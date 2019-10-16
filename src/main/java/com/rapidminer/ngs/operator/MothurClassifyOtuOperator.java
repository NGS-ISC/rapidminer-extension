package com.rapidminer.ngs.operator;

import java.util.List;
import com.rapidminer.operator.OperatorDescription;
import com.rapidminer.operator.ports.InputPort;
import com.rapidminer.operator.ports.OutputPort;
import com.rapidminer.operator.OperatorException;
import com.rapidminer.parameter.*;

public class MothurClassifyOtuOperator extends MothurGeneratedOperator {

	private InputPort listInPort = getInputPorts().createPort("list");
	private InputPort taxonomyInPort = getInputPorts().createPort("taxonomy");
	private InputPort nameInPort = getInputPorts().createPort("name");
	private InputPort countInPort = getInputPorts().createPort("count");
	private InputPort groupInPort = getInputPorts().createPort("group");
	private OutputPort constaxonomyOutPort = getOutputPorts().createPort("constaxonomy");
	private OutputPort taxsummaryOutPort = getOutputPorts().createPort("taxsummary");
	private static final String[] OUTPUT_CHOICES = { "plain", "detail" };
	private static final int OUTPUT_DEFAULT_CHOICE = 1;
	private static final String OUTPUT_LABEL = "output:";
	private static final String RELABUND_LABEL = "relabund:";
	private static final String PRINTLEVEL_LABEL = "printlevel:";
	private static final String PERSAMPLE_LABEL = "persample:";
	private static final String LABEL_LABEL = "label:";
	private static final String[] BASIS_CHOICES = { "otu", "sequence" };
	private static final int BASIS_DEFAULT_CHOICE = 0;
	private static final String BASIS_LABEL = "basis:";
	private static final String CUTOFF_LABEL = "cutoff:";
	private static final String THRESHOLD_LABEL = "threshold:";
	private static final String PROBS_LABEL = "probs:";
	private static final String SEED_LABEL = "seed:";
	private static final String INPUTDIR_LABEL = "inputdir:";
	private static final String OUTPUTDIR_LABEL = "outputdir:";

	public MothurClassifyOtuOperator (OperatorDescription description) {
		super(description);
		// NOTE: Auto-generated constructor stub
	}

	@Override
	public void doWork() throws OperatorException {
		super.doWork();
		clearArguments();
		FileNameObject listFile = listInPort.getData(FileNameObject.class);
		addArgument("list",listFile.getName());
		FileNameObject taxonomyFile = taxonomyInPort.getData(FileNameObject.class);
		addArgument("taxonomy",taxonomyFile.getName());
		FileNameObject nameFile = nameInPort.getData(FileNameObject.class);
		addArgument("name",nameFile.getName());
		FileNameObject countFile = countInPort.getData(FileNameObject.class);
		addArgument("count",countFile.getName());
		FileNameObject groupFile = groupInPort.getData(FileNameObject.class);
		addArgument("group",groupFile.getName());
		int outputIndex = getParameterAsInt(OUTPUT_LABEL);
		String outputValue = OUTPUT_CHOICES[outputIndex];
		addArgument("output",String.valueOf(outputValue));
		boolean relabundValue = getParameterAsBoolean(RELABUND_LABEL);
		addArgument("relabund",String.valueOf(relabundValue));
		int printlevelValue = getParameterAsInt(PRINTLEVEL_LABEL);
		addArgument("printlevel",String.valueOf(printlevelValue));
		boolean persampleValue = getParameterAsBoolean(PERSAMPLE_LABEL);
		addArgument("persample",String.valueOf(persampleValue));
		String labelValue = getParameterAsString(LABEL_LABEL);
		addArgument("label",String.valueOf(labelValue));
		int basisIndex = getParameterAsInt(BASIS_LABEL);
		String basisValue = BASIS_CHOICES[basisIndex];
		addArgument("basis",String.valueOf(basisValue));
		int cutoffValue = getParameterAsInt(CUTOFF_LABEL);
		addArgument("cutoff",String.valueOf(cutoffValue));
		int thresholdValue = getParameterAsInt(THRESHOLD_LABEL);
		addArgument("threshold",String.valueOf(thresholdValue));
		boolean probsValue = getParameterAsBoolean(PROBS_LABEL);
		addArgument("probs",String.valueOf(probsValue));
		int seedValue = getParameterAsInt(SEED_LABEL);
		addArgument("seed",String.valueOf(seedValue));
		String inputdirValue = getParameterAsString(INPUTDIR_LABEL);
		addArgument("inputdir",String.valueOf(inputdirValue));
		String outputdirValue = getParameterAsString(OUTPUTDIR_LABEL);
		addArgument("outputdir",String.valueOf(outputdirValue));
		executeMothurCommand();
		String fileName="<fileName>"; // TODO: Somehow figure out the fileName
		constaxonomyOutPort.deliver(new FileNameObject(fileName+".constaxonomy","constaxonomy"));
		taxsummaryOutPort.deliver(new FileNameObject(fileName+".taxsummary","taxsummary"));
	}

	@Override
	public List<ParameterType> getParameterTypes() {
		List<ParameterType> parameterTypes = super.getParameterTypes();
		parameterTypes.add(new ParameterTypeCategory(OUTPUT_LABEL, "TODO: Add description", OUTPUT_CHOICES, OUTPUT_DEFAULT_CHOICE));
		parameterTypes.add(new ParameterTypeBoolean(RELABUND_LABEL, "TODO: Add description", false, true));
		parameterTypes.add(new ParameterTypeInt(PRINTLEVEL_LABEL, "TODO: Add description", -100000000, 100000000, -1, true));
		parameterTypes.add(new ParameterTypeBoolean(PERSAMPLE_LABEL, "TODO: Add description", false, true));
		parameterTypes.add(new ParameterTypeString(LABEL_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeCategory(BASIS_LABEL, "TODO: Add description", BASIS_CHOICES, BASIS_DEFAULT_CHOICE));
		parameterTypes.add(new ParameterTypeInt(CUTOFF_LABEL, "TODO: Add description", -100000000, 100000000, 51, false));
		parameterTypes.add(new ParameterTypeInt(THRESHOLD_LABEL, "TODO: Add description", -100000000, 100000000, 0, false));
		parameterTypes.add(new ParameterTypeBoolean(PROBS_LABEL, "TODO: Add description", true, true));
		parameterTypes.add(new ParameterTypeInt(SEED_LABEL, "TODO: Add description", -100000000, 100000000, 0, true));
		parameterTypes.add(new ParameterTypeString(INPUTDIR_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeString(OUTPUTDIR_LABEL, "TODO: Add description", "", true));
		return parameterTypes;
	}

	@Override
	public String getOutputPattern(String type) {
		if (type.equals("taxsummary")) return "[filename],[distance],cons.tax.summary";
		if (type.equals("constaxonomy")) return "[filename],[distance],cons.taxonomy";
		return super.getOutputPattern(type);
	}
}
