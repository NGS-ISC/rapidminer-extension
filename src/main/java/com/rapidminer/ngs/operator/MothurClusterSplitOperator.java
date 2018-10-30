package com.rapidminer.ngs.operator;

import java.util.List;
import com.rapidminer.operator.OperatorDescription;
import com.rapidminer.operator.ports.InputPort;
import com.rapidminer.operator.ports.OutputPort;
import com.rapidminer.operator.OperatorException;
import com.rapidminer.parameter.*;

public class MothurClusterSplitOperator extends MothurGeneratedOperator {

	private InputPort columnInPort = getInputPorts().createPort("column");
	private InputPort countInPort = getInputPorts().createPort("count");
	private InputPort fastaInPort = getInputPorts().createPort("fasta");
	private InputPort fileInPort = getInputPorts().createPort("file");
	private InputPort nameInPort = getInputPorts().createPort("name");
	private InputPort phylipInPort = getInputPorts().createPort("phylip");
	private InputPort taxonomyInPort = getInputPorts().createPort("taxonomy");
	private OutputPort sabundOutPort = getOutputPorts().createPort("sabund");
	private OutputPort listOutPort = getOutputPorts().createPort("list");
	private OutputPort rabundOutPort = getOutputPorts().createPort("rabund");
	private OutputPort sensspecOutPort = getOutputPorts().createPort("sensspec");
	private OutputPort fileOutPort = getOutputPorts().createPort("file");
	private OutputPort columnOutPort = getOutputPorts().createPort("column");
	private static final String CLASSIC_LABEL = "classic:";
	private static final String CLUSTER_LABEL = "cluster:";
	private static final String CUTOFF_LABEL = "cutoff:";
	private static final String DELTA_LABEL = "delta:";
	private static final String DIST_LABEL = "dist:";
	public static final String[] INITIALIZE_CHOICES = { "oneotu", "singleton" };
	public static final int INITIALIZE_DEFAULT_CHOICE = 1;
	private static final String INITIALIZE_LABEL = "initialize:";
	private static final String INPUTDIR_LABEL = "inputdir:";
	private static final String ISLIST_LABEL = "islist:";
	private static final String ITERS_LABEL = "iters:";
	private static final String LARGE_LABEL = "large:";
	public static final String[] METHOD_CHOICES = { "agc", "average", "dgc", "furthest", "nearest", "opti", "weighted" };
	public static final int METHOD_DEFAULT_CHOICE = 5;
	private static final String METHOD_LABEL = "method:";
	public static final String[] METRIC_CHOICES = { "accuracy", "f1score", "fdr", "fn", "fp", "fpfn", "mcc", "npv", "ppv", "sens", "spec", "tn", "tp", "tptn" };
	public static final int METRIC_DEFAULT_CHOICE = 6;
	private static final String METRIC_LABEL = "metric:";
	private static final String OUTPUTDIR_LABEL = "outputdir:";
	private static final String PRECISION_LABEL = "precision:";
	private static final String PROCESSORS_LABEL = "processors:";
	private static final String RUNSENSSPEC_LABEL = "runsensspec:";
	private static final String SEED_LABEL = "seed:";
	private static final String SHOWABUND_LABEL = "showabund:";
	public static final String[] SPLITMETHOD_CHOICES = { "classify", "distance", "fasta" };
	public static final int SPLITMETHOD_DEFAULT_CHOICE = 1;
	private static final String SPLITMETHOD_LABEL = "splitmethod:";
	private static final String TAXLEVEL_LABEL = "taxlevel:";
	private static final String TIMING_LABEL = "timing:";

	public MothurClusterSplitOperator (OperatorDescription description) {
		super(description);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void doWork() throws OperatorException {
		super.doWork();
		clearArguments();
		FileNameObject columnFile = columnInPort.getData(FileNameObject.class);
		addArgument("column",columnFile.getName());
		FileNameObject countFile = countInPort.getData(FileNameObject.class);
		addArgument("count",countFile.getName());
		FileNameObject fastaFile = fastaInPort.getData(FileNameObject.class);
		addArgument("fasta",fastaFile.getName());
		FileNameObject fileFile = fileInPort.getData(FileNameObject.class);
		addArgument("file",fileFile.getName());
		FileNameObject nameFile = nameInPort.getData(FileNameObject.class);
		addArgument("name",nameFile.getName());
		FileNameObject phylipFile = phylipInPort.getData(FileNameObject.class);
		addArgument("phylip",phylipFile.getName());
		FileNameObject taxonomyFile = taxonomyInPort.getData(FileNameObject.class);
		addArgument("taxonomy",taxonomyFile.getName());
		boolean classicValue = getParameterAsBoolean(CLASSIC_LABEL);
		addArgument("classic",String.valueOf(classicValue));
		boolean clusterValue = getParameterAsBoolean(CLUSTER_LABEL);
		addArgument("cluster",String.valueOf(clusterValue));
		int cutoffValue = getParameterAsInt(CUTOFF_LABEL);
		addArgument("cutoff",String.valueOf(cutoffValue));
		int deltaValue = getParameterAsInt(DELTA_LABEL);
		addArgument("delta",String.valueOf(deltaValue));
		boolean distValue = getParameterAsBoolean(DIST_LABEL);
		addArgument("dist",String.valueOf(distValue));
		int initializeIndex = getParameterAsInt(INITIALIZE_LABEL);
		String initializeValue = INITIALIZE_CHOICES[initializeIndex];
		addArgument("initialize",String.valueOf(initializeValue));
		String inputdirValue = getParameterAsString(INPUTDIR_LABEL);
		addArgument("inputdir",String.valueOf(inputdirValue));
		boolean islistValue = getParameterAsBoolean(ISLIST_LABEL);
		addArgument("islist",String.valueOf(islistValue));
		int itersValue = getParameterAsInt(ITERS_LABEL);
		addArgument("iters",String.valueOf(itersValue));
		boolean largeValue = getParameterAsBoolean(LARGE_LABEL);
		addArgument("large",String.valueOf(largeValue));
		int methodIndex = getParameterAsInt(METHOD_LABEL);
		String methodValue = METHOD_CHOICES[methodIndex];
		addArgument("method",String.valueOf(methodValue));
		int metricIndex = getParameterAsInt(METRIC_LABEL);
		String metricValue = METRIC_CHOICES[metricIndex];
		addArgument("metric",String.valueOf(metricValue));
		String outputdirValue = getParameterAsString(OUTPUTDIR_LABEL);
		addArgument("outputdir",String.valueOf(outputdirValue));
		int precisionValue = getParameterAsInt(PRECISION_LABEL);
		addArgument("precision",String.valueOf(precisionValue));
		int processorsValue = getParameterAsInt(PROCESSORS_LABEL);
		addArgument("processors",String.valueOf(processorsValue));
		boolean runsensspecValue = getParameterAsBoolean(RUNSENSSPEC_LABEL);
		addArgument("runsensspec",String.valueOf(runsensspecValue));
		int seedValue = getParameterAsInt(SEED_LABEL);
		addArgument("seed",String.valueOf(seedValue));
		boolean showabundValue = getParameterAsBoolean(SHOWABUND_LABEL);
		addArgument("showabund",String.valueOf(showabundValue));
		int splitmethodIndex = getParameterAsInt(SPLITMETHOD_LABEL);
		String splitmethodValue = SPLITMETHOD_CHOICES[splitmethodIndex];
		addArgument("splitmethod",String.valueOf(splitmethodValue));
		int taxlevelValue = getParameterAsInt(TAXLEVEL_LABEL);
		addArgument("taxlevel",String.valueOf(taxlevelValue));
		boolean timingValue = getParameterAsBoolean(TIMING_LABEL);
		addArgument("timing",String.valueOf(timingValue));
		executeMothurCommand();
		String fileName="<fileName>"; // TODO: Somehow figure out the fileName
		sabundOutPort.deliver(new FileNameObject(fileName+".sabund","sabund"));
		listOutPort.deliver(new FileNameObject(fileName+".list","list"));
		rabundOutPort.deliver(new FileNameObject(fileName+".rabund","rabund"));
		sensspecOutPort.deliver(new FileNameObject(fileName+".sensspec","sensspec"));
		fileOutPort.deliver(new FileNameObject(fileName+".file","file"));
		columnOutPort.deliver(new FileNameObject(fileName+".column","column"));
	}

	@Override
	public List<ParameterType> getParameterTypes() {
		List<ParameterType> parameterTypes = super.getParameterTypes();
		parameterTypes.add(new ParameterTypeBoolean(CLASSIC_LABEL, "TODO: Add description", false, true));
		parameterTypes.add(new ParameterTypeBoolean(CLUSTER_LABEL, "TODO: Add description", true, true));
		parameterTypes.add(new ParameterTypeDouble(CUTOFF_LABEL, "TODO: Add description", -100000000, 100000000, 0.03, true));
		parameterTypes.add(new ParameterTypeDouble(DELTA_LABEL, "TODO: Add description", -100000000, 100000000, 0.0001, true));
		parameterTypes.add(new ParameterTypeBoolean(DIST_LABEL, "TODO: Add description", false, true));
		parameterTypes.add(new ParameterTypeCategory(INITIALIZE_LABEL, "TODO: Add description", INITIALIZE_CHOICES, INITIALIZE_DEFAULT_CHOICE));
		parameterTypes.add(new ParameterTypeString(INPUTDIR_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeBoolean(ISLIST_LABEL, "TODO: Add description", false, true));
		parameterTypes.add(new ParameterTypeInt(ITERS_LABEL, "TODO: Add description", -100000000, 100000000, 100, true));
		parameterTypes.add(new ParameterTypeBoolean(LARGE_LABEL, "TODO: Add description", false, true));
		parameterTypes.add(new ParameterTypeCategory(METHOD_LABEL, "TODO: Add description", METHOD_CHOICES, METHOD_DEFAULT_CHOICE));
		parameterTypes.add(new ParameterTypeCategory(METRIC_LABEL, "TODO: Add description", METRIC_CHOICES, METRIC_DEFAULT_CHOICE));
		parameterTypes.add(new ParameterTypeString(OUTPUTDIR_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeInt(PRECISION_LABEL, "TODO: Add description", -100000000, 100000000, 100, true));
		parameterTypes.add(new ParameterTypeInt(PROCESSORS_LABEL, "TODO: Add description", -100000000, 100000000, 1, true));
		parameterTypes.add(new ParameterTypeBoolean(RUNSENSSPEC_LABEL, "TODO: Add description", true, true));
		parameterTypes.add(new ParameterTypeInt(SEED_LABEL, "TODO: Add description", -100000000, 100000000, 0, true));
		parameterTypes.add(new ParameterTypeBoolean(SHOWABUND_LABEL, "TODO: Add description", true, true));
		parameterTypes.add(new ParameterTypeCategory(SPLITMETHOD_LABEL, "TODO: Add description", SPLITMETHOD_CHOICES, SPLITMETHOD_DEFAULT_CHOICE));
		parameterTypes.add(new ParameterTypeInt(TAXLEVEL_LABEL, "TODO: Add description", -100000000, 100000000, 3, true));
		parameterTypes.add(new ParameterTypeBoolean(TIMING_LABEL, "TODO: Add description", false, true));
		return parameterTypes;
	}

	@Override
	public String getOutputPattern(String type) {
		// TODO Use a dictionary to reflect type to pattern
		if (type=="sabund") return "[filename],[clustertag],sabund";
		if (type=="list") return "[filename],[clustertag],list-[filename],[clustertag],[tag2],list";
		if (type=="rabund") return "[filename],[clustertag],rabund";
		if (type=="sensspec") return "[filename],[clustertag],sensspec";
		if (type=="file") return "[filename],file";
		if (type=="column") return "[filename],dist";
		// TODO if nil then 
		return super.getOutputPattern(type);
	}
}
