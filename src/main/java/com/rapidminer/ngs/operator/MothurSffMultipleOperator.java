package com.rapidminer.ngs.operator;

import java.util.List;
import com.rapidminer.operator.OperatorDescription;
import com.rapidminer.operator.ports.InputPort;
import com.rapidminer.operator.ports.OutputPort;
import com.rapidminer.operator.OperatorException;
import com.rapidminer.parameter.*;

public class MothurSffMultipleOperator extends MothurGeneratedOperator {

	private InputPort fileInPort = getInputPorts().createPort("file");
	private InputPort lookupInPort = getInputPorts().createPort("lookup");
	private OutputPort fastaOutPort = getOutputPorts().createPort("fasta");
	private OutputPort groupOutPort = getOutputPorts().createPort("group");
	private OutputPort nameOutPort = getOutputPorts().createPort("name");
	private static final String TRIM_LABEL = "trim:";
	private static final String MAXHOMOP_LABEL = "maxhomop:";
	private static final String MAXFLOWS_LABEL = "maxflows:";
	private static final String MINFLOWS_LABEL = "minflows:";
	private static final String PDIFFS_LABEL = "pdiffs:";
	private static final String BDIFFS_LABEL = "bdiffs:";
	private static final String LDIFFS_LABEL = "ldiffs:";
	private static final String SDIFFS_LABEL = "sdiffs:";
	private static final String TDIFFS_LABEL = "tdiffs:";
	private static final String SIGNAL_LABEL = "signal:";
	private static final String NOISE_LABEL = "noise:";
	private static final String[] ORDER_CHOICES = { "A", "B", "I" };
	private static final int ORDER_DEFAULT_CHOICE = 0;
	private static final String ORDER_LABEL = "order:";
	private static final String CUTOFF_LABEL = "cutoff:";
	private static final String MAXITER_LABEL = "maxiter:";
	private static final String LARGE_LABEL = "large:";
	private static final String SIGMA_LABEL = "sigma:";
	private static final String MINDELTA_LABEL = "mindelta:";
	private static final String ALLFILES_LABEL = "allfiles:";
	private static final String FLIP_LABEL = "flip:";
	private static final String MAXAMBIG_LABEL = "maxambig:";
	private static final String MINLENGTH_LABEL = "minlength:";
	private static final String MAXLENGTH_LABEL = "maxlength:";
	private static final String KEEPFORWARD_LABEL = "keepforward:";
	private static final String KEEPFIRST_LABEL = "keepfirst:";
	private static final String REMOVELAST_LABEL = "removelast:";
	private static final String PROCESSORS_LABEL = "processors:";
	private static final String SEED_LABEL = "seed:";
	private static final String INPUTDIR_LABEL = "inputdir:";
	private static final String OUTPUTDIR_LABEL = "outputdir:";

	public MothurSffMultipleOperator (OperatorDescription description) {
		super(description);
		// NOTE: Auto-generated constructor stub
	}

	@Override
	public void doWork() throws OperatorException {
		super.doWork();
		clearArguments();
		FileNameObject fileFile = fileInPort.getData(FileNameObject.class);
		addArgument("file",fileFile.getName());
		FileNameObject lookupFile = lookupInPort.getData(FileNameObject.class);
		addArgument("lookup",lookupFile.getName());
		boolean trimValue = getParameterAsBoolean(TRIM_LABEL);
		addArgument("trim",String.valueOf(trimValue));
		int maxhomopValue = getParameterAsInt(MAXHOMOP_LABEL);
		addArgument("maxhomop",String.valueOf(maxhomopValue));
		int maxflowsValue = getParameterAsInt(MAXFLOWS_LABEL);
		addArgument("maxflows",String.valueOf(maxflowsValue));
		int minflowsValue = getParameterAsInt(MINFLOWS_LABEL);
		addArgument("minflows",String.valueOf(minflowsValue));
		int pdiffsValue = getParameterAsInt(PDIFFS_LABEL);
		addArgument("pdiffs",String.valueOf(pdiffsValue));
		int bdiffsValue = getParameterAsInt(BDIFFS_LABEL);
		addArgument("bdiffs",String.valueOf(bdiffsValue));
		int ldiffsValue = getParameterAsInt(LDIFFS_LABEL);
		addArgument("ldiffs",String.valueOf(ldiffsValue));
		int sdiffsValue = getParameterAsInt(SDIFFS_LABEL);
		addArgument("sdiffs",String.valueOf(sdiffsValue));
		int tdiffsValue = getParameterAsInt(TDIFFS_LABEL);
		addArgument("tdiffs",String.valueOf(tdiffsValue));
		int signalValue = getParameterAsInt(SIGNAL_LABEL);
		addArgument("signal",String.valueOf(signalValue));
		int noiseValue = getParameterAsInt(NOISE_LABEL);
		addArgument("noise",String.valueOf(noiseValue));
		int orderIndex = getParameterAsInt(ORDER_LABEL);
		String orderValue = ORDER_CHOICES[orderIndex];
		addArgument("order",String.valueOf(orderValue));
		int cutoffValue = getParameterAsInt(CUTOFF_LABEL);
		addArgument("cutoff",String.valueOf(cutoffValue));
		int maxiterValue = getParameterAsInt(MAXITER_LABEL);
		addArgument("maxiter",String.valueOf(maxiterValue));
		int largeValue = getParameterAsInt(LARGE_LABEL);
		addArgument("large",String.valueOf(largeValue));
		int sigmaValue = getParameterAsInt(SIGMA_LABEL);
		addArgument("sigma",String.valueOf(sigmaValue));
		int mindeltaValue = getParameterAsInt(MINDELTA_LABEL);
		addArgument("mindelta",String.valueOf(mindeltaValue));
		boolean allfilesValue = getParameterAsBoolean(ALLFILES_LABEL);
		addArgument("allfiles",String.valueOf(allfilesValue));
		boolean flipValue = getParameterAsBoolean(FLIP_LABEL);
		addArgument("flip",String.valueOf(flipValue));
		int maxambigValue = getParameterAsInt(MAXAMBIG_LABEL);
		addArgument("maxambig",String.valueOf(maxambigValue));
		int minlengthValue = getParameterAsInt(MINLENGTH_LABEL);
		addArgument("minlength",String.valueOf(minlengthValue));
		int maxlengthValue = getParameterAsInt(MAXLENGTH_LABEL);
		addArgument("maxlength",String.valueOf(maxlengthValue));
		boolean keepforwardValue = getParameterAsBoolean(KEEPFORWARD_LABEL);
		addArgument("keepforward",String.valueOf(keepforwardValue));
		int keepfirstValue = getParameterAsInt(KEEPFIRST_LABEL);
		addArgument("keepfirst",String.valueOf(keepfirstValue));
		int removelastValue = getParameterAsInt(REMOVELAST_LABEL);
		addArgument("removelast",String.valueOf(removelastValue));
		int processorsValue = getParameterAsInt(PROCESSORS_LABEL);
		addArgument("processors",String.valueOf(processorsValue));
		int seedValue = getParameterAsInt(SEED_LABEL);
		addArgument("seed",String.valueOf(seedValue));
		String inputdirValue = getParameterAsString(INPUTDIR_LABEL);
		addArgument("inputdir",String.valueOf(inputdirValue));
		String outputdirValue = getParameterAsString(OUTPUTDIR_LABEL);
		addArgument("outputdir",String.valueOf(outputdirValue));
		executeMothurCommand();
		String fileName="<fileName>"; // TODO: Somehow figure out the fileName
		fastaOutPort.deliver(new FileNameObject(fileName+".fasta","fasta"));
		groupOutPort.deliver(new FileNameObject(fileName+".group","group"));
		nameOutPort.deliver(new FileNameObject(fileName+".name","name"));
	}

	@Override
	public List<ParameterType> getParameterTypes() {
		List<ParameterType> parameterTypes = super.getParameterTypes();
		parameterTypes.add(new ParameterTypeBoolean(TRIM_LABEL, "TODO: Add description", true, true));
		parameterTypes.add(new ParameterTypeInt(MAXHOMOP_LABEL, "TODO: Add description", -100000000, 100000000, 9, true));
		parameterTypes.add(new ParameterTypeInt(MAXFLOWS_LABEL, "TODO: Add description", -100000000, 100000000, 450, true));
		parameterTypes.add(new ParameterTypeInt(MINFLOWS_LABEL, "TODO: Add description", -100000000, 100000000, 450, true));
		parameterTypes.add(new ParameterTypeInt(PDIFFS_LABEL, "TODO: Add description", -100000000, 100000000, 0, true));
		parameterTypes.add(new ParameterTypeInt(BDIFFS_LABEL, "TODO: Add description", -100000000, 100000000, 0, true));
		parameterTypes.add(new ParameterTypeInt(LDIFFS_LABEL, "TODO: Add description", -100000000, 100000000, 0, true));
		parameterTypes.add(new ParameterTypeInt(SDIFFS_LABEL, "TODO: Add description", -100000000, 100000000, 0, true));
		parameterTypes.add(new ParameterTypeInt(TDIFFS_LABEL, "TODO: Add description", -100000000, 100000000, 0, true));
		parameterTypes.add(new ParameterTypeDouble(SIGNAL_LABEL, "TODO: Add description", -100000000, 100000000, 0.50, true));
		parameterTypes.add(new ParameterTypeDouble(NOISE_LABEL, "TODO: Add description", -100000000, 100000000, 0.70, true));
		parameterTypes.add(new ParameterTypeCategory(ORDER_LABEL, "TODO: Add description", ORDER_CHOICES, ORDER_DEFAULT_CHOICE));
		parameterTypes.add(new ParameterTypeDouble(CUTOFF_LABEL, "TODO: Add description", -100000000, 100000000, 0.01, true));
		parameterTypes.add(new ParameterTypeInt(MAXITER_LABEL, "TODO: Add description", -100000000, 100000000, 1000, true));
		parameterTypes.add(new ParameterTypeInt(LARGE_LABEL, "TODO: Add description", -100000000, 100000000, -1, true));
		parameterTypes.add(new ParameterTypeInt(SIGMA_LABEL, "TODO: Add description", -100000000, 100000000, 60, true));
		parameterTypes.add(new ParameterTypeDouble(MINDELTA_LABEL, "TODO: Add description", -100000000, 100000000, 0.000001, true));
		parameterTypes.add(new ParameterTypeBoolean(ALLFILES_LABEL, "TODO: Add description", true, true));
		parameterTypes.add(new ParameterTypeBoolean(FLIP_LABEL, "TODO: Add description", false, true));
		parameterTypes.add(new ParameterTypeInt(MAXAMBIG_LABEL, "TODO: Add description", -100000000, 100000000, -1, true));
		parameterTypes.add(new ParameterTypeInt(MINLENGTH_LABEL, "TODO: Add description", -100000000, 100000000, 0, true));
		parameterTypes.add(new ParameterTypeInt(MAXLENGTH_LABEL, "TODO: Add description", -100000000, 100000000, 0, true));
		parameterTypes.add(new ParameterTypeBoolean(KEEPFORWARD_LABEL, "TODO: Add description", false, true));
		parameterTypes.add(new ParameterTypeInt(KEEPFIRST_LABEL, "TODO: Add description", -100000000, 100000000, 0, true));
		parameterTypes.add(new ParameterTypeInt(REMOVELAST_LABEL, "TODO: Add description", -100000000, 100000000, 0, true));
		parameterTypes.add(new ParameterTypeInt(PROCESSORS_LABEL, "TODO: Add description", -100000000, 100000000, 1, true));
		parameterTypes.add(new ParameterTypeInt(SEED_LABEL, "TODO: Add description", -100000000, 100000000, 0, true));
		parameterTypes.add(new ParameterTypeString(INPUTDIR_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeString(OUTPUTDIR_LABEL, "TODO: Add description", "", true));
		return parameterTypes;
	}

	@Override
	public String getOutputPattern(String type) {
		if (type.equals("fasta")) return "[filename],fasta";
		if (type.equals("name")) return "[filename],names";
		if (type.equals("group")) return "[filename],groups";
		return super.getOutputPattern(type);
	}
}
