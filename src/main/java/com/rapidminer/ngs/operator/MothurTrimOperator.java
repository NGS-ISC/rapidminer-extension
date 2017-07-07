/**
 *
 */
package com.rapidminer.ngs.operator;

import com.rapidminer.operator.OperatorDescription;
import com.rapidminer.operator.ports.InputPort;
import com.rapidminer.operator.ports.OutputPort;
import com.rapidminer.parameter.ParameterType;
import com.rapidminer.parameter.ParameterTypeFile;

import java.util.List;

/**
 * @author eugeneai
 *
 */
public class MothurTrimOperator extends MothurOperator {

	/**
	 * @param description
	 */

	private static final String OLIGOS_LABEL = "Oligos filename:";

	private InputPort fastaInPort = getInputPorts().createPort("fasta");
    private InputPort namesInPort = getInputPorts().createPort("names");

    private OutputPort fastaTrimOutPort = getOutputPorts().createPort("trim.fasta");
	private OutputPort namesTrimOutPort = getOutputPorts().createPort("trim.names");
    private OutputPort fastaScrapOutPort = getOutputPorts().createPort("scrap.fasta");
	private OutputPort namesScrapOutPort = getOutputPorts().createPort("scrap.names");
	private OutputPort groupsOutPort = getOutputPorts().createPort("groups");

	@Override
	public List<ParameterType> getParameterTypes() {
		List<ParameterType> types = super.getParameterTypes();

		types.add(new ParameterTypeFile(OLIGOS_LABEL, "This parameter defines file, containing....", "oligos", true));

		return types;
	}


	public MothurTrimOperator(OperatorDescription description) {
		super(description);
		// TODO Auto-generated constructor stub
	}

}
