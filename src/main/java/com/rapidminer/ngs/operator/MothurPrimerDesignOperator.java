package com.rapidminer.ngs.operator;

import java.util.List;
import com.rapidminer.operator.OperatorDescription;
import com.rapidminer.operator.ports.InputPort;
import com.rapidminer.operator.ports.OutputPort;
import com.rapidminer.operator.OperatorException;
import com.rapidminer.parameter.*;

public class MothurPrimerDesignOperator extends MothurGeneratedOperator {

	private InputPort countInPort = getInputPorts().createPort("count");
	private InputPort fastaInPort = getInputPorts().createPort("fasta");
	private InputPort listInPort = getInputPorts().createPort("list");
	private InputPort nameInPort = getInputPorts().createPort("name");
	private OutputPort summaryOutPort = getOutputPorts().createPort("summary");
	private OutputPort fastaOutPort = getOutputPorts().createPort("fasta");
	private OutputPort listOutPort = getOutputPorts().createPort("list");
	private static final String CUTOFF_LABEL = "cutoff:";
	private static final String INPUTDIR_LABEL = "inputdir:";
	private static final String LABEL_LABEL = "label:";
	private static final String LENGTH_LABEL = "length:";
	private static final String MAXTM_LABEL = "maxtm:";
	private static final String MINTM_LABEL = "mintm:";
	private static final String OTULABEL_LABEL = "otulabel:";
	private static final String OUTPUTDIR_LABEL = "outputdir:";
	private static final String PDIFFS_LABEL = "pdiffs:";
	private static final String PROCESSORS_LABEL = "processors:";
	private static final String SEED_LABEL = "seed:";

	public MothurPrimerDesignOperator (OperatorDescription description) {
		super(description);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void doWork() throws OperatorException {
		super.doWork();
		clearArguments();
		FileNameObject countFile = countInPort.getData(FileNameObject.class);
		addArgument("count",countFile.getName());
		FileNameObject fastaFile = fastaInPort.getData(FileNameObject.class);
		addArgument("fasta",fastaFile.getName());
		FileNameObject listFile = listInPort.getData(FileNameObject.class);
		addArgument("list",listFile.getName());
		FileNameObject nameFile = nameInPort.getData(FileNameObject.class);
		addArgument("name",nameFile.getName());
		int cutoffValue = getParameterAsInt(CUTOFF_LABEL);
		addArgument("cutoff",String.valueOf(cutoffValue));
		String inputdirValue = getParameterAsString(INPUTDIR_LABEL);
		addArgument("inputdir",String.valueOf(inputdirValue));
		String labelValue = getParameterAsString(LABEL_LABEL);
		addArgument("label",String.valueOf(labelValue));
		int lengthValue = getParameterAsInt(LENGTH_LABEL);
		addArgument("length",String.valueOf(lengthValue));
		int maxtmValue = getParameterAsInt(MAXTM_LABEL);
		addArgument("maxtm",String.valueOf(maxtmValue));
		int mintmValue = getParameterAsInt(MINTM_LABEL);
		addArgument("mintm",String.valueOf(mintmValue));
		String otulabelValue = getParameterAsString(OTULABEL_LABEL);
		addArgument("otulabel",String.valueOf(otulabelValue));
		String outputdirValue = getParameterAsString(OUTPUTDIR_LABEL);
		addArgument("outputdir",String.valueOf(outputdirValue));
		int pdiffsValue = getParameterAsInt(PDIFFS_LABEL);
		addArgument("pdiffs",String.valueOf(pdiffsValue));
		int processorsValue = getParameterAsInt(PROCESSORS_LABEL);
		addArgument("processors",String.valueOf(processorsValue));
		int seedValue = getParameterAsInt(SEED_LABEL);
		addArgument("seed",String.valueOf(seedValue));
		executeMothurCommand();
		String fileName="<fileName>"; // TODO: Somehow figure out the fileName
		summaryOutPort.deliver(new FileNameObject(fileName+".summary","summary"));
		fastaOutPort.deliver(new FileNameObject(fileName+".fasta","fasta"));
		listOutPort.deliver(new FileNameObject(fileName+".list","list"));
	}

	@Override
	public List<ParameterType> getParameterTypes() {
		List<ParameterType> parameterTypes = super.getParameterTypes();
		parameterTypes.add(new ParameterTypeInt(CUTOFF_LABEL, "TODO: Add description", -100000000, 100000000, 100, true));
		parameterTypes.add(new ParameterTypeString(INPUTDIR_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeString(LABEL_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeInt(LENGTH_LABEL, "TODO: Add description", -100000000, 100000000, 18, true));
		parameterTypes.add(new ParameterTypeInt(MAXTM_LABEL, "TODO: Add description", -100000000, 100000000, -1, true));
		parameterTypes.add(new ParameterTypeInt(MINTM_LABEL, "TODO: Add description", -100000000, 100000000, -1, true));
		parameterTypes.add(new ParameterTypeString(OTULABEL_LABEL, "TODO: Add description", "", false));
		parameterTypes.add(new ParameterTypeString(OUTPUTDIR_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeInt(PDIFFS_LABEL, "TODO: Add description", -100000000, 100000000, 0, true));
		parameterTypes.add(new ParameterTypeInt(PROCESSORS_LABEL, "TODO: Add description", -100000000, 100000000, 1, true));
		parameterTypes.add(new ParameterTypeInt(SEED_LABEL, "TODO: Add description", -100000000, 100000000, 0, true));
		return parameterTypes;
	}

	@Override
	public String getOutputPattern(String type) {
		// TODO Use a dictionary to reflect type to pattern
		if (type=="summary") return "[filename],[distance],primer.summary";
		if (type=="fasta") return "[filename],[distance],otu.cons.fasta";
		if (type=="list") return "[filename],pick,[extension]";
		// TODO if nil then 
		return super.getOutputPattern(type);
	}
}
