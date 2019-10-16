package com.rapidminer.ngs.operator;

import java.util.List;
import com.rapidminer.operator.OperatorDescription;
import com.rapidminer.operator.ports.InputPort;
import com.rapidminer.operator.ports.OutputPort;
import com.rapidminer.operator.OperatorException;
import com.rapidminer.parameter.*;

public class MothurChopSeqsOperator extends MothurGeneratedOperator {

	private InputPort fastaInPort = getInputPorts().createPort("fasta");
	private InputPort qfileInPort = getInputPorts().createPort("qfile");
	private InputPort nameInPort = getInputPorts().createPort("name");
	private InputPort countInPort = getInputPorts().createPort("count");
	private InputPort groupInPort = getInputPorts().createPort("group");
	private OutputPort accnosOutPort = getOutputPorts().createPort("accnos");
	private OutputPort countOutPort = getOutputPorts().createPort("count");
	private OutputPort fastaOutPort = getOutputPorts().createPort("fasta");
	private OutputPort groupOutPort = getOutputPorts().createPort("group");
	private OutputPort nameOutPort = getOutputPorts().createPort("name");
	private OutputPort qfileOutPort = getOutputPorts().createPort("qfile");
	private static final String PROCESSORS_LABEL = "processors:";
	private static final String NUMBASES_LABEL = "numbases:";
	private static final String COUNTGAPS_LABEL = "countgaps:";
	private static final String SHORT_LABEL = "short:";
	private static final String[] KEEP_CHOICES = { "front", "back" };
	private static final int KEEP_DEFAULT_CHOICE = 0;
	private static final String KEEP_LABEL = "keep:";
	private static final String KEEPN_LABEL = "keepn:";
	private static final String SEED_LABEL = "seed:";
	private static final String INPUTDIR_LABEL = "inputdir:";
	private static final String OUTPUTDIR_LABEL = "outputdir:";

	public MothurChopSeqsOperator (OperatorDescription description) {
		super(description);
		// NOTE: Auto-generated constructor stub
	}

	@Override
	public void doWork() throws OperatorException {
		super.doWork();
		clearArguments();
		FileNameObject fastaFile = fastaInPort.getData(FileNameObject.class);
		addArgument("fasta",fastaFile.getName());
		FileNameObject qfileFile = qfileInPort.getData(FileNameObject.class);
		addArgument("qfile",qfileFile.getName());
		FileNameObject nameFile = nameInPort.getData(FileNameObject.class);
		addArgument("name",nameFile.getName());
		FileNameObject countFile = countInPort.getData(FileNameObject.class);
		addArgument("count",countFile.getName());
		FileNameObject groupFile = groupInPort.getData(FileNameObject.class);
		addArgument("group",groupFile.getName());
		int processorsValue = getParameterAsInt(PROCESSORS_LABEL);
		addArgument("processors",String.valueOf(processorsValue));
		int numbasesValue = getParameterAsInt(NUMBASES_LABEL);
		addArgument("numbases",String.valueOf(numbasesValue));
		boolean countgapsValue = getParameterAsBoolean(COUNTGAPS_LABEL);
		addArgument("countgaps",String.valueOf(countgapsValue));
		boolean shortValue = getParameterAsBoolean(SHORT_LABEL);
		addArgument("short",String.valueOf(shortValue));
		int keepIndex = getParameterAsInt(KEEP_LABEL);
		String keepValue = KEEP_CHOICES[keepIndex];
		addArgument("keep",String.valueOf(keepValue));
		boolean keepnValue = getParameterAsBoolean(KEEPN_LABEL);
		addArgument("keepn",String.valueOf(keepnValue));
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
		qfileOutPort.deliver(new FileNameObject(fileName+".qfile","qfile"));
	}

	@Override
	public List<ParameterType> getParameterTypes() {
		List<ParameterType> parameterTypes = super.getParameterTypes();
		parameterTypes.add(new ParameterTypeInt(PROCESSORS_LABEL, "TODO: Add description", -100000000, 100000000, 1, true));
		parameterTypes.add(new ParameterTypeInt(NUMBASES_LABEL, "TODO: Add description", -100000000, 100000000, 0, false));
		parameterTypes.add(new ParameterTypeBoolean(COUNTGAPS_LABEL, "TODO: Add description", false, true));
		parameterTypes.add(new ParameterTypeBoolean(SHORT_LABEL, "TODO: Add description", false, true));
		parameterTypes.add(new ParameterTypeCategory(KEEP_LABEL, "TODO: Add description", KEEP_CHOICES, KEEP_DEFAULT_CHOICE));
		parameterTypes.add(new ParameterTypeBoolean(KEEPN_LABEL, "TODO: Add description", false, true));
		parameterTypes.add(new ParameterTypeInt(SEED_LABEL, "TODO: Add description", -100000000, 100000000, 0, true));
		parameterTypes.add(new ParameterTypeString(INPUTDIR_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeString(OUTPUTDIR_LABEL, "TODO: Add description", "", true));
		return parameterTypes;
	}

	@Override
	public String getOutputPattern(String type) {
		if (type.equals("group")) return "[filename],chop.groups";
		if (type.equals("fasta")) return "[filename],chop.fasta";
		if (type.equals("qfile")) return "[filename],chop.qual";
		if (type.equals("name")) return "[filename],chop.names";
		if (type.equals("accnos")) return "[filename],chop.accnos";
		if (type.equals("count")) return "[filename],chop.count_table";
		return super.getOutputPattern(type);
	}
}
