package com.rapidminer.ngs.operator;

import java.util.List;
import com.rapidminer.operator.OperatorDescription;
import com.rapidminer.operator.ports.InputPort;
import com.rapidminer.operator.ports.OutputPort;
import com.rapidminer.operator.OperatorException;
import com.rapidminer.parameter.*;

public class MothurChimeraUchimeOperator extends MothurGeneratedOperator {

	private InputPort referenceInPort = getInputPorts().createPort("reference");
	private InputPort fastaInPort = getInputPorts().createPort("fasta");
	private InputPort nameInPort = getInputPorts().createPort("name");
	private InputPort countInPort = getInputPorts().createPort("count");
	private InputPort groupInPort = getInputPorts().createPort("group");
	private OutputPort alnsOutPort = getOutputPorts().createPort("alns");
	private OutputPort chimeraOutPort = getOutputPorts().createPort("chimera");
	private OutputPort countOutPort = getOutputPorts().createPort("count");
	private OutputPort accnosOutPort = getOutputPorts().createPort("accnos");
	private static final String PROCESSORS_LABEL = "processors:";
	private static final String STRAND_LABEL = "strand:";
	private static final String SEED_LABEL = "seed:";
	private static final String INPUTDIR_LABEL = "inputdir:";
	private static final String OUTPUTDIR_LABEL = "outputdir:";
	private static final String ABSKEW_LABEL = "abskew:";
	private static final String CHIMEALNS_LABEL = "chimealns:";
	private static final String MINH_LABEL = "minh:";
	private static final String MINDIV_LABEL = "mindiv:";
	private static final String XN_LABEL = "xn:";
	private static final String DN_LABEL = "dn:";
	private static final String XA_LABEL = "xa:";
	private static final String CHUNKS_LABEL = "chunks:";
	private static final String MINCHUNK_LABEL = "minchunk:";
	private static final String IDSMOOTHWINDOW_LABEL = "idsmoothwindow:";
	private static final String DEREPLICATE_LABEL = "dereplicate:";
	private static final String MAXP_LABEL = "maxp:";
	private static final String SKIPGAPS_LABEL = "skipgaps:";
	private static final String SKIPGAPS2_LABEL = "skipgaps2:";
	private static final String MINLEN_LABEL = "minlen:";
	private static final String MAXLEN_LABEL = "maxlen:";
	private static final String UCL_LABEL = "ucl:";
	private static final String QUERYFRACT_LABEL = "queryfract:";

	public MothurChimeraUchimeOperator (OperatorDescription description) {
		super(description);
		// TODO Auto-generated constructor stub
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
		String strandValue = getParameterAsString(STRAND_LABEL);
		addArgument("strand",String.valueOf(strandValue));
		int seedValue = getParameterAsInt(SEED_LABEL);
		addArgument("seed",String.valueOf(seedValue));
		String inputdirValue = getParameterAsString(INPUTDIR_LABEL);
		addArgument("inputdir",String.valueOf(inputdirValue));
		String outputdirValue = getParameterAsString(OUTPUTDIR_LABEL);
		addArgument("outputdir",String.valueOf(outputdirValue));
		int abskewValue = getParameterAsInt(ABSKEW_LABEL);
		addArgument("abskew",String.valueOf(abskewValue));
		boolean chimealnsValue = getParameterAsBoolean(CHIMEALNS_LABEL);
		addArgument("chimealns",String.valueOf(chimealnsValue));
		int minhValue = getParameterAsInt(MINH_LABEL);
		addArgument("minh",String.valueOf(minhValue));
		int mindivValue = getParameterAsInt(MINDIV_LABEL);
		addArgument("mindiv",String.valueOf(mindivValue));
		int xnValue = getParameterAsInt(XN_LABEL);
		addArgument("xn",String.valueOf(xnValue));
		int dnValue = getParameterAsInt(DN_LABEL);
		addArgument("dn",String.valueOf(dnValue));
		int xaValue = getParameterAsInt(XA_LABEL);
		addArgument("xa",String.valueOf(xaValue));
		int chunksValue = getParameterAsInt(CHUNKS_LABEL);
		addArgument("chunks",String.valueOf(chunksValue));
		int minchunkValue = getParameterAsInt(MINCHUNK_LABEL);
		addArgument("minchunk",String.valueOf(minchunkValue));
		int idsmoothwindowValue = getParameterAsInt(IDSMOOTHWINDOW_LABEL);
		addArgument("idsmoothwindow",String.valueOf(idsmoothwindowValue));
		boolean dereplicateValue = getParameterAsBoolean(DEREPLICATE_LABEL);
		addArgument("dereplicate",String.valueOf(dereplicateValue));
		int maxpValue = getParameterAsInt(MAXP_LABEL);
		addArgument("maxp",String.valueOf(maxpValue));
		boolean skipgapsValue = getParameterAsBoolean(SKIPGAPS_LABEL);
		addArgument("skipgaps",String.valueOf(skipgapsValue));
		boolean skipgaps2Value = getParameterAsBoolean(SKIPGAPS2_LABEL);
		addArgument("skipgaps2",String.valueOf(skipgaps2Value));
		int minlenValue = getParameterAsInt(MINLEN_LABEL);
		addArgument("minlen",String.valueOf(minlenValue));
		int maxlenValue = getParameterAsInt(MAXLEN_LABEL);
		addArgument("maxlen",String.valueOf(maxlenValue));
		boolean uclValue = getParameterAsBoolean(UCL_LABEL);
		addArgument("ucl",String.valueOf(uclValue));
		int queryfractValue = getParameterAsInt(QUERYFRACT_LABEL);
		addArgument("queryfract",String.valueOf(queryfractValue));
		executeMothurCommand();
		String fileName="<fileName>"; // TODO: Somehow figure out the fileName
		alnsOutPort.deliver(new FileNameObject(fileName+".alns","alns"));
		chimeraOutPort.deliver(new FileNameObject(fileName+".chimera","chimera"));
		countOutPort.deliver(new FileNameObject(fileName+".count","count"));
		accnosOutPort.deliver(new FileNameObject(fileName+".accnos","accnos"));
	}

	@Override
	public List<ParameterType> getParameterTypes() {
		List<ParameterType> parameterTypes = super.getParameterTypes();
		parameterTypes.add(new ParameterTypeInt(PROCESSORS_LABEL, "TODO: Add description", -100000000, 100000000, 1, true));
		parameterTypes.add(new ParameterTypeString(STRAND_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeInt(SEED_LABEL, "TODO: Add description", -100000000, 100000000, 0, true));
		parameterTypes.add(new ParameterTypeString(INPUTDIR_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeString(OUTPUTDIR_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeDouble(ABSKEW_LABEL, "TODO: Add description", -100000000, 100000000, 1.9, true));
		parameterTypes.add(new ParameterTypeBoolean(CHIMEALNS_LABEL, "TODO: Add description", false, true));
		parameterTypes.add(new ParameterTypeDouble(MINH_LABEL, "TODO: Add description", -100000000, 100000000, 0.3, true));
		parameterTypes.add(new ParameterTypeDouble(MINDIV_LABEL, "TODO: Add description", -100000000, 100000000, 0.5, true));
		parameterTypes.add(new ParameterTypeDouble(XN_LABEL, "TODO: Add description", -100000000, 100000000, 8.0, true));
		parameterTypes.add(new ParameterTypeDouble(DN_LABEL, "TODO: Add description", -100000000, 100000000, 1.4, true));
		parameterTypes.add(new ParameterTypeInt(XA_LABEL, "TODO: Add description", -100000000, 100000000, 1, true));
		parameterTypes.add(new ParameterTypeInt(CHUNKS_LABEL, "TODO: Add description", -100000000, 100000000, 4, true));
		parameterTypes.add(new ParameterTypeInt(MINCHUNK_LABEL, "TODO: Add description", -100000000, 100000000, 64, true));
		parameterTypes.add(new ParameterTypeInt(IDSMOOTHWINDOW_LABEL, "TODO: Add description", -100000000, 100000000, 32, true));
		parameterTypes.add(new ParameterTypeBoolean(DEREPLICATE_LABEL, "TODO: Add description", false, true));
		parameterTypes.add(new ParameterTypeInt(MAXP_LABEL, "TODO: Add description", -100000000, 100000000, 2, true));
		parameterTypes.add(new ParameterTypeBoolean(SKIPGAPS_LABEL, "TODO: Add description", true, true));
		parameterTypes.add(new ParameterTypeBoolean(SKIPGAPS2_LABEL, "TODO: Add description", true, true));
		parameterTypes.add(new ParameterTypeInt(MINLEN_LABEL, "TODO: Add description", -100000000, 100000000, 10, true));
		parameterTypes.add(new ParameterTypeInt(MAXLEN_LABEL, "TODO: Add description", -100000000, 100000000, 10000, true));
		parameterTypes.add(new ParameterTypeBoolean(UCL_LABEL, "TODO: Add description", false, true));
		parameterTypes.add(new ParameterTypeDouble(QUERYFRACT_LABEL, "TODO: Add description", -100000000, 100000000, 0.5, true));
		return parameterTypes;
	}

	@Override
	public String getOutputPattern(String type) {
		// TODO Use a dictionary to reflect type to pattern
		if (type.equals("alns")) return "[filename],[tag],uchime.alns";
		if (type.equals("chimera")) return "[filename],[tag],uchime.chimeras";
		if (type.equals("count")) return "[filename],[tag],uchime.pick.count_table";
		if (type.equals("accnos")) return "[filename],[tag],uchime.accnos";
		// TODO if nil then 
		return super.getOutputPattern(type);
	}
}
