package com.rapidminer.ngs.operator;

import java.util.List;
import com.rapidminer.operator.OperatorDescription;
import com.rapidminer.operator.ports.InputPort;
import com.rapidminer.operator.ports.OutputPort;
import com.rapidminer.operator.OperatorException;
import com.rapidminer.parameter.*;

public class MothurCollectSharedOperator extends MothurGeneratedOperator {

	private InputPort sharedInPort = getInputPorts().createPort("shared");
	private OutputPort anderbergOutPort = getOutputPorts().createPort("anderberg");
	private OutputPort braycurtisOutPort = getOutputPorts().createPort("braycurtis");
	private OutputPort canberraOutPort = getOutputPorts().createPort("canberra");
	private OutputPort gowerOutPort = getOutputPorts().createPort("gower");
	private OutputPort hammingOutPort = getOutputPorts().createPort("hamming");
	private OutputPort hellingerOutPort = getOutputPorts().createPort("hellinger");
	private OutputPort jabundOutPort = getOutputPorts().createPort("jabund");
	private OutputPort jclassOutPort = getOutputPorts().createPort("jclass");
	private OutputPort jestOutPort = getOutputPorts().createPort("jest");
	private OutputPort jsdOutPort = getOutputPorts().createPort("jsd");
	private OutputPort kstestOutPort = getOutputPorts().createPort("kstest");
	private OutputPort kulczynskiOutPort = getOutputPorts().createPort("kulczynski");
	private OutputPort kulczynskicodyOutPort = getOutputPorts().createPort("kulczynskicody");
	private OutputPort lennonOutPort = getOutputPorts().createPort("lennon");
	private OutputPort manhattanOutPort = getOutputPorts().createPort("manhattan");
	private OutputPort memchi2OutPort = getOutputPorts().createPort("memchi2");
	private OutputPort memchordOutPort = getOutputPorts().createPort("memchord");
	private OutputPort memeuclideanOutPort = getOutputPorts().createPort("memeuclidean");
	private OutputPort mempearsonOutPort = getOutputPorts().createPort("mempearson");
	private OutputPort morisitahornOutPort = getOutputPorts().createPort("morisitahorn");
	private OutputPort ochiaiOutPort = getOutputPorts().createPort("ochiai");
	private OutputPort odumOutPort = getOutputPorts().createPort("odum");
	private OutputPort rjsdOutPort = getOutputPorts().createPort("rjsd");
	private OutputPort sharedaceOutPort = getOutputPorts().createPort("sharedace");
	private OutputPort sharedchaoOutPort = getOutputPorts().createPort("sharedchao");
	private OutputPort sharednseqsOutPort = getOutputPorts().createPort("sharednseqs");
	private OutputPort sharedsobsOutPort = getOutputPorts().createPort("sharedsobs");
	private OutputPort soergelOutPort = getOutputPorts().createPort("soergel");
	private OutputPort sorabundOutPort = getOutputPorts().createPort("sorabund");
	private OutputPort sorclassOutPort = getOutputPorts().createPort("sorclass");
	private OutputPort sorestOutPort = getOutputPorts().createPort("sorest");
	private OutputPort spearmanOutPort = getOutputPorts().createPort("spearman");
	private OutputPort speciesprofileOutPort = getOutputPorts().createPort("speciesprofile");
	private OutputPort structchi2OutPort = getOutputPorts().createPort("structchi2");
	private OutputPort structchordOutPort = getOutputPorts().createPort("structchord");
	private OutputPort structeuclideanOutPort = getOutputPorts().createPort("structeuclidean");
	private OutputPort structkulczynskiOutPort = getOutputPorts().createPort("structkulczynski");
	private OutputPort structpearsonOutPort = getOutputPorts().createPort("structpearson");
	private OutputPort thetanOutPort = getOutputPorts().createPort("thetan");
	private OutputPort thetaycOutPort = getOutputPorts().createPort("thetayc");
	private OutputPort whittakerOutPort = getOutputPorts().createPort("whittaker");
	private static final String LABEL_LABEL = "label:";
	private static final String FREQ_LABEL = "freq:";
	private static final String[] CALC_CHOICES = { "sharedchao", "sharedsobs", "sharedace", "jabund", "sorabund", "jclass", "sorclass", "jest", "sorest", "thetayc", "thetan", "kstest", "whittaker", "sharednseqs", "ochiai", "anderberg", "kulczynski", "kulczynskicody", "lennon", "morisitahorn", "braycurtis", "odum", "canberra", "structeuclidean", "structchord", "hellinger", "manhattan", "structpearson", "soergel", "spearman", "structkulczynski", "speciesprofile", "structchi2", "hamming", "gower", "memchi2", "memchord", "memeuclidean", "mempearson", "jsd", "rjsd" };
	private static final int CALC_DEFAULT_CHOICE = 0;
	private static final String CALC_LABEL = "calc:";
	private static final String ALL_LABEL = "all:";
	private static final String GROUPS_LABEL = "groups:";
	private static final String SEED_LABEL = "seed:";
	private static final String INPUTDIR_LABEL = "inputdir:";
	private static final String OUTPUTDIR_LABEL = "outputdir:";

	public MothurCollectSharedOperator (OperatorDescription description) {
		super(description);
		// NOTE: Auto-generated constructor stub
	}

	@Override
	public void doWork() throws OperatorException {
		super.doWork();
		clearArguments();
		FileNameObject sharedFile = sharedInPort.getData(FileNameObject.class);
		addArgument("shared",sharedFile.getName());
		String labelValue = getParameterAsString(LABEL_LABEL);
		addArgument("label",String.valueOf(labelValue));
		int freqValue = getParameterAsInt(FREQ_LABEL);
		addArgument("freq",String.valueOf(freqValue));
		int calcIndex = getParameterAsInt(CALC_LABEL);
		String calcValue = CALC_CHOICES[calcIndex];
		addArgument("calc",String.valueOf(calcValue));
		boolean allValue = getParameterAsBoolean(ALL_LABEL);
		addArgument("all",String.valueOf(allValue));
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
		anderbergOutPort.deliver(new FileNameObject(fileName+".anderberg","anderberg"));
		braycurtisOutPort.deliver(new FileNameObject(fileName+".braycurtis","braycurtis"));
		canberraOutPort.deliver(new FileNameObject(fileName+".canberra","canberra"));
		gowerOutPort.deliver(new FileNameObject(fileName+".gower","gower"));
		hammingOutPort.deliver(new FileNameObject(fileName+".hamming","hamming"));
		hellingerOutPort.deliver(new FileNameObject(fileName+".hellinger","hellinger"));
		jabundOutPort.deliver(new FileNameObject(fileName+".jabund","jabund"));
		jclassOutPort.deliver(new FileNameObject(fileName+".jclass","jclass"));
		jestOutPort.deliver(new FileNameObject(fileName+".jest","jest"));
		jsdOutPort.deliver(new FileNameObject(fileName+".jsd","jsd"));
		kstestOutPort.deliver(new FileNameObject(fileName+".kstest","kstest"));
		kulczynskiOutPort.deliver(new FileNameObject(fileName+".kulczynski","kulczynski"));
		kulczynskicodyOutPort.deliver(new FileNameObject(fileName+".kulczynskicody","kulczynskicody"));
		lennonOutPort.deliver(new FileNameObject(fileName+".lennon","lennon"));
		manhattanOutPort.deliver(new FileNameObject(fileName+".manhattan","manhattan"));
		memchi2OutPort.deliver(new FileNameObject(fileName+".memchi2","memchi2"));
		memchordOutPort.deliver(new FileNameObject(fileName+".memchord","memchord"));
		memeuclideanOutPort.deliver(new FileNameObject(fileName+".memeuclidean","memeuclidean"));
		mempearsonOutPort.deliver(new FileNameObject(fileName+".mempearson","mempearson"));
		morisitahornOutPort.deliver(new FileNameObject(fileName+".morisitahorn","morisitahorn"));
		ochiaiOutPort.deliver(new FileNameObject(fileName+".ochiai","ochiai"));
		odumOutPort.deliver(new FileNameObject(fileName+".odum","odum"));
		rjsdOutPort.deliver(new FileNameObject(fileName+".rjsd","rjsd"));
		sharedaceOutPort.deliver(new FileNameObject(fileName+".sharedace","sharedace"));
		sharedchaoOutPort.deliver(new FileNameObject(fileName+".sharedchao","sharedchao"));
		sharednseqsOutPort.deliver(new FileNameObject(fileName+".sharednseqs","sharednseqs"));
		sharedsobsOutPort.deliver(new FileNameObject(fileName+".sharedsobs","sharedsobs"));
		soergelOutPort.deliver(new FileNameObject(fileName+".soergel","soergel"));
		sorabundOutPort.deliver(new FileNameObject(fileName+".sorabund","sorabund"));
		sorclassOutPort.deliver(new FileNameObject(fileName+".sorclass","sorclass"));
		sorestOutPort.deliver(new FileNameObject(fileName+".sorest","sorest"));
		spearmanOutPort.deliver(new FileNameObject(fileName+".spearman","spearman"));
		speciesprofileOutPort.deliver(new FileNameObject(fileName+".speciesprofile","speciesprofile"));
		structchi2OutPort.deliver(new FileNameObject(fileName+".structchi2","structchi2"));
		structchordOutPort.deliver(new FileNameObject(fileName+".structchord","structchord"));
		structeuclideanOutPort.deliver(new FileNameObject(fileName+".structeuclidean","structeuclidean"));
		structkulczynskiOutPort.deliver(new FileNameObject(fileName+".structkulczynski","structkulczynski"));
		structpearsonOutPort.deliver(new FileNameObject(fileName+".structpearson","structpearson"));
		thetanOutPort.deliver(new FileNameObject(fileName+".thetan","thetan"));
		thetaycOutPort.deliver(new FileNameObject(fileName+".thetayc","thetayc"));
		whittakerOutPort.deliver(new FileNameObject(fileName+".whittaker","whittaker"));
	}

	@Override
	public List<ParameterType> getParameterTypes() {
		List<ParameterType> parameterTypes = super.getParameterTypes();
		parameterTypes.add(new ParameterTypeString(LABEL_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeInt(FREQ_LABEL, "TODO: Add description", -100000000, 100000000, 100, true));
		parameterTypes.add(new ParameterTypeCategory(CALC_LABEL, "TODO: Add description", CALC_CHOICES, CALC_DEFAULT_CHOICE));
		parameterTypes.add(new ParameterTypeBoolean(ALL_LABEL, "TODO: Add description", false, true));
		parameterTypes.add(new ParameterTypeString(GROUPS_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeInt(SEED_LABEL, "TODO: Add description", -100000000, 100000000, 0, true));
		parameterTypes.add(new ParameterTypeString(INPUTDIR_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeString(OUTPUTDIR_LABEL, "TODO: Add description", "", true));
		return parameterTypes;
	}

	@Override
	public String getOutputPattern(String type) {
		if (type.equals("structeuclidean")) return "[filename],structeuclidean";
		if (type.equals("jsd")) return "[filename],jsd";
		if (type.equals("sorclass")) return "[filename],sorclass";
		if (type.equals("memeuclidean")) return "[filename],memeuclidean";
		if (type.equals("structchi2")) return "[filename],structchi2";
		if (type.equals("odum")) return "[filename],odum";
		if (type.equals("soergel")) return "[filename],soergel";
		if (type.equals("jclass")) return "[filename],jclass";
		if (type.equals("structpearson")) return "[filename],structpearson";
		if (type.equals("sharedsobs")) return "[filename],shared.sobs";
		if (type.equals("hamming")) return "[filename],hamming";
		if (type.equals("braycurtis")) return "[filename],braycurtis";
		if (type.equals("kulczynski")) return "[filename],kulczynski";
		if (type.equals("structchord")) return "[filename],structchord";
		if (type.equals("gower")) return "[filename],gower";
		if (type.equals("canberra")) return "[filename],canberra";
		if (type.equals("speciesprofile")) return "[filename],speciesprofile";
		if (type.equals("structkulczynski")) return "[filename],structkulczynski";
		if (type.equals("sharedchao")) return "[filename],shared.chao";
		if (type.equals("rjsd")) return "[filename],rjsd";
		if (type.equals("morisitahorn")) return "[filename],morisitahorn";
		if (type.equals("mempearson")) return "[filename],mempearson";
		if (type.equals("sorest")) return "[filename],sorest";
		if (type.equals("jest")) return "[filename],jest";
		if (type.equals("thetayc")) return "[filename],thetayc";
		if (type.equals("sharedace")) return "[filename],shared.ace";
		if (type.equals("whittaker")) return "[filename],whittaker";
		if (type.equals("ochiai")) return "[filename],ochiai";
		if (type.equals("kstest")) return "[filename],kstest";
		if (type.equals("sharednseqs")) return "[filename],shared.nseqs";
		if (type.equals("memchi2")) return "[filename],memchi2";
		if (type.equals("anderberg")) return "[filename],anderberg";
		if (type.equals("sorabund")) return "[filename],sorabund";
		if (type.equals("jabund")) return "[filename],jabund";
		if (type.equals("manhattan")) return "[filename],manhattan";
		if (type.equals("spearman")) return "[filename],spearman";
		if (type.equals("kulczynskicody")) return "[filename],kulczynskicody";
		if (type.equals("thetan")) return "[filename],thetan";
		if (type.equals("lennon")) return "[filename],lennon";
		if (type.equals("hellinger")) return "[filename],hellinger";
		if (type.equals("memchord")) return "[filename],memchord";
		return super.getOutputPattern(type);
	}
}
