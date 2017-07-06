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
public class MothurUniqueOperator extends MothurOperator {

	/**
	 * @param description
	 */


    private InputPort fastaInPort = getInputPorts().createPort("fasta");
	private InputPort namesInPort = getInputPorts().createPort("names");

    private OutputPort fastaUniqueOutPort = getOutputPorts().createPort("unique.fasta");
	private OutputPort namesUniqueOutPort = getOutputPorts().createPort("unique.names");


	public MothurUniqueOperator(OperatorDescription description) {
		super(description);
		// TODO Auto-generated constructor stub
	}

}
