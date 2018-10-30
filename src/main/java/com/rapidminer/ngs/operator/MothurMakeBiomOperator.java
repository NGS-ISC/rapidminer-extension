package com.rapidminer.ngs.operator;

import java.util.List;
import com.rapidminer.operator.OperatorDescription;
import com.rapidminer.operator.ports.InputPort;
import com.rapidminer.operator.ports.OutputPort;
import com.rapidminer.operator.OperatorException;
import com.rapidminer.parameter.*;

public class MothurMakeBiomOperator extends MothurGeneratedOperator {

	private InputPort constaxonomyInPort = getInputPorts().createPort("constaxonomy");
	private InputPort metadataInPort = getInputPorts().createPort("metadata");
	private InputPort picrustInPort = getInputPorts().createPort("picrust");
	private InputPort reftaxonomyInPort = getInputPorts().createPort("reftaxonomy");
	private InputPort relabundInPort = getInputPorts().createPort("relabund");
	private InputPort sharedInPort = getInputPorts().createPort("shared");
	private OutputPort sharedOutPort = getOutputPorts().createPort("shared");
	private OutputPort relabundOutPort = getOutputPorts().createPort("relabund");
	private OutputPort biomOutPort = getOutputPorts().createPort("biom");
	private static final String GROUPS_LABEL = "groups:";
	private static final String INPUTDIR_LABEL = "inputdir:";
	private static final String LABEL_LABEL = "label:";
	public static final String[] MATRIXTYPE_CHOICES = { "dense", "sparse" };
	public static final int MATRIXTYPE_DEFAULT_CHOICE = 1;
	private static final String MATRIXTYPE_LABEL = "matrixtype:";
	private static final String OUTPUTDIR_LABEL = "outputdir:";
	private static final String SEED_LABEL = "seed:";

	public MothurMakeBiomOperator (OperatorDescription description) {
		super(description);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void doWork() throws OperatorException {
		super.doWork();
		clearArguments();
		FileNameObject constaxonomyFile = constaxonomyInPort.getData(FileNameObject.class);
		addArgument("constaxonomy",constaxonomyFile.getName());
		FileNameObject metadataFile = metadataInPort.getData(FileNameObject.class);
		addArgument("metadata",metadataFile.getName());
		FileNameObject picrustFile = picrustInPort.getData(FileNameObject.class);
		addArgument("picrust",picrustFile.getName());
		FileNameObject reftaxonomyFile = reftaxonomyInPort.getData(FileNameObject.class);
		addArgument("reftaxonomy",reftaxonomyFile.getName());
		FileNameObject relabundFile = relabundInPort.getData(FileNameObject.class);
		addArgument("relabund",relabundFile.getName());
		FileNameObject sharedFile = sharedInPort.getData(FileNameObject.class);
		addArgument("shared",sharedFile.getName());
		String groupsValue = getParameterAsString(GROUPS_LABEL);
		addArgument("groups",String.valueOf(groupsValue));
		String inputdirValue = getParameterAsString(INPUTDIR_LABEL);
		addArgument("inputdir",String.valueOf(inputdirValue));
		String labelValue = getParameterAsString(LABEL_LABEL);
		addArgument("label",String.valueOf(labelValue));
		int matrixtypeIndex = getParameterAsInt(MATRIXTYPE_LABEL);
		String matrixtypeValue = MATRIXTYPE_CHOICES[matrixtypeIndex];
		addArgument("matrixtype",String.valueOf(matrixtypeValue));
		String outputdirValue = getParameterAsString(OUTPUTDIR_LABEL);
		addArgument("outputdir",String.valueOf(outputdirValue));
		int seedValue = getParameterAsInt(SEED_LABEL);
		addArgument("seed",String.valueOf(seedValue));
		executeMothurCommand();
		String fileName="<fileName>"; // TODO: Somehow figure out the fileName
		sharedOutPort.deliver(new FileNameObject(fileName+".shared","shared"));
		relabundOutPort.deliver(new FileNameObject(fileName+".relabund","relabund"));
		biomOutPort.deliver(new FileNameObject(fileName+".biom","biom"));
	}

	@Override
	public List<ParameterType> getParameterTypes() {
		List<ParameterType> parameterTypes = super.getParameterTypes();
		parameterTypes.add(new ParameterTypeString(GROUPS_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeString(INPUTDIR_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeString(LABEL_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeCategory(MATRIXTYPE_LABEL, "TODO: Add description", MATRIXTYPE_CHOICES, MATRIXTYPE_DEFAULT_CHOICE));
		parameterTypes.add(new ParameterTypeString(OUTPUTDIR_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeInt(SEED_LABEL, "TODO: Add description", -100000000, 100000000, 0, true));
		return parameterTypes;
	}

	@Override
	public String getOutputPattern(String type) {
		// TODO Use a dictionary to reflect type to pattern
		if (type=="shared") return "[filename],[distance],biom_shared";
		if (type=="relabund") return "[filename],[distance],biom_relabund";
		if (type=="biom") return "[filename],[distance],biom";
		// TODO if nil then 
		return super.getOutputPattern(type);
	}
}
