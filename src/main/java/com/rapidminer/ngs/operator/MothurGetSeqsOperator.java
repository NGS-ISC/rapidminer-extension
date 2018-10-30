package com.rapidminer.ngs.operator;

import java.util.List;
import com.rapidminer.operator.OperatorDescription;
import com.rapidminer.operator.ports.InputPort;
import com.rapidminer.operator.ports.OutputPort;
import com.rapidminer.operator.OperatorException;
import com.rapidminer.parameter.*;

public class MothurGetSeqsOperator extends MothurGeneratedOperator {

	private InputPort accnosInPort = getInputPorts().createPort("accnos");
	private InputPort accnos2InPort = getInputPorts().createPort("accnos2");
	private InputPort alignreportInPort = getInputPorts().createPort("alignreport");
	private InputPort countInPort = getInputPorts().createPort("count");
	private InputPort fastaInPort = getInputPorts().createPort("fasta");
	private InputPort fastqInPort = getInputPorts().createPort("fastq");
	private InputPort groupInPort = getInputPorts().createPort("group");
	private InputPort listInPort = getInputPorts().createPort("list");
	private InputPort nameInPort = getInputPorts().createPort("name");
	private InputPort qfileInPort = getInputPorts().createPort("qfile");
	private InputPort taxonomyInPort = getInputPorts().createPort("taxonomy");
	private OutputPort listOutPort = getOutputPorts().createPort("list");
	private OutputPort countOutPort = getOutputPorts().createPort("count");
	private OutputPort nameOutPort = getOutputPorts().createPort("name");
	private OutputPort fastaOutPort = getOutputPorts().createPort("fasta");
	private OutputPort taxonomyOutPort = getOutputPorts().createPort("taxonomy");
	private OutputPort qfileOutPort = getOutputPorts().createPort("qfile");
	private OutputPort accnosreportOutPort = getOutputPorts().createPort("accnosreport");
	private OutputPort groupOutPort = getOutputPorts().createPort("group");
	private OutputPort alignreportOutPort = getOutputPorts().createPort("alignreport");
	private OutputPort fastqOutPort = getOutputPorts().createPort("fastq");
	private static final String DUPS_LABEL = "dups:";
	public static final String[] FORMAT_CHOICES = { "illumina", "illumina1.8+", "sanger", "solexa" };
	public static final int FORMAT_DEFAULT_CHOICE = 1;
	private static final String FORMAT_LABEL = "format:";
	private static final String INPUTDIR_LABEL = "inputdir:";
	private static final String OUTPUTDIR_LABEL = "outputdir:";
	private static final String SEED_LABEL = "seed:";

	public MothurGetSeqsOperator (OperatorDescription description) {
		super(description);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void doWork() throws OperatorException {
		super.doWork();
		clearArguments();
		FileNameObject accnosFile = accnosInPort.getData(FileNameObject.class);
		addArgument("accnos",accnosFile.getName());
		FileNameObject accnos2File = accnos2InPort.getData(FileNameObject.class);
		addArgument("accnos2",accnos2File.getName());
		FileNameObject alignreportFile = alignreportInPort.getData(FileNameObject.class);
		addArgument("alignreport",alignreportFile.getName());
		FileNameObject countFile = countInPort.getData(FileNameObject.class);
		addArgument("count",countFile.getName());
		FileNameObject fastaFile = fastaInPort.getData(FileNameObject.class);
		addArgument("fasta",fastaFile.getName());
		FileNameObject fastqFile = fastqInPort.getData(FileNameObject.class);
		addArgument("fastq",fastqFile.getName());
		FileNameObject groupFile = groupInPort.getData(FileNameObject.class);
		addArgument("group",groupFile.getName());
		FileNameObject listFile = listInPort.getData(FileNameObject.class);
		addArgument("list",listFile.getName());
		FileNameObject nameFile = nameInPort.getData(FileNameObject.class);
		addArgument("name",nameFile.getName());
		FileNameObject qfileFile = qfileInPort.getData(FileNameObject.class);
		addArgument("qfile",qfileFile.getName());
		FileNameObject taxonomyFile = taxonomyInPort.getData(FileNameObject.class);
		addArgument("taxonomy",taxonomyFile.getName());
		boolean dupsValue = getParameterAsBoolean(DUPS_LABEL);
		addArgument("dups",String.valueOf(dupsValue));
		int formatIndex = getParameterAsInt(FORMAT_LABEL);
		String formatValue = FORMAT_CHOICES[formatIndex];
		addArgument("format",String.valueOf(formatValue));
		String inputdirValue = getParameterAsString(INPUTDIR_LABEL);
		addArgument("inputdir",String.valueOf(inputdirValue));
		String outputdirValue = getParameterAsString(OUTPUTDIR_LABEL);
		addArgument("outputdir",String.valueOf(outputdirValue));
		int seedValue = getParameterAsInt(SEED_LABEL);
		addArgument("seed",String.valueOf(seedValue));
		executeMothurCommand();
		String fileName="<fileName>"; // TODO: Somehow figure out the fileName
		listOutPort.deliver(new FileNameObject(fileName+".list","list"));
		countOutPort.deliver(new FileNameObject(fileName+".count","count"));
		nameOutPort.deliver(new FileNameObject(fileName+".name","name"));
		fastaOutPort.deliver(new FileNameObject(fileName+".fasta","fasta"));
		taxonomyOutPort.deliver(new FileNameObject(fileName+".taxonomy","taxonomy"));
		qfileOutPort.deliver(new FileNameObject(fileName+".qfile","qfile"));
		accnosreportOutPort.deliver(new FileNameObject(fileName+".accnosreport","accnosreport"));
		groupOutPort.deliver(new FileNameObject(fileName+".group","group"));
		alignreportOutPort.deliver(new FileNameObject(fileName+".alignreport","alignreport"));
		fastqOutPort.deliver(new FileNameObject(fileName+".fastq","fastq"));
	}

	@Override
	public List<ParameterType> getParameterTypes() {
		List<ParameterType> parameterTypes = super.getParameterTypes();
		parameterTypes.add(new ParameterTypeBoolean(DUPS_LABEL, "TODO: Add description", true, true));
		parameterTypes.add(new ParameterTypeCategory(FORMAT_LABEL, "TODO: Add description", FORMAT_CHOICES, FORMAT_DEFAULT_CHOICE));
		parameterTypes.add(new ParameterTypeString(INPUTDIR_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeString(OUTPUTDIR_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeInt(SEED_LABEL, "TODO: Add description", -100000000, 100000000, 0, true));
		return parameterTypes;
	}

	@Override
	public String getOutputPattern(String type) {
		// TODO Use a dictionary to reflect type to pattern
		if (type=="list") return "[filename],[distance],pick,[extension]";
		if (type=="count") return "[filename],pick,[extension]";
		if (type=="name") return "[filename],pick,[extension]";
		if (type=="fasta") return "[filename],pick,[extension]";
		if (type=="taxonomy") return "[filename],pick,[extension]";
		if (type=="qfile") return "[filename],pick,[extension]";
		if (type=="accnosreport") return "[filename],pick.accnos.report";
		if (type=="group") return "[filename],pick,[extension]";
		if (type=="alignreport") return "[filename],pick.align.report";
		if (type=="fastq") return "[filename],pick,[extension]";
		// TODO if nil then 
		return super.getOutputPattern(type);
	}
}
