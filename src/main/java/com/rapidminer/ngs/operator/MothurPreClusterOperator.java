package com.rapidminer.ngs.operator;

import java.util.List;
import com.rapidminer.operator.OperatorDescription;
import com.rapidminer.operator.ports.InputPort;
import com.rapidminer.operator.ports.OutputPort;
import com.rapidminer.operator.OperatorException;
import com.rapidminer.parameter.*;

public class MothurPreClusterOperator extends MothurGeneratedOperator {

	private InputPort countInPort = getInputPorts().createPort("count");
	private InputPort fastaInPort = getInputPorts().createPort("fasta");
	private InputPort groupInPort = getInputPorts().createPort("group");
	private InputPort nameInPort = getInputPorts().createPort("name");
	private OutputPort fastaOutPort = getOutputPorts().createPort("fasta");
	private OutputPort nameOutPort = getOutputPorts().createPort("name");
	private OutputPort mapOutPort = getOutputPorts().createPort("map");
	private OutputPort countOutPort = getOutputPorts().createPort("count");
	public static final String[] ALIGN_CHOICES = { "blast", "gotoh", "needleman", "noalign" };
	public static final int ALIGN_DEFAULT_CHOICE = 2;
	private static final String ALIGN_LABEL = "align:";
	private static final String DIFFS_LABEL = "diffs:";
	private static final String GAPEXTEND_LABEL = "gapextend:";
	private static final String GAPOPEN_LABEL = "gapopen:";
	private static final String INPUTDIR_LABEL = "inputdir:";
	private static final String MATCH_LABEL = "match:";
	private static final String MISMATCH_LABEL = "mismatch:";
	private static final String OUTPUTDIR_LABEL = "outputdir:";
	private static final String PROCESSORS_LABEL = "processors:";
	private static final String SEED_LABEL = "seed:";
	private static final String TOPDOWN_LABEL = "topdown:";

	public MothurPreClusterOperator (OperatorDescription description) {
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
		FileNameObject groupFile = groupInPort.getData(FileNameObject.class);
		addArgument("group",groupFile.getName());
		FileNameObject nameFile = nameInPort.getData(FileNameObject.class);
		addArgument("name",nameFile.getName());
		int alignIndex = getParameterAsInt(ALIGN_LABEL);
		String alignValue = ALIGN_CHOICES[alignIndex];
		addArgument("align",String.valueOf(alignValue));
		int diffsValue = getParameterAsInt(DIFFS_LABEL);
		addArgument("diffs",String.valueOf(diffsValue));
		int gapextendValue = getParameterAsInt(GAPEXTEND_LABEL);
		addArgument("gapextend",String.valueOf(gapextendValue));
		int gapopenValue = getParameterAsInt(GAPOPEN_LABEL);
		addArgument("gapopen",String.valueOf(gapopenValue));
		String inputdirValue = getParameterAsString(INPUTDIR_LABEL);
		addArgument("inputdir",String.valueOf(inputdirValue));
		int matchValue = getParameterAsInt(MATCH_LABEL);
		addArgument("match",String.valueOf(matchValue));
		int mismatchValue = getParameterAsInt(MISMATCH_LABEL);
		addArgument("mismatch",String.valueOf(mismatchValue));
		String outputdirValue = getParameterAsString(OUTPUTDIR_LABEL);
		addArgument("outputdir",String.valueOf(outputdirValue));
		int processorsValue = getParameterAsInt(PROCESSORS_LABEL);
		addArgument("processors",String.valueOf(processorsValue));
		int seedValue = getParameterAsInt(SEED_LABEL);
		addArgument("seed",String.valueOf(seedValue));
		boolean topdownValue = getParameterAsBoolean(TOPDOWN_LABEL);
		addArgument("topdown",String.valueOf(topdownValue));
		executeMothurCommand();
		String fileName="<fileName>"; // TODO: Somehow figure out the fileName
		fastaOutPort.deliver(new FileNameObject(fileName+".fasta","fasta"));
		nameOutPort.deliver(new FileNameObject(fileName+".name","name"));
		mapOutPort.deliver(new FileNameObject(fileName+".map","map"));
		countOutPort.deliver(new FileNameObject(fileName+".count","count"));
	}

	@Override
	public List<ParameterType> getParameterTypes() {
		List<ParameterType> parameterTypes = super.getParameterTypes();
		parameterTypes.add(new ParameterTypeCategory(ALIGN_LABEL, "TODO: Add description", ALIGN_CHOICES, ALIGN_DEFAULT_CHOICE));
		parameterTypes.add(new ParameterTypeInt(DIFFS_LABEL, "TODO: Add description", -100000000, 100000000, 1, true));
		parameterTypes.add(new ParameterTypeDouble(GAPEXTEND_LABEL, "TODO: Add description", -100000000, 100000000, -1.0, true));
		parameterTypes.add(new ParameterTypeDouble(GAPOPEN_LABEL, "TODO: Add description", -100000000, 100000000, -2.0, true));
		parameterTypes.add(new ParameterTypeString(INPUTDIR_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeDouble(MATCH_LABEL, "TODO: Add description", -100000000, 100000000, 1.0, true));
		parameterTypes.add(new ParameterTypeDouble(MISMATCH_LABEL, "TODO: Add description", -100000000, 100000000, -1.0, true));
		parameterTypes.add(new ParameterTypeString(OUTPUTDIR_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeInt(PROCESSORS_LABEL, "TODO: Add description", -100000000, 100000000, 1, true));
		parameterTypes.add(new ParameterTypeInt(SEED_LABEL, "TODO: Add description", -100000000, 100000000, 0, true));
		parameterTypes.add(new ParameterTypeBoolean(TOPDOWN_LABEL, "TODO: Add description", true, true));
		return parameterTypes;
	}

	@Override
	public String getOutputPattern(String type) {
		// TODO Use a dictionary to reflect type to pattern
		if (type=="fasta") return "[filename],precluster,[extension]";
		if (type=="name") return "[filename],precluster.names";
		if (type=="map") return "[filename],precluster.map";
		if (type=="count") return "[filename],precluster.count_table";
		// TODO if nil then 
		return super.getOutputPattern(type);
	}
}
