package com.rapidminer.ngs.operator;

import java.util.List;
import com.rapidminer.operator.OperatorDescription;
import com.rapidminer.operator.ports.InputPort;
import com.rapidminer.operator.ports.OutputPort;
import com.rapidminer.operator.OperatorException;
import com.rapidminer.parameter.*;

public class MothurGetCoremicrobiomeOperator extends MothurGeneratedOperator {

	private InputPort relabundInPort = getInputPorts().createPort("relabund");
	private InputPort sharedInPort = getInputPorts().createPort("shared");
	private OutputPort coremicrobiomeOutPort = getOutputPorts().createPort("coremicrobiome");
	private static final String ABUNDANCE_LABEL = "abundance:";
	private static final String GROUPS_LABEL = "groups:";
	private static final String INPUTDIR_LABEL = "inputdir:";
	private static final String LABEL_LABEL = "label:";
	public static final String[] OUTPUT_CHOICES = { "count", "fraction" };
	public static final int OUTPUT_DEFAULT_CHOICE = 1;
	private static final String OUTPUT_LABEL = "output:";
	private static final String OUTPUTDIR_LABEL = "outputdir:";
	private static final String SAMPLES_LABEL = "samples:";
	private static final String SEED_LABEL = "seed:";

	public MothurGetCoremicrobiomeOperator (OperatorDescription description) {
		super(description);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void doWork() throws OperatorException {
		super.doWork();
		clearArguments();
		FileNameObject relabundFile = relabundInPort.getData(FileNameObject.class);
		addArgument("relabund",relabundFile.getName());
		FileNameObject sharedFile = sharedInPort.getData(FileNameObject.class);
		addArgument("shared",sharedFile.getName());
		int abundanceValue = getParameterAsInt(ABUNDANCE_LABEL);
		addArgument("abundance",String.valueOf(abundanceValue));
		String groupsValue = getParameterAsString(GROUPS_LABEL);
		addArgument("groups",String.valueOf(groupsValue));
		String inputdirValue = getParameterAsString(INPUTDIR_LABEL);
		addArgument("inputdir",String.valueOf(inputdirValue));
		String labelValue = getParameterAsString(LABEL_LABEL);
		addArgument("label",String.valueOf(labelValue));
		int outputIndex = getParameterAsInt(OUTPUT_LABEL);
		String outputValue = OUTPUT_CHOICES[outputIndex];
		addArgument("output",String.valueOf(outputValue));
		String outputdirValue = getParameterAsString(OUTPUTDIR_LABEL);
		addArgument("outputdir",String.valueOf(outputdirValue));
		int samplesValue = getParameterAsInt(SAMPLES_LABEL);
		addArgument("samples",String.valueOf(samplesValue));
		int seedValue = getParameterAsInt(SEED_LABEL);
		addArgument("seed",String.valueOf(seedValue));
		executeMothurCommand();
		String fileName="<fileName>"; // TODO: Somehow figure out the fileName
		coremicrobiomeOutPort.deliver(new FileNameObject(fileName+".coremicrobiome","coremicrobiome"));
	}

	@Override
	public List<ParameterType> getParameterTypes() {
		List<ParameterType> parameterTypes = super.getParameterTypes();
		parameterTypes.add(new ParameterTypeInt(ABUNDANCE_LABEL, "TODO: Add description", -100000000, 100000000, -1, true));
		parameterTypes.add(new ParameterTypeString(GROUPS_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeString(INPUTDIR_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeString(LABEL_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeCategory(OUTPUT_LABEL, "TODO: Add description", OUTPUT_CHOICES, OUTPUT_DEFAULT_CHOICE));
		parameterTypes.add(new ParameterTypeString(OUTPUTDIR_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeInt(SAMPLES_LABEL, "TODO: Add description", -100000000, 100000000, -1, true));
		parameterTypes.add(new ParameterTypeInt(SEED_LABEL, "TODO: Add description", -100000000, 100000000, 0, true));
		return parameterTypes;
	}

	@Override
	public String getOutputPattern(String type) {
		// TODO Use a dictionary to reflect type to pattern
		if (type=="coremicrobiome") return "[filename],[tag],core.microbiome";
		// TODO if nil then 
		return super.getOutputPattern(type);
	}
}
