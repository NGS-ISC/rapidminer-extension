package com.rapidminer.ngs.operator;

import java.util.List;
import com.rapidminer.operator.OperatorDescription;
import com.rapidminer.operator.ports.InputPort;
import com.rapidminer.operator.ports.OutputPort;
import com.rapidminer.operator.OperatorException;
import com.rapidminer.parameter.*;

public class MothurRemoveGroupsOperator extends MothurGeneratedOperator {

	private InputPort fastaInPort = getInputPorts().createPort("fasta");
	private InputPort sharedInPort = getInputPorts().createPort("shared");
	private InputPort nameInPort = getInputPorts().createPort("name");
	private InputPort phylipInPort = getInputPorts().createPort("phylip");
	private InputPort columnInPort = getInputPorts().createPort("column");
	private InputPort countInPort = getInputPorts().createPort("count");
	private InputPort groupInPort = getInputPorts().createPort("group");
	private InputPort designInPort = getInputPorts().createPort("design");
	private InputPort listInPort = getInputPorts().createPort("list");
	private InputPort taxonomyInPort = getInputPorts().createPort("taxonomy");
	private InputPort accnosInPort = getInputPorts().createPort("accnos");
	private OutputPort fastaOutPort = getOutputPorts().createPort("fasta");
	private OutputPort phylipOutPort = getOutputPorts().createPort("phylip");
	private OutputPort nameOutPort = getOutputPorts().createPort("name");
	private OutputPort countOutPort = getOutputPorts().createPort("count");
	private OutputPort taxonomyOutPort = getOutputPorts().createPort("taxonomy");
	private OutputPort listOutPort = getOutputPorts().createPort("list");
	private OutputPort designOutPort = getOutputPorts().createPort("design");
	private OutputPort sharedOutPort = getOutputPorts().createPort("shared");
	private OutputPort groupOutPort = getOutputPorts().createPort("group");
	private OutputPort columnOutPort = getOutputPorts().createPort("column");
	private static final String GROUPS_LABEL = "groups:";
	private static final String SEED_LABEL = "seed:";
	private static final String INPUTDIR_LABEL = "inputdir:";
	private static final String OUTPUTDIR_LABEL = "outputdir:";

	public MothurRemoveGroupsOperator (OperatorDescription description) {
		super(description);
		// NOTE: Auto-generated constructor stub
	}

	@Override
	public void doWork() throws OperatorException {
		super.doWork();
		clearArguments();
		FileNameObject fastaFile = fastaInPort.getData(FileNameObject.class);
		addArgument("fasta",fastaFile.getName());
		FileNameObject sharedFile = sharedInPort.getData(FileNameObject.class);
		addArgument("shared",sharedFile.getName());
		FileNameObject nameFile = nameInPort.getData(FileNameObject.class);
		addArgument("name",nameFile.getName());
		FileNameObject phylipFile = phylipInPort.getData(FileNameObject.class);
		addArgument("phylip",phylipFile.getName());
		FileNameObject columnFile = columnInPort.getData(FileNameObject.class);
		addArgument("column",columnFile.getName());
		FileNameObject countFile = countInPort.getData(FileNameObject.class);
		addArgument("count",countFile.getName());
		FileNameObject groupFile = groupInPort.getData(FileNameObject.class);
		addArgument("group",groupFile.getName());
		FileNameObject designFile = designInPort.getData(FileNameObject.class);
		addArgument("design",designFile.getName());
		FileNameObject listFile = listInPort.getData(FileNameObject.class);
		addArgument("list",listFile.getName());
		FileNameObject taxonomyFile = taxonomyInPort.getData(FileNameObject.class);
		addArgument("taxonomy",taxonomyFile.getName());
		FileNameObject accnosFile = accnosInPort.getData(FileNameObject.class);
		addArgument("accnos",accnosFile.getName());
		String groupsValue = getParameterAsString(GROUPS_LABEL);
		addArgument("groups",String.valueOf(groupsValue));
		int seedValue = getParameterAsInt(SEED_LABEL);
		addArgument("seed",String.valueOf(seedValue));
		String inputdirValue = getParameterAsString(INPUTDIR_LABEL);
		addArgument("inputdir",String.valueOf(inputdirValue));
		String outputdirValue = getParameterAsString(OUTPUTDIR_LABEL);
		addArgument("outputdir",String.valueOf(outputdirValue));
		executeMothurCommand();
		String fileName="<fileName>"; // TODO: Somehow figure out the fileName
		fastaOutPort.deliver(new FileNameObject(fileName+".fasta","fasta"));
		phylipOutPort.deliver(new FileNameObject(fileName+".phylip","phylip"));
		nameOutPort.deliver(new FileNameObject(fileName+".name","name"));
		countOutPort.deliver(new FileNameObject(fileName+".count","count"));
		taxonomyOutPort.deliver(new FileNameObject(fileName+".taxonomy","taxonomy"));
		listOutPort.deliver(new FileNameObject(fileName+".list","list"));
		designOutPort.deliver(new FileNameObject(fileName+".design","design"));
		sharedOutPort.deliver(new FileNameObject(fileName+".shared","shared"));
		groupOutPort.deliver(new FileNameObject(fileName+".group","group"));
		columnOutPort.deliver(new FileNameObject(fileName+".column","column"));
	}

	@Override
	public List<ParameterType> getParameterTypes() {
		List<ParameterType> parameterTypes = super.getParameterTypes();
		parameterTypes.add(new ParameterTypeString(GROUPS_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeInt(SEED_LABEL, "TODO: Add description", -100000000, 100000000, 0, true));
		parameterTypes.add(new ParameterTypeString(INPUTDIR_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeString(OUTPUTDIR_LABEL, "TODO: Add description", "", true));
		return parameterTypes;
	}

	@Override
	public String getOutputPattern(String type) {
		if (type.equals("fasta")) return "[filename],pick,[extension]";
		if (type.equals("phylip")) return "[filename],pick,[extension]";
		if (type.equals("name")) return "[filename],pick,[extension]";
		if (type.equals("count")) return "[filename],pick,[extension]";
		if (type.equals("taxonomy")) return "[filename],pick,[extension]";
		if (type.equals("list")) return "[filename],[tag],pick,[extension]";
		if (type.equals("design")) return "[filename],[tag],pick,[extension]-[filename],pick,[extension]";
		if (type.equals("shared")) return "[filename],[tag],pick,[extension]";
		if (type.equals("group")) return "[filename],pick,[extension]";
		if (type.equals("column")) return "[filename],pick,[extension]";
		return super.getOutputPattern(type);
	}
}
