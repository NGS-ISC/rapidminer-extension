package com.rapidminer.ngs.operator;

import java.util.List;
import com.rapidminer.operator.OperatorDescription;
import com.rapidminer.operator.ports.InputPort;
import com.rapidminer.operator.ports.OutputPort;
import com.rapidminer.operator.OperatorException;
import com.rapidminer.parameter.*;

public class MothurCollectSharedOperator extends MothurGeneratedOperator {

	private InputPort sharedInPort = getInputPorts().createPort("shared");
	private OutputPort jsdOutPort = getOutputPorts().createPort("jsd");
	private OutputPort morisitahornOutPort = getOutputPorts().createPort("morisitahorn");
	private OutputPort odumOutPort = getOutputPorts().createPort("odum");
	private OutputPort mempearsonOutPort = getOutputPorts().createPort("mempearson");
	private OutputPort sorabundOutPort = getOutputPorts().createPort("sorabund");
	private OutputPort kulczynskiOutPort = getOutputPorts().createPort("kulczynski");
	private OutputPort memeuclideanOutPort = getOutputPorts().createPort("memeuclidean");
	private OutputPort memchi2OutPort = getOutputPorts().createPort("memchi2");
	private OutputPort manhattanOutPort = getOutputPorts().createPort("manhattan");
	private OutputPort speciesprofileOutPort = getOutputPorts().createPort("speciesprofile");
	private OutputPort hammingOutPort = getOutputPorts().createPort("hamming");
	private OutputPort jabundOutPort = getOutputPorts().createPort("jabund");
	private OutputPort structchi2OutPort = getOutputPorts().createPort("structchi2");
	private OutputPort spearmanOutPort = getOutputPorts().createPort("spearman");
	private OutputPort braycurtisOutPort = getOutputPorts().createPort("braycurtis");
	private OutputPort sorestOutPort = getOutputPorts().createPort("sorest");
	private OutputPort lennonOutPort = getOutputPorts().createPort("lennon");
	private OutputPort canberraOutPort = getOutputPorts().createPort("canberra");
	private OutputPort hellingerOutPort = getOutputPorts().createPort("hellinger");
	private OutputPort soergelOutPort = getOutputPorts().createPort("soergel");
	private OutputPort structchordOutPort = getOutputPorts().createPort("structchord");
	private OutputPort sharednseqsOutPort = getOutputPorts().createPort("sharednseqs");
	private OutputPort sharedaceOutPort = getOutputPorts().createPort("sharedace");
	private OutputPort rjsdOutPort = getOutputPorts().createPort("rjsd");
	private OutputPort whittakerOutPort = getOutputPorts().createPort("whittaker");
	private OutputPort thetaycOutPort = getOutputPorts().createPort("thetayc");
	private OutputPort structeuclideanOutPort = getOutputPorts().createPort("structeuclidean");
	private OutputPort sharedsobsOutPort = getOutputPorts().createPort("sharedsobs");
	private OutputPort anderbergOutPort = getOutputPorts().createPort("anderberg");
	private OutputPort sharedchaoOutPort = getOutputPorts().createPort("sharedchao");
	private OutputPort thetanOutPort = getOutputPorts().createPort("thetan");
	private OutputPort structpearsonOutPort = getOutputPorts().createPort("structpearson");
	private OutputPort kulczynskicodyOutPort = getOutputPorts().createPort("kulczynskicody");
	private OutputPort kstestOutPort = getOutputPorts().createPort("kstest");
	private OutputPort memchordOutPort = getOutputPorts().createPort("memchord");
	private OutputPort jestOutPort = getOutputPorts().createPort("jest");
	private OutputPort gowerOutPort = getOutputPorts().createPort("gower");
	private OutputPort structkulczynskiOutPort = getOutputPorts().createPort("structkulczynski");
	private OutputPort ochiaiOutPort = getOutputPorts().createPort("ochiai");
	private OutputPort sorclassOutPort = getOutputPorts().createPort("sorclass");
	private OutputPort jclassOutPort = getOutputPorts().createPort("jclass");
	private static final String ALL_LABEL = "all:";
	public static final String[] CALC_CHOICES = { "anderberg", "braycurtis", "canberra", "gower", "hamming", "hellinger", "jabund", "jclass", "jest", "jsd", "kstest", "kulczynski", "kulczynskicody", "lennon", "manhattan", "memchi2", "memchord", "memeuclidean", "mempearson", "morisitahorn", "ochiai", "odum", "rjsd", "sharedace", "sharedchao", "sharednseqs", "sharedsobs", "soergel", "sorabund", "sorclass", "sorest", "spearman", "speciesprofile", "structchi2", "structchord", "structeuclidean", "structkulczynski", "structpearson", "thetan", "thetayc", "whittaker" };
	public static final int CALC_DEFAULT_CHOICE = 0;
	private static final String CALC_LABEL = "calc:";
	private static final String FREQ_LABEL = "freq:";
	private static final String GROUPS_LABEL = "groups:";
	private static final String INPUTDIR_LABEL = "inputdir:";
	private static final String LABEL_LABEL = "label:";
	private static final String OUTPUTDIR_LABEL = "outputdir:";
	private static final String SEED_LABEL = "seed:";

	public MothurCollectSharedOperator (OperatorDescription description) {
		super(description);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void doWork() throws OperatorException {
		super.doWork();
		clearArguments();
		FileNameObject sharedFile = sharedInPort.getData(FileNameObject.class);
		addArgument("shared",sharedFile.getName());
		boolean allValue = getParameterAsBoolean(ALL_LABEL);
		addArgument("all",String.valueOf(allValue));
		int calcIndex = getParameterAsInt(CALC_LABEL);
		String calcValue = CALC_CHOICES[calcIndex];
		addArgument("calc",String.valueOf(calcValue));
		int freqValue = getParameterAsInt(FREQ_LABEL);
		addArgument("freq",String.valueOf(freqValue));
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
		jsdOutPort.deliver(new FileNameObject(fileName+".jsd","jsd"));
		morisitahornOutPort.deliver(new FileNameObject(fileName+".morisitahorn","morisitahorn"));
		odumOutPort.deliver(new FileNameObject(fileName+".odum","odum"));
		mempearsonOutPort.deliver(new FileNameObject(fileName+".mempearson","mempearson"));
		sorabundOutPort.deliver(new FileNameObject(fileName+".sorabund","sorabund"));
		kulczynskiOutPort.deliver(new FileNameObject(fileName+".kulczynski","kulczynski"));
		memeuclideanOutPort.deliver(new FileNameObject(fileName+".memeuclidean","memeuclidean"));
		memchi2OutPort.deliver(new FileNameObject(fileName+".memchi2","memchi2"));
		manhattanOutPort.deliver(new FileNameObject(fileName+".manhattan","manhattan"));
		speciesprofileOutPort.deliver(new FileNameObject(fileName+".speciesprofile","speciesprofile"));
		hammingOutPort.deliver(new FileNameObject(fileName+".hamming","hamming"));
		jabundOutPort.deliver(new FileNameObject(fileName+".jabund","jabund"));
		structchi2OutPort.deliver(new FileNameObject(fileName+".structchi2","structchi2"));
		spearmanOutPort.deliver(new FileNameObject(fileName+".spearman","spearman"));
		braycurtisOutPort.deliver(new FileNameObject(fileName+".braycurtis","braycurtis"));
		sorestOutPort.deliver(new FileNameObject(fileName+".sorest","sorest"));
		lennonOutPort.deliver(new FileNameObject(fileName+".lennon","lennon"));
		canberraOutPort.deliver(new FileNameObject(fileName+".canberra","canberra"));
		hellingerOutPort.deliver(new FileNameObject(fileName+".hellinger","hellinger"));
		soergelOutPort.deliver(new FileNameObject(fileName+".soergel","soergel"));
		structchordOutPort.deliver(new FileNameObject(fileName+".structchord","structchord"));
		sharednseqsOutPort.deliver(new FileNameObject(fileName+".sharednseqs","sharednseqs"));
		sharedaceOutPort.deliver(new FileNameObject(fileName+".sharedace","sharedace"));
		rjsdOutPort.deliver(new FileNameObject(fileName+".rjsd","rjsd"));
		whittakerOutPort.deliver(new FileNameObject(fileName+".whittaker","whittaker"));
		thetaycOutPort.deliver(new FileNameObject(fileName+".thetayc","thetayc"));
		structeuclideanOutPort.deliver(new FileNameObject(fileName+".structeuclidean","structeuclidean"));
		sharedsobsOutPort.deliver(new FileNameObject(fileName+".sharedsobs","sharedsobs"));
		anderbergOutPort.deliver(new FileNameObject(fileName+".anderberg","anderberg"));
		sharedchaoOutPort.deliver(new FileNameObject(fileName+".sharedchao","sharedchao"));
		thetanOutPort.deliver(new FileNameObject(fileName+".thetan","thetan"));
		structpearsonOutPort.deliver(new FileNameObject(fileName+".structpearson","structpearson"));
		kulczynskicodyOutPort.deliver(new FileNameObject(fileName+".kulczynskicody","kulczynskicody"));
		kstestOutPort.deliver(new FileNameObject(fileName+".kstest","kstest"));
		memchordOutPort.deliver(new FileNameObject(fileName+".memchord","memchord"));
		jestOutPort.deliver(new FileNameObject(fileName+".jest","jest"));
		gowerOutPort.deliver(new FileNameObject(fileName+".gower","gower"));
		structkulczynskiOutPort.deliver(new FileNameObject(fileName+".structkulczynski","structkulczynski"));
		ochiaiOutPort.deliver(new FileNameObject(fileName+".ochiai","ochiai"));
		sorclassOutPort.deliver(new FileNameObject(fileName+".sorclass","sorclass"));
		jclassOutPort.deliver(new FileNameObject(fileName+".jclass","jclass"));
	}

	@Override
	public List<ParameterType> getParameterTypes() {
		List<ParameterType> parameterTypes = super.getParameterTypes();
		parameterTypes.add(new ParameterTypeBoolean(ALL_LABEL, "TODO: Add description", false, true));
		parameterTypes.add(new ParameterTypeCategory(CALC_LABEL, "TODO: Add description", CALC_CHOICES, CALC_DEFAULT_CHOICE));
		parameterTypes.add(new ParameterTypeInt(FREQ_LABEL, "TODO: Add description", -100000000, 100000000, 100, true));
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
		if (type=="jsd") return "[filename],jsd";
		if (type=="morisitahorn") return "[filename],morisitahorn";
		if (type=="odum") return "[filename],odum";
		if (type=="mempearson") return "[filename],mempearson";
		if (type=="sorabund") return "[filename],sorabund";
		if (type=="kulczynski") return "[filename],kulczynski";
		if (type=="memeuclidean") return "[filename],memeuclidean";
		if (type=="memchi2") return "[filename],memchi2";
		if (type=="manhattan") return "[filename],manhattan";
		if (type=="speciesprofile") return "[filename],speciesprofile";
		if (type=="hamming") return "[filename],hamming";
		if (type=="jabund") return "[filename],jabund";
		if (type=="structchi2") return "[filename],structchi2";
		if (type=="spearman") return "[filename],spearman";
		if (type=="braycurtis") return "[filename],braycurtis";
		if (type=="sorest") return "[filename],sorest";
		if (type=="lennon") return "[filename],lennon";
		if (type=="canberra") return "[filename],canberra";
		if (type=="hellinger") return "[filename],hellinger";
		if (type=="soergel") return "[filename],soergel";
		if (type=="structchord") return "[filename],structchord";
		if (type=="sharednseqs") return "[filename],shared.nseqs";
		if (type=="sharedace") return "[filename],shared.ace";
		if (type=="rjsd") return "[filename],rjsd";
		if (type=="whittaker") return "[filename],whittaker";
		if (type=="thetayc") return "[filename],thetayc";
		if (type=="structeuclidean") return "[filename],structeuclidean";
		if (type=="sharedsobs") return "[filename],shared.sobs";
		if (type=="anderberg") return "[filename],anderberg";
		if (type=="sharedchao") return "[filename],shared.chao";
		if (type=="thetan") return "[filename],thetan";
		if (type=="structpearson") return "[filename],structpearson";
		if (type=="kulczynskicody") return "[filename],kulczynskicody";
		if (type=="kstest") return "[filename],kstest";
		if (type=="memchord") return "[filename],memchord";
		if (type=="jest") return "[filename],jest";
		if (type=="gower") return "[filename],gower";
		if (type=="structkulczynski") return "[filename],structkulczynski";
		if (type=="ochiai") return "[filename],ochiai";
		if (type=="sorclass") return "[filename],sorclass";
		if (type=="jclass") return "[filename],jclass";
		// TODO if nil then 
		return super.getOutputPattern(type);
	}
}
