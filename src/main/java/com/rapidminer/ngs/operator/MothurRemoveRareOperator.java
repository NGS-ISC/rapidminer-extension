package com.rapidminer.ngs.operator;

import java.util.List;
import com.rapidminer.operator.OperatorDescription;
import com.rapidminer.operator.ports.InputPort;
import com.rapidminer.operator.ports.OutputPort;
import com.rapidminer.operator.OperatorException;
import com.rapidminer.parameter.*;

public class MothurRemoveRareOperator extends MothurGeneratedOperator {

	private InputPort countInPort = getInputPorts().createPort("count");
	private InputPort groupInPort = getInputPorts().createPort("group");
	private InputPort listInPort = getInputPorts().createPort("list");
	private InputPort rabundInPort = getInputPorts().createPort("rabund");
	private InputPort sabundInPort = getInputPorts().createPort("sabund");
	private InputPort sharedInPort = getInputPorts().createPort("shared");
	private OutputPort rabundOutPort = getOutputPorts().createPort("rabund");
	private OutputPort sharedOutPort = getOutputPorts().createPort("shared");
	private OutputPort countOutPort = getOutputPorts().createPort("count");
	private OutputPort listOutPort = getOutputPorts().createPort("list");
	private OutputPort sabundOutPort = getOutputPorts().createPort("sabund");
	private OutputPort groupOutPort = getOutputPorts().createPort("group");
	private static final String BYGROUP_LABEL = "bygroup:";
	private static final String GROUPS_LABEL = "groups:";
	private static final String INPUTDIR_LABEL = "inputdir:";
	private static final String LABEL_LABEL = "label:";
	private static final String NSEQS_LABEL = "nseqs:";
	private static final String OUTPUTDIR_LABEL = "outputdir:";
	private static final String SEED_LABEL = "seed:";

	public MothurRemoveRareOperator (OperatorDescription description) {
		super(description);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void doWork() throws OperatorException {
		super.doWork();
		clearArguments();
		FileNameObject countFile = countInPort.getData(FileNameObject.class);
		addArgument("count",countFile.getName());
		FileNameObject groupFile = groupInPort.getData(FileNameObject.class);
		addArgument("group",groupFile.getName());
		FileNameObject listFile = listInPort.getData(FileNameObject.class);
		addArgument("list",listFile.getName());
		FileNameObject rabundFile = rabundInPort.getData(FileNameObject.class);
		addArgument("rabund",rabundFile.getName());
		FileNameObject sabundFile = sabundInPort.getData(FileNameObject.class);
		addArgument("sabund",sabundFile.getName());
		FileNameObject sharedFile = sharedInPort.getData(FileNameObject.class);
		addArgument("shared",sharedFile.getName());
		boolean bygroupValue = getParameterAsBoolean(BYGROUP_LABEL);
		addArgument("bygroup",String.valueOf(bygroupValue));
		String groupsValue = getParameterAsString(GROUPS_LABEL);
		addArgument("groups",String.valueOf(groupsValue));
		String inputdirValue = getParameterAsString(INPUTDIR_LABEL);
		addArgument("inputdir",String.valueOf(inputdirValue));
		String labelValue = getParameterAsString(LABEL_LABEL);
		addArgument("label",String.valueOf(labelValue));
		int nseqsValue = getParameterAsInt(NSEQS_LABEL);
		addArgument("nseqs",String.valueOf(nseqsValue));
		String outputdirValue = getParameterAsString(OUTPUTDIR_LABEL);
		addArgument("outputdir",String.valueOf(outputdirValue));
		int seedValue = getParameterAsInt(SEED_LABEL);
		addArgument("seed",String.valueOf(seedValue));
		executeMothurCommand();
		String fileName="<fileName>"; // TODO: Somehow figure out the fileName
		rabundOutPort.deliver(new FileNameObject(fileName+".rabund","rabund"));
		sharedOutPort.deliver(new FileNameObject(fileName+".shared","shared"));
		countOutPort.deliver(new FileNameObject(fileName+".count","count"));
		listOutPort.deliver(new FileNameObject(fileName+".list","list"));
		sabundOutPort.deliver(new FileNameObject(fileName+".sabund","sabund"));
		groupOutPort.deliver(new FileNameObject(fileName+".group","group"));
	}

	@Override
	public List<ParameterType> getParameterTypes() {
		List<ParameterType> parameterTypes = super.getParameterTypes();
		parameterTypes.add(new ParameterTypeBoolean(BYGROUP_LABEL, "TODO: Add description", false, true));
		parameterTypes.add(new ParameterTypeString(GROUPS_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeString(INPUTDIR_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeString(LABEL_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeInt(NSEQS_LABEL, "TODO: Add description", -100000000, 100000000, 0, false));
		parameterTypes.add(new ParameterTypeString(OUTPUTDIR_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeInt(SEED_LABEL, "TODO: Add description", -100000000, 100000000, 0, true));
		return parameterTypes;
	}

	@Override
	public String getOutputPattern(String type) {
		// TODO Use a dictionary to reflect type to pattern
		if (type=="rabund") return "[filename],pick,[extension]";
		if (type=="shared") return "[filename],[tag],pick,[extension]";
		if (type=="count") return "[filename],pick,[extension]";
		if (type=="list") return "[filename],[tag],pick,[extension]";
		if (type=="sabund") return "[filename],pick,[extension]";
		if (type=="group") return "[filename],pick,[extension]";
		// TODO if nil then 
		return super.getOutputPattern(type);
	}
}
