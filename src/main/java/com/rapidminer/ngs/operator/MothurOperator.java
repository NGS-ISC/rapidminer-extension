/**
 *
 */
package com.rapidminer.ngs.operator;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;

import com.rapidminer.example.ExampleSet;
import com.rapidminer.ngs.ExternalProgramLauncher;
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

	protected static String command;

	/**
	 * @param description
	 */
	public MothurOperator(OperatorDescription description) {
		super(description);
		// TODO Auto-generated constructor stub
	}

	protected Map<String, Object> getParametersValues() throws OperatorException {
		return new HashMap<>();
	};

	@Override
	public void doWork() throws OperatorException {
		ExternalProgramLauncher externalProgramLauncher = new ExternalProgramLauncher();
		try {
			externalProgramLauncher.main("mothur",
					"#" + this.command + "(" + getParametersValues().toString()
							.replaceAll("\\{", "")
							.replaceAll("}", "") + ")");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

//  R.I.P. for a time being.
// 	@Override
//	public List<ParameterType> getParameterTypes() {
//		List<ParameterType> types = super.getParameterTypes();
//
//		return types;
//	}

}
