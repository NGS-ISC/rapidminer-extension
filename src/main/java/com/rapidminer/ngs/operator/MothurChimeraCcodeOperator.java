package com.rapidminer.ngs.operator;

import java.util.List;
import com.rapidminer.operator.OperatorDescription;
import com.rapidminer.operator.ports.InputPort;
import com.rapidminer.operator.ports.OutputPort;
import com.rapidminer.operator.OperatorException;
import com.rapidminer.parameter.*;

public class MothurChimeraCcodeOperator extends MothurGeneratedOperator {

	private InputPort referenceInPort = getInputPorts().createPort("reference");
	private InputPort fastaInPort = getInputPorts().createPort("fasta");
	private OutputPort chimeraOutPort = getOutputPorts().createPort("chimera");
	private OutputPort accnosOutPort = getOutputPorts().createPort("accnos");
	private OutputPort mapinfoOutPort = getOutputPorts().createPort("mapinfo");
	private static final String FILTER_LABEL = "filter:";
	private static final String WINDOW_LABEL = "window:";
	private static final String NUMWANTED_LABEL = "numwanted:";
	private static final String MASK_LABEL = "mask:";
	private static final String SEED_LABEL = "seed:";
	private static final String INPUTDIR_LABEL = "inputdir:";
	private static final String OUTPUTDIR_LABEL = "outputdir:";

	public MothurChimeraCcodeOperator (OperatorDescription description) {
		super(description);
		// NOTE: Auto-generated constructor stub
	}

	@Override
	public void doWork() throws OperatorException {
		super.doWork();
		clearArguments();
		FileNameObject referenceFile = referenceInPort.getData(FileNameObject.class);
		addArgument("reference",referenceFile.getName());
		FileNameObject fastaFile = fastaInPort.getData(FileNameObject.class);
		addArgument("fasta",fastaFile.getName());
		boolean filterValue = getParameterAsBoolean(FILTER_LABEL);
		addArgument("filter",String.valueOf(filterValue));
		int windowValue = getParameterAsInt(WINDOW_LABEL);
		addArgument("window",String.valueOf(windowValue));
		int numwantedValue = getParameterAsInt(NUMWANTED_LABEL);
		addArgument("numwanted",String.valueOf(numwantedValue));
		String maskValue = getParameterAsString(MASK_LABEL);
		addArgument("mask",String.valueOf(maskValue));
		int seedValue = getParameterAsInt(SEED_LABEL);
		addArgument("seed",String.valueOf(seedValue));
		String inputdirValue = getParameterAsString(INPUTDIR_LABEL);
		addArgument("inputdir",String.valueOf(inputdirValue));
		String outputdirValue = getParameterAsString(OUTPUTDIR_LABEL);
		addArgument("outputdir",String.valueOf(outputdirValue));
		executeMothurCommand();
		String fileName="<fileName>"; // TODO: Somehow figure out the fileName
		chimeraOutPort.deliver(new FileNameObject(fileName+".chimera","chimera"));
		accnosOutPort.deliver(new FileNameObject(fileName+".accnos","accnos"));
		mapinfoOutPort.deliver(new FileNameObject(fileName+".mapinfo","mapinfo"));
	}

	@Override
	public List<ParameterType> getParameterTypes() {
		List<ParameterType> parameterTypes = super.getParameterTypes();
		parameterTypes.add(new ParameterTypeBoolean(FILTER_LABEL, "TODO: Add description", false, true));
		parameterTypes.add(new ParameterTypeInt(WINDOW_LABEL, "TODO: Add description", -100000000, 100000000, 0, true));
		parameterTypes.add(new ParameterTypeInt(NUMWANTED_LABEL, "TODO: Add description", -100000000, 100000000, 20, true));
		parameterTypes.add(new ParameterTypeString(MASK_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeInt(SEED_LABEL, "TODO: Add description", -100000000, 100000000, 0, true));
		parameterTypes.add(new ParameterTypeString(INPUTDIR_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeString(OUTPUTDIR_LABEL, "TODO: Add description", "", true));
		return parameterTypes;
	}

	@Override
	public String getOutputPattern(String type) {
		if (type.equals("chimera")) return "[filename],[tag],ccode.chimeras-[filename],ccode.chimeras";
		if (type.equals("accnos")) return "[filename],[tag],ccode.accnos-[filename],ccode.accnos";
		if (type.equals("mapinfo")) return "[filename],mapinfo";
		return super.getOutputPattern(type);
	}
}
