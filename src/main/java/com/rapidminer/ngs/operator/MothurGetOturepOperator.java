package com.rapidminer.ngs.operator;

import java.util.List;
import com.rapidminer.operator.OperatorDescription;
import com.rapidminer.operator.ports.InputPort;
import com.rapidminer.operator.ports.OutputPort;
import com.rapidminer.operator.OperatorException;
import com.rapidminer.parameter.*;

public class MothurGetOturepOperator extends MothurGeneratedOperator {

	private InputPort columnInPort = getInputPorts().createPort("column");
	private InputPort countInPort = getInputPorts().createPort("count");
	private InputPort fastaInPort = getInputPorts().createPort("fasta");
	private InputPort groupInPort = getInputPorts().createPort("group");
	private InputPort listInPort = getInputPorts().createPort("list");
	private InputPort nameInPort = getInputPorts().createPort("name");
	private InputPort phylipInPort = getInputPorts().createPort("phylip");
	private OutputPort nameOutPort = getOutputPorts().createPort("name");
	private OutputPort fastaOutPort = getOutputPorts().createPort("fasta");
	private OutputPort countOutPort = getOutputPorts().createPort("count");
	private static final String CUTOFF_LABEL = "cutoff:";
	private static final String GROUPS_LABEL = "groups:";
	private static final String INPUTDIR_LABEL = "inputdir:";
	private static final String LABEL_LABEL = "label:";
	private static final String LARGE_LABEL = "large:";
	public static final String[] METHOD_CHOICES = { "abundance", "distance" };
	public static final int METHOD_DEFAULT_CHOICE = 1;
	private static final String METHOD_LABEL = "method:";
	private static final String OUTPUTDIR_LABEL = "outputdir:";
	private static final String PRECISION_LABEL = "precision:";
	private static final String SEED_LABEL = "seed:";
	private static final String WEIGHTED_LABEL = "weighted:";

	public MothurGetOturepOperator (OperatorDescription description) {
		super(description);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void doWork() throws OperatorException {
		super.doWork();
		clearArguments();
		FileNameObject columnFile = columnInPort.getData(FileNameObject.class);
		addArgument("column",columnFile.getName());
		FileNameObject countFile = countInPort.getData(FileNameObject.class);
		addArgument("count",countFile.getName());
		FileNameObject fastaFile = fastaInPort.getData(FileNameObject.class);
		addArgument("fasta",fastaFile.getName());
		FileNameObject groupFile = groupInPort.getData(FileNameObject.class);
		addArgument("group",groupFile.getName());
		FileNameObject listFile = listInPort.getData(FileNameObject.class);
		addArgument("list",listFile.getName());
		FileNameObject nameFile = nameInPort.getData(FileNameObject.class);
		addArgument("name",nameFile.getName());
		FileNameObject phylipFile = phylipInPort.getData(FileNameObject.class);
		addArgument("phylip",phylipFile.getName());
		int cutoffValue = getParameterAsInt(CUTOFF_LABEL);
		addArgument("cutoff",String.valueOf(cutoffValue));
		String groupsValue = getParameterAsString(GROUPS_LABEL);
		addArgument("groups",String.valueOf(groupsValue));
		String inputdirValue = getParameterAsString(INPUTDIR_LABEL);
		addArgument("inputdir",String.valueOf(inputdirValue));
		String labelValue = getParameterAsString(LABEL_LABEL);
		addArgument("label",String.valueOf(labelValue));
		boolean largeValue = getParameterAsBoolean(LARGE_LABEL);
		addArgument("large",String.valueOf(largeValue));
		int methodIndex = getParameterAsInt(METHOD_LABEL);
		String methodValue = METHOD_CHOICES[methodIndex];
		addArgument("method",String.valueOf(methodValue));
		String outputdirValue = getParameterAsString(OUTPUTDIR_LABEL);
		addArgument("outputdir",String.valueOf(outputdirValue));
		int precisionValue = getParameterAsInt(PRECISION_LABEL);
		addArgument("precision",String.valueOf(precisionValue));
		int seedValue = getParameterAsInt(SEED_LABEL);
		addArgument("seed",String.valueOf(seedValue));
		boolean weightedValue = getParameterAsBoolean(WEIGHTED_LABEL);
		addArgument("weighted",String.valueOf(weightedValue));
		executeMothurCommand();
		String fileName="<fileName>"; // TODO: Somehow figure out the fileName
		nameOutPort.deliver(new FileNameObject(fileName+".name","name"));
		fastaOutPort.deliver(new FileNameObject(fileName+".fasta","fasta"));
		countOutPort.deliver(new FileNameObject(fileName+".count","count"));
	}

	@Override
	public List<ParameterType> getParameterTypes() {
		List<ParameterType> parameterTypes = super.getParameterTypes();
		parameterTypes.add(new ParameterTypeInt(CUTOFF_LABEL, "TODO: Add description", -100000000, 100000000, 10, true));
		parameterTypes.add(new ParameterTypeString(GROUPS_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeString(INPUTDIR_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeString(LABEL_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeBoolean(LARGE_LABEL, "TODO: Add description", false, true));
		parameterTypes.add(new ParameterTypeCategory(METHOD_LABEL, "TODO: Add description", METHOD_CHOICES, METHOD_DEFAULT_CHOICE));
		parameterTypes.add(new ParameterTypeString(OUTPUTDIR_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeInt(PRECISION_LABEL, "TODO: Add description", -100000000, 100000000, 100, true));
		parameterTypes.add(new ParameterTypeInt(SEED_LABEL, "TODO: Add description", -100000000, 100000000, 0, true));
		parameterTypes.add(new ParameterTypeBoolean(WEIGHTED_LABEL, "TODO: Add description", false, true));
		return parameterTypes;
	}

	@Override
	public String getOutputPattern(String type) {
		// TODO Use a dictionary to reflect type to pattern
		if (type=="name") return "[filename],[tag],rep.names-[filename],[tag],[group],rep.names";
		if (type=="fasta") return "[filename],[tag],rep.fasta-[filename],[tag],[group],rep.fasta";
		if (type=="count") return "[filename],[tag],rep.count_table-[filename],[tag],[group],rep.count_table";
		// TODO if nil then 
		return super.getOutputPattern(type);
	}
}
