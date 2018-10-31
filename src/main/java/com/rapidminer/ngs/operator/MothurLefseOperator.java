package com.rapidminer.ngs.operator;

import java.util.List;
import com.rapidminer.operator.OperatorDescription;
import com.rapidminer.operator.ports.InputPort;
import com.rapidminer.operator.ports.OutputPort;
import com.rapidminer.operator.OperatorException;
import com.rapidminer.parameter.*;

public class MothurLefseOperator extends MothurGeneratedOperator {

	private InputPort designInPort = getInputPorts().createPort("design");
	private InputPort sharedInPort = getInputPorts().createPort("shared");
	private OutputPort summaryOutPort = getOutputPorts().createPort("summary");
	private static final String CLASS_LABEL = "class:";
	private static final String SUBCLASS_LABEL = "subclass:";
	private static final String LABEL_LABEL = "label:";
	private static final String AALPHA_LABEL = "aalpha:";
	private static final String WALPHA_LABEL = "walpha:";
	private static final String SETS_LABEL = "sets:";
	private static final String LDA_LABEL = "lda:";
	private static final String WILC_LABEL = "wilc:";
	private static final String NORM_LABEL = "norm:";
	private static final String ITERS_LABEL = "iters:";
	private static final String CURV_LABEL = "curv:";
	private static final String FBOOTS_LABEL = "fboots:";
	private static final String[] STRICT_CHOICES = { "0", "1", "2" };
	private static final int STRICT_DEFAULT_CHOICE = 0;
	private static final String STRICT_LABEL = "strict:";
	private static final String MINC_LABEL = "minc:";
	private static final String[] MULTICLASS_CHOICES = { "onevone", "onevall" };
	private static final int MULTICLASS_DEFAULT_CHOICE = 1;
	private static final String MULTICLASS_LABEL = "multiclass:";
	private static final String SEED_LABEL = "seed:";
	private static final String INPUTDIR_LABEL = "inputdir:";
	private static final String OUTPUTDIR_LABEL = "outputdir:";

	public MothurLefseOperator (OperatorDescription description) {
		super(description);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void doWork() throws OperatorException {
		super.doWork();
		clearArguments();
		FileNameObject designFile = designInPort.getData(FileNameObject.class);
		addArgument("design",designFile.getName());
		FileNameObject sharedFile = sharedInPort.getData(FileNameObject.class);
		addArgument("shared",sharedFile.getName());
		String classValue = getParameterAsString(CLASS_LABEL);
		addArgument("class",String.valueOf(classValue));
		String subclassValue = getParameterAsString(SUBCLASS_LABEL);
		addArgument("subclass",String.valueOf(subclassValue));
		String labelValue = getParameterAsString(LABEL_LABEL);
		addArgument("label",String.valueOf(labelValue));
		int aalphaValue = getParameterAsInt(AALPHA_LABEL);
		addArgument("aalpha",String.valueOf(aalphaValue));
		int walphaValue = getParameterAsInt(WALPHA_LABEL);
		addArgument("walpha",String.valueOf(walphaValue));
		String setsValue = getParameterAsString(SETS_LABEL);
		addArgument("sets",String.valueOf(setsValue));
		int ldaValue = getParameterAsInt(LDA_LABEL);
		addArgument("lda",String.valueOf(ldaValue));
		boolean wilcValue = getParameterAsBoolean(WILC_LABEL);
		addArgument("wilc",String.valueOf(wilcValue));
		boolean normValue = getParameterAsBoolean(NORM_LABEL);
		addArgument("norm",String.valueOf(normValue));
		int itersValue = getParameterAsInt(ITERS_LABEL);
		addArgument("iters",String.valueOf(itersValue));
		boolean curvValue = getParameterAsBoolean(CURV_LABEL);
		addArgument("curv",String.valueOf(curvValue));
		int fbootsValue = getParameterAsInt(FBOOTS_LABEL);
		addArgument("fboots",String.valueOf(fbootsValue));
		int strictIndex = getParameterAsInt(STRICT_LABEL);
		String strictValue = STRICT_CHOICES[strictIndex];
		addArgument("strict",String.valueOf(strictValue));
		int mincValue = getParameterAsInt(MINC_LABEL);
		addArgument("minc",String.valueOf(mincValue));
		int multiclassIndex = getParameterAsInt(MULTICLASS_LABEL);
		String multiclassValue = MULTICLASS_CHOICES[multiclassIndex];
		addArgument("multiclass",String.valueOf(multiclassValue));
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
		parameterTypes.add(new ParameterTypeString(CLASS_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeString(SUBCLASS_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeString(LABEL_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeDouble(AALPHA_LABEL, "TODO: Add description", -100000000, 100000000, 0.05, true));
		parameterTypes.add(new ParameterTypeDouble(WALPHA_LABEL, "TODO: Add description", -100000000, 100000000, 0.05, true));
		parameterTypes.add(new ParameterTypeString(SETS_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeDouble(LDA_LABEL, "TODO: Add description", -100000000, 100000000, 2.0, true));
		parameterTypes.add(new ParameterTypeBoolean(WILC_LABEL, "TODO: Add description", true, true));
		parameterTypes.add(new ParameterTypeBoolean(NORM_LABEL, "TODO: Add description", true, true));
		parameterTypes.add(new ParameterTypeInt(ITERS_LABEL, "TODO: Add description", -100000000, 100000000, 30, true));
		parameterTypes.add(new ParameterTypeBoolean(CURV_LABEL, "TODO: Add description", false, true));
		parameterTypes.add(new ParameterTypeDouble(FBOOTS_LABEL, "TODO: Add description", -100000000, 100000000, 0.67, true));
		parameterTypes.add(new ParameterTypeCategory(STRICT_LABEL, "TODO: Add description", STRICT_CHOICES, STRICT_DEFAULT_CHOICE));
		parameterTypes.add(new ParameterTypeInt(MINC_LABEL, "TODO: Add description", -100000000, 100000000, 10, true));
		parameterTypes.add(new ParameterTypeCategory(MULTICLASS_LABEL, "TODO: Add description", MULTICLASS_CHOICES, MULTICLASS_DEFAULT_CHOICE));
		parameterTypes.add(new ParameterTypeInt(SEED_LABEL, "TODO: Add description", -100000000, 100000000, 0, true));
		parameterTypes.add(new ParameterTypeString(INPUTDIR_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeString(OUTPUTDIR_LABEL, "TODO: Add description", "", true));
		return parameterTypes;
	}

	@Override
	public String getOutputPattern(String type) {
		// TODO Use a dictionary to reflect type to pattern
		if (type.equals("summary")) return "[filename],[distance],lefse_summary";
		// TODO if nil then 
		return super.getOutputPattern(type);
	}
}
