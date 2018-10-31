package com.rapidminer.ngs.operator;

import java.util.List;
import com.rapidminer.operator.OperatorDescription;
import com.rapidminer.operator.ports.InputPort;
import com.rapidminer.operator.ports.OutputPort;
import com.rapidminer.operator.OperatorException;
import com.rapidminer.parameter.*;

public class MothurCorrAxesOperator extends MothurGeneratedOperator {

	private InputPort axesInPort = getInputPorts().createPort("axes");
	private InputPort sharedInPort = getInputPorts().createPort("shared");
	private InputPort relabundInPort = getInputPorts().createPort("relabund");
	private InputPort metadataInPort = getInputPorts().createPort("metadata");
	private OutputPort corraxesOutPort = getOutputPorts().createPort("corraxes");
	private static final String NUMAXES_LABEL = "numaxes:";
	private static final String LABEL_LABEL = "label:";
	private static final String GROUPS_LABEL = "groups:";
	private static final String[] METHOD_CHOICES = { "pearson", "spearman", "kendall" };
	private static final int METHOD_DEFAULT_CHOICE = 0;
	private static final String METHOD_LABEL = "method:";
	private static final String SEED_LABEL = "seed:";
	private static final String INPUTDIR_LABEL = "inputdir:";
	private static final String OUTPUTDIR_LABEL = "outputdir:";

	public MothurCorrAxesOperator (OperatorDescription description) {
		super(description);
		// NOTE: Auto-generated constructor stub
	}

	@Override
	public void doWork() throws OperatorException {
		super.doWork();
		clearArguments();
		FileNameObject axesFile = axesInPort.getData(FileNameObject.class);
		addArgument("axes",axesFile.getName());
		FileNameObject sharedFile = sharedInPort.getData(FileNameObject.class);
		addArgument("shared",sharedFile.getName());
		FileNameObject relabundFile = relabundInPort.getData(FileNameObject.class);
		addArgument("relabund",relabundFile.getName());
		FileNameObject metadataFile = metadataInPort.getData(FileNameObject.class);
		addArgument("metadata",metadataFile.getName());
		int numaxesValue = getParameterAsInt(NUMAXES_LABEL);
		addArgument("numaxes",String.valueOf(numaxesValue));
		String labelValue = getParameterAsString(LABEL_LABEL);
		addArgument("label",String.valueOf(labelValue));
		String groupsValue = getParameterAsString(GROUPS_LABEL);
		addArgument("groups",String.valueOf(groupsValue));
		int methodIndex = getParameterAsInt(METHOD_LABEL);
		String methodValue = METHOD_CHOICES[methodIndex];
		addArgument("method",String.valueOf(methodValue));
		int seedValue = getParameterAsInt(SEED_LABEL);
		addArgument("seed",String.valueOf(seedValue));
		String inputdirValue = getParameterAsString(INPUTDIR_LABEL);
		addArgument("inputdir",String.valueOf(inputdirValue));
		String outputdirValue = getParameterAsString(OUTPUTDIR_LABEL);
		addArgument("outputdir",String.valueOf(outputdirValue));
		executeMothurCommand();
		String fileName="<fileName>"; // TODO: Somehow figure out the fileName
		corraxesOutPort.deliver(new FileNameObject(fileName+".corraxes","corraxes"));
	}

	@Override
	public List<ParameterType> getParameterTypes() {
		List<ParameterType> parameterTypes = super.getParameterTypes();
		parameterTypes.add(new ParameterTypeInt(NUMAXES_LABEL, "TODO: Add description", -100000000, 100000000, 3, true));
		parameterTypes.add(new ParameterTypeString(LABEL_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeString(GROUPS_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeCategory(METHOD_LABEL, "TODO: Add description", METHOD_CHOICES, METHOD_DEFAULT_CHOICE));
		parameterTypes.add(new ParameterTypeInt(SEED_LABEL, "TODO: Add description", -100000000, 100000000, 0, true));
		parameterTypes.add(new ParameterTypeString(INPUTDIR_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeString(OUTPUTDIR_LABEL, "TODO: Add description", "", true));
		return parameterTypes;
	}

	@Override
	public String getOutputPattern(String type) {
		if (type.equals("corraxes")) return "[filename],[tag],corr.axes";
		return super.getOutputPattern(type);
	}
}
