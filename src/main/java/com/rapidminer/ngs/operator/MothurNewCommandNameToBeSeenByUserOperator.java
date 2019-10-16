package com.rapidminer.ngs.operator;

import java.util.List;
import com.rapidminer.operator.OperatorDescription;
import com.rapidminer.operator.ports.InputPort;
import com.rapidminer.operator.ports.OutputPort;
import com.rapidminer.operator.OperatorException;
import com.rapidminer.parameter.*;

public class MothurNewCommandNameToBeSeenByUserOperator extends MothurGeneratedOperator {

	private InputPort phylipInPort = getInputPorts().createPort("phylip");
	private InputPort nameInPort = getInputPorts().createPort("name");
	private InputPort columnInPort = getInputPorts().createPort("column");
	private InputPort fastaInPort = getInputPorts().createPort("fasta");
	private InputPort sharedInPort = getInputPorts().createPort("shared");
	private OutputPort fileType1OutPort = getOutputPorts().createPort("fileType1");
	private OutputPort fileType2OutPort = getOutputPorts().createPort("fileType2");
	private OutputPort fileType3OutPort = getOutputPorts().createPort("fileType3");
	private static final String PROCESSORS_LABEL = "processors:";
	private static final String GROUPS_LABEL = "groups:";
	private static final String LABEL_LABEL = "label:";
	private static final String[] CALC_CHOICES = { "jabund", "sorabund", "jclass", "sorclass", "jest", "sorest", "thetayc", "thetan", "morisitahorn", "braycurtis" };
	private static final int CALC_DEFAULT_CHOICE = 0;
	private static final String CALC_LABEL = "calc:";
	private static final String[] DISTANCE_CHOICES = { "column", "lt", "square" };
	private static final int DISTANCE_DEFAULT_CHOICE = 0;
	private static final String DISTANCE_LABEL = "distance:";
	private static final String TIMING_LABEL = "timing:";
	private static final String SEED_LABEL = "seed:";
	private static final String INPUTDIR_LABEL = "inputdir:";
	private static final String OUTPUTDIR_LABEL = "outputdir:";

	public MothurNewCommandNameToBeSeenByUserOperator (OperatorDescription description) {
		super(description);
		// NOTE: Auto-generated constructor stub
	}

	@Override
	public void doWork() throws OperatorException {
		super.doWork();
		clearArguments();
		FileNameObject phylipFile = phylipInPort.getData(FileNameObject.class);
		addArgument("phylip",phylipFile.getName());
		FileNameObject nameFile = nameInPort.getData(FileNameObject.class);
		addArgument("name",nameFile.getName());
		FileNameObject columnFile = columnInPort.getData(FileNameObject.class);
		addArgument("column",columnFile.getName());
		FileNameObject fastaFile = fastaInPort.getData(FileNameObject.class);
		addArgument("fasta",fastaFile.getName());
		FileNameObject sharedFile = sharedInPort.getData(FileNameObject.class);
		addArgument("shared",sharedFile.getName());
		int processorsValue = getParameterAsInt(PROCESSORS_LABEL);
		addArgument("processors",String.valueOf(processorsValue));
		String groupsValue = getParameterAsString(GROUPS_LABEL);
		addArgument("groups",String.valueOf(groupsValue));
		String labelValue = getParameterAsString(LABEL_LABEL);
		addArgument("label",String.valueOf(labelValue));
		int calcIndex = getParameterAsInt(CALC_LABEL);
		String calcValue = CALC_CHOICES[calcIndex];
		addArgument("calc",String.valueOf(calcValue));
		int distanceIndex = getParameterAsInt(DISTANCE_LABEL);
		String distanceValue = DISTANCE_CHOICES[distanceIndex];
		addArgument("distance",String.valueOf(distanceValue));
		boolean timingValue = getParameterAsBoolean(TIMING_LABEL);
		addArgument("timing",String.valueOf(timingValue));
		int seedValue = getParameterAsInt(SEED_LABEL);
		addArgument("seed",String.valueOf(seedValue));
		String inputdirValue = getParameterAsString(INPUTDIR_LABEL);
		addArgument("inputdir",String.valueOf(inputdirValue));
		String outputdirValue = getParameterAsString(OUTPUTDIR_LABEL);
		addArgument("outputdir",String.valueOf(outputdirValue));
		executeMothurCommand();
		String fileName="<fileName>"; // TODO: Somehow figure out the fileName
		fileType1OutPort.deliver(new FileNameObject(fileName+".fileType1","fileType1"));
		fileType2OutPort.deliver(new FileNameObject(fileName+".fileType2","fileType2"));
		fileType3OutPort.deliver(new FileNameObject(fileName+".fileType3","fileType3"));
	}

	@Override
	public List<ParameterType> getParameterTypes() {
		List<ParameterType> parameterTypes = super.getParameterTypes();
		parameterTypes.add(new ParameterTypeInt(PROCESSORS_LABEL, "TODO: Add description", -100000000, 100000000, 1, true));
		parameterTypes.add(new ParameterTypeString(GROUPS_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeString(LABEL_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeCategory(CALC_LABEL, "TODO: Add description", CALC_CHOICES, CALC_DEFAULT_CHOICE));
		parameterTypes.add(new ParameterTypeCategory(DISTANCE_LABEL, "TODO: Add description", DISTANCE_CHOICES, DISTANCE_DEFAULT_CHOICE));
		parameterTypes.add(new ParameterTypeBoolean(TIMING_LABEL, "TODO: Add description", false, true));
		parameterTypes.add(new ParameterTypeInt(SEED_LABEL, "TODO: Add description", -100000000, 100000000, 0, true));
		parameterTypes.add(new ParameterTypeString(INPUTDIR_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeString(OUTPUTDIR_LABEL, "TODO: Add description", "", true));
		return parameterTypes;
	}

	@Override
	public String getOutputPattern(String type) {
		if (type.equals("fileType3")) return "[filename],tag3";
		if (type.equals("fileType1")) return "[filename],tag1";
		if (type.equals("fileType2")) return "[filename],tag2";
		return super.getOutputPattern(type);
	}
}
