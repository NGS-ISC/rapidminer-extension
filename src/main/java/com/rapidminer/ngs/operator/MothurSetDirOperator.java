package com.rapidminer.ngs.operator;

import java.util.List;
import com.rapidminer.operator.OperatorDescription;
import com.rapidminer.operator.ports.InputPort;
import com.rapidminer.operator.ports.OutputPort;
import com.rapidminer.operator.OperatorException;
import com.rapidminer.parameter.*;

public class MothurSetDirOperator extends MothurGeneratedOperator {

	private static final String TEMPDEFAULT_LABEL = "tempdefault:";
	private static final String BLASTDIR_LABEL = "blastdir:";
	private static final String TOOLS_LABEL = "tools:";
	private static final String DEBUG_LABEL = "debug:";
	private static final String SEED_LABEL = "seed:";
	private static final String MODIFYNAMES_LABEL = "modifynames:";
	private static final String INPUT_LABEL = "input:";
	private static final String OUTPUT_LABEL = "output:";
	private static final String INPUTDIR_LABEL = "inputdir:";
	private static final String OUTPUTDIR_LABEL = "outputdir:";

	public MothurSetDirOperator (OperatorDescription description) {
		super(description);
		// NOTE: Auto-generated constructor stub
	}

	@Override
	public void doWork() throws OperatorException {
		super.doWork();
		clearArguments();
		String tempdefaultValue = getParameterAsString(TEMPDEFAULT_LABEL);
		addArgument("tempdefault",String.valueOf(tempdefaultValue));
		String blastdirValue = getParameterAsString(BLASTDIR_LABEL);
		addArgument("blastdir",String.valueOf(blastdirValue));
		String toolsValue = getParameterAsString(TOOLS_LABEL);
		addArgument("tools",String.valueOf(toolsValue));
		boolean debugValue = getParameterAsBoolean(DEBUG_LABEL);
		addArgument("debug",String.valueOf(debugValue));
		int seedValue = getParameterAsInt(SEED_LABEL);
		addArgument("seed",String.valueOf(seedValue));
		boolean modifynamesValue = getParameterAsBoolean(MODIFYNAMES_LABEL);
		addArgument("modifynames",String.valueOf(modifynamesValue));
		String inputValue = getParameterAsString(INPUT_LABEL);
		addArgument("input",String.valueOf(inputValue));
		String outputValue = getParameterAsString(OUTPUT_LABEL);
		addArgument("output",String.valueOf(outputValue));
		String inputdirValue = getParameterAsString(INPUTDIR_LABEL);
		addArgument("inputdir",String.valueOf(inputdirValue));
		String outputdirValue = getParameterAsString(OUTPUTDIR_LABEL);
		addArgument("outputdir",String.valueOf(outputdirValue));
		executeMothurCommand();
		String fileName="<fileName>"; // TODO: Somehow figure out the fileName
	}

	@Override
	public List<ParameterType> getParameterTypes() {
		List<ParameterType> parameterTypes = super.getParameterTypes();
		parameterTypes.add(new ParameterTypeString(TEMPDEFAULT_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeString(BLASTDIR_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeString(TOOLS_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeBoolean(DEBUG_LABEL, "TODO: Add description", false, true));
		parameterTypes.add(new ParameterTypeInt(SEED_LABEL, "TODO: Add description", -100000000, 100000000, 0, true));
		parameterTypes.add(new ParameterTypeBoolean(MODIFYNAMES_LABEL, "TODO: Add description", true, true));
		parameterTypes.add(new ParameterTypeString(INPUT_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeString(OUTPUT_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeString(INPUTDIR_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeString(OUTPUTDIR_LABEL, "TODO: Add description", "", true));
		return parameterTypes;
	}

	@Override
	public String getOutputPattern(String type) {
		return super.getOutputPattern(type);
	}
}
