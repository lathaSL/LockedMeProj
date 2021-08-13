package com.lockedme.fileprocess;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LockedMeFileManager {
	
	/**
	 * Method to list files in a directory
	 * @param dirPath
	 */
	public static void listFileNames(String dirPath) {
		//Method to list files in a given directory
		
		File fileObj=new File(dirPath);
		
		try {
				File[] filesList=fileObj.listFiles();
				
				if (filesList.length >0) {
					List <String> arrFileNames=new ArrayList<String>();
//					Iterate through all files in the directory and save files in arraylist
					for (File file: filesList) {
						if (file.isFile()) {
							arrFileNames.add(file.getName());
						}
					}
//					To sort file names in ascending order
					Collections.sort(arrFileNames);
					
					System.out.println("Files in "+dirPath +": ");
					for (String fileName: arrFileNames) {
						System.out.println(fileName);
						
					}
				}
				else {
					System.out.println("No files in the directory "+dirPath );
				}
		
			}
		catch (Exception e) {
			System.out.println("Error occurred.Please contact Helpdesk.");
		}
	}
	/**
	 * Function to add file to a directory
	 * @param dirPath
	 * @param fileName
	 * @param contentArr
	 * @throws IOException 
	 */
	
	public static void addFiletoDir(String dirPath,String fileName, List <String> contentArr) throws IOException	{
		
		File fileObj=new File(dirPath,fileName);
		FileWriter fw=null;
			try {
				 fw =new FileWriter(fileObj);
//				 Write lines to file
				for (String line: contentArr) {
					fw.append(line+"\n");
				}
				fw.close();
				System.out.println("File created in "+dirPath);


			} catch (IOException e) {
				fw.close();
				System.out.println("Error occurred.Please contact Helpdesk.");
				e.printStackTrace();

			}
			
		
	}
	/**
	 * Function to delete a file, case sensitive
	 * @param dirPath
	 * @param fileName
	 */
	public static void deleteFile (String dirPath,String fileName)	{
		 
		File fileObj=new File(dirPath);
		boolean fileDeleted=false;
		boolean fileExists=false;
			File[] filesList=fileObj.listFiles();
			
			if (filesList.length >0) {
				
				for (File file: filesList) {
//					Iterate through files and check filename and delete if it matches
					if (file.isFile() && file.getName().equals(fileName)) {
						fileExists=true;
						File fileDelObj=new File(dirPath,fileName);
//						Deletes file
						if(fileDelObj.delete()) {
							System.out.println("File "+fileName +" deleted.");	
							fileDeleted=true;
							break;
						}
					}
					
				}	
			}
			if (!fileExists) {
				System.out.println("File not Exists. Please check the file name (case also!!)");
			}				
			else if(!fileDeleted) {
				System.out.println("File not deleted");
			}
		
			
	}
	/**
	 * Function to search a file in given directory
	 * @param dirPath
	 * @param fileName
	 */
	public static void SearchFile (String dirPath,String fileName) {
		
		File fileObj=new File(dirPath);
			File[] filesList=fileObj.listFiles();
			boolean fileExists=false;
			if (filesList.length >0) {
//				Iterate through files in the directory and if matches with the given filename
//				then prints the message
				for (File file: filesList) {
					if (file.isFile() && file.getName().equals(fileName)) {
						fileExists=true;
							System.out.println("File "+fileName +" exists.");	
							break;
						}
					}
					
				}
			if (!fileExists) {
				System.out.println("File "+fileName +" not exists in the directory "+dirPath);	
			}
		
	}
	
}
