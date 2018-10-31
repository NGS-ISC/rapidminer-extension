package com.rapidminer.ngs.operator;

import java.util.List;
import com.rapidminer.operator.OperatorDescription;
import com.rapidminer.operator.ports.InputPort;
import com.rapidminer.operator.ports.OutputPort;
import com.rapidminer.operator.OperatorException;
import com.rapidminer.parameter.*;

public class MothurCooccurrenceOperator extends MothurGeneratedOperator {

	private InputPort sharedInPort = getInputPorts().createPort("shared");
	private OutputPort summaryOutPort = getOutputPorts().createPort("summary");
	private static final String[] METRIC_CHOICES = { "cscore", "checker", "combo", "vratio" };
	private static final int METRIC_DEFAULT_CHOICE = 0;
	private static final String METRIC_LABEL = "metric:";
	private static final String[] MATRIXMODEL_CHOICES = { "sim1", "sim2", "sim3", "sim4", "sim5", "sim6", "sim7", "sim8", "sim9" };
	private static final int MATRIXMODEL_DEFAULT_CHOICE = 1;
	private static final String MATRIXMODEL_LABEL = "matrixmodel:";
	private static final String ITERS_LABEL = "iters:";
	private static final String SEED_LABEL = "seed:";
	private static final String INPUTDIR_LABEL = "inputdir:";
	private static final String OUTPUTDIR_LABEL = "outputdir:";
	private static final String LABEL_LABEL = "label:";
	private static final String GROUPS_LABEL = "groups:";

	public MothurCooccurrenceOperator (OperatorDescription description) {
		super(description);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void doWork() throws OperatorException {
		super.doWork();
		clearArguments();
		FileNameObject sharedFile = sharedInPort.getData(FileNameObject.class);
		addArgument("shared",sharedFile.getName());
		int metricIndex = getParameterAsInt(METRIC_LABEL);
		String metricValue = METRIC_CHOICES[metricIndex];
		addArgument("metric",String.valueOf(metricValue));
		int matrixmodelIndex = getParameterAsInt(MATRIXMODEL_LABEL);
		String matrixmodelValue = MATRIXMODEL_CHOICES[matrixmodelIndex];
		addArgument("matrixmodel",String.valueOf(matrixmodelValue));
		int itersValue = getParameterAsInt(ITERS_LABEL);
		addArgument("iters",String.valueOf(itersValue));
		int seedValue = getParameterAsInt(SEED_LABEL);
		addArgument("seed",String.valueOf(seedValue));
		String inputdirValue = getParameterAsString(INPUTDIR_LABEL);
		addArgument("inputdir",String.valueOf(inputdirValue));
		String outputdirValue = getParameterAsString(OUTPUTDIR_LABEL);
		addArgument("outputdir",String.valueOf(outputdirValue));
		String labelValue = getParameterAsString(LABEL_LABEL);
		addArgument("label",String.valueOf(labelValue));
		String groupsValue = getParameterAsString(GROUPS_LABEL);
		addArgument("groups",String.valueOf(groupsValue));
		executeMothurCommand();
		String fileName="<fileName>"; // TODO: Somehow figure out the fileName
		summaryOutPort.deliver(new FileNameObject(fileName+".summary","summary"));
	}

	@Override
	public List<ParameterType> getParameterTypes() {
		List<ParameterType> parameterTypes = super.getParameterTypes();
		parameterTypes.add(new ParameterTypeCategory(METRIC_LABEL, "TODO: Add description", METRIC_CHOICES, METRIC_DEFAULT_CHOICE));
		parameterTypes.add(new ParameterTypeCategory(MATRIXMODEL_LABEL, "TODO: Add description", MATRIXMODEL_CHOICES, MATRIXMODEL_DEFAULT_CHOICE));
		parameterTypes.add(new ParameterTypeInt(ITERS_LABEL, "TODO: Add description", -100000000, 100000000, 1000, true));
		parameterTypes.add(new ParameterTypeInt(SEED_LABEL, "TODO: Add description", -100000000, 100000000, 0, true));
		parameterTypes.add(new ParameterTypeString(INPUTDIR_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeString(OUTPUTDIR_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeString(LABEL_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeString(GROUPS_LABEL, "TODO: Add description", "", true));
		return parameterTypes;
	}

	@Override
	public String getOutputPattern(String type) {
		// TODO Use a dictionary to reflect type to pattern
		if (type.equals("summary")) return "[filename],cooccurence.summary";
		// TODO if nil then 
		return super.getOutputPattern(type);
	}
}
