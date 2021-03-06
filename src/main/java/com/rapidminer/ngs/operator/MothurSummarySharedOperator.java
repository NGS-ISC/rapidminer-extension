package com.rapidminer.ngs.operator;

import java.util.List;
import com.rapidminer.operator.OperatorDescription;
import com.rapidminer.operator.ports.InputPort;
import com.rapidminer.operator.ports.OutputPort;
import com.rapidminer.operator.OperatorException;
import com.rapidminer.parameter.*;

public class MothurSummarySharedOperator extends MothurGeneratedOperator {

	private InputPort sharedInPort = getInputPorts().createPort("shared");
	private OutputPort phylipOutPort = getOutputPorts().createPort("phylip");
	private OutputPort summaryOutPort = getOutputPorts().createPort("summary");
	private static final String LABEL_LABEL = "label:";
	private static final String SUBSAMPLE_LABEL = "subsample:";
	private static final String WITHREPLACEMENT_LABEL = "withreplacement:";
	private static final String DISTANCE_LABEL = "distance:";
	private static final String[] CALC_CHOICES = { "sharedchao", "sharedsobs", "sharedace", "jabund", "sorabund", "jclass", "sorclass", "jest", "sorest", "thetayc", "thetan", "kstest", "whittaker", "sharednseqs", "ochiai", "anderberg", "kulczynski", "kulczynskicody", "lennon", "morisitahorn", "braycurtis", "odum", "canberra", "structeuclidean", "structchord", "hellinger", "manhattan", "structpearson", "soergel", "spearman", "structkulczynski", "speciesprofile", "structchi2", "hamming", "gower", "memchi2", "memchord", "memeuclidean", "mempearson", "jsd", "rjsd" };
	private static final int CALC_DEFAULT_CHOICE = 0;
	private static final String CALC_LABEL = "calc:";
	private static final String[] OUTPUT_CHOICES = { "lt", "square" };
	private static final int OUTPUT_DEFAULT_CHOICE = 0;
	private static final String OUTPUT_LABEL = "output:";
	private static final String ALL_LABEL = "all:";
	private static final String ITERS_LABEL = "iters:";
	private static final String PROCESSORS_LABEL = "processors:";
	private static final String GROUPS_LABEL = "groups:";
	private static final String SEED_LABEL = "seed:";
	private static final String INPUTDIR_LABEL = "inputdir:";
	private static final String OUTPUTDIR_LABEL = "outputdir:";

	public MothurSummarySharedOperator (OperatorDescription description) {
		super(description);
		// NOTE: Auto-generated constructor stub
	}

	@Override
	public void doWork() throws OperatorException {
		super.doWork();
		clearArguments();
		FileNameObject sharedFile = sharedInPort.getData(FileNameObject.class);
		addArgument("shared",sharedFile.getName());
		String labelValue = getParameterAsString(LABEL_LABEL);
		addArgument("label",String.valueOf(labelValue));
		String subsampleValue = getParameterAsString(SUBSAMPLE_LABEL);
		addArgument("subsample",String.valueOf(subsampleValue));
		boolean withreplacementValue = getParameterAsBoolean(WITHREPLACEMENT_LABEL);
		addArgument("withreplacement",String.valueOf(withreplacementValue));
		boolean distanceValue = getParameterAsBoolean(DISTANCE_LABEL);
		addArgument("distance",String.valueOf(distanceValue));
		int calcIndex = getParameterAsInt(CALC_LABEL);
		String calcValue = CALC_CHOICES[calcIndex];
		addArgument("calc",String.valueOf(calcValue));
		int outputIndex = getParameterAsInt(OUTPUT_LABEL);
		String outputValue = OUTPUT_CHOICES[outputIndex];
		addArgument("output",String.valueOf(outputValue));
		boolean allValue = getParameterAsBoolean(ALL_LABEL);
		addArgument("all",String.valueOf(allValue));
		int itersValue = getParameterAsInt(ITERS_LABEL);
		addArgument("iters",String.valueOf(itersValue));
		int processorsValue = getParameterAsInt(PROCESSORS_LABEL);
		addArgument("processors",String.valueOf(processorsValue));
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
		phylipOutPort.deliver(new FileNameObject(fileName+".phylip","phylip"));
		summaryOutPort.deliver(new FileNameObject(fileName+".summary","summary"));
	}

	@Override
	public List<ParameterType> getParameterTypes() {
		List<ParameterType> parameterTypes = super.getParameterTypes();
		parameterTypes.add(new ParameterTypeString(LABEL_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeString(SUBSAMPLE_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeBoolean(WITHREPLACEMENT_LABEL, "TODO: Add description", false, true));
		parameterTypes.add(new ParameterTypeBoolean(DISTANCE_LABEL, "TODO: Add description", false, true));
		parameterTypes.add(new ParameterTypeCategory(CALC_LABEL, "TODO: Add description", CALC_CHOICES, CALC_DEFAULT_CHOICE));
		parameterTypes.add(new ParameterTypeCategory(OUTPUT_LABEL, "TODO: Add description", OUTPUT_CHOICES, OUTPUT_DEFAULT_CHOICE));
		parameterTypes.add(new ParameterTypeBoolean(ALL_LABEL, "TODO: Add description", false, true));
		parameterTypes.add(new ParameterTypeInt(ITERS_LABEL, "TODO: Add description", -100000000, 100000000, 1000, true));
		parameterTypes.add(new ParameterTypeInt(PROCESSORS_LABEL, "TODO: Add description", -100000000, 100000000, 1, true));
		parameterTypes.add(new ParameterTypeString(GROUPS_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeInt(SEED_LABEL, "TODO: Add description", -100000000, 100000000, 0, true));
		parameterTypes.add(new ParameterTypeString(INPUTDIR_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeString(OUTPUTDIR_LABEL, "TODO: Add description", "", true));
		return parameterTypes;
	}

	@Override
	public String getOutputPattern(String type) {
		if (type.equals("summary")) return "[filename],summary-[filename],[tag],summary";
		if (type.equals("phylip")) return "[filename],[calc],[distance],[outputtag],[tag2],dist";
		return super.getOutputPattern(type);
	}
}
