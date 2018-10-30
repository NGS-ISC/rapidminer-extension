package com.rapidminer.ngs.operator;

import java.util.List;
import com.rapidminer.operator.OperatorDescription;
import com.rapidminer.operator.ports.InputPort;
import com.rapidminer.operator.ports.OutputPort;
import com.rapidminer.operator.OperatorException;
import com.rapidminer.parameter.*;

public class MothurChimeraVsearchOperator extends MothurGeneratedOperator {

	private InputPort countInPort = getInputPorts().createPort("count");
	private InputPort fastaInPort = getInputPorts().createPort("fasta");
	private InputPort groupInPort = getInputPorts().createPort("group");
	private InputPort nameInPort = getInputPorts().createPort("name");
	private InputPort referenceInPort = getInputPorts().createPort("reference");
	private OutputPort alnsOutPort = getOutputPorts().createPort("alns");
	private OutputPort chimeraOutPort = getOutputPorts().createPort("chimera");
	private OutputPort accnosOutPort = getOutputPorts().createPort("accnos");
	private OutputPort countOutPort = getOutputPorts().createPort("count");
	private static final String ABSKEW_LABEL = "abskew:";
	private static final String DEREPLICATE_LABEL = "dereplicate:";
	private static final String DN_LABEL = "dn:";
	private static final String INPUTDIR_LABEL = "inputdir:";
	private static final String MINDIFFS_LABEL = "mindiffs:";
	private static final String MINDIV_LABEL = "mindiv:";
	private static final String MINH_LABEL = "minh:";
	private static final String OUTPUTDIR_LABEL = "outputdir:";
	private static final String PROCESSORS_LABEL = "processors:";
	private static final String SEED_LABEL = "seed:";
	private static final String UCHIMEALNS_LABEL = "uchimealns:";
	private static final String XN_LABEL = "xn:";

	public MothurChimeraVsearchOperator (OperatorDescription description) {
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
		FileNameObject groupFile = groupInPort.getData(FileNameObject.class);
		addArgument("group",groupFile.getName());
		FileNameObject nameFile = nameInPort.getData(FileNameObject.class);
		addArgument("name",nameFile.getName());
		FileNameObject referenceFile = referenceInPort.getData(FileNameObject.class);
		addArgument("reference",referenceFile.getName());
		int abskewValue = getParameterAsInt(ABSKEW_LABEL);
		addArgument("abskew",String.valueOf(abskewValue));
		boolean dereplicateValue = getParameterAsBoolean(DEREPLICATE_LABEL);
		addArgument("dereplicate",String.valueOf(dereplicateValue));
		int dnValue = getParameterAsInt(DN_LABEL);
		addArgument("dn",String.valueOf(dnValue));
		String inputdirValue = getParameterAsString(INPUTDIR_LABEL);
		addArgument("inputdir",String.valueOf(inputdirValue));
		int mindiffsValue = getParameterAsInt(MINDIFFS_LABEL);
		addArgument("mindiffs",String.valueOf(mindiffsValue));
		int mindivValue = getParameterAsInt(MINDIV_LABEL);
		addArgument("mindiv",String.valueOf(mindivValue));
		int minhValue = getParameterAsInt(MINH_LABEL);
		addArgument("minh",String.valueOf(minhValue));
		String outputdirValue = getParameterAsString(OUTPUTDIR_LABEL);
		addArgument("outputdir",String.valueOf(outputdirValue));
		int processorsValue = getParameterAsInt(PROCESSORS_LABEL);
		addArgument("processors",String.valueOf(processorsValue));
		int seedValue = getParameterAsInt(SEED_LABEL);
		addArgument("seed",String.valueOf(seedValue));
		boolean uchimealnsValue = getParameterAsBoolean(UCHIMEALNS_LABEL);
		addArgument("uchimealns",String.valueOf(uchimealnsValue));
		int xnValue = getParameterAsInt(XN_LABEL);
		addArgument("xn",String.valueOf(xnValue));
		executeMothurCommand();
		String fileName="<fileName>"; // TODO: Somehow figure out the fileName
		alnsOutPort.deliver(new FileNameObject(fileName+".alns","alns"));
		chimeraOutPort.deliver(new FileNameObject(fileName+".chimera","chimera"));
		accnosOutPort.deliver(new FileNameObject(fileName+".accnos","accnos"));
		countOutPort.deliver(new FileNameObject(fileName+".count","count"));
	}

	@Override
	public List<ParameterType> getParameterTypes() {
		List<ParameterType> parameterTypes = super.getParameterTypes();
		parameterTypes.add(new ParameterTypeDouble(ABSKEW_LABEL, "TODO: Add description", -100000000, 100000000, 1.9, true));
		parameterTypes.add(new ParameterTypeBoolean(DEREPLICATE_LABEL, "TODO: Add description", false, true));
		parameterTypes.add(new ParameterTypeDouble(DN_LABEL, "TODO: Add description", -100000000, 100000000, 1.4, true));
		parameterTypes.add(new ParameterTypeString(INPUTDIR_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeInt(MINDIFFS_LABEL, "TODO: Add description", -100000000, 100000000, 3, true));
		parameterTypes.add(new ParameterTypeDouble(MINDIV_LABEL, "TODO: Add description", -100000000, 100000000, 0.8, true));
		parameterTypes.add(new ParameterTypeDouble(MINH_LABEL, "TODO: Add description", -100000000, 100000000, 0.28, true));
		parameterTypes.add(new ParameterTypeString(OUTPUTDIR_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeInt(PROCESSORS_LABEL, "TODO: Add description", -100000000, 100000000, 1, true));
		parameterTypes.add(new ParameterTypeInt(SEED_LABEL, "TODO: Add description", -100000000, 100000000, 0, true));
		parameterTypes.add(new ParameterTypeBoolean(UCHIMEALNS_LABEL, "TODO: Add description", false, true));
		parameterTypes.add(new ParameterTypeDouble(XN_LABEL, "TODO: Add description", -100000000, 100000000, 8.0, true));
		return parameterTypes;
	}

	@Override
	public String getOutputPattern(String type) {
		// TODO Use a dictionary to reflect type to pattern
		if (type=="alns") return "[filename],[tag],vsearch.alns";
		if (type=="chimera") return "[filename],[tag],vsearch.chimeras";
		if (type=="accnos") return "[filename],[tag],vsearch.accnos";
		if (type=="count") return "[filename],[tag],vsearch.pick.count_table";
		// TODO if nil then 
		return super.getOutputPattern(type);
	}
}
