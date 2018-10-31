package com.rapidminer.ngs.operator;

import java.util.List;
import com.rapidminer.operator.OperatorDescription;
import com.rapidminer.operator.ports.InputPort;
import com.rapidminer.operator.ports.OutputPort;
import com.rapidminer.operator.OperatorException;
import com.rapidminer.parameter.*;

public class MothurFilterSharedOperator extends MothurGeneratedOperator {

	private InputPort sharedInPort = getInputPorts().createPort("shared");
	private OutputPort sharedOutPort = getOutputPorts().createPort("shared");
	private static final String LABEL_LABEL = "label:";
	private static final String GROUPS_LABEL = "groups:";
	private static final String MINPERCENT_LABEL = "minpercent:";
	private static final String RAREPERCENT_LABEL = "rarepercent:";
	private static final String MINABUND_LABEL = "minabund:";
	private static final String MINTOTAL_LABEL = "mintotal:";
	private static final String MINNUMSAMPLES_LABEL = "minnumsamples:";
	private static final String MINPERCENTSAMPLES_LABEL = "minpercentsamples:";
	private static final String KEEPTIES_LABEL = "keepties:";
	private static final String MAKERARE_LABEL = "makerare:";
	private static final String SEED_LABEL = "seed:";
	private static final String INPUTDIR_LABEL = "inputdir:";
	private static final String OUTPUTDIR_LABEL = "outputdir:";

	public MothurFilterSharedOperator (OperatorDescription description) {
		super(description);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void doWork() throws OperatorException {
		super.doWork();
		clearArguments();
		FileNameObject sharedFile = sharedInPort.getData(FileNameObject.class);
		addArgument("shared",sharedFile.getName());
		String labelValue = getParameterAsString(LABEL_LABEL);
		addArgument("label",String.valueOf(labelValue));
		String groupsValue = getParameterAsString(GROUPS_LABEL);
		addArgument("groups",String.valueOf(groupsValue));
		int minpercentValue = getParameterAsInt(MINPERCENT_LABEL);
		addArgument("minpercent",String.valueOf(minpercentValue));
		int rarepercentValue = getParameterAsInt(RAREPERCENT_LABEL);
		addArgument("rarepercent",String.valueOf(rarepercentValue));
		int minabundValue = getParameterAsInt(MINABUND_LABEL);
		addArgument("minabund",String.valueOf(minabundValue));
		int mintotalValue = getParameterAsInt(MINTOTAL_LABEL);
		addArgument("mintotal",String.valueOf(mintotalValue));
		int minnumsamplesValue = getParameterAsInt(MINNUMSAMPLES_LABEL);
		addArgument("minnumsamples",String.valueOf(minnumsamplesValue));
		int minpercentsamplesValue = getParameterAsInt(MINPERCENTSAMPLES_LABEL);
		addArgument("minpercentsamples",String.valueOf(minpercentsamplesValue));
		boolean keeptiesValue = getParameterAsBoolean(KEEPTIES_LABEL);
		addArgument("keepties",String.valueOf(keeptiesValue));
		boolean makerareValue = getParameterAsBoolean(MAKERARE_LABEL);
		addArgument("makerare",String.valueOf(makerareValue));
		int seedValue = getParameterAsInt(SEED_LABEL);
		addArgument("seed",String.valueOf(seedValue));
		String inputdirValue = getParameterAsString(INPUTDIR_LABEL);
		addArgument("inputdir",String.valueOf(inputdirValue));
		String outputdirValue = getParameterAsString(OUTPUTDIR_LABEL);
		addArgument("outputdir",String.valueOf(outputdirValue));
		executeMothurCommand();
		String fileName="<fileName>"; // TODO: Somehow figure out the fileName
		sharedOutPort.deliver(new FileNameObject(fileName+".shared","shared"));
	}

	@Override
	public List<ParameterType> getParameterTypes() {
		List<ParameterType> parameterTypes = super.getParameterTypes();
		parameterTypes.add(new ParameterTypeString(LABEL_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeString(GROUPS_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeInt(MINPERCENT_LABEL, "TODO: Add description", -100000000, 100000000, -1, true));
		parameterTypes.add(new ParameterTypeInt(RAREPERCENT_LABEL, "TODO: Add description", -100000000, 100000000, -1, true));
		parameterTypes.add(new ParameterTypeInt(MINABUND_LABEL, "TODO: Add description", -100000000, 100000000, -1, true));
		parameterTypes.add(new ParameterTypeInt(MINTOTAL_LABEL, "TODO: Add description", -100000000, 100000000, -1, true));
		parameterTypes.add(new ParameterTypeInt(MINNUMSAMPLES_LABEL, "TODO: Add description", -100000000, 100000000, -1, true));
		parameterTypes.add(new ParameterTypeInt(MINPERCENTSAMPLES_LABEL, "TODO: Add description", -100000000, 100000000, -1, true));
		parameterTypes.add(new ParameterTypeBoolean(KEEPTIES_LABEL, "TODO: Add description", true, true));
		parameterTypes.add(new ParameterTypeBoolean(MAKERARE_LABEL, "TODO: Add description", true, true));
		parameterTypes.add(new ParameterTypeInt(SEED_LABEL, "TODO: Add description", -100000000, 100000000, 0, true));
		parameterTypes.add(new ParameterTypeString(INPUTDIR_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeString(OUTPUTDIR_LABEL, "TODO: Add description", "", true));
		return parameterTypes;
	}

	@Override
	public String getOutputPattern(String type) {
		// TODO Use a dictionary to reflect type to pattern
		if (type.equals("shared")) return "[filename],[distance],filter,[extension]";
		// TODO if nil then 
		return super.getOutputPattern(type);
	}
}
