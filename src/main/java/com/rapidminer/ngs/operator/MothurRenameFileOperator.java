package com.rapidminer.ngs.operator;

import java.util.List;
import com.rapidminer.operator.OperatorDescription;
import com.rapidminer.operator.ports.InputPort;
import com.rapidminer.operator.ports.OutputPort;
import com.rapidminer.operator.OperatorException;
import com.rapidminer.parameter.*;

public class MothurRenameFileOperator extends MothurGeneratedOperator {

	private InputPort accnosInPort = getInputPorts().createPort("accnos");
	private InputPort biomInPort = getInputPorts().createPort("biom");
	private InputPort columnInPort = getInputPorts().createPort("column");
	private InputPort constaxonomyInPort = getInputPorts().createPort("constaxonomy");
	private InputPort countInPort = getInputPorts().createPort("count");
	private InputPort designInPort = getInputPorts().createPort("design");
	private InputPort fastaInPort = getInputPorts().createPort("fasta");
	private InputPort fileInPort = getInputPorts().createPort("file");
	private InputPort flowInPort = getInputPorts().createPort("flow");
	private InputPort groupInPort = getInputPorts().createPort("group");
	private InputPort inputInPort = getInputPorts().createPort("input");
	private InputPort listInPort = getInputPorts().createPort("list");
	private InputPort nameInPort = getInputPorts().createPort("name");
	private InputPort newInPort = getInputPorts().createPort("new");
	private InputPort oligosInPort = getInputPorts().createPort("oligos");
	private InputPort orderInPort = getInputPorts().createPort("order");
	private InputPort phylipInPort = getInputPorts().createPort("phylip");
	private InputPort qfileInPort = getInputPorts().createPort("qfile");
	private InputPort rabundInPort = getInputPorts().createPort("rabund");
	private InputPort relabundInPort = getInputPorts().createPort("relabund");
	private InputPort sabundInPort = getInputPorts().createPort("sabund");
	private InputPort sffInPort = getInputPorts().createPort("sff");
	private InputPort sharedInPort = getInputPorts().createPort("shared");
	private InputPort summaryInPort = getInputPorts().createPort("summary");
	private InputPort taxonomyInPort = getInputPorts().createPort("taxonomy");
	private InputPort treeInPort = getInputPorts().createPort("tree");
	private static final String DELETEOLD_LABEL = "deleteold:";
	private static final String INPUTDIR_LABEL = "inputdir:";
	private static final String OUTPUTDIR_LABEL = "outputdir:";
	private static final String PREFIX_LABEL = "prefix:";
	private static final String SEED_LABEL = "seed:";
	private static final String SHORTEN_LABEL = "shorten:";

	public MothurRenameFileOperator (OperatorDescription description) {
		super(description);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void doWork() throws OperatorException {
		super.doWork();
		clearArguments();
		FileNameObject accnosFile = accnosInPort.getData(FileNameObject.class);
		addArgument("accnos",accnosFile.getName());
		FileNameObject biomFile = biomInPort.getData(FileNameObject.class);
		addArgument("biom",biomFile.getName());
		FileNameObject columnFile = columnInPort.getData(FileNameObject.class);
		addArgument("column",columnFile.getName());
		FileNameObject constaxonomyFile = constaxonomyInPort.getData(FileNameObject.class);
		addArgument("constaxonomy",constaxonomyFile.getName());
		FileNameObject countFile = countInPort.getData(FileNameObject.class);
		addArgument("count",countFile.getName());
		FileNameObject designFile = designInPort.getData(FileNameObject.class);
		addArgument("design",designFile.getName());
		FileNameObject fastaFile = fastaInPort.getData(FileNameObject.class);
		addArgument("fasta",fastaFile.getName());
		FileNameObject fileFile = fileInPort.getData(FileNameObject.class);
		addArgument("file",fileFile.getName());
		FileNameObject flowFile = flowInPort.getData(FileNameObject.class);
		addArgument("flow",flowFile.getName());
		FileNameObject groupFile = groupInPort.getData(FileNameObject.class);
		addArgument("group",groupFile.getName());
		FileNameObject inputFile = inputInPort.getData(FileNameObject.class);
		addArgument("input",inputFile.getName());
		FileNameObject listFile = listInPort.getData(FileNameObject.class);
		addArgument("list",listFile.getName());
		FileNameObject nameFile = nameInPort.getData(FileNameObject.class);
		addArgument("name",nameFile.getName());
		FileNameObject newFile = newInPort.getData(FileNameObject.class);
		addArgument("new",newFile.getName());
		FileNameObject oligosFile = oligosInPort.getData(FileNameObject.class);
		addArgument("oligos",oligosFile.getName());
		FileNameObject orderFile = orderInPort.getData(FileNameObject.class);
		addArgument("order",orderFile.getName());
		FileNameObject phylipFile = phylipInPort.getData(FileNameObject.class);
		addArgument("phylip",phylipFile.getName());
		FileNameObject qfileFile = qfileInPort.getData(FileNameObject.class);
		addArgument("qfile",qfileFile.getName());
		FileNameObject rabundFile = rabundInPort.getData(FileNameObject.class);
		addArgument("rabund",rabundFile.getName());
		FileNameObject relabundFile = relabundInPort.getData(FileNameObject.class);
		addArgument("relabund",relabundFile.getName());
		FileNameObject sabundFile = sabundInPort.getData(FileNameObject.class);
		addArgument("sabund",sabundFile.getName());
		FileNameObject sffFile = sffInPort.getData(FileNameObject.class);
		addArgument("sff",sffFile.getName());
		FileNameObject sharedFile = sharedInPort.getData(FileNameObject.class);
		addArgument("shared",sharedFile.getName());
		FileNameObject summaryFile = summaryInPort.getData(FileNameObject.class);
		addArgument("summary",summaryFile.getName());
		FileNameObject taxonomyFile = taxonomyInPort.getData(FileNameObject.class);
		addArgument("taxonomy",taxonomyFile.getName());
		FileNameObject treeFile = treeInPort.getData(FileNameObject.class);
		addArgument("tree",treeFile.getName());
		boolean deleteoldValue = getParameterAsBoolean(DELETEOLD_LABEL);
		addArgument("deleteold",String.valueOf(deleteoldValue));
		String inputdirValue = getParameterAsString(INPUTDIR_LABEL);
		addArgument("inputdir",String.valueOf(inputdirValue));
		String outputdirValue = getParameterAsString(OUTPUTDIR_LABEL);
		addArgument("outputdir",String.valueOf(outputdirValue));
		String prefixValue = getParameterAsString(PREFIX_LABEL);
		addArgument("prefix",String.valueOf(prefixValue));
		int seedValue = getParameterAsInt(SEED_LABEL);
		addArgument("seed",String.valueOf(seedValue));
		boolean shortenValue = getParameterAsBoolean(SHORTEN_LABEL);
		addArgument("shorten",String.valueOf(shortenValue));
		executeMothurCommand();
		String fileName="<fileName>"; // TODO: Somehow figure out the fileName
	}

	@Override
	public List<ParameterType> getParameterTypes() {
		List<ParameterType> parameterTypes = super.getParameterTypes();
		parameterTypes.add(new ParameterTypeBoolean(DELETEOLD_LABEL, "TODO: Add description", true, true));
		parameterTypes.add(new ParameterTypeString(INPUTDIR_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeString(OUTPUTDIR_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeString(PREFIX_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeInt(SEED_LABEL, "TODO: Add description", -100000000, 100000000, 0, true));
		parameterTypes.add(new ParameterTypeBoolean(SHORTEN_LABEL, "TODO: Add description", true, true));
		return parameterTypes;
	}

	@Override
	public String getOutputPattern(String type) {
		// TODO Use a dictionary to reflect type to pattern
		// TODO if nil then 
		return super.getOutputPattern(type);
	}
}
