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
public class MothurTrimOperator extends MothurOperator {

	/**
	 * @param description
	 */

    private InputPort fastaInPort = getInputPorts().createPort("fasta");
    private InputPort namesInPort = getInputPorts().createPort("names");

    private OutputPort fastaTrimOutPort = getOutputPorts().createPort("trim.fasta");
    private OutputPort fastaScrapOutPort = getOutputPorts().createPort("scrap.fasta");
	private OutputPort namesTrimOutPort = getOutputPorts().createPort("trim.names");
	private OutputPort namesScrapOutPort = getOutputPorts().createPort("scrap.names");
	private OutputPort groupsOutPort = getOutputPorts().createPort("groups");

	public MothurTrimOperator(OperatorDescription description) {
		super(description);
		// TODO Auto-generated constructor stub
	}

}
