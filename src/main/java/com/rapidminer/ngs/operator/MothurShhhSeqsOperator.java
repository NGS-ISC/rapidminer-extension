package com.rapidminer.ngs.operator;

import java.util.List;
import com.rapidminer.operator.OperatorDescription;
import com.rapidminer.operator.ports.InputPort;
import com.rapidminer.operator.ports.OutputPort;
import com.rapidminer.operator.OperatorException;
import com.rapidminer.parameter.*;

public class MothurShhhSeqsOperator extends MothurGeneratedOperator {

	private InputPort fastaInPort = getInputPorts().createPort("fasta");
	private InputPort groupInPort = getInputPorts().createPort("group");
	private InputPort nameInPort = getInputPorts().createPort("name");
	private OutputPort mapOutPort = getOutputPorts().createPort("map");
	private OutputPort fastaOutPort = getOutputPorts().createPort("fasta");
	private OutputPort nameOutPort = getOutputPorts().createPort("name");
	private static final String INPUTDIR_LABEL = "inputdir:";
	private static final String OUTPUTDIR_LABEL = "outputdir:";
	private static final String PROCESSORS_LABEL = "processors:";
	private static final String SEED_LABEL = "seed:";
	private static final String SIGMA_LABEL = "sigma:";

	public MothurShhhSeqsOperator (OperatorDescription description) {
		super(description);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void doWork() throws OperatorException {
		super.doWork();
		clearArguments();
		FileNameObject fastaFile = fastaInPort.getData(FileNameObject.class);
		addArgument("fasta",fastaFile.getName());
		FileNameObject groupFile = groupInPort.getData(FileNameObject.class);
		addArgument("group",groupFile.getName());
		FileNameObject nameFile = nameInPort.getData(FileNameObject.class);
		addArgument("name",nameFile.getName());
		String inputdirValue = getParameterAsString(INPUTDIR_LABEL);
		addArgument("inputdir",String.valueOf(inputdirValue));
		String outputdirValue = getParameterAsString(OUTPUTDIR_LABEL);
		addArgument("outputdir",String.valueOf(outputdirValue));
		int processorsValue = getParameterAsInt(PROCESSORS_LABEL);
		addArgument("processors",String.valueOf(processorsValue));
		int seedValue = getParameterAsInt(SEED_LABEL);
		addArgument("seed",String.valueOf(seedValue));
		int sigmaValue = getParameterAsInt(SIGMA_LABEL);
		addArgument("sigma",String.valueOf(sigmaValue));
		executeMothurCommand();
		String fileName="<fileName>"; // TODO: Somehow figure out the fileName
		mapOutPort.deliver(new FileNameObject(fileName+".map","map"));
		fastaOutPort.deliver(new FileNameObject(fileName+".fasta","fasta"));
		nameOutPort.deliver(new FileNameObject(fileName+".name","name"));
	}

	@Override
	public List<ParameterType> getParameterTypes() {
		List<ParameterType> parameterTypes = super.getParameterTypes();
		parameterTypes.add(new ParameterTypeString(INPUTDIR_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeString(OUTPUTDIR_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeInt(PROCESSORS_LABEL, "TODO: Add description", -100000000, 100000000, 1, true));
		parameterTypes.add(new ParameterTypeInt(SEED_LABEL, "TODO: Add description", -100000000, 100000000, 0, true));
		parameterTypes.add(new ParameterTypeDouble(SIGMA_LABEL, "TODO: Add description", -100000000, 100000000, 0.01, true));
		return parameterTypes;
	}

	@Override
	public String getOutputPattern(String type) {
		// TODO Use a dictionary to reflect type to pattern
		if (type=="map") return "[filename],shhh_seqs.map";
		if (type=="fasta") return "[filename],shhh_seqs.fasta";
		if (type=="name") return "[filename],shhh_seqs.names";
		// TODO if nil then 
		return super.getOutputPattern(type);
	}
}
