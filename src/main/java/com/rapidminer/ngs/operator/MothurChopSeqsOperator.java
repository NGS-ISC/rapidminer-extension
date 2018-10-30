package com.rapidminer.ngs.operator;

import java.util.List;
import com.rapidminer.operator.OperatorDescription;
import com.rapidminer.operator.ports.InputPort;
import com.rapidminer.operator.ports.OutputPort;
import com.rapidminer.operator.OperatorException;
import com.rapidminer.parameter.*;

public class MothurChopSeqsOperator extends MothurGeneratedOperator {

	private InputPort countInPort = getInputPorts().createPort("count");
	private InputPort fastaInPort = getInputPorts().createPort("fasta");
	private InputPort groupInPort = getInputPorts().createPort("group");
	private InputPort nameInPort = getInputPorts().createPort("name");
	private InputPort qfileInPort = getInputPorts().createPort("qfile");
	private OutputPort groupOutPort = getOutputPorts().createPort("group");
	private OutputPort fastaOutPort = getOutputPorts().createPort("fasta");
	private OutputPort nameOutPort = getOutputPorts().createPort("name");
	private OutputPort accnosOutPort = getOutputPorts().createPort("accnos");
	private OutputPort qfileOutPort = getOutputPorts().createPort("qfile");
	private OutputPort countOutPort = getOutputPorts().createPort("count");
	private static final String COUNTGAPS_LABEL = "countgaps:";
	private static final String INPUTDIR_LABEL = "inputdir:";
	public static final String[] KEEP_CHOICES = { "back", "front" };
	public static final int KEEP_DEFAULT_CHOICE = 1;
	private static final String KEEP_LABEL = "keep:";
	private static final String KEEPN_LABEL = "keepn:";
	private static final String NUMBASES_LABEL = "numbases:";
	private static final String OUTPUTDIR_LABEL = "outputdir:";
	private static final String PROCESSORS_LABEL = "processors:";
	private static final String SEED_LABEL = "seed:";
	private static final String SHORT_LABEL = "short:";

	public MothurChopSeqsOperator (OperatorDescription description) {
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
		FileNameObject qfileFile = qfileInPort.getData(FileNameObject.class);
		addArgument("qfile",qfileFile.getName());
		boolean countgapsValue = getParameterAsBoolean(COUNTGAPS_LABEL);
		addArgument("countgaps",String.valueOf(countgapsValue));
		String inputdirValue = getParameterAsString(INPUTDIR_LABEL);
		addArgument("inputdir",String.valueOf(inputdirValue));
		int keepIndex = getParameterAsInt(KEEP_LABEL);
		String keepValue = KEEP_CHOICES[keepIndex];
		addArgument("keep",String.valueOf(keepValue));
		boolean keepnValue = getParameterAsBoolean(KEEPN_LABEL);
		addArgument("keepn",String.valueOf(keepnValue));
		int numbasesValue = getParameterAsInt(NUMBASES_LABEL);
		addArgument("numbases",String.valueOf(numbasesValue));
		String outputdirValue = getParameterAsString(OUTPUTDIR_LABEL);
		addArgument("outputdir",String.valueOf(outputdirValue));
		int processorsValue = getParameterAsInt(PROCESSORS_LABEL);
		addArgument("processors",String.valueOf(processorsValue));
		int seedValue = getParameterAsInt(SEED_LABEL);
		addArgument("seed",String.valueOf(seedValue));
		boolean shortValue = getParameterAsBoolean(SHORT_LABEL);
		addArgument("short",String.valueOf(shortValue));
		executeMothurCommand();
		String fileName="<fileName>"; // TODO: Somehow figure out the fileName
		groupOutPort.deliver(new FileNameObject(fileName+".group","group"));
		fastaOutPort.deliver(new FileNameObject(fileName+".fasta","fasta"));
		nameOutPort.deliver(new FileNameObject(fileName+".name","name"));
		accnosOutPort.deliver(new FileNameObject(fileName+".accnos","accnos"));
		qfileOutPort.deliver(new FileNameObject(fileName+".qfile","qfile"));
		countOutPort.deliver(new FileNameObject(fileName+".count","count"));
	}

	@Override
	public List<ParameterType> getParameterTypes() {
		List<ParameterType> parameterTypes = super.getParameterTypes();
		parameterTypes.add(new ParameterTypeBoolean(COUNTGAPS_LABEL, "TODO: Add description", false, true));
		parameterTypes.add(new ParameterTypeString(INPUTDIR_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeCategory(KEEP_LABEL, "TODO: Add description", KEEP_CHOICES, KEEP_DEFAULT_CHOICE));
		parameterTypes.add(new ParameterTypeBoolean(KEEPN_LABEL, "TODO: Add description", false, true));
		parameterTypes.add(new ParameterTypeInt(NUMBASES_LABEL, "TODO: Add description", -100000000, 100000000, 0, false));
		parameterTypes.add(new ParameterTypeString(OUTPUTDIR_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeInt(PROCESSORS_LABEL, "TODO: Add description", -100000000, 100000000, 1, true));
		parameterTypes.add(new ParameterTypeInt(SEED_LABEL, "TODO: Add description", -100000000, 100000000, 0, true));
		parameterTypes.add(new ParameterTypeBoolean(SHORT_LABEL, "TODO: Add description", false, true));
		return parameterTypes;
	}

	@Override
	public String getOutputPattern(String type) {
		// TODO Use a dictionary to reflect type to pattern
		if (type=="group") return "[filename],chop.groups";
		if (type=="fasta") return "[filename],chop.fasta";
		if (type=="name") return "[filename],chop.names";
		if (type=="accnos") return "[filename],chop.accnos";
		if (type=="qfile") return "[filename],chop.qual";
		if (type=="count") return "[filename],chop.count_table";
		// TODO if nil then 
		return super.getOutputPattern(type);
	}
}
