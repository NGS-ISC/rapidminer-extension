package com.rapidminer.ngs.operator;

import java.util.List;
import com.rapidminer.operator.OperatorDescription;
import com.rapidminer.operator.ports.InputPort;
import com.rapidminer.operator.ports.OutputPort;
import com.rapidminer.operator.OperatorException;
import com.rapidminer.parameter.*;

public class MothurGetOturepOperator extends MothurGeneratedOperator {

	private InputPort listInPort = getInputPorts().createPort("list");
	private InputPort fastaInPort = getInputPorts().createPort("fasta");
	private InputPort phylipInPort = getInputPorts().createPort("phylip");
	private InputPort nameInPort = getInputPorts().createPort("name");
	private InputPort countInPort = getInputPorts().createPort("count");
	private InputPort groupInPort = getInputPorts().createPort("group");
	private InputPort columnInPort = getInputPorts().createPort("column");
	private OutputPort countOutPort = getOutputPorts().createPort("count");
	private OutputPort nameOutPort = getOutputPorts().createPort("name");
	private OutputPort fastaOutPort = getOutputPorts().createPort("fasta");
	private static final String LABEL_LABEL = "label:";
	private static final String GROUPS_LABEL = "groups:";
	private static final String CUTOFF_LABEL = "cutoff:";
	private static final String PRECISION_LABEL = "precision:";
	private static final String WEIGHTED_LABEL = "weighted:";
	private static final String[] METHOD_CHOICES = { "distance", "abundance" };
	private static final int METHOD_DEFAULT_CHOICE = 0;
	private static final String METHOD_LABEL = "method:";
	private static final String LARGE_LABEL = "large:";
	private static final String SEED_LABEL = "seed:";
	private static final String INPUTDIR_LABEL = "inputdir:";
	private static final String OUTPUTDIR_LABEL = "outputdir:";

	public MothurGetOturepOperator (OperatorDescription description) {
		super(description);
		// NOTE: Auto-generated constructor stub
	}

	@Override
	public void doWork() throws OperatorException {
		super.doWork();
		clearArguments();
		FileNameObject listFile = listInPort.getData(FileNameObject.class);
		addArgument("list",listFile.getName());
		FileNameObject fastaFile = fastaInPort.getData(FileNameObject.class);
		addArgument("fasta",fastaFile.getName());
		FileNameObject phylipFile = phylipInPort.getData(FileNameObject.class);
		addArgument("phylip",phylipFile.getName());
		FileNameObject nameFile = nameInPort.getData(FileNameObject.class);
		addArgument("name",nameFile.getName());
		FileNameObject countFile = countInPort.getData(FileNameObject.class);
		addArgument("count",countFile.getName());
		FileNameObject groupFile = groupInPort.getData(FileNameObject.class);
		addArgument("group",groupFile.getName());
		FileNameObject columnFile = columnInPort.getData(FileNameObject.class);
		addArgument("column",columnFile.getName());
		String labelValue = getParameterAsString(LABEL_LABEL);
		addArgument("label",String.valueOf(labelValue));
		String groupsValue = getParameterAsString(GROUPS_LABEL);
		addArgument("groups",String.valueOf(groupsValue));
		int cutoffValue = getParameterAsInt(CUTOFF_LABEL);
		addArgument("cutoff",String.valueOf(cutoffValue));
		int precisionValue = getParameterAsInt(PRECISION_LABEL);
		addArgument("precision",String.valueOf(precisionValue));
		boolean weightedValue = getParameterAsBoolean(WEIGHTED_LABEL);
		addArgument("weighted",String.valueOf(weightedValue));
		int methodIndex = getParameterAsInt(METHOD_LABEL);
		String methodValue = METHOD_CHOICES[methodIndex];
		addArgument("method",String.valueOf(methodValue));
		boolean largeValue = getParameterAsBoolean(LARGE_LABEL);
		addArgument("large",String.valueOf(largeValue));
		int seedValue = getParameterAsInt(SEED_LABEL);
		addArgument("seed",String.valueOf(seedValue));
		String inputdirValue = getParameterAsString(INPUTDIR_LABEL);
		addArgument("inputdir",String.valueOf(inputdirValue));
		String outputdirValue = getParameterAsString(OUTPUTDIR_LABEL);
		addArgument("outputdir",String.valueOf(outputdirValue));
		executeMothurCommand();
		String fileName="<fileName>"; // TODO: Somehow figure out the fileName
		countOutPort.deliver(new FileNameObject(fileName+".count","count"));
		nameOutPort.deliver(new FileNameObject(fileName+".name","name"));
		fastaOutPort.deliver(new FileNameObject(fileName+".fasta","fasta"));
	}

	@Override
	public List<ParameterType> getParameterTypes() {
		List<ParameterType> parameterTypes = super.getParameterTypes();
		parameterTypes.add(new ParameterTypeString(LABEL_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeString(GROUPS_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeInt(CUTOFF_LABEL, "TODO: Add description", -100000000, 100000000, 10, true));
		parameterTypes.add(new ParameterTypeInt(PRECISION_LABEL, "TODO: Add description", -100000000, 100000000, 100, true));
		parameterTypes.add(new ParameterTypeBoolean(WEIGHTED_LABEL, "TODO: Add description", false, true));
		parameterTypes.add(new ParameterTypeCategory(METHOD_LABEL, "TODO: Add description", METHOD_CHOICES, METHOD_DEFAULT_CHOICE));
		parameterTypes.add(new ParameterTypeBoolean(LARGE_LABEL, "TODO: Add description", false, true));
		parameterTypes.add(new ParameterTypeInt(SEED_LABEL, "TODO: Add description", -100000000, 100000000, 0, true));
		parameterTypes.add(new ParameterTypeString(INPUTDIR_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeString(OUTPUTDIR_LABEL, "TODO: Add description", "", true));
		return parameterTypes;
	}

	@Override
	public String getOutputPattern(String type) {
		if (type.equals("count")) return "[filename],[tag],rep.count_table-[filename],[tag],[group],rep.count_table";
		if (type.equals("name")) return "[filename],[tag],rep.names-[filename],[tag],[group],rep.names";
		if (type.equals("fasta")) return "[filename],[tag],rep.fasta-[filename],[tag],[group],rep.fasta";
		return super.getOutputPattern(type);
	}
}
