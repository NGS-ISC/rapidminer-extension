package com.rapidminer.ngs.operator;

import java.util.List;
import com.rapidminer.operator.OperatorDescription;
import com.rapidminer.operator.ports.InputPort;
import com.rapidminer.operator.ports.OutputPort;
import com.rapidminer.operator.OperatorException;
import com.rapidminer.parameter.*;

public class MothurChimeraSlayerOperator extends MothurGeneratedOperator {

	private InputPort referenceInPort = getInputPorts().createPort("reference");
	private InputPort fastaInPort = getInputPorts().createPort("fasta");
	private InputPort nameInPort = getInputPorts().createPort("name");
	private InputPort countInPort = getInputPorts().createPort("count");
	private InputPort groupInPort = getInputPorts().createPort("group");
	private OutputPort accnosOutPort = getOutputPorts().createPort("accnos");
	private OutputPort chimeraOutPort = getOutputPorts().createPort("chimera");
	private OutputPort countOutPort = getOutputPorts().createPort("count");
	private OutputPort fastaOutPort = getOutputPorts().createPort("fasta");
	private static final String WINDOW_LABEL = "window:";
	private static final String KSIZE_LABEL = "ksize:";
	private static final String MATCH_LABEL = "match:";
	private static final String MISMATCH_LABEL = "mismatch:";
	private static final String MINSIM_LABEL = "minsim:";
	private static final String MINCOV_LABEL = "mincov:";
	private static final String MINSNP_LABEL = "minsnp:";
	private static final String MINBS_LABEL = "minbs:";
	private static final String[] SEARCH_CHOICES = { "kmer", "blast" };
	private static final int SEARCH_DEFAULT_CHOICE = 1;
	private static final String SEARCH_LABEL = "search:";
	private static final String REALIGN_LABEL = "realign:";
	private static final String TRIM_LABEL = "trim:";
	private static final String SPLIT_LABEL = "split:";
	private static final String NUMWANTED_LABEL = "numwanted:";
	private static final String ITERS_LABEL = "iters:";
	private static final String DIVERGENCE_LABEL = "divergence:";
	private static final String DEREPLICATE_LABEL = "dereplicate:";
	private static final String PARENTS_LABEL = "parents:";
	private static final String INCREMENT_LABEL = "increment:";
	private static final String BLASTLOCATION_LABEL = "blastlocation:";
	private static final String SEED_LABEL = "seed:";
	private static final String INPUTDIR_LABEL = "inputdir:";
	private static final String OUTPUTDIR_LABEL = "outputdir:";

	public MothurChimeraSlayerOperator (OperatorDescription description) {
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
		FileNameObject countFile = countInPort.getData(FileNameObject.class);
		addArgument("count",countFile.getName());
		FileNameObject groupFile = groupInPort.getData(FileNameObject.class);
		addArgument("group",groupFile.getName());
		int windowValue = getParameterAsInt(WINDOW_LABEL);
		addArgument("window",String.valueOf(windowValue));
		int ksizeValue = getParameterAsInt(KSIZE_LABEL);
		addArgument("ksize",String.valueOf(ksizeValue));
		int matchValue = getParameterAsInt(MATCH_LABEL);
		addArgument("match",String.valueOf(matchValue));
		int mismatchValue = getParameterAsInt(MISMATCH_LABEL);
		addArgument("mismatch",String.valueOf(mismatchValue));
		int minsimValue = getParameterAsInt(MINSIM_LABEL);
		addArgument("minsim",String.valueOf(minsimValue));
		int mincovValue = getParameterAsInt(MINCOV_LABEL);
		addArgument("mincov",String.valueOf(mincovValue));
		int minsnpValue = getParameterAsInt(MINSNP_LABEL);
		addArgument("minsnp",String.valueOf(minsnpValue));
		int minbsValue = getParameterAsInt(MINBS_LABEL);
		addArgument("minbs",String.valueOf(minbsValue));
		int searchIndex = getParameterAsInt(SEARCH_LABEL);
		String searchValue = SEARCH_CHOICES[searchIndex];
		addArgument("search",String.valueOf(searchValue));
		boolean realignValue = getParameterAsBoolean(REALIGN_LABEL);
		addArgument("realign",String.valueOf(realignValue));
		boolean trimValue = getParameterAsBoolean(TRIM_LABEL);
		addArgument("trim",String.valueOf(trimValue));
		boolean splitValue = getParameterAsBoolean(SPLIT_LABEL);
		addArgument("split",String.valueOf(splitValue));
		int numwantedValue = getParameterAsInt(NUMWANTED_LABEL);
		addArgument("numwanted",String.valueOf(numwantedValue));
		int itersValue = getParameterAsInt(ITERS_LABEL);
		addArgument("iters",String.valueOf(itersValue));
		int divergenceValue = getParameterAsInt(DIVERGENCE_LABEL);
		addArgument("divergence",String.valueOf(divergenceValue));
		boolean dereplicateValue = getParameterAsBoolean(DEREPLICATE_LABEL);
		addArgument("dereplicate",String.valueOf(dereplicateValue));
		int parentsValue = getParameterAsInt(PARENTS_LABEL);
		addArgument("parents",String.valueOf(parentsValue));
		int incrementValue = getParameterAsInt(INCREMENT_LABEL);
		addArgument("increment",String.valueOf(incrementValue));
		String blastlocationValue = getParameterAsString(BLASTLOCATION_LABEL);
		addArgument("blastlocation",String.valueOf(blastlocationValue));
		int seedValue = getParameterAsInt(SEED_LABEL);
		addArgument("seed",String.valueOf(seedValue));
		String inputdirValue = getParameterAsString(INPUTDIR_LABEL);
		addArgument("inputdir",String.valueOf(inputdirValue));
		String outputdirValue = getParameterAsString(OUTPUTDIR_LABEL);
		addArgument("outputdir",String.valueOf(outputdirValue));
		executeMothurCommand();
		String fileName="<fileName>"; // TODO: Somehow figure out the fileName
		accnosOutPort.deliver(new FileNameObject(fileName+".accnos","accnos"));
		chimeraOutPort.deliver(new FileNameObject(fileName+".chimera","chimera"));
		countOutPort.deliver(new FileNameObject(fileName+".count","count"));
		fastaOutPort.deliver(new FileNameObject(fileName+".fasta","fasta"));
	}

	@Override
	public List<ParameterType> getParameterTypes() {
		List<ParameterType> parameterTypes = super.getParameterTypes();
		parameterTypes.add(new ParameterTypeInt(WINDOW_LABEL, "TODO: Add description", -100000000, 100000000, 50, true));
		parameterTypes.add(new ParameterTypeInt(KSIZE_LABEL, "TODO: Add description", -100000000, 100000000, 7, true));
		parameterTypes.add(new ParameterTypeDouble(MATCH_LABEL, "TODO: Add description", -100000000, 100000000, 5.0, true));
		parameterTypes.add(new ParameterTypeDouble(MISMATCH_LABEL, "TODO: Add description", -100000000, 100000000, -4.0, true));
		parameterTypes.add(new ParameterTypeInt(MINSIM_LABEL, "TODO: Add description", -100000000, 100000000, 90, true));
		parameterTypes.add(new ParameterTypeInt(MINCOV_LABEL, "TODO: Add description", -100000000, 100000000, 70, true));
		parameterTypes.add(new ParameterTypeInt(MINSNP_LABEL, "TODO: Add description", -100000000, 100000000, 10, true));
		parameterTypes.add(new ParameterTypeInt(MINBS_LABEL, "TODO: Add description", -100000000, 100000000, 90, true));
		parameterTypes.add(new ParameterTypeCategory(SEARCH_LABEL, "TODO: Add description", SEARCH_CHOICES, SEARCH_DEFAULT_CHOICE));
		parameterTypes.add(new ParameterTypeBoolean(REALIGN_LABEL, "TODO: Add description", true, true));
		parameterTypes.add(new ParameterTypeBoolean(TRIM_LABEL, "TODO: Add description", false, true));
		parameterTypes.add(new ParameterTypeBoolean(SPLIT_LABEL, "TODO: Add description", false, true));
		parameterTypes.add(new ParameterTypeInt(NUMWANTED_LABEL, "TODO: Add description", -100000000, 100000000, 15, true));
		parameterTypes.add(new ParameterTypeInt(ITERS_LABEL, "TODO: Add description", -100000000, 100000000, 1000, true));
		parameterTypes.add(new ParameterTypeDouble(DIVERGENCE_LABEL, "TODO: Add description", -100000000, 100000000, 1.007, true));
		parameterTypes.add(new ParameterTypeBoolean(DEREPLICATE_LABEL, "TODO: Add description", false, true));
		parameterTypes.add(new ParameterTypeInt(PARENTS_LABEL, "TODO: Add description", -100000000, 100000000, 3, true));
		parameterTypes.add(new ParameterTypeInt(INCREMENT_LABEL, "TODO: Add description", -100000000, 100000000, 5, true));
		parameterTypes.add(new ParameterTypeString(BLASTLOCATION_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeInt(SEED_LABEL, "TODO: Add description", -100000000, 100000000, 0, true));
		parameterTypes.add(new ParameterTypeString(INPUTDIR_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeString(OUTPUTDIR_LABEL, "TODO: Add description", "", true));
		return parameterTypes;
	}

	@Override
	public String getOutputPattern(String type) {
		if (type.equals("accnos")) return "[filename],slayer.accnos";
		if (type.equals("fasta")) return "[filename],slayer.fasta";
		if (type.equals("count")) return "[filename],slayer.pick.count_table";
		if (type.equals("chimera")) return "[filename],slayer.chimeras";
		return super.getOutputPattern(type);
	}
}
