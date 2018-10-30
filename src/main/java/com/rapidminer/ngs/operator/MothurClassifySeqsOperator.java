package com.rapidminer.ngs.operator;

import java.util.List;
import com.rapidminer.operator.OperatorDescription;
import com.rapidminer.operator.ports.InputPort;
import com.rapidminer.operator.ports.OutputPort;
import com.rapidminer.operator.OperatorException;
import com.rapidminer.parameter.*;

public class MothurClassifySeqsOperator extends MothurGeneratedOperator {

	private InputPort countInPort = getInputPorts().createPort("count");
	private InputPort fastaInPort = getInputPorts().createPort("fasta");
	private InputPort groupInPort = getInputPorts().createPort("group");
	private InputPort nameInPort = getInputPorts().createPort("name");
	private InputPort referenceInPort = getInputPorts().createPort("reference");
	private InputPort taxonomyInPort = getInputPorts().createPort("taxonomy");
	private OutputPort taxsummaryOutPort = getOutputPorts().createPort("taxsummary");
	private OutputPort matchdistOutPort = getOutputPorts().createPort("matchdist");
	private OutputPort accnosOutPort = getOutputPorts().createPort("accnos");
	private OutputPort taxonomyOutPort = getOutputPorts().createPort("taxonomy");
	private static final String CUTOFF_LABEL = "cutoff:";
	private static final String GAPEXTEND_LABEL = "gapextend:";
	private static final String GAPOPEN_LABEL = "gapopen:";
	private static final String INPUTDIR_LABEL = "inputdir:";
	private static final String ITERS_LABEL = "iters:";
	private static final String KSIZE_LABEL = "ksize:";
	private static final String MATCH_LABEL = "match:";
	public static final String[] METHOD_CHOICES = { "knn", "wang", "zap" };
	public static final int METHOD_DEFAULT_CHOICE = 1;
	private static final String METHOD_LABEL = "method:";
	private static final String MISMATCH_LABEL = "mismatch:";
	private static final String NUMWANTED_LABEL = "numwanted:";
	public static final String[] OUTPUT_CHOICES = { "detail", "simple" };
	public static final int OUTPUT_DEFAULT_CHOICE = 0;
	private static final String OUTPUT_LABEL = "output:";
	private static final String OUTPUTDIR_LABEL = "outputdir:";
	private static final String PRINTLEVEL_LABEL = "printlevel:";
	private static final String PROBS_LABEL = "probs:";
	private static final String PROCESSORS_LABEL = "processors:";
	private static final String RELABUND_LABEL = "relabund:";
	public static final String[] SEARCH_CHOICES = { "align", "blast", "distance", "kmer", "suffix" };
	public static final int SEARCH_DEFAULT_CHOICE = 3;
	private static final String SEARCH_LABEL = "search:";
	private static final String SEED_LABEL = "seed:";
	private static final String SHORTCUTS_LABEL = "shortcuts:";

	public MothurClassifySeqsOperator (OperatorDescription description) {
		super(description);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void doWork() throws OperatorException {
		super.doWork();
		clearArguments();
		FileNameObject countFile = countInPort.getData(FileNameObject.class);
		addArgument("count",countFile.getName());
		FileNameObject fastaFile = fastaInPort.getData(FileNameObject.class);
		addArgument("fasta",fastaFile.getName());
		FileNameObject groupFile = groupInPort.getData(FileNameObject.class);
		addArgument("group",groupFile.getName());
		FileNameObject nameFile = nameInPort.getData(FileNameObject.class);
		addArgument("name",nameFile.getName());
		FileNameObject referenceFile = referenceInPort.getData(FileNameObject.class);
		addArgument("reference",referenceFile.getName());
		FileNameObject taxonomyFile = taxonomyInPort.getData(FileNameObject.class);
		addArgument("taxonomy",taxonomyFile.getName());
		int cutoffValue = getParameterAsInt(CUTOFF_LABEL);
		addArgument("cutoff",String.valueOf(cutoffValue));
		int gapextendValue = getParameterAsInt(GAPEXTEND_LABEL);
		addArgument("gapextend",String.valueOf(gapextendValue));
		int gapopenValue = getParameterAsInt(GAPOPEN_LABEL);
		addArgument("gapopen",String.valueOf(gapopenValue));
		String inputdirValue = getParameterAsString(INPUTDIR_LABEL);
		addArgument("inputdir",String.valueOf(inputdirValue));
		int itersValue = getParameterAsInt(ITERS_LABEL);
		addArgument("iters",String.valueOf(itersValue));
		int ksizeValue = getParameterAsInt(KSIZE_LABEL);
		addArgument("ksize",String.valueOf(ksizeValue));
		int matchValue = getParameterAsInt(MATCH_LABEL);
		addArgument("match",String.valueOf(matchValue));
		int methodIndex = getParameterAsInt(METHOD_LABEL);
		String methodValue = METHOD_CHOICES[methodIndex];
		addArgument("method",String.valueOf(methodValue));
		int mismatchValue = getParameterAsInt(MISMATCH_LABEL);
		addArgument("mismatch",String.valueOf(mismatchValue));
		int numwantedValue = getParameterAsInt(NUMWANTED_LABEL);
		addArgument("numwanted",String.valueOf(numwantedValue));
		int outputIndex = getParameterAsInt(OUTPUT_LABEL);
		String outputValue = OUTPUT_CHOICES[outputIndex];
		addArgument("output",String.valueOf(outputValue));
		String outputdirValue = getParameterAsString(OUTPUTDIR_LABEL);
		addArgument("outputdir",String.valueOf(outputdirValue));
		int printlevelValue = getParameterAsInt(PRINTLEVEL_LABEL);
		addArgument("printlevel",String.valueOf(printlevelValue));
		boolean probsValue = getParameterAsBoolean(PROBS_LABEL);
		addArgument("probs",String.valueOf(probsValue));
		int processorsValue = getParameterAsInt(PROCESSORS_LABEL);
		addArgument("processors",String.valueOf(processorsValue));
		boolean relabundValue = getParameterAsBoolean(RELABUND_LABEL);
		addArgument("relabund",String.valueOf(relabundValue));
		int searchIndex = getParameterAsInt(SEARCH_LABEL);
		String searchValue = SEARCH_CHOICES[searchIndex];
		addArgument("search",String.valueOf(searchValue));
		int seedValue = getParameterAsInt(SEED_LABEL);
		addArgument("seed",String.valueOf(seedValue));
		boolean shortcutsValue = getParameterAsBoolean(SHORTCUTS_LABEL);
		addArgument("shortcuts",String.valueOf(shortcutsValue));
		executeMothurCommand();
		String fileName="<fileName>"; // TODO: Somehow figure out the fileName
		taxsummaryOutPort.deliver(new FileNameObject(fileName+".taxsummary","taxsummary"));
		matchdistOutPort.deliver(new FileNameObject(fileName+".matchdist","matchdist"));
		accnosOutPort.deliver(new FileNameObject(fileName+".accnos","accnos"));
		taxonomyOutPort.deliver(new FileNameObject(fileName+".taxonomy","taxonomy"));
	}

	@Override
	public List<ParameterType> getParameterTypes() {
		List<ParameterType> parameterTypes = super.getParameterTypes();
		parameterTypes.add(new ParameterTypeInt(CUTOFF_LABEL, "TODO: Add description", -100000000, 100000000, 80, false));
		parameterTypes.add(new ParameterTypeDouble(GAPEXTEND_LABEL, "TODO: Add description", -100000000, 100000000, -1.0, true));
		parameterTypes.add(new ParameterTypeDouble(GAPOPEN_LABEL, "TODO: Add description", -100000000, 100000000, -2.0, true));
		parameterTypes.add(new ParameterTypeString(INPUTDIR_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeInt(ITERS_LABEL, "TODO: Add description", -100000000, 100000000, 100, false));
		parameterTypes.add(new ParameterTypeInt(KSIZE_LABEL, "TODO: Add description", -100000000, 100000000, 8, true));
		parameterTypes.add(new ParameterTypeDouble(MATCH_LABEL, "TODO: Add description", -100000000, 100000000, 1.0, true));
		parameterTypes.add(new ParameterTypeCategory(METHOD_LABEL, "TODO: Add description", METHOD_CHOICES, METHOD_DEFAULT_CHOICE));
		parameterTypes.add(new ParameterTypeDouble(MISMATCH_LABEL, "TODO: Add description", -100000000, 100000000, -1.0, true));
		parameterTypes.add(new ParameterTypeInt(NUMWANTED_LABEL, "TODO: Add description", -100000000, 100000000, 10, false));
		parameterTypes.add(new ParameterTypeCategory(OUTPUT_LABEL, "TODO: Add description", OUTPUT_CHOICES, OUTPUT_DEFAULT_CHOICE));
		parameterTypes.add(new ParameterTypeString(OUTPUTDIR_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeInt(PRINTLEVEL_LABEL, "TODO: Add description", -100000000, 100000000, -1, true));
		parameterTypes.add(new ParameterTypeBoolean(PROBS_LABEL, "TODO: Add description", true, true));
		parameterTypes.add(new ParameterTypeInt(PROCESSORS_LABEL, "TODO: Add description", -100000000, 100000000, 1, true));
		parameterTypes.add(new ParameterTypeBoolean(RELABUND_LABEL, "TODO: Add description", false, true));
		parameterTypes.add(new ParameterTypeCategory(SEARCH_LABEL, "TODO: Add description", SEARCH_CHOICES, SEARCH_DEFAULT_CHOICE));
		parameterTypes.add(new ParameterTypeInt(SEED_LABEL, "TODO: Add description", -100000000, 100000000, 0, true));
		parameterTypes.add(new ParameterTypeBoolean(SHORTCUTS_LABEL, "TODO: Add description", true, true));
		return parameterTypes;
	}

	@Override
	public String getOutputPattern(String type) {
		// TODO Use a dictionary to reflect type to pattern
		if (type=="taxsummary") return "[filename],[tag],[tag2],tax.summary";
		if (type=="matchdist") return "[filename],[tag],[tag2],match.dist";
		if (type=="accnos") return "[filename],[tag],[tag2],flip.accnos";
		if (type=="taxonomy") return "[filename],[tag],[tag2],taxonomy";
		// TODO if nil then 
		return super.getOutputPattern(type);
	}
}
