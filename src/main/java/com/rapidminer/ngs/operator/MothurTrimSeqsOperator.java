package com.rapidminer.ngs.operator;

import java.util.List;
import com.rapidminer.operator.OperatorDescription;
import com.rapidminer.operator.ports.InputPort;
import com.rapidminer.operator.ports.OutputPort;
import com.rapidminer.operator.OperatorException;
import com.rapidminer.parameter.*;

public class MothurTrimSeqsOperator extends MothurGeneratedOperator {

	private InputPort countInPort = getInputPorts().createPort("count");
	private InputPort fastaInPort = getInputPorts().createPort("fasta");
	private InputPort nameInPort = getInputPorts().createPort("name");
	private InputPort oligosInPort = getInputPorts().createPort("oligos");
	private InputPort qfileInPort = getInputPorts().createPort("qfile");
	private OutputPort countOutPort = getOutputPorts().createPort("count");
	private OutputPort qfileOutPort = getOutputPorts().createPort("qfile");
	private OutputPort groupOutPort = getOutputPorts().createPort("group");
	private OutputPort fastaOutPort = getOutputPorts().createPort("fasta");
	private OutputPort nameOutPort = getOutputPorts().createPort("name");
	private static final String ALLFILES_LABEL = "allfiles:";
	private static final String BDIFFS_LABEL = "bdiffs:";
	private static final String CHECKORIENT_LABEL = "checkorient:";
	private static final String FLIP_LABEL = "flip:";
	private static final String INPUTDIR_LABEL = "inputdir:";
	private static final String KEEPFIRST_LABEL = "keepfirst:";
	private static final String KEEPFORWARD_LABEL = "keepforward:";
	private static final String LDIFFS_LABEL = "ldiffs:";
	private static final String LOGTRANSFORM_LABEL = "logtransform:";
	private static final String MAXAMBIG_LABEL = "maxambig:";
	private static final String MAXHOMOP_LABEL = "maxhomop:";
	private static final String MAXLENGTH_LABEL = "maxlength:";
	private static final String MINLENGTH_LABEL = "minlength:";
	private static final String OUTPUTDIR_LABEL = "outputdir:";
	private static final String PDIFFS_LABEL = "pdiffs:";
	private static final String PROCESSORS_LABEL = "processors:";
	private static final String QAVERAGE_LABEL = "qaverage:";
	private static final String QSTEPSIZE_LABEL = "qstepsize:";
	private static final String QTHRESHOLD_LABEL = "qthreshold:";
	private static final String QTRIM_LABEL = "qtrim:";
	private static final String QWINDOWAVERAGE_LABEL = "qwindowaverage:";
	private static final String QWINDOWSIZE_LABEL = "qwindowsize:";
	private static final String REMOVELAST_LABEL = "removelast:";
	private static final String ROLLAVERAGE_LABEL = "rollaverage:";
	private static final String SDIFFS_LABEL = "sdiffs:";
	private static final String SEED_LABEL = "seed:";
	private static final String TDIFFS_LABEL = "tdiffs:";

	public MothurTrimSeqsOperator (OperatorDescription description) {
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
		FileNameObject nameFile = nameInPort.getData(FileNameObject.class);
		addArgument("name",nameFile.getName());
		FileNameObject oligosFile = oligosInPort.getData(FileNameObject.class);
		addArgument("oligos",oligosFile.getName());
		FileNameObject qfileFile = qfileInPort.getData(FileNameObject.class);
		addArgument("qfile",qfileFile.getName());
		boolean allfilesValue = getParameterAsBoolean(ALLFILES_LABEL);
		addArgument("allfiles",String.valueOf(allfilesValue));
		int bdiffsValue = getParameterAsInt(BDIFFS_LABEL);
		addArgument("bdiffs",String.valueOf(bdiffsValue));
		boolean checkorientValue = getParameterAsBoolean(CHECKORIENT_LABEL);
		addArgument("checkorient",String.valueOf(checkorientValue));
		boolean flipValue = getParameterAsBoolean(FLIP_LABEL);
		addArgument("flip",String.valueOf(flipValue));
		String inputdirValue = getParameterAsString(INPUTDIR_LABEL);
		addArgument("inputdir",String.valueOf(inputdirValue));
		int keepfirstValue = getParameterAsInt(KEEPFIRST_LABEL);
		addArgument("keepfirst",String.valueOf(keepfirstValue));
		boolean keepforwardValue = getParameterAsBoolean(KEEPFORWARD_LABEL);
		addArgument("keepforward",String.valueOf(keepforwardValue));
		int ldiffsValue = getParameterAsInt(LDIFFS_LABEL);
		addArgument("ldiffs",String.valueOf(ldiffsValue));
		boolean logtransformValue = getParameterAsBoolean(LOGTRANSFORM_LABEL);
		addArgument("logtransform",String.valueOf(logtransformValue));
		int maxambigValue = getParameterAsInt(MAXAMBIG_LABEL);
		addArgument("maxambig",String.valueOf(maxambigValue));
		int maxhomopValue = getParameterAsInt(MAXHOMOP_LABEL);
		addArgument("maxhomop",String.valueOf(maxhomopValue));
		int maxlengthValue = getParameterAsInt(MAXLENGTH_LABEL);
		addArgument("maxlength",String.valueOf(maxlengthValue));
		int minlengthValue = getParameterAsInt(MINLENGTH_LABEL);
		addArgument("minlength",String.valueOf(minlengthValue));
		String outputdirValue = getParameterAsString(OUTPUTDIR_LABEL);
		addArgument("outputdir",String.valueOf(outputdirValue));
		int pdiffsValue = getParameterAsInt(PDIFFS_LABEL);
		addArgument("pdiffs",String.valueOf(pdiffsValue));
		int processorsValue = getParameterAsInt(PROCESSORS_LABEL);
		addArgument("processors",String.valueOf(processorsValue));
		int qaverageValue = getParameterAsInt(QAVERAGE_LABEL);
		addArgument("qaverage",String.valueOf(qaverageValue));
		int qstepsizeValue = getParameterAsInt(QSTEPSIZE_LABEL);
		addArgument("qstepsize",String.valueOf(qstepsizeValue));
		int qthresholdValue = getParameterAsInt(QTHRESHOLD_LABEL);
		addArgument("qthreshold",String.valueOf(qthresholdValue));
		boolean qtrimValue = getParameterAsBoolean(QTRIM_LABEL);
		addArgument("qtrim",String.valueOf(qtrimValue));
		int qwindowaverageValue = getParameterAsInt(QWINDOWAVERAGE_LABEL);
		addArgument("qwindowaverage",String.valueOf(qwindowaverageValue));
		int qwindowsizeValue = getParameterAsInt(QWINDOWSIZE_LABEL);
		addArgument("qwindowsize",String.valueOf(qwindowsizeValue));
		int removelastValue = getParameterAsInt(REMOVELAST_LABEL);
		addArgument("removelast",String.valueOf(removelastValue));
		int rollaverageValue = getParameterAsInt(ROLLAVERAGE_LABEL);
		addArgument("rollaverage",String.valueOf(rollaverageValue));
		int sdiffsValue = getParameterAsInt(SDIFFS_LABEL);
		addArgument("sdiffs",String.valueOf(sdiffsValue));
		int seedValue = getParameterAsInt(SEED_LABEL);
		addArgument("seed",String.valueOf(seedValue));
		int tdiffsValue = getParameterAsInt(TDIFFS_LABEL);
		addArgument("tdiffs",String.valueOf(tdiffsValue));
		executeMothurCommand();
		String fileName="<fileName>"; // TODO: Somehow figure out the fileName
		countOutPort.deliver(new FileNameObject(fileName+".count","count"));
		qfileOutPort.deliver(new FileNameObject(fileName+".qfile","qfile"));
		groupOutPort.deliver(new FileNameObject(fileName+".group","group"));
		fastaOutPort.deliver(new FileNameObject(fileName+".fasta","fasta"));
		nameOutPort.deliver(new FileNameObject(fileName+".name","name"));
	}

	@Override
	public List<ParameterType> getParameterTypes() {
		List<ParameterType> parameterTypes = super.getParameterTypes();
		parameterTypes.add(new ParameterTypeBoolean(ALLFILES_LABEL, "TODO: Add description", false, true));
		parameterTypes.add(new ParameterTypeInt(BDIFFS_LABEL, "TODO: Add description", -100000000, 100000000, 0, true));
		parameterTypes.add(new ParameterTypeBoolean(CHECKORIENT_LABEL, "TODO: Add description", false, true));
		parameterTypes.add(new ParameterTypeBoolean(FLIP_LABEL, "TODO: Add description", false, true));
		parameterTypes.add(new ParameterTypeString(INPUTDIR_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeInt(KEEPFIRST_LABEL, "TODO: Add description", -100000000, 100000000, 0, true));
		parameterTypes.add(new ParameterTypeBoolean(KEEPFORWARD_LABEL, "TODO: Add description", false, true));
		parameterTypes.add(new ParameterTypeInt(LDIFFS_LABEL, "TODO: Add description", -100000000, 100000000, 0, true));
		parameterTypes.add(new ParameterTypeBoolean(LOGTRANSFORM_LABEL, "TODO: Add description", false, true));
		parameterTypes.add(new ParameterTypeInt(MAXAMBIG_LABEL, "TODO: Add description", -100000000, 100000000, -1, true));
		parameterTypes.add(new ParameterTypeInt(MAXHOMOP_LABEL, "TODO: Add description", -100000000, 100000000, 0, true));
		parameterTypes.add(new ParameterTypeInt(MAXLENGTH_LABEL, "TODO: Add description", -100000000, 100000000, 0, true));
		parameterTypes.add(new ParameterTypeInt(MINLENGTH_LABEL, "TODO: Add description", -100000000, 100000000, 1, true));
		parameterTypes.add(new ParameterTypeString(OUTPUTDIR_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeInt(PDIFFS_LABEL, "TODO: Add description", -100000000, 100000000, 0, true));
		parameterTypes.add(new ParameterTypeInt(PROCESSORS_LABEL, "TODO: Add description", -100000000, 100000000, 1, true));
		parameterTypes.add(new ParameterTypeInt(QAVERAGE_LABEL, "TODO: Add description", -100000000, 100000000, 0, true));
		parameterTypes.add(new ParameterTypeInt(QSTEPSIZE_LABEL, "TODO: Add description", -100000000, 100000000, 1, true));
		parameterTypes.add(new ParameterTypeInt(QTHRESHOLD_LABEL, "TODO: Add description", -100000000, 100000000, 0, true));
		parameterTypes.add(new ParameterTypeBoolean(QTRIM_LABEL, "TODO: Add description", true, true));
		parameterTypes.add(new ParameterTypeInt(QWINDOWAVERAGE_LABEL, "TODO: Add description", -100000000, 100000000, 0, true));
		parameterTypes.add(new ParameterTypeInt(QWINDOWSIZE_LABEL, "TODO: Add description", -100000000, 100000000, 50, true));
		parameterTypes.add(new ParameterTypeInt(REMOVELAST_LABEL, "TODO: Add description", -100000000, 100000000, 0, true));
		parameterTypes.add(new ParameterTypeInt(ROLLAVERAGE_LABEL, "TODO: Add description", -100000000, 100000000, 0, true));
		parameterTypes.add(new ParameterTypeInt(SDIFFS_LABEL, "TODO: Add description", -100000000, 100000000, 0, true));
		parameterTypes.add(new ParameterTypeInt(SEED_LABEL, "TODO: Add description", -100000000, 100000000, 0, true));
		parameterTypes.add(new ParameterTypeInt(TDIFFS_LABEL, "TODO: Add description", -100000000, 100000000, 0, true));
		return parameterTypes;
	}

	@Override
	public String getOutputPattern(String type) {
		// TODO Use a dictionary to reflect type to pattern
		if (type=="count") return "[filename],[tag],count_table-[filename],count_table";
		if (type=="qfile") return "[filename],[tag],qual";
		if (type=="group") return "[filename],groups";
		if (type=="fasta") return "[filename],[tag],fasta";
		if (type=="name") return "[filename],[tag],names";
		// TODO if nil then 
		return super.getOutputPattern(type);
	}
}
