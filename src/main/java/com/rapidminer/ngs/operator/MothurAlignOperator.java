/**
 *
 */
package com.rapidminer.ngs.operator;

import com.rapidminer.ngs.ExternalProgramLauncher;
import com.rapidminer.ngs.MothurConstants;
import com.rapidminer.operator.OperatorDescription;
import com.rapidminer.operator.OperatorException;
import com.rapidminer.operator.ports.InputPort;
import com.rapidminer.operator.ports.OutputPort;
import com.rapidminer.parameter.ParameterType;
import com.rapidminer.parameter.ParameterTypeInt;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author eugeneai
 *
 */
public class MothurAlignOperator extends MothurOperator {

	/**
	 * @param description
	 */

	private InputPort fastaInPort = getInputPorts().createPort(MothurConstants.Parameters.FASTA);
	private InputPort referenceFastaInPort = getInputPorts().createPort("reference.fasta");

	private OutputPort alignOutPort = getOutputPorts().createPort("align");
	private OutputPort alignReportOutPort = getOutputPorts().createPort("align.report");
	private OutputPort flipAccnosOutPort = getOutputPorts().createPort("flip.accnos");

	@Override
	public List<ParameterType> getParameterTypes() {
		List<ParameterType> types = super.getParameterTypes();

		types.add(new ParameterTypeInt(MothurConstants.Parameters.PROCESSORS, "", 0, 10, 2));

		return types;
	}

	public MothurAlignOperator(OperatorDescription description) {
		super(description, MothurConstants.Commands.ALIGN_SEQS, new HashMap<>());
		this.outputFiles.put(alignOutPort, "align");
		this.outputFiles.put(alignReportOutPort, "align.report");
		this.outputFiles.put(flipAccnosOutPort, "flip.accnos");
		// TODO Auto-generated constructor stub
	}

	@Override
	protected Map<String, Object> getParametersValues() throws OperatorException {
		final FileNameObject fastaIn = fastaInPort.getData(FileNameObject.class);

		final FileNameObject referenceFastaIn = referenceFastaInPort.getData(FileNameObject.class);

		final Map<String, Object> parameters = new HashMap<>();
		parameters.put(MothurConstants.Parameters.FASTA, fastaIn.getName());
		parameters.put(MothurConstants.Parameters.REFERENCE, referenceFastaIn.getName());
		parameters.put(MothurConstants.Parameters.PROCESSORS,
				getParameterAsInt(MothurConstants.Parameters.PROCESSORS));
		return parameters;
	}
}