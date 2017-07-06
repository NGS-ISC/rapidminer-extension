/**
 *
 */
package com.rapidminer.ngs.operator;

import java.util.List;
import java.util.logging.Level;

import com.rapidminer.example.ExampleSet;
import com.rapidminer.operator.Operator;
import com.rapidminer.operator.OperatorDescription;
import com.rapidminer.operator.OperatorException;
import com.rapidminer.operator.ports.InputPort;
import com.rapidminer.operator.ports.OutputPort;
import com.rapidminer.parameter.ParameterType;
import com.rapidminer.parameter.ParameterTypeFile;
import com.rapidminer.parameter.ParameterTypeString;
import com.rapidminer.tools.LogService;

/**
 * @author eugeneai
 *
 */
public class MothurOperator extends Operator {

	private static final String PARAMETER_TEXT = "Length of the data:";
	private static final String OLIGOS_LABEL = "Oligos filename:";
	private InputPort fileSetInput = getInputPorts().createPort("fasta");
	private OutputPort fileSetOutput = getOutputPorts().createPort("names");

	/**
	 * @param description
	 */
	public MothurOperator(OperatorDescription description) {
		super(description);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void doWork() throws OperatorException {
		FileNameObject file = fileSetInput.getData(FileNameObject.class);
		String text = getParameterAsString(PARAMETER_TEXT);
		LogService.getRoot().log(Level.INFO, "Running acme program mothur: '" + text + "'.");
		fileSetOutput.deliver(file);
	}

	@Override
	public List<ParameterType> getParameterTypes() {
		List<ParameterType> types = super.getParameterTypes();

		types.add(new ParameterTypeString(PARAMETER_TEXT,
				"This parameter defines which text is logged to the console when this operator is executed.",
				"This is a default text", false));

		types.add(new ParameterTypeFile(OLIGOS_LABEL, "This parameter defines file, containing....", "oligos", true));

		return types;
	}

}
