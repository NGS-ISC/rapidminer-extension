package com.rapidminer.ngs.operator;

import java.util.List;
import com.rapidminer.operator.OperatorDescription;
import com.rapidminer.operator.ports.InputPort;
import com.rapidminer.operator.ports.OutputPort;
import com.rapidminer.operator.OperatorException;
import com.rapidminer.parameter.*;

public class MothurBiomInfoOperator extends MothurGeneratedOperator {

	private InputPort biomInPort = getInputPorts().createPort("biom");
	private OutputPort taxonomyOutPort = getOutputPorts().createPort("taxonomy");
	private OutputPort taxsummaryOutPort = getOutputPorts().createPort("taxsummary");
	private OutputPort sharedOutPort = getOutputPorts().createPort("shared");
	private OutputPort constaxonomyOutPort = getOutputPorts().createPort("constaxonomy");
	private static final String LABEL_LABEL = "label:";
	private static final String RELABUND_LABEL = "relabund:";
	private static final String[] BASIS_CHOICES = { "otu", "sequence" };
	private static final int BASIS_DEFAULT_CHOICE = 0;
	private static final String BASIS_LABEL = "basis:";
	private static final String SEED_LABEL = "seed:";
	private static final String[] OUTPUT_CHOICES = { "simple", "detail" };
	private static final int OUTPUT_DEFAULT_CHOICE = 1;
	private static final String OUTPUT_LABEL = "output:";
	private static final String PRINTLEVEL_LABEL = "printlevel:";
	private static final String INPUTDIR_LABEL = "inputdir:";
	private static final String OUTPUTDIR_LABEL = "outputdir:";

	public MothurBiomInfoOperator (OperatorDescription description) {
		super(description);
		// NOTE: Auto-generated constructor stub
	}

	@Override
	public void doWork() throws OperatorException {
		super.doWork();
		clearArguments();
		FileNameObject biomFile = biomInPort.getData(FileNameObject.class);
		addArgument("biom",biomFile.getName());
		String labelValue = getParameterAsString(LABEL_LABEL);
		addArgument("label",String.valueOf(labelValue));
		boolean relabundValue = getParameterAsBoolean(RELABUND_LABEL);
		addArgument("relabund",String.valueOf(relabundValue));
		int basisIndex = getParameterAsInt(BASIS_LABEL);
		String basisValue = BASIS_CHOICES[basisIndex];
		addArgument("basis",String.valueOf(basisValue));
		int seedValue = getParameterAsInt(SEED_LABEL);
		addArgument("seed",String.valueOf(seedValue));
		int outputIndex = getParameterAsInt(OUTPUT_LABEL);
		String outputValue = OUTPUT_CHOICES[outputIndex];
		addArgument("output",String.valueOf(outputValue));
		int printlevelValue = getParameterAsInt(PRINTLEVEL_LABEL);
		addArgument("printlevel",String.valueOf(printlevelValue));
		String inputdirValue = getParameterAsString(INPUTDIR_LABEL);
		addArgument("inputdir",String.valueOf(inputdirValue));
		String outputdirValue = getParameterAsString(OUTPUTDIR_LABEL);
		addArgument("outputdir",String.valueOf(outputdirValue));
		executeMothurCommand();
		String fileName="<fileName>"; // TODO: Somehow figure out the fileName
		taxonomyOutPort.deliver(new FileNameObject(fileName+".taxonomy","taxonomy"));
		taxsummaryOutPort.deliver(new FileNameObject(fileName+".taxsummary","taxsummary"));
		sharedOutPort.deliver(new FileNameObject(fileName+".shared","shared"));
		constaxonomyOutPort.deliver(new FileNameObject(fileName+".constaxonomy","constaxonomy"));
	}

	@Override
	public List<ParameterType> getParameterTypes() {
		List<ParameterType> parameterTypes = super.getParameterTypes();
		parameterTypes.add(new ParameterTypeString(LABEL_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeBoolean(RELABUND_LABEL, "TODO: Add description", false, true));
		parameterTypes.add(new ParameterTypeCategory(BASIS_LABEL, "TODO: Add description", BASIS_CHOICES, BASIS_DEFAULT_CHOICE));
		parameterTypes.add(new ParameterTypeInt(SEED_LABEL, "TODO: Add description", -100000000, 100000000, 0, true));
		parameterTypes.add(new ParameterTypeCategory(OUTPUT_LABEL, "TODO: Add description", OUTPUT_CHOICES, OUTPUT_DEFAULT_CHOICE));
		parameterTypes.add(new ParameterTypeInt(PRINTLEVEL_LABEL, "TODO: Add description", -100000000, 100000000, -1, true));
		parameterTypes.add(new ParameterTypeString(INPUTDIR_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeString(OUTPUTDIR_LABEL, "TODO: Add description", "", true));
		return parameterTypes;
	}

	@Override
	public String getOutputPattern(String type) {
		if (type.equals("taxonomy")) return "[filename],[tag],taxonomy";
		if (type.equals("taxsummary")) return "[filename],[tag],[tag2],tax.summary";
		if (type.equals("shared")) return "[filename],[tag],shared";
		if (type.equals("constaxonomy")) return "[filename],[tag],cons.taxonomy";
		return super.getOutputPattern(type);
	}
}
