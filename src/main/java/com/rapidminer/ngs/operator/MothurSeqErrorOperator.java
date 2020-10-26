package com.rapidminer.ngs.operator;

import java.util.List;
import com.rapidminer.operator.OperatorDescription;
import com.rapidminer.operator.ports.InputPort;
import com.rapidminer.operator.ports.OutputPort;
import com.rapidminer.operator.OperatorException;
import com.rapidminer.parameter.*;

public class MothurSeqErrorOperator extends MothurGeneratedOperator {

	private InputPort fastaInPort = getInputPorts().createPort("fasta");
	private InputPort referenceInPort = getInputPorts().createPort("reference");
	private InputPort qfileInPort = getInputPorts().createPort("qfile");
	private InputPort reportInPort = getInputPorts().createPort("report");
	private InputPort nameInPort = getInputPorts().createPort("name");
	private InputPort countInPort = getInputPorts().createPort("count");
	private OutputPort errorchimeraOutPort = getOutputPorts().createPort("errorchimera");
	private OutputPort errorcountOutPort = getOutputPorts().createPort("errorcount");
	private OutputPort errorforwardOutPort = getOutputPorts().createPort("errorforward");
	private OutputPort errormatrixOutPort = getOutputPorts().createPort("errormatrix");
	private OutputPort errorqualforwardOutPort = getOutputPorts().createPort("errorqualforward");
	private OutputPort errorqualityOutPort = getOutputPorts().createPort("errorquality");
	private OutputPort errorqualreverseOutPort = getOutputPorts().createPort("errorqualreverse");
	private OutputPort errorref_queryOutPort = getOutputPorts().createPort("errorref-query");
	private OutputPort errorreverseOutPort = getOutputPorts().createPort("errorreverse");
	private OutputPort errorseqOutPort = getOutputPorts().createPort("errorseq");
	private OutputPort errorsummaryOutPort = getOutputPorts().createPort("errorsummary");
	private static final String IGNORECHIMERAS_LABEL = "ignorechimeras:";
	private static final String THRESHOLD_LABEL = "threshold:";
	private static final String ALIGNED_LABEL = "aligned:";
	private static final String SEED_LABEL = "seed:";
	private static final String INPUTDIR_LABEL = "inputdir:";
	private static final String OUTPUTDIR_LABEL = "outputdir:";

	public MothurSeqErrorOperator (OperatorDescription description) {
		super(description);
		// NOTE: Auto-generated constructor stub
	}

	@Override
	public void doWork() throws OperatorException {
		super.doWork();
		clearArguments();
		FileNameObject fastaFile = fastaInPort.getData(FileNameObject.class);
		addArgument("fasta",fastaFile.getName());
		FileNameObject referenceFile = referenceInPort.getData(FileNameObject.class);
		addArgument("reference",referenceFile.getName());
		FileNameObject qfileFile = qfileInPort.getData(FileNameObject.class);
		addArgument("qfile",qfileFile.getName());
		FileNameObject reportFile = reportInPort.getData(FileNameObject.class);
		addArgument("report",reportFile.getName());
		FileNameObject nameFile = nameInPort.getData(FileNameObject.class);
		addArgument("name",nameFile.getName());
		FileNameObject countFile = countInPort.getData(FileNameObject.class);
		addArgument("count",countFile.getName());
		boolean ignorechimerasValue = getParameterAsBoolean(IGNORECHIMERAS_LABEL);
		addArgument("ignorechimeras",String.valueOf(ignorechimerasValue));
		int thresholdValue = getParameterAsInt(THRESHOLD_LABEL);
		addArgument("threshold",String.valueOf(thresholdValue));
		boolean alignedValue = getParameterAsBoolean(ALIGNED_LABEL);
		addArgument("aligned",String.valueOf(alignedValue));
		int seedValue = getParameterAsInt(SEED_LABEL);
		addArgument("seed",String.valueOf(seedValue));
		String inputdirValue = getParameterAsString(INPUTDIR_LABEL);
		addArgument("inputdir",String.valueOf(inputdirValue));
		String outputdirValue = getParameterAsString(OUTPUTDIR_LABEL);
		addArgument("outputdir",String.valueOf(outputdirValue));
		executeMothurCommand();
		String fileName="<fileName>"; // TODO: Somehow figure out the fileName
		errorchimeraOutPort.deliver(new FileNameObject(fileName+".errorchimera","errorchimera"));
		errorcountOutPort.deliver(new FileNameObject(fileName+".errorcount","errorcount"));
		errorforwardOutPort.deliver(new FileNameObject(fileName+".errorforward","errorforward"));
		errormatrixOutPort.deliver(new FileNameObject(fileName+".errormatrix","errormatrix"));
		errorqualforwardOutPort.deliver(new FileNameObject(fileName+".errorqualforward","errorqualforward"));
		errorqualityOutPort.deliver(new FileNameObject(fileName+".errorquality","errorquality"));
		errorqualreverseOutPort.deliver(new FileNameObject(fileName+".errorqualreverse","errorqualreverse"));
		errorref_queryOutPort.deliver(new FileNameObject(fileName+".errorref-query","errorref-query"));
		errorreverseOutPort.deliver(new FileNameObject(fileName+".errorreverse","errorreverse"));
		errorseqOutPort.deliver(new FileNameObject(fileName+".errorseq","errorseq"));
		errorsummaryOutPort.deliver(new FileNameObject(fileName+".errorsummary","errorsummary"));
	}

	@Override
	public List<ParameterType> getParameterTypes() {
		List<ParameterType> parameterTypes = super.getParameterTypes();
		parameterTypes.add(new ParameterTypeBoolean(IGNORECHIMERAS_LABEL, "TODO: Add description", true, true));
		parameterTypes.add(new ParameterTypeDouble(THRESHOLD_LABEL, "TODO: Add description", -100000000, 100000000, 1.0, true));
		parameterTypes.add(new ParameterTypeBoolean(ALIGNED_LABEL, "TODO: Add description", true, true));
		parameterTypes.add(new ParameterTypeInt(SEED_LABEL, "TODO: Add description", -100000000, 100000000, 0, true));
		parameterTypes.add(new ParameterTypeString(INPUTDIR_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeString(OUTPUTDIR_LABEL, "TODO: Add description", "", true));
		return parameterTypes;
	}

	@Override
	public String getOutputPattern(String type) {
		if (type.equals("errorquality")) return "[filename],error.quality";
		if (type.equals("errorref-query")) return "[filename],error.ref-query";
		if (type.equals("errorreverse")) return "[filename],error.seq.reverse";
		if (type.equals("errorqualreverse")) return "[filename],error.qual.reverse";
		if (type.equals("errorseq")) return "[filename],error.seq";
		if (type.equals("errorcount")) return "[filename],error.count";
		if (type.equals("errorchimera")) return "[filename],error.chimera";
		if (type.equals("errormatrix")) return "[filename],error.matrix";
		if (type.equals("errorforward")) return "[filename],error.seq.forward";
		if (type.equals("errorsummary")) return "[filename],error.summary";
		if (type.equals("errorqualforward")) return "[filename],error.qual.forward";
		return super.getOutputPattern(type);
	}
}
