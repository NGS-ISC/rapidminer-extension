package com.rapidminer.ngs.operator;

import java.util.List;
import com.rapidminer.operator.OperatorDescription;
import com.rapidminer.operator.ports.InputPort;
import com.rapidminer.operator.ports.OutputPort;
import com.rapidminer.operator.OperatorException;
import com.rapidminer.parameter.*;

public class MothurTreeSharedOperator extends MothurGeneratedOperator {

	private InputPort sharedInPort = getInputPorts().createPort("shared");
	private InputPort phylipInPort = getInputPorts().createPort("phylip");
	private InputPort nameInPort = getInputPorts().createPort("name");
	private InputPort countInPort = getInputPorts().createPort("count");
	private InputPort columnInPort = getInputPorts().createPort("column");
	private OutputPort treeOutPort = getOutputPorts().createPort("tree");
	private static final String ITERS_LABEL = "iters:";
	private static final String SUBSAMPLE_LABEL = "subsample:";
	private static final String CUTOFF_LABEL = "cutoff:";
	private static final String PRECISION_LABEL = "precision:";
	private static final String LABEL_LABEL = "label:";
	private static final String GROUPS_LABEL = "groups:";
	private static final String[] CALC_CHOICES = { "sharedsobs", "sharedchao", "sharedace", "jabund", "sorabund", "jclass", "sorclass", "jest", "sorest", "thetayc", "thetan", "kstest", "sharednseqs", "ochiai", "anderberg", "kulczynski", "kulczynskicody", "lennon", "morisitahorn", "braycurtis", "whittaker", "odum", "canberra", "structeuclidean", "structchord", "hellinger", "manhattan", "structpearson", "soergel", "spearman", "structkulczynski", "speciesprofile", "hamming", "structchi2", "gower", "memchi2", "memchord", "memeuclidean", "mempearson", "jsd", "rjsd" };
	private static final int CALC_DEFAULT_CHOICE = 0;
	private static final String CALC_LABEL = "calc:";
	private static final String PROCESSORS_LABEL = "processors:";
	private static final String SEED_LABEL = "seed:";
	private static final String INPUTDIR_LABEL = "inputdir:";
	private static final String OUTPUTDIR_LABEL = "outputdir:";

	public MothurTreeSharedOperator (OperatorDescription description) {
		super(description);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void doWork() throws OperatorException {
		super.doWork();
		clearArguments();
		FileNameObject sharedFile = sharedInPort.getData(FileNameObject.class);
		addArgument("shared",sharedFile.getName());
		FileNameObject phylipFile = phylipInPort.getData(FileNameObject.class);
		addArgument("phylip",phylipFile.getName());
		FileNameObject nameFile = nameInPort.getData(FileNameObject.class);
		addArgument("name",nameFile.getName());
		FileNameObject countFile = countInPort.getData(FileNameObject.class);
		addArgument("count",countFile.getName());
		FileNameObject columnFile = columnInPort.getData(FileNameObject.class);
		addArgument("column",columnFile.getName());
		int itersValue = getParameterAsInt(ITERS_LABEL);
		addArgument("iters",String.valueOf(itersValue));
		String subsampleValue = getParameterAsString(SUBSAMPLE_LABEL);
		addArgument("subsample",String.valueOf(subsampleValue));
		int cutoffValue = getParameterAsInt(CUTOFF_LABEL);
		addArgument("cutoff",String.valueOf(cutoffValue));
		int precisionValue = getParameterAsInt(PRECISION_LABEL);
		addArgument("precision",String.valueOf(precisionValue));
		String labelValue = getParameterAsString(LABEL_LABEL);
		addArgument("label",String.valueOf(labelValue));
		String groupsValue = getParameterAsString(GROUPS_LABEL);
		addArgument("groups",String.valueOf(groupsValue));
		int calcIndex = getParameterAsInt(CALC_LABEL);
		String calcValue = CALC_CHOICES[calcIndex];
		addArgument("calc",String.valueOf(calcValue));
		int processorsValue = getParameterAsInt(PROCESSORS_LABEL);
		addArgument("processors",String.valueOf(processorsValue));
		int seedValue = getParameterAsInt(SEED_LABEL);
		addArgument("seed",String.valueOf(seedValue));
		String inputdirValue = getParameterAsString(INPUTDIR_LABEL);
		addArgument("inputdir",String.valueOf(inputdirValue));
		String outputdirValue = getParameterAsString(OUTPUTDIR_LABEL);
		addArgument("outputdir",String.valueOf(outputdirValue));
		executeMothurCommand();
		String fileName="<fileName>"; // TODO: Somehow figure out the fileName
		treeOutPort.deliver(new FileNameObject(fileName+".tree","tree"));
	}

	@Override
	public List<ParameterType> getParameterTypes() {
		List<ParameterType> parameterTypes = super.getParameterTypes();
		parameterTypes.add(new ParameterTypeInt(ITERS_LABEL, "TODO: Add description", -100000000, 100000000, 1000, true));
		parameterTypes.add(new ParameterTypeString(SUBSAMPLE_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeInt(CUTOFF_LABEL, "TODO: Add description", -100000000, 100000000, 10, true));
		parameterTypes.add(new ParameterTypeInt(PRECISION_LABEL, "TODO: Add description", -100000000, 100000000, 100, true));
		parameterTypes.add(new ParameterTypeString(LABEL_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeString(GROUPS_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeCategory(CALC_LABEL, "TODO: Add description", CALC_CHOICES, CALC_DEFAULT_CHOICE));
		parameterTypes.add(new ParameterTypeInt(PROCESSORS_LABEL, "TODO: Add description", -100000000, 100000000, 1, true));
		parameterTypes.add(new ParameterTypeInt(SEED_LABEL, "TODO: Add description", -100000000, 100000000, 0, true));
		parameterTypes.add(new ParameterTypeString(INPUTDIR_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeString(OUTPUTDIR_LABEL, "TODO: Add description", "", true));
		return parameterTypes;
	}

	@Override
	public String getOutputPattern(String type) {
		// TODO Use a dictionary to reflect type to pattern
		if (type.equals("tree")) return "[filename],[calc],[distance],[tag],tre-[filename],tre";
		// TODO if nil then 
		return super.getOutputPattern(type);
	}
}
