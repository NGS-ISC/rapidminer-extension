package com.rapidminer.ngs.operator;

import java.util.List;
import com.rapidminer.operator.OperatorDescription;
import com.rapidminer.operator.ports.InputPort;
import com.rapidminer.operator.ports.OutputPort;
import com.rapidminer.operator.OperatorException;
import com.rapidminer.parameter.*;

public class MothurClearcutOperator extends MothurGeneratedOperator {

	private InputPort phylipInPort = getInputPorts().createPort("phylip");
	private InputPort fastaInPort = getInputPorts().createPort("fasta");
	private OutputPort treeOutPort = getOutputPorts().createPort("tree");
	private OutputPort matrixoutOutPort = getOutputPorts().createPort("matrixout");
	private static final String VERBOSE_LABEL = "verbose:";
	private static final String QUIET_LABEL = "quiet:";
	private static final String VERSION_LABEL = "version:";
	private static final String RSEED_LABEL = "rseed:";
	private static final String NORANDOM_LABEL = "norandom:";
	private static final String SHUFFLE_LABEL = "shuffle:";
	private static final String NEIGHBOR_LABEL = "neighbor:";
	private static final String EXPBLEN_LABEL = "expblen:";
	private static final String EXPDIST_LABEL = "expdist:";
	private static final String DNA_LABEL = "DNA:";
	private static final String PROTEIN_LABEL = "protein:";
	private static final String JUKES_LABEL = "jukes:";
	private static final String KIMURA_LABEL = "kimura:";
	private static final String STDOUT_LABEL = "stdout:";
	private static final String NTREES_LABEL = "ntrees:";
	private static final String MATRIXOUT_LABEL = "matrixout:";
	private static final String SEED_LABEL = "seed:";
	private static final String INPUTDIR_LABEL = "inputdir:";
	private static final String OUTPUTDIR_LABEL = "outputdir:";

	public MothurClearcutOperator (OperatorDescription description) {
		super(description);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void doWork() throws OperatorException {
		super.doWork();
		clearArguments();
		FileNameObject phylipFile = phylipInPort.getData(FileNameObject.class);
		addArgument("phylip",phylipFile.getName());
		FileNameObject fastaFile = fastaInPort.getData(FileNameObject.class);
		addArgument("fasta",fastaFile.getName());
		boolean verboseValue = getParameterAsBoolean(VERBOSE_LABEL);
		addArgument("verbose",String.valueOf(verboseValue));
		boolean quietValue = getParameterAsBoolean(QUIET_LABEL);
		addArgument("quiet",String.valueOf(quietValue));
		boolean versionValue = getParameterAsBoolean(VERSION_LABEL);
		addArgument("version",String.valueOf(versionValue));
		String rseedValue = getParameterAsString(RSEED_LABEL);
		addArgument("rseed",String.valueOf(rseedValue));
		boolean norandomValue = getParameterAsBoolean(NORANDOM_LABEL);
		addArgument("norandom",String.valueOf(norandomValue));
		boolean shuffleValue = getParameterAsBoolean(SHUFFLE_LABEL);
		addArgument("shuffle",String.valueOf(shuffleValue));
		boolean neighborValue = getParameterAsBoolean(NEIGHBOR_LABEL);
		addArgument("neighbor",String.valueOf(neighborValue));
		boolean expblenValue = getParameterAsBoolean(EXPBLEN_LABEL);
		addArgument("expblen",String.valueOf(expblenValue));
		boolean expdistValue = getParameterAsBoolean(EXPDIST_LABEL);
		addArgument("expdist",String.valueOf(expdistValue));
		boolean DNAValue = getParameterAsBoolean(DNA_LABEL);
		addArgument("DNA",String.valueOf(DNAValue));
		boolean proteinValue = getParameterAsBoolean(PROTEIN_LABEL);
		addArgument("protein",String.valueOf(proteinValue));
		boolean jukesValue = getParameterAsBoolean(JUKES_LABEL);
		addArgument("jukes",String.valueOf(jukesValue));
		boolean kimuraValue = getParameterAsBoolean(KIMURA_LABEL);
		addArgument("kimura",String.valueOf(kimuraValue));
		boolean stdoutValue = getParameterAsBoolean(STDOUT_LABEL);
		addArgument("stdout",String.valueOf(stdoutValue));
		int ntreesValue = getParameterAsInt(NTREES_LABEL);
		addArgument("ntrees",String.valueOf(ntreesValue));
		String matrixoutValue = getParameterAsString(MATRIXOUT_LABEL);
		addArgument("matrixout",String.valueOf(matrixoutValue));
		int seedValue = getParameterAsInt(SEED_LABEL);
		addArgument("seed",String.valueOf(seedValue));
		String inputdirValue = getParameterAsString(INPUTDIR_LABEL);
		addArgument("inputdir",String.valueOf(inputdirValue));
		String outputdirValue = getParameterAsString(OUTPUTDIR_LABEL);
		addArgument("outputdir",String.valueOf(outputdirValue));
		executeMothurCommand();
		String fileName="<fileName>"; // TODO: Somehow figure out the fileName
		treeOutPort.deliver(new FileNameObject(fileName+".tree","tree"));
		matrixoutOutPort.deliver(new FileNameObject(fileName+".matrixout","matrixout"));
	}

	@Override
	public List<ParameterType> getParameterTypes() {
		List<ParameterType> parameterTypes = super.getParameterTypes();
		parameterTypes.add(new ParameterTypeBoolean(VERBOSE_LABEL, "TODO: Add description", false, true));
		parameterTypes.add(new ParameterTypeBoolean(QUIET_LABEL, "TODO: Add description", false, true));
		parameterTypes.add(new ParameterTypeBoolean(VERSION_LABEL, "TODO: Add description", false, true));
		parameterTypes.add(new ParameterTypeString(RSEED_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeBoolean(NORANDOM_LABEL, "TODO: Add description", false, true));
		parameterTypes.add(new ParameterTypeBoolean(SHUFFLE_LABEL, "TODO: Add description", false, true));
		parameterTypes.add(new ParameterTypeBoolean(NEIGHBOR_LABEL, "TODO: Add description", true, true));
		parameterTypes.add(new ParameterTypeBoolean(EXPBLEN_LABEL, "TODO: Add description", false, true));
		parameterTypes.add(new ParameterTypeBoolean(EXPDIST_LABEL, "TODO: Add description", false, true));
		parameterTypes.add(new ParameterTypeBoolean(DNA_LABEL, "TODO: Add description", false, true));
		parameterTypes.add(new ParameterTypeBoolean(PROTEIN_LABEL, "TODO: Add description", false, true));
		parameterTypes.add(new ParameterTypeBoolean(JUKES_LABEL, "TODO: Add description", false, true));
		parameterTypes.add(new ParameterTypeBoolean(KIMURA_LABEL, "TODO: Add description", false, true));
		parameterTypes.add(new ParameterTypeBoolean(STDOUT_LABEL, "TODO: Add description", false, true));
		parameterTypes.add(new ParameterTypeInt(NTREES_LABEL, "TODO: Add description", -100000000, 100000000, 1, true));
		parameterTypes.add(new ParameterTypeString(MATRIXOUT_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeInt(SEED_LABEL, "TODO: Add description", -100000000, 100000000, 0, true));
		parameterTypes.add(new ParameterTypeString(INPUTDIR_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeString(OUTPUTDIR_LABEL, "TODO: Add description", "", true));
		return parameterTypes;
	}

	@Override
	public String getOutputPattern(String type) {
		// TODO Use a dictionary to reflect type to pattern
		if (type.equals("tree")) return "[filename],tre";
		if (type.equals("matrixout")) return "[filename],";
		// TODO if nil then 
		return super.getOutputPattern(type);
	}
}
