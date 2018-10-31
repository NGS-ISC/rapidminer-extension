package com.rapidminer.ngs.operator;

import java.util.List;
import com.rapidminer.operator.OperatorDescription;
import com.rapidminer.operator.ports.InputPort;
import com.rapidminer.operator.ports.OutputPort;
import com.rapidminer.operator.OperatorException;
import com.rapidminer.parameter.*;

public class MothurHeatmapBinOperator extends MothurGeneratedOperator {

	private InputPort listInPort = getInputPorts().createPort("list");
	private InputPort rabundInPort = getInputPorts().createPort("rabund");
	private InputPort sabundInPort = getInputPorts().createPort("sabund");
	private InputPort sharedInPort = getInputPorts().createPort("shared");
	private InputPort relabundInPort = getInputPorts().createPort("relabund");
	private OutputPort svgOutPort = getOutputPorts().createPort("svg");
	private static final String GROUPS_LABEL = "groups:";
	private static final String[] SCALE_CHOICES = { "log10", "log2", "linear" };
	private static final int SCALE_DEFAULT_CHOICE = 0;
	private static final String SCALE_LABEL = "scale:";
	private static final String[] SORTED_CHOICES = { "none", "shared", "topotu", "topgroup" };
	private static final int SORTED_DEFAULT_CHOICE = 1;
	private static final String SORTED_LABEL = "sorted:";
	private static final String NUMOTU_LABEL = "numotu:";
	private static final String FONTSIZE_LABEL = "fontsize:";
	private static final String LABEL_LABEL = "label:";
	private static final String SEED_LABEL = "seed:";
	private static final String INPUTDIR_LABEL = "inputdir:";
	private static final String OUTPUTDIR_LABEL = "outputdir:";

	public MothurHeatmapBinOperator (OperatorDescription description) {
		super(description);
		// NOTE: Auto-generated constructor stub
	}

	@Override
	public void doWork() throws OperatorException {
		super.doWork();
		clearArguments();
		FileNameObject listFile = listInPort.getData(FileNameObject.class);
		addArgument("list",listFile.getName());
		FileNameObject rabundFile = rabundInPort.getData(FileNameObject.class);
		addArgument("rabund",rabundFile.getName());
		FileNameObject sabundFile = sabundInPort.getData(FileNameObject.class);
		addArgument("sabund",sabundFile.getName());
		FileNameObject sharedFile = sharedInPort.getData(FileNameObject.class);
		addArgument("shared",sharedFile.getName());
		FileNameObject relabundFile = relabundInPort.getData(FileNameObject.class);
		addArgument("relabund",relabundFile.getName());
		String groupsValue = getParameterAsString(GROUPS_LABEL);
		addArgument("groups",String.valueOf(groupsValue));
		int scaleIndex = getParameterAsInt(SCALE_LABEL);
		String scaleValue = SCALE_CHOICES[scaleIndex];
		addArgument("scale",String.valueOf(scaleValue));
		int sortedIndex = getParameterAsInt(SORTED_LABEL);
		String sortedValue = SORTED_CHOICES[sortedIndex];
		addArgument("sorted",String.valueOf(sortedValue));
		int numotuValue = getParameterAsInt(NUMOTU_LABEL);
		addArgument("numotu",String.valueOf(numotuValue));
		int fontsizeValue = getParameterAsInt(FONTSIZE_LABEL);
		addArgument("fontsize",String.valueOf(fontsizeValue));
		String labelValue = getParameterAsString(LABEL_LABEL);
		addArgument("label",String.valueOf(labelValue));
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
		parameterTypes.add(new ParameterTypeCategory(SCALE_LABEL, "TODO: Add description", SCALE_CHOICES, SCALE_DEFAULT_CHOICE));
		parameterTypes.add(new ParameterTypeCategory(SORTED_LABEL, "TODO: Add description", SORTED_CHOICES, SORTED_DEFAULT_CHOICE));
		parameterTypes.add(new ParameterTypeInt(NUMOTU_LABEL, "TODO: Add description", -100000000, 100000000, 0, true));
		parameterTypes.add(new ParameterTypeInt(FONTSIZE_LABEL, "TODO: Add description", -100000000, 100000000, 24, true));
		parameterTypes.add(new ParameterTypeString(LABEL_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeInt(SEED_LABEL, "TODO: Add description", -100000000, 100000000, 0, true));
		parameterTypes.add(new ParameterTypeString(INPUTDIR_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeString(OUTPUTDIR_LABEL, "TODO: Add description", "", true));
		return parameterTypes;
	}

	@Override
	public String getOutputPattern(String type) {
		if (type.equals("svg")) return "[filename],svg";
		return super.getOutputPattern(type);
	}
}
