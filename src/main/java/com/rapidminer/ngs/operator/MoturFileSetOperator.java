package com.rapidminer.ngs.operator;

import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.rapidminer.MacroHandler;
import com.rapidminer.operator.Operator;
import com.rapidminer.operator.OperatorDescription;
import com.rapidminer.operator.OperatorException;
import com.rapidminer.operator.ports.InputPort;
import com.rapidminer.operator.ports.OutputPort;
import com.rapidminer.parameter.ParameterType;
import com.rapidminer.parameter.ParameterTypeDirectory;
import com.rapidminer.parameter.ParameterTypeFile;
import com.rapidminer.parameter.ParameterTypeString;
import com.rapidminer.parameter.UndefinedParameterError;

public class MoturFileSetOperator extends Operator {

	// private InputPort inputPort;
	// private OutputPort outputPort;

	/**
	 * Default operator constructor.
	 *
	 * @param description
	 *            the opreator description
	 */
	private static final String DIRECTORY_LABEL = "File .fasta:";
	private static final String FASTA_LABEL = "File .fasta:";
	private static final String NAMES_LABEL = "File .names:";
	private static final String REFERENCE_FASTA_LABEL = "File reference.fasta:";
	private OutputPort fastaOutPort = getOutputPorts().createPort("fasta");
	private OutputPort namesOutPort = getOutputPorts().createPort("names");
	private OutputPort referenceFastaOutPort = getOutputPorts().createPort("reference.fasta");

	public MoturFileSetOperator(OperatorDescription description) {
		super(description);

		// create input and output ports
		// inputPort = getInputPorts().createPort("example input");
		// outputPort = getOutputPorts().createPort("example output");

		// transform meta data
		// getTransformer().addRule(new MDTransformationRule() {
		//
		// @Override
		// public void transformMD() {
		// // transform meta data here
		// }
		// });

	}

	@Override
	public void doWork() throws OperatorException {

		// ExampleSet data = inputPort.getData(ExampleSet.class);
		// // implement operator logic here
		// outputPort.deliver(data);
		String fastaName = getParameterAsString(FASTA_LABEL);
		String namesName = getParameterAsString(NAMES_LABEL);
		String referenceFastaName = getParameterAsString(REFERENCE_FASTA_LABEL);
		fastaOutPort.deliver(new FileNameObject(fastaName, "fasta"));
		namesOutPort.deliver(new FileNameObject(namesName, "names"));
		referenceFastaOutPort.deliver(new FileNameObject(referenceFastaName, "fasta"));
	}

	@Override
	public List<ParameterType> getParameterTypes() {
		List<ParameterType> parameterTypes = super.getParameterTypes();

		// add parameter types here

		parameterTypes.add(new ParameterTypeDirectory(DIRECTORY_LABEL,
				"A project directory, containing the file set.",
				false));

		parameterTypes.add(new ParameterTypeFile(FASTA_LABEL,
				"File of .fasta format, containing ...",
				"fasta",
				"file.fasta"));

		parameterTypes.add(new ParameterTypeFile(NAMES_LABEL,
				"File of .fasta format, containing ...",
				"names",
				"file.names"));
		parameterTypes.add(new ParameterTypeFile(REFERENCE_FASTA_LABEL,
				"File of .fasta format, containing reference data",
				"fasta",
				"reference.fasta"));

		return parameterTypes;
	}

}
