package com.rapidminer.ngs.operator;

import java.util.List;
import com.rapidminer.operator.OperatorDescription;
import com.rapidminer.operator.ports.InputPort;
import com.rapidminer.operator.ports.OutputPort;
import com.rapidminer.operator.OperatorException;
import com.rapidminer.parameter.*;

public class MothurRemoveOtusOperator extends MothurGeneratedOperator {

	private InputPort accnosInPort = getInputPorts().createPort("accnos");
	private InputPort constaxonomyInPort = getInputPorts().createPort("constaxonomy");
	private InputPort otucorrInPort = getInputPorts().createPort("otucorr");
	private InputPort corraxesInPort = getInputPorts().createPort("corraxes");
	private InputPort listInPort = getInputPorts().createPort("list");
	private InputPort sharedInPort = getInputPorts().createPort("shared");
	private OutputPort constaxonomyOutPort = getOutputPorts().createPort("constaxonomy");
	private OutputPort otucorrOutPort = getOutputPorts().createPort("otucorr");
	private OutputPort listOutPort = getOutputPorts().createPort("list");
	private OutputPort sharedOutPort = getOutputPorts().createPort("shared");
	private OutputPort corraxesOutPort = getOutputPorts().createPort("corraxes");
	private static final String LABEL_LABEL = "label:";
	private static final String SEED_LABEL = "seed:";
	private static final String INPUTDIR_LABEL = "inputdir:";
	private static final String OUTPUTDIR_LABEL = "outputdir:";

	public MothurRemoveOtusOperator (OperatorDescription description) {
		super(description);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void doWork() throws OperatorException {
		super.doWork();
		clearArguments();
		FileNameObject accnosFile = accnosInPort.getData(FileNameObject.class);
		addArgument("accnos",accnosFile.getName());
		FileNameObject constaxonomyFile = constaxonomyInPort.getData(FileNameObject.class);
		addArgument("constaxonomy",constaxonomyFile.getName());
		FileNameObject otucorrFile = otucorrInPort.getData(FileNameObject.class);
		addArgument("otucorr",otucorrFile.getName());
		FileNameObject corraxesFile = corraxesInPort.getData(FileNameObject.class);
		addArgument("corraxes",corraxesFile.getName());
		FileNameObject listFile = listInPort.getData(FileNameObject.class);
		addArgument("list",listFile.getName());
		FileNameObject sharedFile = sharedInPort.getData(FileNameObject.class);
		addArgument("shared",sharedFile.getName());
		String labelValue = getParameterAsString(LABEL_LABEL);
		addArgument("label",String.valueOf(labelValue));
		int seedValue = getParameterAsInt(SEED_LABEL);
		addArgument("seed",String.valueOf(seedValue));
		String inputdirValue = getParameterAsString(INPUTDIR_LABEL);
		addArgument("inputdir",String.valueOf(inputdirValue));
		String outputdirValue = getParameterAsString(OUTPUTDIR_LABEL);
		addArgument("outputdir",String.valueOf(outputdirValue));
		executeMothurCommand();
		String fileName="<fileName>"; // TODO: Somehow figure out the fileName
		constaxonomyOutPort.deliver(new FileNameObject(fileName+".constaxonomy","constaxonomy"));
		otucorrOutPort.deliver(new FileNameObject(fileName+".otucorr","otucorr"));
		listOutPort.deliver(new FileNameObject(fileName+".list","list"));
		sharedOutPort.deliver(new FileNameObject(fileName+".shared","shared"));
		corraxesOutPort.deliver(new FileNameObject(fileName+".corraxes","corraxes"));
	}

	@Override
	public List<ParameterType> getParameterTypes() {
		List<ParameterType> parameterTypes = super.getParameterTypes();
		parameterTypes.add(new ParameterTypeString(LABEL_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeInt(SEED_LABEL, "TODO: Add description", -100000000, 100000000, 0, true));
		parameterTypes.add(new ParameterTypeString(INPUTDIR_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeString(OUTPUTDIR_LABEL, "TODO: Add description", "", true));
		return parameterTypes;
	}

	@Override
	public String getOutputPattern(String type) {
		// TODO Use a dictionary to reflect type to pattern
		if (type.equals("constaxonomy")) return "[filename],pick,[extension]";
		if (type.equals("otucorr")) return "[filename],pick,[extension]";
		if (type.equals("list")) return "[filename],[distance],pick,[extension]";
		if (type.equals("shared")) return "[filename],[distance],pick,[extension]";
		if (type.equals("corraxes")) return "[filename],pick,[extension]";
		// TODO if nil then 
		return super.getOutputPattern(type);
	}
}
