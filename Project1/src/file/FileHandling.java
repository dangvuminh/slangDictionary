package file;
import java.io.File;  // Import the File class

import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import slangDictonary.SlangWord ;
import java.io.FileWriter; 

public class FileHandling {
	
	public void readFile(ArrayList<SlangWord> slang,String filename) {//reading txt file and put it into ArrayList
		
		try {
		
			//ArrayList<SlangWord> 
			//slang = new ArrayList<SlangWord>();
			
			BufferedReader br = new BufferedReader(new FileReader(filename));
			String str ;
			while (true)
			{
				str = br.readLine();
				
				//slang arraylist can get null so make sure put the condition checking null before 
				// the string is added
				if(str == null)
					break;
				
				slang.add(separateString(str));	
			}
			br.close();
		}
		catch(IOException ie) {
            ie.printStackTrace();
        }   
		
	}
	
	static SlangWord separateString(String line) {//separate a line in txt file into 2 parts before and after `
		SlangWord slang = new SlangWord();
		for(int i = 0 ; i<line.length();i++) {
			
				 char c = line.charAt(i);
				if(c == '`') {
				slang.slangWord = line.substring(0, i)	;
				slang.definition = line.substring(i+1, line.length());
				slang.keyWord=getKeyWord(slang.definition);
				}
				
			}
			return slang;
		
	}
	
	static ArrayList<String> getKeyWord(String definition) {//separate every single word in a line after omitting space and marks
		int j = 0;
		boolean isEndingSpace = true;
		ArrayList<String>  arr = new ArrayList<String>();
		for(int i = 0 ; i<definition.length(); i++) {
			if(definition.charAt(i) == '|'   ) { //when encounter | then substring
				arr.add(definition.substring(j, i).replaceAll("\\s+",""));
				j=i+2;
				isEndingSpace = false;
			} else if(( i == definition.length()-1 )) {//when encounter last character then substring
				arr.add(definition.substring(j, i+1).replaceAll("\\s+",""));
				
			    
			} else if(definition.charAt(i) == ' ' && isEndingSpace == true) {//when encounter space then substring
				arr.add(definition.substring(j, i+1).replaceAll("\\s+",""));
				j=i;
				isEndingSpace = true;
			}
		}
		return arr;
	}
	
	public void writeOnFile(String file,String data) {
		try {
			 FileWriter myWriter = new FileWriter(file,true);
		      myWriter.write(data);
		      myWriter.write("\n");
		      myWriter.close();
		}
		catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
	}
	
	public void createFile(String filename) {
	try {
		File file = new File(filename);
		if(file.createNewFile()) {
			System.out.println("...");
		}
	}catch (IOException e) {
	      System.out.println("An error occurred.");
	      e.printStackTrace();
	      }
	}
	
	public void deleteFile(String filename) {
		File file = new File(filename);
		if(file.delete()) {
			System.out.println("...");
		}
	}
	
	public void writeHistory(String line) {
		String file = "history.txt";
		FileHandling fileHndl = new FileHandling();
		fileHndl.writeOnFile(file, line);
	}
	
	public void printHistory() {
		try {
			BufferedReader br = new BufferedReader(new FileReader("history.txt"));
			String str ;
			while (true)
			{
				str = br.readLine();
				System.out.println(str);
				
				if(str == null)
					break;
				
			}
			br.close();
		}
		catch(IOException ie) {
            ie.printStackTrace();
        }  
	}
	
}
