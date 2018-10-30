package com.rapidminer.ngs.operator;

import java.util.List;
import com.rapidminer.operator.OperatorDescription;
import com.rapidminer.operator.ports.InputPort;
import com.rapidminer.operator.ports.OutputPort;
import com.rapidminer.operator.OperatorException;
import com.rapidminer.parameter.*;

public class MothurClusterFitOperator extends MothurGeneratedOperator {

	private InputPort countInPort = getInputPorts().createPort("count");
	private InputPort fastaInPort = getInputPorts().createPort("fasta");
	private InputPort fastamapInPort = getInputPorts().createPort("fastamap");
	private InputPort listInPort = getInputPorts().createPort("list");
	private InputPort nameInPort = getInputPorts().createPort("name");
	private InputPort refcolumnInPort = getInputPorts().createPort("refcolumn");
	private InputPort refcountInPort = getInputPorts().createPort("refcount");
	private InputPort reffastaInPort = getInputPorts().createPort("reffasta");
	private InputPort refnameInPort = getInputPorts().createPort("refname");
	private OutputPort sensspecOutPort = getOutputPorts().createPort("sensspec");
	private OutputPort stepsOutPort = getOutputPorts().createPort("steps");
	private OutputPort listOutPort = getOutputPorts().createPort("list");
	private static final String CUTOFF_LABEL = "cutoff:";
	private static final String DELTA_LABEL = "delta:";
	public static final String[] INITIALIZE_CHOICES = { "oneotu", "singleton" };
	public static final int INITIALIZE_DEFAULT_CHOICE = 1;
	private static final String INITIALIZE_LABEL = "initialize:";
	private static final String INPUTDIR_LABEL = "inputdir:";
	private static final String ITERS_LABEL = "iters:";
	public static final String[] METHOD_CHOICES = { "opti",  };
	public static final int METHOD_DEFAULT_CHOICE = 0;
	private static final String METHOD_LABEL = "method:";
	public static final String[] METRIC_CHOICES = { "accuracy", "f1score", "fdr", "fn", "fp", "fpfn", "mcc", "npv", "ppv", "sens", "spec", "tn", "tp", "tptn" };
	public static final int METRIC_DEFAULT_CHOICE = 6;
	private static final String METRIC_LABEL = "metric:";
	private static final String OUTPUTDIR_LABEL = "outputdir:";
	private static final String PRECISION_LABEL = "precision:";
	private static final String SEED_LABEL = "seed:";

	public MothurClusterFitOperator (OperatorDescription description) {
		super(description);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void doWork() throws OperatorException {
		super.doWork();
		clearArguments();
		FileNameObject countFile = countInPort.getData(FileNameObject.class);
		addArgument("count",countFile.getName());
		FileNameObject fastaFile = fastaInPort.getData(FileNameObject.class);
		addArgument("fasta",fastaFile.getName());
		FileNameObject fastamapFile = fastamapInPort.getData(FileNameObject.class);
		addArgument("fastamap",fastamapFile.getName());
		FileNameObject listFile = listInPort.getData(FileNameObject.class);
		addArgument("list",listFile.getName());
		FileNameObject nameFile = nameInPort.getData(FileNameObject.class);
		addArgument("name",nameFile.getName());
		FileNameObject refcolumnFile = refcolumnInPort.getData(FileNameObject.class);
		addArgument("refcolumn",refcolumnFile.getName());
		FileNameObject refcountFile = refcountInPort.getData(FileNameObject.class);
		addArgument("refcount",refcountFile.getName());
		FileNameObject reffastaFile = reffastaInPort.getData(FileNameObject.class);
		addArgument("reffasta",reffastaFile.getName());
		FileNameObject refnameFile = refnameInPort.getData(FileNameObject.class);
		addArgument("refname",refnameFile.getName());
		int cutoffValue = getParameterAsInt(CUTOFF_LABEL);
		addArgument("cutoff",String.valueOf(cutoffValue));
		int deltaValue = getParameterAsInt(DELTA_LABEL);
		addArgument("delta",String.valueOf(deltaValue));
		int initializeIndex = getParameterAsInt(INITIALIZE_LABEL);
		String initializeValue = INITIALIZE_CHOICES[initializeIndex];
		addArgument("initialize",String.valueOf(initializeValue));
		String inputdirValue = getParameterAsString(INPUTDIR_LABEL);
		addArgument("inputdir",String.valueOf(inputdirValue));
		int itersValue = getParameterAsInt(ITERS_LABEL);
		addArgument("iters",String.valueOf(itersValue));
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
		int seedValue = getParameterAsInt(SEED_LABEL);
		addArgument("seed",String.valueOf(seedValue));
		executeMothurCommand();
		String fileName="<fileName>"; // TODO: Somehow figure out the fileName
		sensspecOutPort.deliver(new FileNameObject(fileName+".sensspec","sensspec"));
		stepsOutPort.deliver(new FileNameObject(fileName+".steps","steps"));
		listOutPort.deliver(new FileNameObject(fileName+".list","list"));
	}

	@Override
	public List<ParameterType> getParameterTypes() {
		List<ParameterType> parameterTypes = super.getParameterTypes();
		parameterTypes.add(new ParameterTypeDouble(CUTOFF_LABEL, "TODO: Add description", -100000000, 100000000, 0.03, true));
		parameterTypes.add(new ParameterTypeDouble(DELTA_LABEL, "TODO: Add description", -100000000, 100000000, 0.0001, true));
		parameterTypes.add(new ParameterTypeCategory(INITIALIZE_LABEL, "TODO: Add description", INITIALIZE_CHOICES, INITIALIZE_DEFAULT_CHOICE));
		parameterTypes.add(new ParameterTypeString(INPUTDIR_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeInt(ITERS_LABEL, "TODO: Add description", -100000000, 100000000, 100, true));
		parameterTypes.add(new ParameterTypeCategory(METHOD_LABEL, "TODO: Add description", METHOD_CHOICES, METHOD_DEFAULT_CHOICE));
		parameterTypes.add(new ParameterTypeCategory(METRIC_LABEL, "TODO: Add description", METRIC_CHOICES, METRIC_DEFAULT_CHOICE));
		parameterTypes.add(new ParameterTypeString(OUTPUTDIR_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeInt(PRECISION_LABEL, "TODO: Add description", -100000000, 100000000, 100, true));
		parameterTypes.add(new ParameterTypeInt(SEED_LABEL, "TODO: Add description", -100000000, 100000000, 0, true));
		return parameterTypes;
	}

	@Override
	public String getOutputPattern(String type) {
		// TODO Use a dictionary to reflect type to pattern
		if (type=="sensspec") return "[filename],[clustertag],sensspec";
		if (type=="steps") return "[filename],[clustertag],steps";
		if (type=="list") return "[filename],[clustertag],list-[filename],[clustertag],[tag2],list";
		// TODO if nil then 
		return super.getOutputPattern(type);
	}
}
