package com.rapidminer.ngs.operator;

import java.util.List;
import com.rapidminer.operator.OperatorDescription;
import com.rapidminer.operator.ports.InputPort;
import com.rapidminer.operator.ports.OutputPort;
import com.rapidminer.operator.OperatorException;
import com.rapidminer.parameter.*;

public class MothurSensSpecOperator extends MothurGeneratedOperator {

	private InputPort listInPort = getInputPorts().createPort("list");
	private InputPort phylipInPort = getInputPorts().createPort("phylip");
	private InputPort columnInPort = getInputPorts().createPort("column");
	private InputPort countInPort = getInputPorts().createPort("count");
	private InputPort nameInPort = getInputPorts().createPort("name");
	private OutputPort sensspecOutPort = getOutputPorts().createPort("sensspec");
	private static final String LABEL_LABEL = "label:";
	private static final String CUTOFF_LABEL = "cutoff:";
	private static final String PRECISION_LABEL = "precision:";
	private static final String SEED_LABEL = "seed:";
	private static final String INPUTDIR_LABEL = "inputdir:";
	private static final String OUTPUTDIR_LABEL = "outputdir:";

	public MothurSensSpecOperator (OperatorDescription description) {
		super(description);
		// NOTE: Auto-generated constructor stub
	}

	@Override
	public void doWork() throws OperatorException {
		super.doWork();
		clearArguments();
		FileNameObject listFile = listInPort.getData(FileNameObject.class);
		addArgument("list",listFile.getName());
		FileNameObject phylipFile = phylipInPort.getData(FileNameObject.class);
		addArgument("phylip",phylipFile.getName());
		FileNameObject columnFile = columnInPort.getData(FileNameObject.class);
		addArgument("column",columnFile.getName());
		FileNameObject countFile = countInPort.getData(FileNameObject.class);
		addArgument("count",countFile.getName());
		FileNameObject nameFile = nameInPort.getData(FileNameObject.class);
		addArgument("name",nameFile.getName());
		String labelValue = getParameterAsString(LABEL_LABEL);
		addArgument("label",String.valueOf(labelValue));
		int cutoffValue = getParameterAsInt(CUTOFF_LABEL);
		addArgument("cutoff",String.valueOf(cutoffValue));
		int precisionValue = getParameterAsInt(PRECISION_LABEL);
		addArgument("precision",String.valueOf(precisionValue));
		int seedValue = getParameterAsInt(SEED_LABEL);
		addArgument("seed",String.valueOf(seedValue));
		String inputdirValue = getParameterAsString(INPUTDIR_LABEL);
		addArgument("inputdir",String.valueOf(inputdirValue));
		String outputdirValue = getParameterAsString(OUTPUTDIR_LABEL);
		addArgument("outputdir",String.valueOf(outputdirValue));
		executeMothurCommand();
		String fileName="<fileName>"; // TODO: Somehow figure out the fileName
		sensspecOutPort.deliver(new FileNameObject(fileName+".sensspec","sensspec"));
	}

	@Override
	public List<ParameterType> getParameterTypes() {
		List<ParameterType> parameterTypes = super.getParameterTypes();
		parameterTypes.add(new ParameterTypeString(LABEL_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeDouble(CUTOFF_LABEL, "TODO: Add description", -100000000, 100000000, -1.00, true));
		parameterTypes.add(new ParameterTypeInt(PRECISION_LABEL, "TODO: Add description", -100000000, 100000000, 100, true));
		parameterTypes.add(new ParameterTypeInt(SEED_LABEL, "TODO: Add description", -100000000, 100000000, 0, true));
		parameterTypes.add(new ParameterTypeString(INPUTDIR_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeString(OUTPUTDIR_LABEL, "TODO: Add description", "", true));
		return parameterTypes;
	}

	@Override
	public String getOutputPattern(String type) {
		if (type.equals("sensspec")) return "[filename],sensspec";
		return super.getOutputPattern(type);
	}
}
