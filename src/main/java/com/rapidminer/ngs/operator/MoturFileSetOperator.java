package com.rapidminer.ngs.operator;

import java.util.List;

import com.rapidminer.operator.Operator;
import com.rapidminer.operator.OperatorDescription;
import com.rapidminer.operator.OperatorException;
import com.rapidminer.operator.ports.InputPort;
import com.rapidminer.operator.ports.OutputPort;
import com.rapidminer.parameter.ParameterType;
import com.rapidminer.parameter.ParameterTypeString;


public class MoturFileSetOperator extends Operator {

	// private InputPort inputPort;
	// private OutputPort outputPort;

	/**
	 * Default operator constructor.
	 *
	 * @param description
	 *            the opreator description
	 */
	private static final String DOT_FASTA_LABEL = ".fasta Filename:";
	private static final String DOT_NAMES_LABEL = ".names Filename:";
	private static final String OLIGOS_LABEL = "oligos Filename:";
	private OutputPort dotFastaOutPort = getOutputPorts().createPort(".fasta");
	private OutputPort dotNamesOutPort= getOutputPorts().createPort(".names");
	private OutputPort oligosOutPort = getOutputPorts().createPort("oligos");
	
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
		String oligosName = getParameterAsString(OLIGOS_LABEL);
		oligosOutPort.deliver(new FileNameObject(oligosName, "Description of Oligos FileName", "oligos"));
	}

	@Override
	public List<ParameterType> getParameterTypes() {
		List<ParameterType> parameterTypes = super.getParameterTypes();

		// add parameter types here
		
		
	    parameterTypes.add(new ParameterTypeString(
		        OLIGOS_LABEL,
		        "This parameter defines an oligos file.",
		        "oligos",
		        false));
		return parameterTypes;
	}

}
