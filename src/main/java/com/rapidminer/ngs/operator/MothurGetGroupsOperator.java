package com.rapidminer.ngs.operator;

import java.util.List;
import com.rapidminer.operator.OperatorDescription;
import com.rapidminer.operator.ports.InputPort;
import com.rapidminer.operator.ports.OutputPort;
import com.rapidminer.operator.OperatorException;
import com.rapidminer.parameter.*;

public class MothurGetGroupsOperator extends MothurGeneratedOperator {

	private InputPort accnosInPort = getInputPorts().createPort("accnos");
	private InputPort columnInPort = getInputPorts().createPort("column");
	private InputPort countInPort = getInputPorts().createPort("count");
	private InputPort designInPort = getInputPorts().createPort("design");
	private InputPort fastaInPort = getInputPorts().createPort("fasta");
	private InputPort groupInPort = getInputPorts().createPort("group");
	private InputPort listInPort = getInputPorts().createPort("list");
	private InputPort nameInPort = getInputPorts().createPort("name");
	private InputPort phylipInPort = getInputPorts().createPort("phylip");
	private InputPort sharedInPort = getInputPorts().createPort("shared");
	private InputPort taxonomyInPort = getInputPorts().createPort("taxonomy");
	private OutputPort taxonomyOutPort = getOutputPorts().createPort("taxonomy");
	private OutputPort designOutPort = getOutputPorts().createPort("design");
	private OutputPort nameOutPort = getOutputPorts().createPort("name");
	private OutputPort phylipOutPort = getOutputPorts().createPort("phylip");
	private OutputPort groupOutPort = getOutputPorts().createPort("group");
	private OutputPort fastaOutPort = getOutputPorts().createPort("fasta");
	private OutputPort sharedOutPort = getOutputPorts().createPort("shared");
	private OutputPort countOutPort = getOutputPorts().createPort("count");
	private OutputPort columnOutPort = getOutputPorts().createPort("column");
	private OutputPort listOutPort = getOutputPorts().createPort("list");
	private static final String GROUPS_LABEL = "groups:";
	private static final String INPUTDIR_LABEL = "inputdir:";
	private static final String OUTPUTDIR_LABEL = "outputdir:";
	private static final String SEED_LABEL = "seed:";

	public MothurGetGroupsOperator (OperatorDescription description) {
		super(description);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void doWork() throws OperatorException {
		super.doWork();
		clearArguments();
		FileNameObject accnosFile = accnosInPort.getData(FileNameObject.class);
		addArgument("accnos",accnosFile.getName());
		FileNameObject columnFile = columnInPort.getData(FileNameObject.class);
		addArgument("column",columnFile.getName());
		FileNameObject countFile = countInPort.getData(FileNameObject.class);
		addArgument("count",countFile.getName());
		FileNameObject designFile = designInPort.getData(FileNameObject.class);
		addArgument("design",designFile.getName());
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
		FileNameObject sharedFile = sharedInPort.getData(FileNameObject.class);
		addArgument("shared",sharedFile.getName());
		FileNameObject taxonomyFile = taxonomyInPort.getData(FileNameObject.class);
		addArgument("taxonomy",taxonomyFile.getName());
		String groupsValue = getParameterAsString(GROUPS_LABEL);
		addArgument("groups",String.valueOf(groupsValue));
		String inputdirValue = getParameterAsString(INPUTDIR_LABEL);
		addArgument("inputdir",String.valueOf(inputdirValue));
		String outputdirValue = getParameterAsString(OUTPUTDIR_LABEL);
		addArgument("outputdir",String.valueOf(outputdirValue));
		int seedValue = getParameterAsInt(SEED_LABEL);
		addArgument("seed",String.valueOf(seedValue));
		executeMothurCommand();
		String fileName="<fileName>"; // TODO: Somehow figure out the fileName
		taxonomyOutPort.deliver(new FileNameObject(fileName+".taxonomy","taxonomy"));
		designOutPort.deliver(new FileNameObject(fileName+".design","design"));
		nameOutPort.deliver(new FileNameObject(fileName+".name","name"));
		phylipOutPort.deliver(new FileNameObject(fileName+".phylip","phylip"));
		groupOutPort.deliver(new FileNameObject(fileName+".group","group"));
		fastaOutPort.deliver(new FileNameObject(fileName+".fasta","fasta"));
		sharedOutPort.deliver(new FileNameObject(fileName+".shared","shared"));
		countOutPort.deliver(new FileNameObject(fileName+".count","count"));
		columnOutPort.deliver(new FileNameObject(fileName+".column","column"));
		listOutPort.deliver(new FileNameObject(fileName+".list","list"));
	}

	@Override
	public List<ParameterType> getParameterTypes() {
		List<ParameterType> parameterTypes = super.getParameterTypes();
		parameterTypes.add(new ParameterTypeString(GROUPS_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeString(INPUTDIR_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeString(OUTPUTDIR_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeInt(SEED_LABEL, "TODO: Add description", -100000000, 100000000, 0, true));
		return parameterTypes;
	}

	@Override
	public String getOutputPattern(String type) {
		// TODO Use a dictionary to reflect type to pattern
		if (type=="taxonomy") return "[filename],pick,[extension]";
		if (type=="design") return "[filename],pick,[extension]";
		if (type=="name") return "[filename],pick,[extension]";
		if (type=="phylip") return "[filename],pick,[extension]";
		if (type=="group") return "[filename],pick,[extension]";
		if (type=="fasta") return "[filename],pick,[extension]";
		if (type=="shared") return "[filename],[tag],pick,[extension]";
		if (type=="count") return "[filename],pick,[extension]";
		if (type=="column") return "[filename],pick,[extension]";
		if (type=="list") return "[filename],[tag],pick,[extension]";
		// TODO if nil then 
		return super.getOutputPattern(type);
	}
}
