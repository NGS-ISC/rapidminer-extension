package com.rapidminer.ngs.operator;

import java.util.List;
import com.rapidminer.operator.OperatorDescription;
import com.rapidminer.operator.ports.InputPort;
import com.rapidminer.operator.ports.OutputPort;
import com.rapidminer.operator.OperatorException;
import com.rapidminer.parameter.*;

public class MothurMakeSharedOperator extends MothurGeneratedOperator {

	private InputPort biomInPort = getInputPorts().createPort("biom");
	private InputPort listInPort = getInputPorts().createPort("list");
	private InputPort countInPort = getInputPorts().createPort("count");
	private InputPort groupInPort = getInputPorts().createPort("group");
	private OutputPort mapOutPort = getOutputPorts().createPort("map");
	private OutputPort sharedOutPort = getOutputPorts().createPort("shared");
	private OutputPort groupOutPort = getOutputPorts().createPort("group");
	private static final String LABEL_LABEL = "label:";
	private static final String GROUPS_LABEL = "groups:";
	private static final String SEED_LABEL = "seed:";
	private static final String INPUTDIR_LABEL = "inputdir:";
	private static final String OUTPUTDIR_LABEL = "outputdir:";

	public MothurMakeSharedOperator (OperatorDescription description) {
		super(description);
		// NOTE: Auto-generated constructor stub
	}

	@Override
	public void doWork() throws OperatorException {
		super.doWork();
		clearArguments();
		FileNameObject biomFile = biomInPort.getData(FileNameObject.class);
		addArgument("biom",biomFile.getName());
		FileNameObject listFile = listInPort.getData(FileNameObject.class);
		addArgument("list",listFile.getName());
		FileNameObject countFile = countInPort.getData(FileNameObject.class);
		addArgument("count",countFile.getName());
		FileNameObject groupFile = groupInPort.getData(FileNameObject.class);
		addArgument("group",groupFile.getName());
		String labelValue = getParameterAsString(LABEL_LABEL);
		addArgument("label",String.valueOf(labelValue));
		String groupsValue = getParameterAsString(GROUPS_LABEL);
		addArgument("groups",String.valueOf(groupsValue));
		int seedValue = getParameterAsInt(SEED_LABEL);
		addArgument("seed",String.valueOf(seedValue));
		String inputdirValue = getParameterAsString(INPUTDIR_LABEL);
		addArgument("inputdir",String.valueOf(inputdirValue));
		String outputdirValue = getParameterAsString(OUTPUTDIR_LABEL);
		addArgument("outputdir",String.valueOf(outputdirValue));
		executeMothurCommand();
		String fileName="<fileName>"; // TODO: Somehow figure out the fileName
		mapOutPort.deliver(new FileNameObject(fileName+".map","map"));
		sharedOutPort.deliver(new FileNameObject(fileName+".shared","shared"));
		groupOutPort.deliver(new FileNameObject(fileName+".group","group"));
	}

	@Override
	public List<ParameterType> getParameterTypes() {
		List<ParameterType> parameterTypes = super.getParameterTypes();
		parameterTypes.add(new ParameterTypeString(LABEL_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeString(GROUPS_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeInt(SEED_LABEL, "TODO: Add description", -100000000, 100000000, 0, true));
		parameterTypes.add(new ParameterTypeString(INPUTDIR_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeString(OUTPUTDIR_LABEL, "TODO: Add description", "", true));
		return parameterTypes;
	}

	@Override
	public String getOutputPattern(String type) {
		if (type.equals("map")) return "[filename],map";
		if (type.equals("shared")) return "[filename],shared-[filename],[distance],shared";
		if (type.equals("group")) return "[filename],[group],groups";
		return super.getOutputPattern(type);
	}
}
