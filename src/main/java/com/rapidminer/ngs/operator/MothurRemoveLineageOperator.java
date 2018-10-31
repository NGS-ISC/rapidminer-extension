package com.rapidminer.ngs.operator;

import java.util.List;
import com.rapidminer.operator.OperatorDescription;
import com.rapidminer.operator.ports.InputPort;
import com.rapidminer.operator.ports.OutputPort;
import com.rapidminer.operator.OperatorException;
import com.rapidminer.parameter.*;

public class MothurRemoveLineageOperator extends MothurGeneratedOperator {

	private InputPort fastaInPort = getInputPorts().createPort("fasta");
	private InputPort nameInPort = getInputPorts().createPort("name");
	private InputPort countInPort = getInputPorts().createPort("count");
	private InputPort groupInPort = getInputPorts().createPort("group");
	private InputPort listInPort = getInputPorts().createPort("list");
	private InputPort sharedInPort = getInputPorts().createPort("shared");
	private InputPort taxonomyInPort = getInputPorts().createPort("taxonomy");
	private InputPort constaxonomyInPort = getInputPorts().createPort("constaxonomy");
	private InputPort alignreportInPort = getInputPorts().createPort("alignreport");
	private OutputPort constaxonomyOutPort = getOutputPorts().createPort("constaxonomy");
	private OutputPort groupOutPort = getOutputPorts().createPort("group");
	private OutputPort listOutPort = getOutputPorts().createPort("list");
	private OutputPort taxonomyOutPort = getOutputPorts().createPort("taxonomy");
	private OutputPort fastaOutPort = getOutputPorts().createPort("fasta");
	private OutputPort countOutPort = getOutputPorts().createPort("count");
	private OutputPort sharedOutPort = getOutputPorts().createPort("shared");
	private OutputPort nameOutPort = getOutputPorts().createPort("name");
	private OutputPort alignreportOutPort = getOutputPorts().createPort("alignreport");
	private static final String LABEL_LABEL = "label:";
	private static final String TAXON_LABEL = "taxon:";
	private static final String DUPS_LABEL = "dups:";
	private static final String SEED_LABEL = "seed:";
	private static final String INPUTDIR_LABEL = "inputdir:";
	private static final String OUTPUTDIR_LABEL = "outputdir:";

	public MothurRemoveLineageOperator (OperatorDescription description) {
		super(description);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void doWork() throws OperatorException {
		super.doWork();
		clearArguments();
		FileNameObject fastaFile = fastaInPort.getData(FileNameObject.class);
		addArgument("fasta",fastaFile.getName());
		FileNameObject nameFile = nameInPort.getData(FileNameObject.class);
		addArgument("name",nameFile.getName());
		FileNameObject countFile = countInPort.getData(FileNameObject.class);
		addArgument("count",countFile.getName());
		FileNameObject groupFile = groupInPort.getData(FileNameObject.class);
		addArgument("group",groupFile.getName());
		FileNameObject listFile = listInPort.getData(FileNameObject.class);
		addArgument("list",listFile.getName());
		FileNameObject sharedFile = sharedInPort.getData(FileNameObject.class);
		addArgument("shared",sharedFile.getName());
		FileNameObject taxonomyFile = taxonomyInPort.getData(FileNameObject.class);
		addArgument("taxonomy",taxonomyFile.getName());
		FileNameObject constaxonomyFile = constaxonomyInPort.getData(FileNameObject.class);
		addArgument("constaxonomy",constaxonomyFile.getName());
		FileNameObject alignreportFile = alignreportInPort.getData(FileNameObject.class);
		addArgument("alignreport",alignreportFile.getName());
		String labelValue = getParameterAsString(LABEL_LABEL);
		addArgument("label",String.valueOf(labelValue));
		String taxonValue = getParameterAsString(TAXON_LABEL);
		addArgument("taxon",String.valueOf(taxonValue));
		boolean dupsValue = getParameterAsBoolean(DUPS_LABEL);
		addArgument("dups",String.valueOf(dupsValue));
		int seedValue = getParameterAsInt(SEED_LABEL);
		addArgument("seed",String.valueOf(seedValue));
		String inputdirValue = getParameterAsString(INPUTDIR_LABEL);
		addArgument("inputdir",String.valueOf(inputdirValue));
		String outputdirValue = getParameterAsString(OUTPUTDIR_LABEL);
		addArgument("outputdir",String.valueOf(outputdirValue));
		executeMothurCommand();
		String fileName="<fileName>"; // TODO: Somehow figure out the fileName
		constaxonomyOutPort.deliver(new FileNameObject(fileName+".constaxonomy","constaxonomy"));
		groupOutPort.deliver(new FileNameObject(fileName+".group","group"));
		listOutPort.deliver(new FileNameObject(fileName+".list","list"));
		taxonomyOutPort.deliver(new FileNameObject(fileName+".taxonomy","taxonomy"));
		fastaOutPort.deliver(new FileNameObject(fileName+".fasta","fasta"));
		countOutPort.deliver(new FileNameObject(fileName+".count","count"));
		sharedOutPort.deliver(new FileNameObject(fileName+".shared","shared"));
		nameOutPort.deliver(new FileNameObject(fileName+".name","name"));
		alignreportOutPort.deliver(new FileNameObject(fileName+".alignreport","alignreport"));
	}

	@Override
	public List<ParameterType> getParameterTypes() {
		List<ParameterType> parameterTypes = super.getParameterTypes();
		parameterTypes.add(new ParameterTypeString(LABEL_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeString(TAXON_LABEL, "TODO: Add description", "", false));
		parameterTypes.add(new ParameterTypeBoolean(DUPS_LABEL, "TODO: Add description", true, true));
		parameterTypes.add(new ParameterTypeInt(SEED_LABEL, "TODO: Add description", -100000000, 100000000, 0, true));
		parameterTypes.add(new ParameterTypeString(INPUTDIR_LABEL, "TODO: Add description", "", true));
		parameterTypes.add(new ParameterTypeString(OUTPUTDIR_LABEL, "TODO: Add description", "", true));
		return parameterTypes;
	}

	@Override
	public String getOutputPattern(String type) {
		// TODO Use a dictionary to reflect type to pattern
		if (type.equals("constaxonomy")) return "[filename],pick,[extension]";
		if (type.equals("group")) return "[filename],pick,[extension]";
		if (type.equals("list")) return "[filename],[distance],pick,[extension]";
		if (type.equals("taxonomy")) return "[filename],pick,[extension]";
		if (type.equals("fasta")) return "[filename],pick,[extension]";
		if (type.equals("count")) return "[filename],pick,[extension]";
		if (type.equals("shared")) return "[filename],[distance],pick,[extension]";
		if (type.equals("name")) return "[filename],pick,[extension]";
		if (type.equals("alignreport")) return "[filename],pick.align.report";
		// TODO if nil then 
		return super.getOutputPattern(type);
	}
}
