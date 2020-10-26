package com.rapidminer.ngs.operator;

import java.util.List;
import com.rapidminer.operator.OperatorDescription;
import com.rapidminer.operator.ports.InputPort;
import com.rapidminer.operator.ports.OutputPort;
import com.rapidminer.operator.OperatorException;
import com.rapidminer.parameter.*;

public class MothurShhhFlowsOperator extends MothurGeneratedOperator {

	private InputPort flowInPort = getInputPorts().createPort("flow");
	private InputPort fileInPort = getInputPorts().createPort("file");
	private InputPort lookupInPort = getInputPorts().createPort("lookup");
	private OutputPort countsOutPort = getOutputPorts().createPort("counts");
	private OutputPort fastaOutPort = getOutputPorts().createPort("fasta");
	private OutputPort groupOutPort = getOutputPorts().createPort("group");
	private OutputPort nameOutPort = getOutputPorts().createPort("name");
	private OutputPort qfileOutPort = getOutputPorts().createPort("qfile");
	private static final String CUTOFF_LABEL = "cutoff:";
	private static final String MAXITER_LABEL = "maxiter:";
	private static final String LARGE_LABEL = "large:";
	private static final String SIGMA_LABEL = "sigma:";
	private static final String MINDELTA_LABEL = "mindelta:";
	private static final String[] ORDER_CHOICES = { "A", "B", "I" };
	private static final int ORDER_DEFAULT_CHOICE = 0;
	private static final String ORDER_LABEL = "order:";
	private static final String SEED_LABEL = "seed:";
	private static final String INPUTDIR_LABEL = "inputdir:";
	private static final String OUTPUTDIR_LABEL = "outputdir:";

	public MothurShhhFlowsOperator (OperatorDescription description) {
		super(description);
		// NOTE: Auto-generated constructor stub
	}

	@Override
	public void doWork() throws OperatorException {
		super.doWork();
		clearArguments();
		FileNameObject flowFile = flowInPort.getData(FileNameObject.class);
		addArgument("flow",flowFile.getName());
		FileNameObject fileFile = fileInPort.getData(FileNameObject.class);
		addArgument("file",fileFile.getName());
		FileNameObject lookupFile = lookupInPort.getData(FileNameObject.class);
		addArgument("lookup",lookupFile.getName());
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
		countsOutPort.deliver(new FileNameObject(fileName+".counts","counts"));
		fastaOutPort.deliver(new FileNameObject(fileName+".fasta","fasta"));
		groupOutPort.deliver(new FileNameObject(fileName+".group","group"));
		nameOutPort.deliver(new FileNameObject(fileName+".name","name"));
		qfileOutPort.deliver(new FileNameObject(fileName+".qfile","qfile"));
	}

	@Override
	public List<ParameterType> getParameterTypes() {
		List<ParameterType> parameterTypes = super.getParameterTypes();
		parameterTypes.add(new ParameterTypeDouble(CUTOFF_LABEL, "TODO: Add description", -100000000, 100000000, 0.01, true));
		parameterTypes.add(new ParameterTypeInt(MAXITER_LABEL, "TODO: Add description", -100000000, 100000000, 1000, true));
		parameterTypes.add(new ParameterTypeInt(LARGE_LABEL, "TODO: Add description", -100000000, 100000000, -1, true));
		parameterTypes.add(new ParameterTypeInt(SIGMA_LABEL, "TODO: Add description", -100000000, 100000000, 60, true));
		parameterTypes.add(new ParameterTypeDouble(MINDELTA_LABEL, "TODO: Add description", -100000000, 100000000, 0.000001, true));
		parameterTypes.add(new ParameterTypeCategory(ORDER_LABEL, "TODO: Add description", ORDER_CHOICES, ORDER_DEFAULT_CHOICE));
		parameterTypes.add(new ParameterTypeInt(SEED_LABEL, "TODO: Add description", -100000000, 100000000, 0, true));
		parameterTypes.add(new ParameterTypeString(INPUTDIR_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeString(OUTPUTDIR_LABEL, "TODO: Add description", "", true));
		return parameterTypes;
	}

	@Override
	public String getOutputPattern(String type) {
		if (type.equals("fasta")) return "[filename],shhh.fasta";
		if (type.equals("group")) return "[filename],shhh.groups";
		if (type.equals("name")) return "[filename],shhh.names";
		if (type.equals("counts")) return "[filename],shhh.counts";
		if (type.equals("qfile")) return "[filename],shhh.qual";
		return super.getOutputPattern(type);
	}
}
