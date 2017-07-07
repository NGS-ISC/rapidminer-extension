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
public class MothurScreenOperator extends MothurOperator {

	/**
	 * @param description
	 */


    private InputPort alignInPort = getInputPorts().createPort("align");
	private InputPort namesInPort = getInputPorts().createPort("names");
	private InputPort groupsInPort = getInputPorts().createPort("groups");

    private OutputPort goodAlignOutPort = getOutputPorts().createPort("good.align");
	private OutputPort badAccnosOutPort = getOutputPorts().createPort("bad.accnos");
	private OutputPort goodNamesOutPort = getOutputPorts().createPort("good.names");
	private OutputPort goodGroupsOutPort = getOutputPorts().createPort("good.groups");


	public MothurScreenOperator(OperatorDescription description) {
		super(description);
		// TODO Auto-generated constructor stub
	}

}
