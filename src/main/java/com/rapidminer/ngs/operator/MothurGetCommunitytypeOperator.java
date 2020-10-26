package com.rapidminer.ngs.operator;

import java.util.List;
import com.rapidminer.operator.OperatorDescription;
import com.rapidminer.operator.ports.InputPort;
import com.rapidminer.operator.ports.OutputPort;
import com.rapidminer.operator.OperatorException;
import com.rapidminer.parameter.*;

public class MothurGetCommunitytypeOperator extends MothurGeneratedOperator {

	private InputPort sharedInPort = getInputPorts().createPort("shared");
	private OutputPort designOutPort = getOutputPorts().createPort("design");
	private OutputPort fitOutPort = getOutputPorts().createPort("fit");
	private OutputPort matrixOutPort = getOutputPorts().createPort("matrix");
	private OutputPort parametersOutPort = getOutputPorts().createPort("parameters");
	private OutputPort relabundOutPort = getOutputPorts().createPort("relabund");
	private OutputPort summaryOutPort = getOutputPorts().createPort("summary");
	private static final String GROUPS_LABEL = "groups:";
	private static final String LABEL_LABEL = "label:";
	private static final String[] CALC_CHOICES = { "sharedsobs", "sharedchao", "sharedace", "jabund", "sorabund", "jclass", "sorclass", "jest", "sorest", "thetayc", "thetan", "kstest", "sharednseqs", "ochiai", "anderberg", "kulczynski", "kulczynskicody", "lennon", "morisitahorn", "braycurtis", "whittaker", "odum", "canberra", "structeuclidean", "structchord", "hellinger", "manhattan", "structpearson", "soergel", "spearman", "structkulczynski", "speciesprofile", "hamming", "structchi2", "gower", "memchi2", "memchord", "memeuclidean", "mempearson", "jsd", "rjsd" };
	private static final int CALC_DEFAULT_CHOICE = 40;
	private static final String CALC_LABEL = "calc:";
	private static final String SUBSAMPLE_LABEL = "subsample:";
	private static final String ITERS_LABEL = "iters:";
	private static final String MINPARTITIONS_LABEL = "minpartitions:";
	private static final String MAXPARTITIONS_LABEL = "maxpartitions:";
	private static final String OPTIMIZEGAP_LABEL = "optimizegap:";
	private static final String WITHREPLACEMENT_LABEL = "withreplacement:";
	private static final String SEED_LABEL = "seed:";
	private static final String INPUTDIR_LABEL = "inputdir:";
	private static final String OUTPUTDIR_LABEL = "outputdir:";
	private static final String[] METHOD_CHOICES = { "dmm", "kmeans", "pam" };
	private static final int METHOD_DEFAULT_CHOICE = 0;
	private static final String METHOD_LABEL = "method:";

	public MothurGetCommunitytypeOperator (OperatorDescription description) {
		super(description);
		// NOTE: Auto-generated constructor stub
	}

	@Override
	public void doWork() throws OperatorException {
		super.doWork();
		clearArguments();
		FileNameObject sharedFile = sharedInPort.getData(FileNameObject.class);
		addArgument("shared",sharedFile.getName());
		String groupsValue = getParameterAsString(GROUPS_LABEL);
		addArgument("groups",String.valueOf(groupsValue));
		String labelValue = getParameterAsString(LABEL_LABEL);
		addArgument("label",String.valueOf(labelValue));
		int calcIndex = getParameterAsInt(CALC_LABEL);
		String calcValue = CALC_CHOICES[calcIndex];
		addArgument("calc",String.valueOf(calcValue));
		String subsampleValue = getParameterAsString(SUBSAMPLE_LABEL);
		addArgument("subsample",String.valueOf(subsampleValue));
		int itersValue = getParameterAsInt(ITERS_LABEL);
		addArgument("iters",String.valueOf(itersValue));
		int minpartitionsValue = getParameterAsInt(MINPARTITIONS_LABEL);
		addArgument("minpartitions",String.valueOf(minpartitionsValue));
		int maxpartitionsValue = getParameterAsInt(MAXPARTITIONS_LABEL);
		addArgument("maxpartitions",String.valueOf(maxpartitionsValue));
		int optimizegapValue = getParameterAsInt(OPTIMIZEGAP_LABEL);
		addArgument("optimizegap",String.valueOf(optimizegapValue));
		boolean withreplacementValue = getParameterAsBoolean(WITHREPLACEMENT_LABEL);
		addArgument("withreplacement",String.valueOf(withreplacementValue));
		int seedValue = getParameterAsInt(SEED_LABEL);
		addArgument("seed",String.valueOf(seedValue));
		String inputdirValue = getParameterAsString(INPUTDIR_LABEL);
		addArgument("inputdir",String.valueOf(inputdirValue));
		String outputdirValue = getParameterAsString(OUTPUTDIR_LABEL);
		addArgument("outputdir",String.valueOf(outputdirValue));
		int methodIndex = getParameterAsInt(METHOD_LABEL);
		String methodValue = METHOD_CHOICES[methodIndex];
		addArgument("method",String.valueOf(methodValue));
		executeMothurCommand();
		String fileName="<fileName>"; // TODO: Somehow figure out the fileName
		designOutPort.deliver(new FileNameObject(fileName+".design","design"));
		fitOutPort.deliver(new FileNameObject(fileName+".fit","fit"));
		matrixOutPort.deliver(new FileNameObject(fileName+".matrix","matrix"));
		parametersOutPort.deliver(new FileNameObject(fileName+".parameters","parameters"));
		relabundOutPort.deliver(new FileNameObject(fileName+".relabund","relabund"));
		summaryOutPort.deliver(new FileNameObject(fileName+".summary","summary"));
	}

	@Override
	public List<ParameterType> getParameterTypes() {
		List<ParameterType> parameterTypes = super.getParameterTypes();
		parameterTypes.add(new ParameterTypeString(GROUPS_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeString(LABEL_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeCategory(CALC_LABEL, "TODO: Add description", CALC_CHOICES, CALC_DEFAULT_CHOICE));
		parameterTypes.add(new ParameterTypeString(SUBSAMPLE_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeInt(ITERS_LABEL, "TODO: Add description", -100000000, 100000000, 1000, true));
		parameterTypes.add(new ParameterTypeInt(MINPARTITIONS_LABEL, "TODO: Add description", -100000000, 100000000, 5, true));
		parameterTypes.add(new ParameterTypeInt(MAXPARTITIONS_LABEL, "TODO: Add description", -100000000, 100000000, 100, true));
		parameterTypes.add(new ParameterTypeInt(OPTIMIZEGAP_LABEL, "TODO: Add description", -100000000, 100000000, 3, true));
		parameterTypes.add(new ParameterTypeBoolean(WITHREPLACEMENT_LABEL, "TODO: Add description", false, true));
		parameterTypes.add(new ParameterTypeInt(SEED_LABEL, "TODO: Add description", -100000000, 100000000, 0, true));
		parameterTypes.add(new ParameterTypeString(INPUTDIR_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeString(OUTPUTDIR_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeCategory(METHOD_LABEL, "TODO: Add description", METHOD_CHOICES, METHOD_DEFAULT_CHOICE));
		return parameterTypes;
	}

	@Override
	public String getOutputPattern(String type) {
		if (type.equals("summary")) return "[filename],[distance],[method],mix.summary";
		if (type.equals("fit")) return "[filename],[distance],[method],mix.fit";
		if (type.equals("parameters")) return "[filename],[distance],[method],mix.parameters";
		if (type.equals("matrix")) return "[filename],[distance],[method],[tag],mix.posterior";
		if (type.equals("relabund")) return "[filename],[distance],[method],[tag],mix.relabund";
		if (type.equals("design")) return "[filename],[distance],[method],mix.design";
		return super.getOutputPattern(type);
	}
}
