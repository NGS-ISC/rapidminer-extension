/**
 * 
 */
package com.rapidminer.extension.operator;

import java.util.logging.Level;

import com.rapidminer.operator.Operator;
import com.rapidminer.operator.OperatorDescription;
import com.rapidminer.operator.OperatorException;
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
		LogService.getRoot().log(Level.INFO, "Running acme program mothur!!!");
	}

}
