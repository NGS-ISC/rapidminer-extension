package com.rapidminer.ngs.operator;

import java.util.List;
import com.rapidminer.operator.OperatorDescription;
import com.rapidminer.operator.ports.InputPort;
import com.rapidminer.operator.ports.OutputPort;
import com.rapidminer.operator.OperatorException;
import com.rapidminer.parameter.*;

public class MothurMergeFilesOperator extends MothurGeneratedOperator {

	private InputPort taxonomyInPort = getInputPorts().createPort("taxonomy");
	private InputPort fastaInPort = getInputPorts().createPort("fasta");
	private InputPort nameInPort = getInputPorts().createPort("name");
	private InputPort countInPort = getInputPorts().createPort("count");
	private OutputPort fastaOutPort = getOutputPorts().createPort("fasta");
	private OutputPort mergeOutPort = getOutputPorts().createPort("merge");
	private static final String INPUT_LABEL = "input:";
	private static final String OUTPUT_LABEL = "output:";
	private static final String SEED_LABEL = "seed:";
	private static final String INPUTDIR_LABEL = "inputdir:";
	private static final String OUTPUTDIR_LABEL = "outputdir:";

	public MothurMergeFilesOperator (OperatorDescription description) {
		super(description);
		// NOTE: Auto-generated constructor stub
	}

	@Override
	public void doWork() throws OperatorException {
		super.doWork();
		clearArguments();
		FileNameObject taxonomyFile = taxonomyInPort.getData(FileNameObject.class);
		addArgument("taxonomy",taxonomyFile.getName());
		FileNameObject fastaFile = fastaInPort.getData(FileNameObject.class);
		addArgument("fasta",fastaFile.getName());
		FileNameObject nameFile = nameInPort.getData(FileNameObject.class);
		addArgument("name",nameFile.getName());
		FileNameObject countFile = countInPort.getData(FileNameObject.class);
		addArgument("count",countFile.getName());
		String inputValue = getParameterAsString(INPUT_LABEL);
		addArgument("input",String.valueOf(inputValue));
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
		fastaOutPort.deliver(new FileNameObject(fileName+".fasta","fasta"));
		mergeOutPort.deliver(new FileNameObject(fileName+".merge","merge"));
	}

	@Override
	public List<ParameterType> getParameterTypes() {
		List<ParameterType> parameterTypes = super.getParameterTypes();
		parameterTypes.add(new ParameterTypeString(INPUT_LABEL, "TODO: Add description", "", false));
		parameterTypes.add(new ParameterTypeString(OUTPUT_LABEL, "TODO: Add description", "", false));
		parameterTypes.add(new ParameterTypeInt(SEED_LABEL, "TODO: Add description", -100000000, 100000000, 0, true));
		parameterTypes.add(new ParameterTypeString(INPUTDIR_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeString(OUTPUTDIR_LABEL, "TODO: Add description", "", true));
		return parameterTypes;
	}

	@Override
	public String getOutputPattern(String type) {
		if (type.equals("merge")) return "";
		if (type.equals("fasta")) return "[filename],merged,[extension]";
		return super.getOutputPattern(type);
	}
}
