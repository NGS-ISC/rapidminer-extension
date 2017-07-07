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
public class MothurChimeraOperator extends MothurOperator {

	/**
	 * @param description
	 */


    private InputPort fastaInPort = getInputPorts().createPort("fasta");
	private InputPort namesInPort = getInputPorts().createPort("names");
	private InputPort groupsInPort = getInputPorts().createPort("groups");

    private OutputPort chimerasOutPort = getOutputPorts().createPort("chimeras");
	private OutputPort accnosNamesOutPort = getOutputPorts().createPort("accnos");


	public MothurChimeraOperator(OperatorDescription description) {
		super(description);
		// TODO Auto-generated constructor stub
	}

}
