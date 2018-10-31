package com.rapidminer.ngs.operator;

import java.util.List;
import com.rapidminer.operator.OperatorDescription;
import com.rapidminer.operator.ports.InputPort;
import com.rapidminer.operator.ports.OutputPort;
import com.rapidminer.operator.OperatorException;
import com.rapidminer.parameter.*;

public class MothurMergeSfffilesOperator extends MothurGeneratedOperator {

	private InputPort sffInPort = getInputPorts().createPort("sff");
	private InputPort fileInPort = getInputPorts().createPort("file");
	private OutputPort sffOutPort = getOutputPorts().createPort("sff");
	private static final String KEYTRIM_LABEL = "keytrim:";
	private static final String OUTPUT_LABEL = "output:";
	private static final String SEED_LABEL = "seed:";
	private static final String INPUTDIR_LABEL = "inputdir:";
	private static final String OUTPUTDIR_LABEL = "outputdir:";

	public MothurMergeSfffilesOperator (OperatorDescription description) {
		super(description);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void doWork() throws OperatorException {
		super.doWork();
		clearArguments();
		FileNameObject sffFile = sffInPort.getData(FileNameObject.class);
		addArgument("sff",sffFile.getName());
		FileNameObject fileFile = fileInPort.getData(FileNameObject.class);
		addArgument("file",fileFile.getName());
		boolean keytrimValue = getParameterAsBoolean(KEYTRIM_LABEL);
		addArgument("keytrim",String.valueOf(keytrimValue));
		String outputValue = getParameterAsString(OUTPUT_LABEL);
		addArgument("output",String.valueOf(outputValue));
		int seedValue = getParameterAsInt(SEED_LABEL);
		addArgument("seed",String.valueOf(seedValue));
		String inputdirValue = getParameterAsString(INPUTDIR_LABEL);
		addArgument("inputdir",String.valueOf(inputdirValue));
		String outputdirValue = getParameterAsString(OUTPUTDIR_LABEL);
		addArgument("outputdir",String.valueOf(outputdirValue));
		executeMothurCommand();
		String fileName="<fileName>"; // TODO: Somehow figure out the fileName
		sffOutPort.deliver(new FileNameObject(fileName+".sff","sff"));
	}

	@Override
	public List<ParameterType> getParameterTypes() {
		List<ParameterType> parameterTypes = super.getParameterTypes();
		parameterTypes.add(new ParameterTypeBoolean(KEYTRIM_LABEL, "TODO: Add description", false, true));
		parameterTypes.add(new ParameterTypeString(OUTPUT_LABEL, "TODO: Add description", "", false));
		parameterTypes.add(new ParameterTypeInt(SEED_LABEL, "TODO: Add description", -100000000, 100000000, 0, true));
		parameterTypes.add(new ParameterTypeString(INPUTDIR_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeString(OUTPUTDIR_LABEL, "TODO: Add description", "", true));
		return parameterTypes;
	}

	@Override
	public String getOutputPattern(String type) {
		// TODO Use a dictionary to reflect type to pattern
		if (type.equals("sff")) return "[filename],";
		// TODO if nil then 
		return super.getOutputPattern(type);
	}
}
