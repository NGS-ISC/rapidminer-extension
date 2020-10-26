package com.rapidminer.ngs.operator;

import java.util.List;
import com.rapidminer.operator.OperatorDescription;
import com.rapidminer.operator.ports.InputPort;
import com.rapidminer.operator.ports.OutputPort;
import com.rapidminer.operator.OperatorException;
import com.rapidminer.parameter.*;

public class MothurDistSeqsOperator extends MothurGeneratedOperator {

	private InputPort columnInPort = getInputPorts().createPort("column");
	private InputPort oldfastaInPort = getInputPorts().createPort("oldfasta");
	private InputPort fastaInPort = getInputPorts().createPort("fasta");
	private OutputPort columnOutPort = getOutputPorts().createPort("column");
	private OutputPort phylipOutPort = getOutputPorts().createPort("phylip");
	private static final String[] OUTPUT_CHOICES = { "column", "lt", "square", "phylip" };
	private static final int OUTPUT_DEFAULT_CHOICE = 0;
	private static final String OUTPUT_LABEL = "output:";
	private static final String[] CALC_CHOICES = { "nogaps", "eachgap", "onegap" };
	private static final int CALC_DEFAULT_CHOICE = 2;
	private static final String CALC_LABEL = "calc:";
	private static final String COUNTENDS_LABEL = "countends:";
	private static final String FITCALC_LABEL = "fitcalc:";
	private static final String COMPRESS_LABEL = "compress:";
	private static final String PROCESSORS_LABEL = "processors:";
	private static final String CUTOFF_LABEL = "cutoff:";
	private static final String SEED_LABEL = "seed:";
	private static final String INPUTDIR_LABEL = "inputdir:";
	private static final String OUTPUTDIR_LABEL = "outputdir:";

	public MothurDistSeqsOperator (OperatorDescription description) {
		super(description);
		// NOTE: Auto-generated constructor stub
	}

	@Override
	public void doWork() throws OperatorException {
		super.doWork();
		clearArguments();
		FileNameObject columnFile = columnInPort.getData(FileNameObject.class);
		addArgument("column",columnFile.getName());
		FileNameObject oldfastaFile = oldfastaInPort.getData(FileNameObject.class);
		addArgument("oldfasta",oldfastaFile.getName());
		FileNameObject fastaFile = fastaInPort.getData(FileNameObject.class);
		addArgument("fasta",fastaFile.getName());
		int outputIndex = getParameterAsInt(OUTPUT_LABEL);
		String outputValue = OUTPUT_CHOICES[outputIndex];
		addArgument("output",String.valueOf(outputValue));
		int calcIndex = getParameterAsInt(CALC_LABEL);
		String calcValue = CALC_CHOICES[calcIndex];
		addArgument("calc",String.valueOf(calcValue));
		boolean countendsValue = getParameterAsBoolean(COUNTENDS_LABEL);
		addArgument("countends",String.valueOf(countendsValue));
		boolean fitcalcValue = getParameterAsBoolean(FITCALC_LABEL);
		addArgument("fitcalc",String.valueOf(fitcalcValue));
		boolean compressValue = getParameterAsBoolean(COMPRESS_LABEL);
		addArgument("compress",String.valueOf(compressValue));
		int processorsValue = getParameterAsInt(PROCESSORS_LABEL);
		addArgument("processors",String.valueOf(processorsValue));
		int cutoffValue = getParameterAsInt(CUTOFF_LABEL);
		addArgument("cutoff",String.valueOf(cutoffValue));
		int seedValue = getParameterAsInt(SEED_LABEL);
		addArgument("seed",String.valueOf(seedValue));
		String inputdirValue = getParameterAsString(INPUTDIR_LABEL);
		addArgument("inputdir",String.valueOf(inputdirValue));
		String outputdirValue = getParameterAsString(OUTPUTDIR_LABEL);
		addArgument("outputdir",String.valueOf(outputdirValue));
		executeMothurCommand();
		String fileName="<fileName>"; // TODO: Somehow figure out the fileName
		columnOutPort.deliver(new FileNameObject(fileName+".column","column"));
		phylipOutPort.deliver(new FileNameObject(fileName+".phylip","phylip"));
	}

	@Override
	public List<ParameterType> getParameterTypes() {
		List<ParameterType> parameterTypes = super.getParameterTypes();
		parameterTypes.add(new ParameterTypeCategory(OUTPUT_LABEL, "TODO: Add description", OUTPUT_CHOICES, OUTPUT_DEFAULT_CHOICE));
		parameterTypes.add(new ParameterTypeCategory(CALC_LABEL, "TODO: Add description", CALC_CHOICES, CALC_DEFAULT_CHOICE));
		parameterTypes.add(new ParameterTypeBoolean(COUNTENDS_LABEL, "TODO: Add description", true, true));
		parameterTypes.add(new ParameterTypeBoolean(FITCALC_LABEL, "TODO: Add description", false, true));
		parameterTypes.add(new ParameterTypeBoolean(COMPRESS_LABEL, "TODO: Add description", false, true));
		parameterTypes.add(new ParameterTypeInt(PROCESSORS_LABEL, "TODO: Add description", -100000000, 100000000, 1, true));
		parameterTypes.add(new ParameterTypeDouble(CUTOFF_LABEL, "TODO: Add description", -100000000, 100000000, 1.0, true));
		parameterTypes.add(new ParameterTypeInt(SEED_LABEL, "TODO: Add description", -100000000, 100000000, 0, true));
		parameterTypes.add(new ParameterTypeString(INPUTDIR_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeString(OUTPUTDIR_LABEL, "TODO: Add description", "", true));
		return parameterTypes;
	}

	@Override
	public String getOutputPattern(String type) {
		if (type.equals("column")) return "[filename],dist-[filename],[outputtag],dist";
		if (type.equals("phylip")) return "[filename],[outputtag],dist";
		return super.getOutputPattern(type);
	}
}
