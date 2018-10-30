package com.rapidminer.ngs.operator;

import java.util.List;
import com.rapidminer.operator.OperatorDescription;
import com.rapidminer.operator.ports.InputPort;
import com.rapidminer.operator.ports.OutputPort;
import com.rapidminer.operator.OperatorException;
import com.rapidminer.parameter.*;

public class MothurMgclusterOperator extends MothurGeneratedOperator {

	private InputPort blastInPort = getInputPorts().createPort("blast");
	private InputPort countInPort = getInputPorts().createPort("count");
	private InputPort nameInPort = getInputPorts().createPort("name");
	private OutputPort rabundOutPort = getOutputPorts().createPort("rabund");
	private OutputPort stepsOutPort = getOutputPorts().createPort("steps");
	private OutputPort listOutPort = getOutputPorts().createPort("list");
	private OutputPort sensspecOutPort = getOutputPorts().createPort("sensspec");
	private OutputPort sabundOutPort = getOutputPorts().createPort("sabund");
	private static final String ADJUST_LABEL = "adjust:";
	private static final String CUTOFF_LABEL = "cutoff:";
	private static final String DELTA_LABEL = "delta:";
	private static final String HCLUSTER_LABEL = "hcluster:";
	public static final String[] INITIALIZE_CHOICES = { "oneotu", "singleton" };
	public static final int INITIALIZE_DEFAULT_CHOICE = 1;
	private static final String INITIALIZE_LABEL = "initialize:";
	private static final String INPUTDIR_LABEL = "inputdir:";
	private static final String ITERS_LABEL = "iters:";
	private static final String LENGTH_LABEL = "length:";
	private static final String MERGE_LABEL = "merge:";
	public static final String[] METHOD_CHOICES = { "average", "furthest", "nearest", "opti" };
	public static final int METHOD_DEFAULT_CHOICE = 3;
	private static final String METHOD_LABEL = "method:";
	public static final String[] METRIC_CHOICES = { "accuracy", "f1score", "fdr", "fn", "fp", "fpfn", "mcc", "npv", "ppv", "sens", "spec", "tn", "tp", "tptn" };
	public static final int METRIC_DEFAULT_CHOICE = 6;
	private static final String METRIC_LABEL = "metric:";
	private static final String MIN_LABEL = "min:";
	private static final String OUTPUTDIR_LABEL = "outputdir:";
	private static final String PENALTY_LABEL = "penalty:";
	private static final String PRECISION_LABEL = "precision:";
	private static final String SEED_LABEL = "seed:";

	public MothurMgclusterOperator (OperatorDescription description) {
		super(description);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void doWork() throws OperatorException {
		super.doWork();
		clearArguments();
		FileNameObject blastFile = blastInPort.getData(FileNameObject.class);
		addArgument("blast",blastFile.getName());
		FileNameObject countFile = countInPort.getData(FileNameObject.class);
		addArgument("count",countFile.getName());
		FileNameObject nameFile = nameInPort.getData(FileNameObject.class);
		addArgument("name",nameFile.getName());
		String adjustValue = getParameterAsString(ADJUST_LABEL);
		addArgument("adjust",String.valueOf(adjustValue));
		int cutoffValue = getParameterAsInt(CUTOFF_LABEL);
		addArgument("cutoff",String.valueOf(cutoffValue));
		int deltaValue = getParameterAsInt(DELTA_LABEL);
		addArgument("delta",String.valueOf(deltaValue));
		boolean hclusterValue = getParameterAsBoolean(HCLUSTER_LABEL);
		addArgument("hcluster",String.valueOf(hclusterValue));
		int initializeIndex = getParameterAsInt(INITIALIZE_LABEL);
		String initializeValue = INITIALIZE_CHOICES[initializeIndex];
		addArgument("initialize",String.valueOf(initializeValue));
		String inputdirValue = getParameterAsString(INPUTDIR_LABEL);
		addArgument("inputdir",String.valueOf(inputdirValue));
		int itersValue = getParameterAsInt(ITERS_LABEL);
		addArgument("iters",String.valueOf(itersValue));
		int lengthValue = getParameterAsInt(LENGTH_LABEL);
		addArgument("length",String.valueOf(lengthValue));
		boolean mergeValue = getParameterAsBoolean(MERGE_LABEL);
		addArgument("merge",String.valueOf(mergeValue));
		int methodIndex = getParameterAsInt(METHOD_LABEL);
		String methodValue = METHOD_CHOICES[methodIndex];
		addArgument("method",String.valueOf(methodValue));
		int metricIndex = getParameterAsInt(METRIC_LABEL);
		String metricValue = METRIC_CHOICES[metricIndex];
		addArgument("metric",String.valueOf(metricValue));
		boolean minValue = getParameterAsBoolean(MIN_LABEL);
		addArgument("min",String.valueOf(minValue));
		String outputdirValue = getParameterAsString(OUTPUTDIR_LABEL);
		addArgument("outputdir",String.valueOf(outputdirValue));
		int penaltyValue = getParameterAsInt(PENALTY_LABEL);
		addArgument("penalty",String.valueOf(penaltyValue));
		int precisionValue = getParameterAsInt(PRECISION_LABEL);
		addArgument("precision",String.valueOf(precisionValue));
		int seedValue = getParameterAsInt(SEED_LABEL);
		addArgument("seed",String.valueOf(seedValue));
		executeMothurCommand();
		String fileName="<fileName>"; // TODO: Somehow figure out the fileName
		rabundOutPort.deliver(new FileNameObject(fileName+".rabund","rabund"));
		stepsOutPort.deliver(new FileNameObject(fileName+".steps","steps"));
		listOutPort.deliver(new FileNameObject(fileName+".list","list"));
		sensspecOutPort.deliver(new FileNameObject(fileName+".sensspec","sensspec"));
		sabundOutPort.deliver(new FileNameObject(fileName+".sabund","sabund"));
	}

	@Override
	public List<ParameterType> getParameterTypes() {
		List<ParameterType> parameterTypes = super.getParameterTypes();
		parameterTypes.add(new ParameterTypeString(ADJUST_LABEL, "TODO: Add description", "F", true));
		parameterTypes.add(new ParameterTypeDouble(CUTOFF_LABEL, "TODO: Add description", -100000000, 100000000, 0.70, true));
		parameterTypes.add(new ParameterTypeDouble(DELTA_LABEL, "TODO: Add description", -100000000, 100000000, 0.0001, true));
		parameterTypes.add(new ParameterTypeBoolean(HCLUSTER_LABEL, "TODO: Add description", false, true));
		parameterTypes.add(new ParameterTypeCategory(INITIALIZE_LABEL, "TODO: Add description", INITIALIZE_CHOICES, INITIALIZE_DEFAULT_CHOICE));
		parameterTypes.add(new ParameterTypeString(INPUTDIR_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeInt(ITERS_LABEL, "TODO: Add description", -100000000, 100000000, 100, true));
		parameterTypes.add(new ParameterTypeInt(LENGTH_LABEL, "TODO: Add description", -100000000, 100000000, 5, true));
		parameterTypes.add(new ParameterTypeBoolean(MERGE_LABEL, "TODO: Add description", true, true));
		parameterTypes.add(new ParameterTypeCategory(METHOD_LABEL, "TODO: Add description", METHOD_CHOICES, METHOD_DEFAULT_CHOICE));
		parameterTypes.add(new ParameterTypeCategory(METRIC_LABEL, "TODO: Add description", METRIC_CHOICES, METRIC_DEFAULT_CHOICE));
		parameterTypes.add(new ParameterTypeBoolean(MIN_LABEL, "TODO: Add description", true, true));
		parameterTypes.add(new ParameterTypeString(OUTPUTDIR_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeDouble(PENALTY_LABEL, "TODO: Add description", -100000000, 100000000, 0.10, true));
		parameterTypes.add(new ParameterTypeInt(PRECISION_LABEL, "TODO: Add description", -100000000, 100000000, 100, true));
		parameterTypes.add(new ParameterTypeInt(SEED_LABEL, "TODO: Add description", -100000000, 100000000, 0, true));
		return parameterTypes;
	}

	@Override
	public String getOutputPattern(String type) {
		// TODO Use a dictionary to reflect type to pattern
		if (type=="rabund") return "[filename],[clustertag],rabund";
		if (type=="steps") return "[filename],[clustertag],steps";
		if (type=="list") return "[filename],[clustertag],list-[filename],[clustertag],[tag2],list";
		if (type=="sensspec") return "[filename],[clustertag],sensspec";
		if (type=="sabund") return "[filename],[clustertag],sabund";
		// TODO if nil then 
		return super.getOutputPattern(type);
	}
}
