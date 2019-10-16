package com.rapidminer.ngs.operator;

import java.util.List;
import com.rapidminer.operator.OperatorDescription;
import com.rapidminer.operator.ports.InputPort;
import com.rapidminer.operator.ports.OutputPort;
import com.rapidminer.operator.OperatorException;
import com.rapidminer.parameter.*;

public class MothurSplitGroupsOperator extends MothurGeneratedOperator {

	private InputPort flowInPort = getInputPorts().createPort("flow");
	private InputPort fastaInPort = getInputPorts().createPort("fasta");
	private InputPort fastqInPort = getInputPorts().createPort("fastq");
	private InputPort nameInPort = getInputPorts().createPort("name");
	private InputPort countInPort = getInputPorts().createPort("count");
	private InputPort groupInPort = getInputPorts().createPort("group");
	private OutputPort countOutPort = getOutputPorts().createPort("count");
	private OutputPort fastaOutPort = getOutputPorts().createPort("fasta");
	private OutputPort fastqOutPort = getOutputPorts().createPort("fastq");
	private OutputPort flowOutPort = getOutputPorts().createPort("flow");
	private OutputPort groupOutPort = getOutputPorts().createPort("group");
	private OutputPort nameOutPort = getOutputPorts().createPort("name");
	private static final String GROUPS_LABEL = "groups:";
	private static final String[] FORMAT_CHOICES = { "sanger", "illumina", "solexa", "illumina1.8+" };
	private static final int FORMAT_DEFAULT_CHOICE = 0;
	private static final String FORMAT_LABEL = "format:";
	private static final String SEED_LABEL = "seed:";
	private static final String INPUTDIR_LABEL = "inputdir:";
	private static final String OUTPUTDIR_LABEL = "outputdir:";

	public MothurSplitGroupsOperator (OperatorDescription description) {
		super(description);
		// NOTE: Auto-generated constructor stub
	}

	@Override
	public void doWork() throws OperatorException {
		super.doWork();
		clearArguments();
		FileNameObject flowFile = flowInPort.getData(FileNameObject.class);
		addArgument("flow",flowFile.getName());
		FileNameObject fastaFile = fastaInPort.getData(FileNameObject.class);
		addArgument("fasta",fastaFile.getName());
		FileNameObject fastqFile = fastqInPort.getData(FileNameObject.class);
		addArgument("fastq",fastqFile.getName());
		FileNameObject nameFile = nameInPort.getData(FileNameObject.class);
		addArgument("name",nameFile.getName());
		FileNameObject countFile = countInPort.getData(FileNameObject.class);
		addArgument("count",countFile.getName());
		FileNameObject groupFile = groupInPort.getData(FileNameObject.class);
		addArgument("group",groupFile.getName());
		String groupsValue = getParameterAsString(GROUPS_LABEL);
		addArgument("groups",String.valueOf(groupsValue));
		int formatIndex = getParameterAsInt(FORMAT_LABEL);
		String formatValue = FORMAT_CHOICES[formatIndex];
		addArgument("format",String.valueOf(formatValue));
		int seedValue = getParameterAsInt(SEED_LABEL);
		addArgument("seed",String.valueOf(seedValue));
		String inputdirValue = getParameterAsString(INPUTDIR_LABEL);
		addArgument("inputdir",String.valueOf(inputdirValue));
		String outputdirValue = getParameterAsString(OUTPUTDIR_LABEL);
		addArgument("outputdir",String.valueOf(outputdirValue));
		executeMothurCommand();
		String fileName="<fileName>"; // TODO: Somehow figure out the fileName
		countOutPort.deliver(new FileNameObject(fileName+".count","count"));
		fastaOutPort.deliver(new FileNameObject(fileName+".fasta","fasta"));
		fastqOutPort.deliver(new FileNameObject(fileName+".fastq","fastq"));
		flowOutPort.deliver(new FileNameObject(fileName+".flow","flow"));
		groupOutPort.deliver(new FileNameObject(fileName+".group","group"));
		nameOutPort.deliver(new FileNameObject(fileName+".name","name"));
	}

	@Override
	public List<ParameterType> getParameterTypes() {
		List<ParameterType> parameterTypes = super.getParameterTypes();
		parameterTypes.add(new ParameterTypeString(GROUPS_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeCategory(FORMAT_LABEL, "TODO: Add description", FORMAT_CHOICES, FORMAT_DEFAULT_CHOICE));
		parameterTypes.add(new ParameterTypeInt(SEED_LABEL, "TODO: Add description", -100000000, 100000000, 0, true));
		parameterTypes.add(new ParameterTypeString(INPUTDIR_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeString(OUTPUTDIR_LABEL, "TODO: Add description", "", true));
		return parameterTypes;
	}

	@Override
	public String getOutputPattern(String type) {
		if (type.equals("flow")) return "[filename],[group],flow";
		if (type.equals("count")) return "[filename],[group],count_table";
		if (type.equals("group")) return "[filename],[group],groups";
		if (type.equals("name")) return "[filename],[group],names";
		if (type.equals("fastq")) return "[filename],[group],fastq";
		if (type.equals("fasta")) return "[filename],[group],fasta";
		return super.getOutputPattern(type);
	}
}
