/**
 *
 */
package com.rapidminer.ngs.operator;

import com.rapidminer.ngs.ExternalProgramLauncher;
import com.rapidminer.operator.OperatorDescription;
import com.rapidminer.operator.OperatorException;
import com.rapidminer.operator.ports.InputPort;
import com.rapidminer.operator.ports.OutputPort;
import com.rapidminer.parameter.ParameterType;
import com.rapidminer.parameter.ParameterTypeFile;
import com.rapidminer.parameter.ParameterTypeInt;
import com.rapidminer.tools.LogService;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;

/**
 * @author eugeneai
 *
 */
public class MothurTrimOperator extends MothurOperator {

	/**
	 * @param description
	 */

	private static final String OLIGOS_LABEL = "Oligos filename:";
	private static final String PARAMETR_MAXHOMOP = "maxhomop";
	private static final String PARAMETR_PDIFFS = "pdiffs";
	private static final String PARAMETR_BDIFFS = "bdiffs";
	private static final String PARAMETR_MINLENGTH = "minlength";
	private static final String PARAMETR_PROCESSORS = "processors";

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
		types.add(new ParameterTypeInt(PARAMETR_MAXHOMOP, "", 0, 10, 8));
		types.add(new ParameterTypeInt(PARAMETR_PDIFFS, "", 0, 10, 2));
		types.add(new ParameterTypeInt(PARAMETR_BDIFFS, "", 0, 10, 1));
		types.add(new ParameterTypeInt(PARAMETR_MINLENGTH, "", 0, 500, 100));
		types.add(new ParameterTypeInt(PARAMETR_PROCESSORS, "", 0, 10, 2));

		return types;
	}


	public MothurTrimOperator(OperatorDescription description) {
		super(description);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void doWork() throws OperatorException {
		/*
		FileNameObject file = fileSetInput.getData(FileNameObject.class);
		*/
		ExternalProgramLauncher externalProgramLauncher = new ExternalProgramLauncher();
		try {
			externalProgramLauncher.main();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		String text = "This Trim Operator is work"; // getParameterAsString(PARAMETER_TEXT);
		LogService.getRoot().log(Level.INFO, "Running acme program mothur: '" + text + "'.");
		/*
		fileSetOutput.deliver(file);
		*/
	}

}
