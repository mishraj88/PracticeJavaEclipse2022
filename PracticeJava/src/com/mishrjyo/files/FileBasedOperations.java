package com.mishrjyo.files;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileBasedOperations {
	
	static void createFile() throws IOException {
		
		//Files.createDirectories(Paths.get("c:/Users/Anshika/Downloads/Java_Programs/someRandomFile.txt")); 
		File file = new File("c:/Users/Anshika/Downloads/Java_Programs/someRandomFile.txt");
		if (!file.getParentFile().exists()) {
	        if (file.getParentFile().mkdir()) {
	            file.createNewFile();
	            System.out.println("Successfully created new file");
	        } else {
	            throw new IOException("Failed to create directory " + file.getParent());
	        }
	    }
		//FileWriter fw = new FileWriter(file);
		//fw.write("Hello World");
	}

	public static void main(String[] args) {
		try{
			createFile();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
