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
import com.rapidminer.parameter.ParameterTypeFile;
import com.rapidminer.parameter.ParameterTypeInt;
import com.rapidminer.tools.LogService;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;

/**
 * @author eugeneai
 *
 */
public class MothurTrimOperator extends MothurOperator {

	/**
	 * @param description
	 */

	private InputPort fastaInPort = getInputPorts().createPort(MothurConstants.Parameters.FASTA);
    private InputPort namesInPort = getInputPorts().createPort(MothurConstants.Parameters.NAME);

    private OutputPort fastaTrimOutPort = getOutputPorts().createPort("trim.fasta");
	private OutputPort namesTrimOutPort = getOutputPorts().createPort("trim.names");
    private OutputPort fastaScrapOutPort = getOutputPorts().createPort("scrap.fasta");
	private OutputPort namesScrapOutPort = getOutputPorts().createPort("scrap.names");
	private OutputPort groupsOutPort = getOutputPorts().createPort("groups");

	@Override
	public List<ParameterType> getParameterTypes() {
		List<ParameterType> types = super.getParameterTypes();

		// TODO: Не удается открыть файл без расширения. мб есть возможность исправить
		types.add(new ParameterTypeFile(MothurConstants.Parameters.OLIGOS,
				"This parameter defines file, containing....",
				MothurConstants.Parameters.OLIGOS,
				true));
		types.add(new ParameterTypeInt(MothurConstants.Parameters.MAXHOMOP, "", 0, 10, 8));
		types.add(new ParameterTypeInt(MothurConstants.Parameters.PDIFFS, "", 0, 10, 2));
		types.add(new ParameterTypeInt(MothurConstants.Parameters.BDIFFS, "", 0, 10, 1));
		types.add(new ParameterTypeInt(MothurConstants.Parameters.MINLENGTH, "", 0, 500, 100));
		types.add(new ParameterTypeInt(MothurConstants.Parameters.PROCESSORS, "", 0, 10, 2));

		return types;
	}


	public MothurTrimOperator(OperatorDescription description) {
		super(description, MothurConstants.Commands.TRIM_SEQS, new HashMap<>());
		this.outputFiles.put(fastaTrimOutPort, "trim.fasta");
		this.outputFiles.put(namesTrimOutPort, "trim.names");
		this.outputFiles.put(fastaScrapOutPort, "scrap.fasta");
		this.outputFiles.put(namesScrapOutPort, "scrap.names");
		this.outputFiles.put(groupsOutPort, "groups");
		// TODO Auto-generated constructor stub
	}

	// TODO: добавить обработку отсутсвия каких-либо параметров
	@Override
	protected Map<String, Object> getParametersValues() throws OperatorException{
//		if (fastaInPort.isConnected()) {
		final FileNameObject fastaIn = fastaInPort.getData(FileNameObject.class);
//			LogService.getRoot().log(Level.INFO, "FASTA: '" + fastaIn.getName() + "'.");
//		}
//		if (namesInPort.isConnected()) {
		final FileNameObject namesIn = namesInPort.getData(FileNameObject.class);
//			LogService.getRoot().log(Level.INFO, "NAMES: '" + namesIn.getName() + "'.");
//		}
		final Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put(MothurConstants.Parameters.FASTA, fastaIn.getName());
		parameters.put(MothurConstants.Parameters.NAME, namesIn.getName());
		parameters.put(MothurConstants.Parameters.OLIGOS,
				getParameterAsString(MothurConstants.Parameters.OLIGOS));

		String[] paramList = new String[] {
				MothurConstants.Parameters.MAXHOMOP,
				MothurConstants.Parameters.PDIFFS,
				MothurConstants.Parameters.BDIFFS,
				MothurConstants.Parameters.MINLENGTH,
				MothurConstants.Parameters.PROCESSORS
		};
		for (String param : paramList) {
			parameters.put(param, getParameterAsInt(param));
		}
//		parameters.put("pdiffs", getParameterAsInt(PARAMETR_PDIFFS));
//		parameters.put("bdiffs", getParameterAsInt(PARAMETR_BDIFFS));
//		parameters.put("minlength", getParameterAsInt(PARAMETR_MINLENGTH));
//		parameters.put("processors", getParameterAsInt(PARAMETR_PROCESSORS));
		return parameters;
	}

//	public void doWork() throws OperatorException {
//
//		/*
//		FileNameObject file = fileSetInput.getData(FileNameObject.class);
//		*/
//		String text = "This Trim Operator is work"; // getParameterAsString(PARAMETER_TEXT);
//		LogService.getRoot().log(Level.INFO, "Running acme program mothur: '" + text + "'.");
//		/*
//		fileSetOutput.deliver(file);
//		*/
//	}

}
