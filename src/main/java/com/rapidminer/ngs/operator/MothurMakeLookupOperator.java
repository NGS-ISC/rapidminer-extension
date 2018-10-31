package com.rapidminer.ngs.operator;

import java.util.List;
import com.rapidminer.operator.OperatorDescription;
import com.rapidminer.operator.ports.InputPort;
import com.rapidminer.operator.ports.OutputPort;
import com.rapidminer.operator.OperatorException;
import com.rapidminer.parameter.*;

public class MothurMakeLookupOperator extends MothurGeneratedOperator {

	private InputPort referenceInPort = getInputPorts().createPort("reference");
	private InputPort flowInPort = getInputPorts().createPort("flow");
	private InputPort errorInPort = getInputPorts().createPort("error");
	private OutputPort lookupOutPort = getOutputPorts().createPort("lookup");
	private static final String BARCODE_LABEL = "barcode:";
	private static final String KEY_LABEL = "key:";
	private static final String THRESHOLD_LABEL = "threshold:";
	private static final String[] ORDER_CHOICES = { "A", "B", "I" };
	private static final int ORDER_DEFAULT_CHOICE = 0;
	private static final String ORDER_LABEL = "order:";
	private static final String SEED_LABEL = "seed:";
	private static final String INPUTDIR_LABEL = "inputdir:";
	private static final String OUTPUTDIR_LABEL = "outputdir:";

	public MothurMakeLookupOperator (OperatorDescription description) {
		super(description);
		// NOTE: Auto-generated constructor stub
	}

	@Override
	public void doWork() throws OperatorException {
		super.doWork();
		clearArguments();
		FileNameObject referenceFile = referenceInPort.getData(FileNameObject.class);
		addArgument("reference",referenceFile.getName());
		FileNameObject flowFile = flowInPort.getData(FileNameObject.class);
		addArgument("flow",flowFile.getName());
		FileNameObject errorFile = errorInPort.getData(FileNameObject.class);
		addArgument("error",errorFile.getName());
		String barcodeValue = getParameterAsString(BARCODE_LABEL);
		addArgument("barcode",String.valueOf(barcodeValue));
		String keyValue = getParameterAsString(KEY_LABEL);
		addArgument("key",String.valueOf(keyValue));
		int thresholdValue = getParameterAsInt(THRESHOLD_LABEL);
		addArgument("threshold",String.valueOf(thresholdValue));
		int orderIndex = getParameterAsInt(ORDER_LABEL);
		String orderValue = ORDER_CHOICES[orderIndex];
		addArgument("order",String.valueOf(orderValue));
		int seedValue = getParameterAsInt(SEED_LABEL);
		addArgument("seed",String.valueOf(seedValue));
		String inputdirValue = getParameterAsString(INPUTDIR_LABEL);
		addArgument("inputdir",String.valueOf(inputdirValue));
		String outputdirValue = getParameterAsString(OUTPUTDIR_LABEL);
		addArgument("outputdir",String.valueOf(outputdirValue));
		executeMothurCommand();
		String fileName="<fileName>"; // TODO: Somehow figure out the fileName
		lookupOutPort.deliver(new FileNameObject(fileName+".lookup","lookup"));
	}

	@Override
	public List<ParameterType> getParameterTypes() {
		List<ParameterType> parameterTypes = super.getParameterTypes();
		parameterTypes.add(new ParameterTypeString(BARCODE_LABEL, "TODO: Add description", "AACCGTGTC", true));
		parameterTypes.add(new ParameterTypeString(KEY_LABEL, "TODO: Add description", "TCAG", true));
		parameterTypes.add(new ParameterTypeInt(THRESHOLD_LABEL, "TODO: Add description", -100000000, 100000000, 10000, true));
		parameterTypes.add(new ParameterTypeCategory(ORDER_LABEL, "TODO: Add description", ORDER_CHOICES, ORDER_DEFAULT_CHOICE));
		parameterTypes.add(new ParameterTypeInt(SEED_LABEL, "TODO: Add description", -100000000, 100000000, 0, true));
		parameterTypes.add(new ParameterTypeString(INPUTDIR_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeString(OUTPUTDIR_LABEL, "TODO: Add description", "", true));
		return parameterTypes;
	}

	@Override
	public String getOutputPattern(String type) {
		if (type.equals("lookup")) return "[filename],lookup";
		return super.getOutputPattern(type);
	}
}
