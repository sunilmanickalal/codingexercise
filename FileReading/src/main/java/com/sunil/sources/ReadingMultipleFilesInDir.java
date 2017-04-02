package com.sunil.sources;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class ReadingMultipleFilesInDir {

	public static void main(String[] args) throws IOException {
		File folder = new File("/apps/temp/files");
		File[] listOfFiles = folder.listFiles();

		for (int i = 0; i < listOfFiles.length; i++) {
		  File file = listOfFiles[i];
		  System.out.println("Reading File: " + file.getName());
		  if (file.isFile() && file.getName().endsWith(".txt")) {
		    String content = FileUtils.readFileToString(file);
		    System.out.println("file data: " + content );
		  } 
		  if(i>0){
			  file.delete();
		  }
		}
	}

}
