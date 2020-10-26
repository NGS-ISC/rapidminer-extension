package com.rapidminer.ngs.operator;

import java.util.List;
import com.rapidminer.operator.OperatorDescription;
import com.rapidminer.operator.ports.InputPort;
import com.rapidminer.operator.ports.OutputPort;
import com.rapidminer.operator.OperatorException;
import com.rapidminer.parameter.*;

public class MothurRarefactionSingleOperator extends MothurGeneratedOperator {

	private InputPort listInPort = getInputPorts().createPort("list");
	private InputPort rabundInPort = getInputPorts().createPort("rabund");
	private InputPort sabundInPort = getInputPorts().createPort("sabund");
	private InputPort sharedInPort = getInputPorts().createPort("shared");
	private OutputPort r_aceOutPort = getOutputPorts().createPort("r_ace");
	private OutputPort r_bootstrapOutPort = getOutputPorts().createPort("r_bootstrap");
	private OutputPort r_chaoOutPort = getOutputPorts().createPort("r_chao");
	private OutputPort r_coverageOutPort = getOutputPorts().createPort("r_coverage");
	private OutputPort r_heipOutPort = getOutputPorts().createPort("r_heip");
	private OutputPort r_invsimpsonOutPort = getOutputPorts().createPort("r_invsimpson");
	private OutputPort r_jackOutPort = getOutputPorts().createPort("r_jack");
	private OutputPort r_npshannonOutPort = getOutputPorts().createPort("r_npshannon");
	private OutputPort r_nseqsOutPort = getOutputPorts().createPort("r_nseqs");
	private OutputPort r_shannonOutPort = getOutputPorts().createPort("r_shannon");
	private OutputPort r_shannonevenOutPort = getOutputPorts().createPort("r_shannoneven");
	private OutputPort r_shannonrangeOutPort = getOutputPorts().createPort("r_shannonrange");
	private OutputPort r_simpsonOutPort = getOutputPorts().createPort("r_simpson");
	private OutputPort r_simpsonevenOutPort = getOutputPorts().createPort("r_simpsoneven");
	private OutputPort r_smithwilsonOutPort = getOutputPorts().createPort("r_smithwilson");
	private OutputPort rarefactionOutPort = getOutputPorts().createPort("rarefaction");
	private static final String GROUPS_LABEL = "groups:";
	private static final String LABEL_LABEL = "label:";
	private static final String FREQ_LABEL = "freq:";
	private static final String ITERS_LABEL = "iters:";
	private static final String[] CALC_CHOICES = { "sobs", "chao", "nseqs", "coverage", "ace", "jack", "shannon", "shannoneven", "npshannon", "heip", "smithwilson", "simpson", "simpsoneven", "invsimpson", "bootstrap", "shannonrange" };
	private static final int CALC_DEFAULT_CHOICE = 0;
	private static final String CALC_LABEL = "calc:";
	private static final String ABUND_LABEL = "abund:";
	private static final String[] ALPHA_CHOICES = { "0", "1", "2" };
	private static final int ALPHA_DEFAULT_CHOICE = 1;
	private static final String ALPHA_LABEL = "alpha:";
	private static final String GROUPMODE_LABEL = "groupmode:";
	private static final String SEED_LABEL = "seed:";
	private static final String PROCESSORS_LABEL = "processors:";
	private static final String INPUTDIR_LABEL = "inputdir:";
	private static final String OUTPUTDIR_LABEL = "outputdir:";

	public MothurRarefactionSingleOperator (OperatorDescription description) {
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
		String groupsValue = getParameterAsString(GROUPS_LABEL);
		addArgument("groups",String.valueOf(groupsValue));
		String labelValue = getParameterAsString(LABEL_LABEL);
		addArgument("label",String.valueOf(labelValue));
		int freqValue = getParameterAsInt(FREQ_LABEL);
		addArgument("freq",String.valueOf(freqValue));
		int itersValue = getParameterAsInt(ITERS_LABEL);
		addArgument("iters",String.valueOf(itersValue));
		int calcIndex = getParameterAsInt(CALC_LABEL);
		String calcValue = CALC_CHOICES[calcIndex];
		addArgument("calc",String.valueOf(calcValue));
		int abundValue = getParameterAsInt(ABUND_LABEL);
		addArgument("abund",String.valueOf(abundValue));
		int alphaIndex = getParameterAsInt(ALPHA_LABEL);
		String alphaValue = ALPHA_CHOICES[alphaIndex];
		addArgument("alpha",String.valueOf(alphaValue));
		boolean groupmodeValue = getParameterAsBoolean(GROUPMODE_LABEL);
		addArgument("groupmode",String.valueOf(groupmodeValue));
		int seedValue = getParameterAsInt(SEED_LABEL);
		addArgument("seed",String.valueOf(seedValue));
		int processorsValue = getParameterAsInt(PROCESSORS_LABEL);
		addArgument("processors",String.valueOf(processorsValue));
		String inputdirValue = getParameterAsString(INPUTDIR_LABEL);
		addArgument("inputdir",String.valueOf(inputdirValue));
		String outputdirValue = getParameterAsString(OUTPUTDIR_LABEL);
		addArgument("outputdir",String.valueOf(outputdirValue));
		executeMothurCommand();
		String fileName="<fileName>"; // TODO: Somehow figure out the fileName
		r_aceOutPort.deliver(new FileNameObject(fileName+".r_ace","r_ace"));
		r_bootstrapOutPort.deliver(new FileNameObject(fileName+".r_bootstrap","r_bootstrap"));
		r_chaoOutPort.deliver(new FileNameObject(fileName+".r_chao","r_chao"));
		r_coverageOutPort.deliver(new FileNameObject(fileName+".r_coverage","r_coverage"));
		r_heipOutPort.deliver(new FileNameObject(fileName+".r_heip","r_heip"));
		r_invsimpsonOutPort.deliver(new FileNameObject(fileName+".r_invsimpson","r_invsimpson"));
		r_jackOutPort.deliver(new FileNameObject(fileName+".r_jack","r_jack"));
		r_npshannonOutPort.deliver(new FileNameObject(fileName+".r_npshannon","r_npshannon"));
		r_nseqsOutPort.deliver(new FileNameObject(fileName+".r_nseqs","r_nseqs"));
		r_shannonOutPort.deliver(new FileNameObject(fileName+".r_shannon","r_shannon"));
		r_shannonevenOutPort.deliver(new FileNameObject(fileName+".r_shannoneven","r_shannoneven"));
		r_shannonrangeOutPort.deliver(new FileNameObject(fileName+".r_shannonrange","r_shannonrange"));
		r_simpsonOutPort.deliver(new FileNameObject(fileName+".r_simpson","r_simpson"));
		r_simpsonevenOutPort.deliver(new FileNameObject(fileName+".r_simpsoneven","r_simpsoneven"));
		r_smithwilsonOutPort.deliver(new FileNameObject(fileName+".r_smithwilson","r_smithwilson"));
		rarefactionOutPort.deliver(new FileNameObject(fileName+".rarefaction","rarefaction"));
	}

	@Override
	public List<ParameterType> getParameterTypes() {
		List<ParameterType> parameterTypes = super.getParameterTypes();
		parameterTypes.add(new ParameterTypeString(GROUPS_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeString(LABEL_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeInt(FREQ_LABEL, "TODO: Add description", -100000000, 100000000, 100, true));
		parameterTypes.add(new ParameterTypeInt(ITERS_LABEL, "TODO: Add description", -100000000, 100000000, 1000, true));
		parameterTypes.add(new ParameterTypeCategory(CALC_LABEL, "TODO: Add description", CALC_CHOICES, CALC_DEFAULT_CHOICE));
		parameterTypes.add(new ParameterTypeInt(ABUND_LABEL, "TODO: Add description", -100000000, 100000000, 10, true));
		parameterTypes.add(new ParameterTypeCategory(ALPHA_LABEL, "TODO: Add description", ALPHA_CHOICES, ALPHA_DEFAULT_CHOICE));
		parameterTypes.add(new ParameterTypeBoolean(GROUPMODE_LABEL, "TODO: Add description", true, true));
		parameterTypes.add(new ParameterTypeInt(SEED_LABEL, "TODO: Add description", -100000000, 100000000, 0, true));
		parameterTypes.add(new ParameterTypeInt(PROCESSORS_LABEL, "TODO: Add description", -100000000, 100000000, 1, true));
		parameterTypes.add(new ParameterTypeString(INPUTDIR_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeString(OUTPUTDIR_LABEL, "TODO: Add description", "", true));
		return parameterTypes;
	}

	@Override
	public String getOutputPattern(String type) {
		if (type.equals("r_jack")) return "[filename],r_jack";
		if (type.equals("r_npshannon")) return "[filename],r_npshannon";
		if (type.equals("rarefaction")) return "[filename],rarefaction";
		if (type.equals("r_chao")) return "[filename],r_chao";
		if (type.equals("r_shannon")) return "[filename],r_shannon";
		if (type.equals("r_shannoneven")) return "[filename],r_shannoneven";
		if (type.equals("r_ace")) return "[filename],r_ace";
		if (type.equals("r_invsimpson")) return "[filename],r_invsimpson";
		if (type.equals("r_simpsoneven")) return "[filename],r_simpsoneven";
		if (type.equals("r_shannonrange")) return "[filename],r_shannonrange";
		if (type.equals("r_simpson")) return "[filename],r_simpson";
		if (type.equals("r_nseqs")) return "[filename],r_nseqs";
		if (type.equals("r_coverage")) return "[filename],r_coverage";
		if (type.equals("r_smithwilson")) return "[filename],r_smithwilson";
		if (type.equals("r_bootstrap")) return "[filename],r_bootstrap";
		if (type.equals("r_heip")) return "[filename],r_heip";
		return super.getOutputPattern(type);
	}
}
