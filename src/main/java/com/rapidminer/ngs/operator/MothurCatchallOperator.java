package com.rapidminer.ngs.operator;

import java.util.List;
import com.rapidminer.operator.OperatorDescription;
import com.rapidminer.operator.ports.InputPort;
import com.rapidminer.operator.ports.OutputPort;
import com.rapidminer.operator.OperatorException;
import com.rapidminer.parameter.*;

public class MothurCatchallOperator extends MothurGeneratedOperator {

	private InputPort sharedInPort = getInputPorts().createPort("shared");
	private InputPort sabundInPort = getInputPorts().createPort("sabund");
	private OutputPort analysisOutPort = getOutputPorts().createPort("analysis");
	private OutputPort summaryOutPort = getOutputPorts().createPort("summary");
	private OutputPort modelsOutPort = getOutputPorts().createPort("models");
	private OutputPort sabundOutPort = getOutputPorts().createPort("sabund");
	private OutputPort bubbleOutPort = getOutputPorts().createPort("bubble");
	private OutputPort bestanalysisOutPort = getOutputPorts().createPort("bestanalysis");
	private static final String LABEL_LABEL = "label:";
	private static final String GROUPS_LABEL = "groups:";
	private static final String SEED_LABEL = "seed:";
	private static final String INPUTDIR_LABEL = "inputdir:";
	private static final String OUTPUTDIR_LABEL = "outputdir:";

	public MothurCatchallOperator (OperatorDescription description) {
		super(description);
		// NOTE: Auto-generated constructor stub
	}

	@Override
	public void doWork() throws OperatorException {
		super.doWork();
		clearArguments();
		FileNameObject sharedFile = sharedInPort.getData(FileNameObject.class);
		addArgument("shared",sharedFile.getName());
		FileNameObject sabundFile = sabundInPort.getData(FileNameObject.class);
		addArgument("sabund",sabundFile.getName());
		String labelValue = getParameterAsString(LABEL_LABEL);
		addArgument("label",String.valueOf(labelValue));
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
		analysisOutPort.deliver(new FileNameObject(fileName+".analysis","analysis"));
		summaryOutPort.deliver(new FileNameObject(fileName+".summary","summary"));
		modelsOutPort.deliver(new FileNameObject(fileName+".models","models"));
		sabundOutPort.deliver(new FileNameObject(fileName+".sabund","sabund"));
		bubbleOutPort.deliver(new FileNameObject(fileName+".bubble","bubble"));
		bestanalysisOutPort.deliver(new FileNameObject(fileName+".bestanalysis","bestanalysis"));
	}

	@Override
	public List<ParameterType> getParameterTypes() {
		List<ParameterType> parameterTypes = super.getParameterTypes();
		parameterTypes.add(new ParameterTypeString(LABEL_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeString(GROUPS_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeInt(SEED_LABEL, "TODO: Add description", -100000000, 100000000, 0, true));
		parameterTypes.add(new ParameterTypeString(INPUTDIR_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeString(OUTPUTDIR_LABEL, "TODO: Add description", "", true));
		return parameterTypes;
	}

	@Override
	public String getOutputPattern(String type) {
		if (type.equals("analysis")) return "[filename],_Analysis.csv";
		if (type.equals("summary")) return "[filename],catchall.summary";
		if (type.equals("models")) return "[filename],_BestModelsAnalysis.csv";
		if (type.equals("sabund")) return "[filename],[distance],csv";
		if (type.equals("bubble")) return "[filename],_BubblePlot.csv";
		if (type.equals("bestanalysis")) return "[filename],_BestModelsAnalysis.csv";
		return super.getOutputPattern(type);
	}
}
