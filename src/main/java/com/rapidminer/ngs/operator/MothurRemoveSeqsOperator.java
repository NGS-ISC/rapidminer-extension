package com.rapidminer.ngs.operator;

import java.util.List;
import com.rapidminer.operator.OperatorDescription;
import com.rapidminer.operator.ports.InputPort;
import com.rapidminer.operator.ports.OutputPort;
import com.rapidminer.operator.OperatorException;
import com.rapidminer.parameter.*;

public class MothurRemoveSeqsOperator extends MothurGeneratedOperator {

	private InputPort fastqInPort = getInputPorts().createPort("fastq");
	private InputPort fastaInPort = getInputPorts().createPort("fasta");
	private InputPort nameInPort = getInputPorts().createPort("name");
	private InputPort countInPort = getInputPorts().createPort("count");
	private InputPort groupInPort = getInputPorts().createPort("group");
	private InputPort listInPort = getInputPorts().createPort("list");
	private InputPort taxonomyInPort = getInputPorts().createPort("taxonomy");
	private InputPort alignreportInPort = getInputPorts().createPort("alignreport");
	private InputPort contigsreportInPort = getInputPorts().createPort("contigsreport");
	private InputPort qfileInPort = getInputPorts().createPort("qfile");
	private InputPort accnosInPort = getInputPorts().createPort("accnos");
	private OutputPort alignreportOutPort = getOutputPorts().createPort("alignreport");
	private OutputPort contigsreportOutPort = getOutputPorts().createPort("contigsreport");
	private OutputPort countOutPort = getOutputPorts().createPort("count");
	private OutputPort fastaOutPort = getOutputPorts().createPort("fasta");
	private OutputPort fastqOutPort = getOutputPorts().createPort("fastq");
	private OutputPort groupOutPort = getOutputPorts().createPort("group");
	private OutputPort listOutPort = getOutputPorts().createPort("list");
	private OutputPort nameOutPort = getOutputPorts().createPort("name");
	private OutputPort qfileOutPort = getOutputPorts().createPort("qfile");
	private OutputPort taxonomyOutPort = getOutputPorts().createPort("taxonomy");
	private static final String DUPS_LABEL = "dups:";
	private static final String SEED_LABEL = "seed:";
	private static final String[] FORMAT_CHOICES = { "sanger", "illumina", "solexa", "illumina1.8+" };
	private static final int FORMAT_DEFAULT_CHOICE = 3;
	private static final String FORMAT_LABEL = "format:";
	private static final String INPUTDIR_LABEL = "inputdir:";
	private static final String OUTPUTDIR_LABEL = "outputdir:";

	public MothurRemoveSeqsOperator (OperatorDescription description) {
		super(description);
		// NOTE: Auto-generated constructor stub
	}

	@Override
	public void doWork() throws OperatorException {
		super.doWork();
		clearArguments();
		FileNameObject fastqFile = fastqInPort.getData(FileNameObject.class);
		addArgument("fastq",fastqFile.getName());
		FileNameObject fastaFile = fastaInPort.getData(FileNameObject.class);
		addArgument("fasta",fastaFile.getName());
		FileNameObject nameFile = nameInPort.getData(FileNameObject.class);
		addArgument("name",nameFile.getName());
		FileNameObject countFile = countInPort.getData(FileNameObject.class);
		addArgument("count",countFile.getName());
		FileNameObject groupFile = groupInPort.getData(FileNameObject.class);
		addArgument("group",groupFile.getName());
		FileNameObject listFile = listInPort.getData(FileNameObject.class);
		addArgument("list",listFile.getName());
		FileNameObject taxonomyFile = taxonomyInPort.getData(FileNameObject.class);
		addArgument("taxonomy",taxonomyFile.getName());
		FileNameObject alignreportFile = alignreportInPort.getData(FileNameObject.class);
		addArgument("alignreport",alignreportFile.getName());
		FileNameObject contigsreportFile = contigsreportInPort.getData(FileNameObject.class);
		addArgument("contigsreport",contigsreportFile.getName());
		FileNameObject qfileFile = qfileInPort.getData(FileNameObject.class);
		addArgument("qfile",qfileFile.getName());
		FileNameObject accnosFile = accnosInPort.getData(FileNameObject.class);
		addArgument("accnos",accnosFile.getName());
		boolean dupsValue = getParameterAsBoolean(DUPS_LABEL);
		addArgument("dups",String.valueOf(dupsValue));
		int seedValue = getParameterAsInt(SEED_LABEL);
		addArgument("seed",String.valueOf(seedValue));
		int formatIndex = getParameterAsInt(FORMAT_LABEL);
		String formatValue = FORMAT_CHOICES[formatIndex];
		addArgument("format",String.valueOf(formatValue));
		String inputdirValue = getParameterAsString(INPUTDIR_LABEL);
		addArgument("inputdir",String.valueOf(inputdirValue));
		String outputdirValue = getParameterAsString(OUTPUTDIR_LABEL);
		addArgument("outputdir",String.valueOf(outputdirValue));
		executeMothurCommand();
		String fileName="<fileName>"; // TODO: Somehow figure out the fileName
		alignreportOutPort.deliver(new FileNameObject(fileName+".alignreport","alignreport"));
		contigsreportOutPort.deliver(new FileNameObject(fileName+".contigsreport","contigsreport"));
		countOutPort.deliver(new FileNameObject(fileName+".count","count"));
		fastaOutPort.deliver(new FileNameObject(fileName+".fasta","fasta"));
		fastqOutPort.deliver(new FileNameObject(fileName+".fastq","fastq"));
		groupOutPort.deliver(new FileNameObject(fileName+".group","group"));
		listOutPort.deliver(new FileNameObject(fileName+".list","list"));
		nameOutPort.deliver(new FileNameObject(fileName+".name","name"));
		qfileOutPort.deliver(new FileNameObject(fileName+".qfile","qfile"));
		taxonomyOutPort.deliver(new FileNameObject(fileName+".taxonomy","taxonomy"));
	}

	@Override
	public List<ParameterType> getParameterTypes() {
		List<ParameterType> parameterTypes = super.getParameterTypes();
		parameterTypes.add(new ParameterTypeBoolean(DUPS_LABEL, "TODO: Add description", true, true));
		parameterTypes.add(new ParameterTypeInt(SEED_LABEL, "TODO: Add description", -100000000, 100000000, 0, true));
		parameterTypes.add(new ParameterTypeCategory(FORMAT_LABEL, "TODO: Add description", FORMAT_CHOICES, FORMAT_DEFAULT_CHOICE));
		parameterTypes.add(new ParameterTypeString(INPUTDIR_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeString(OUTPUTDIR_LABEL, "TODO: Add description", "", true));
		return parameterTypes;
	}

	@Override
	public String getOutputPattern(String type) {
		if (type.equals("count")) return "[filename],pick,[extension]";
		if (type.equals("qfile")) return "[filename],pick,[extension]";
		if (type.equals("list")) return "[filename],[distance],pick,[extension]";
		if (type.equals("contigsreport")) return "[filename],pick.contigs.report";
		if (type.equals("taxonomy")) return "[filename],pick,[extension]";
		if (type.equals("group")) return "[filename],pick,[extension]";
		if (type.equals("alignreport")) return "[filename],pick.align.report";
		if (type.equals("fasta")) return "[filename],pick,[extension]";
		if (type.equals("fastq")) return "[filename],pick,[extension]";
		if (type.equals("name")) return "[filename],pick,[extension]";
		return super.getOutputPattern(type);
	}
}
