package com.rapidminer.ngs.operator;

import java.util.List;
import com.rapidminer.operator.OperatorDescription;
import com.rapidminer.operator.ports.InputPort;
import com.rapidminer.operator.ports.OutputPort;
import com.rapidminer.operator.OperatorException;
import com.rapidminer.parameter.*;

public class MothurVennOperator extends MothurGeneratedOperator {

	private InputPort listInPort = getInputPorts().createPort("list");
	private InputPort sharedInPort = getInputPorts().createPort("shared");
	private OutputPort svgOutPort = getOutputPorts().createPort("svg");
	private static final String ABUND_LABEL = "abund:";
	private static final String CALC_LABEL = "calc:";
	private static final String FONTSIZE_LABEL = "fontsize:";
	private static final String GROUPS_LABEL = "groups:";
	private static final String INPUTDIR_LABEL = "inputdir:";
	private static final String LABEL_LABEL = "label:";
	private static final String NSEQS_LABEL = "nseqs:";
	private static final String OUTPUTDIR_LABEL = "outputdir:";
	public static final String[] PERMUTE_CHOICES = { "1", "2", "3", "4" };
	public static final int PERMUTE_DEFAULT_CHOICE = 3;
	private static final String PERMUTE_LABEL = "permute:";
	private static final String SEED_LABEL = "seed:";
	private static final String SHAREDOTUS_LABEL = "sharedotus:";

	public MothurVennOperator (OperatorDescription description) {
		super(description);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void doWork() throws OperatorException {
		super.doWork();
		clearArguments();
		FileNameObject listFile = listInPort.getData(FileNameObject.class);
		addArgument("list",listFile.getName());
		FileNameObject sharedFile = sharedInPort.getData(FileNameObject.class);
		addArgument("shared",sharedFile.getName());
		int abundValue = getParameterAsInt(ABUND_LABEL);
		addArgument("abund",String.valueOf(abundValue));
		String calcValue = getParameterAsString(CALC_LABEL);
		addArgument("calc",String.valueOf(calcValue));
		int fontsizeValue = getParameterAsInt(FONTSIZE_LABEL);
		addArgument("fontsize",String.valueOf(fontsizeValue));
		String groupsValue = getParameterAsString(GROUPS_LABEL);
		addArgument("groups",String.valueOf(groupsValue));
		String inputdirValue = getParameterAsString(INPUTDIR_LABEL);
		addArgument("inputdir",String.valueOf(inputdirValue));
		String labelValue = getParameterAsString(LABEL_LABEL);
		addArgument("label",String.valueOf(labelValue));
		boolean nseqsValue = getParameterAsBoolean(NSEQS_LABEL);
		addArgument("nseqs",String.valueOf(nseqsValue));
		String outputdirValue = getParameterAsString(OUTPUTDIR_LABEL);
		addArgument("outputdir",String.valueOf(outputdirValue));
		int permuteIndex = getParameterAsInt(PERMUTE_LABEL);
		String permuteValue = PERMUTE_CHOICES[permuteIndex];
		addArgument("permute",String.valueOf(permuteValue));
		int seedValue = getParameterAsInt(SEED_LABEL);
		addArgument("seed",String.valueOf(seedValue));
		boolean sharedotusValue = getParameterAsBoolean(SHAREDOTUS_LABEL);
		addArgument("sharedotus",String.valueOf(sharedotusValue));
		executeMothurCommand();
		String fileName="<fileName>"; // TODO: Somehow figure out the fileName
		svgOutPort.deliver(new FileNameObject(fileName+".svg","svg"));
	}

	@Override
	public List<ParameterType> getParameterTypes() {
		List<ParameterType> parameterTypes = super.getParameterTypes();
		parameterTypes.add(new ParameterTypeInt(ABUND_LABEL, "TODO: Add description", -100000000, 100000000, 10, true));
		parameterTypes.add(new ParameterTypeString(CALC_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeInt(FONTSIZE_LABEL, "TODO: Add description", -100000000, 100000000, 24, true));
		parameterTypes.add(new ParameterTypeString(GROUPS_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeString(INPUTDIR_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeString(LABEL_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeBoolean(NSEQS_LABEL, "TODO: Add description", false, true));
		parameterTypes.add(new ParameterTypeString(OUTPUTDIR_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeCategory(PERMUTE_LABEL, "TODO: Add description", PERMUTE_CHOICES, PERMUTE_DEFAULT_CHOICE));
		parameterTypes.add(new ParameterTypeInt(SEED_LABEL, "TODO: Add description", -100000000, 100000000, 0, true));
		parameterTypes.add(new ParameterTypeBoolean(SHAREDOTUS_LABEL, "TODO: Add description", true, true));
		return parameterTypes;
	}

	@Override
	public String getOutputPattern(String type) {
		// TODO Use a dictionary to reflect type to pattern
		if (type=="svg") return "[filename],svg";
		// TODO if nil then 
		return super.getOutputPattern(type);
	}
}
