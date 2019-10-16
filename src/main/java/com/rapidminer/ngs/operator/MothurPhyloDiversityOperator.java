package com.rapidminer.ngs.operator;

import java.util.List;
import com.rapidminer.operator.OperatorDescription;
import com.rapidminer.operator.ports.InputPort;
import com.rapidminer.operator.ports.OutputPort;
import com.rapidminer.operator.OperatorException;
import com.rapidminer.parameter.*;

public class MothurPhyloDiversityOperator extends MothurGeneratedOperator {

	private InputPort treeInPort = getInputPorts().createPort("tree");
	private InputPort nameInPort = getInputPorts().createPort("name");
	private InputPort countInPort = getInputPorts().createPort("count");
	private InputPort groupInPort = getInputPorts().createPort("group");
	private OutputPort phylodivOutPort = getOutputPorts().createPort("phylodiv");
	private OutputPort rarefyOutPort = getOutputPorts().createPort("rarefy");
	private OutputPort summaryOutPort = getOutputPorts().createPort("summary");
	private static final String GROUPS_LABEL = "groups:";
	private static final String ITERS_LABEL = "iters:";
	private static final String FREQ_LABEL = "freq:";
	private static final String PROCESSORS_LABEL = "processors:";
	private static final String RAREFY_LABEL = "rarefy:";
	private static final String SAMPLEDEPTH_LABEL = "sampledepth:";
	private static final String SUMMARY_LABEL = "summary:";
	private static final String COLLECT_LABEL = "collect:";
	private static final String SCALE_LABEL = "scale:";
	private static final String SEED_LABEL = "seed:";
	private static final String INPUTDIR_LABEL = "inputdir:";
	private static final String OUTPUTDIR_LABEL = "outputdir:";

	public MothurPhyloDiversityOperator (OperatorDescription description) {
		super(description);
		// NOTE: Auto-generated constructor stub
	}

	@Override
	public void doWork() throws OperatorException {
		super.doWork();
		clearArguments();
		FileNameObject treeFile = treeInPort.getData(FileNameObject.class);
		addArgument("tree",treeFile.getName());
		FileNameObject nameFile = nameInPort.getData(FileNameObject.class);
		addArgument("name",nameFile.getName());
		FileNameObject countFile = countInPort.getData(FileNameObject.class);
		addArgument("count",countFile.getName());
		FileNameObject groupFile = groupInPort.getData(FileNameObject.class);
		addArgument("group",groupFile.getName());
		String groupsValue = getParameterAsString(GROUPS_LABEL);
		addArgument("groups",String.valueOf(groupsValue));
		int itersValue = getParameterAsInt(ITERS_LABEL);
		addArgument("iters",String.valueOf(itersValue));
		int freqValue = getParameterAsInt(FREQ_LABEL);
		addArgument("freq",String.valueOf(freqValue));
		int processorsValue = getParameterAsInt(PROCESSORS_LABEL);
		addArgument("processors",String.valueOf(processorsValue));
		boolean rarefyValue = getParameterAsBoolean(RAREFY_LABEL);
		addArgument("rarefy",String.valueOf(rarefyValue));
		int sampledepthValue = getParameterAsInt(SAMPLEDEPTH_LABEL);
		addArgument("sampledepth",String.valueOf(sampledepthValue));
		boolean summaryValue = getParameterAsBoolean(SUMMARY_LABEL);
		addArgument("summary",String.valueOf(summaryValue));
		boolean collectValue = getParameterAsBoolean(COLLECT_LABEL);
		addArgument("collect",String.valueOf(collectValue));
		boolean scaleValue = getParameterAsBoolean(SCALE_LABEL);
		addArgument("scale",String.valueOf(scaleValue));
		int seedValue = getParameterAsInt(SEED_LABEL);
		addArgument("seed",String.valueOf(seedValue));
		String inputdirValue = getParameterAsString(INPUTDIR_LABEL);
		addArgument("inputdir",String.valueOf(inputdirValue));
		String outputdirValue = getParameterAsString(OUTPUTDIR_LABEL);
		addArgument("outputdir",String.valueOf(outputdirValue));
		executeMothurCommand();
		String fileName="<fileName>"; // TODO: Somehow figure out the fileName
		phylodivOutPort.deliver(new FileNameObject(fileName+".phylodiv","phylodiv"));
		rarefyOutPort.deliver(new FileNameObject(fileName+".rarefy","rarefy"));
		summaryOutPort.deliver(new FileNameObject(fileName+".summary","summary"));
	}

	@Override
	public List<ParameterType> getParameterTypes() {
		List<ParameterType> parameterTypes = super.getParameterTypes();
		parameterTypes.add(new ParameterTypeString(GROUPS_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeInt(ITERS_LABEL, "TODO: Add description", -100000000, 100000000, 1000, true));
		parameterTypes.add(new ParameterTypeInt(FREQ_LABEL, "TODO: Add description", -100000000, 100000000, 100, true));
		parameterTypes.add(new ParameterTypeInt(PROCESSORS_LABEL, "TODO: Add description", -100000000, 100000000, 1, true));
		parameterTypes.add(new ParameterTypeBoolean(RAREFY_LABEL, "TODO: Add description", false, true));
		parameterTypes.add(new ParameterTypeInt(SAMPLEDEPTH_LABEL, "TODO: Add description", -100000000, 100000000, 0, true));
		parameterTypes.add(new ParameterTypeBoolean(SUMMARY_LABEL, "TODO: Add description", true, true));
		parameterTypes.add(new ParameterTypeBoolean(COLLECT_LABEL, "TODO: Add description", false, true));
		parameterTypes.add(new ParameterTypeBoolean(SCALE_LABEL, "TODO: Add description", false, true));
		parameterTypes.add(new ParameterTypeInt(SEED_LABEL, "TODO: Add description", -100000000, 100000000, 0, true));
		parameterTypes.add(new ParameterTypeString(INPUTDIR_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeString(OUTPUTDIR_LABEL, "TODO: Add description", "", true));
		return parameterTypes;
	}

	@Override
	public String getOutputPattern(String type) {
		if (type.equals("rarefy")) return "[filename],[tag],phylodiv.rarefaction";
		if (type.equals("summary")) return "[filename],[tag],phylodiv.summary";
		if (type.equals("phylodiv")) return "[filename],[tag],phylodiv";
		return super.getOutputPattern(type);
	}
}
