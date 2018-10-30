package com.rapidminer.ngs.operator;

import java.util.List;
import com.rapidminer.operator.OperatorDescription;
import com.rapidminer.operator.ports.InputPort;
import com.rapidminer.operator.ports.OutputPort;
import com.rapidminer.operator.OperatorException;
import com.rapidminer.parameter.*;

public class MothurCatchallOperator extends MothurGeneratedOperator {

	private InputPort sabundInPort = getInputPorts().createPort("sabund");
	private InputPort sharedInPort = getInputPorts().createPort("shared");
	private OutputPort modelsOutPort = getOutputPorts().createPort("models");
	private OutputPort bestanalysisOutPort = getOutputPorts().createPort("bestanalysis");
	private OutputPort analysisOutPort = getOutputPorts().createPort("analysis");
	private OutputPort summaryOutPort = getOutputPorts().createPort("summary");
	private OutputPort bubbleOutPort = getOutputPorts().createPort("bubble");
	private OutputPort sabundOutPort = getOutputPorts().createPort("sabund");
	private static final String GROUPS_LABEL = "groups:";
	private static final String INPUTDIR_LABEL = "inputdir:";
	private static final String LABEL_LABEL = "label:";
	private static final String OUTPUTDIR_LABEL = "outputdir:";
	private static final String SEED_LABEL = "seed:";

	public MothurCatchallOperator (OperatorDescription description) {
		super(description);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void doWork() throws OperatorException {
		super.doWork();
		clearArguments();
		FileNameObject sabundFile = sabundInPort.getData(FileNameObject.class);
		addArgument("sabund",sabundFile.getName());
		FileNameObject sharedFile = sharedInPort.getData(FileNameObject.class);
		addArgument("shared",sharedFile.getName());
		String groupsValue = getParameterAsString(GROUPS_LABEL);
		addArgument("groups",String.valueOf(groupsValue));
		String inputdirValue = getParameterAsString(INPUTDIR_LABEL);
		addArgument("inputdir",String.valueOf(inputdirValue));
		String labelValue = getParameterAsString(LABEL_LABEL);
		addArgument("label",String.valueOf(labelValue));
		String outputdirValue = getParameterAsString(OUTPUTDIR_LABEL);
		addArgument("outputdir",String.valueOf(outputdirValue));
		int seedValue = getParameterAsInt(SEED_LABEL);
		addArgument("seed",String.valueOf(seedValue));
		executeMothurCommand();
		String fileName="<fileName>"; // TODO: Somehow figure out the fileName
		modelsOutPort.deliver(new FileNameObject(fileName+".models","models"));
		bestanalysisOutPort.deliver(new FileNameObject(fileName+".bestanalysis","bestanalysis"));
		analysisOutPort.deliver(new FileNameObject(fileName+".analysis","analysis"));
		summaryOutPort.deliver(new FileNameObject(fileName+".summary","summary"));
		bubbleOutPort.deliver(new FileNameObject(fileName+".bubble","bubble"));
		sabundOutPort.deliver(new FileNameObject(fileName+".sabund","sabund"));
	}

	@Override
	public List<ParameterType> getParameterTypes() {
		List<ParameterType> parameterTypes = super.getParameterTypes();
		parameterTypes.add(new ParameterTypeString(GROUPS_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeString(INPUTDIR_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeString(LABEL_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeString(OUTPUTDIR_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeInt(SEED_LABEL, "TODO: Add description", -100000000, 100000000, 0, true));
		return parameterTypes;
	}

	@Override
	public String getOutputPattern(String type) {
		// TODO Use a dictionary to reflect type to pattern
		if (type=="models") return "[filename],_BestModelsAnalysis.csv";
		if (type=="bestanalysis") return "[filename],_BestModelsAnalysis.csv";
		if (type=="analysis") return "[filename],_Analysis.csv";
		if (type=="summary") return "[filename],catchall.summary";
		if (type=="bubble") return "[filename],_BubblePlot.csv";
		if (type=="sabund") return "[filename],[distance],csv";
		// TODO if nil then 
		return super.getOutputPattern(type);
	}
}
