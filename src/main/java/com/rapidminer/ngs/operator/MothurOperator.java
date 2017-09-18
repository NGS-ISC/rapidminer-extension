/**
 *
 */
package com.rapidminer.ngs.operator;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
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
import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.exec.ExecuteException;
import org.apache.commons.exec.ExecuteWatchdog;

/**
 * @author Evgeny Cherkashin (eugeneai@irnok.net), Kristina Paskal
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

	protected CommandLine commandLine;
	protected OutputStream stdout = null;
	protected OutputStream sterr = null;
	protected InputStream stdin = null;
	protected int execTimeout = 0;

	@Override
	public void doWork() throws OperatorException {
		super.doWork();
		commandLine = new CommandLine("/usr/bin/mothur");
		DefaultExecutor executor = new DefaultExecutor();
		// Set timeout from a parameter.
		ExecuteWatchdog watchdog = null;
		if (execTimeout > 0) {
			watchdog = new ExecuteWatchdog(execTimeout);
			executor.setWatchdog(watchdog);
		}

		/*
		FileNameObject file = fileSetInput.getData(FileNameObject.class);
		*/
		mothurPreExec(); // Should add other parts of the command line and text to stdin

		int retVal = 0;

		try {
			LogService.getRoot().log(Level.WARNING, "Executing :" + commandLine.toString());
			retVal = executor.execute(commandLine);
			LogService.getRoot().log(Level.WARNING, "RetVal :" + Integer.toString(retVal));
		} catch (IOException ex) {
			LogService.getRoot().log(Level.WARNING, "Mothur execution produced error");
			LogService.getRoot().log(Level.WARNING, ex.toString());
			throw new OperatorException("mothur execution failed");
		}

		mothurPostExec(retVal); // Process the stdout and stderr. Can raise IOException.
		/*
		fileSetOutput.deliver(file);
		*/
	}

	public void mothurPreExec() throws OperatorException {
		commandLine.addArgument("--help");
	};

	public void mothurPostExec(int retVal) throws OperatorException {
//		LogService.getRoot().log(Level.WARNING, "Mothur result processing failed");
//		LogService.getRoot().log(Level.WARNING, ex.toString());
//		throw new OperatorException("mothur result processing failed");
	};

//  R.I.P. for a time being.
// 	@Override
//	public List<ParameterType> getParameterTypes() {
//		List<ParameterType> types = super.getParameterTypes();
//
//		return types;
//	}

}
