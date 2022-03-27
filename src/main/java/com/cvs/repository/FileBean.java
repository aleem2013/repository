/**
 * 
 */
package com.cvs.repository;

import java.nio.file.attribute.FileTime;

/**
 * @author Yahiya Khan
 *
 */
public class FileBean {
	
	private String fileName;
	
	private String filePath;
	
	private String fileSize;
	
	private String fileType;
	
	private String lastModifiedTime;
	
	

	public String getLastModifiedTime() {
		return lastModifiedTime;
	}

	public void setLastModifiedTime(String time) {
		this.lastModifiedTime = time;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getFileSize() {
		return fileSize;
	}

	public void setFileSize(String fileSize) {
		this.fileSize = fileSize;
	}
	
	

}
