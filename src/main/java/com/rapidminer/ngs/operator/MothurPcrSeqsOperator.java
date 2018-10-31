package com.rapidminer.ngs.operator;

import java.util.List;
import com.rapidminer.operator.OperatorDescription;
import com.rapidminer.operator.ports.InputPort;
import com.rapidminer.operator.ports.OutputPort;
import com.rapidminer.operator.OperatorException;
import com.rapidminer.parameter.*;

public class MothurPcrSeqsOperator extends MothurGeneratedOperator {

	private InputPort fastaInPort = getInputPorts().createPort("fasta");
	private InputPort oligosInPort = getInputPorts().createPort("oligos");
	private InputPort nameInPort = getInputPorts().createPort("name");
	private InputPort countInPort = getInputPorts().createPort("count");
	private InputPort groupInPort = getInputPorts().createPort("group");
	private InputPort taxonomyInPort = getInputPorts().createPort("taxonomy");
	private InputPort ecoliInPort = getInputPorts().createPort("ecoli");
	private OutputPort accnosOutPort = getOutputPorts().createPort("accnos");
	private OutputPort countOutPort = getOutputPorts().createPort("count");
	private OutputPort fastaOutPort = getOutputPorts().createPort("fasta");
	private OutputPort groupOutPort = getOutputPorts().createPort("group");
	private OutputPort nameOutPort = getOutputPorts().createPort("name");
	private OutputPort taxonomyOutPort = getOutputPorts().createPort("taxonomy");
	private static final String START_LABEL = "start:";
	private static final String END_LABEL = "end:";
	private static final String[] NOMATCH_CHOICES = { "reject", "keep" };
	private static final int NOMATCH_DEFAULT_CHOICE = 0;
	private static final String NOMATCH_LABEL = "nomatch:";
	private static final String PDIFFS_LABEL = "pdiffs:";
	private static final String RDIFFS_LABEL = "rdiffs:";
	private static final String PROCESSORS_LABEL = "processors:";
	private static final String KEEPPRIMER_LABEL = "keepprimer:";
	private static final String KEEPDOTS_LABEL = "keepdots:";
	private static final String SEED_LABEL = "seed:";
	private static final String INPUTDIR_LABEL = "inputdir:";
	private static final String OUTPUTDIR_LABEL = "outputdir:";

	public MothurPcrSeqsOperator (OperatorDescription description) {
		super(description);
		// NOTE: Auto-generated constructor stub
	}

	@Override
	public void doWork() throws OperatorException {
		super.doWork();
		clearArguments();
		FileNameObject fastaFile = fastaInPort.getData(FileNameObject.class);
		addArgument("fasta",fastaFile.getName());
		FileNameObject oligosFile = oligosInPort.getData(FileNameObject.class);
		addArgument("oligos",oligosFile.getName());
		FileNameObject nameFile = nameInPort.getData(FileNameObject.class);
		addArgument("name",nameFile.getName());
		FileNameObject countFile = countInPort.getData(FileNameObject.class);
		addArgument("count",countFile.getName());
		FileNameObject groupFile = groupInPort.getData(FileNameObject.class);
		addArgument("group",groupFile.getName());
		FileNameObject taxonomyFile = taxonomyInPort.getData(FileNameObject.class);
		addArgument("taxonomy",taxonomyFile.getName());
		FileNameObject ecoliFile = ecoliInPort.getData(FileNameObject.class);
		addArgument("ecoli",ecoliFile.getName());
		int startValue = getParameterAsInt(START_LABEL);
		addArgument("start",String.valueOf(startValue));
		int endValue = getParameterAsInt(END_LABEL);
		addArgument("end",String.valueOf(endValue));
		int nomatchIndex = getParameterAsInt(NOMATCH_LABEL);
		String nomatchValue = NOMATCH_CHOICES[nomatchIndex];
		addArgument("nomatch",String.valueOf(nomatchValue));
		int pdiffsValue = getParameterAsInt(PDIFFS_LABEL);
		addArgument("pdiffs",String.valueOf(pdiffsValue));
		int rdiffsValue = getParameterAsInt(RDIFFS_LABEL);
		addArgument("rdiffs",String.valueOf(rdiffsValue));
		int processorsValue = getParameterAsInt(PROCESSORS_LABEL);
		addArgument("processors",String.valueOf(processorsValue));
		boolean keepprimerValue = getParameterAsBoolean(KEEPPRIMER_LABEL);
		addArgument("keepprimer",String.valueOf(keepprimerValue));
		boolean keepdotsValue = getParameterAsBoolean(KEEPDOTS_LABEL);
		addArgument("keepdots",String.valueOf(keepdotsValue));
		int seedValue = getParameterAsInt(SEED_LABEL);
		addArgument("seed",String.valueOf(seedValue));
		String inputdirValue = getParameterAsString(INPUTDIR_LABEL);
		addArgument("inputdir",String.valueOf(inputdirValue));
		String outputdirValue = getParameterAsString(OUTPUTDIR_LABEL);
		addArgument("outputdir",String.valueOf(outputdirValue));
		executeMothurCommand();
		String fileName="<fileName>"; // TODO: Somehow figure out the fileName
		accnosOutPort.deliver(new FileNameObject(fileName+".accnos","accnos"));
		countOutPort.deliver(new FileNameObject(fileName+".count","count"));
		fastaOutPort.deliver(new FileNameObject(fileName+".fasta","fasta"));
		groupOutPort.deliver(new FileNameObject(fileName+".group","group"));
		nameOutPort.deliver(new FileNameObject(fileName+".name","name"));
		taxonomyOutPort.deliver(new FileNameObject(fileName+".taxonomy","taxonomy"));
	}

	@Override
	public List<ParameterType> getParameterTypes() {
		List<ParameterType> parameterTypes = super.getParameterTypes();
		parameterTypes.add(new ParameterTypeInt(START_LABEL, "TODO: Add description", -100000000, 100000000, -1, true));
		parameterTypes.add(new ParameterTypeInt(END_LABEL, "TODO: Add description", -100000000, 100000000, -1, true));
		parameterTypes.add(new ParameterTypeCategory(NOMATCH_LABEL, "TODO: Add description", NOMATCH_CHOICES, NOMATCH_DEFAULT_CHOICE));
		parameterTypes.add(new ParameterTypeInt(PDIFFS_LABEL, "TODO: Add description", -100000000, 100000000, 0, true));
		parameterTypes.add(new ParameterTypeInt(RDIFFS_LABEL, "TODO: Add description", -100000000, 100000000, 0, true));
		parameterTypes.add(new ParameterTypeInt(PROCESSORS_LABEL, "TODO: Add description", -100000000, 100000000, 1, true));
		parameterTypes.add(new ParameterTypeBoolean(KEEPPRIMER_LABEL, "TODO: Add description", false, true));
		parameterTypes.add(new ParameterTypeBoolean(KEEPDOTS_LABEL, "TODO: Add description", true, true));
		parameterTypes.add(new ParameterTypeInt(SEED_LABEL, "TODO: Add description", -100000000, 100000000, 0, true));
		parameterTypes.add(new ParameterTypeString(INPUTDIR_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeString(OUTPUTDIR_LABEL, "TODO: Add description", "", true));
		return parameterTypes;
	}

	@Override
	public String getOutputPattern(String type) {
		if (type.equals("accnos")) return "[filename],bad.accnos";
		if (type.equals("name")) return "[filename],pcr,[extension]";
		if (type.equals("fasta")) return "[filename],pcr,[extension]-[filename],[tag],pcr,[extension]";
		if (type.equals("taxonomy")) return "[filename],pcr,[extension]";
		if (type.equals("group")) return "[filename],pcr,[extension]";
		if (type.equals("count")) return "[filename],pcr,[extension]";
		return super.getOutputPattern(type);
	}
}
