package com.rapidminer.ngs.operator;

import java.util.List;
import com.rapidminer.operator.OperatorDescription;
import com.rapidminer.operator.ports.InputPort;
import com.rapidminer.operator.ports.OutputPort;
import com.rapidminer.operator.OperatorException;
import com.rapidminer.parameter.*;

public class MothurDistSeqsOperator extends MothurGeneratedOperator {

	private InputPort columnInPort = getInputPorts().createPort("column");
	private InputPort fastaInPort = getInputPorts().createPort("fasta");
	private InputPort oldfastaInPort = getInputPorts().createPort("oldfasta");
	private OutputPort columnOutPort = getOutputPorts().createPort("column");
	private OutputPort phylipOutPort = getOutputPorts().createPort("phylip");
	public static final String[] CALC_CHOICES = { "eachgap", "nogaps", "onegap" };
	public static final int CALC_DEFAULT_CHOICE = 2;
	private static final String CALC_LABEL = "calc:";
	private static final String COMPRESS_LABEL = "compress:";
	private static final String COUNTENDS_LABEL = "countends:";
	private static final String CUTOFF_LABEL = "cutoff:";
	private static final String FITCALC_LABEL = "fitcalc:";
	private static final String INPUTDIR_LABEL = "inputdir:";
	public static final String[] OUTPUT_CHOICES = { "column", "lt", "phylip", "square" };
	public static final int OUTPUT_DEFAULT_CHOICE = 0;
	private static final String OUTPUT_LABEL = "output:";
	private static final String OUTPUTDIR_LABEL = "outputdir:";
	private static final String PROCESSORS_LABEL = "processors:";
	private static final String SEED_LABEL = "seed:";

	public MothurDistSeqsOperator (OperatorDescription description) {
		super(description);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void doWork() throws OperatorException {
		super.doWork();
		clearArguments();
		FileNameObject columnFile = columnInPort.getData(FileNameObject.class);
		addArgument("column",columnFile.getName());
		FileNameObject fastaFile = fastaInPort.getData(FileNameObject.class);
		addArgument("fasta",fastaFile.getName());
		FileNameObject oldfastaFile = oldfastaInPort.getData(FileNameObject.class);
		addArgument("oldfasta",oldfastaFile.getName());
		int calcIndex = getParameterAsInt(CALC_LABEL);
		String calcValue = CALC_CHOICES[calcIndex];
		addArgument("calc",String.valueOf(calcValue));
		boolean compressValue = getParameterAsBoolean(COMPRESS_LABEL);
		addArgument("compress",String.valueOf(compressValue));
		boolean countendsValue = getParameterAsBoolean(COUNTENDS_LABEL);
		addArgument("countends",String.valueOf(countendsValue));
		int cutoffValue = getParameterAsInt(CUTOFF_LABEL);
		addArgument("cutoff",String.valueOf(cutoffValue));
		boolean fitcalcValue = getParameterAsBoolean(FITCALC_LABEL);
		addArgument("fitcalc",String.valueOf(fitcalcValue));
		String inputdirValue = getParameterAsString(INPUTDIR_LABEL);
		addArgument("inputdir",String.valueOf(inputdirValue));
		int outputIndex = getParameterAsInt(OUTPUT_LABEL);
		String outputValue = OUTPUT_CHOICES[outputIndex];
		addArgument("output",String.valueOf(outputValue));
		String outputdirValue = getParameterAsString(OUTPUTDIR_LABEL);
		addArgument("outputdir",String.valueOf(outputdirValue));
		int processorsValue = getParameterAsInt(PROCESSORS_LABEL);
		addArgument("processors",String.valueOf(processorsValue));
		int seedValue = getParameterAsInt(SEED_LABEL);
		addArgument("seed",String.valueOf(seedValue));
		executeMothurCommand();
		String fileName="<fileName>"; // TODO: Somehow figure out the fileName
		columnOutPort.deliver(new FileNameObject(fileName+".column","column"));
		phylipOutPort.deliver(new FileNameObject(fileName+".phylip","phylip"));
	}

	@Override
	public List<ParameterType> getParameterTypes() {
		List<ParameterType> parameterTypes = super.getParameterTypes();
		parameterTypes.add(new ParameterTypeCategory(CALC_LABEL, "TODO: Add description", CALC_CHOICES, CALC_DEFAULT_CHOICE));
		parameterTypes.add(new ParameterTypeBoolean(COMPRESS_LABEL, "TODO: Add description", false, true));
		parameterTypes.add(new ParameterTypeBoolean(COUNTENDS_LABEL, "TODO: Add description", true, true));
		parameterTypes.add(new ParameterTypeDouble(CUTOFF_LABEL, "TODO: Add description", -100000000, 100000000, 1.0, true));
		parameterTypes.add(new ParameterTypeBoolean(FITCALC_LABEL, "TODO: Add description", false, true));
		parameterTypes.add(new ParameterTypeString(INPUTDIR_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeCategory(OUTPUT_LABEL, "TODO: Add description", OUTPUT_CHOICES, OUTPUT_DEFAULT_CHOICE));
		parameterTypes.add(new ParameterTypeString(OUTPUTDIR_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeInt(PROCESSORS_LABEL, "TODO: Add description", -100000000, 100000000, 1, true));
		parameterTypes.add(new ParameterTypeInt(SEED_LABEL, "TODO: Add description", -100000000, 100000000, 0, true));
		return parameterTypes;
	}

	@Override
	public String getOutputPattern(String type) {
		// TODO Use a dictionary to reflect type to pattern
		if (type=="column") return "[filename],dist";
		if (type=="phylip") return "[filename],[outputtag],dist";
		// TODO if nil then 
		return super.getOutputPattern(type);
	}
}
