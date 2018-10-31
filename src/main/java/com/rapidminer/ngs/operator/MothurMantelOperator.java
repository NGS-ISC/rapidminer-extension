package com.rapidminer.ngs.operator;

import java.util.List;
import com.rapidminer.operator.OperatorDescription;
import com.rapidminer.operator.ports.InputPort;
import com.rapidminer.operator.ports.OutputPort;
import com.rapidminer.operator.OperatorException;
import com.rapidminer.parameter.*;

public class MothurMantelOperator extends MothurGeneratedOperator {

	private InputPort phylip1InPort = getInputPorts().createPort("phylip1");
	private InputPort phylip2InPort = getInputPorts().createPort("phylip2");
	private OutputPort mantelOutPort = getOutputPorts().createPort("mantel");
	private static final String ITERS_LABEL = "iters:";
	private static final String[] METHOD_CHOICES = { "pearson", "spearman", "kendall" };
	private static final int METHOD_DEFAULT_CHOICE = 0;
	private static final String METHOD_LABEL = "method:";
	private static final String SEED_LABEL = "seed:";
	private static final String INPUTDIR_LABEL = "inputdir:";
	private static final String OUTPUTDIR_LABEL = "outputdir:";

	public MothurMantelOperator (OperatorDescription description) {
		super(description);
		// NOTE: Auto-generated constructor stub
	}

	@Override
	public void doWork() throws OperatorException {
		super.doWork();
		clearArguments();
		FileNameObject phylip1File = phylip1InPort.getData(FileNameObject.class);
		addArgument("phylip1",phylip1File.getName());
		FileNameObject phylip2File = phylip2InPort.getData(FileNameObject.class);
		addArgument("phylip2",phylip2File.getName());
		int itersValue = getParameterAsInt(ITERS_LABEL);
		addArgument("iters",String.valueOf(itersValue));
		int methodIndex = getParameterAsInt(METHOD_LABEL);
		String methodValue = METHOD_CHOICES[methodIndex];
		addArgument("method",String.valueOf(methodValue));
		int seedValue = getParameterAsInt(SEED_LABEL);
		addArgument("seed",String.valueOf(seedValue));
		String inputdirValue = getParameterAsString(INPUTDIR_LABEL);
		addArgument("inputdir",String.valueOf(inputdirValue));
		String outputdirValue = getParameterAsString(OUTPUTDIR_LABEL);
		addArgument("outputdir",String.valueOf(outputdirValue));
		executeMothurCommand();
		String fileName="<fileName>"; // TODO: Somehow figure out the fileName
		mantelOutPort.deliver(new FileNameObject(fileName+".mantel","mantel"));
	}

	@Override
	public List<ParameterType> getParameterTypes() {
		List<ParameterType> parameterTypes = super.getParameterTypes();
		parameterTypes.add(new ParameterTypeInt(ITERS_LABEL, "TODO: Add description", -100000000, 100000000, 1000, true));
		parameterTypes.add(new ParameterTypeCategory(METHOD_LABEL, "TODO: Add description", METHOD_CHOICES, METHOD_DEFAULT_CHOICE));
		parameterTypes.add(new ParameterTypeInt(SEED_LABEL, "TODO: Add description", -100000000, 100000000, 0, true));
		parameterTypes.add(new ParameterTypeString(INPUTDIR_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeString(OUTPUTDIR_LABEL, "TODO: Add description", "", true));
		return parameterTypes;
	}

	@Override
	public String getOutputPattern(String type) {
		if (type.equals("mantel")) return "[filename],mantel";
		return super.getOutputPattern(type);
	}
}
