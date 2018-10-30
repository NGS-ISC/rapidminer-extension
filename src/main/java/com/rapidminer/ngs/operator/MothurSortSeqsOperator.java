package com.rapidminer.ngs.operator;

import java.util.List;
import com.rapidminer.operator.OperatorDescription;
import com.rapidminer.operator.ports.InputPort;
import com.rapidminer.operator.ports.OutputPort;
import com.rapidminer.operator.OperatorException;
import com.rapidminer.parameter.*;

public class MothurSortSeqsOperator extends MothurGeneratedOperator {

	private InputPort accnosInPort = getInputPorts().createPort("accnos");
	private InputPort countInPort = getInputPorts().createPort("count");
	private InputPort fastaInPort = getInputPorts().createPort("fasta");
	private InputPort flowInPort = getInputPorts().createPort("flow");
	private InputPort groupInPort = getInputPorts().createPort("group");
	private InputPort nameInPort = getInputPorts().createPort("name");
	private InputPort qfileInPort = getInputPorts().createPort("qfile");
	private InputPort taxonomyInPort = getInputPorts().createPort("taxonomy");
	private OutputPort countOutPort = getOutputPorts().createPort("count");
	private OutputPort taxonomyOutPort = getOutputPorts().createPort("taxonomy");
	private OutputPort nameOutPort = getOutputPorts().createPort("name");
	private OutputPort groupOutPort = getOutputPorts().createPort("group");
	private OutputPort qfileOutPort = getOutputPorts().createPort("qfile");
	private OutputPort flowOutPort = getOutputPorts().createPort("flow");
	private OutputPort fastaOutPort = getOutputPorts().createPort("fasta");
	private static final String INPUTDIR_LABEL = "inputdir:";
	private static final String LARGE_LABEL = "large:";
	private static final String OUTPUTDIR_LABEL = "outputdir:";
	private static final String SEED_LABEL = "seed:";

	public MothurSortSeqsOperator (OperatorDescription description) {
		super(description);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void doWork() throws OperatorException {
		super.doWork();
		clearArguments();
		FileNameObject accnosFile = accnosInPort.getData(FileNameObject.class);
		addArgument("accnos",accnosFile.getName());
		FileNameObject countFile = countInPort.getData(FileNameObject.class);
		addArgument("count",countFile.getName());
		FileNameObject fastaFile = fastaInPort.getData(FileNameObject.class);
		addArgument("fasta",fastaFile.getName());
		FileNameObject flowFile = flowInPort.getData(FileNameObject.class);
		addArgument("flow",flowFile.getName());
		FileNameObject groupFile = groupInPort.getData(FileNameObject.class);
		addArgument("group",groupFile.getName());
		FileNameObject nameFile = nameInPort.getData(FileNameObject.class);
		addArgument("name",nameFile.getName());
		FileNameObject qfileFile = qfileInPort.getData(FileNameObject.class);
		addArgument("qfile",qfileFile.getName());
		FileNameObject taxonomyFile = taxonomyInPort.getData(FileNameObject.class);
		addArgument("taxonomy",taxonomyFile.getName());
		String inputdirValue = getParameterAsString(INPUTDIR_LABEL);
		addArgument("inputdir",String.valueOf(inputdirValue));
		boolean largeValue = getParameterAsBoolean(LARGE_LABEL);
		addArgument("large",String.valueOf(largeValue));
		String outputdirValue = getParameterAsString(OUTPUTDIR_LABEL);
		addArgument("outputdir",String.valueOf(outputdirValue));
		int seedValue = getParameterAsInt(SEED_LABEL);
		addArgument("seed",String.valueOf(seedValue));
		executeMothurCommand();
		String fileName="<fileName>"; // TODO: Somehow figure out the fileName
		countOutPort.deliver(new FileNameObject(fileName+".count","count"));
		taxonomyOutPort.deliver(new FileNameObject(fileName+".taxonomy","taxonomy"));
		nameOutPort.deliver(new FileNameObject(fileName+".name","name"));
		groupOutPort.deliver(new FileNameObject(fileName+".group","group"));
		qfileOutPort.deliver(new FileNameObject(fileName+".qfile","qfile"));
		flowOutPort.deliver(new FileNameObject(fileName+".flow","flow"));
		fastaOutPort.deliver(new FileNameObject(fileName+".fasta","fasta"));
	}

	@Override
	public List<ParameterType> getParameterTypes() {
		List<ParameterType> parameterTypes = super.getParameterTypes();
		parameterTypes.add(new ParameterTypeString(INPUTDIR_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeBoolean(LARGE_LABEL, "TODO: Add description", false, true));
		parameterTypes.add(new ParameterTypeString(OUTPUTDIR_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeInt(SEED_LABEL, "TODO: Add description", -100000000, 100000000, 0, true));
		return parameterTypes;
	}

	@Override
	public String getOutputPattern(String type) {
		// TODO Use a dictionary to reflect type to pattern
		if (type=="count") return "[filename],sorted,[extension]";
		if (type=="taxonomy") return "[filename],sorted,[extension]";
		if (type=="name") return "[filename],sorted,[extension]";
		if (type=="group") return "[filename],sorted,[extension]";
		if (type=="qfile") return "[filename],sorted,[extension]";
		if (type=="flow") return "[filename],sorted,[extension]";
		if (type=="fasta") return "[filename],sorted,[extension]";
		// TODO if nil then 
		return super.getOutputPattern(type);
	}
}
