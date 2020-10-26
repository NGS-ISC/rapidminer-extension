package com.rapidminer.ngs.operator;

import java.util.List;
import com.rapidminer.operator.OperatorDescription;
import com.rapidminer.operator.ports.InputPort;
import com.rapidminer.operator.ports.OutputPort;
import com.rapidminer.operator.OperatorException;
import com.rapidminer.parameter.*;

public class MothurRenameSeqsOperator extends MothurGeneratedOperator {

	private InputPort fileInPort = getInputPorts().createPort("file");
	private InputPort mapInPort = getInputPorts().createPort("map");
	private InputPort fastaInPort = getInputPorts().createPort("fasta");
	private InputPort qfileInPort = getInputPorts().createPort("qfile");
	private InputPort contigsreportInPort = getInputPorts().createPort("contigsreport");
	private InputPort taxonomyInPort = getInputPorts().createPort("taxonomy");
	private InputPort nameInPort = getInputPorts().createPort("name");
	private InputPort countInPort = getInputPorts().createPort("count");
	private InputPort groupInPort = getInputPorts().createPort("group");
	private OutputPort contigsreportOutPort = getOutputPorts().createPort("contigsreport");
	private OutputPort countOutPort = getOutputPorts().createPort("count");
	private OutputPort fastaOutPort = getOutputPorts().createPort("fasta");
	private OutputPort groupOutPort = getOutputPorts().createPort("group");
	private OutputPort mapOutPort = getOutputPorts().createPort("map");
	private OutputPort nameOutPort = getOutputPorts().createPort("name");
	private OutputPort qfileOutPort = getOutputPorts().createPort("qfile");
	private OutputPort taxonomyOutPort = getOutputPorts().createPort("taxonomy");
	private static final String DELIM_LABEL = "delim:";
	private static final String[] PLACEMENT_CHOICES = { "front", "back" };
	private static final int PLACEMENT_DEFAULT_CHOICE = 1;
	private static final String PLACEMENT_LABEL = "placement:";
	private static final String SEED_LABEL = "seed:";
	private static final String INPUTDIR_LABEL = "inputdir:";
	private static final String OUTPUTDIR_LABEL = "outputdir:";

	public MothurRenameSeqsOperator (OperatorDescription description) {
		super(description);
		// NOTE: Auto-generated constructor stub
	}

	@Override
	public void doWork() throws OperatorException {
		super.doWork();
		clearArguments();
		FileNameObject fileFile = fileInPort.getData(FileNameObject.class);
		addArgument("file",fileFile.getName());
		FileNameObject mapFile = mapInPort.getData(FileNameObject.class);
		addArgument("map",mapFile.getName());
		FileNameObject fastaFile = fastaInPort.getData(FileNameObject.class);
		addArgument("fasta",fastaFile.getName());
		FileNameObject qfileFile = qfileInPort.getData(FileNameObject.class);
		addArgument("qfile",qfileFile.getName());
		FileNameObject contigsreportFile = contigsreportInPort.getData(FileNameObject.class);
		addArgument("contigsreport",contigsreportFile.getName());
		FileNameObject taxonomyFile = taxonomyInPort.getData(FileNameObject.class);
		addArgument("taxonomy",taxonomyFile.getName());
		FileNameObject nameFile = nameInPort.getData(FileNameObject.class);
		addArgument("name",nameFile.getName());
		FileNameObject countFile = countInPort.getData(FileNameObject.class);
		addArgument("count",countFile.getName());
		FileNameObject groupFile = groupInPort.getData(FileNameObject.class);
		addArgument("group",groupFile.getName());
		String delimValue = getParameterAsString(DELIM_LABEL);
		addArgument("delim",String.valueOf(delimValue));
		int placementIndex = getParameterAsInt(PLACEMENT_LABEL);
		String placementValue = PLACEMENT_CHOICES[placementIndex];
		addArgument("placement",String.valueOf(placementValue));
		int seedValue = getParameterAsInt(SEED_LABEL);
		addArgument("seed",String.valueOf(seedValue));
		String inputdirValue = getParameterAsString(INPUTDIR_LABEL);
		addArgument("inputdir",String.valueOf(inputdirValue));
		String outputdirValue = getParameterAsString(OUTPUTDIR_LABEL);
		addArgument("outputdir",String.valueOf(outputdirValue));
		executeMothurCommand();
		String fileName="<fileName>"; // TODO: Somehow figure out the fileName
		contigsreportOutPort.deliver(new FileNameObject(fileName+".contigsreport","contigsreport"));
		countOutPort.deliver(new FileNameObject(fileName+".count","count"));
		fastaOutPort.deliver(new FileNameObject(fileName+".fasta","fasta"));
		groupOutPort.deliver(new FileNameObject(fileName+".group","group"));
		mapOutPort.deliver(new FileNameObject(fileName+".map","map"));
		nameOutPort.deliver(new FileNameObject(fileName+".name","name"));
		qfileOutPort.deliver(new FileNameObject(fileName+".qfile","qfile"));
		taxonomyOutPort.deliver(new FileNameObject(fileName+".taxonomy","taxonomy"));
	}

	@Override
	public List<ParameterType> getParameterTypes() {
		List<ParameterType> parameterTypes = super.getParameterTypes();
		parameterTypes.add(new ParameterTypeString(DELIM_LABEL, "TODO: Add description", "_", true));
		parameterTypes.add(new ParameterTypeCategory(PLACEMENT_LABEL, "TODO: Add description", PLACEMENT_CHOICES, PLACEMENT_DEFAULT_CHOICE));
		parameterTypes.add(new ParameterTypeInt(SEED_LABEL, "TODO: Add description", -100000000, 100000000, 0, true));
		parameterTypes.add(new ParameterTypeString(INPUTDIR_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeString(OUTPUTDIR_LABEL, "TODO: Add description", "", true));
		return parameterTypes;
	}

	@Override
	public String getOutputPattern(String type) {
		if (type.equals("group")) return "[filename],renamed,[extension]";
		if (type.equals("qfile")) return "[filename],renamed,[extension]";
		if (type.equals("contigsreport")) return "[filename],renamed,[extension]";
		if (type.equals("name")) return "[filename],renamed,[extension]";
		if (type.equals("count")) return "[filename],renamed,[extension]";
		if (type.equals("fasta")) return "[filename],renamed,[extension]";
		if (type.equals("taxonomy")) return "[filename],renamed,[extension]";
		if (type.equals("map")) return "[filename],renamed_map";
		return super.getOutputPattern(type);
	}
}
