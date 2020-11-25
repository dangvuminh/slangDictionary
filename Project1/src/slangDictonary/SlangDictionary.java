package slangDictonary;
import java.io.*; 
import java.util.Scanner;
import file.FileHandling;
import java.util.ArrayList;
import slangDictonary.SlangWord;
import java.io.File;

public class SlangDictionary {
	
	static void SearchKey(String key,ArrayList<SlangWord> slang) {
		int count = 0 ;
		for(int i = 0 ; i<slang.size();i++) {
			//always checking null 
			if(slang.get(i) == null)
				break;
			if(slang.get(i).slangWord.compareTo(key) == 0) {
				System.out.println("Meaning: " + slang.get(i).definition);
				count ++;
				break;
			} 
			
		}
		if(count == 0)
		System.out.println("Cannot find any");
	}
	
	static void findAllSlangs(String key,ArrayList<SlangWord> slang) {
		int count = 0;
		for(int i = 0 ; i < slang.size(); i++) {
			for(int j = 0;j<slang.get(i).keyWord.size(); j++ ) {
				//always checking null 
 				if(slang.get(i) == null)
					break;
				if(slang.get(i).keyWord.get(j).compareToIgnoreCase(key) == 0) {
					System.out.println(slang.get(i).slangWord);
					count++;
				}
			}
		}
		if(count == 0)
		System.out.println("Sorry!Can't find any match");
	}
	
	static void addSlang(String key,String definition,ArrayList<SlangWord> slang) {
		int count = 0 ;
		for(int i = 0 ; i<slang.size();i++) {
			//always checking null 
			if(slang.get(i) == null)
				break;
			
			if(slang.get(i).slangWord.compareTo(key) == 0) {
				System.out.println("This slang has already existed!");
				System.out.println("1)Overrride it ....2)Duplicate it");
				count ++;
				break;
				
			}
			}
		if(count == 0) {
			FileHandling fileHndl =  new FileHandling();
			String file = "/Users/macbookpro/git/slangDictionary/Project1/src/file/slang.txt";
			String newLine = key + "`" + definition;
			fileHndl.writeOnFile(file, newLine);
			System.out.println("Successfully adding a new slang");
		}
	}
	
	static void deleteSlang(String key,ArrayList<SlangWord> slang) {
		String filename ="/Users/macbookpro/git/slangDictionary/Project1/src/file/slang.txt";
		FileHandling fileHndl = new FileHandling();
		int count = 0 ;
		fileHndl.deleteFile(filename);
		fileHndl.createFile(filename);
		for(int i = 0 ; i<slang.size();i++) {
			//always checking null 
			if(slang.get(i) == null)
				break;
			if(slang.get(i).slangWord.compareTo(key) != 0) {
				
				String line = slang.get(i).slangWord + "`" + slang.get(i).definition;
				fileHndl.writeOnFile(filename, line);
			} else {
				count++;
			}  
		}
		if(count == 0) {
			System.out.println("Found no slang to delete");
		} else {
			System.out.println("Deleted the slang");
		}
	}
	
	static void editSlang(String key,String newKey,String newDefinition,ArrayList<SlangWord> slang ) {
		String filename ="/Users/macbookpro/git/slangDictionary/Project1/src/file/slang.txt";
		FileHandling fileHndl = new FileHandling();
		int count = 0 ;
		fileHndl.deleteFile(filename);
		fileHndl.createFile(filename);
		for(int i = 0 ; i<slang.size();i++) {
			//always checking null 
			if(slang.get(i).slangWord != null) {
				if(slang.get(i).slangWord.compareTo(key) == 0) {
					String line = newKey + "`" + newDefinition;
					fileHndl.writeOnFile(filename, line);
					count ++;
				} else {
					String line = slang.get(i).slangWord + "`" + slang.get(i).definition;
					fileHndl.writeOnFile(filename, line);
				}  
				
			}
			
		}
		if(count == 0) {
			System.out.println("Found no slang to edit");
		} else {
			System.out.println("Edited the slang");
		}
	}
	
	public static void main(String[] args) {
		
		//SlangDictionary sl = new SlangDictionary();
		System.out.println("Hello my friend");
		System.out.println("Welcome to Slang Word Dictionary");
		System.out.println("We are offering you some services below for you:");
		System.out.println("1.Find the meaning by slang word..");
		System.out.println("2.Find the slang by definition..");
		System.out.println("3.Show your history..");
		System.out.println("4.Add a new slang..");
		System.out.println("5.Edit a slang..");
		System.out.println("5.Delete a slang..");
		
		System.out.println("Enter the number please:");
		Scanner myLine;
		
		myLine = new Scanner(System.in);
		int num = myLine.nextInt();  
		
		FileHandling file = new FileHandling();
		
		ArrayList<SlangWord> slang = new ArrayList<SlangWord>();
		file.readFile(slang);
		
		
		
		switch(num) {
		case 1:{
			System.out.println("Enter the slang word please:");
			 myLine = new Scanner(System.in);
			String key = myLine.nextLine();
			file.writeHistory(key);
			SearchKey(key,slang);
			break;
			
		}
		
		case 2:{
			System.out.println("Enter the key word please:");
			myLine = new Scanner(System.in);
			String key = myLine.nextLine();
			file.writeHistory(key);
			findAllSlangs(key,slang);
			break;
		}
		
		case 3: {
			file.printHistory();
			break;
		}
		
		case 4: {
			System.out.println("Enter the key word you want to add please:");
			myLine = new Scanner(System.in);
			String key = myLine.nextLine();
			System.out.println("Enter the definition you want to add please:");
			String definition = myLine.nextLine();
			addSlang(key,definition,slang);
			break;
		}
		case 5: {
			System.out.println("Enter the key word you want to change:");
			myLine = new Scanner(System.in);
			String key = myLine.nextLine();
			
			System.out.println("Enter the new key word you:");
			myLine = new Scanner(System.in);
			String newKey = myLine.nextLine();
			
			System.out.println("Enter the definition for your new slang:");
			myLine = new Scanner(System.in);
			String newDefinition = myLine.nextLine();
			
			editSlang(key,newKey,newDefinition,slang);
			break;
		}
		case 6:{
			System.out.println("Enter the key word you want to delete please:");
			myLine = new Scanner(System.in);
			String key = myLine.nextLine();
			deleteSlang(key,slang);
			break;
		}
		}
		
	}
	
	
}
