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
public class MothurPreOperator extends MothurOperator {

	/**
	 * @param description
	 */


    private InputPort fastaInPort = getInputPorts().createPort("fasta");
	private InputPort namesInPort = getInputPorts().createPort("names");
	private InputPort groupsInPort = getInputPorts().createPort("groups");

    private OutputPort preclusterFastaOutPort = getOutputPorts().createPort("precluster.fasta");
	private OutputPort preclusterNamesOutPort = getOutputPorts().createPort("precluster.names");


	public MothurPreOperator(OperatorDescription description) {
		super(description);
		// TODO Auto-generated constructor stub
	}

}
