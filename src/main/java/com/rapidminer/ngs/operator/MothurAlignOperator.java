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
public class MothurAlignOperator extends MothurOperator {

	/**
	 * @param description
	 */


    private InputPort fastaInPort = getInputPorts().createPort("fasta");
	private InputPort bacteriaFastaInPort = getInputPorts().createPort("bacteria.fasta");

    private OutputPort alignOutPort = getOutputPorts().createPort("align");
	private OutputPort alignReportOutPort = getOutputPorts().createPort("align.report");
	private OutputPort flipAccnosOutPort = getOutputPorts().createPort("flip.accnos");


	public MothurAlignOperator(OperatorDescription description) {
		super(description);
		// TODO Auto-generated constructor stub
	}

}
