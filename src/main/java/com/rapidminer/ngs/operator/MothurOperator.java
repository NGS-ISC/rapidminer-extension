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
import com.rapidminer.parameter.ParameterTypeString;
import com.rapidminer.tools.LogService;

/**
 * @author eugeneai
 *
 */
public class MothurOperator extends Operator {

	private static final String PARAMETER_TEXT = "Length of the data:";
	private InputPort fileSetInput = getInputPorts().createPort("file set");
	private OutputPort fileSetOutput = getOutputPorts().createPort("file set");

	/**
	 * @param description
	 */
	public MothurOperator(OperatorDescription description) {
		super(description);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void doWork() throws OperatorException {
		ExampleSet files = fileSetInput.getData(ExampleSet.class);
		String text = getParameterAsString(PARAMETER_TEXT);
		LogService.getRoot().log(Level.INFO, "Running acme program mothur: '"+text+"'.");
		fileSetOutput.deliver(files);
	}

	@Override
	public List<ParameterType> getParameterTypes(){
	    List<ParameterType> types = super.getParameterTypes();

	    types.add(new ParameterTypeString(
	        PARAMETER_TEXT,
	        "This parameter defines which text is logged to " +
	        "the console when this operator is executed.",
	        "This is a default text",
	        false));
	    return types;
	}

}
