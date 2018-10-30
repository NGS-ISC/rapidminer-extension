package com.rapidminer.ngs.operator;

import java.util.List;
import com.rapidminer.operator.OperatorDescription;
import com.rapidminer.operator.ports.InputPort;
import com.rapidminer.operator.ports.OutputPort;
import com.rapidminer.operator.OperatorException;
import com.rapidminer.parameter.*;

public class MothurGetMimarkspackageOperator extends MothurGeneratedOperator {

	private InputPort fileInPort = getInputPorts().createPort("file");
	private InputPort groupInPort = getInputPorts().createPort("group");
	private InputPort oligosInPort = getInputPorts().createPort("oligos");
	private OutputPort tsvOutPort = getOutputPorts().createPort("tsv");
	private static final String INPUTDIR_LABEL = "inputdir:";
	private static final String OUTPUTDIR_LABEL = "outputdir:";
	public static final String[] PACKAGE_CHOICES = { "air", "host_associated", "human_associated", "human_gut", "human_oral", "human_skin", "human_vaginal", "microbial", "miscellaneous", "plant_associated", "sediment", "soil", "wastewater", "water" };
	public static final int PACKAGE_DEFAULT_CHOICE = 8;
	private static final String PACKAGE_LABEL = "package:";
	private static final String REQUIREDONLY_LABEL = "requiredonly:";
	private static final String SEED_LABEL = "seed:";

	public MothurGetMimarkspackageOperator (OperatorDescription description) {
		super(description);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void doWork() throws OperatorException {
		super.doWork();
		clearArguments();
		FileNameObject fileFile = fileInPort.getData(FileNameObject.class);
		addArgument("file",fileFile.getName());
		FileNameObject groupFile = groupInPort.getData(FileNameObject.class);
		addArgument("group",groupFile.getName());
		FileNameObject oligosFile = oligosInPort.getData(FileNameObject.class);
		addArgument("oligos",oligosFile.getName());
		String inputdirValue = getParameterAsString(INPUTDIR_LABEL);
		addArgument("inputdir",String.valueOf(inputdirValue));
		String outputdirValue = getParameterAsString(OUTPUTDIR_LABEL);
		addArgument("outputdir",String.valueOf(outputdirValue));
		int packageIndex = getParameterAsInt(PACKAGE_LABEL);
		String packageValue = PACKAGE_CHOICES[packageIndex];
		addArgument("package",String.valueOf(packageValue));
		boolean requiredonlyValue = getParameterAsBoolean(REQUIREDONLY_LABEL);
		addArgument("requiredonly",String.valueOf(requiredonlyValue));
		int seedValue = getParameterAsInt(SEED_LABEL);
		addArgument("seed",String.valueOf(seedValue));
		executeMothurCommand();
		String fileName="<fileName>"; // TODO: Somehow figure out the fileName
		tsvOutPort.deliver(new FileNameObject(fileName+".tsv","tsv"));
	}

	@Override
	public List<ParameterType> getParameterTypes() {
		List<ParameterType> parameterTypes = super.getParameterTypes();
		parameterTypes.add(new ParameterTypeString(INPUTDIR_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeString(OUTPUTDIR_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeCategory(PACKAGE_LABEL, "TODO: Add description", PACKAGE_CHOICES, PACKAGE_DEFAULT_CHOICE));
		parameterTypes.add(new ParameterTypeBoolean(REQUIREDONLY_LABEL, "TODO: Add description", false, true));
		parameterTypes.add(new ParameterTypeInt(SEED_LABEL, "TODO: Add description", -100000000, 100000000, 0, true));
		return parameterTypes;
	}

	@Override
	public String getOutputPattern(String type) {
		// TODO Use a dictionary to reflect type to pattern
		if (type=="tsv") return "[filename],tsv";
		// TODO if nil then 
		return super.getOutputPattern(type);
	}
}
