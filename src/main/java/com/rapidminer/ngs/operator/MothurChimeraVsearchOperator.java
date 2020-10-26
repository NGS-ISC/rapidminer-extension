package com.rapidminer.ngs.operator;

import java.util.List;
import com.rapidminer.operator.OperatorDescription;
import com.rapidminer.operator.ports.InputPort;
import com.rapidminer.operator.ports.OutputPort;
import com.rapidminer.operator.OperatorException;
import com.rapidminer.parameter.*;

public class MothurChimeraVsearchOperator extends MothurGeneratedOperator {

	private InputPort referenceInPort = getInputPorts().createPort("reference");
	private InputPort fastaInPort = getInputPorts().createPort("fasta");
	private InputPort nameInPort = getInputPorts().createPort("name");
	private InputPort countInPort = getInputPorts().createPort("count");
	private InputPort groupInPort = getInputPorts().createPort("group");
	private OutputPort accnosOutPort = getOutputPorts().createPort("accnos");
	private OutputPort alnsOutPort = getOutputPorts().createPort("alns");
	private OutputPort chimeraOutPort = getOutputPorts().createPort("chimera");
	private OutputPort countOutPort = getOutputPorts().createPort("count");
	private static final String PROCESSORS_LABEL = "processors:";
	private static final String SEED_LABEL = "seed:";
	private static final String INPUTDIR_LABEL = "inputdir:";
	private static final String OUTPUTDIR_LABEL = "outputdir:";
	private static final String ABSKEW_LABEL = "abskew:";
	private static final String UCHIMEALNS_LABEL = "uchimealns:";
	private static final String MINH_LABEL = "minh:";
	private static final String MINDIV_LABEL = "mindiv:";
	private static final String XN_LABEL = "xn:";
	private static final String DN_LABEL = "dn:";
	private static final String MINDIFFS_LABEL = "mindiffs:";
	private static final String VSEARCH_LABEL = "vsearch:";
	private static final String DEREPLICATE_LABEL = "dereplicate:";

	public MothurChimeraVsearchOperator (OperatorDescription description) {
		super(description);
		// NOTE: Auto-generated constructor stub
	}

	@Override
	public void doWork() throws OperatorException {
		super.doWork();
		clearArguments();
		FileNameObject referenceFile = referenceInPort.getData(FileNameObject.class);
		addArgument("reference",referenceFile.getName());
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
		int seedValue = getParameterAsInt(SEED_LABEL);
		addArgument("seed",String.valueOf(seedValue));
		String inputdirValue = getParameterAsString(INPUTDIR_LABEL);
		addArgument("inputdir",String.valueOf(inputdirValue));
		String outputdirValue = getParameterAsString(OUTPUTDIR_LABEL);
		addArgument("outputdir",String.valueOf(outputdirValue));
		int abskewValue = getParameterAsInt(ABSKEW_LABEL);
		addArgument("abskew",String.valueOf(abskewValue));
		boolean uchimealnsValue = getParameterAsBoolean(UCHIMEALNS_LABEL);
		addArgument("uchimealns",String.valueOf(uchimealnsValue));
		int minhValue = getParameterAsInt(MINH_LABEL);
		addArgument("minh",String.valueOf(minhValue));
		int mindivValue = getParameterAsInt(MINDIV_LABEL);
		addArgument("mindiv",String.valueOf(mindivValue));
		int xnValue = getParameterAsInt(XN_LABEL);
		addArgument("xn",String.valueOf(xnValue));
		int dnValue = getParameterAsInt(DN_LABEL);
		addArgument("dn",String.valueOf(dnValue));
		int mindiffsValue = getParameterAsInt(MINDIFFS_LABEL);
		addArgument("mindiffs",String.valueOf(mindiffsValue));
		String vsearchValue = getParameterAsString(VSEARCH_LABEL);
		addArgument("vsearch",String.valueOf(vsearchValue));
		boolean dereplicateValue = getParameterAsBoolean(DEREPLICATE_LABEL);
		addArgument("dereplicate",String.valueOf(dereplicateValue));
		executeMothurCommand();
		String fileName="<fileName>"; // TODO: Somehow figure out the fileName
		accnosOutPort.deliver(new FileNameObject(fileName+".accnos","accnos"));
		alnsOutPort.deliver(new FileNameObject(fileName+".alns","alns"));
		chimeraOutPort.deliver(new FileNameObject(fileName+".chimera","chimera"));
		countOutPort.deliver(new FileNameObject(fileName+".count","count"));
	}

	@Override
	public List<ParameterType> getParameterTypes() {
		List<ParameterType> parameterTypes = super.getParameterTypes();
		parameterTypes.add(new ParameterTypeInt(PROCESSORS_LABEL, "TODO: Add description", -100000000, 100000000, 1, true));
		parameterTypes.add(new ParameterTypeInt(SEED_LABEL, "TODO: Add description", -100000000, 100000000, 0, true));
		parameterTypes.add(new ParameterTypeString(INPUTDIR_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeString(OUTPUTDIR_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeDouble(ABSKEW_LABEL, "TODO: Add description", -100000000, 100000000, 1.9, true));
		parameterTypes.add(new ParameterTypeBoolean(UCHIMEALNS_LABEL, "TODO: Add description", false, true));
		parameterTypes.add(new ParameterTypeDouble(MINH_LABEL, "TODO: Add description", -100000000, 100000000, 0.28, true));
		parameterTypes.add(new ParameterTypeDouble(MINDIV_LABEL, "TODO: Add description", -100000000, 100000000, 0.8, true));
		parameterTypes.add(new ParameterTypeDouble(XN_LABEL, "TODO: Add description", -100000000, 100000000, 8.0, true));
		parameterTypes.add(new ParameterTypeDouble(DN_LABEL, "TODO: Add description", -100000000, 100000000, 1.4, true));
		parameterTypes.add(new ParameterTypeInt(MINDIFFS_LABEL, "TODO: Add description", -100000000, 100000000, 3, true));
		parameterTypes.add(new ParameterTypeString(VSEARCH_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeBoolean(DEREPLICATE_LABEL, "TODO: Add description", false, true));
		return parameterTypes;
	}

	@Override
	public String getOutputPattern(String type) {
		if (type.equals("alns")) return "[filename],[tag],vsearch.alns";
		if (type.equals("chimera")) return "[filename],[tag],vsearch.chimeras";
		if (type.equals("count")) return "[filename],[tag],vsearch.pick.count_table-[filename],count_table";
		if (type.equals("accnos")) return "[filename],[tag],vsearch.accnos";
		return super.getOutputPattern(type);
	}
}
