package com.rapidminer.ngs.operator;

import java.util.List;
import com.rapidminer.operator.OperatorDescription;
import com.rapidminer.operator.ports.InputPort;
import com.rapidminer.operator.ports.OutputPort;
import com.rapidminer.operator.OperatorException;
import com.rapidminer.parameter.*;

public class MothurSummarySingleOperator extends MothurGeneratedOperator {

	private InputPort listInPort = getInputPorts().createPort("list");
	private InputPort rabundInPort = getInputPorts().createPort("rabund");
	private InputPort sabundInPort = getInputPorts().createPort("sabund");
	private InputPort sharedInPort = getInputPorts().createPort("shared");
	private OutputPort summaryOutPort = getOutputPorts().createPort("summary");
	private static final String SUBSAMPLE_LABEL = "subsample:";
	private static final String ITERS_LABEL = "iters:";
	private static final String LABEL_LABEL = "label:";
	private static final String[] CALC_CHOICES = { "sobs", "chao", "nseqs", "coverage", "ace", "jack", "shannon", "shannoneven", "npshannon", "heip", "smithwilson", "simpson", "simpsoneven", "invsimpson", "bootstrap", "geometric", "qstat", "logseries", "bergerparker", "bstick", "goodscoverage", "efron", "boneh", "solow", "shen" };
	private static final int CALC_DEFAULT_CHOICE = 0;
	private static final String CALC_LABEL = "calc:";
	private static final String[] ALPHA_CHOICES = { "0", "1", "2" };
	private static final int ALPHA_DEFAULT_CHOICE = 1;
	private static final String ALPHA_LABEL = "alpha:";
	private static final String ABUND_LABEL = "abund:";
	private static final String SIZE_LABEL = "size:";
	private static final String GROUPMODE_LABEL = "groupmode:";
	private static final String SEED_LABEL = "seed:";
	private static final String INPUTDIR_LABEL = "inputdir:";
	private static final String OUTPUTDIR_LABEL = "outputdir:";

	public MothurSummarySingleOperator (OperatorDescription description) {
		super(description);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void doWork() throws OperatorException {
		super.doWork();
		clearArguments();
		FileNameObject listFile = listInPort.getData(FileNameObject.class);
		addArgument("list",listFile.getName());
		FileNameObject rabundFile = rabundInPort.getData(FileNameObject.class);
		addArgument("rabund",rabundFile.getName());
		FileNameObject sabundFile = sabundInPort.getData(FileNameObject.class);
		addArgument("sabund",sabundFile.getName());
		FileNameObject sharedFile = sharedInPort.getData(FileNameObject.class);
		addArgument("shared",sharedFile.getName());
		String subsampleValue = getParameterAsString(SUBSAMPLE_LABEL);
		addArgument("subsample",String.valueOf(subsampleValue));
		int itersValue = getParameterAsInt(ITERS_LABEL);
		addArgument("iters",String.valueOf(itersValue));
		String labelValue = getParameterAsString(LABEL_LABEL);
		addArgument("label",String.valueOf(labelValue));
		int calcIndex = getParameterAsInt(CALC_LABEL);
		String calcValue = CALC_CHOICES[calcIndex];
		addArgument("calc",String.valueOf(calcValue));
		int alphaIndex = getParameterAsInt(ALPHA_LABEL);
		String alphaValue = ALPHA_CHOICES[alphaIndex];
		addArgument("alpha",String.valueOf(alphaValue));
		int abundValue = getParameterAsInt(ABUND_LABEL);
		addArgument("abund",String.valueOf(abundValue));
		int sizeValue = getParameterAsInt(SIZE_LABEL);
		addArgument("size",String.valueOf(sizeValue));
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
		summaryOutPort.deliver(new FileNameObject(fileName+".summary","summary"));
	}

	@Override
	public List<ParameterType> getParameterTypes() {
		List<ParameterType> parameterTypes = super.getParameterTypes();
		parameterTypes.add(new ParameterTypeString(SUBSAMPLE_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeInt(ITERS_LABEL, "TODO: Add description", -100000000, 100000000, 1000, true));
		parameterTypes.add(new ParameterTypeString(LABEL_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeCategory(CALC_LABEL, "TODO: Add description", CALC_CHOICES, CALC_DEFAULT_CHOICE));
		parameterTypes.add(new ParameterTypeCategory(ALPHA_LABEL, "TODO: Add description", ALPHA_CHOICES, ALPHA_DEFAULT_CHOICE));
		parameterTypes.add(new ParameterTypeInt(ABUND_LABEL, "TODO: Add description", -100000000, 100000000, 10, true));
		parameterTypes.add(new ParameterTypeInt(SIZE_LABEL, "TODO: Add description", -100000000, 100000000, 0, true));
		parameterTypes.add(new ParameterTypeBoolean(GROUPMODE_LABEL, "TODO: Add description", true, true));
		parameterTypes.add(new ParameterTypeInt(SEED_LABEL, "TODO: Add description", -100000000, 100000000, 0, true));
		parameterTypes.add(new ParameterTypeString(INPUTDIR_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeString(OUTPUTDIR_LABEL, "TODO: Add description", "", true));
		return parameterTypes;
	}

	@Override
	public String getOutputPattern(String type) {
		// TODO Use a dictionary to reflect type to pattern
		if (type.equals("summary")) return "[filename],summary-[filename],[tag],summary";
		// TODO if nil then 
		return super.getOutputPattern(type);
	}
}
