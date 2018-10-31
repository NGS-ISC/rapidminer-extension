package com.rapidminer.ngs.operator;

import java.util.List;
import com.rapidminer.operator.OperatorDescription;
import com.rapidminer.operator.ports.InputPort;
import com.rapidminer.operator.ports.OutputPort;
import com.rapidminer.operator.OperatorException;
import com.rapidminer.parameter.*;

public class MothurMgclusterOperator extends MothurGeneratedOperator {

	private InputPort blastInPort = getInputPorts().createPort("blast");
	private InputPort nameInPort = getInputPorts().createPort("name");
	private InputPort countInPort = getInputPorts().createPort("count");
	private OutputPort sabundOutPort = getOutputPorts().createPort("sabund");
	private OutputPort sensspecOutPort = getOutputPorts().createPort("sensspec");
	private OutputPort rabundOutPort = getOutputPorts().createPort("rabund");
	private OutputPort stepsOutPort = getOutputPorts().createPort("steps");
	private OutputPort listOutPort = getOutputPorts().createPort("list");
	private static final String LENGTH_LABEL = "length:";
	private static final String PENALTY_LABEL = "penalty:";
	private static final String CUTOFF_LABEL = "cutoff:";
	private static final String PRECISION_LABEL = "precision:";
	private static final String[] METHOD_CHOICES = { "furthest", "nearest", "average", "opti" };
	private static final int METHOD_DEFAULT_CHOICE = 3;
	private static final String METHOD_LABEL = "method:";
	private static final String[] INITIALIZE_CHOICES = { "oneotu", "singleton" };
	private static final int INITIALIZE_DEFAULT_CHOICE = 1;
	private static final String INITIALIZE_LABEL = "initialize:";
	private static final String[] METRIC_CHOICES = { "mcc", "sens", "spec", "tptn", "fpfn", "tp", "tn", "fp", "fn", "f1score", "accuracy", "ppv", "npv", "fdr" };
	private static final int METRIC_DEFAULT_CHOICE = 0;
	private static final String METRIC_LABEL = "metric:";
	private static final String DELTA_LABEL = "delta:";
	private static final String ITERS_LABEL = "iters:";
	private static final String MIN_LABEL = "min:";
	private static final String MERGE_LABEL = "merge:";
	private static final String ADJUST_LABEL = "adjust:";
	private static final String HCLUSTER_LABEL = "hcluster:";
	private static final String SEED_LABEL = "seed:";
	private static final String INPUTDIR_LABEL = "inputdir:";
	private static final String OUTPUTDIR_LABEL = "outputdir:";

	public MothurMgclusterOperator (OperatorDescription description) {
		super(description);
		// NOTE: Auto-generated constructor stub
	}

	@Override
	public void doWork() throws OperatorException {
		super.doWork();
		clearArguments();
		FileNameObject blastFile = blastInPort.getData(FileNameObject.class);
		addArgument("blast",blastFile.getName());
		FileNameObject nameFile = nameInPort.getData(FileNameObject.class);
		addArgument("name",nameFile.getName());
		FileNameObject countFile = countInPort.getData(FileNameObject.class);
		addArgument("count",countFile.getName());
		int lengthValue = getParameterAsInt(LENGTH_LABEL);
		addArgument("length",String.valueOf(lengthValue));
		int penaltyValue = getParameterAsInt(PENALTY_LABEL);
		addArgument("penalty",String.valueOf(penaltyValue));
		int cutoffValue = getParameterAsInt(CUTOFF_LABEL);
		addArgument("cutoff",String.valueOf(cutoffValue));
		int precisionValue = getParameterAsInt(PRECISION_LABEL);
		addArgument("precision",String.valueOf(precisionValue));
		int methodIndex = getParameterAsInt(METHOD_LABEL);
		String methodValue = METHOD_CHOICES[methodIndex];
		addArgument("method",String.valueOf(methodValue));
		int initializeIndex = getParameterAsInt(INITIALIZE_LABEL);
		String initializeValue = INITIALIZE_CHOICES[initializeIndex];
		addArgument("initialize",String.valueOf(initializeValue));
		int metricIndex = getParameterAsInt(METRIC_LABEL);
		String metricValue = METRIC_CHOICES[metricIndex];
		addArgument("metric",String.valueOf(metricValue));
		int deltaValue = getParameterAsInt(DELTA_LABEL);
		addArgument("delta",String.valueOf(deltaValue));
		int itersValue = getParameterAsInt(ITERS_LABEL);
		addArgument("iters",String.valueOf(itersValue));
		boolean minValue = getParameterAsBoolean(MIN_LABEL);
		addArgument("min",String.valueOf(minValue));
		boolean mergeValue = getParameterAsBoolean(MERGE_LABEL);
		addArgument("merge",String.valueOf(mergeValue));
		String adjustValue = getParameterAsString(ADJUST_LABEL);
		addArgument("adjust",String.valueOf(adjustValue));
		boolean hclusterValue = getParameterAsBoolean(HCLUSTER_LABEL);
		addArgument("hcluster",String.valueOf(hclusterValue));
		int seedValue = getParameterAsInt(SEED_LABEL);
		addArgument("seed",String.valueOf(seedValue));
		String inputdirValue = getParameterAsString(INPUTDIR_LABEL);
		addArgument("inputdir",String.valueOf(inputdirValue));
		String outputdirValue = getParameterAsString(OUTPUTDIR_LABEL);
		addArgument("outputdir",String.valueOf(outputdirValue));
		executeMothurCommand();
		String fileName="<fileName>"; // TODO: Somehow figure out the fileName
		sabundOutPort.deliver(new FileNameObject(fileName+".sabund","sabund"));
		sensspecOutPort.deliver(new FileNameObject(fileName+".sensspec","sensspec"));
		rabundOutPort.deliver(new FileNameObject(fileName+".rabund","rabund"));
		stepsOutPort.deliver(new FileNameObject(fileName+".steps","steps"));
		listOutPort.deliver(new FileNameObject(fileName+".list","list"));
	}

	@Override
	public List<ParameterType> getParameterTypes() {
		List<ParameterType> parameterTypes = super.getParameterTypes();
		parameterTypes.add(new ParameterTypeInt(LENGTH_LABEL, "TODO: Add description", -100000000, 100000000, 5, true));
		parameterTypes.add(new ParameterTypeDouble(PENALTY_LABEL, "TODO: Add description", -100000000, 100000000, 0.10, true));
		parameterTypes.add(new ParameterTypeDouble(CUTOFF_LABEL, "TODO: Add description", -100000000, 100000000, 0.70, true));
		parameterTypes.add(new ParameterTypeInt(PRECISION_LABEL, "TODO: Add description", -100000000, 100000000, 100, true));
		parameterTypes.add(new ParameterTypeCategory(METHOD_LABEL, "TODO: Add description", METHOD_CHOICES, METHOD_DEFAULT_CHOICE));
		parameterTypes.add(new ParameterTypeCategory(INITIALIZE_LABEL, "TODO: Add description", INITIALIZE_CHOICES, INITIALIZE_DEFAULT_CHOICE));
		parameterTypes.add(new ParameterTypeCategory(METRIC_LABEL, "TODO: Add description", METRIC_CHOICES, METRIC_DEFAULT_CHOICE));
		parameterTypes.add(new ParameterTypeDouble(DELTA_LABEL, "TODO: Add description", -100000000, 100000000, 0.0001, true));
		parameterTypes.add(new ParameterTypeInt(ITERS_LABEL, "TODO: Add description", -100000000, 100000000, 100, true));
		parameterTypes.add(new ParameterTypeBoolean(MIN_LABEL, "TODO: Add description", true, true));
		parameterTypes.add(new ParameterTypeBoolean(MERGE_LABEL, "TODO: Add description", true, true));
		parameterTypes.add(new ParameterTypeString(ADJUST_LABEL, "TODO: Add description", "F", true));
		parameterTypes.add(new ParameterTypeBoolean(HCLUSTER_LABEL, "TODO: Add description", false, true));
		parameterTypes.add(new ParameterTypeInt(SEED_LABEL, "TODO: Add description", -100000000, 100000000, 0, true));
		parameterTypes.add(new ParameterTypeString(INPUTDIR_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeString(OUTPUTDIR_LABEL, "TODO: Add description", "", true));
		return parameterTypes;
	}

	@Override
	public String getOutputPattern(String type) {
		if (type.equals("sabund")) return "[filename],[clustertag],sabund";
		if (type.equals("sensspec")) return "[filename],[clustertag],sensspec";
		if (type.equals("rabund")) return "[filename],[clustertag],rabund";
		if (type.equals("steps")) return "[filename],[clustertag],steps";
		if (type.equals("list")) return "[filename],[clustertag],list-[filename],[clustertag],[tag2],list";
		return super.getOutputPattern(type);
	}
}
