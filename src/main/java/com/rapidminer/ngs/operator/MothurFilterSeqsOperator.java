package com.rapidminer.ngs.operator;

import java.util.List;
import com.rapidminer.operator.OperatorDescription;
import com.rapidminer.operator.ports.InputPort;
import com.rapidminer.operator.ports.OutputPort;
import com.rapidminer.operator.OperatorException;
import com.rapidminer.parameter.*;

public class MothurFilterSeqsOperator extends MothurGeneratedOperator {

	private InputPort fastaInPort = getInputPorts().createPort("fasta");
	private InputPort hardInPort = getInputPorts().createPort("hard");
	private OutputPort fastaOutPort = getOutputPorts().createPort("fasta");
	private OutputPort filterOutPort = getOutputPorts().createPort("filter");
	private static final String TRUMP_LABEL = "trump:";
	private static final String SOFT_LABEL = "soft:";
	private static final String VERTICAL_LABEL = "vertical:";
	private static final String PROCESSORS_LABEL = "processors:";
	private static final String SEED_LABEL = "seed:";
	private static final String INPUTDIR_LABEL = "inputdir:";
	private static final String OUTPUTDIR_LABEL = "outputdir:";

	public MothurFilterSeqsOperator (OperatorDescription description) {
		super(description);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void doWork() throws OperatorException {
		super.doWork();
		clearArguments();
		FileNameObject fastaFile = fastaInPort.getData(FileNameObject.class);
		addArgument("fasta",fastaFile.getName());
		FileNameObject hardFile = hardInPort.getData(FileNameObject.class);
		addArgument("hard",hardFile.getName());
		String trumpValue = getParameterAsString(TRUMP_LABEL);
		addArgument("trump",String.valueOf(trumpValue));
		int softValue = getParameterAsInt(SOFT_LABEL);
		addArgument("soft",String.valueOf(softValue));
		boolean verticalValue = getParameterAsBoolean(VERTICAL_LABEL);
		addArgument("vertical",String.valueOf(verticalValue));
		int processorsValue = getParameterAsInt(PROCESSORS_LABEL);
		addArgument("processors",String.valueOf(processorsValue));
		int seedValue = getParameterAsInt(SEED_LABEL);
		addArgument("seed",String.valueOf(seedValue));
		String inputdirValue = getParameterAsString(INPUTDIR_LABEL);
		addArgument("inputdir",String.valueOf(inputdirValue));
		String outputdirValue = getParameterAsString(OUTPUTDIR_LABEL);
		addArgument("outputdir",String.valueOf(outputdirValue));
		executeMothurCommand();
		String fileName="<fileName>"; // TODO: Somehow figure out the fileName
		fastaOutPort.deliver(new FileNameObject(fileName+".fasta","fasta"));
		filterOutPort.deliver(new FileNameObject(fileName+".filter","filter"));
	}

	@Override
	public List<ParameterType> getParameterTypes() {
		List<ParameterType> parameterTypes = super.getParameterTypes();
		parameterTypes.add(new ParameterTypeString(TRUMP_LABEL, "TODO: Add description", "*", true));
		parameterTypes.add(new ParameterTypeInt(SOFT_LABEL, "TODO: Add description", -100000000, 100000000, 0, true));
		parameterTypes.add(new ParameterTypeBoolean(VERTICAL_LABEL, "TODO: Add description", true, true));
		parameterTypes.add(new ParameterTypeInt(PROCESSORS_LABEL, "TODO: Add description", -100000000, 100000000, 1, true));
		parameterTypes.add(new ParameterTypeInt(SEED_LABEL, "TODO: Add description", -100000000, 100000000, 0, true));
		parameterTypes.add(new ParameterTypeString(INPUTDIR_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeString(OUTPUTDIR_LABEL, "TODO: Add description", "", true));
		return parameterTypes;
	}

	@Override
	public String getOutputPattern(String type) {
		// TODO Use a dictionary to reflect type to pattern
		if (type.equals("fasta")) return "[filename],filter.fasta";
		if (type.equals("filter")) return "[filename],filter";
		// TODO if nil then 
		return super.getOutputPattern(type);
	}
}
