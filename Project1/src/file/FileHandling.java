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
	
	public void readFile(ArrayList<SlangWord> slang) {
		try {
		
			//ArrayList<SlangWord> 
			//slang = new ArrayList<SlangWord>();
			
			BufferedReader br = new BufferedReader(new FileReader("/Users/macbookpro/git/slangDictionary/Project1/src/file/slang.txt"));
			String str ;
			int i = 0 ;
			while (i<700)
			{
				str = br.readLine();
				
				slang.add(separateString(str));
				if(str == null)
					break;
				i++;
				
			}
			br.close();
		}
		catch(IOException ie) {
            ie.printStackTrace();
        }   
		
	}
	
	static SlangWord separateString(String line) {
		SlangWord slang = new SlangWord();
		for(int i = 0 ; i<line.length();i++) {
			
				 char c = line.charAt(i);
				if(c == '`') {
				slang.slangWord = line.substring(0, i)	;
				slang.definition = line.substring(i+1, line.length());
				}
			}
			return slang;
		
	}
	
	public void writeHistory(String line) {
		try {
		      FileWriter myWriter = new FileWriter("/Users/macbookpro/git/slangDictionary/Project1/src/file/history.txt",true);
		      //while(nyWriter!=null) {
		    	  
		      //}
		      myWriter.write(line);
		      myWriter.write("\n");
		      myWriter.close();
		      System.out.println("Successfully wrote to the file.");
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
	}
	
}
