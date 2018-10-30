package com.rapidminer.ngs.operator;

import java.util.List;
import com.rapidminer.operator.OperatorDescription;
import com.rapidminer.operator.ports.InputPort;
import com.rapidminer.operator.ports.OutputPort;
import com.rapidminer.operator.OperatorException;
import com.rapidminer.parameter.*;

public class MothurGetSharedseqsOperator extends MothurGeneratedOperator {

	private InputPort countInPort = getInputPorts().createPort("count");
	private InputPort fastaInPort = getInputPorts().createPort("fasta");
	private InputPort groupInPort = getInputPorts().createPort("group");
	private InputPort listInPort = getInputPorts().createPort("list");
	private InputPort sharedInPort = getInputPorts().createPort("shared");
	private OutputPort fastaOutPort = getOutputPorts().createPort("fasta");
	private OutputPort sharedseqsOutPort = getOutputPorts().createPort("sharedseqs");
	private OutputPort accnosOutPort = getOutputPorts().createPort("accnos");
	private static final String INPUTDIR_LABEL = "inputdir:";
	private static final String LABEL_LABEL = "label:";
	public static final String[] OUTPUT_CHOICES = { "accnos", "default" };
	public static final int OUTPUT_DEFAULT_CHOICE = 1;
	private static final String OUTPUT_LABEL = "output:";
	private static final String OUTPUTDIR_LABEL = "outputdir:";
	private static final String SEED_LABEL = "seed:";
	private static final String SHAREDGROUPS_LABEL = "sharedgroups:";
	private static final String UNIQUEGROUPS_LABEL = "uniquegroups:";

	public MothurGetSharedseqsOperator (OperatorDescription description) {
		super(description);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void doWork() throws OperatorException {
		super.doWork();
		clearArguments();
		FileNameObject countFile = countInPort.getData(FileNameObject.class);
		addArgument("count",countFile.getName());
		FileNameObject fastaFile = fastaInPort.getData(FileNameObject.class);
		addArgument("fasta",fastaFile.getName());
		FileNameObject groupFile = groupInPort.getData(FileNameObject.class);
		addArgument("group",groupFile.getName());
		FileNameObject listFile = listInPort.getData(FileNameObject.class);
		addArgument("list",listFile.getName());
		FileNameObject sharedFile = sharedInPort.getData(FileNameObject.class);
		addArgument("shared",sharedFile.getName());
		String inputdirValue = getParameterAsString(INPUTDIR_LABEL);
		addArgument("inputdir",String.valueOf(inputdirValue));
		String labelValue = getParameterAsString(LABEL_LABEL);
		addArgument("label",String.valueOf(labelValue));
		int outputIndex = getParameterAsInt(OUTPUT_LABEL);
		String outputValue = OUTPUT_CHOICES[outputIndex];
		addArgument("output",String.valueOf(outputValue));
		String outputdirValue = getParameterAsString(OUTPUTDIR_LABEL);
		addArgument("outputdir",String.valueOf(outputdirValue));
		int seedValue = getParameterAsInt(SEED_LABEL);
		addArgument("seed",String.valueOf(seedValue));
		String sharedgroupsValue = getParameterAsString(SHAREDGROUPS_LABEL);
		addArgument("sharedgroups",String.valueOf(sharedgroupsValue));
		String uniquegroupsValue = getParameterAsString(UNIQUEGROUPS_LABEL);
		addArgument("uniquegroups",String.valueOf(uniquegroupsValue));
		executeMothurCommand();
		String fileName="<fileName>"; // TODO: Somehow figure out the fileName
		fastaOutPort.deliver(new FileNameObject(fileName+".fasta","fasta"));
		sharedseqsOutPort.deliver(new FileNameObject(fileName+".sharedseqs","sharedseqs"));
		accnosOutPort.deliver(new FileNameObject(fileName+".accnos","accnos"));
	}

	@Override
	public List<ParameterType> getParameterTypes() {
		List<ParameterType> parameterTypes = super.getParameterTypes();
		parameterTypes.add(new ParameterTypeString(INPUTDIR_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeString(LABEL_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeCategory(OUTPUT_LABEL, "TODO: Add description", OUTPUT_CHOICES, OUTPUT_DEFAULT_CHOICE));
		parameterTypes.add(new ParameterTypeString(OUTPUTDIR_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeInt(SEED_LABEL, "TODO: Add description", -100000000, 100000000, 0, true));
		parameterTypes.add(new ParameterTypeString(SHAREDGROUPS_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeString(UNIQUEGROUPS_LABEL, "TODO: Add description", "", true));
		return parameterTypes;
	}

	@Override
	public String getOutputPattern(String type) {
		// TODO Use a dictionary to reflect type to pattern
		if (type=="fasta") return "[filename],[distance],[group],shared.fasta";
		if (type=="sharedseqs") return "[filename],[distance],[group],shared.seqs";
		if (type=="accnos") return "[filename],[distance],[group],accnos";
		// TODO if nil then 
		return super.getOutputPattern(type);
	}
}
