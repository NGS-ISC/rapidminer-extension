package com.rapidminer.ngs.operator;

import java.util.List;
import com.rapidminer.operator.OperatorDescription;
import com.rapidminer.operator.ports.InputPort;
import com.rapidminer.operator.ports.OutputPort;
import com.rapidminer.operator.OperatorException;
import com.rapidminer.parameter.*;

public class MothurSubSampleOperator extends MothurGeneratedOperator {

	private InputPort fastaInPort = getInputPorts().createPort("fasta");
	private InputPort nameInPort = getInputPorts().createPort("name");
	private InputPort taxonomyInPort = getInputPorts().createPort("taxonomy");
	private InputPort countInPort = getInputPorts().createPort("count");
	private InputPort groupInPort = getInputPorts().createPort("group");
	private InputPort listInPort = getInputPorts().createPort("list");
	private InputPort sharedInPort = getInputPorts().createPort("shared");
	private InputPort rabundInPort = getInputPorts().createPort("rabund");
	private InputPort sabundInPort = getInputPorts().createPort("sabund");
	private OutputPort sabundOutPort = getOutputPorts().createPort("sabund");
	private OutputPort countOutPort = getOutputPorts().createPort("count");
	private OutputPort groupOutPort = getOutputPorts().createPort("group");
	private OutputPort sharedOutPort = getOutputPorts().createPort("shared");
	private OutputPort taxonomyOutPort = getOutputPorts().createPort("taxonomy");
	private OutputPort rabundOutPort = getOutputPorts().createPort("rabund");
	private OutputPort nameOutPort = getOutputPorts().createPort("name");
	private OutputPort listOutPort = getOutputPorts().createPort("list");
	private OutputPort fastaOutPort = getOutputPorts().createPort("fasta");
	private static final String LABEL_LABEL = "label:";
	private static final String GROUPS_LABEL = "groups:";
	private static final String SIZE_LABEL = "size:";
	private static final String PERSAMPLE_LABEL = "persample:";
	private static final String SEED_LABEL = "seed:";
	private static final String INPUTDIR_LABEL = "inputdir:";
	private static final String OUTPUTDIR_LABEL = "outputdir:";

	public MothurSubSampleOperator (OperatorDescription description) {
		super(description);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void doWork() throws OperatorException {
		super.doWork();
		clearArguments();
		FileNameObject fastaFile = fastaInPort.getData(FileNameObject.class);
		addArgument("fasta",fastaFile.getName());
		FileNameObject nameFile = nameInPort.getData(FileNameObject.class);
		addArgument("name",nameFile.getName());
		FileNameObject taxonomyFile = taxonomyInPort.getData(FileNameObject.class);
		addArgument("taxonomy",taxonomyFile.getName());
		FileNameObject countFile = countInPort.getData(FileNameObject.class);
		addArgument("count",countFile.getName());
		FileNameObject groupFile = groupInPort.getData(FileNameObject.class);
		addArgument("group",groupFile.getName());
		FileNameObject listFile = listInPort.getData(FileNameObject.class);
		addArgument("list",listFile.getName());
		FileNameObject sharedFile = sharedInPort.getData(FileNameObject.class);
		addArgument("shared",sharedFile.getName());
		FileNameObject rabundFile = rabundInPort.getData(FileNameObject.class);
		addArgument("rabund",rabundFile.getName());
		FileNameObject sabundFile = sabundInPort.getData(FileNameObject.class);
		addArgument("sabund",sabundFile.getName());
		String labelValue = getParameterAsString(LABEL_LABEL);
		addArgument("label",String.valueOf(labelValue));
		String groupsValue = getParameterAsString(GROUPS_LABEL);
		addArgument("groups",String.valueOf(groupsValue));
		int sizeValue = getParameterAsInt(SIZE_LABEL);
		addArgument("size",String.valueOf(sizeValue));
		boolean persampleValue = getParameterAsBoolean(PERSAMPLE_LABEL);
		addArgument("persample",String.valueOf(persampleValue));
		int seedValue = getParameterAsInt(SEED_LABEL);
		addArgument("seed",String.valueOf(seedValue));
		String inputdirValue = getParameterAsString(INPUTDIR_LABEL);
		addArgument("inputdir",String.valueOf(inputdirValue));
		String outputdirValue = getParameterAsString(OUTPUTDIR_LABEL);
		addArgument("outputdir",String.valueOf(outputdirValue));
		executeMothurCommand();
		String fileName="<fileName>"; // TODO: Somehow figure out the fileName
		sabundOutPort.deliver(new FileNameObject(fileName+".sabund","sabund"));
		countOutPort.deliver(new FileNameObject(fileName+".count","count"));
		groupOutPort.deliver(new FileNameObject(fileName+".group","group"));
		sharedOutPort.deliver(new FileNameObject(fileName+".shared","shared"));
		taxonomyOutPort.deliver(new FileNameObject(fileName+".taxonomy","taxonomy"));
		rabundOutPort.deliver(new FileNameObject(fileName+".rabund","rabund"));
		nameOutPort.deliver(new FileNameObject(fileName+".name","name"));
		listOutPort.deliver(new FileNameObject(fileName+".list","list"));
		fastaOutPort.deliver(new FileNameObject(fileName+".fasta","fasta"));
	}

	@Override
	public List<ParameterType> getParameterTypes() {
		List<ParameterType> parameterTypes = super.getParameterTypes();
		parameterTypes.add(new ParameterTypeString(LABEL_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeString(GROUPS_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeInt(SIZE_LABEL, "TODO: Add description", -100000000, 100000000, 0, true));
		parameterTypes.add(new ParameterTypeBoolean(PERSAMPLE_LABEL, "TODO: Add description", false, true));
		parameterTypes.add(new ParameterTypeInt(SEED_LABEL, "TODO: Add description", -100000000, 100000000, 0, true));
		parameterTypes.add(new ParameterTypeString(INPUTDIR_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeString(OUTPUTDIR_LABEL, "TODO: Add description", "", true));
		return parameterTypes;
	}

	@Override
	public String getOutputPattern(String type) {
		// TODO Use a dictionary to reflect type to pattern
		if (type.equals("sabund")) return "[filename],subsample,[extension]";
		if (type.equals("count")) return "[filename],subsample,[extension]";
		if (type.equals("group")) return "[filename],subsample,[extension]";
		if (type.equals("shared")) return "[filename],[distance],subsample,[extension]";
		if (type.equals("taxonomy")) return "[filename],subsample,[extension]";
		if (type.equals("rabund")) return "[filename],subsample,[extension]";
		if (type.equals("name")) return "[filename],subsample,[extension]";
		if (type.equals("list")) return "[filename],[distance],subsample,[extension]";
		if (type.equals("fasta")) return "[filename],subsample,[extension]";
		// TODO if nil then 
		return super.getOutputPattern(type);
	}
}
