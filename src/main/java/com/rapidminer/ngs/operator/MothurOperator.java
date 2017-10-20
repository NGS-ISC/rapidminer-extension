/**
 *
 */
package com.rapidminer.ngs.operator;

import java.io.IOException;
import java.util.*;
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

	protected String command;
	protected Map<Object, String> outputFiles;


	/**
	 * @param description
	 */
	public MothurOperator(OperatorDescription description) {
		super(description);
		// TODO Auto-generated constructor stub
	}


	/**
	 * @param description
	 */
	public MothurOperator(OperatorDescription description, String command, Map<Object, String> outputFiles) {
		super(description);
		this.command = command;
		this.outputFiles = outputFiles;
		// TODO Auto-generated constructor stub
	}

	protected Map<String, Object> getParametersValues() throws OperatorException {
		return new HashMap<>();
	};

	@Override
	public void doWork() throws OperatorException {
		ExternalProgramLauncher externalProgramLauncher = new ExternalProgramLauncher();
		try {
			Map<Object, String> outputFilesMap = externalProgramLauncher.main("mothur",
					"#" + this.command + "(" + getParametersValues().toString()
							.replaceAll("\\{", "")
							.replaceAll("}", "") + ")", outputFiles);

			for (Map.Entry<Object, String> pair : outputFilesMap.entrySet()) {
				String[] ext = pair.getValue().split("\\.");
				if (ext.length > 0) {
					((OutputPort) pair.getKey()).deliver(new FileNameObject(pair.getValue(), ext[ext.length - 1]));
				}
				else {
					LogService.getRoot().log(Level.INFO, "MothurOperator pair.getValue().split().length <= 0: '" + pair.getValue() + "'.");
				}

			}
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
