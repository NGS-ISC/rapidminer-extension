package com.rapidminer.ngs.operator;

import java.util.List;
import com.rapidminer.operator.OperatorDescription;
import com.rapidminer.operator.ports.InputPort;
import com.rapidminer.operator.ports.OutputPort;
import com.rapidminer.operator.OperatorException;
import com.rapidminer.parameter.*;

public class MothurMakeFastqOperator extends MothurGeneratedOperator {

	private InputPort fastaInPort = getInputPorts().createPort("fasta");
	private InputPort qfileInPort = getInputPorts().createPort("qfile");
	private OutputPort fastqOutPort = getOutputPorts().createPort("fastq");
	private static final String[] FORMAT_CHOICES = { "sanger", "illumina", "solexa", "illumina1.8+" };
	private static final int FORMAT_DEFAULT_CHOICE = 3;
	private static final String FORMAT_LABEL = "format:";
	private static final String SEED_LABEL = "seed:";
	private static final String INPUTDIR_LABEL = "inputdir:";
	private static final String OUTPUTDIR_LABEL = "outputdir:";

	public MothurMakeFastqOperator (OperatorDescription description) {
		super(description);
		// NOTE: Auto-generated constructor stub
	}

	@Override
	public void doWork() throws OperatorException {
		super.doWork();
		clearArguments();
		FileNameObject fastaFile = fastaInPort.getData(FileNameObject.class);
		addArgument("fasta",fastaFile.getName());
		FileNameObject qfileFile = qfileInPort.getData(FileNameObject.class);
		addArgument("qfile",qfileFile.getName());
		int formatIndex = getParameterAsInt(FORMAT_LABEL);
		String formatValue = FORMAT_CHOICES[formatIndex];
		addArgument("format",String.valueOf(formatValue));
		int seedValue = getParameterAsInt(SEED_LABEL);
		addArgument("seed",String.valueOf(seedValue));
		String inputdirValue = getParameterAsString(INPUTDIR_LABEL);
		addArgument("inputdir",String.valueOf(inputdirValue));
		String outputdirValue = getParameterAsString(OUTPUTDIR_LABEL);
		addArgument("outputdir",String.valueOf(outputdirValue));
		executeMothurCommand();
		String fileName="<fileName>"; // TODO: Somehow figure out the fileName
		fastqOutPort.deliver(new FileNameObject(fileName+".fastq","fastq"));
	}

	@Override
	public List<ParameterType> getParameterTypes() {
		List<ParameterType> parameterTypes = super.getParameterTypes();
		parameterTypes.add(new ParameterTypeCategory(FORMAT_LABEL, "TODO: Add description", FORMAT_CHOICES, FORMAT_DEFAULT_CHOICE));
		parameterTypes.add(new ParameterTypeInt(SEED_LABEL, "TODO: Add description", -100000000, 100000000, 0, true));
		parameterTypes.add(new ParameterTypeString(INPUTDIR_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeString(OUTPUTDIR_LABEL, "TODO: Add description", "", true));
		return parameterTypes;
	}

	@Override
	public String getOutputPattern(String type) {
		if (type.equals("fastq")) return "[filename],fastq";
		return super.getOutputPattern(type);
	}
}
