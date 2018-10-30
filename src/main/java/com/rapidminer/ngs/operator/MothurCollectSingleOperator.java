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
	private OutputPort sobsOutPort = getOutputPorts().createPort("sobs");
	private OutputPort shannonOutPort = getOutputPorts().createPort("shannon");
	private OutputPort simpsonOutPort = getOutputPorts().createPort("simpson");
	private OutputPort geometricOutPort = getOutputPorts().createPort("geometric");
	private OutputPort bergerparkerOutPort = getOutputPorts().createPort("bergerparker");
	private OutputPort simpsonevenOutPort = getOutputPorts().createPort("simpsoneven");
	private OutputPort qstatOutPort = getOutputPorts().createPort("qstat");
	private OutputPort aceOutPort = getOutputPorts().createPort("ace");
	private OutputPort logseriesOutPort = getOutputPorts().createPort("logseries");
	private OutputPort chaoOutPort = getOutputPorts().createPort("chao");
	private OutputPort nseqsOutPort = getOutputPorts().createPort("nseqs");
	private OutputPort bstickOutPort = getOutputPorts().createPort("bstick");
	private OutputPort bonehOutPort = getOutputPorts().createPort("boneh");
	private OutputPort bootstrapOutPort = getOutputPorts().createPort("bootstrap");
	private OutputPort coverageOutPort = getOutputPorts().createPort("coverage");
	private OutputPort shenOutPort = getOutputPorts().createPort("shen");
	private OutputPort heipOutPort = getOutputPorts().createPort("heip");
	private OutputPort npshannonOutPort = getOutputPorts().createPort("npshannon");
	private OutputPort goodscoverageOutPort = getOutputPorts().createPort("goodscoverage");
	private OutputPort shannonrangeOutPort = getOutputPorts().createPort("shannonrange");
	private OutputPort smithwilsonOutPort = getOutputPorts().createPort("smithwilson");
	private OutputPort efronOutPort = getOutputPorts().createPort("efron");
	private OutputPort solowOutPort = getOutputPorts().createPort("solow");
	private OutputPort shannonevenOutPort = getOutputPorts().createPort("shannoneven");
	private OutputPort invsimpsonOutPort = getOutputPorts().createPort("invsimpson");
	private OutputPort jackOutPort = getOutputPorts().createPort("jack");
	private static final String ABUND_LABEL = "abund:";
	public static final String[] ALPHA_CHOICES = { "0", "1", "2" };
	public static final int ALPHA_DEFAULT_CHOICE = 1;
	private static final String ALPHA_LABEL = "alpha:";
	public static final String[] CALC_CHOICES = { "ace", "bergerparker", "boneh", "bootstrap", "bstick", "chao", "coverage", "efron", "geometric", "goodscoverage", "heip", "invsimpson", "jack", "logseries", "npshannon", "nseqs", "qstat", "shannon", "shannoneven", "shen", "simpson", "simpsoneven", "smithwilson", "sobs", "solow" };
	public static final int CALC_DEFAULT_CHOICE = 0;
	private static final String CALC_LABEL = "calc:";
	private static final String FREQ_LABEL = "freq:";
	private static final String INPUTDIR_LABEL = "inputdir:";
	private static final String LABEL_LABEL = "label:";
	private static final String OUTPUTDIR_LABEL = "outputdir:";
	private static final String SEED_LABEL = "seed:";
	private static final String SIZE_LABEL = "size:";

	public MothurCollectSingleOperator (OperatorDescription description) {
		super(description);
		// TODO Auto-generated constructor stub
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
		int abundValue = getParameterAsInt(ABUND_LABEL);
		addArgument("abund",String.valueOf(abundValue));
		int alphaIndex = getParameterAsInt(ALPHA_LABEL);
		String alphaValue = ALPHA_CHOICES[alphaIndex];
		addArgument("alpha",String.valueOf(alphaValue));
		int calcIndex = getParameterAsInt(CALC_LABEL);
		String calcValue = CALC_CHOICES[calcIndex];
		addArgument("calc",String.valueOf(calcValue));
		int freqValue = getParameterAsInt(FREQ_LABEL);
		addArgument("freq",String.valueOf(freqValue));
		String inputdirValue = getParameterAsString(INPUTDIR_LABEL);
		addArgument("inputdir",String.valueOf(inputdirValue));
		String labelValue = getParameterAsString(LABEL_LABEL);
		addArgument("label",String.valueOf(labelValue));
		String outputdirValue = getParameterAsString(OUTPUTDIR_LABEL);
		addArgument("outputdir",String.valueOf(outputdirValue));
		int seedValue = getParameterAsInt(SEED_LABEL);
		addArgument("seed",String.valueOf(seedValue));
		int sizeValue = getParameterAsInt(SIZE_LABEL);
		addArgument("size",String.valueOf(sizeValue));
		executeMothurCommand();
		String fileName="<fileName>"; // TODO: Somehow figure out the fileName
		sobsOutPort.deliver(new FileNameObject(fileName+".sobs","sobs"));
		shannonOutPort.deliver(new FileNameObject(fileName+".shannon","shannon"));
		simpsonOutPort.deliver(new FileNameObject(fileName+".simpson","simpson"));
		geometricOutPort.deliver(new FileNameObject(fileName+".geometric","geometric"));
		bergerparkerOutPort.deliver(new FileNameObject(fileName+".bergerparker","bergerparker"));
		simpsonevenOutPort.deliver(new FileNameObject(fileName+".simpsoneven","simpsoneven"));
		qstatOutPort.deliver(new FileNameObject(fileName+".qstat","qstat"));
		aceOutPort.deliver(new FileNameObject(fileName+".ace","ace"));
		logseriesOutPort.deliver(new FileNameObject(fileName+".logseries","logseries"));
		chaoOutPort.deliver(new FileNameObject(fileName+".chao","chao"));
		nseqsOutPort.deliver(new FileNameObject(fileName+".nseqs","nseqs"));
		bstickOutPort.deliver(new FileNameObject(fileName+".bstick","bstick"));
		bonehOutPort.deliver(new FileNameObject(fileName+".boneh","boneh"));
		bootstrapOutPort.deliver(new FileNameObject(fileName+".bootstrap","bootstrap"));
		coverageOutPort.deliver(new FileNameObject(fileName+".coverage","coverage"));
		shenOutPort.deliver(new FileNameObject(fileName+".shen","shen"));
		heipOutPort.deliver(new FileNameObject(fileName+".heip","heip"));
		npshannonOutPort.deliver(new FileNameObject(fileName+".npshannon","npshannon"));
		goodscoverageOutPort.deliver(new FileNameObject(fileName+".goodscoverage","goodscoverage"));
		shannonrangeOutPort.deliver(new FileNameObject(fileName+".shannonrange","shannonrange"));
		smithwilsonOutPort.deliver(new FileNameObject(fileName+".smithwilson","smithwilson"));
		efronOutPort.deliver(new FileNameObject(fileName+".efron","efron"));
		solowOutPort.deliver(new FileNameObject(fileName+".solow","solow"));
		shannonevenOutPort.deliver(new FileNameObject(fileName+".shannoneven","shannoneven"));
		invsimpsonOutPort.deliver(new FileNameObject(fileName+".invsimpson","invsimpson"));
		jackOutPort.deliver(new FileNameObject(fileName+".jack","jack"));
	}

	@Override
	public List<ParameterType> getParameterTypes() {
		List<ParameterType> parameterTypes = super.getParameterTypes();
		parameterTypes.add(new ParameterTypeInt(ABUND_LABEL, "TODO: Add description", -100000000, 100000000, 10, true));
		parameterTypes.add(new ParameterTypeCategory(ALPHA_LABEL, "TODO: Add description", ALPHA_CHOICES, ALPHA_DEFAULT_CHOICE));
		parameterTypes.add(new ParameterTypeCategory(CALC_LABEL, "TODO: Add description", CALC_CHOICES, CALC_DEFAULT_CHOICE));
		parameterTypes.add(new ParameterTypeInt(FREQ_LABEL, "TODO: Add description", -100000000, 100000000, 100, true));
		parameterTypes.add(new ParameterTypeString(INPUTDIR_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeString(LABEL_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeString(OUTPUTDIR_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeInt(SEED_LABEL, "TODO: Add description", -100000000, 100000000, 0, true));
		parameterTypes.add(new ParameterTypeInt(SIZE_LABEL, "TODO: Add description", -100000000, 100000000, 0, true));
		return parameterTypes;
	}

	@Override
	public String getOutputPattern(String type) {
		// TODO Use a dictionary to reflect type to pattern
		if (type=="sobs") return "[filename],sobs";
		if (type=="shannon") return "[filename],shannon";
		if (type=="simpson") return "[filename],simpson";
		if (type=="geometric") return "[filename],geometric";
		if (type=="bergerparker") return "[filename],bergerparker";
		if (type=="simpsoneven") return "[filename],simpsoneven";
		if (type=="qstat") return "[filename],qstat";
		if (type=="ace") return "[filename],ace";
		if (type=="logseries") return "[filename],logseries";
		if (type=="chao") return "[filename],chao";
		if (type=="nseqs") return "[filename],nseqs";
		if (type=="bstick") return "[filename],bstick";
		if (type=="boneh") return "[filename],boneh";
		if (type=="bootstrap") return "[filename],bootstrap";
		if (type=="coverage") return "[filename],coverage";
		if (type=="shen") return "[filename],shen";
		if (type=="heip") return "[filename],heip";
		if (type=="npshannon") return "[filename],npshannon";
		if (type=="goodscoverage") return "[filename],goodscoverage";
		if (type=="shannonrange") return "[filename],shannonrange";
		if (type=="smithwilson") return "[filename],smithwilson";
		if (type=="efron") return "[filename],efron";
		if (type=="solow") return "[filename],solow";
		if (type=="shannoneven") return "[filename],shannoneven";
		if (type=="invsimpson") return "[filename],invsimpson";
		if (type=="jack") return "[filename],jack";
		// TODO if nil then 
		return super.getOutputPattern(type);
	}
}
