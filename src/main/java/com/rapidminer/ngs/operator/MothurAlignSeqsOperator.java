package com.rapidminer.ngs.operator;

import java.util.List;
import com.rapidminer.operator.OperatorDescription;
import com.rapidminer.operator.ports.InputPort;
import com.rapidminer.operator.ports.OutputPort;
import com.rapidminer.operator.OperatorException;
import com.rapidminer.parameter.*;

public class MothurAlignSeqsOperator extends MothurGeneratedOperator {

	private InputPort fastaInPort = getInputPorts().createPort("fasta");
	private InputPort referenceInPort = getInputPorts().createPort("reference");
	private OutputPort fastaOutPort = getOutputPorts().createPort("fasta");
	private OutputPort accnosOutPort = getOutputPorts().createPort("accnos");
	private OutputPort alignreportOutPort = getOutputPorts().createPort("alignreport");
	public static final String[] ALIGN_CHOICES = { "blast", "gotoh", "needleman", "noalign" };
	public static final int ALIGN_DEFAULT_CHOICE = 2;
	private static final String ALIGN_LABEL = "align:";
	private static final String FLIP_LABEL = "flip:";
	private static final String GAPEXTEND_LABEL = "gapextend:";
	private static final String GAPOPEN_LABEL = "gapopen:";
	private static final String INPUTDIR_LABEL = "inputdir:";
	private static final String KSIZE_LABEL = "ksize:";
	private static final String MATCH_LABEL = "match:";
	private static final String MISMATCH_LABEL = "mismatch:";
	private static final String OUTPUTDIR_LABEL = "outputdir:";
	private static final String PROCESSORS_LABEL = "processors:";
	public static final String[] SEARCH_CHOICES = { "blast", "kmer", "suffix" };
	public static final int SEARCH_DEFAULT_CHOICE = 1;
	private static final String SEARCH_LABEL = "search:";
	private static final String SEED_LABEL = "seed:";
	private static final String THRESHOLD_LABEL = "threshold:";

	public MothurAlignSeqsOperator (OperatorDescription description) {
		super(description);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void doWork() throws OperatorException {
		super.doWork();
		clearArguments();
		FileNameObject fastaFile = fastaInPort.getData(FileNameObject.class);
		addArgument("fasta",fastaFile.getName());
		FileNameObject referenceFile = referenceInPort.getData(FileNameObject.class);
		addArgument("reference",referenceFile.getName());
		int alignIndex = getParameterAsInt(ALIGN_LABEL);
		String alignValue = ALIGN_CHOICES[alignIndex];
		addArgument("align",String.valueOf(alignValue));
		boolean flipValue = getParameterAsBoolean(FLIP_LABEL);
		addArgument("flip",String.valueOf(flipValue));
		int gapextendValue = getParameterAsInt(GAPEXTEND_LABEL);
		addArgument("gapextend",String.valueOf(gapextendValue));
		int gapopenValue = getParameterAsInt(GAPOPEN_LABEL);
		addArgument("gapopen",String.valueOf(gapopenValue));
		String inputdirValue = getParameterAsString(INPUTDIR_LABEL);
		addArgument("inputdir",String.valueOf(inputdirValue));
		int ksizeValue = getParameterAsInt(KSIZE_LABEL);
		addArgument("ksize",String.valueOf(ksizeValue));
		int matchValue = getParameterAsInt(MATCH_LABEL);
		addArgument("match",String.valueOf(matchValue));
		int mismatchValue = getParameterAsInt(MISMATCH_LABEL);
		addArgument("mismatch",String.valueOf(mismatchValue));
		String outputdirValue = getParameterAsString(OUTPUTDIR_LABEL);
		addArgument("outputdir",String.valueOf(outputdirValue));
		int processorsValue = getParameterAsInt(PROCESSORS_LABEL);
		addArgument("processors",String.valueOf(processorsValue));
		int searchIndex = getParameterAsInt(SEARCH_LABEL);
		String searchValue = SEARCH_CHOICES[searchIndex];
		addArgument("search",String.valueOf(searchValue));
		int seedValue = getParameterAsInt(SEED_LABEL);
		addArgument("seed",String.valueOf(seedValue));
		int thresholdValue = getParameterAsInt(THRESHOLD_LABEL);
		addArgument("threshold",String.valueOf(thresholdValue));
		executeMothurCommand();
		String fileName="<fileName>"; // TODO: Somehow figure out the fileName
		fastaOutPort.deliver(new FileNameObject(fileName+".fasta","fasta"));
		accnosOutPort.deliver(new FileNameObject(fileName+".accnos","accnos"));
		alignreportOutPort.deliver(new FileNameObject(fileName+".alignreport","alignreport"));
	}

	@Override
	public List<ParameterType> getParameterTypes() {
		List<ParameterType> parameterTypes = super.getParameterTypes();
		parameterTypes.add(new ParameterTypeCategory(ALIGN_LABEL, "TODO: Add description", ALIGN_CHOICES, ALIGN_DEFAULT_CHOICE));
		parameterTypes.add(new ParameterTypeBoolean(FLIP_LABEL, "TODO: Add description", true, true));
		parameterTypes.add(new ParameterTypeDouble(GAPEXTEND_LABEL, "TODO: Add description", -100000000, 100000000, -2.0, true));
		parameterTypes.add(new ParameterTypeDouble(GAPOPEN_LABEL, "TODO: Add description", -100000000, 100000000, -5.0, true));
		parameterTypes.add(new ParameterTypeString(INPUTDIR_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeInt(KSIZE_LABEL, "TODO: Add description", -100000000, 100000000, 8, true));
		parameterTypes.add(new ParameterTypeDouble(MATCH_LABEL, "TODO: Add description", -100000000, 100000000, 1.0, true));
		parameterTypes.add(new ParameterTypeDouble(MISMATCH_LABEL, "TODO: Add description", -100000000, 100000000, -1.0, true));
		parameterTypes.add(new ParameterTypeString(OUTPUTDIR_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeInt(PROCESSORS_LABEL, "TODO: Add description", -100000000, 100000000, 1, true));
		parameterTypes.add(new ParameterTypeCategory(SEARCH_LABEL, "TODO: Add description", SEARCH_CHOICES, SEARCH_DEFAULT_CHOICE));
		parameterTypes.add(new ParameterTypeInt(SEED_LABEL, "TODO: Add description", -100000000, 100000000, 0, true));
		parameterTypes.add(new ParameterTypeDouble(THRESHOLD_LABEL, "TODO: Add description", -100000000, 100000000, 0.50, true));
		return parameterTypes;
	}

	@Override
	public String getOutputPattern(String type) {
		// TODO Use a dictionary to reflect type to pattern
		if (type=="fasta") return "[filename],align";
		if (type=="accnos") return "[filename],flip.accnos";
		if (type=="alignreport") return "[filename],align.report";
		// TODO if nil then 
		return super.getOutputPattern(type);
	}
}
