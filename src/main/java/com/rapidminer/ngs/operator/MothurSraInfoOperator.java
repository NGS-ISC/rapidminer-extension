package com.rapidminer.ngs.operator;

import java.util.List;
import com.rapidminer.operator.OperatorDescription;
import com.rapidminer.operator.ports.InputPort;
import com.rapidminer.operator.ports.OutputPort;
import com.rapidminer.operator.OperatorException;
import com.rapidminer.parameter.*;

public class MothurSraInfoOperator extends MothurGeneratedOperator {

	private InputPort accnosInPort = getInputPorts().createPort("accnos");
	private OutputPort fastqOutPort = getOutputPorts().createPort("fastq");
	private OutputPort fileOutPort = getOutputPorts().createPort("file");
	private OutputPort sraOutPort = getOutputPorts().createPort("sra");
	private static final String PREFETCH_LABEL = "prefetch:";
	private static final String FASTERQ_LABEL = "fasterq:";
	private static final String GZ_LABEL = "gz:";
	private static final String PROCESSORS_LABEL = "processors:";
	private static final String MAXSIZE_LABEL = "maxsize:";
	private static final String SEED_LABEL = "seed:";
	private static final String INPUTDIR_LABEL = "inputdir:";
	private static final String OUTPUTDIR_LABEL = "outputdir:";

	public MothurSraInfoOperator (OperatorDescription description) {
		super(description);
		// NOTE: Auto-generated constructor stub
	}

	@Override
	public void doWork() throws OperatorException {
		super.doWork();
		clearArguments();
		FileNameObject accnosFile = accnosInPort.getData(FileNameObject.class);
		addArgument("accnos",accnosFile.getName());
		String prefetchValue = getParameterAsString(PREFETCH_LABEL);
		addArgument("prefetch",String.valueOf(prefetchValue));
		String fasterqValue = getParameterAsString(FASTERQ_LABEL);
		addArgument("fasterq",String.valueOf(fasterqValue));
		boolean gzValue = getParameterAsBoolean(GZ_LABEL);
		addArgument("gz",String.valueOf(gzValue));
		int processorsValue = getParameterAsInt(PROCESSORS_LABEL);
		addArgument("processors",String.valueOf(processorsValue));
		int maxsizeValue = getParameterAsInt(MAXSIZE_LABEL);
		addArgument("maxsize",String.valueOf(maxsizeValue));
		int seedValue = getParameterAsInt(SEED_LABEL);
		addArgument("seed",String.valueOf(seedValue));
		String inputdirValue = getParameterAsString(INPUTDIR_LABEL);
		addArgument("inputdir",String.valueOf(inputdirValue));
		String outputdirValue = getParameterAsString(OUTPUTDIR_LABEL);
		addArgument("outputdir",String.valueOf(outputdirValue));
		executeMothurCommand();
		String fileName="<fileName>"; // TODO: Somehow figure out the fileName
		fastqOutPort.deliver(new FileNameObject(fileName+".fastq","fastq"));
		fileOutPort.deliver(new FileNameObject(fileName+".file","file"));
		sraOutPort.deliver(new FileNameObject(fileName+".sra","sra"));
	}

	@Override
	public List<ParameterType> getParameterTypes() {
		List<ParameterType> parameterTypes = super.getParameterTypes();
		parameterTypes.add(new ParameterTypeString(PREFETCH_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeString(FASTERQ_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeBoolean(GZ_LABEL, "TODO: Add description", false, true));
		parameterTypes.add(new ParameterTypeInt(PROCESSORS_LABEL, "TODO: Add description", -100000000, 100000000, 1, true));
		parameterTypes.add(new ParameterTypeInt(MAXSIZE_LABEL, "TODO: Add description", -100000000, 100000000, 20, true));
		parameterTypes.add(new ParameterTypeInt(SEED_LABEL, "TODO: Add description", -100000000, 100000000, 0, true));
		parameterTypes.add(new ParameterTypeString(INPUTDIR_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeString(OUTPUTDIR_LABEL, "TODO: Add description", "", true));
		return parameterTypes;
	}

	@Override
	public String getOutputPattern(String type) {
		if (type.equals("sra")) return "[filename],sra";
		if (type.equals("file")) return "[filename],[tag],files";
		if (type.equals("fastq")) return "[filename],fastq";
		return super.getOutputPattern(type);
	}
}
