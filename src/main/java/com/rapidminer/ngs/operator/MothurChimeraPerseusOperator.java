package com.rapidminer.ngs.operator;

import java.util.List;
import com.rapidminer.operator.OperatorDescription;
import com.rapidminer.operator.ports.InputPort;
import com.rapidminer.operator.ports.OutputPort;
import com.rapidminer.operator.OperatorException;
import com.rapidminer.parameter.*;

public class MothurChimeraPerseusOperator extends MothurGeneratedOperator {

	private InputPort fastaInPort = getInputPorts().createPort("fasta");
	private InputPort nameInPort = getInputPorts().createPort("name");
	private InputPort countInPort = getInputPorts().createPort("count");
	private InputPort groupInPort = getInputPorts().createPort("group");
	private OutputPort accnosOutPort = getOutputPorts().createPort("accnos");
	private OutputPort countOutPort = getOutputPorts().createPort("count");
	private OutputPort chimeraOutPort = getOutputPorts().createPort("chimera");
	private static final String PROCESSORS_LABEL = "processors:";
	private static final String DEREPLICATE_LABEL = "dereplicate:";
	private static final String SEED_LABEL = "seed:";
	private static final String INPUTDIR_LABEL = "inputdir:";
	private static final String OUTPUTDIR_LABEL = "outputdir:";
	private static final String CUTOFF_LABEL = "cutoff:";
	private static final String ALPHA_LABEL = "alpha:";
	private static final String BETA_LABEL = "beta:";

	public MothurChimeraPerseusOperator (OperatorDescription description) {
		super(description);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void doWork() throws OperatorException {
		super.doWork();
		clearArguments();
		FileNameObject fastaFile = fastaInPort.getData(FileNameObject.class);
		addArgument("fasta",fastaFile.getName());
		FileNameObject nameFile = nameInPort.getData(FileNameObject.class);
		addArgument("name",nameFile.getName());
		FileNameObject countFile = countInPort.getData(FileNameObject.class);
		addArgument("count",countFile.getName());
		FileNameObject groupFile = groupInPort.getData(FileNameObject.class);
		addArgument("group",groupFile.getName());
		int processorsValue = getParameterAsInt(PROCESSORS_LABEL);
		addArgument("processors",String.valueOf(processorsValue));
		boolean dereplicateValue = getParameterAsBoolean(DEREPLICATE_LABEL);
		addArgument("dereplicate",String.valueOf(dereplicateValue));
		int seedValue = getParameterAsInt(SEED_LABEL);
		addArgument("seed",String.valueOf(seedValue));
		String inputdirValue = getParameterAsString(INPUTDIR_LABEL);
		addArgument("inputdir",String.valueOf(inputdirValue));
		String outputdirValue = getParameterAsString(OUTPUTDIR_LABEL);
		addArgument("outputdir",String.valueOf(outputdirValue));
		int cutoffValue = getParameterAsInt(CUTOFF_LABEL);
		addArgument("cutoff",String.valueOf(cutoffValue));
		int alphaValue = getParameterAsInt(ALPHA_LABEL);
		addArgument("alpha",String.valueOf(alphaValue));
		int betaValue = getParameterAsInt(BETA_LABEL);
		addArgument("beta",String.valueOf(betaValue));
		executeMothurCommand();
		String fileName="<fileName>"; // TODO: Somehow figure out the fileName
		accnosOutPort.deliver(new FileNameObject(fileName+".accnos","accnos"));
		countOutPort.deliver(new FileNameObject(fileName+".count","count"));
		chimeraOutPort.deliver(new FileNameObject(fileName+".chimera","chimera"));
	}

	@Override
	public List<ParameterType> getParameterTypes() {
		List<ParameterType> parameterTypes = super.getParameterTypes();
		parameterTypes.add(new ParameterTypeInt(PROCESSORS_LABEL, "TODO: Add description", -100000000, 100000000, 1, true));
		parameterTypes.add(new ParameterTypeBoolean(DEREPLICATE_LABEL, "TODO: Add description", false, true));
		parameterTypes.add(new ParameterTypeInt(SEED_LABEL, "TODO: Add description", -100000000, 100000000, 0, true));
		parameterTypes.add(new ParameterTypeString(INPUTDIR_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeString(OUTPUTDIR_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeDouble(CUTOFF_LABEL, "TODO: Add description", -100000000, 100000000, 0.5, true));
		parameterTypes.add(new ParameterTypeDouble(ALPHA_LABEL, "TODO: Add description", -100000000, 100000000, -5.54, true));
		parameterTypes.add(new ParameterTypeDouble(BETA_LABEL, "TODO: Add description", -100000000, 100000000, 0.33, true));
		return parameterTypes;
	}

	@Override
	public String getOutputPattern(String type) {
		// TODO Use a dictionary to reflect type to pattern
		if (type.equals("accnos")) return "[filename],perseus.accnos";
		if (type.equals("count")) return "[filename],perseus.pick.count_table";
		if (type.equals("chimera")) return "[filename],perseus.chimeras";
		// TODO if nil then 
		return super.getOutputPattern(type);
	}
}
