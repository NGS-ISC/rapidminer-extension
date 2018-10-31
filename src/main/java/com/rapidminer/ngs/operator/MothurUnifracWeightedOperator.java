package com.rapidminer.ngs.operator;

import java.util.List;
import com.rapidminer.operator.OperatorDescription;
import com.rapidminer.operator.ports.InputPort;
import com.rapidminer.operator.ports.OutputPort;
import com.rapidminer.operator.OperatorException;
import com.rapidminer.parameter.*;

public class MothurUnifracWeightedOperator extends MothurGeneratedOperator {

	private InputPort treeInPort = getInputPorts().createPort("tree");
	private InputPort nameInPort = getInputPorts().createPort("name");
	private InputPort countInPort = getInputPorts().createPort("count");
	private InputPort groupInPort = getInputPorts().createPort("group");
	private OutputPort wsummaryOutPort = getOutputPorts().createPort("wsummary");
	private OutputPort columnOutPort = getOutputPorts().createPort("column");
	private OutputPort treeOutPort = getOutputPorts().createPort("tree");
	private OutputPort phylipOutPort = getOutputPorts().createPort("phylip");
	private OutputPort weightedOutPort = getOutputPorts().createPort("weighted");
	private static final String GROUPS_LABEL = "groups:";
	private static final String ITERS_LABEL = "iters:";
	private static final String PROCESSORS_LABEL = "processors:";
	private static final String SUBSAMPLE_LABEL = "subsample:";
	private static final String CONSENSUS_LABEL = "consensus:";
	private static final String RANDOM_LABEL = "random:";
	private static final String[] DISTANCE_CHOICES = { "column", "lt", "square", "phylip" };
	private static final int DISTANCE_DEFAULT_CHOICE = 0;
	private static final String DISTANCE_LABEL = "distance:";
	private static final String ROOT_LABEL = "root:";
	private static final String SEED_LABEL = "seed:";
	private static final String INPUTDIR_LABEL = "inputdir:";
	private static final String OUTPUTDIR_LABEL = "outputdir:";

	public MothurUnifracWeightedOperator (OperatorDescription description) {
		super(description);
		// TODO Auto-generated constructor stub
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
		int processorsValue = getParameterAsInt(PROCESSORS_LABEL);
		addArgument("processors",String.valueOf(processorsValue));
		String subsampleValue = getParameterAsString(SUBSAMPLE_LABEL);
		addArgument("subsample",String.valueOf(subsampleValue));
		boolean consensusValue = getParameterAsBoolean(CONSENSUS_LABEL);
		addArgument("consensus",String.valueOf(consensusValue));
		boolean randomValue = getParameterAsBoolean(RANDOM_LABEL);
		addArgument("random",String.valueOf(randomValue));
		int distanceIndex = getParameterAsInt(DISTANCE_LABEL);
		String distanceValue = DISTANCE_CHOICES[distanceIndex];
		addArgument("distance",String.valueOf(distanceValue));
		boolean rootValue = getParameterAsBoolean(ROOT_LABEL);
		addArgument("root",String.valueOf(rootValue));
		int seedValue = getParameterAsInt(SEED_LABEL);
		addArgument("seed",String.valueOf(seedValue));
		String inputdirValue = getParameterAsString(INPUTDIR_LABEL);
		addArgument("inputdir",String.valueOf(inputdirValue));
		String outputdirValue = getParameterAsString(OUTPUTDIR_LABEL);
		addArgument("outputdir",String.valueOf(outputdirValue));
		executeMothurCommand();
		String fileName="<fileName>"; // TODO: Somehow figure out the fileName
		wsummaryOutPort.deliver(new FileNameObject(fileName+".wsummary","wsummary"));
		columnOutPort.deliver(new FileNameObject(fileName+".column","column"));
		treeOutPort.deliver(new FileNameObject(fileName+".tree","tree"));
		phylipOutPort.deliver(new FileNameObject(fileName+".phylip","phylip"));
		weightedOutPort.deliver(new FileNameObject(fileName+".weighted","weighted"));
	}

	@Override
	public List<ParameterType> getParameterTypes() {
		List<ParameterType> parameterTypes = super.getParameterTypes();
		parameterTypes.add(new ParameterTypeString(GROUPS_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeInt(ITERS_LABEL, "TODO: Add description", -100000000, 100000000, 1000, true));
		parameterTypes.add(new ParameterTypeInt(PROCESSORS_LABEL, "TODO: Add description", -100000000, 100000000, 1, true));
		parameterTypes.add(new ParameterTypeString(SUBSAMPLE_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeBoolean(CONSENSUS_LABEL, "TODO: Add description", false, true));
		parameterTypes.add(new ParameterTypeBoolean(RANDOM_LABEL, "TODO: Add description", false, true));
		parameterTypes.add(new ParameterTypeCategory(DISTANCE_LABEL, "TODO: Add description", DISTANCE_CHOICES, DISTANCE_DEFAULT_CHOICE));
		parameterTypes.add(new ParameterTypeBoolean(ROOT_LABEL, "TODO: Add description", false, true));
		parameterTypes.add(new ParameterTypeInt(SEED_LABEL, "TODO: Add description", -100000000, 100000000, 0, true));
		parameterTypes.add(new ParameterTypeString(INPUTDIR_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeString(OUTPUTDIR_LABEL, "TODO: Add description", "", true));
		return parameterTypes;
	}

	@Override
	public String getOutputPattern(String type) {
		// TODO Use a dictionary to reflect type to pattern
		if (type.equals("wsummary")) return "[filename],[tag],wsummary";
		if (type.equals("column")) return "[filename],[tag],[tag2],dist";
		if (type.equals("tree")) return "[filename],[tag],[tag2],tre";
		if (type.equals("phylip")) return "[filename],[tag],[tag2],dist";
		if (type.equals("weighted")) return "[filename],weighted-[filename],[tag],weighted";
		// TODO if nil then 
		return super.getOutputPattern(type);
	}
}
