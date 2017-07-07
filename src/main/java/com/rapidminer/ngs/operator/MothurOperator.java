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

	/**
	 * @param description
	 */
	public MothurOperator(OperatorDescription description) {
		super(description);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void doWork() throws OperatorException {
		/*
		FileNameObject file = fileSetInput.getData(FileNameObject.class);
		*/
		String text = "Test text"; // getParameterAsString(PARAMETER_TEXT);
		LogService.getRoot().log(Level.INFO, "Running acme program mothur: '" + text + "'.");
		/*
		fileSetOutput.deliver(file);
		*/
	}

	@Override
	public List<ParameterType> getParameterTypes() {
		List<ParameterType> types = super.getParameterTypes();

		return types;
	}

}
