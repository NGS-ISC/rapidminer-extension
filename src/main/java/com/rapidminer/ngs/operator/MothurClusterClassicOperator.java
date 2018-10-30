package com.rapidminer.ngs.operator;

import java.util.List;
import com.rapidminer.operator.OperatorDescription;
import com.rapidminer.operator.ports.InputPort;
import com.rapidminer.operator.ports.OutputPort;
import com.rapidminer.operator.OperatorException;
import com.rapidminer.parameter.*;

public class MothurClusterClassicOperator extends MothurGeneratedOperator {

	private InputPort countInPort = getInputPorts().createPort("count");
	private InputPort nameInPort = getInputPorts().createPort("name");
	private InputPort phylipInPort = getInputPorts().createPort("phylip");
	private OutputPort listOutPort = getOutputPorts().createPort("list");
	private OutputPort rabundOutPort = getOutputPorts().createPort("rabund");
	private OutputPort sabundOutPort = getOutputPorts().createPort("sabund");
	private static final String CUTOFF_LABEL = "cutoff:";
	private static final String INPUTDIR_LABEL = "inputdir:";
	public static final String[] METHOD_CHOICES = { "average", "furthest", "nearest", "weighted" };
	public static final int METHOD_DEFAULT_CHOICE = 0;
	private static final String METHOD_LABEL = "method:";
	private static final String OUTPUTDIR_LABEL = "outputdir:";
	private static final String PRECISION_LABEL = "precision:";
	private static final String SEED_LABEL = "seed:";
	private static final String SIM_LABEL = "sim:";

	public MothurClusterClassicOperator (OperatorDescription description) {
		super(description);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void doWork() throws OperatorException {
		super.doWork();
		clearArguments();
		FileNameObject countFile = countInPort.getData(FileNameObject.class);
		addArgument("count",countFile.getName());
		FileNameObject nameFile = nameInPort.getData(FileNameObject.class);
		addArgument("name",nameFile.getName());
		FileNameObject phylipFile = phylipInPort.getData(FileNameObject.class);
		addArgument("phylip",phylipFile.getName());
		int cutoffValue = getParameterAsInt(CUTOFF_LABEL);
		addArgument("cutoff",String.valueOf(cutoffValue));
		String inputdirValue = getParameterAsString(INPUTDIR_LABEL);
		addArgument("inputdir",String.valueOf(inputdirValue));
		int methodIndex = getParameterAsInt(METHOD_LABEL);
		String methodValue = METHOD_CHOICES[methodIndex];
		addArgument("method",String.valueOf(methodValue));
		String outputdirValue = getParameterAsString(OUTPUTDIR_LABEL);
		addArgument("outputdir",String.valueOf(outputdirValue));
		int precisionValue = getParameterAsInt(PRECISION_LABEL);
		addArgument("precision",String.valueOf(precisionValue));
		int seedValue = getParameterAsInt(SEED_LABEL);
		addArgument("seed",String.valueOf(seedValue));
		boolean simValue = getParameterAsBoolean(SIM_LABEL);
		addArgument("sim",String.valueOf(simValue));
		executeMothurCommand();
		String fileName="<fileName>"; // TODO: Somehow figure out the fileName
		listOutPort.deliver(new FileNameObject(fileName+".list","list"));
		rabundOutPort.deliver(new FileNameObject(fileName+".rabund","rabund"));
		sabundOutPort.deliver(new FileNameObject(fileName+".sabund","sabund"));
	}

	@Override
	public List<ParameterType> getParameterTypes() {
		List<ParameterType> parameterTypes = super.getParameterTypes();
		parameterTypes.add(new ParameterTypeInt(CUTOFF_LABEL, "TODO: Add description", -100000000, 100000000, 10, true));
		parameterTypes.add(new ParameterTypeString(INPUTDIR_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeCategory(METHOD_LABEL, "TODO: Add description", METHOD_CHOICES, METHOD_DEFAULT_CHOICE));
		parameterTypes.add(new ParameterTypeString(OUTPUTDIR_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeInt(PRECISION_LABEL, "TODO: Add description", -100000000, 100000000, 100, true));
		parameterTypes.add(new ParameterTypeInt(SEED_LABEL, "TODO: Add description", -100000000, 100000000, 0, true));
		parameterTypes.add(new ParameterTypeBoolean(SIM_LABEL, "TODO: Add description", false, true));
		return parameterTypes;
	}

	@Override
	public String getOutputPattern(String type) {
		// TODO Use a dictionary to reflect type to pattern
		if (type=="list") return "[filename],[clustertag],list-[filename],[clustertag],[tag2],list";
		if (type=="rabund") return "[filename],[clustertag],rabund";
		if (type=="sabund") return "[filename],[clustertag],sabund";
		// TODO if nil then 
		return super.getOutputPattern(type);
	}
}
