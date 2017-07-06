/**
 *
 */
package com.rapidminer.ngs.operator;

import com.rapidminer.operator.SimpleResultObject;

/**
 * @author Evgeny Cherkashin
 *
 */
public class FileNameObject extends SimpleResultObject {
	private static final long serialVersionUID = 4406614006750155688L;
	/**
	 * @param name
	 * @param text
	 */
    private String fileType;

	public FileNameObject(String name, String text, String fileType) {
		super(name, text);
        this.fileType = fileType;
	}

    public String getFileType() {
        return fileType;
    }

    @Override
    public String toString() {
        return String.format("%s:%s", getName(), getFileType());
    }

    /*
    public void setFileType(String fileType ) {
        this.text = fileType;
    }
    */
}
