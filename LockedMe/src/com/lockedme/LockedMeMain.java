package com.lockedme;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.lockedme.fileprocess.LockedMeFileManager;

public class LockedMeMain {
	static Scanner scanObj =new Scanner(System.in);
	static String defaultPath="C:\\LockedMeFiles";


	public static void main(String[] args) {
		// Initialize scanner object to get user input
		
		int selectOption=0;
		boolean contMenu=false;
		//DefaultPath

		//Display Title
		displayHeader();		
		
		do {		
			
			//Display Main Menu to choose the option
			
			displayMenu();
			

			selectOption=Integer.parseInt(scanObj.nextLine());

			switch (selectOption){
			
			
				case 1: listFileNames(); break;
				case 2: addFiletoDir(); break;
				case 3:	deleteFile(); break;
				case 4: searchFile(); break;
				case 5: System.exit(0); break;
			
			default: System.out.println("Enter any of the above options 1-5.") ; break;
			}
			System.out.println("Do you want to continue?[Y/N]");
			
			contMenu=(scanObj.nextLine().equalsIgnoreCase("Y")? true: false);
			
		}
		while(contMenu) ;
		
		System.out.println("Exiting.");
		
	}
	
	private static void searchFile() {
		
		System.out.println("Do you want to specify Directory Path from which file to be deleted. Default path is C:\\LockedMeFiles");
		String dirPath=validatePath(scanObj.nextLine());
		
		System.out.println("Please specify FILE NAME.");
		String fileName=scanObj.nextLine();
		LockedMeFileManager.SearchFile(dirPath, fileName);	
		
	}
	
	private static void deleteFile() {
		System.out.println("Do you want to specify Directory Path from which file to be deleted. Default path is C:\\LockedMeFiles");
		String dirPath=validatePath(scanObj.nextLine());
		
		System.out.println("Please specify FILE NAME.");
		String fileName=scanObj.nextLine();
		
		LockedMeFileManager.deleteFile(dirPath, fileName);
	}
	
	private static void addFiletoDir() {
		List<String> Lines=new ArrayList<String>();
		System.out.println("Do you want to specify Directory Path to search? Please specify path. Else press enter. Default path is C:\\LockedMeFiles");
		String dirPath=validatePath(scanObj.nextLine());
		
		System.out.println("Please specify FILE NAME.");
		String fileName=scanObj.nextLine();
		
		System.out.println("Please enter number of lines you want to add.");
		try {
			int lineCount=Integer.parseInt(scanObj.nextLine());
		
			for (int i=0; i<lineCount; i++) {
				System.out.println("Enter line "+ (i+1));
				Lines.add(scanObj.nextLine());
			}
			
			LockedMeFileManager.addFilestoDir(dirPath, fileName, Lines);
		}
		catch (NumberFormatException ne) {
			System.out.println("Please enter valid number!");
		}
		
	}
	private static void listFileNames() {
		
		System.out.println("Do you want to specify Directory Path to search? \nPlease specify path. Else press enter. Default path is C:\\LockedMeFiles");
		String dirPath=validatePath(scanObj.nextLine());

		LockedMeFileManager.listFileNames(dirPath);
	}
	private static String validatePath(String path) {
		//Directory path basic validation, if user gives directory path
		
		
		if (!path.isEmpty() && path.contains("\\")) {
			return path.trim();
		}
		else {
			return defaultPath;			
		}	
			
		}
	
	private static void displayMenu() {
		//Method to display the menu and options
		System.out.println("Please enter your option: ") ;

		System.out.println("1 : Print List of File Names");
		System.out.println("2 : Add a file to the Directory");
		System.out.println("3 : Delete a file from the Directory");
		System.out.println("4 : Search for a file");
		System.out.println("5 : Exit");		
		
	}
	private static  void displayHeader(){
		
		//Print Application & developer name
				System.out.println("********************************************************\n");
				System.out.println("*\t\t\t\t\t\t\t*\n");

				System.out.println("*\t\tLOCKEDME.COM Project\t\t\t*\n");
				System.out.println("*\t\t\t\t\t\t\t*\n");

				
				System.out.println("*********************************************************\n");
				
				System.out.println("Developed by Sree Latha S\n");
				
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");

	}

}
