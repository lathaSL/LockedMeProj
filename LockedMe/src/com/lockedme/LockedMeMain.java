package com.lockedme;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.lockedme.fileprocess.LockedMeFileManager;

public class LockedMeMain {
	static Scanner scanObj =new Scanner(System.in);
	static String defaultPath="C:\\LockedMeFiles";
	static String dirPath="";
	boolean first=false;
	public static void main(String[] args) {
		// Initialize scanner object to get user input
		
		int selectOption=0;
		boolean contMenu=false;
		boolean first=true;

		//DefaultPath

		//Display Title
		displayHeader();		
		
		do {		
			
			//Display Main Menu to choose the option
			
			selectOption=displayMenu();
			if (first && selectOption <4 && selectOption >0 ){
				System.out.println("Please specify Directory Path, if necessary.\nDefault path is C:\\LockedMeFiles");
				dirPath=validatePath(scanObj.nextLine());
				first=false;
			}
			switch (selectOption){			
			
				case 1: LockedMeFileManager.listFileNames(dirPath); break;
				case 2: addFiletoDir(); break;
				case 3:	deleteFile(); break;
				case 4: searchFile(); break;
				case 5: System.out.println("Exiting");System.exit(0); break;
			
			default: System.out.println("Enter any of the above options 1-5.") ; break;
			}
			System.out.println("Do you want to continue? Enter 'Y' to continue.");
			
			contMenu=(scanObj.nextLine().equalsIgnoreCase("Y")? true: false);
			
		}
		while(contMenu) ;
		
		System.out.println("Exiting.");
		
	}
	
	private static void searchFile() {
		
		//get input for search file and call SearchFile 
		System.out.println("Please specify FILE NAME.");
		String fileName=scanObj.nextLine();
		LockedMeFileManager.SearchFile(dirPath, fileName);	
		
	}
	
	private static void deleteFile() {
		//get input for delete file and call deleteFile

		System.out.println("Please specify FILE NAME.");
		String fileName=scanObj.nextLine();
		
		LockedMeFileManager.deleteFile(dirPath, fileName);
	}
	
	private static void addFiletoDir() {
		//get inputs for delete file and call addFilestoDir method

		List<String> Lines=new ArrayList<String>();
		
		System.out.println("Please specify FILE NAME.");
		String fileName=scanObj.nextLine();
		if (fileName.isEmpty() || fileName.equals("")) {
			System.out.println("Please specify proper file name!!");
			return;
		}
		
		System.out.println("Please enter number of lines you want to add.");
		try {
			int lineCount=Integer.parseInt(scanObj.nextLine());
		
			for (int i=0; i<lineCount; i++) {
				System.out.println("Enter line "+ (i+1));
				Lines.add(scanObj.nextLine());
			}
			
			LockedMeFileManager.addFiletoDir(dirPath, fileName, Lines);
		}
		catch (NumberFormatException ne) {
			System.out.println("Please enter valid number!");
		}
		catch(IOException ie) {
			System.out.println("Error writing File.");
		}
		
	}
	private static String validatePath(String path) {
		//Directory path  validation, if user gives directory path
		
		
		if (!path.isEmpty() && !path.equals("")&& path.contains("\\")) {
			File fileObj=new File(path.trim());
			
				if (fileObj.exists()) {
					return path.trim();
 
				}				
		}
		if (!path.isEmpty() && !path.equals("")) {
			System.out.println("Mentioned directory not Exists!!! Using default directory.");
		}
		return defaultPath;			
			
			
		}
	
	private static int displayMenu() {
		//Method to display the menu and options
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("1 : Print List of File Names");
		System.out.println("2 : Add a file to the Directory");
		System.out.println("3 : Delete a file from the Directory");
		System.out.println("4 : Search for a file");
		System.out.println("5 : Exit");		
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");

		System.out.println("Please enter your option: ") ;
		try {
		return Integer.parseInt(scanObj.nextLine());
		}
		catch (NumberFormatException ne) {
			return 0;
		}
		
	}
	private static  void displayHeader(){
		
		//Print Application & developer name
				System.out.println("*********************************************************\n");

				System.out.println("\t\tLOCKEDME.COM Project\t\t\t\n");
				
				System.out.println("*********************************************************");
				
				System.out.println("Developed by Sree Latha S.");
				

	}

}

