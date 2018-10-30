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
	private OutputPort matrixOutPort = getOutputPorts().createPort("matrix");
	private OutputPort summaryOutPort = getOutputPorts().createPort("summary");
	private OutputPort relabundOutPort = getOutputPorts().createPort("relabund");
	private OutputPort fitOutPort = getOutputPorts().createPort("fit");
	private OutputPort parametersOutPort = getOutputPorts().createPort("parameters");
	public static final String[] CALC_CHOICES = { "anderberg", "braycurtis", "canberra", "gower", "hamming", "hellinger", "jabund", "jclass", "jest", "jsd", "kstest", "kulczynski", "kulczynskicody", "lennon", "manhattan", "memchi2", "memchord", "memeuclidean", "mempearson", "morisitahorn", "ochiai", "odum", "rjsd", "sharedace", "sharedchao", "sharednseqs", "sharedsobs", "soergel", "sorabund", "sorclass", "sorest", "spearman", "speciesprofile", "structchi2", "structchord", "structeuclidean", "structkulczynski", "structpearson", "thetan", "thetayc", "whittaker" };
	public static final int CALC_DEFAULT_CHOICE = 22;
	private static final String CALC_LABEL = "calc:";
	private static final String GROUPS_LABEL = "groups:";
	private static final String INPUTDIR_LABEL = "inputdir:";
	private static final String ITERS_LABEL = "iters:";
	private static final String LABEL_LABEL = "label:";
	private static final String MAXPARTITIONS_LABEL = "maxpartitions:";
	public static final String[] METHOD_CHOICES = { "dmm", "kmeans", "pam" };
	public static final int METHOD_DEFAULT_CHOICE = 0;
	private static final String METHOD_LABEL = "method:";
	private static final String MINPARTITIONS_LABEL = "minpartitions:";
	private static final String OPTIMIZEGAP_LABEL = "optimizegap:";
	private static final String OUTPUTDIR_LABEL = "outputdir:";
	private static final String SEED_LABEL = "seed:";
	private static final String SUBSAMPLE_LABEL = "subsample:";

	public MothurGetCommunitytypeOperator (OperatorDescription description) {
		super(description);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void doWork() throws OperatorException {
		super.doWork();
		clearArguments();
		FileNameObject sharedFile = sharedInPort.getData(FileNameObject.class);
		addArgument("shared",sharedFile.getName());
		int calcIndex = getParameterAsInt(CALC_LABEL);
		String calcValue = CALC_CHOICES[calcIndex];
		addArgument("calc",String.valueOf(calcValue));
		String groupsValue = getParameterAsString(GROUPS_LABEL);
		addArgument("groups",String.valueOf(groupsValue));
		String inputdirValue = getParameterAsString(INPUTDIR_LABEL);
		addArgument("inputdir",String.valueOf(inputdirValue));
		int itersValue = getParameterAsInt(ITERS_LABEL);
		addArgument("iters",String.valueOf(itersValue));
		String labelValue = getParameterAsString(LABEL_LABEL);
		addArgument("label",String.valueOf(labelValue));
		int maxpartitionsValue = getParameterAsInt(MAXPARTITIONS_LABEL);
		addArgument("maxpartitions",String.valueOf(maxpartitionsValue));
		int methodIndex = getParameterAsInt(METHOD_LABEL);
		String methodValue = METHOD_CHOICES[methodIndex];
		addArgument("method",String.valueOf(methodValue));
		int minpartitionsValue = getParameterAsInt(MINPARTITIONS_LABEL);
		addArgument("minpartitions",String.valueOf(minpartitionsValue));
		int optimizegapValue = getParameterAsInt(OPTIMIZEGAP_LABEL);
		addArgument("optimizegap",String.valueOf(optimizegapValue));
		String outputdirValue = getParameterAsString(OUTPUTDIR_LABEL);
		addArgument("outputdir",String.valueOf(outputdirValue));
		int seedValue = getParameterAsInt(SEED_LABEL);
		addArgument("seed",String.valueOf(seedValue));
		String subsampleValue = getParameterAsString(SUBSAMPLE_LABEL);
		addArgument("subsample",String.valueOf(subsampleValue));
		executeMothurCommand();
		String fileName="<fileName>"; // TODO: Somehow figure out the fileName
		designOutPort.deliver(new FileNameObject(fileName+".design","design"));
		matrixOutPort.deliver(new FileNameObject(fileName+".matrix","matrix"));
		summaryOutPort.deliver(new FileNameObject(fileName+".summary","summary"));
		relabundOutPort.deliver(new FileNameObject(fileName+".relabund","relabund"));
		fitOutPort.deliver(new FileNameObject(fileName+".fit","fit"));
		parametersOutPort.deliver(new FileNameObject(fileName+".parameters","parameters"));
	}

	@Override
	public List<ParameterType> getParameterTypes() {
		List<ParameterType> parameterTypes = super.getParameterTypes();
		parameterTypes.add(new ParameterTypeCategory(CALC_LABEL, "TODO: Add description", CALC_CHOICES, CALC_DEFAULT_CHOICE));
		parameterTypes.add(new ParameterTypeString(GROUPS_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeString(INPUTDIR_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeInt(ITERS_LABEL, "TODO: Add description", -100000000, 100000000, 1000, true));
		parameterTypes.add(new ParameterTypeString(LABEL_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeInt(MAXPARTITIONS_LABEL, "TODO: Add description", -100000000, 100000000, 100, true));
		parameterTypes.add(new ParameterTypeCategory(METHOD_LABEL, "TODO: Add description", METHOD_CHOICES, METHOD_DEFAULT_CHOICE));
		parameterTypes.add(new ParameterTypeInt(MINPARTITIONS_LABEL, "TODO: Add description", -100000000, 100000000, 5, true));
		parameterTypes.add(new ParameterTypeInt(OPTIMIZEGAP_LABEL, "TODO: Add description", -100000000, 100000000, 3, true));
		parameterTypes.add(new ParameterTypeString(OUTPUTDIR_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeInt(SEED_LABEL, "TODO: Add description", -100000000, 100000000, 0, true));
		parameterTypes.add(new ParameterTypeString(SUBSAMPLE_LABEL, "TODO: Add description", "", true));
		return parameterTypes;
	}

	@Override
	public String getOutputPattern(String type) {
		// TODO Use a dictionary to reflect type to pattern
		if (type=="design") return "[filename],[distance],[method],mix.design";
		if (type=="matrix") return "[filename],[distance],[method],[tag],mix.posterior";
		if (type=="summary") return "[filename],[distance],[method],mix.summary";
		if (type=="relabund") return "[filename],[distance],[method],[tag],mix.relabund";
		if (type=="fit") return "[filename],[distance],[method],mix.fit";
		if (type=="parameters") return "[filename],[distance],[method],mix.parameters";
		// TODO if nil then 
		return super.getOutputPattern(type);
	}
}
