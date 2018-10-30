package com.rapidminer.ngs.operator;

import java.util.List;
import com.rapidminer.operator.OperatorDescription;
import com.rapidminer.operator.ports.InputPort;
import com.rapidminer.operator.ports.OutputPort;
import com.rapidminer.operator.OperatorException;
import com.rapidminer.parameter.*;

public class MothurLibshuffOperator extends MothurGeneratedOperator {

	private InputPort groupInPort = getInputPorts().createPort("group");
	private InputPort phylipInPort = getInputPorts().createPort("phylip");
	private OutputPort libshuffsummaryOutPort = getOutputPorts().createPort("libshuffsummary");
	private OutputPort coverageOutPort = getOutputPorts().createPort("coverage");
	private static final String CUTOFF_LABEL = "cutoff:";
	public static final String[] FORM_CHOICES = { "discrete", "integral" };
	public static final int FORM_DEFAULT_CHOICE = 1;
	private static final String FORM_LABEL = "form:";
	private static final String GROUPS_LABEL = "groups:";
	private static final String INPUTDIR_LABEL = "inputdir:";
	private static final String ITERS_LABEL = "iters:";
	private static final String OUTPUTDIR_LABEL = "outputdir:";
	private static final String SEED_LABEL = "seed:";
	private static final String SIM_LABEL = "sim:";
	private static final String STEP_LABEL = "step:";

	public MothurLibshuffOperator (OperatorDescription description) {
		super(description);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void doWork() throws OperatorException {
		super.doWork();
		clearArguments();
		FileNameObject groupFile = groupInPort.getData(FileNameObject.class);
		addArgument("group",groupFile.getName());
		FileNameObject phylipFile = phylipInPort.getData(FileNameObject.class);
		addArgument("phylip",phylipFile.getName());
		int cutoffValue = getParameterAsInt(CUTOFF_LABEL);
		addArgument("cutoff",String.valueOf(cutoffValue));
		int formIndex = getParameterAsInt(FORM_LABEL);
		String formValue = FORM_CHOICES[formIndex];
		addArgument("form",String.valueOf(formValue));
		String groupsValue = getParameterAsString(GROUPS_LABEL);
		addArgument("groups",String.valueOf(groupsValue));
		String inputdirValue = getParameterAsString(INPUTDIR_LABEL);
		addArgument("inputdir",String.valueOf(inputdirValue));
		int itersValue = getParameterAsInt(ITERS_LABEL);
		addArgument("iters",String.valueOf(itersValue));
		String outputdirValue = getParameterAsString(OUTPUTDIR_LABEL);
		addArgument("outputdir",String.valueOf(outputdirValue));
		int seedValue = getParameterAsInt(SEED_LABEL);
		addArgument("seed",String.valueOf(seedValue));
		boolean simValue = getParameterAsBoolean(SIM_LABEL);
		addArgument("sim",String.valueOf(simValue));
		int stepValue = getParameterAsInt(STEP_LABEL);
		addArgument("step",String.valueOf(stepValue));
		executeMothurCommand();
		String fileName="<fileName>"; // TODO: Somehow figure out the fileName
		libshuffsummaryOutPort.deliver(new FileNameObject(fileName+".libshuffsummary","libshuffsummary"));
		coverageOutPort.deliver(new FileNameObject(fileName+".coverage","coverage"));
	}

	@Override
	public List<ParameterType> getParameterTypes() {
		List<ParameterType> parameterTypes = super.getParameterTypes();
		parameterTypes.add(new ParameterTypeDouble(CUTOFF_LABEL, "TODO: Add description", -100000000, 100000000, 1.0, true));
		parameterTypes.add(new ParameterTypeCategory(FORM_LABEL, "TODO: Add description", FORM_CHOICES, FORM_DEFAULT_CHOICE));
		parameterTypes.add(new ParameterTypeString(GROUPS_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeString(INPUTDIR_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeInt(ITERS_LABEL, "TODO: Add description", -100000000, 100000000, 10000, true));
		parameterTypes.add(new ParameterTypeString(OUTPUTDIR_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeInt(SEED_LABEL, "TODO: Add description", -100000000, 100000000, 0, true));
		parameterTypes.add(new ParameterTypeBoolean(SIM_LABEL, "TODO: Add description", false, true));
		parameterTypes.add(new ParameterTypeDouble(STEP_LABEL, "TODO: Add description", -100000000, 100000000, 0.01, true));
		return parameterTypes;
	}

	@Override
	public String getOutputPattern(String type) {
		// TODO Use a dictionary to reflect type to pattern
		if (type=="libshuffsummary") return "[filename],libshuff.summary";
		if (type=="coverage") return "[filename],libshuff.coverage";
		// TODO if nil then 
		return super.getOutputPattern(type);
	}
}
