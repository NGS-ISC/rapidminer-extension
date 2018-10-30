package com.rapidminer.ngs.operator;

import java.util.List;
import com.rapidminer.operator.OperatorDescription;
import com.rapidminer.operator.ports.InputPort;
import com.rapidminer.operator.ports.OutputPort;
import com.rapidminer.operator.OperatorException;
import com.rapidminer.parameter.*;

public class MothurGetLineageOperator extends MothurGeneratedOperator {

	private InputPort alignreportInPort = getInputPorts().createPort("alignreport");
	private InputPort constaxonomyInPort = getInputPorts().createPort("constaxonomy");
	private InputPort countInPort = getInputPorts().createPort("count");
	private InputPort fastaInPort = getInputPorts().createPort("fasta");
	private InputPort groupInPort = getInputPorts().createPort("group");
	private InputPort listInPort = getInputPorts().createPort("list");
	private InputPort nameInPort = getInputPorts().createPort("name");
	private InputPort sharedInPort = getInputPorts().createPort("shared");
	private InputPort taxonomyInPort = getInputPorts().createPort("taxonomy");
	private OutputPort countOutPort = getOutputPorts().createPort("count");
	private OutputPort fastaOutPort = getOutputPorts().createPort("fasta");
	private OutputPort sharedOutPort = getOutputPorts().createPort("shared");
	private OutputPort taxonomyOutPort = getOutputPorts().createPort("taxonomy");
	private OutputPort nameOutPort = getOutputPorts().createPort("name");
	private OutputPort listOutPort = getOutputPorts().createPort("list");
	private OutputPort alignreportOutPort = getOutputPorts().createPort("alignreport");
	private OutputPort groupOutPort = getOutputPorts().createPort("group");
	private OutputPort constaxonomyOutPort = getOutputPorts().createPort("constaxonomy");
	private static final String DUPS_LABEL = "dups:";
	private static final String INPUTDIR_LABEL = "inputdir:";
	private static final String LABEL_LABEL = "label:";
	private static final String OUTPUTDIR_LABEL = "outputdir:";
	private static final String SEED_LABEL = "seed:";
	private static final String TAXON_LABEL = "taxon:";

	public MothurGetLineageOperator (OperatorDescription description) {
		super(description);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void doWork() throws OperatorException {
		super.doWork();
		clearArguments();
		FileNameObject alignreportFile = alignreportInPort.getData(FileNameObject.class);
		addArgument("alignreport",alignreportFile.getName());
		FileNameObject constaxonomyFile = constaxonomyInPort.getData(FileNameObject.class);
		addArgument("constaxonomy",constaxonomyFile.getName());
		FileNameObject countFile = countInPort.getData(FileNameObject.class);
		addArgument("count",countFile.getName());
		FileNameObject fastaFile = fastaInPort.getData(FileNameObject.class);
		addArgument("fasta",fastaFile.getName());
		FileNameObject groupFile = groupInPort.getData(FileNameObject.class);
		addArgument("group",groupFile.getName());
		FileNameObject listFile = listInPort.getData(FileNameObject.class);
		addArgument("list",listFile.getName());
		FileNameObject nameFile = nameInPort.getData(FileNameObject.class);
		addArgument("name",nameFile.getName());
		FileNameObject sharedFile = sharedInPort.getData(FileNameObject.class);
		addArgument("shared",sharedFile.getName());
		FileNameObject taxonomyFile = taxonomyInPort.getData(FileNameObject.class);
		addArgument("taxonomy",taxonomyFile.getName());
		boolean dupsValue = getParameterAsBoolean(DUPS_LABEL);
		addArgument("dups",String.valueOf(dupsValue));
		String inputdirValue = getParameterAsString(INPUTDIR_LABEL);
		addArgument("inputdir",String.valueOf(inputdirValue));
		String labelValue = getParameterAsString(LABEL_LABEL);
		addArgument("label",String.valueOf(labelValue));
		String outputdirValue = getParameterAsString(OUTPUTDIR_LABEL);
		addArgument("outputdir",String.valueOf(outputdirValue));
		int seedValue = getParameterAsInt(SEED_LABEL);
		addArgument("seed",String.valueOf(seedValue));
		String taxonValue = getParameterAsString(TAXON_LABEL);
		addArgument("taxon",String.valueOf(taxonValue));
		executeMothurCommand();
		String fileName="<fileName>"; // TODO: Somehow figure out the fileName
		countOutPort.deliver(new FileNameObject(fileName+".count","count"));
		fastaOutPort.deliver(new FileNameObject(fileName+".fasta","fasta"));
		sharedOutPort.deliver(new FileNameObject(fileName+".shared","shared"));
		taxonomyOutPort.deliver(new FileNameObject(fileName+".taxonomy","taxonomy"));
		nameOutPort.deliver(new FileNameObject(fileName+".name","name"));
		listOutPort.deliver(new FileNameObject(fileName+".list","list"));
		alignreportOutPort.deliver(new FileNameObject(fileName+".alignreport","alignreport"));
		groupOutPort.deliver(new FileNameObject(fileName+".group","group"));
		constaxonomyOutPort.deliver(new FileNameObject(fileName+".constaxonomy","constaxonomy"));
	}

	@Override
	public List<ParameterType> getParameterTypes() {
		List<ParameterType> parameterTypes = super.getParameterTypes();
		parameterTypes.add(new ParameterTypeBoolean(DUPS_LABEL, "TODO: Add description", true, true));
		parameterTypes.add(new ParameterTypeString(INPUTDIR_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeString(LABEL_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeString(OUTPUTDIR_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeInt(SEED_LABEL, "TODO: Add description", -100000000, 100000000, 0, true));
		parameterTypes.add(new ParameterTypeString(TAXON_LABEL, "TODO: Add description", "", false));
		return parameterTypes;
	}

	@Override
	public String getOutputPattern(String type) {
		// TODO Use a dictionary to reflect type to pattern
		if (type=="count") return "[filename],pick,[extension]";
		if (type=="fasta") return "[filename],pick,[extension]";
		if (type=="shared") return "[filename],[distance],pick,[extension]";
		if (type=="taxonomy") return "[filename],pick,[extension]";
		if (type=="name") return "[filename],pick,[extension]";
		if (type=="list") return "[filename],[distance],pick,[extension]";
		if (type=="alignreport") return "[filename],pick.align.report";
		if (type=="group") return "[filename],pick,[extension]";
		if (type=="constaxonomy") return "[filename],pick,[extension]";
		// TODO if nil then 
		return super.getOutputPattern(type);
	}
}
