package com.rapidminer.ngs.operator;

import java.util.List;
import com.rapidminer.operator.OperatorDescription;
import com.rapidminer.operator.ports.InputPort;
import com.rapidminer.operator.ports.OutputPort;
import com.rapidminer.operator.OperatorException;
import com.rapidminer.parameter.*;

public class MothurPhylotypeOperator extends MothurGeneratedOperator {

	private InputPort countInPort = getInputPorts().createPort("count");
	private InputPort nameInPort = getInputPorts().createPort("name");
	private InputPort taxonomyInPort = getInputPorts().createPort("taxonomy");
	private OutputPort rabundOutPort = getOutputPorts().createPort("rabund");
	private OutputPort listOutPort = getOutputPorts().createPort("list");
	private OutputPort sabundOutPort = getOutputPorts().createPort("sabund");
	private static final String CUTOFF_LABEL = "cutoff:";
	private static final String INPUTDIR_LABEL = "inputdir:";
	private static final String LABEL_LABEL = "label:";
	private static final String OUTPUTDIR_LABEL = "outputdir:";
	private static final String SEED_LABEL = "seed:";

	public MothurPhylotypeOperator (OperatorDescription description) {
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
		FileNameObject taxonomyFile = taxonomyInPort.getData(FileNameObject.class);
		addArgument("taxonomy",taxonomyFile.getName());
		int cutoffValue = getParameterAsInt(CUTOFF_LABEL);
		addArgument("cutoff",String.valueOf(cutoffValue));
		String inputdirValue = getParameterAsString(INPUTDIR_LABEL);
		addArgument("inputdir",String.valueOf(inputdirValue));
		String labelValue = getParameterAsString(LABEL_LABEL);
		addArgument("label",String.valueOf(labelValue));
		String outputdirValue = getParameterAsString(OUTPUTDIR_LABEL);
		addArgument("outputdir",String.valueOf(outputdirValue));
		int seedValue = getParameterAsInt(SEED_LABEL);
		addArgument("seed",String.valueOf(seedValue));
		executeMothurCommand();
		String fileName="<fileName>"; // TODO: Somehow figure out the fileName
		rabundOutPort.deliver(new FileNameObject(fileName+".rabund","rabund"));
		listOutPort.deliver(new FileNameObject(fileName+".list","list"));
		sabundOutPort.deliver(new FileNameObject(fileName+".sabund","sabund"));
	}

	@Override
	public List<ParameterType> getParameterTypes() {
		List<ParameterType> parameterTypes = super.getParameterTypes();
		parameterTypes.add(new ParameterTypeInt(CUTOFF_LABEL, "TODO: Add description", -100000000, 100000000, -1, true));
		parameterTypes.add(new ParameterTypeString(INPUTDIR_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeString(LABEL_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeString(OUTPUTDIR_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeInt(SEED_LABEL, "TODO: Add description", -100000000, 100000000, 0, true));
		return parameterTypes;
	}

	@Override
	public String getOutputPattern(String type) {
		// TODO Use a dictionary to reflect type to pattern
		if (type=="rabund") return "[filename],[clustertag],rabund";
		if (type=="list") return "[filename],[clustertag],list-[filename],[clustertag],[tag2],list";
		if (type=="sabund") return "[filename],[clustertag],sabund";
		// TODO if nil then 
		return super.getOutputPattern(type);
	}
}
