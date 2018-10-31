package com.rapidminer.ngs.operator;

import java.util.List;
import com.rapidminer.operator.OperatorDescription;
import com.rapidminer.operator.ports.InputPort;
import com.rapidminer.operator.ports.OutputPort;
import com.rapidminer.operator.OperatorException;
import com.rapidminer.parameter.*;

public class MothurClassifyRfOperator extends MothurGeneratedOperator {

	private InputPort sharedInPort = getInputPorts().createPort("shared");
	private InputPort designInPort = getInputPorts().createPort("design");
	private OutputPort summaryOutPort = getOutputPorts().createPort("summary");
	private static final String[] OTUPERSPLIT_CHOICES = { "log2", "squareroot" };
	private static final int OTUPERSPLIT_DEFAULT_CHOICE = 0;
	private static final String OTUPERSPLIT_LABEL = "otupersplit:";
	private static final String[] SPLITCRITERIA_CHOICES = { "gainratio", "infogain" };
	private static final int SPLITCRITERIA_DEFAULT_CHOICE = 0;
	private static final String SPLITCRITERIA_LABEL = "splitcriteria:";
	private static final String NUMTREES_LABEL = "numtrees:";
	private static final String PRUNE_LABEL = "prune:";
	private static final String PRUNEAGGRESSIVENESS_LABEL = "pruneaggressiveness:";
	private static final String DISCARDERRORTREES_LABEL = "discarderrortrees:";
	private static final String ERRORTHRESHOLD_LABEL = "errorthreshold:";
	private static final String STDTHRESHOLD_LABEL = "stdthreshold:";
	private static final String GROUPS_LABEL = "groups:";
	private static final String LABEL_LABEL = "label:";
	private static final String SEED_LABEL = "seed:";
	private static final String INPUTDIR_LABEL = "inputdir:";
	private static final String OUTPUTDIR_LABEL = "outputdir:";

	public MothurClassifyRfOperator (OperatorDescription description) {
		super(description);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void doWork() throws OperatorException {
		super.doWork();
		clearArguments();
		FileNameObject sharedFile = sharedInPort.getData(FileNameObject.class);
		addArgument("shared",sharedFile.getName());
		FileNameObject designFile = designInPort.getData(FileNameObject.class);
		addArgument("design",designFile.getName());
		int otupersplitIndex = getParameterAsInt(OTUPERSPLIT_LABEL);
		String otupersplitValue = OTUPERSPLIT_CHOICES[otupersplitIndex];
		addArgument("otupersplit",String.valueOf(otupersplitValue));
		int splitcriteriaIndex = getParameterAsInt(SPLITCRITERIA_LABEL);
		String splitcriteriaValue = SPLITCRITERIA_CHOICES[splitcriteriaIndex];
		addArgument("splitcriteria",String.valueOf(splitcriteriaValue));
		int numtreesValue = getParameterAsInt(NUMTREES_LABEL);
		addArgument("numtrees",String.valueOf(numtreesValue));
		boolean pruneValue = getParameterAsBoolean(PRUNE_LABEL);
		addArgument("prune",String.valueOf(pruneValue));
		int pruneaggressivenessValue = getParameterAsInt(PRUNEAGGRESSIVENESS_LABEL);
		addArgument("pruneaggressiveness",String.valueOf(pruneaggressivenessValue));
		boolean discarderrortreesValue = getParameterAsBoolean(DISCARDERRORTREES_LABEL);
		addArgument("discarderrortrees",String.valueOf(discarderrortreesValue));
		int errorthresholdValue = getParameterAsInt(ERRORTHRESHOLD_LABEL);
		addArgument("errorthreshold",String.valueOf(errorthresholdValue));
		int stdthresholdValue = getParameterAsInt(STDTHRESHOLD_LABEL);
		addArgument("stdthreshold",String.valueOf(stdthresholdValue));
		String groupsValue = getParameterAsString(GROUPS_LABEL);
		addArgument("groups",String.valueOf(groupsValue));
		String labelValue = getParameterAsString(LABEL_LABEL);
		addArgument("label",String.valueOf(labelValue));
		int seedValue = getParameterAsInt(SEED_LABEL);
		addArgument("seed",String.valueOf(seedValue));
		String inputdirValue = getParameterAsString(INPUTDIR_LABEL);
		addArgument("inputdir",String.valueOf(inputdirValue));
		String outputdirValue = getParameterAsString(OUTPUTDIR_LABEL);
		addArgument("outputdir",String.valueOf(outputdirValue));
		executeMothurCommand();
		String fileName="<fileName>"; // TODO: Somehow figure out the fileName
		summaryOutPort.deliver(new FileNameObject(fileName+".summary","summary"));
	}

	@Override
	public List<ParameterType> getParameterTypes() {
		List<ParameterType> parameterTypes = super.getParameterTypes();
		parameterTypes.add(new ParameterTypeCategory(OTUPERSPLIT_LABEL, "TODO: Add description", OTUPERSPLIT_CHOICES, OTUPERSPLIT_DEFAULT_CHOICE));
		parameterTypes.add(new ParameterTypeCategory(SPLITCRITERIA_LABEL, "TODO: Add description", SPLITCRITERIA_CHOICES, SPLITCRITERIA_DEFAULT_CHOICE));
		parameterTypes.add(new ParameterTypeInt(NUMTREES_LABEL, "TODO: Add description", -100000000, 100000000, 100, true));
		parameterTypes.add(new ParameterTypeBoolean(PRUNE_LABEL, "TODO: Add description", true, true));
		parameterTypes.add(new ParameterTypeDouble(PRUNEAGGRESSIVENESS_LABEL, "TODO: Add description", -100000000, 100000000, 0.9, true));
		parameterTypes.add(new ParameterTypeBoolean(DISCARDERRORTREES_LABEL, "TODO: Add description", true, true));
		parameterTypes.add(new ParameterTypeDouble(ERRORTHRESHOLD_LABEL, "TODO: Add description", -100000000, 100000000, 0.4, true));
		parameterTypes.add(new ParameterTypeDouble(STDTHRESHOLD_LABEL, "TODO: Add description", -100000000, 100000000, 0.0, true));
		parameterTypes.add(new ParameterTypeString(GROUPS_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeString(LABEL_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeInt(SEED_LABEL, "TODO: Add description", -100000000, 100000000, 0, true));
		parameterTypes.add(new ParameterTypeString(INPUTDIR_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeString(OUTPUTDIR_LABEL, "TODO: Add description", "", true));
		return parameterTypes;
	}

	@Override
	public String getOutputPattern(String type) {
		// TODO Use a dictionary to reflect type to pattern
		if (type.equals("summary")) return "[filename],[distance],summary";
		// TODO if nil then 
		return super.getOutputPattern(type);
	}
}
