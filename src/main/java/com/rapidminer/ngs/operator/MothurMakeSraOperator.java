package com.rapidminer.ngs.operator;

import java.util.List;
import com.rapidminer.operator.OperatorDescription;
import com.rapidminer.operator.ports.InputPort;
import com.rapidminer.operator.ports.OutputPort;
import com.rapidminer.operator.OperatorException;
import com.rapidminer.parameter.*;

public class MothurMakeSraOperator extends MothurGeneratedOperator {

	private InputPort sffInPort = getInputPorts().createPort("sff");
	private InputPort oligosInPort = getInputPorts().createPort("oligos");
	private InputPort fileInPort = getInputPorts().createPort("file");
	private InputPort fastqInPort = getInputPorts().createPort("fastq");
	private InputPort projectInPort = getInputPorts().createPort("project");
	private InputPort mimarkInPort = getInputPorts().createPort("mimark");
	private OutputPort xmlOutPort = getOutputPorts().createPort("xml");
	private static final String CHECKORIENT_LABEL = "checkorient:";
	private static final String INCLUDESCRAP_LABEL = "includescrap:";
	private static final String[] PLATFORM_CHOICES = { "_LS454", "ILLUMINA", "ION_TORRENT", "PACBIO_SMRT" };
	private static final int PLATFORM_DEFAULT_CHOICE = 0;
	private static final String PLATFORM_LABEL = "platform:";
	private static final String[] INSTRUMENT_CHOICES = { "454_GS", "454_GS_20", "454_GS_FLX", "454_GS_FLX_Titanium", "454_GS_Junior", "Illumina_Genome_Analyzer", "Illumina_Genome_Analyzer_II", "Illumina_Genome_Analyzer_IIx", "Illumina_HiSeq_2000", "Illumina_HiSeq_1000", "Illumina_MiSeq", "PacBio_RS", "Ion_Torrent_PGM", "unspecified" };
	private static final int INSTRUMENT_DEFAULT_CHOICE = 0;
	private static final String INSTRUMENT_LABEL = "instrument:";
	private static final String LIBSTRATEGY_LABEL = "libstrategy:";
	private static final String DATATYPE_LABEL = "datatype:";
	private static final String LIBSOURCE_LABEL = "libsource:";
	private static final String LIBSELECTION_LABEL = "libselection:";
	private static final String[] ORIENTATION_CHOICES = { "forward", "reverse" };
	private static final int ORIENTATION_DEFAULT_CHOICE = 0;
	private static final String ORIENTATION_LABEL = "orientation:";
	private static final String PDIFFS_LABEL = "pdiffs:";
	private static final String BDIFFS_LABEL = "bdiffs:";
	private static final String LDIFFS_LABEL = "ldiffs:";
	private static final String SDIFFS_LABEL = "sdiffs:";
	private static final String TDIFFS_LABEL = "tdiffs:";
	private static final String TRIM_LABEL = "trim:";
	private static final String SEED_LABEL = "seed:";
	private static final String INPUTDIR_LABEL = "inputdir:";
	private static final String OUTPUTDIR_LABEL = "outputdir:";

	public MothurMakeSraOperator (OperatorDescription description) {
		super(description);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void doWork() throws OperatorException {
		super.doWork();
		clearArguments();
		FileNameObject sffFile = sffInPort.getData(FileNameObject.class);
		addArgument("sff",sffFile.getName());
		FileNameObject oligosFile = oligosInPort.getData(FileNameObject.class);
		addArgument("oligos",oligosFile.getName());
		FileNameObject fileFile = fileInPort.getData(FileNameObject.class);
		addArgument("file",fileFile.getName());
		FileNameObject fastqFile = fastqInPort.getData(FileNameObject.class);
		addArgument("fastq",fastqFile.getName());
		FileNameObject projectFile = projectInPort.getData(FileNameObject.class);
		addArgument("project",projectFile.getName());
		FileNameObject mimarkFile = mimarkInPort.getData(FileNameObject.class);
		addArgument("mimark",mimarkFile.getName());
		boolean checkorientValue = getParameterAsBoolean(CHECKORIENT_LABEL);
		addArgument("checkorient",String.valueOf(checkorientValue));
		boolean includescrapValue = getParameterAsBoolean(INCLUDESCRAP_LABEL);
		addArgument("includescrap",String.valueOf(includescrapValue));
		int platformIndex = getParameterAsInt(PLATFORM_LABEL);
		String platformValue = PLATFORM_CHOICES[platformIndex];
		addArgument("platform",String.valueOf(platformValue));
		int instrumentIndex = getParameterAsInt(INSTRUMENT_LABEL);
		String instrumentValue = INSTRUMENT_CHOICES[instrumentIndex];
		addArgument("instrument",String.valueOf(instrumentValue));
		String libstrategyValue = getParameterAsString(LIBSTRATEGY_LABEL);
		addArgument("libstrategy",String.valueOf(libstrategyValue));
		String datatypeValue = getParameterAsString(DATATYPE_LABEL);
		addArgument("datatype",String.valueOf(datatypeValue));
		String libsourceValue = getParameterAsString(LIBSOURCE_LABEL);
		addArgument("libsource",String.valueOf(libsourceValue));
		String libselectionValue = getParameterAsString(LIBSELECTION_LABEL);
		addArgument("libselection",String.valueOf(libselectionValue));
		int orientationIndex = getParameterAsInt(ORIENTATION_LABEL);
		String orientationValue = ORIENTATION_CHOICES[orientationIndex];
		addArgument("orientation",String.valueOf(orientationValue));
		int pdiffsValue = getParameterAsInt(PDIFFS_LABEL);
		addArgument("pdiffs",String.valueOf(pdiffsValue));
		int bdiffsValue = getParameterAsInt(BDIFFS_LABEL);
		addArgument("bdiffs",String.valueOf(bdiffsValue));
		int ldiffsValue = getParameterAsInt(LDIFFS_LABEL);
		addArgument("ldiffs",String.valueOf(ldiffsValue));
		int sdiffsValue = getParameterAsInt(SDIFFS_LABEL);
		addArgument("sdiffs",String.valueOf(sdiffsValue));
		int tdiffsValue = getParameterAsInt(TDIFFS_LABEL);
		addArgument("tdiffs",String.valueOf(tdiffsValue));
		boolean trimValue = getParameterAsBoolean(TRIM_LABEL);
		addArgument("trim",String.valueOf(trimValue));
		int seedValue = getParameterAsInt(SEED_LABEL);
		addArgument("seed",String.valueOf(seedValue));
		String inputdirValue = getParameterAsString(INPUTDIR_LABEL);
		addArgument("inputdir",String.valueOf(inputdirValue));
		String outputdirValue = getParameterAsString(OUTPUTDIR_LABEL);
		addArgument("outputdir",String.valueOf(outputdirValue));
		executeMothurCommand();
		String fileName="<fileName>"; // TODO: Somehow figure out the fileName
		xmlOutPort.deliver(new FileNameObject(fileName+".xml","xml"));
	}

	@Override
	public List<ParameterType> getParameterTypes() {
		List<ParameterType> parameterTypes = super.getParameterTypes();
		parameterTypes.add(new ParameterTypeBoolean(CHECKORIENT_LABEL, "TODO: Add description", false, true));
		parameterTypes.add(new ParameterTypeBoolean(INCLUDESCRAP_LABEL, "TODO: Add description", true, true));
		parameterTypes.add(new ParameterTypeCategory(PLATFORM_LABEL, "TODO: Add description", PLATFORM_CHOICES, PLATFORM_DEFAULT_CHOICE));
		parameterTypes.add(new ParameterTypeCategory(INSTRUMENT_LABEL, "TODO: Add description", INSTRUMENT_CHOICES, INSTRUMENT_DEFAULT_CHOICE));
		parameterTypes.add(new ParameterTypeString(LIBSTRATEGY_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeString(DATATYPE_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeString(LIBSOURCE_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeString(LIBSELECTION_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeCategory(ORIENTATION_LABEL, "TODO: Add description", ORIENTATION_CHOICES, ORIENTATION_DEFAULT_CHOICE));
		parameterTypes.add(new ParameterTypeInt(PDIFFS_LABEL, "TODO: Add description", -100000000, 100000000, 0, true));
		parameterTypes.add(new ParameterTypeInt(BDIFFS_LABEL, "TODO: Add description", -100000000, 100000000, 0, true));
		parameterTypes.add(new ParameterTypeInt(LDIFFS_LABEL, "TODO: Add description", -100000000, 100000000, 0, true));
		parameterTypes.add(new ParameterTypeInt(SDIFFS_LABEL, "TODO: Add description", -100000000, 100000000, 0, true));
		parameterTypes.add(new ParameterTypeInt(TDIFFS_LABEL, "TODO: Add description", -100000000, 100000000, 0, true));
		parameterTypes.add(new ParameterTypeBoolean(TRIM_LABEL, "TODO: Add description", true, true));
		parameterTypes.add(new ParameterTypeInt(SEED_LABEL, "TODO: Add description", -100000000, 100000000, 0, true));
		parameterTypes.add(new ParameterTypeString(INPUTDIR_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeString(OUTPUTDIR_LABEL, "TODO: Add description", "", true));
		return parameterTypes;
	}

	@Override
	public String getOutputPattern(String type) {
		// TODO Use a dictionary to reflect type to pattern
		if (type.equals("xml")) return "[filename],xml";
		// TODO if nil then 
		return super.getOutputPattern(type);
	}
}
