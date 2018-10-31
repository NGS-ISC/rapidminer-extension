package com.rapidminer.ngs.operator;

import java.util.List;
import com.rapidminer.operator.OperatorDescription;
import com.rapidminer.operator.ports.InputPort;
import com.rapidminer.operator.ports.OutputPort;
import com.rapidminer.operator.OperatorException;
import com.rapidminer.parameter.*;

public class MothurMakeLefseOperator extends MothurGeneratedOperator {

	private InputPort sharedInPort = getInputPorts().createPort("shared");
	private InputPort relabundInPort = getInputPorts().createPort("relabund");
	private InputPort constaxonomyInPort = getInputPorts().createPort("constaxonomy");
	private InputPort designInPort = getInputPorts().createPort("design");
	private OutputPort lefseOutPort = getOutputPorts().createPort("lefse");
	private static final String GROUPS_LABEL = "groups:";
	private static final String[] SCALE_CHOICES = { "totalgroup", "totalotu", "averagegroup", "averageotu" };
	private static final int SCALE_DEFAULT_CHOICE = 0;
	private static final String SCALE_LABEL = "scale:";
	private static final String LABEL_LABEL = "label:";
	private static final String SEED_LABEL = "seed:";
	private static final String INPUTDIR_LABEL = "inputdir:";
	private static final String OUTPUTDIR_LABEL = "outputdir:";

	public MothurMakeLefseOperator (OperatorDescription description) {
		super(description);
		// NOTE: Auto-generated constructor stub
	}

	@Override
	public void doWork() throws OperatorException {
		super.doWork();
		clearArguments();
		FileNameObject sharedFile = sharedInPort.getData(FileNameObject.class);
		addArgument("shared",sharedFile.getName());
		FileNameObject relabundFile = relabundInPort.getData(FileNameObject.class);
		addArgument("relabund",relabundFile.getName());
		FileNameObject constaxonomyFile = constaxonomyInPort.getData(FileNameObject.class);
		addArgument("constaxonomy",constaxonomyFile.getName());
		FileNameObject designFile = designInPort.getData(FileNameObject.class);
		addArgument("design",designFile.getName());
		String groupsValue = getParameterAsString(GROUPS_LABEL);
		addArgument("groups",String.valueOf(groupsValue));
		int scaleIndex = getParameterAsInt(SCALE_LABEL);
		String scaleValue = SCALE_CHOICES[scaleIndex];
		addArgument("scale",String.valueOf(scaleValue));
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
		lefseOutPort.deliver(new FileNameObject(fileName+".lefse","lefse"));
	}

	@Override
	public List<ParameterType> getParameterTypes() {
		List<ParameterType> parameterTypes = super.getParameterTypes();
		parameterTypes.add(new ParameterTypeString(GROUPS_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeCategory(SCALE_LABEL, "TODO: Add description", SCALE_CHOICES, SCALE_DEFAULT_CHOICE));
		parameterTypes.add(new ParameterTypeString(LABEL_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeInt(SEED_LABEL, "TODO: Add description", -100000000, 100000000, 0, true));
		parameterTypes.add(new ParameterTypeString(INPUTDIR_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeString(OUTPUTDIR_LABEL, "TODO: Add description", "", true));
		return parameterTypes;
	}

	@Override
	public String getOutputPattern(String type) {
		if (type.equals("lefse")) return "[filename],[distance],lefse";
		return super.getOutputPattern(type);
	}
}
