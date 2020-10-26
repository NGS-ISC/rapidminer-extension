package com.rapidminer.ngs.operator;

import java.util.List;
import com.rapidminer.operator.OperatorDescription;
import com.rapidminer.operator.ports.InputPort;
import com.rapidminer.operator.ports.OutputPort;
import com.rapidminer.operator.OperatorException;
import com.rapidminer.parameter.*;

public class MothurCollectSingleOperator extends MothurGeneratedOperator {

	private InputPort listInPort = getInputPorts().createPort("list");
	private InputPort rabundInPort = getInputPorts().createPort("rabund");
	private InputPort sabundInPort = getInputPorts().createPort("sabund");
	private InputPort sharedInPort = getInputPorts().createPort("shared");
	private OutputPort aceOutPort = getOutputPorts().createPort("ace");
	private OutputPort bergerparkerOutPort = getOutputPorts().createPort("bergerparker");
	private OutputPort bonehOutPort = getOutputPorts().createPort("boneh");
	private OutputPort bootstrapOutPort = getOutputPorts().createPort("bootstrap");
	private OutputPort bstickOutPort = getOutputPorts().createPort("bstick");
	private OutputPort chaoOutPort = getOutputPorts().createPort("chao");
	private OutputPort coverageOutPort = getOutputPorts().createPort("coverage");
	private OutputPort efronOutPort = getOutputPorts().createPort("efron");
	private OutputPort geometricOutPort = getOutputPorts().createPort("geometric");
	private OutputPort goodscoverageOutPort = getOutputPorts().createPort("goodscoverage");
	private OutputPort heipOutPort = getOutputPorts().createPort("heip");
	private OutputPort invsimpsonOutPort = getOutputPorts().createPort("invsimpson");
	private OutputPort jackOutPort = getOutputPorts().createPort("jack");
	private OutputPort logseriesOutPort = getOutputPorts().createPort("logseries");
	private OutputPort npshannonOutPort = getOutputPorts().createPort("npshannon");
	private OutputPort nseqsOutPort = getOutputPorts().createPort("nseqs");
	private OutputPort qstatOutPort = getOutputPorts().createPort("qstat");
	private OutputPort shannonOutPort = getOutputPorts().createPort("shannon");
	private OutputPort shannonevenOutPort = getOutputPorts().createPort("shannoneven");
	private OutputPort shannonrangeOutPort = getOutputPorts().createPort("shannonrange");
	private OutputPort shenOutPort = getOutputPorts().createPort("shen");
	private OutputPort simpsonOutPort = getOutputPorts().createPort("simpson");
	private OutputPort simpsonevenOutPort = getOutputPorts().createPort("simpsoneven");
	private OutputPort smithwilsonOutPort = getOutputPorts().createPort("smithwilson");
	private OutputPort sobsOutPort = getOutputPorts().createPort("sobs");
	private OutputPort solowOutPort = getOutputPorts().createPort("solow");
	private static final String LABEL_LABEL = "label:";
	private static final String FREQ_LABEL = "freq:";
	private static final String[] CALC_CHOICES = { "sobs", "chao", "nseqs", "coverage", "ace", "jack", "shannon", "shannoneven", "npshannon", "heip", "smithwilson", "simpson", "simpsoneven", "invsimpson", "bootstrap", "geometric", "qstat", "logseries", "bergerparker", "bstick", "goodscoverage", "efron", "boneh", "solow", "shen" };
	private static final int CALC_DEFAULT_CHOICE = 0;
	private static final String CALC_LABEL = "calc:";
	private static final String ABUND_LABEL = "abund:";
	private static final String[] ALPHA_CHOICES = { "0", "1", "2" };
	private static final int ALPHA_DEFAULT_CHOICE = 1;
	private static final String ALPHA_LABEL = "alpha:";
	private static final String SIZE_LABEL = "size:";
	private static final String SEED_LABEL = "seed:";
	private static final String INPUTDIR_LABEL = "inputdir:";
	private static final String OUTPUTDIR_LABEL = "outputdir:";

	public MothurCollectSingleOperator (OperatorDescription description) {
		super(description);
		// NOTE: Auto-generated constructor stub
	}

	@Override
	public void doWork() throws OperatorException {
		super.doWork();
		clearArguments();
		FileNameObject listFile = listInPort.getData(FileNameObject.class);
		addArgument("list",listFile.getName());
		FileNameObject rabundFile = rabundInPort.getData(FileNameObject.class);
		addArgument("rabund",rabundFile.getName());
		FileNameObject sabundFile = sabundInPort.getData(FileNameObject.class);
		addArgument("sabund",sabundFile.getName());
		FileNameObject sharedFile = sharedInPort.getData(FileNameObject.class);
		addArgument("shared",sharedFile.getName());
		String labelValue = getParameterAsString(LABEL_LABEL);
		addArgument("label",String.valueOf(labelValue));
		int freqValue = getParameterAsInt(FREQ_LABEL);
		addArgument("freq",String.valueOf(freqValue));
		int calcIndex = getParameterAsInt(CALC_LABEL);
		String calcValue = CALC_CHOICES[calcIndex];
		addArgument("calc",String.valueOf(calcValue));
		int abundValue = getParameterAsInt(ABUND_LABEL);
		addArgument("abund",String.valueOf(abundValue));
		int alphaIndex = getParameterAsInt(ALPHA_LABEL);
		String alphaValue = ALPHA_CHOICES[alphaIndex];
		addArgument("alpha",String.valueOf(alphaValue));
		int sizeValue = getParameterAsInt(SIZE_LABEL);
		addArgument("size",String.valueOf(sizeValue));
		int seedValue = getParameterAsInt(SEED_LABEL);
		addArgument("seed",String.valueOf(seedValue));
		String inputdirValue = getParameterAsString(INPUTDIR_LABEL);
		addArgument("inputdir",String.valueOf(inputdirValue));
		String outputdirValue = getParameterAsString(OUTPUTDIR_LABEL);
		addArgument("outputdir",String.valueOf(outputdirValue));
		executeMothurCommand();
		String fileName="<fileName>"; // TODO: Somehow figure out the fileName
		aceOutPort.deliver(new FileNameObject(fileName+".ace","ace"));
		bergerparkerOutPort.deliver(new FileNameObject(fileName+".bergerparker","bergerparker"));
		bonehOutPort.deliver(new FileNameObject(fileName+".boneh","boneh"));
		bootstrapOutPort.deliver(new FileNameObject(fileName+".bootstrap","bootstrap"));
		bstickOutPort.deliver(new FileNameObject(fileName+".bstick","bstick"));
		chaoOutPort.deliver(new FileNameObject(fileName+".chao","chao"));
		coverageOutPort.deliver(new FileNameObject(fileName+".coverage","coverage"));
		efronOutPort.deliver(new FileNameObject(fileName+".efron","efron"));
		geometricOutPort.deliver(new FileNameObject(fileName+".geometric","geometric"));
		goodscoverageOutPort.deliver(new FileNameObject(fileName+".goodscoverage","goodscoverage"));
		heipOutPort.deliver(new FileNameObject(fileName+".heip","heip"));
		invsimpsonOutPort.deliver(new FileNameObject(fileName+".invsimpson","invsimpson"));
		jackOutPort.deliver(new FileNameObject(fileName+".jack","jack"));
		logseriesOutPort.deliver(new FileNameObject(fileName+".logseries","logseries"));
		npshannonOutPort.deliver(new FileNameObject(fileName+".npshannon","npshannon"));
		nseqsOutPort.deliver(new FileNameObject(fileName+".nseqs","nseqs"));
		qstatOutPort.deliver(new FileNameObject(fileName+".qstat","qstat"));
		shannonOutPort.deliver(new FileNameObject(fileName+".shannon","shannon"));
		shannonevenOutPort.deliver(new FileNameObject(fileName+".shannoneven","shannoneven"));
		shannonrangeOutPort.deliver(new FileNameObject(fileName+".shannonrange","shannonrange"));
		shenOutPort.deliver(new FileNameObject(fileName+".shen","shen"));
		simpsonOutPort.deliver(new FileNameObject(fileName+".simpson","simpson"));
		simpsonevenOutPort.deliver(new FileNameObject(fileName+".simpsoneven","simpsoneven"));
		smithwilsonOutPort.deliver(new FileNameObject(fileName+".smithwilson","smithwilson"));
		sobsOutPort.deliver(new FileNameObject(fileName+".sobs","sobs"));
		solowOutPort.deliver(new FileNameObject(fileName+".solow","solow"));
	}

	@Override
	public List<ParameterType> getParameterTypes() {
		List<ParameterType> parameterTypes = super.getParameterTypes();
		parameterTypes.add(new ParameterTypeString(LABEL_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeInt(FREQ_LABEL, "TODO: Add description", -100000000, 100000000, 100, true));
		parameterTypes.add(new ParameterTypeCategory(CALC_LABEL, "TODO: Add description", CALC_CHOICES, CALC_DEFAULT_CHOICE));
		parameterTypes.add(new ParameterTypeInt(ABUND_LABEL, "TODO: Add description", -100000000, 100000000, 10, true));
		parameterTypes.add(new ParameterTypeCategory(ALPHA_LABEL, "TODO: Add description", ALPHA_CHOICES, ALPHA_DEFAULT_CHOICE));
		parameterTypes.add(new ParameterTypeInt(SIZE_LABEL, "TODO: Add description", -100000000, 100000000, 0, true));
		parameterTypes.add(new ParameterTypeInt(SEED_LABEL, "TODO: Add description", -100000000, 100000000, 0, true));
		parameterTypes.add(new ParameterTypeString(INPUTDIR_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeString(OUTPUTDIR_LABEL, "TODO: Add description", "", true));
		return parameterTypes;
	}

	@Override
	public String getOutputPattern(String type) {
		if (type.equals("smithwilson")) return "[filename],smithwilson";
		if (type.equals("coverage")) return "[filename],coverage";
		if (type.equals("sobs")) return "[filename],sobs";
		if (type.equals("shannon")) return "[filename],shannon";
		if (type.equals("geometric")) return "[filename],geometric";
		if (type.equals("logseries")) return "[filename],logseries";
		if (type.equals("shen")) return "[filename],shen";
		if (type.equals("nseqs")) return "[filename],nseqs";
		if (type.equals("ace")) return "[filename],ace";
		if (type.equals("jack")) return "[filename],jack";
		if (type.equals("bstick")) return "[filename],bstick";
		if (type.equals("bergerparker")) return "[filename],bergerparker";
		if (type.equals("bootstrap")) return "[filename],bootstrap";
		if (type.equals("goodscoverage")) return "[filename],goodscoverage";
		if (type.equals("boneh")) return "[filename],boneh";
		if (type.equals("shannoneven")) return "[filename],shannoneven";
		if (type.equals("efron")) return "[filename],efron";
		if (type.equals("solow")) return "[filename],solow";
		if (type.equals("invsimpson")) return "[filename],invsimpson";
		if (type.equals("qstat")) return "[filename],qstat";
		if (type.equals("chao")) return "[filename],chao";
		if (type.equals("heip")) return "[filename],heip";
		if (type.equals("simpsoneven")) return "[filename],simpsoneven";
		if (type.equals("shannonrange")) return "[filename],shannonrange";
		if (type.equals("npshannon")) return "[filename],npshannon";
		if (type.equals("simpson")) return "[filename],simpson";
		return super.getOutputPattern(type);
	}
}
