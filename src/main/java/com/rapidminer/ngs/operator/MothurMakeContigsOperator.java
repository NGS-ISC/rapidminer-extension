package com.rapidminer.ngs.operator;

import java.util.List;
import com.rapidminer.operator.OperatorDescription;
import com.rapidminer.operator.ports.InputPort;
import com.rapidminer.operator.ports.OutputPort;
import com.rapidminer.operator.OperatorException;
import com.rapidminer.parameter.*;

public class MothurMakeContigsOperator extends MothurGeneratedOperator {

	private InputPort ffastqInPort = getInputPorts().createPort("ffastq");
	private InputPort rfastqInPort = getInputPorts().createPort("rfastq");
	private InputPort ffastaInPort = getInputPorts().createPort("ffasta");
	private InputPort rfastaInPort = getInputPorts().createPort("rfasta");
	private InputPort fqfileInPort = getInputPorts().createPort("fqfile");
	private InputPort rqfileInPort = getInputPorts().createPort("rqfile");
	private InputPort fileInPort = getInputPorts().createPort("file");
	private InputPort oligosInPort = getInputPorts().createPort("oligos");
	private InputPort findexInPort = getInputPorts().createPort("findex");
	private InputPort rindexInPort = getInputPorts().createPort("rindex");
	private OutputPort fastaOutPort = getOutputPorts().createPort("fasta");
	private OutputPort groupOutPort = getOutputPorts().createPort("group");
	private OutputPort qfileOutPort = getOutputPorts().createPort("qfile");
	private OutputPort reportOutPort = getOutputPorts().createPort("report");
	private static final String PDIFFS_LABEL = "pdiffs:";
	private static final String BDIFFS_LABEL = "bdiffs:";
	private static final String TDIFFS_LABEL = "tdiffs:";
	private static final String CHECKORIENT_LABEL = "checkorient:";
	private static final String[] ALIGN_CHOICES = { "needleman", "gotoh", "kmer" };
	private static final int ALIGN_DEFAULT_CHOICE = 0;
	private static final String ALIGN_LABEL = "align:";
	private static final String ALLFILES_LABEL = "allfiles:";
	private static final String TRIMOVERLAP_LABEL = "trimoverlap:";
	private static final String MATCH_LABEL = "match:";
	private static final String MISMATCH_LABEL = "mismatch:";
	private static final String GAPOPEN_LABEL = "gapopen:";
	private static final String GAPEXTEND_LABEL = "gapextend:";
	private static final String INSERT_LABEL = "insert:";
	private static final String DELTAQ_LABEL = "deltaq:";
	private static final String PROCESSORS_LABEL = "processors:";
	private static final String[] FORMAT_CHOICES = { "sanger", "illumina", "solexa", "illumina1.8+" };
	private static final int FORMAT_DEFAULT_CHOICE = 3;
	private static final String FORMAT_LABEL = "format:";
	private static final String KSIZE_LABEL = "ksize:";
	private static final String SEED_LABEL = "seed:";
	private static final String INPUTDIR_LABEL = "inputdir:";
	private static final String OUTPUTDIR_LABEL = "outputdir:";

	public MothurMakeContigsOperator (OperatorDescription description) {
		super(description);
		// NOTE: Auto-generated constructor stub
	}

	@Override
	public void doWork() throws OperatorException {
		super.doWork();
		clearArguments();
		FileNameObject ffastqFile = ffastqInPort.getData(FileNameObject.class);
		addArgument("ffastq",ffastqFile.getName());
		FileNameObject rfastqFile = rfastqInPort.getData(FileNameObject.class);
		addArgument("rfastq",rfastqFile.getName());
		FileNameObject ffastaFile = ffastaInPort.getData(FileNameObject.class);
		addArgument("ffasta",ffastaFile.getName());
		FileNameObject rfastaFile = rfastaInPort.getData(FileNameObject.class);
		addArgument("rfasta",rfastaFile.getName());
		FileNameObject fqfileFile = fqfileInPort.getData(FileNameObject.class);
		addArgument("fqfile",fqfileFile.getName());
		FileNameObject rqfileFile = rqfileInPort.getData(FileNameObject.class);
		addArgument("rqfile",rqfileFile.getName());
		FileNameObject fileFile = fileInPort.getData(FileNameObject.class);
		addArgument("file",fileFile.getName());
		FileNameObject oligosFile = oligosInPort.getData(FileNameObject.class);
		addArgument("oligos",oligosFile.getName());
		FileNameObject findexFile = findexInPort.getData(FileNameObject.class);
		addArgument("findex",findexFile.getName());
		FileNameObject rindexFile = rindexInPort.getData(FileNameObject.class);
		addArgument("rindex",rindexFile.getName());
		int pdiffsValue = getParameterAsInt(PDIFFS_LABEL);
		addArgument("pdiffs",String.valueOf(pdiffsValue));
		int bdiffsValue = getParameterAsInt(BDIFFS_LABEL);
		addArgument("bdiffs",String.valueOf(bdiffsValue));
		int tdiffsValue = getParameterAsInt(TDIFFS_LABEL);
		addArgument("tdiffs",String.valueOf(tdiffsValue));
		boolean checkorientValue = getParameterAsBoolean(CHECKORIENT_LABEL);
		addArgument("checkorient",String.valueOf(checkorientValue));
		int alignIndex = getParameterAsInt(ALIGN_LABEL);
		String alignValue = ALIGN_CHOICES[alignIndex];
		addArgument("align",String.valueOf(alignValue));
		boolean allfilesValue = getParameterAsBoolean(ALLFILES_LABEL);
		addArgument("allfiles",String.valueOf(allfilesValue));
		boolean trimoverlapValue = getParameterAsBoolean(TRIMOVERLAP_LABEL);
		addArgument("trimoverlap",String.valueOf(trimoverlapValue));
		int matchValue = getParameterAsInt(MATCH_LABEL);
		addArgument("match",String.valueOf(matchValue));
		int mismatchValue = getParameterAsInt(MISMATCH_LABEL);
		addArgument("mismatch",String.valueOf(mismatchValue));
		int gapopenValue = getParameterAsInt(GAPOPEN_LABEL);
		addArgument("gapopen",String.valueOf(gapopenValue));
		int gapextendValue = getParameterAsInt(GAPEXTEND_LABEL);
		addArgument("gapextend",String.valueOf(gapextendValue));
		int insertValue = getParameterAsInt(INSERT_LABEL);
		addArgument("insert",String.valueOf(insertValue));
		int deltaqValue = getParameterAsInt(DELTAQ_LABEL);
		addArgument("deltaq",String.valueOf(deltaqValue));
		int processorsValue = getParameterAsInt(PROCESSORS_LABEL);
		addArgument("processors",String.valueOf(processorsValue));
		int formatIndex = getParameterAsInt(FORMAT_LABEL);
		String formatValue = FORMAT_CHOICES[formatIndex];
		addArgument("format",String.valueOf(formatValue));
		int ksizeValue = getParameterAsInt(KSIZE_LABEL);
		addArgument("ksize",String.valueOf(ksizeValue));
		int seedValue = getParameterAsInt(SEED_LABEL);
		addArgument("seed",String.valueOf(seedValue));
		String inputdirValue = getParameterAsString(INPUTDIR_LABEL);
		addArgument("inputdir",String.valueOf(inputdirValue));
		String outputdirValue = getParameterAsString(OUTPUTDIR_LABEL);
		addArgument("outputdir",String.valueOf(outputdirValue));
		executeMothurCommand();
		String fileName="<fileName>"; // TODO: Somehow figure out the fileName
		fastaOutPort.deliver(new FileNameObject(fileName+".fasta","fasta"));
		groupOutPort.deliver(new FileNameObject(fileName+".group","group"));
		qfileOutPort.deliver(new FileNameObject(fileName+".qfile","qfile"));
		reportOutPort.deliver(new FileNameObject(fileName+".report","report"));
	}

	@Override
	public List<ParameterType> getParameterTypes() {
		List<ParameterType> parameterTypes = super.getParameterTypes();
		parameterTypes.add(new ParameterTypeInt(PDIFFS_LABEL, "TODO: Add description", -100000000, 100000000, 0, true));
		parameterTypes.add(new ParameterTypeInt(BDIFFS_LABEL, "TODO: Add description", -100000000, 100000000, 0, true));
		parameterTypes.add(new ParameterTypeInt(TDIFFS_LABEL, "TODO: Add description", -100000000, 100000000, 0, true));
		parameterTypes.add(new ParameterTypeBoolean(CHECKORIENT_LABEL, "TODO: Add description", false, true));
		parameterTypes.add(new ParameterTypeCategory(ALIGN_LABEL, "TODO: Add description", ALIGN_CHOICES, ALIGN_DEFAULT_CHOICE));
		parameterTypes.add(new ParameterTypeBoolean(ALLFILES_LABEL, "TODO: Add description", false, true));
		parameterTypes.add(new ParameterTypeBoolean(TRIMOVERLAP_LABEL, "TODO: Add description", false, true));
		parameterTypes.add(new ParameterTypeDouble(MATCH_LABEL, "TODO: Add description", -100000000, 100000000, 1.0, true));
		parameterTypes.add(new ParameterTypeDouble(MISMATCH_LABEL, "TODO: Add description", -100000000, 100000000, -1.0, true));
		parameterTypes.add(new ParameterTypeDouble(GAPOPEN_LABEL, "TODO: Add description", -100000000, 100000000, -2.0, true));
		parameterTypes.add(new ParameterTypeDouble(GAPEXTEND_LABEL, "TODO: Add description", -100000000, 100000000, -1.0, true));
		parameterTypes.add(new ParameterTypeInt(INSERT_LABEL, "TODO: Add description", -100000000, 100000000, 20, true));
		parameterTypes.add(new ParameterTypeInt(DELTAQ_LABEL, "TODO: Add description", -100000000, 100000000, 6, true));
		parameterTypes.add(new ParameterTypeInt(PROCESSORS_LABEL, "TODO: Add description", -100000000, 100000000, 1, true));
		parameterTypes.add(new ParameterTypeCategory(FORMAT_LABEL, "TODO: Add description", FORMAT_CHOICES, FORMAT_DEFAULT_CHOICE));
		parameterTypes.add(new ParameterTypeInt(KSIZE_LABEL, "TODO: Add description", -100000000, 100000000, 8, true));
		parameterTypes.add(new ParameterTypeInt(SEED_LABEL, "TODO: Add description", -100000000, 100000000, 0, true));
		parameterTypes.add(new ParameterTypeString(INPUTDIR_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeString(OUTPUTDIR_LABEL, "TODO: Add description", "", true));
		return parameterTypes;
	}

	@Override
	public String getOutputPattern(String type) {
		if (type.equals("group")) return "[filename],[tag],contigs.groups";
		if (type.equals("fasta")) return "[filename],[tag],contigs.fasta";
		if (type.equals("qfile")) return "[filename],[tag],contigs.qual";
		if (type.equals("report")) return "[filename],[tag],contigs.report";
		return super.getOutputPattern(type);
	}
}
