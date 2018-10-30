package com.rapidminer.ngs.operator;

import java.util.List;
import com.rapidminer.operator.OperatorDescription;
import com.rapidminer.operator.ports.InputPort;
import com.rapidminer.operator.ports.OutputPort;
import com.rapidminer.operator.OperatorException;
import com.rapidminer.parameter.*;

public class MothurNmdsOperator extends MothurGeneratedOperator {

	private InputPort axesInPort = getInputPorts().createPort("axes");
	private InputPort phylipInPort = getInputPorts().createPort("phylip");
	private OutputPort itersOutPort = getOutputPorts().createPort("iters");
	private OutputPort stressOutPort = getOutputPorts().createPort("stress");
	private OutputPort nmdsOutPort = getOutputPorts().createPort("nmds");
	private static final String EPSILON_LABEL = "epsilon:";
	private static final String INPUTDIR_LABEL = "inputdir:";
	private static final String ITERS_LABEL = "iters:";
	private static final String MAXDIM_LABEL = "maxdim:";
	private static final String MAXITERS_LABEL = "maxiters:";
	private static final String MINDIM_LABEL = "mindim:";
	private static final String OUTPUTDIR_LABEL = "outputdir:";
	private static final String SEED_LABEL = "seed:";

	public MothurNmdsOperator (OperatorDescription description) {
		super(description);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void doWork() throws OperatorException {
		super.doWork();
		clearArguments();
		FileNameObject axesFile = axesInPort.getData(FileNameObject.class);
		addArgument("axes",axesFile.getName());
		FileNameObject phylipFile = phylipInPort.getData(FileNameObject.class);
		addArgument("phylip",phylipFile.getName());
		int epsilonValue = getParameterAsInt(EPSILON_LABEL);
		addArgument("epsilon",String.valueOf(epsilonValue));
		String inputdirValue = getParameterAsString(INPUTDIR_LABEL);
		addArgument("inputdir",String.valueOf(inputdirValue));
		int itersValue = getParameterAsInt(ITERS_LABEL);
		addArgument("iters",String.valueOf(itersValue));
		int maxdimValue = getParameterAsInt(MAXDIM_LABEL);
		addArgument("maxdim",String.valueOf(maxdimValue));
		int maxitersValue = getParameterAsInt(MAXITERS_LABEL);
		addArgument("maxiters",String.valueOf(maxitersValue));
		int mindimValue = getParameterAsInt(MINDIM_LABEL);
		addArgument("mindim",String.valueOf(mindimValue));
		String outputdirValue = getParameterAsString(OUTPUTDIR_LABEL);
		addArgument("outputdir",String.valueOf(outputdirValue));
		int seedValue = getParameterAsInt(SEED_LABEL);
		addArgument("seed",String.valueOf(seedValue));
		executeMothurCommand();
		String fileName="<fileName>"; // TODO: Somehow figure out the fileName
		itersOutPort.deliver(new FileNameObject(fileName+".iters","iters"));
		stressOutPort.deliver(new FileNameObject(fileName+".stress","stress"));
		nmdsOutPort.deliver(new FileNameObject(fileName+".nmds","nmds"));
	}

	@Override
	public List<ParameterType> getParameterTypes() {
		List<ParameterType> parameterTypes = super.getParameterTypes();
		parameterTypes.add(new ParameterTypeDouble(EPSILON_LABEL, "TODO: Add description", -100000000, 100000000, 0.000000000001, true));
		parameterTypes.add(new ParameterTypeString(INPUTDIR_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeInt(ITERS_LABEL, "TODO: Add description", -100000000, 100000000, 10, true));
		parameterTypes.add(new ParameterTypeInt(MAXDIM_LABEL, "TODO: Add description", -100000000, 100000000, 2, true));
		parameterTypes.add(new ParameterTypeInt(MAXITERS_LABEL, "TODO: Add description", -100000000, 100000000, 500, true));
		parameterTypes.add(new ParameterTypeInt(MINDIM_LABEL, "TODO: Add description", -100000000, 100000000, 2, true));
		parameterTypes.add(new ParameterTypeString(OUTPUTDIR_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeInt(SEED_LABEL, "TODO: Add description", -100000000, 100000000, 0, true));
		return parameterTypes;
	}

	@Override
	public String getOutputPattern(String type) {
		// TODO Use a dictionary to reflect type to pattern
		if (type=="iters") return "[filename],nmds.iters";
		if (type=="stress") return "[filename],nmds.stress";
		if (type=="nmds") return "[filename],nmds.axes";
		// TODO if nil then 
		return super.getOutputPattern(type);
	}
}
