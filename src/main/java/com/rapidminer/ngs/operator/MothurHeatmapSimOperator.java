package com.rapidminer.ngs.operator;

import java.util.List;
import com.rapidminer.operator.OperatorDescription;
import com.rapidminer.operator.ports.InputPort;
import com.rapidminer.operator.ports.OutputPort;
import com.rapidminer.operator.OperatorException;
import com.rapidminer.parameter.*;

public class MothurHeatmapSimOperator extends MothurGeneratedOperator {

	private InputPort sharedInPort = getInputPorts().createPort("shared");
	private InputPort phylipInPort = getInputPorts().createPort("phylip");
	private InputPort nameInPort = getInputPorts().createPort("name");
	private InputPort countInPort = getInputPorts().createPort("count");
	private InputPort columnInPort = getInputPorts().createPort("column");
	private OutputPort svgOutPort = getOutputPorts().createPort("svg");
	private static final String GROUPS_LABEL = "groups:";
	private static final String LABEL_LABEL = "label:";
	private static final String[] CALC_CHOICES = { "jabund", "sorabund", "jclass", "sorclass", "jest", "sorest", "thetayc", "thetan", "morisitahorn", "braycurtis" };
	private static final int CALC_DEFAULT_CHOICE = 0;
	private static final String CALC_LABEL = "calc:";
	private static final String FONTSIZE_LABEL = "fontsize:";
	private static final String SEED_LABEL = "seed:";
	private static final String INPUTDIR_LABEL = "inputdir:";
	private static final String OUTPUTDIR_LABEL = "outputdir:";

	public MothurHeatmapSimOperator (OperatorDescription description) {
		super(description);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void doWork() throws OperatorException {
		super.doWork();
		clearArguments();
		FileNameObject sharedFile = sharedInPort.getData(FileNameObject.class);
		addArgument("shared",sharedFile.getName());
		FileNameObject phylipFile = phylipInPort.getData(FileNameObject.class);
		addArgument("phylip",phylipFile.getName());
		FileNameObject nameFile = nameInPort.getData(FileNameObject.class);
		addArgument("name",nameFile.getName());
		FileNameObject countFile = countInPort.getData(FileNameObject.class);
		addArgument("count",countFile.getName());
		FileNameObject columnFile = columnInPort.getData(FileNameObject.class);
		addArgument("column",columnFile.getName());
		String groupsValue = getParameterAsString(GROUPS_LABEL);
		addArgument("groups",String.valueOf(groupsValue));
		String labelValue = getParameterAsString(LABEL_LABEL);
		addArgument("label",String.valueOf(labelValue));
		int calcIndex = getParameterAsInt(CALC_LABEL);
		String calcValue = CALC_CHOICES[calcIndex];
		addArgument("calc",String.valueOf(calcValue));
		int fontsizeValue = getParameterAsInt(FONTSIZE_LABEL);
		addArgument("fontsize",String.valueOf(fontsizeValue));
		int seedValue = getParameterAsInt(SEED_LABEL);
		addArgument("seed",String.valueOf(seedValue));
		String inputdirValue = getParameterAsString(INPUTDIR_LABEL);
		addArgument("inputdir",String.valueOf(inputdirValue));
		String outputdirValue = getParameterAsString(OUTPUTDIR_LABEL);
		addArgument("outputdir",String.valueOf(outputdirValue));
		executeMothurCommand();
		String fileName="<fileName>"; // TODO: Somehow figure out the fileName
		svgOutPort.deliver(new FileNameObject(fileName+".svg","svg"));
	}

	@Override
	public List<ParameterType> getParameterTypes() {
		List<ParameterType> parameterTypes = super.getParameterTypes();
		parameterTypes.add(new ParameterTypeString(GROUPS_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeString(LABEL_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeCategory(CALC_LABEL, "TODO: Add description", CALC_CHOICES, CALC_DEFAULT_CHOICE));
		parameterTypes.add(new ParameterTypeInt(FONTSIZE_LABEL, "TODO: Add description", -100000000, 100000000, 24, true));
		parameterTypes.add(new ParameterTypeInt(SEED_LABEL, "TODO: Add description", -100000000, 100000000, 0, true));
		parameterTypes.add(new ParameterTypeString(INPUTDIR_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeString(OUTPUTDIR_LABEL, "TODO: Add description", "", true));
		return parameterTypes;
	}

	@Override
	public String getOutputPattern(String type) {
		// TODO Use a dictionary to reflect type to pattern
		if (type.equals("svg")) return "[filename],svg";
		// TODO if nil then 
		return super.getOutputPattern(type);
	}
}
