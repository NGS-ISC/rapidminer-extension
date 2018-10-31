package com.rapidminer.ngs.operator;

import java.util.List;
import com.rapidminer.operator.OperatorDescription;
import com.rapidminer.operator.ports.InputPort;
import com.rapidminer.operator.ports.OutputPort;
import com.rapidminer.operator.OperatorException;
import com.rapidminer.parameter.*;

public class MothurAmovaOperator extends MothurGeneratedOperator {

	private InputPort designInPort = getInputPorts().createPort("design");
	private InputPort phylipInPort = getInputPorts().createPort("phylip");
	private OutputPort amovaOutPort = getOutputPorts().createPort("amova");
	private static final String SETS_LABEL = "sets:";
	private static final String ITERS_LABEL = "iters:";
	private static final String ALPHA_LABEL = "alpha:";
	private static final String SEED_LABEL = "seed:";
	private static final String INPUTDIR_LABEL = "inputdir:";
	private static final String OUTPUTDIR_LABEL = "outputdir:";

	public MothurAmovaOperator (OperatorDescription description) {
		super(description);
		// NOTE: Auto-generated constructor stub
	}

	@Override
	public void doWork() throws OperatorException {
		super.doWork();
		clearArguments();
		FileNameObject designFile = designInPort.getData(FileNameObject.class);
		addArgument("design",designFile.getName());
		FileNameObject phylipFile = phylipInPort.getData(FileNameObject.class);
		addArgument("phylip",phylipFile.getName());
		String setsValue = getParameterAsString(SETS_LABEL);
		addArgument("sets",String.valueOf(setsValue));
		int itersValue = getParameterAsInt(ITERS_LABEL);
		addArgument("iters",String.valueOf(itersValue));
		int alphaValue = getParameterAsInt(ALPHA_LABEL);
		addArgument("alpha",String.valueOf(alphaValue));
		int seedValue = getParameterAsInt(SEED_LABEL);
		addArgument("seed",String.valueOf(seedValue));
		String inputdirValue = getParameterAsString(INPUTDIR_LABEL);
		addArgument("inputdir",String.valueOf(inputdirValue));
		String outputdirValue = getParameterAsString(OUTPUTDIR_LABEL);
		addArgument("outputdir",String.valueOf(outputdirValue));
		executeMothurCommand();
		String fileName="<fileName>"; // TODO: Somehow figure out the fileName
		amovaOutPort.deliver(new FileNameObject(fileName+".amova","amova"));
	}

	@Override
	public List<ParameterType> getParameterTypes() {
		List<ParameterType> parameterTypes = super.getParameterTypes();
		parameterTypes.add(new ParameterTypeString(SETS_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeInt(ITERS_LABEL, "TODO: Add description", -100000000, 100000000, 1000, true));
		parameterTypes.add(new ParameterTypeDouble(ALPHA_LABEL, "TODO: Add description", -100000000, 100000000, 0.05, true));
		parameterTypes.add(new ParameterTypeInt(SEED_LABEL, "TODO: Add description", -100000000, 100000000, 0, true));
		parameterTypes.add(new ParameterTypeString(INPUTDIR_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeString(OUTPUTDIR_LABEL, "TODO: Add description", "", true));
		return parameterTypes;
	}

	@Override
	public String getOutputPattern(String type) {
		if (type.equals("amova")) return "[filename],amova";
		return super.getOutputPattern(type);
	}
}
