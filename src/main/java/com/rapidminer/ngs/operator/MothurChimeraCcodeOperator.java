package com.rapidminer.ngs.operator;

import java.util.List;
import com.rapidminer.operator.OperatorDescription;
import com.rapidminer.operator.ports.InputPort;
import com.rapidminer.operator.ports.OutputPort;
import com.rapidminer.operator.OperatorException;
import com.rapidminer.parameter.*;

public class MothurChimeraCcodeOperator extends MothurGeneratedOperator {

	private InputPort fastaInPort = getInputPorts().createPort("fasta");
	private InputPort referenceInPort = getInputPorts().createPort("reference");
	private OutputPort chimeraOutPort = getOutputPorts().createPort("chimera");
	private OutputPort mapinfoOutPort = getOutputPorts().createPort("mapinfo");
	private OutputPort accnosOutPort = getOutputPorts().createPort("accnos");
	private static final String FILTER_LABEL = "filter:";
	private static final String INPUTDIR_LABEL = "inputdir:";
	private static final String MASK_LABEL = "mask:";
	private static final String NUMWANTED_LABEL = "numwanted:";
	private static final String OUTPUTDIR_LABEL = "outputdir:";
	private static final String SEED_LABEL = "seed:";
	private static final String WINDOW_LABEL = "window:";

	public MothurChimeraCcodeOperator (OperatorDescription description) {
		super(description);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void doWork() throws OperatorException {
		super.doWork();
		clearArguments();
		FileNameObject fastaFile = fastaInPort.getData(FileNameObject.class);
		addArgument("fasta",fastaFile.getName());
		FileNameObject referenceFile = referenceInPort.getData(FileNameObject.class);
		addArgument("reference",referenceFile.getName());
		boolean filterValue = getParameterAsBoolean(FILTER_LABEL);
		addArgument("filter",String.valueOf(filterValue));
		String inputdirValue = getParameterAsString(INPUTDIR_LABEL);
		addArgument("inputdir",String.valueOf(inputdirValue));
		String maskValue = getParameterAsString(MASK_LABEL);
		addArgument("mask",String.valueOf(maskValue));
		int numwantedValue = getParameterAsInt(NUMWANTED_LABEL);
		addArgument("numwanted",String.valueOf(numwantedValue));
		String outputdirValue = getParameterAsString(OUTPUTDIR_LABEL);
		addArgument("outputdir",String.valueOf(outputdirValue));
		int seedValue = getParameterAsInt(SEED_LABEL);
		addArgument("seed",String.valueOf(seedValue));
		int windowValue = getParameterAsInt(WINDOW_LABEL);
		addArgument("window",String.valueOf(windowValue));
		executeMothurCommand();
		String fileName="<fileName>"; // TODO: Somehow figure out the fileName
		chimeraOutPort.deliver(new FileNameObject(fileName+".chimera","chimera"));
		mapinfoOutPort.deliver(new FileNameObject(fileName+".mapinfo","mapinfo"));
		accnosOutPort.deliver(new FileNameObject(fileName+".accnos","accnos"));
	}

	@Override
	public List<ParameterType> getParameterTypes() {
		List<ParameterType> parameterTypes = super.getParameterTypes();
		parameterTypes.add(new ParameterTypeBoolean(FILTER_LABEL, "TODO: Add description", false, true));
		parameterTypes.add(new ParameterTypeString(INPUTDIR_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeString(MASK_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeInt(NUMWANTED_LABEL, "TODO: Add description", -100000000, 100000000, 20, true));
		parameterTypes.add(new ParameterTypeString(OUTPUTDIR_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeInt(SEED_LABEL, "TODO: Add description", -100000000, 100000000, 0, true));
		parameterTypes.add(new ParameterTypeInt(WINDOW_LABEL, "TODO: Add description", -100000000, 100000000, 0, true));
		return parameterTypes;
	}

	@Override
	public String getOutputPattern(String type) {
		// TODO Use a dictionary to reflect type to pattern
		if (type=="chimera") return "[filename],[tag],ccode.chimeras-[filename],ccode.chimeras";
		if (type=="mapinfo") return "[filename],mapinfo";
		if (type=="accnos") return "[filename],[tag],ccode.accnos-[filename],ccode.accnos";
		// TODO if nil then 
		return super.getOutputPattern(type);
	}
}
