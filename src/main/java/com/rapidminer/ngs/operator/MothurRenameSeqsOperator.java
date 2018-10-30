package com.rapidminer.ngs.operator;

import java.util.List;
import com.rapidminer.operator.OperatorDescription;
import com.rapidminer.operator.ports.InputPort;
import com.rapidminer.operator.ports.OutputPort;
import com.rapidminer.operator.OperatorException;
import com.rapidminer.parameter.*;

public class MothurRenameSeqsOperator extends MothurGeneratedOperator {

	private InputPort contigsreportInPort = getInputPorts().createPort("contigsreport");
	private InputPort countInPort = getInputPorts().createPort("count");
	private InputPort fastaInPort = getInputPorts().createPort("fasta");
	private InputPort fileInPort = getInputPorts().createPort("file");
	private InputPort groupInPort = getInputPorts().createPort("group");
	private InputPort mapInPort = getInputPorts().createPort("map");
	private InputPort nameInPort = getInputPorts().createPort("name");
	private InputPort qfileInPort = getInputPorts().createPort("qfile");
	private OutputPort groupOutPort = getOutputPorts().createPort("group");
	private OutputPort nameOutPort = getOutputPorts().createPort("name");
	private OutputPort qfileOutPort = getOutputPorts().createPort("qfile");
	private OutputPort mapOutPort = getOutputPorts().createPort("map");
	private OutputPort countOutPort = getOutputPorts().createPort("count");
	private OutputPort contigsreportOutPort = getOutputPorts().createPort("contigsreport");
	private OutputPort fastaOutPort = getOutputPorts().createPort("fasta");
	private static final String DELIM_LABEL = "delim:";
	private static final String INPUTDIR_LABEL = "inputdir:";
	private static final String OUTPUTDIR_LABEL = "outputdir:";
	public static final String[] PLACEMENT_CHOICES = { "back", "front" };
	public static final int PLACEMENT_DEFAULT_CHOICE = 0;
	private static final String PLACEMENT_LABEL = "placement:";
	private static final String SEED_LABEL = "seed:";

	public MothurRenameSeqsOperator (OperatorDescription description) {
		super(description);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void doWork() throws OperatorException {
		super.doWork();
		clearArguments();
		FileNameObject contigsreportFile = contigsreportInPort.getData(FileNameObject.class);
		addArgument("contigsreport",contigsreportFile.getName());
		FileNameObject countFile = countInPort.getData(FileNameObject.class);
		addArgument("count",countFile.getName());
		FileNameObject fastaFile = fastaInPort.getData(FileNameObject.class);
		addArgument("fasta",fastaFile.getName());
		FileNameObject fileFile = fileInPort.getData(FileNameObject.class);
		addArgument("file",fileFile.getName());
		FileNameObject groupFile = groupInPort.getData(FileNameObject.class);
		addArgument("group",groupFile.getName());
		FileNameObject mapFile = mapInPort.getData(FileNameObject.class);
		addArgument("map",mapFile.getName());
		FileNameObject nameFile = nameInPort.getData(FileNameObject.class);
		addArgument("name",nameFile.getName());
		FileNameObject qfileFile = qfileInPort.getData(FileNameObject.class);
		addArgument("qfile",qfileFile.getName());
		String delimValue = getParameterAsString(DELIM_LABEL);
		addArgument("delim",String.valueOf(delimValue));
		String inputdirValue = getParameterAsString(INPUTDIR_LABEL);
		addArgument("inputdir",String.valueOf(inputdirValue));
		String outputdirValue = getParameterAsString(OUTPUTDIR_LABEL);
		addArgument("outputdir",String.valueOf(outputdirValue));
		int placementIndex = getParameterAsInt(PLACEMENT_LABEL);
		String placementValue = PLACEMENT_CHOICES[placementIndex];
		addArgument("placement",String.valueOf(placementValue));
		int seedValue = getParameterAsInt(SEED_LABEL);
		addArgument("seed",String.valueOf(seedValue));
		executeMothurCommand();
		String fileName="<fileName>"; // TODO: Somehow figure out the fileName
		groupOutPort.deliver(new FileNameObject(fileName+".group","group"));
		nameOutPort.deliver(new FileNameObject(fileName+".name","name"));
		qfileOutPort.deliver(new FileNameObject(fileName+".qfile","qfile"));
		mapOutPort.deliver(new FileNameObject(fileName+".map","map"));
		countOutPort.deliver(new FileNameObject(fileName+".count","count"));
		contigsreportOutPort.deliver(new FileNameObject(fileName+".contigsreport","contigsreport"));
		fastaOutPort.deliver(new FileNameObject(fileName+".fasta","fasta"));
	}

	@Override
	public List<ParameterType> getParameterTypes() {
		List<ParameterType> parameterTypes = super.getParameterTypes();
		parameterTypes.add(new ParameterTypeString(DELIM_LABEL, "TODO: Add description", "_", true));
		parameterTypes.add(new ParameterTypeString(INPUTDIR_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeString(OUTPUTDIR_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeCategory(PLACEMENT_LABEL, "TODO: Add description", PLACEMENT_CHOICES, PLACEMENT_DEFAULT_CHOICE));
		parameterTypes.add(new ParameterTypeInt(SEED_LABEL, "TODO: Add description", -100000000, 100000000, 0, true));
		return parameterTypes;
	}

	@Override
	public String getOutputPattern(String type) {
		// TODO Use a dictionary to reflect type to pattern
		if (type=="group") return "[filename],renamed,[extension]";
		if (type=="name") return "[filename],renamed,[extension]";
		if (type=="qfile") return "[filename],renamed,[extension]";
		if (type=="map") return "[filename],renamed_map";
		if (type=="count") return "[filename],renamed,[extension]";
		if (type=="contigsreport") return "[filename],renamed,[extension]";
		if (type=="fasta") return "[filename],renamed,[extension]";
		// TODO if nil then 
		return super.getOutputPattern(type);
	}
}
