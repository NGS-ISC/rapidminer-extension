package com.rapidminer.ngs.operator;

import java.util.List;
import com.rapidminer.operator.OperatorDescription;
import com.rapidminer.operator.ports.InputPort;
import com.rapidminer.operator.ports.OutputPort;
import com.rapidminer.operator.OperatorException;
import com.rapidminer.parameter.*;

public class MothurEstimatorSingleOperator extends MothurGeneratedOperator {

	private InputPort listInPort = getInputPorts().createPort("list");
	private InputPort rabundInPort = getInputPorts().createPort("rabund");
	private InputPort sabundInPort = getInputPorts().createPort("sabund");
	private InputPort sampleInPort = getInputPorts().createPort("sample");
	private InputPort sharedInPort = getInputPorts().createPort("shared");
	private static final String LABEL_LABEL = "label:";
	private static final String FREQ_LABEL = "freq:";
	private static final String[] CALC_CHOICES = { "erarefact", "ig", "ln", "ls", "si", "igabund", "igrarefact", "lnrarefact", "lnabund", "lnshift", "lsabund", "lsrarefact", "siabund", "sirarefact", "sishift" };
	private static final int CALC_DEFAULT_CHOICE = 1;
	private static final String CALC_LABEL = "calc:";
	private static final String SIGMAA_LABEL = "sigmaa:";
	private static final String SIGMAB_LABEL = "sigmab:";
	private static final String SIGMAN_LABEL = "sigman:";
	private static final String SIGMAS_LABEL = "sigmas:";
	private static final String BURN_LABEL = "burn:";
	private static final String COVERAGE_LABEL = "coverage:";
	private static final String FIT_LABEL = "fit:";
	private static final String BURNSAMPLE_LABEL = "burnsample:";
	private static final String ITERS_LABEL = "iters:";
	private static final String SEED_LABEL = "seed:";
	private static final String INPUTDIR_LABEL = "inputdir:";
	private static final String OUTPUTDIR_LABEL = "outputdir:";

	public MothurEstimatorSingleOperator (OperatorDescription description) {
		super(description);
		// NOTE: Auto-generated constructor stub
	}

	@Override
	public void doWork() throws OperatorException {
		super.doWork();
		clearArguments();
		FileNameObject listFile = listInPort.getData(FileNameObject.class);
		addArgument("list",listFile.getName());
		FileNameObject rabundFile = rabundInPort.getData(FileNameObject.class);
		addArgument("rabund",rabundFile.getName());
		FileNameObject sabundFile = sabundInPort.getData(FileNameObject.class);
		addArgument("sabund",sabundFile.getName());
		FileNameObject sampleFile = sampleInPort.getData(FileNameObject.class);
		addArgument("sample",sampleFile.getName());
		FileNameObject sharedFile = sharedInPort.getData(FileNameObject.class);
		addArgument("shared",sharedFile.getName());
		String labelValue = getParameterAsString(LABEL_LABEL);
		addArgument("label",String.valueOf(labelValue));
		int freqValue = getParameterAsInt(FREQ_LABEL);
		addArgument("freq",String.valueOf(freqValue));
		int calcIndex = getParameterAsInt(CALC_LABEL);
		String calcValue = CALC_CHOICES[calcIndex];
		addArgument("calc",String.valueOf(calcValue));
		int sigmaaValue = getParameterAsInt(SIGMAA_LABEL);
		addArgument("sigmaa",String.valueOf(sigmaaValue));
		int sigmabValue = getParameterAsInt(SIGMAB_LABEL);
		addArgument("sigmab",String.valueOf(sigmabValue));
		int sigmanValue = getParameterAsInt(SIGMAN_LABEL);
		addArgument("sigman",String.valueOf(sigmanValue));
		int sigmasValue = getParameterAsInt(SIGMAS_LABEL);
		addArgument("sigmas",String.valueOf(sigmasValue));
		int burnValue = getParameterAsInt(BURN_LABEL);
		addArgument("burn",String.valueOf(burnValue));
		int coverageValue = getParameterAsInt(COVERAGE_LABEL);
		addArgument("coverage",String.valueOf(coverageValue));
		int fitValue = getParameterAsInt(FIT_LABEL);
		addArgument("fit",String.valueOf(fitValue));
		int burnsampleValue = getParameterAsInt(BURNSAMPLE_LABEL);
		addArgument("burnsample",String.valueOf(burnsampleValue));
		int itersValue = getParameterAsInt(ITERS_LABEL);
		addArgument("iters",String.valueOf(itersValue));
		int seedValue = getParameterAsInt(SEED_LABEL);
		addArgument("seed",String.valueOf(seedValue));
		String inputdirValue = getParameterAsString(INPUTDIR_LABEL);
		addArgument("inputdir",String.valueOf(inputdirValue));
		String outputdirValue = getParameterAsString(OUTPUTDIR_LABEL);
		addArgument("outputdir",String.valueOf(outputdirValue));
		executeMothurCommand();
		String fileName="<fileName>"; // TODO: Somehow figure out the fileName
	}

	@Override
	public List<ParameterType> getParameterTypes() {
		List<ParameterType> parameterTypes = super.getParameterTypes();
		parameterTypes.add(new ParameterTypeString(LABEL_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeInt(FREQ_LABEL, "TODO: Add description", -100000000, 100000000, 100, true));
		parameterTypes.add(new ParameterTypeCategory(CALC_LABEL, "TODO: Add description", CALC_CHOICES, CALC_DEFAULT_CHOICE));
		parameterTypes.add(new ParameterTypeDouble(SIGMAA_LABEL, "TODO: Add description", -100000000, 100000000, 0.1, true));
		parameterTypes.add(new ParameterTypeDouble(SIGMAB_LABEL, "TODO: Add description", -100000000, 100000000, 0.1, true));
		parameterTypes.add(new ParameterTypeDouble(SIGMAN_LABEL, "TODO: Add description", -100000000, 100000000, 0.1, true));
		parameterTypes.add(new ParameterTypeInt(SIGMAS_LABEL, "TODO: Add description", -100000000, 100000000, 100, true));
		parameterTypes.add(new ParameterTypeInt(BURN_LABEL, "TODO: Add description", -100000000, 100000000, 2000000, true));
		parameterTypes.add(new ParameterTypeDouble(COVERAGE_LABEL, "TODO: Add description", -100000000, 100000000, 0.8, true));
		parameterTypes.add(new ParameterTypeInt(FIT_LABEL, "TODO: Add description", -100000000, 100000000, 20, true));
		parameterTypes.add(new ParameterTypeInt(BURNSAMPLE_LABEL, "TODO: Add description", -100000000, 100000000, 1000, true));
		parameterTypes.add(new ParameterTypeInt(ITERS_LABEL, "TODO: Add description", -100000000, 100000000, 1000, true));
		parameterTypes.add(new ParameterTypeInt(SEED_LABEL, "TODO: Add description", -100000000, 100000000, 0, true));
		parameterTypes.add(new ParameterTypeString(INPUTDIR_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeString(OUTPUTDIR_LABEL, "TODO: Add description", "", true));
		return parameterTypes;
	}

	@Override
	public String getOutputPattern(String type) {
		return super.getOutputPattern(type);
	}
}
