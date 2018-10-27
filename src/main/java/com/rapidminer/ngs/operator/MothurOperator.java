/**
 *
 */
package com.rapidminer.ngs.operator;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
		clearArguments();
		determineMothurCommand();
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

	protected final Map<String,String> mothur_parameters = new HashMap<String,String>();
	protected static String mothur_command = null;

	protected void addArgument(String arg, String value) {
		mothur_parameters.put(arg, value);
	}

	protected void clearArguments() {
		mothur_parameters.clear();
	}

	protected String executeMothurCommand() {
		List<String> command = new ArrayList<String>();
		command.add(mothur_command);
		for (Map.Entry<String, String> entry : mothur_parameters.entrySet()) {
			command.add(String.format("%s=%s", entry.getKey(), entry.getValue()));
		}
		String output = executeCommand(command);
		// TODO: process output
		return output;
	}

	protected String executeShellCommand(String command) {

		StringBuffer output = new StringBuffer();

		Process p;
		try {
			p = Runtime.getRuntime().exec(command);
			p.waitFor();
			BufferedReader reader =
					new BufferedReader(new InputStreamReader(p.getInputStream()));

			String line = "";
			while ((line = reader.readLine())!= null) {
				output.append(line + "\n");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return output.toString();
	}

	protected StringBuffer standardOutput = null;
	protected StringBuffer standardError = null;
	protected int executionResult = 0;             // This is not valid if standardOutput is null
	protected String executeCommand(List<String> command) {
		standardError = null;
		standardOutput = null;
		try {
			ProcessBuilder builder = new ProcessBuilder(command);
			final Process process = builder.start();

			InputStream is = process.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);

			String line;
			process.waitFor();
			standardOutput = new StringBuffer();
			while ((line = br.readLine()) != null) {
				standardOutput.append(line + "\n");
			}

			is = process.getErrorStream();
			isr = new InputStreamReader(is);
			br = new BufferedReader(isr);

			standardError = new StringBuffer();
			while ((line = br.readLine()) != null) {
				standardError.append(line + "\n");
			}

			executionResult=process.exitValue();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return standardOutput.toString();
	}

	private void determineMothurCommand() {
		if (mothur_command == null) {
			String output = executeShellCommand("which mothur");
			mothur_command=output.trim();
			System.out.printf("INFO: Mothur executable is '%s'\n", mothur_command);
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
