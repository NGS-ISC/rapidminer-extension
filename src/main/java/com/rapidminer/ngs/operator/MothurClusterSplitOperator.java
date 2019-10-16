package com.rapidminer.ngs.operator;

import java.util.List;
import com.rapidminer.operator.OperatorDescription;
import com.rapidminer.operator.ports.InputPort;
import com.rapidminer.operator.ports.OutputPort;
import com.rapidminer.operator.OperatorException;
import com.rapidminer.parameter.*;

public class MothurClusterSplitOperator extends MothurGeneratedOperator {

	private InputPort fileInPort = getInputPorts().createPort("file");
	private InputPort taxonomyInPort = getInputPorts().createPort("taxonomy");
	private InputPort phylipInPort = getInputPorts().createPort("phylip");
	private InputPort fastaInPort = getInputPorts().createPort("fasta");
	private InputPort nameInPort = getInputPorts().createPort("name");
	private InputPort countInPort = getInputPorts().createPort("count");
	private InputPort columnInPort = getInputPorts().createPort("column");
	private OutputPort columnOutPort = getOutputPorts().createPort("column");
	private OutputPort fileOutPort = getOutputPorts().createPort("file");
	private OutputPort listOutPort = getOutputPorts().createPort("list");
	private OutputPort rabundOutPort = getOutputPorts().createPort("rabund");
	private OutputPort sabundOutPort = getOutputPorts().createPort("sabund");
	private OutputPort sensspecOutPort = getOutputPorts().createPort("sensspec");
	private static final String TAXLEVEL_LABEL = "taxlevel:";
	private static final String[] SPLITMETHOD_CHOICES = { "classify", "fasta", "distance" };
	private static final int SPLITMETHOD_DEFAULT_CHOICE = 2;
	private static final String SPLITMETHOD_LABEL = "splitmethod:";
	private static final String LARGE_LABEL = "large:";
	private static final String SHOWABUND_LABEL = "showabund:";
	private static final String RUNSENSSPEC_LABEL = "runsensspec:";
	private static final String CLUSTER_LABEL = "cluster:";
	private static final String TIMING_LABEL = "timing:";
	private static final String PROCESSORS_LABEL = "processors:";
	private static final String CUTOFF_LABEL = "cutoff:";
	private static final String DELTA_LABEL = "delta:";
	private static final String ITERS_LABEL = "iters:";
	private static final String[] INITIALIZE_CHOICES = { "oneotu", "singleton" };
	private static final int INITIALIZE_DEFAULT_CHOICE = 1;
	private static final String INITIALIZE_LABEL = "initialize:";
	private static final String PRECISION_LABEL = "precision:";
	private static final String[] METHOD_CHOICES = { "furthest", "nearest", "average", "weighted", "agc", "dgc", "opti" };
	private static final int METHOD_DEFAULT_CHOICE = 6;
	private static final String METHOD_LABEL = "method:";
	private static final String[] METRIC_CHOICES = { "mcc", "sens", "spec", "tptn", "fpfn", "tp", "tn", "fp", "fn", "f1score", "accuracy", "ppv", "npv", "fdr" };
	private static final int METRIC_DEFAULT_CHOICE = 0;
	private static final String METRIC_LABEL = "metric:";
	private static final String DIST_LABEL = "dist:";
	private static final String ISLIST_LABEL = "islist:";
	private static final String CLASSIC_LABEL = "classic:";
	private static final String SEED_LABEL = "seed:";
	private static final String INPUTDIR_LABEL = "inputdir:";
	private static final String OUTPUTDIR_LABEL = "outputdir:";

	public MothurClusterSplitOperator (OperatorDescription description) {
		super(description);
		// NOTE: Auto-generated constructor stub
	}

	@Override
	public void doWork() throws OperatorException {
		super.doWork();
		clearArguments();
		FileNameObject fileFile = fileInPort.getData(FileNameObject.class);
		addArgument("file",fileFile.getName());
		FileNameObject taxonomyFile = taxonomyInPort.getData(FileNameObject.class);
		addArgument("taxonomy",taxonomyFile.getName());
		FileNameObject phylipFile = phylipInPort.getData(FileNameObject.class);
		addArgument("phylip",phylipFile.getName());
		FileNameObject fastaFile = fastaInPort.getData(FileNameObject.class);
		addArgument("fasta",fastaFile.getName());
		FileNameObject nameFile = nameInPort.getData(FileNameObject.class);
		addArgument("name",nameFile.getName());
		FileNameObject countFile = countInPort.getData(FileNameObject.class);
		addArgument("count",countFile.getName());
		FileNameObject columnFile = columnInPort.getData(FileNameObject.class);
		addArgument("column",columnFile.getName());
		int taxlevelValue = getParameterAsInt(TAXLEVEL_LABEL);
		addArgument("taxlevel",String.valueOf(taxlevelValue));
		int splitmethodIndex = getParameterAsInt(SPLITMETHOD_LABEL);
		String splitmethodValue = SPLITMETHOD_CHOICES[splitmethodIndex];
		addArgument("splitmethod",String.valueOf(splitmethodValue));
		boolean largeValue = getParameterAsBoolean(LARGE_LABEL);
		addArgument("large",String.valueOf(largeValue));
		boolean showabundValue = getParameterAsBoolean(SHOWABUND_LABEL);
		addArgument("showabund",String.valueOf(showabundValue));
		boolean runsensspecValue = getParameterAsBoolean(RUNSENSSPEC_LABEL);
		addArgument("runsensspec",String.valueOf(runsensspecValue));
		boolean clusterValue = getParameterAsBoolean(CLUSTER_LABEL);
		addArgument("cluster",String.valueOf(clusterValue));
		boolean timingValue = getParameterAsBoolean(TIMING_LABEL);
		addArgument("timing",String.valueOf(timingValue));
		int processorsValue = getParameterAsInt(PROCESSORS_LABEL);
		addArgument("processors",String.valueOf(processorsValue));
		int cutoffValue = getParameterAsInt(CUTOFF_LABEL);
		addArgument("cutoff",String.valueOf(cutoffValue));
		int deltaValue = getParameterAsInt(DELTA_LABEL);
		addArgument("delta",String.valueOf(deltaValue));
		int itersValue = getParameterAsInt(ITERS_LABEL);
		addArgument("iters",String.valueOf(itersValue));
		int initializeIndex = getParameterAsInt(INITIALIZE_LABEL);
		String initializeValue = INITIALIZE_CHOICES[initializeIndex];
		addArgument("initialize",String.valueOf(initializeValue));
		int precisionValue = getParameterAsInt(PRECISION_LABEL);
		addArgument("precision",String.valueOf(precisionValue));
		int methodIndex = getParameterAsInt(METHOD_LABEL);
		String methodValue = METHOD_CHOICES[methodIndex];
		addArgument("method",String.valueOf(methodValue));
		int metricIndex = getParameterAsInt(METRIC_LABEL);
		String metricValue = METRIC_CHOICES[metricIndex];
		addArgument("metric",String.valueOf(metricValue));
		boolean distValue = getParameterAsBoolean(DIST_LABEL);
		addArgument("dist",String.valueOf(distValue));
		boolean islistValue = getParameterAsBoolean(ISLIST_LABEL);
		addArgument("islist",String.valueOf(islistValue));
		boolean classicValue = getParameterAsBoolean(CLASSIC_LABEL);
		addArgument("classic",String.valueOf(classicValue));
		int seedValue = getParameterAsInt(SEED_LABEL);
		addArgument("seed",String.valueOf(seedValue));
		String inputdirValue = getParameterAsString(INPUTDIR_LABEL);
		addArgument("inputdir",String.valueOf(inputdirValue));
		String outputdirValue = getParameterAsString(OUTPUTDIR_LABEL);
		addArgument("outputdir",String.valueOf(outputdirValue));
		executeMothurCommand();
		String fileName="<fileName>"; // TODO: Somehow figure out the fileName
		columnOutPort.deliver(new FileNameObject(fileName+".column","column"));
		fileOutPort.deliver(new FileNameObject(fileName+".file","file"));
		listOutPort.deliver(new FileNameObject(fileName+".list","list"));
		rabundOutPort.deliver(new FileNameObject(fileName+".rabund","rabund"));
		sabundOutPort.deliver(new FileNameObject(fileName+".sabund","sabund"));
		sensspecOutPort.deliver(new FileNameObject(fileName+".sensspec","sensspec"));
	}

	@Override
	public List<ParameterType> getParameterTypes() {
		List<ParameterType> parameterTypes = super.getParameterTypes();
		parameterTypes.add(new ParameterTypeInt(TAXLEVEL_LABEL, "TODO: Add description", -100000000, 100000000, 3, true));
		parameterTypes.add(new ParameterTypeCategory(SPLITMETHOD_LABEL, "TODO: Add description", SPLITMETHOD_CHOICES, SPLITMETHOD_DEFAULT_CHOICE));
		parameterTypes.add(new ParameterTypeBoolean(LARGE_LABEL, "TODO: Add description", false, true));
		parameterTypes.add(new ParameterTypeBoolean(SHOWABUND_LABEL, "TODO: Add description", true, true));
		parameterTypes.add(new ParameterTypeBoolean(RUNSENSSPEC_LABEL, "TODO: Add description", true, true));
		parameterTypes.add(new ParameterTypeBoolean(CLUSTER_LABEL, "TODO: Add description", true, true));
		parameterTypes.add(new ParameterTypeBoolean(TIMING_LABEL, "TODO: Add description", false, true));
		parameterTypes.add(new ParameterTypeInt(PROCESSORS_LABEL, "TODO: Add description", -100000000, 100000000, 1, true));
		parameterTypes.add(new ParameterTypeDouble(CUTOFF_LABEL, "TODO: Add description", -100000000, 100000000, 0.03, true));
		parameterTypes.add(new ParameterTypeDouble(DELTA_LABEL, "TODO: Add description", -100000000, 100000000, 0.0001, true));
		parameterTypes.add(new ParameterTypeInt(ITERS_LABEL, "TODO: Add description", -100000000, 100000000, 100, true));
		parameterTypes.add(new ParameterTypeCategory(INITIALIZE_LABEL, "TODO: Add description", INITIALIZE_CHOICES, INITIALIZE_DEFAULT_CHOICE));
		parameterTypes.add(new ParameterTypeInt(PRECISION_LABEL, "TODO: Add description", -100000000, 100000000, 100, true));
		parameterTypes.add(new ParameterTypeCategory(METHOD_LABEL, "TODO: Add description", METHOD_CHOICES, METHOD_DEFAULT_CHOICE));
		parameterTypes.add(new ParameterTypeCategory(METRIC_LABEL, "TODO: Add description", METRIC_CHOICES, METRIC_DEFAULT_CHOICE));
		parameterTypes.add(new ParameterTypeBoolean(DIST_LABEL, "TODO: Add description", false, true));
		parameterTypes.add(new ParameterTypeBoolean(ISLIST_LABEL, "TODO: Add description", false, true));
		parameterTypes.add(new ParameterTypeBoolean(CLASSIC_LABEL, "TODO: Add description", false, true));
		parameterTypes.add(new ParameterTypeInt(SEED_LABEL, "TODO: Add description", -100000000, 100000000, 0, true));
		parameterTypes.add(new ParameterTypeString(INPUTDIR_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeString(OUTPUTDIR_LABEL, "TODO: Add description", "", true));
		return parameterTypes;
	}

	@Override
	public String getOutputPattern(String type) {
		if (type.equals("rabund")) return "[filename],[clustertag],rabund";
		if (type.equals("column")) return "[filename],dist";
		if (type.equals("sabund")) return "[filename],[clustertag],sabund";
		if (type.equals("list")) return "[filename],[clustertag],list-[filename],[clustertag],[tag2],list";
		if (type.equals("sensspec")) return "[filename],[clustertag],sensspec";
		if (type.equals("file")) return "[filename],file";
		return super.getOutputPattern(type);
	}
}
