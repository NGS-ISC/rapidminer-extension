package com.rapidminer.ngs.operator;

import java.util.List;
import com.rapidminer.operator.OperatorDescription;
import com.rapidminer.operator.ports.InputPort;
import com.rapidminer.operator.ports.OutputPort;
import com.rapidminer.operator.OperatorException;
import com.rapidminer.parameter.*;

public class MothurClusterFitOperator extends MothurGeneratedOperator {

	private InputPort reflistInPort = getInputPorts().createPort("reflist");
	private InputPort fastaInPort = getInputPorts().createPort("fasta");
	private InputPort reffastaInPort = getInputPorts().createPort("reffasta");
	private InputPort nameInPort = getInputPorts().createPort("name");
	private InputPort countInPort = getInputPorts().createPort("count");
	private InputPort refnameInPort = getInputPorts().createPort("refname");
	private InputPort refcountInPort = getInputPorts().createPort("refcount");
	private InputPort refcolumnInPort = getInputPorts().createPort("refcolumn");
	private InputPort columnInPort = getInputPorts().createPort("column");
	private InputPort accnosInPort = getInputPorts().createPort("accnos");
	private OutputPort listOutPort = getOutputPorts().createPort("list");
	private OutputPort sensspecOutPort = getOutputPorts().createPort("sensspec");
	private OutputPort stepsOutPort = getOutputPorts().createPort("steps");
	private static final String CUTOFF_LABEL = "cutoff:";
	private static final String PRECISION_LABEL = "precision:";
	private static final String[] METHOD_CHOICES = { "closed", "open" };
	private static final int METHOD_DEFAULT_CHOICE = 0;
	private static final String METHOD_LABEL = "method:";
	private static final String[] CRITERIA_CHOICES = { "fit", "combo", "both" };
	private static final int CRITERIA_DEFAULT_CHOICE = 2;
	private static final String CRITERIA_LABEL = "criteria:";
	private static final String[] METRIC_CHOICES = { "mcc", "sens", "spec", "tptn", "fpfn", "tp", "tn", "fp", "fn", "f1score", "accuracy", "ppv", "npv", "fdr" };
	private static final int METRIC_DEFAULT_CHOICE = 0;
	private static final String METRIC_LABEL = "metric:";
	private static final String DELTA_LABEL = "delta:";
	private static final String ITERS_LABEL = "iters:";
	private static final String DENOVOITERS_LABEL = "denovoiters:";
	private static final String FITPERCENT_LABEL = "fitpercent:";
	private static final String SEED_LABEL = "seed:";
	private static final String PRINTREF_LABEL = "printref:";
	private static final String INPUTDIR_LABEL = "inputdir:";
	private static final String OUTPUTDIR_LABEL = "outputdir:";

	public MothurClusterFitOperator (OperatorDescription description) {
		super(description);
		// NOTE: Auto-generated constructor stub
	}

	@Override
	public void doWork() throws OperatorException {
		super.doWork();
		clearArguments();
		FileNameObject reflistFile = reflistInPort.getData(FileNameObject.class);
		addArgument("reflist",reflistFile.getName());
		FileNameObject fastaFile = fastaInPort.getData(FileNameObject.class);
		addArgument("fasta",fastaFile.getName());
		FileNameObject reffastaFile = reffastaInPort.getData(FileNameObject.class);
		addArgument("reffasta",reffastaFile.getName());
		FileNameObject nameFile = nameInPort.getData(FileNameObject.class);
		addArgument("name",nameFile.getName());
		FileNameObject countFile = countInPort.getData(FileNameObject.class);
		addArgument("count",countFile.getName());
		FileNameObject refnameFile = refnameInPort.getData(FileNameObject.class);
		addArgument("refname",refnameFile.getName());
		FileNameObject refcountFile = refcountInPort.getData(FileNameObject.class);
		addArgument("refcount",refcountFile.getName());
		FileNameObject refcolumnFile = refcolumnInPort.getData(FileNameObject.class);
		addArgument("refcolumn",refcolumnFile.getName());
		FileNameObject columnFile = columnInPort.getData(FileNameObject.class);
		addArgument("column",columnFile.getName());
		FileNameObject accnosFile = accnosInPort.getData(FileNameObject.class);
		addArgument("accnos",accnosFile.getName());
		int cutoffValue = getParameterAsInt(CUTOFF_LABEL);
		addArgument("cutoff",String.valueOf(cutoffValue));
		int precisionValue = getParameterAsInt(PRECISION_LABEL);
		addArgument("precision",String.valueOf(precisionValue));
		int methodIndex = getParameterAsInt(METHOD_LABEL);
		String methodValue = METHOD_CHOICES[methodIndex];
		addArgument("method",String.valueOf(methodValue));
		int criteriaIndex = getParameterAsInt(CRITERIA_LABEL);
		String criteriaValue = CRITERIA_CHOICES[criteriaIndex];
		addArgument("criteria",String.valueOf(criteriaValue));
		int metricIndex = getParameterAsInt(METRIC_LABEL);
		String metricValue = METRIC_CHOICES[metricIndex];
		addArgument("metric",String.valueOf(metricValue));
		int deltaValue = getParameterAsInt(DELTA_LABEL);
		addArgument("delta",String.valueOf(deltaValue));
		int itersValue = getParameterAsInt(ITERS_LABEL);
		addArgument("iters",String.valueOf(itersValue));
		int denovoitersValue = getParameterAsInt(DENOVOITERS_LABEL);
		addArgument("denovoiters",String.valueOf(denovoitersValue));
		int fitpercentValue = getParameterAsInt(FITPERCENT_LABEL);
		addArgument("fitpercent",String.valueOf(fitpercentValue));
		int seedValue = getParameterAsInt(SEED_LABEL);
		addArgument("seed",String.valueOf(seedValue));
		boolean printrefValue = getParameterAsBoolean(PRINTREF_LABEL);
		addArgument("printref",String.valueOf(printrefValue));
		String inputdirValue = getParameterAsString(INPUTDIR_LABEL);
		addArgument("inputdir",String.valueOf(inputdirValue));
		String outputdirValue = getParameterAsString(OUTPUTDIR_LABEL);
		addArgument("outputdir",String.valueOf(outputdirValue));
		executeMothurCommand();
		String fileName="<fileName>"; // TODO: Somehow figure out the fileName
		listOutPort.deliver(new FileNameObject(fileName+".list","list"));
		sensspecOutPort.deliver(new FileNameObject(fileName+".sensspec","sensspec"));
		stepsOutPort.deliver(new FileNameObject(fileName+".steps","steps"));
	}

	@Override
	public List<ParameterType> getParameterTypes() {
		List<ParameterType> parameterTypes = super.getParameterTypes();
		parameterTypes.add(new ParameterTypeDouble(CUTOFF_LABEL, "TODO: Add description", -100000000, 100000000, 0.03, true));
		parameterTypes.add(new ParameterTypeInt(PRECISION_LABEL, "TODO: Add description", -100000000, 100000000, 100, true));
		parameterTypes.add(new ParameterTypeCategory(METHOD_LABEL, "TODO: Add description", METHOD_CHOICES, METHOD_DEFAULT_CHOICE));
		parameterTypes.add(new ParameterTypeCategory(CRITERIA_LABEL, "TODO: Add description", CRITERIA_CHOICES, CRITERIA_DEFAULT_CHOICE));
		parameterTypes.add(new ParameterTypeCategory(METRIC_LABEL, "TODO: Add description", METRIC_CHOICES, METRIC_DEFAULT_CHOICE));
		parameterTypes.add(new ParameterTypeDouble(DELTA_LABEL, "TODO: Add description", -100000000, 100000000, 0.0001, true));
		parameterTypes.add(new ParameterTypeInt(ITERS_LABEL, "TODO: Add description", -100000000, 100000000, 100, true));
		parameterTypes.add(new ParameterTypeInt(DENOVOITERS_LABEL, "TODO: Add description", -100000000, 100000000, 100, true));
		parameterTypes.add(new ParameterTypeInt(FITPERCENT_LABEL, "TODO: Add description", -100000000, 100000000, 10, true));
		parameterTypes.add(new ParameterTypeInt(SEED_LABEL, "TODO: Add description", -100000000, 100000000, 0, true));
		parameterTypes.add(new ParameterTypeBoolean(PRINTREF_LABEL, "TODO: Add description", false, true));
		parameterTypes.add(new ParameterTypeString(INPUTDIR_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeString(OUTPUTDIR_LABEL, "TODO: Add description", "", true));
		return parameterTypes;
	}

	@Override
	public String getOutputPattern(String type) {
		if (type.equals("sensspec")) return "[filename],sensspec";
		if (type.equals("list")) return "[filename],[clustertag],list-[filename],[clustertag],[tag2],list";
		if (type.equals("steps")) return "[filename],[clustertag],steps";
		return super.getOutputPattern(type);
	}
}
