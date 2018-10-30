package com.rapidminer.ngs.operator;

import java.util.List;
import com.rapidminer.operator.OperatorDescription;
import com.rapidminer.operator.ports.InputPort;
import com.rapidminer.operator.ports.OutputPort;
import com.rapidminer.operator.OperatorException;
import com.rapidminer.parameter.*;

public class MothurSparccOperator extends MothurGeneratedOperator {

	private InputPort sharedInPort = getInputPorts().createPort("shared");
	private OutputPort sparccrelabundOutPort = getOutputPorts().createPort("sparccrelabund");
	private OutputPort pvalueOutPort = getOutputPorts().createPort("pvalue");
	private OutputPort corrOutPort = getOutputPorts().createPort("corr");
	private static final String GROUPS_LABEL = "groups:";
	private static final String INPUTDIR_LABEL = "inputdir:";
	private static final String ITERATIONS_LABEL = "iterations:";
	private static final String LABEL_LABEL = "label:";
	public static final String[] METHOD_CHOICES = { "dirichlet", "relabund" };
	public static final int METHOD_DEFAULT_CHOICE = 0;
	private static final String METHOD_LABEL = "method:";
	private static final String OUTPUTDIR_LABEL = "outputdir:";
	private static final String PERMUTATIONS_LABEL = "permutations:";
	private static final String PROCESSORS_LABEL = "processors:";
	private static final String SAMPLINGS_LABEL = "samplings:";
	private static final String SEED_LABEL = "seed:";

	public MothurSparccOperator (OperatorDescription description) {
		super(description);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void doWork() throws OperatorException {
		super.doWork();
		clearArguments();
		FileNameObject sharedFile = sharedInPort.getData(FileNameObject.class);
		addArgument("shared",sharedFile.getName());
		String groupsValue = getParameterAsString(GROUPS_LABEL);
		addArgument("groups",String.valueOf(groupsValue));
		String inputdirValue = getParameterAsString(INPUTDIR_LABEL);
		addArgument("inputdir",String.valueOf(inputdirValue));
		int iterationsValue = getParameterAsInt(ITERATIONS_LABEL);
		addArgument("iterations",String.valueOf(iterationsValue));
		String labelValue = getParameterAsString(LABEL_LABEL);
		addArgument("label",String.valueOf(labelValue));
		int methodIndex = getParameterAsInt(METHOD_LABEL);
		String methodValue = METHOD_CHOICES[methodIndex];
		addArgument("method",String.valueOf(methodValue));
		String outputdirValue = getParameterAsString(OUTPUTDIR_LABEL);
		addArgument("outputdir",String.valueOf(outputdirValue));
		int permutationsValue = getParameterAsInt(PERMUTATIONS_LABEL);
		addArgument("permutations",String.valueOf(permutationsValue));
		int processorsValue = getParameterAsInt(PROCESSORS_LABEL);
		addArgument("processors",String.valueOf(processorsValue));
		int samplingsValue = getParameterAsInt(SAMPLINGS_LABEL);
		addArgument("samplings",String.valueOf(samplingsValue));
		int seedValue = getParameterAsInt(SEED_LABEL);
		addArgument("seed",String.valueOf(seedValue));
		executeMothurCommand();
		String fileName="<fileName>"; // TODO: Somehow figure out the fileName
		sparccrelabundOutPort.deliver(new FileNameObject(fileName+".sparccrelabund","sparccrelabund"));
		pvalueOutPort.deliver(new FileNameObject(fileName+".pvalue","pvalue"));
		corrOutPort.deliver(new FileNameObject(fileName+".corr","corr"));
	}

	@Override
	public List<ParameterType> getParameterTypes() {
		List<ParameterType> parameterTypes = super.getParameterTypes();
		parameterTypes.add(new ParameterTypeString(GROUPS_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeString(INPUTDIR_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeInt(ITERATIONS_LABEL, "TODO: Add description", -100000000, 100000000, 10, true));
		parameterTypes.add(new ParameterTypeString(LABEL_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeCategory(METHOD_LABEL, "TODO: Add description", METHOD_CHOICES, METHOD_DEFAULT_CHOICE));
		parameterTypes.add(new ParameterTypeString(OUTPUTDIR_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeInt(PERMUTATIONS_LABEL, "TODO: Add description", -100000000, 100000000, 1000, true));
		parameterTypes.add(new ParameterTypeInt(PROCESSORS_LABEL, "TODO: Add description", -100000000, 100000000, 1, true));
		parameterTypes.add(new ParameterTypeInt(SAMPLINGS_LABEL, "TODO: Add description", -100000000, 100000000, 20, true));
		parameterTypes.add(new ParameterTypeInt(SEED_LABEL, "TODO: Add description", -100000000, 100000000, 0, true));
		return parameterTypes;
	}

	@Override
	public String getOutputPattern(String type) {
		// TODO Use a dictionary to reflect type to pattern
		if (type=="sparccrelabund") return "[filename],[distance],sparcc_relabund";
		if (type=="pvalue") return "[filename],[distance],sparcc_pvalue";
		if (type=="corr") return "[filename],[distance],sparcc_correlation";
		// TODO if nil then 
		return super.getOutputPattern(type);
	}
}
