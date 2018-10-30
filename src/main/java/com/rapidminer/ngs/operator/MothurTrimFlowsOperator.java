package com.rapidminer.ngs.operator;

import java.util.List;
import com.rapidminer.operator.OperatorDescription;
import com.rapidminer.operator.ports.InputPort;
import com.rapidminer.operator.ports.OutputPort;
import com.rapidminer.operator.OperatorException;
import com.rapidminer.parameter.*;

public class MothurTrimFlowsOperator extends MothurGeneratedOperator {

	private InputPort flowInPort = getInputPorts().createPort("flow");
	private InputPort oligosInPort = getInputPorts().createPort("oligos");
	private OutputPort flowOutPort = getOutputPorts().createPort("flow");
	private OutputPort fastaOutPort = getOutputPorts().createPort("fasta");
	private OutputPort groupOutPort = getOutputPorts().createPort("group");
	private OutputPort fileOutPort = getOutputPorts().createPort("file");
	private static final String ALLFILES_LABEL = "allfiles:";
	private static final String BDIFFS_LABEL = "bdiffs:";
	private static final String CHECKORIENT_LABEL = "checkorient:";
	private static final String FASTA_LABEL = "fasta:";
	private static final String INPUTDIR_LABEL = "inputdir:";
	private static final String LDIFFS_LABEL = "ldiffs:";
	private static final String MAXFLOWS_LABEL = "maxflows:";
	private static final String MAXHOMOP_LABEL = "maxhomop:";
	private static final String MINFLOWS_LABEL = "minflows:";
	private static final String NOISE_LABEL = "noise:";
	public static final String[] ORDER_CHOICES = { "A", "B", "I" };
	public static final int ORDER_DEFAULT_CHOICE = 0;
	private static final String ORDER_LABEL = "order:";
	private static final String OUTPUTDIR_LABEL = "outputdir:";
	private static final String PDIFFS_LABEL = "pdiffs:";
	private static final String PROCESSORS_LABEL = "processors:";
	private static final String SDIFFS_LABEL = "sdiffs:";
	private static final String SEED_LABEL = "seed:";
	private static final String SIGNAL_LABEL = "signal:";
	private static final String TDIFFS_LABEL = "tdiffs:";

	public MothurTrimFlowsOperator (OperatorDescription description) {
		super(description);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void doWork() throws OperatorException {
		super.doWork();
		clearArguments();
		FileNameObject flowFile = flowInPort.getData(FileNameObject.class);
		addArgument("flow",flowFile.getName());
		FileNameObject oligosFile = oligosInPort.getData(FileNameObject.class);
		addArgument("oligos",oligosFile.getName());
		boolean allfilesValue = getParameterAsBoolean(ALLFILES_LABEL);
		addArgument("allfiles",String.valueOf(allfilesValue));
		int bdiffsValue = getParameterAsInt(BDIFFS_LABEL);
		addArgument("bdiffs",String.valueOf(bdiffsValue));
		boolean checkorientValue = getParameterAsBoolean(CHECKORIENT_LABEL);
		addArgument("checkorient",String.valueOf(checkorientValue));
		boolean fastaValue = getParameterAsBoolean(FASTA_LABEL);
		addArgument("fasta",String.valueOf(fastaValue));
		String inputdirValue = getParameterAsString(INPUTDIR_LABEL);
		addArgument("inputdir",String.valueOf(inputdirValue));
		int ldiffsValue = getParameterAsInt(LDIFFS_LABEL);
		addArgument("ldiffs",String.valueOf(ldiffsValue));
		int maxflowsValue = getParameterAsInt(MAXFLOWS_LABEL);
		addArgument("maxflows",String.valueOf(maxflowsValue));
		int maxhomopValue = getParameterAsInt(MAXHOMOP_LABEL);
		addArgument("maxhomop",String.valueOf(maxhomopValue));
		int minflowsValue = getParameterAsInt(MINFLOWS_LABEL);
		addArgument("minflows",String.valueOf(minflowsValue));
		int noiseValue = getParameterAsInt(NOISE_LABEL);
		addArgument("noise",String.valueOf(noiseValue));
		int orderIndex = getParameterAsInt(ORDER_LABEL);
		String orderValue = ORDER_CHOICES[orderIndex];
		addArgument("order",String.valueOf(orderValue));
		String outputdirValue = getParameterAsString(OUTPUTDIR_LABEL);
		addArgument("outputdir",String.valueOf(outputdirValue));
		int pdiffsValue = getParameterAsInt(PDIFFS_LABEL);
		addArgument("pdiffs",String.valueOf(pdiffsValue));
		int processorsValue = getParameterAsInt(PROCESSORS_LABEL);
		addArgument("processors",String.valueOf(processorsValue));
		int sdiffsValue = getParameterAsInt(SDIFFS_LABEL);
		addArgument("sdiffs",String.valueOf(sdiffsValue));
		int seedValue = getParameterAsInt(SEED_LABEL);
		addArgument("seed",String.valueOf(seedValue));
		int signalValue = getParameterAsInt(SIGNAL_LABEL);
		addArgument("signal",String.valueOf(signalValue));
		int tdiffsValue = getParameterAsInt(TDIFFS_LABEL);
		addArgument("tdiffs",String.valueOf(tdiffsValue));
		executeMothurCommand();
		String fileName="<fileName>"; // TODO: Somehow figure out the fileName
		flowOutPort.deliver(new FileNameObject(fileName+".flow","flow"));
		fastaOutPort.deliver(new FileNameObject(fileName+".fasta","fasta"));
		groupOutPort.deliver(new FileNameObject(fileName+".group","group"));
		fileOutPort.deliver(new FileNameObject(fileName+".file","file"));
	}

	@Override
	public List<ParameterType> getParameterTypes() {
		List<ParameterType> parameterTypes = super.getParameterTypes();
		parameterTypes.add(new ParameterTypeBoolean(ALLFILES_LABEL, "TODO: Add description", true, true));
		parameterTypes.add(new ParameterTypeInt(BDIFFS_LABEL, "TODO: Add description", -100000000, 100000000, 0, true));
		parameterTypes.add(new ParameterTypeBoolean(CHECKORIENT_LABEL, "TODO: Add description", false, true));
		parameterTypes.add(new ParameterTypeBoolean(FASTA_LABEL, "TODO: Add description", false, true));
		parameterTypes.add(new ParameterTypeString(INPUTDIR_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeInt(LDIFFS_LABEL, "TODO: Add description", -100000000, 100000000, 0, true));
		parameterTypes.add(new ParameterTypeInt(MAXFLOWS_LABEL, "TODO: Add description", -100000000, 100000000, 450, true));
		parameterTypes.add(new ParameterTypeInt(MAXHOMOP_LABEL, "TODO: Add description", -100000000, 100000000, 9, true));
		parameterTypes.add(new ParameterTypeInt(MINFLOWS_LABEL, "TODO: Add description", -100000000, 100000000, 450, true));
		parameterTypes.add(new ParameterTypeDouble(NOISE_LABEL, "TODO: Add description", -100000000, 100000000, 0.70, true));
		parameterTypes.add(new ParameterTypeCategory(ORDER_LABEL, "TODO: Add description", ORDER_CHOICES, ORDER_DEFAULT_CHOICE));
		parameterTypes.add(new ParameterTypeString(OUTPUTDIR_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeInt(PDIFFS_LABEL, "TODO: Add description", -100000000, 100000000, 0, true));
		parameterTypes.add(new ParameterTypeInt(PROCESSORS_LABEL, "TODO: Add description", -100000000, 100000000, 1, true));
		parameterTypes.add(new ParameterTypeInt(SDIFFS_LABEL, "TODO: Add description", -100000000, 100000000, 0, true));
		parameterTypes.add(new ParameterTypeInt(SEED_LABEL, "TODO: Add description", -100000000, 100000000, 0, true));
		parameterTypes.add(new ParameterTypeDouble(SIGNAL_LABEL, "TODO: Add description", -100000000, 100000000, 0.50, true));
		parameterTypes.add(new ParameterTypeInt(TDIFFS_LABEL, "TODO: Add description", -100000000, 100000000, 0, true));
		return parameterTypes;
	}

	@Override
	public String getOutputPattern(String type) {
		// TODO Use a dictionary to reflect type to pattern
		if (type=="flow") return "[filename],[tag],flow";
		if (type=="fasta") return "[filename],flow.fasta";
		if (type=="group") return "[filename],flow.groups";
		if (type=="file") return "[filename],flow.files";
		// TODO if nil then 
		return super.getOutputPattern(type);
	}
}
