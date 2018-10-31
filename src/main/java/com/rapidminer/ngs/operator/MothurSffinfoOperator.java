package com.rapidminer.ngs.operator;

import java.util.List;
import com.rapidminer.operator.OperatorDescription;
import com.rapidminer.operator.ports.InputPort;
import com.rapidminer.operator.ports.OutputPort;
import com.rapidminer.operator.OperatorException;
import com.rapidminer.parameter.*;

public class MothurSffinfoOperator extends MothurGeneratedOperator {

	private InputPort sffInPort = getInputPorts().createPort("sff");
	private InputPort oligosInPort = getInputPorts().createPort("oligos");
	private InputPort groupInPort = getInputPorts().createPort("group");
	private InputPort accnosInPort = getInputPorts().createPort("accnos");
	private OutputPort fastaOutPort = getOutputPorts().createPort("fasta");
	private OutputPort qfileOutPort = getOutputPorts().createPort("qfile");
	private OutputPort flowOutPort = getOutputPorts().createPort("flow");
	private OutputPort sfftxtOutPort = getOutputPorts().createPort("sfftxt");
	private OutputPort sffOutPort = getOutputPorts().createPort("sff");
	private static final String CHECKORIENT_LABEL = "checkorient:";
	private static final String SFFTXT_LABEL = "sfftxt:";
	private static final String FLOW_LABEL = "flow:";
	private static final String TRIM_LABEL = "trim:";
	private static final String FASTA_LABEL = "fasta:";
	private static final String QFILE_LABEL = "qfile:";
	private static final String PDIFFS_LABEL = "pdiffs:";
	private static final String BDIFFS_LABEL = "bdiffs:";
	private static final String LDIFFS_LABEL = "ldiffs:";
	private static final String SDIFFS_LABEL = "sdiffs:";
	private static final String TDIFFS_LABEL = "tdiffs:";
	private static final String SEED_LABEL = "seed:";
	private static final String INPUTDIR_LABEL = "inputdir:";
	private static final String OUTPUTDIR_LABEL = "outputdir:";

	public MothurSffinfoOperator (OperatorDescription description) {
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
		FileNameObject groupFile = groupInPort.getData(FileNameObject.class);
		addArgument("group",groupFile.getName());
		FileNameObject accnosFile = accnosInPort.getData(FileNameObject.class);
		addArgument("accnos",accnosFile.getName());
		boolean checkorientValue = getParameterAsBoolean(CHECKORIENT_LABEL);
		addArgument("checkorient",String.valueOf(checkorientValue));
		String sfftxtValue = getParameterAsString(SFFTXT_LABEL);
		addArgument("sfftxt",String.valueOf(sfftxtValue));
		boolean flowValue = getParameterAsBoolean(FLOW_LABEL);
		addArgument("flow",String.valueOf(flowValue));
		boolean trimValue = getParameterAsBoolean(TRIM_LABEL);
		addArgument("trim",String.valueOf(trimValue));
		boolean fastaValue = getParameterAsBoolean(FASTA_LABEL);
		addArgument("fasta",String.valueOf(fastaValue));
		boolean qfileValue = getParameterAsBoolean(QFILE_LABEL);
		addArgument("qfile",String.valueOf(qfileValue));
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
		int seedValue = getParameterAsInt(SEED_LABEL);
		addArgument("seed",String.valueOf(seedValue));
		String inputdirValue = getParameterAsString(INPUTDIR_LABEL);
		addArgument("inputdir",String.valueOf(inputdirValue));
		String outputdirValue = getParameterAsString(OUTPUTDIR_LABEL);
		addArgument("outputdir",String.valueOf(outputdirValue));
		executeMothurCommand();
		String fileName="<fileName>"; // TODO: Somehow figure out the fileName
		fastaOutPort.deliver(new FileNameObject(fileName+".fasta","fasta"));
		qfileOutPort.deliver(new FileNameObject(fileName+".qfile","qfile"));
		flowOutPort.deliver(new FileNameObject(fileName+".flow","flow"));
		sfftxtOutPort.deliver(new FileNameObject(fileName+".sfftxt","sfftxt"));
		sffOutPort.deliver(new FileNameObject(fileName+".sff","sff"));
	}

	@Override
	public List<ParameterType> getParameterTypes() {
		List<ParameterType> parameterTypes = super.getParameterTypes();
		parameterTypes.add(new ParameterTypeBoolean(CHECKORIENT_LABEL, "TODO: Add description", false, true));
		parameterTypes.add(new ParameterTypeString(SFFTXT_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeBoolean(FLOW_LABEL, "TODO: Add description", true, true));
		parameterTypes.add(new ParameterTypeBoolean(TRIM_LABEL, "TODO: Add description", true, true));
		parameterTypes.add(new ParameterTypeBoolean(FASTA_LABEL, "TODO: Add description", true, true));
		parameterTypes.add(new ParameterTypeBoolean(QFILE_LABEL, "TODO: Add description", true, true));
		parameterTypes.add(new ParameterTypeInt(PDIFFS_LABEL, "TODO: Add description", -100000000, 100000000, 0, true));
		parameterTypes.add(new ParameterTypeInt(BDIFFS_LABEL, "TODO: Add description", -100000000, 100000000, 0, true));
		parameterTypes.add(new ParameterTypeInt(LDIFFS_LABEL, "TODO: Add description", -100000000, 100000000, 0, true));
		parameterTypes.add(new ParameterTypeInt(SDIFFS_LABEL, "TODO: Add description", -100000000, 100000000, 0, true));
		parameterTypes.add(new ParameterTypeInt(TDIFFS_LABEL, "TODO: Add description", -100000000, 100000000, 0, true));
		parameterTypes.add(new ParameterTypeInt(SEED_LABEL, "TODO: Add description", -100000000, 100000000, 0, true));
		parameterTypes.add(new ParameterTypeString(INPUTDIR_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeString(OUTPUTDIR_LABEL, "TODO: Add description", "", true));
		return parameterTypes;
	}

	@Override
	public String getOutputPattern(String type) {
		// TODO Use a dictionary to reflect type to pattern
		if (type.equals("fasta")) return "[filename],fasta-[filename],[tag],fasta";
		if (type.equals("qfile")) return "[filename],qual-[filename],[tag],qual";
		if (type.equals("flow")) return "[filename],flow";
		if (type.equals("sfftxt")) return "[filename],sff.txt";
		if (type.equals("sff")) return "[filename],[group],sff";
		// TODO if nil then 
		return super.getOutputPattern(type);
	}
}
