package com.rapidminer.ngs.operator;

import java.util.List;
import com.rapidminer.operator.OperatorDescription;
import com.rapidminer.operator.ports.InputPort;
import com.rapidminer.operator.ports.OutputPort;
import com.rapidminer.operator.OperatorException;
import com.rapidminer.parameter.*;

public class MothurScreenSeqsOperator extends MothurGeneratedOperator {

	private InputPort fastaInPort = getInputPorts().createPort("fasta");
	private InputPort contigsreportInPort = getInputPorts().createPort("contigsreport");
	private InputPort alignreportInPort = getInputPorts().createPort("alignreport");
	private InputPort summaryInPort = getInputPorts().createPort("summary");
	private InputPort nameInPort = getInputPorts().createPort("name");
	private InputPort countInPort = getInputPorts().createPort("count");
	private InputPort groupInPort = getInputPorts().createPort("group");
	private InputPort qfileInPort = getInputPorts().createPort("qfile");
	private InputPort taxonomyInPort = getInputPorts().createPort("taxonomy");
	private OutputPort taxonomyOutPort = getOutputPorts().createPort("taxonomy");
	private OutputPort contigsreportOutPort = getOutputPorts().createPort("contigsreport");
	private OutputPort fastaOutPort = getOutputPorts().createPort("fasta");
	private OutputPort summaryOutPort = getOutputPorts().createPort("summary");
	private OutputPort nameOutPort = getOutputPorts().createPort("name");
	private OutputPort countOutPort = getOutputPorts().createPort("count");
	private OutputPort accnosOutPort = getOutputPorts().createPort("accnos");
	private OutputPort alignreportOutPort = getOutputPorts().createPort("alignreport");
	private OutputPort groupOutPort = getOutputPorts().createPort("group");
	private OutputPort qfileOutPort = getOutputPorts().createPort("qfile");
	private static final String START_LABEL = "start:";
	private static final String END_LABEL = "end:";
	private static final String MAXAMBIG_LABEL = "maxambig:";
	private static final String MAXHOMOP_LABEL = "maxhomop:";
	private static final String MINLENGTH_LABEL = "minlength:";
	private static final String MAXLENGTH_LABEL = "maxlength:";
	private static final String PROCESSORS_LABEL = "processors:";
	private static final String CRITERIA_LABEL = "criteria:";
	private static final String SEED_LABEL = "seed:";
	private static final String INPUTDIR_LABEL = "inputdir:";
	private static final String OUTPUTDIR_LABEL = "outputdir:";
	private static final String MINOVERLAP_LABEL = "minoverlap:";
	private static final String OSTART_LABEL = "ostart:";
	private static final String OEND_LABEL = "oend:";
	private static final String MISMATCHES_LABEL = "mismatches:";
	private static final String MAXN_LABEL = "maxn:";
	private static final String MINSCORE_LABEL = "minscore:";
	private static final String MAXINSERT_LABEL = "maxinsert:";
	private static final String MINSIM_LABEL = "minsim:";

	public MothurScreenSeqsOperator (OperatorDescription description) {
		super(description);
		// NOTE: Auto-generated constructor stub
	}

	@Override
	public void doWork() throws OperatorException {
		super.doWork();
		clearArguments();
		FileNameObject fastaFile = fastaInPort.getData(FileNameObject.class);
		addArgument("fasta",fastaFile.getName());
		FileNameObject contigsreportFile = contigsreportInPort.getData(FileNameObject.class);
		addArgument("contigsreport",contigsreportFile.getName());
		FileNameObject alignreportFile = alignreportInPort.getData(FileNameObject.class);
		addArgument("alignreport",alignreportFile.getName());
		FileNameObject summaryFile = summaryInPort.getData(FileNameObject.class);
		addArgument("summary",summaryFile.getName());
		FileNameObject nameFile = nameInPort.getData(FileNameObject.class);
		addArgument("name",nameFile.getName());
		FileNameObject countFile = countInPort.getData(FileNameObject.class);
		addArgument("count",countFile.getName());
		FileNameObject groupFile = groupInPort.getData(FileNameObject.class);
		addArgument("group",groupFile.getName());
		FileNameObject qfileFile = qfileInPort.getData(FileNameObject.class);
		addArgument("qfile",qfileFile.getName());
		FileNameObject taxonomyFile = taxonomyInPort.getData(FileNameObject.class);
		addArgument("taxonomy",taxonomyFile.getName());
		int startValue = getParameterAsInt(START_LABEL);
		addArgument("start",String.valueOf(startValue));
		int endValue = getParameterAsInt(END_LABEL);
		addArgument("end",String.valueOf(endValue));
		int maxambigValue = getParameterAsInt(MAXAMBIG_LABEL);
		addArgument("maxambig",String.valueOf(maxambigValue));
		int maxhomopValue = getParameterAsInt(MAXHOMOP_LABEL);
		addArgument("maxhomop",String.valueOf(maxhomopValue));
		int minlengthValue = getParameterAsInt(MINLENGTH_LABEL);
		addArgument("minlength",String.valueOf(minlengthValue));
		int maxlengthValue = getParameterAsInt(MAXLENGTH_LABEL);
		addArgument("maxlength",String.valueOf(maxlengthValue));
		int processorsValue = getParameterAsInt(PROCESSORS_LABEL);
		addArgument("processors",String.valueOf(processorsValue));
		int criteriaValue = getParameterAsInt(CRITERIA_LABEL);
		addArgument("criteria",String.valueOf(criteriaValue));
		int seedValue = getParameterAsInt(SEED_LABEL);
		addArgument("seed",String.valueOf(seedValue));
		String inputdirValue = getParameterAsString(INPUTDIR_LABEL);
		addArgument("inputdir",String.valueOf(inputdirValue));
		String outputdirValue = getParameterAsString(OUTPUTDIR_LABEL);
		addArgument("outputdir",String.valueOf(outputdirValue));
		int minoverlapValue = getParameterAsInt(MINOVERLAP_LABEL);
		addArgument("minoverlap",String.valueOf(minoverlapValue));
		int ostartValue = getParameterAsInt(OSTART_LABEL);
		addArgument("ostart",String.valueOf(ostartValue));
		int oendValue = getParameterAsInt(OEND_LABEL);
		addArgument("oend",String.valueOf(oendValue));
		int mismatchesValue = getParameterAsInt(MISMATCHES_LABEL);
		addArgument("mismatches",String.valueOf(mismatchesValue));
		int maxnValue = getParameterAsInt(MAXN_LABEL);
		addArgument("maxn",String.valueOf(maxnValue));
		int minscoreValue = getParameterAsInt(MINSCORE_LABEL);
		addArgument("minscore",String.valueOf(minscoreValue));
		int maxinsertValue = getParameterAsInt(MAXINSERT_LABEL);
		addArgument("maxinsert",String.valueOf(maxinsertValue));
		int minsimValue = getParameterAsInt(MINSIM_LABEL);
		addArgument("minsim",String.valueOf(minsimValue));
		executeMothurCommand();
		String fileName="<fileName>"; // TODO: Somehow figure out the fileName
		taxonomyOutPort.deliver(new FileNameObject(fileName+".taxonomy","taxonomy"));
		contigsreportOutPort.deliver(new FileNameObject(fileName+".contigsreport","contigsreport"));
		fastaOutPort.deliver(new FileNameObject(fileName+".fasta","fasta"));
		summaryOutPort.deliver(new FileNameObject(fileName+".summary","summary"));
		nameOutPort.deliver(new FileNameObject(fileName+".name","name"));
		countOutPort.deliver(new FileNameObject(fileName+".count","count"));
		accnosOutPort.deliver(new FileNameObject(fileName+".accnos","accnos"));
		alignreportOutPort.deliver(new FileNameObject(fileName+".alignreport","alignreport"));
		groupOutPort.deliver(new FileNameObject(fileName+".group","group"));
		qfileOutPort.deliver(new FileNameObject(fileName+".qfile","qfile"));
	}

	@Override
	public List<ParameterType> getParameterTypes() {
		List<ParameterType> parameterTypes = super.getParameterTypes();
		parameterTypes.add(new ParameterTypeInt(START_LABEL, "TODO: Add description", -100000000, 100000000, -1, true));
		parameterTypes.add(new ParameterTypeInt(END_LABEL, "TODO: Add description", -100000000, 100000000, -1, true));
		parameterTypes.add(new ParameterTypeInt(MAXAMBIG_LABEL, "TODO: Add description", -100000000, 100000000, -1, true));
		parameterTypes.add(new ParameterTypeInt(MAXHOMOP_LABEL, "TODO: Add description", -100000000, 100000000, -1, true));
		parameterTypes.add(new ParameterTypeInt(MINLENGTH_LABEL, "TODO: Add description", -100000000, 100000000, 10, true));
		parameterTypes.add(new ParameterTypeInt(MAXLENGTH_LABEL, "TODO: Add description", -100000000, 100000000, -1, true));
		parameterTypes.add(new ParameterTypeInt(PROCESSORS_LABEL, "TODO: Add description", -100000000, 100000000, 1, true));
		parameterTypes.add(new ParameterTypeInt(CRITERIA_LABEL, "TODO: Add description", -100000000, 100000000, 90, true));
		parameterTypes.add(new ParameterTypeInt(SEED_LABEL, "TODO: Add description", -100000000, 100000000, 0, true));
		parameterTypes.add(new ParameterTypeString(INPUTDIR_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeString(OUTPUTDIR_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeInt(MINOVERLAP_LABEL, "TODO: Add description", -100000000, 100000000, -1, true));
		parameterTypes.add(new ParameterTypeInt(OSTART_LABEL, "TODO: Add description", -100000000, 100000000, -1, true));
		parameterTypes.add(new ParameterTypeInt(OEND_LABEL, "TODO: Add description", -100000000, 100000000, -1, true));
		parameterTypes.add(new ParameterTypeInt(MISMATCHES_LABEL, "TODO: Add description", -100000000, 100000000, -1, true));
		parameterTypes.add(new ParameterTypeInt(MAXN_LABEL, "TODO: Add description", -100000000, 100000000, -1, true));
		parameterTypes.add(new ParameterTypeInt(MINSCORE_LABEL, "TODO: Add description", -100000000, 100000000, -1, true));
		parameterTypes.add(new ParameterTypeInt(MAXINSERT_LABEL, "TODO: Add description", -100000000, 100000000, -1, true));
		parameterTypes.add(new ParameterTypeInt(MINSIM_LABEL, "TODO: Add description", -100000000, 100000000, -1, true));
		return parameterTypes;
	}

	@Override
	public String getOutputPattern(String type) {
		if (type.equals("taxonomy")) return "[filename],good,[extension]";
		if (type.equals("contigsreport")) return "[filename],good.contigs.report";
		if (type.equals("fasta")) return "[filename],good,[extension]";
		if (type.equals("summary")) return "[filename],good.summary";
		if (type.equals("name")) return "[filename],good,[extension]";
		if (type.equals("count")) return "[filename],good,[extension]";
		if (type.equals("accnos")) return "[filename],bad.accnos";
		if (type.equals("alignreport")) return "[filename],good.align.report";
		if (type.equals("group")) return "[filename],good,[extension]";
		if (type.equals("qfile")) return "[filename],good,[extension]";
		return super.getOutputPattern(type);
	}
}
