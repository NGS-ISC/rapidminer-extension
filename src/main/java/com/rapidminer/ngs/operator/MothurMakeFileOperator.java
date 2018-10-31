package com.rapidminer.ngs.operator;

import java.util.List;
import com.rapidminer.operator.OperatorDescription;
import com.rapidminer.operator.ports.InputPort;
import com.rapidminer.operator.ports.OutputPort;
import com.rapidminer.operator.OperatorException;
import com.rapidminer.parameter.*;

public class MothurMakeFileOperator extends MothurGeneratedOperator {

	private OutputPort fileOutPort = getOutputPorts().createPort("file");
	private static final String[] TYPE_CHOICES = { "fastq", "gz" };
	private static final int TYPE_DEFAULT_CHOICE = 0;
	private static final String TYPE_LABEL = "type:";
	private static final String[] NUMCOLS_CHOICES = { "2", "3" };
	private static final int NUMCOLS_DEFAULT_CHOICE = 1;
	private static final String NUMCOLS_LABEL = "numcols:";
	private static final String SEED_LABEL = "seed:";
	private static final String PREFIX_LABEL = "prefix:";
	private static final String INPUTDIR_LABEL = "inputdir:";
	private static final String OUTPUTDIR_LABEL = "outputdir:";
	private static final String DELIM_LABEL = "delim:";

	public MothurMakeFileOperator (OperatorDescription description) {
		super(description);
		// NOTE: Auto-generated constructor stub
	}

	@Override
	public void doWork() throws OperatorException {
		super.doWork();
		clearArguments();
		int typeIndex = getParameterAsInt(TYPE_LABEL);
		String typeValue = TYPE_CHOICES[typeIndex];
		addArgument("type",String.valueOf(typeValue));
		int numcolsIndex = getParameterAsInt(NUMCOLS_LABEL);
		String numcolsValue = NUMCOLS_CHOICES[numcolsIndex];
		addArgument("numcols",String.valueOf(numcolsValue));
		int seedValue = getParameterAsInt(SEED_LABEL);
		addArgument("seed",String.valueOf(seedValue));
		String prefixValue = getParameterAsString(PREFIX_LABEL);
		addArgument("prefix",String.valueOf(prefixValue));
		String inputdirValue = getParameterAsString(INPUTDIR_LABEL);
		addArgument("inputdir",String.valueOf(inputdirValue));
		String outputdirValue = getParameterAsString(OUTPUTDIR_LABEL);
		addArgument("outputdir",String.valueOf(outputdirValue));
		String delimValue = getParameterAsString(DELIM_LABEL);
		addArgument("delim",String.valueOf(delimValue));
		executeMothurCommand();
		String fileName="<fileName>"; // TODO: Somehow figure out the fileName
		fileOutPort.deliver(new FileNameObject(fileName+".file","file"));
	}

	@Override
	public List<ParameterType> getParameterTypes() {
		List<ParameterType> parameterTypes = super.getParameterTypes();
		parameterTypes.add(new ParameterTypeCategory(TYPE_LABEL, "TODO: Add description", TYPE_CHOICES, TYPE_DEFAULT_CHOICE));
		parameterTypes.add(new ParameterTypeCategory(NUMCOLS_LABEL, "TODO: Add description", NUMCOLS_CHOICES, NUMCOLS_DEFAULT_CHOICE));
		parameterTypes.add(new ParameterTypeInt(SEED_LABEL, "TODO: Add description", -100000000, 100000000, 0, true));
		parameterTypes.add(new ParameterTypeString(PREFIX_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeString(INPUTDIR_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeString(OUTPUTDIR_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeString(DELIM_LABEL, "TODO: Add description", "_", true));
		return parameterTypes;
	}

	@Override
	public String getOutputPattern(String type) {
		if (type.equals("file")) return "[filename],[tag],files-[filename],files";
		return super.getOutputPattern(type);
	}
}
