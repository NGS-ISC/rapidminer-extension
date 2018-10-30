package com.rapidminer.ngs.operator;

import java.util.List;
import com.rapidminer.operator.OperatorDescription;
import com.rapidminer.operator.ports.InputPort;
import com.rapidminer.operator.ports.OutputPort;
import com.rapidminer.operator.OperatorException;
import com.rapidminer.parameter.*;

public class MothurFastqInfoOperator extends MothurGeneratedOperator {

	private InputPort fastqInPort = getInputPorts().createPort("fastq");
	private InputPort fileInPort = getInputPorts().createPort("file");
	private InputPort groupInPort = getInputPorts().createPort("group");
	private InputPort oligosInPort = getInputPorts().createPort("oligos");
	private OutputPort qfileOutPort = getOutputPorts().createPort("qfile");
	private OutputPort fastaOutPort = getOutputPorts().createPort("fasta");
	private OutputPort fastqOutPort = getOutputPorts().createPort("fastq");
	private static final String BDIFFS_LABEL = "bdiffs:";
	private static final String CHECKORIENT_LABEL = "checkorient:";
	private static final String FASTA_LABEL = "fasta:";
	public static final String[] FORMAT_CHOICES = { "illumina", "illumina1.8+", "sanger", "solexa" };
	public static final int FORMAT_DEFAULT_CHOICE = 2;
	private static final String FORMAT_LABEL = "format:";
	private static final String INPUTDIR_LABEL = "inputdir:";
	private static final String LDIFFS_LABEL = "ldiffs:";
	private static final String OUTPUTDIR_LABEL = "outputdir:";
	private static final String PACBIO_LABEL = "pacbio:";
	private static final String PDIFFS_LABEL = "pdiffs:";
	private static final String QFILE_LABEL = "qfile:";
	private static final String SDIFFS_LABEL = "sdiffs:";
	private static final String SEED_LABEL = "seed:";
	private static final String TDIFFS_LABEL = "tdiffs:";

	public MothurFastqInfoOperator (OperatorDescription description) {
		super(description);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void doWork() throws OperatorException {
		super.doWork();
		clearArguments();
		FileNameObject fastqFile = fastqInPort.getData(FileNameObject.class);
		addArgument("fastq",fastqFile.getName());
		FileNameObject fileFile = fileInPort.getData(FileNameObject.class);
		addArgument("file",fileFile.getName());
		FileNameObject groupFile = groupInPort.getData(FileNameObject.class);
		addArgument("group",groupFile.getName());
		FileNameObject oligosFile = oligosInPort.getData(FileNameObject.class);
		addArgument("oligos",oligosFile.getName());
		int bdiffsValue = getParameterAsInt(BDIFFS_LABEL);
		addArgument("bdiffs",String.valueOf(bdiffsValue));
		boolean checkorientValue = getParameterAsBoolean(CHECKORIENT_LABEL);
		addArgument("checkorient",String.valueOf(checkorientValue));
		boolean fastaValue = getParameterAsBoolean(FASTA_LABEL);
		addArgument("fasta",String.valueOf(fastaValue));
		int formatIndex = getParameterAsInt(FORMAT_LABEL);
		String formatValue = FORMAT_CHOICES[formatIndex];
		addArgument("format",String.valueOf(formatValue));
		String inputdirValue = getParameterAsString(INPUTDIR_LABEL);
		addArgument("inputdir",String.valueOf(inputdirValue));
		int ldiffsValue = getParameterAsInt(LDIFFS_LABEL);
		addArgument("ldiffs",String.valueOf(ldiffsValue));
		String outputdirValue = getParameterAsString(OUTPUTDIR_LABEL);
		addArgument("outputdir",String.valueOf(outputdirValue));
		boolean pacbioValue = getParameterAsBoolean(PACBIO_LABEL);
		addArgument("pacbio",String.valueOf(pacbioValue));
		int pdiffsValue = getParameterAsInt(PDIFFS_LABEL);
		addArgument("pdiffs",String.valueOf(pdiffsValue));
		boolean qfileValue = getParameterAsBoolean(QFILE_LABEL);
		addArgument("qfile",String.valueOf(qfileValue));
		int sdiffsValue = getParameterAsInt(SDIFFS_LABEL);
		addArgument("sdiffs",String.valueOf(sdiffsValue));
		int seedValue = getParameterAsInt(SEED_LABEL);
		addArgument("seed",String.valueOf(seedValue));
		int tdiffsValue = getParameterAsInt(TDIFFS_LABEL);
		addArgument("tdiffs",String.valueOf(tdiffsValue));
		executeMothurCommand();
		String fileName="<fileName>"; // TODO: Somehow figure out the fileName
		qfileOutPort.deliver(new FileNameObject(fileName+".qfile","qfile"));
		fastaOutPort.deliver(new FileNameObject(fileName+".fasta","fasta"));
		fastqOutPort.deliver(new FileNameObject(fileName+".fastq","fastq"));
	}

	@Override
	public List<ParameterType> getParameterTypes() {
		List<ParameterType> parameterTypes = super.getParameterTypes();
		parameterTypes.add(new ParameterTypeInt(BDIFFS_LABEL, "TODO: Add description", -100000000, 100000000, 0, true));
		parameterTypes.add(new ParameterTypeBoolean(CHECKORIENT_LABEL, "TODO: Add description", false, true));
		parameterTypes.add(new ParameterTypeBoolean(FASTA_LABEL, "TODO: Add description", true, true));
		parameterTypes.add(new ParameterTypeCategory(FORMAT_LABEL, "TODO: Add description", FORMAT_CHOICES, FORMAT_DEFAULT_CHOICE));
		parameterTypes.add(new ParameterTypeString(INPUTDIR_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeInt(LDIFFS_LABEL, "TODO: Add description", -100000000, 100000000, 0, true));
		parameterTypes.add(new ParameterTypeString(OUTPUTDIR_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeBoolean(PACBIO_LABEL, "TODO: Add description", false, true));
		parameterTypes.add(new ParameterTypeInt(PDIFFS_LABEL, "TODO: Add description", -100000000, 100000000, 0, true));
		parameterTypes.add(new ParameterTypeBoolean(QFILE_LABEL, "TODO: Add description", true, true));
		parameterTypes.add(new ParameterTypeInt(SDIFFS_LABEL, "TODO: Add description", -100000000, 100000000, 0, true));
		parameterTypes.add(new ParameterTypeInt(SEED_LABEL, "TODO: Add description", -100000000, 100000000, 0, true));
		parameterTypes.add(new ParameterTypeInt(TDIFFS_LABEL, "TODO: Add description", -100000000, 100000000, 0, true));
		return parameterTypes;
	}

	@Override
	public String getOutputPattern(String type) {
		// TODO Use a dictionary to reflect type to pattern
		if (type=="qfile") return "[filename],qual-[filename],[group],[tag],qual-[filename],[group],qual";
		if (type=="fasta") return "[filename],fasta-[filename],[group],[tag],fasta-[filename],[group],fasta";
		if (type=="fastq") return "[filename],[group],fastq-[filename],[group],[tag],fastq";
		// TODO if nil then 
		return super.getOutputPattern(type);
	}
}
