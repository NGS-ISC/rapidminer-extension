package com.rapidminer.ngs.operator;

import java.util.List;
import com.rapidminer.operator.OperatorDescription;
import com.rapidminer.operator.ports.InputPort;
import com.rapidminer.operator.ports.OutputPort;
import com.rapidminer.operator.OperatorException;
import com.rapidminer.parameter.*;

public class MothurRarefactionSharedOperator extends MothurGeneratedOperator {

	private InputPort sharedInPort = getInputPorts().createPort("shared");
	private InputPort designInPort = getInputPorts().createPort("design");
	private OutputPort sharedrarefactionOutPort = getOutputPorts().createPort("sharedrarefaction");
	private OutputPort sharedr_nseqsOutPort = getOutputPorts().createPort("sharedr_nseqs");
	private static final String LABEL_LABEL = "label:";
	private static final String FREQ_LABEL = "freq:";
	private static final String ITERS_LABEL = "iters:";
	private static final String[] CALC_CHOICES = { "sharednseqs", "sharedobserved" };
	private static final int CALC_DEFAULT_CHOICE = 1;
	private static final String CALC_LABEL = "calc:";
	private static final String SUBSAMPLEITERS_LABEL = "subsampleiters:";
	private static final String SUBSAMPLE_LABEL = "subsample:";
	private static final String JUMBLE_LABEL = "jumble:";
	private static final String GROUPS_LABEL = "groups:";
	private static final String SETS_LABEL = "sets:";
	private static final String GROUPMODE_LABEL = "groupmode:";
	private static final String SEED_LABEL = "seed:";
	private static final String INPUTDIR_LABEL = "inputdir:";
	private static final String OUTPUTDIR_LABEL = "outputdir:";

	public MothurRarefactionSharedOperator (OperatorDescription description) {
		super(description);
		// NOTE: Auto-generated constructor stub
	}

	@Override
	public void doWork() throws OperatorException {
		super.doWork();
		clearArguments();
		FileNameObject sharedFile = sharedInPort.getData(FileNameObject.class);
		addArgument("shared",sharedFile.getName());
		FileNameObject designFile = designInPort.getData(FileNameObject.class);
		addArgument("design",designFile.getName());
		String labelValue = getParameterAsString(LABEL_LABEL);
		addArgument("label",String.valueOf(labelValue));
		int freqValue = getParameterAsInt(FREQ_LABEL);
		addArgument("freq",String.valueOf(freqValue));
		int itersValue = getParameterAsInt(ITERS_LABEL);
		addArgument("iters",String.valueOf(itersValue));
		int calcIndex = getParameterAsInt(CALC_LABEL);
		String calcValue = CALC_CHOICES[calcIndex];
		addArgument("calc",String.valueOf(calcValue));
		int subsampleitersValue = getParameterAsInt(SUBSAMPLEITERS_LABEL);
		addArgument("subsampleiters",String.valueOf(subsampleitersValue));
		String subsampleValue = getParameterAsString(SUBSAMPLE_LABEL);
		addArgument("subsample",String.valueOf(subsampleValue));
		boolean jumbleValue = getParameterAsBoolean(JUMBLE_LABEL);
		addArgument("jumble",String.valueOf(jumbleValue));
		String groupsValue = getParameterAsString(GROUPS_LABEL);
		addArgument("groups",String.valueOf(groupsValue));
		String setsValue = getParameterAsString(SETS_LABEL);
		addArgument("sets",String.valueOf(setsValue));
		boolean groupmodeValue = getParameterAsBoolean(GROUPMODE_LABEL);
		addArgument("groupmode",String.valueOf(groupmodeValue));
		int seedValue = getParameterAsInt(SEED_LABEL);
		addArgument("seed",String.valueOf(seedValue));
		String inputdirValue = getParameterAsString(INPUTDIR_LABEL);
		addArgument("inputdir",String.valueOf(inputdirValue));
		String outputdirValue = getParameterAsString(OUTPUTDIR_LABEL);
		addArgument("outputdir",String.valueOf(outputdirValue));
		executeMothurCommand();
		String fileName="<fileName>"; // TODO: Somehow figure out the fileName
		sharedrarefactionOutPort.deliver(new FileNameObject(fileName+".sharedrarefaction","sharedrarefaction"));
		sharedr_nseqsOutPort.deliver(new FileNameObject(fileName+".sharedr_nseqs","sharedr_nseqs"));
	}

	@Override
	public List<ParameterType> getParameterTypes() {
		List<ParameterType> parameterTypes = super.getParameterTypes();
		parameterTypes.add(new ParameterTypeString(LABEL_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeInt(FREQ_LABEL, "TODO: Add description", -100000000, 100000000, 100, true));
		parameterTypes.add(new ParameterTypeInt(ITERS_LABEL, "TODO: Add description", -100000000, 100000000, 1000, true));
		parameterTypes.add(new ParameterTypeCategory(CALC_LABEL, "TODO: Add description", CALC_CHOICES, CALC_DEFAULT_CHOICE));
		parameterTypes.add(new ParameterTypeInt(SUBSAMPLEITERS_LABEL, "TODO: Add description", -100000000, 100000000, 1000, true));
		parameterTypes.add(new ParameterTypeString(SUBSAMPLE_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeBoolean(JUMBLE_LABEL, "TODO: Add description", true, true));
		parameterTypes.add(new ParameterTypeString(GROUPS_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeString(SETS_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeBoolean(GROUPMODE_LABEL, "TODO: Add description", true, true));
		parameterTypes.add(new ParameterTypeInt(SEED_LABEL, "TODO: Add description", -100000000, 100000000, 0, true));
		parameterTypes.add(new ParameterTypeString(INPUTDIR_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeString(OUTPUTDIR_LABEL, "TODO: Add description", "", true));
		return parameterTypes;
	}

	@Override
	public String getOutputPattern(String type) {
		if (type.equals("sharedrarefaction")) return "[filename],shared.rarefaction";
		if (type.equals("sharedr_nseqs")) return "[filename],shared.r_nseqs";
		return super.getOutputPattern(type);
	}
}
