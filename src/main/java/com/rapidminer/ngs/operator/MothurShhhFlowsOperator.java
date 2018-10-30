package com.rapidminer.ngs.operator;

import java.util.List;
import com.rapidminer.operator.OperatorDescription;
import com.rapidminer.operator.ports.InputPort;
import com.rapidminer.operator.ports.OutputPort;
import com.rapidminer.operator.OperatorException;
import com.rapidminer.parameter.*;

public class MothurShhhFlowsOperator extends MothurGeneratedOperator {

	private InputPort fileInPort = getInputPorts().createPort("file");
	private InputPort flowInPort = getInputPorts().createPort("flow");
	private InputPort lookupInPort = getInputPorts().createPort("lookup");
	private OutputPort qfileOutPort = getOutputPorts().createPort("qfile");
	private OutputPort fastaOutPort = getOutputPorts().createPort("fasta");
	private OutputPort groupOutPort = getOutputPorts().createPort("group");
	private OutputPort nameOutPort = getOutputPorts().createPort("name");
	private OutputPort countsOutPort = getOutputPorts().createPort("counts");
	private static final String CUTOFF_LABEL = "cutoff:";
	private static final String INPUTDIR_LABEL = "inputdir:";
	private static final String LARGE_LABEL = "large:";
	private static final String MAXITER_LABEL = "maxiter:";
	private static final String MINDELTA_LABEL = "mindelta:";
	public static final String[] ORDER_CHOICES = { "A", "B", "I" };
	public static final int ORDER_DEFAULT_CHOICE = 0;
	private static final String ORDER_LABEL = "order:";
	private static final String OUTPUTDIR_LABEL = "outputdir:";
	private static final String SEED_LABEL = "seed:";
	private static final String SIGMA_LABEL = "sigma:";

	public MothurShhhFlowsOperator (OperatorDescription description) {
		super(description);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void doWork() throws OperatorException {
		super.doWork();
		clearArguments();
		FileNameObject fileFile = fileInPort.getData(FileNameObject.class);
		addArgument("file",fileFile.getName());
		FileNameObject flowFile = flowInPort.getData(FileNameObject.class);
		addArgument("flow",flowFile.getName());
		FileNameObject lookupFile = lookupInPort.getData(FileNameObject.class);
		addArgument("lookup",lookupFile.getName());
		int cutoffValue = getParameterAsInt(CUTOFF_LABEL);
		addArgument("cutoff",String.valueOf(cutoffValue));
		String inputdirValue = getParameterAsString(INPUTDIR_LABEL);
		addArgument("inputdir",String.valueOf(inputdirValue));
		int largeValue = getParameterAsInt(LARGE_LABEL);
		addArgument("large",String.valueOf(largeValue));
		int maxiterValue = getParameterAsInt(MAXITER_LABEL);
		addArgument("maxiter",String.valueOf(maxiterValue));
		int mindeltaValue = getParameterAsInt(MINDELTA_LABEL);
		addArgument("mindelta",String.valueOf(mindeltaValue));
		int orderIndex = getParameterAsInt(ORDER_LABEL);
		String orderValue = ORDER_CHOICES[orderIndex];
		addArgument("order",String.valueOf(orderValue));
		String outputdirValue = getParameterAsString(OUTPUTDIR_LABEL);
		addArgument("outputdir",String.valueOf(outputdirValue));
		int seedValue = getParameterAsInt(SEED_LABEL);
		addArgument("seed",String.valueOf(seedValue));
		int sigmaValue = getParameterAsInt(SIGMA_LABEL);
		addArgument("sigma",String.valueOf(sigmaValue));
		executeMothurCommand();
		String fileName="<fileName>"; // TODO: Somehow figure out the fileName
		qfileOutPort.deliver(new FileNameObject(fileName+".qfile","qfile"));
		fastaOutPort.deliver(new FileNameObject(fileName+".fasta","fasta"));
		groupOutPort.deliver(new FileNameObject(fileName+".group","group"));
		nameOutPort.deliver(new FileNameObject(fileName+".name","name"));
		countsOutPort.deliver(new FileNameObject(fileName+".counts","counts"));
	}

	@Override
	public List<ParameterType> getParameterTypes() {
		List<ParameterType> parameterTypes = super.getParameterTypes();
		parameterTypes.add(new ParameterTypeDouble(CUTOFF_LABEL, "TODO: Add description", -100000000, 100000000, 0.01, true));
		parameterTypes.add(new ParameterTypeString(INPUTDIR_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeInt(LARGE_LABEL, "TODO: Add description", -100000000, 100000000, -1, true));
		parameterTypes.add(new ParameterTypeInt(MAXITER_LABEL, "TODO: Add description", -100000000, 100000000, 1000, true));
		parameterTypes.add(new ParameterTypeDouble(MINDELTA_LABEL, "TODO: Add description", -100000000, 100000000, 0.000001, true));
		parameterTypes.add(new ParameterTypeCategory(ORDER_LABEL, "TODO: Add description", ORDER_CHOICES, ORDER_DEFAULT_CHOICE));
		parameterTypes.add(new ParameterTypeString(OUTPUTDIR_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeInt(SEED_LABEL, "TODO: Add description", -100000000, 100000000, 0, true));
		parameterTypes.add(new ParameterTypeInt(SIGMA_LABEL, "TODO: Add description", -100000000, 100000000, 60, true));
		return parameterTypes;
	}

	@Override
	public String getOutputPattern(String type) {
		// TODO Use a dictionary to reflect type to pattern
		if (type=="qfile") return "[filename],shhh.qual";
		if (type=="fasta") return "[filename],shhh.fasta";
		if (type=="group") return "[filename],shhh.groups";
		if (type=="name") return "[filename],shhh.names";
		if (type=="counts") return "[filename],shhh.counts";
		// TODO if nil then 
		return super.getOutputPattern(type);
	}
}
