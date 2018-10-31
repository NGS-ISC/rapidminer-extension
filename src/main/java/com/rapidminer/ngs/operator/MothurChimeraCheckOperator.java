package com.rapidminer.ngs.operator;

import java.util.List;
import com.rapidminer.operator.OperatorDescription;
import com.rapidminer.operator.ports.InputPort;
import com.rapidminer.operator.ports.OutputPort;
import com.rapidminer.operator.OperatorException;
import com.rapidminer.parameter.*;

public class MothurChimeraCheckOperator extends MothurGeneratedOperator {

	private InputPort referenceInPort = getInputPorts().createPort("reference");
	private InputPort fastaInPort = getInputPorts().createPort("fasta");
	private InputPort nameInPort = getInputPorts().createPort("name");
	private OutputPort chimeraOutPort = getOutputPorts().createPort("chimera");
	private static final String SVG_LABEL = "svg:";
	private static final String INCREMENT_LABEL = "increment:";
	private static final String KSIZE_LABEL = "ksize:";
	private static final String SEED_LABEL = "seed:";
	private static final String INPUTDIR_LABEL = "inputdir:";
	private static final String OUTPUTDIR_LABEL = "outputdir:";

	public MothurChimeraCheckOperator (OperatorDescription description) {
		super(description);
		// NOTE: Auto-generated constructor stub
	}

	@Override
	public void doWork() throws OperatorException {
		super.doWork();
		clearArguments();
		FileNameObject referenceFile = referenceInPort.getData(FileNameObject.class);
		addArgument("reference",referenceFile.getName());
		FileNameObject fastaFile = fastaInPort.getData(FileNameObject.class);
		addArgument("fasta",fastaFile.getName());
		FileNameObject nameFile = nameInPort.getData(FileNameObject.class);
		addArgument("name",nameFile.getName());
		boolean svgValue = getParameterAsBoolean(SVG_LABEL);
		addArgument("svg",String.valueOf(svgValue));
		int incrementValue = getParameterAsInt(INCREMENT_LABEL);
		addArgument("increment",String.valueOf(incrementValue));
		int ksizeValue = getParameterAsInt(KSIZE_LABEL);
		addArgument("ksize",String.valueOf(ksizeValue));
		int seedValue = getParameterAsInt(SEED_LABEL);
		addArgument("seed",String.valueOf(seedValue));
		String inputdirValue = getParameterAsString(INPUTDIR_LABEL);
		addArgument("inputdir",String.valueOf(inputdirValue));
		String outputdirValue = getParameterAsString(OUTPUTDIR_LABEL);
		addArgument("outputdir",String.valueOf(outputdirValue));
		executeMothurCommand();
		String fileName="<fileName>"; // TODO: Somehow figure out the fileName
		chimeraOutPort.deliver(new FileNameObject(fileName+".chimera","chimera"));
	}

	@Override
	public List<ParameterType> getParameterTypes() {
		List<ParameterType> parameterTypes = super.getParameterTypes();
		parameterTypes.add(new ParameterTypeBoolean(SVG_LABEL, "TODO: Add description", false, true));
		parameterTypes.add(new ParameterTypeInt(INCREMENT_LABEL, "TODO: Add description", -100000000, 100000000, 10, true));
		parameterTypes.add(new ParameterTypeInt(KSIZE_LABEL, "TODO: Add description", -100000000, 100000000, 7, true));
		parameterTypes.add(new ParameterTypeInt(SEED_LABEL, "TODO: Add description", -100000000, 100000000, 0, true));
		parameterTypes.add(new ParameterTypeString(INPUTDIR_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeString(OUTPUTDIR_LABEL, "TODO: Add description", "", true));
		return parameterTypes;
	}

	@Override
	public String getOutputPattern(String type) {
		if (type.equals("chimera")) return "[filename],chimeracheck.chimeras";
		return super.getOutputPattern(type);
	}
}
