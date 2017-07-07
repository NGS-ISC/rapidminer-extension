/**
 *
 */
package com.rapidminer.ngs.operator;

import com.rapidminer.operator.OperatorDescription;
import com.rapidminer.operator.ports.InputPort;
import com.rapidminer.operator.ports.OutputPort;

/**
 * @author eugeneai
 *
 */
public class MothurFilterOperator extends MothurOperator {

	/**
	 * @param description
	 */


    private InputPort alignInPort = getInputPorts().createPort("align");
	// private InputPort namesInPort = getInputPorts().createPort("fasta"); // FIXME: fasta внутри align?

	private OutputPort filterFastaOutPort = getOutputPorts().createPort("filter.fasta");
    private OutputPort filterOutPort = getOutputPorts().createPort("filter");


	public MothurFilterOperator(OperatorDescription description) {
		super(description);
		// TODO Auto-generated constructor stub
	}

}
