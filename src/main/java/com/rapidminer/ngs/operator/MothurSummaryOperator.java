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
public class MothurSummaryOperator extends MothurOperator {

	/**
	 * @param description
	 */


    private InputPort fastaInPort = getInputPorts().createPort("fasta");
	private InputPort namesInPort = getInputPorts().createPort("names");

	private OutputPort summaryOutPort = getOutputPorts().createPort("summary");

	public MothurSummaryOperator(OperatorDescription description) {
		super(description);
		// TODO Auto-generated constructor stub
	}

}
