package com.lockedme.fileprocess;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LockedMeFileManager {
	
	
	public static boolean listFileNames(String dirPath) {
		
		File fileObj=new File(dirPath);
		
		try {
			if (fileObj.exists()) {
				File[] filesList=fileObj.listFiles();
				
				if (filesList.length >0) {
					List <String> arrFileNames=new ArrayList<String>();
					
					for (File file: filesList) {
						if (file.isFile()) {
							arrFileNames.add(file.getName());
						}
					}
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
			else {
					System.out.println("The Directory path "+dirPath +" doesnot exists.");
				}
			}
		catch (Exception e) {
			System.out.println("Error occurred.Please contact Helpdesk.");
		}
		return true;
	}
	
	
	public static boolean addFilestoDir(String dirPath,String fileName, List <String> contentArr)	{
		
		File fileObj=new File(dirPath,fileName);
//		if (fileObj.exists()) {
			try {
				FileWriter fw=new FileWriter(fileObj);
				for (String line: contentArr) {
					fw.append(line+"\n");
				}
				fw.close();
				
			} catch (IOException e) {
				System.out.println("Error occurred.Please contact Helpdesk.");
				e.printStackTrace();
			}
			
//		}
//		else {
//			System.out.println("The file path "+dirPath +" doesnot exists.");
//
//		}
		
		return true;	
	}
	public static boolean deleteFile (String dirPath,String fileName)	{
		 
		File fileObj=new File(dirPath);
		boolean fileDeleted=false,fileExists=false;
		if (fileObj.exists()) {
			File[] filesList=fileObj.listFiles();
			
			if (filesList.length >0) {
				
				for (File file: filesList) {
					if (file.isFile() && file.getName().equals(fileName)) {
						fileExists=true;
						if(fileObj.delete()) {
							System.out.println("File "+fileName +" deleted.");	
							fileDeleted=true;
							break;
						}
					}
					
				}	
			}
			if (!fileExists) {
				System.out.println("File not Exists. Please check the file name case also!");
			}				
			else if(!fileDeleted) {
				System.out.println("File not deleted");
			}
		}
		else {
			System.out.println("Directory not exists.");
		}
			
				return true;	
	}
	public static boolean SearchFile (String dirPath,String fileName) {
		
		File fileObj=new File(dirPath);
		if (fileObj.exists()) {
			File[] filesList=fileObj.listFiles();
			boolean fileExists=false;
			if (filesList.length >0) {
				
				for (File file: filesList) {
					if (file.isFile() && file.getName().equals(fileName)) {

							System.out.println("File "+fileName +" exists.");	
							break;
						}
					}
					
				}
			if (!fileExists) {
				System.out.println("File "+fileName +" not exists in the directory "+dirPath);	
			}
		}
		else {
			System.out.println("Directory "+dirPath +" not exists.");	

		}
		return true;	
	}
	
}
