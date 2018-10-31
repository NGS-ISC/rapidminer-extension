package com.rapidminer.ngs.operator;

import java.util.List;
import com.rapidminer.operator.OperatorDescription;
import com.rapidminer.operator.ports.InputPort;
import com.rapidminer.operator.ports.OutputPort;
import com.rapidminer.operator.OperatorException;
import com.rapidminer.parameter.*;

public class MothurNormalizeSharedOperator extends MothurGeneratedOperator {

	private InputPort sharedInPort = getInputPorts().createPort("shared");
	private InputPort relabundInPort = getInputPorts().createPort("relabund");
	private OutputPort sharedOutPort = getOutputPorts().createPort("shared");
	private static final String GROUPS_LABEL = "groups:";
	private static final String[] METHOD_CHOICES = { "totalgroup", "zscore" };
	private static final int METHOD_DEFAULT_CHOICE = 0;
	private static final String METHOD_LABEL = "method:";
	private static final String NORM_LABEL = "norm:";
	private static final String MAKERELABUND_LABEL = "makerelabund:";
	private static final String LABEL_LABEL = "label:";
	private static final String SEED_LABEL = "seed:";
	private static final String INPUTDIR_LABEL = "inputdir:";
	private static final String OUTPUTDIR_LABEL = "outputdir:";

	public MothurNormalizeSharedOperator (OperatorDescription description) {
		super(description);
		// NOTE: Auto-generated constructor stub
	}

	@Override
	public void doWork() throws OperatorException {
		super.doWork();
		clearArguments();
		FileNameObject sharedFile = sharedInPort.getData(FileNameObject.class);
		addArgument("shared",sharedFile.getName());
		FileNameObject relabundFile = relabundInPort.getData(FileNameObject.class);
		addArgument("relabund",relabundFile.getName());
		String groupsValue = getParameterAsString(GROUPS_LABEL);
		addArgument("groups",String.valueOf(groupsValue));
		int methodIndex = getParameterAsInt(METHOD_LABEL);
		String methodValue = METHOD_CHOICES[methodIndex];
		addArgument("method",String.valueOf(methodValue));
		int normValue = getParameterAsInt(NORM_LABEL);
		addArgument("norm",String.valueOf(normValue));
		boolean makerelabundValue = getParameterAsBoolean(MAKERELABUND_LABEL);
		addArgument("makerelabund",String.valueOf(makerelabundValue));
		String labelValue = getParameterAsString(LABEL_LABEL);
		addArgument("label",String.valueOf(labelValue));
		int seedValue = getParameterAsInt(SEED_LABEL);
		addArgument("seed",String.valueOf(seedValue));
		String inputdirValue = getParameterAsString(INPUTDIR_LABEL);
		addArgument("inputdir",String.valueOf(inputdirValue));
		String outputdirValue = getParameterAsString(OUTPUTDIR_LABEL);
		addArgument("outputdir",String.valueOf(outputdirValue));
		executeMothurCommand();
		String fileName="<fileName>"; // TODO: Somehow figure out the fileName
		sharedOutPort.deliver(new FileNameObject(fileName+".shared","shared"));
	}

	@Override
	public List<ParameterType> getParameterTypes() {
		List<ParameterType> parameterTypes = super.getParameterTypes();
		parameterTypes.add(new ParameterTypeString(GROUPS_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeCategory(METHOD_LABEL, "TODO: Add description", METHOD_CHOICES, METHOD_DEFAULT_CHOICE));
		parameterTypes.add(new ParameterTypeInt(NORM_LABEL, "TODO: Add description", -100000000, 100000000, 0, true));
		parameterTypes.add(new ParameterTypeBoolean(MAKERELABUND_LABEL, "TODO: Add description", false, true));
		parameterTypes.add(new ParameterTypeString(LABEL_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeInt(SEED_LABEL, "TODO: Add description", -100000000, 100000000, 0, true));
		parameterTypes.add(new ParameterTypeString(INPUTDIR_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeString(OUTPUTDIR_LABEL, "TODO: Add description", "", true));
		return parameterTypes;
	}

	@Override
	public String getOutputPattern(String type) {
		if (type.equals("shared")) return "[filename],[distance],norm.shared";
		return super.getOutputPattern(type);
	}
}
