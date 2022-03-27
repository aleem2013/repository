/**
 * 
 */
package com.cvs.repository;

import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Yahiya Khan
 *
 */
@RestController
public class HomeController {
	
	@RequestMapping("/getList")
	public List<FileBean> getList() throws IOException {
		List<FileBean> listOfFiles = new ArrayList<>();
		try (Stream<Path> filePathStream = Files.walk(Paths.get("E:\\aleem"))){
			filePathStream.forEach(filePath -> {
				FileBean file = new FileBean();
				System.out.println("File path:"+filePath);
				System.out.println("File Name:"+filePath.getFileName());
				file.setFilePath(filePath.toString());
				file.setFileName(filePath.getFileName().toString());
				System.out.println(StringUtils.getFilenameExtension(filePath.getFileName().toString()));
				file.setFileType(StringUtils.getFilenameExtension(filePath.getFileName().toString())); 
				try {
					long bytes = Files.size(filePath);
					System.out.println("File size:"+String.format("%,d bytes", bytes));
					file.setFileSize(String.format("%,d bytes", bytes));
					System.out.println("Last modified :"+Files.getLastModifiedTime(filePath));
					file.setLastModifiedTime(Files.getLastModifiedTime(filePath).toString());
				} catch(IOException e) {
					e.printStackTrace();
				}
				listOfFiles.add(file);
			});
		}
		return listOfFiles;
	}
	
	@RequestMapping("/")
	public String welcome() {
		return "Welcome";
	}

}
