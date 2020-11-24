package slangDictonary;
import java.io.*; 
import java.util.Scanner;
import file.FileHandling;
import slangDictonary.SlangWord ;
import java.util.ArrayList;

public class SlangDictionary {
	
	public void SearchKey(String key,ArrayList<SlangWord> slang) {
		int count = 0 ;
		for(int i = 0 ; i<slang.size();i++) {
			if(slang.get(i).slangWord.compareTo(key) == 0) {
				System.out.println("Meaning: " + slang.get(i).definition);
				count ++;
				break;
			} 
			
		}
		if(count == 0)
		System.out.println("Cannot find any");
	}
	
	public static void main(String[] args) {
		SlangDictionary sl = new SlangDictionary();
		
		System.out.println("Hello my friend");
		System.out.println("Welcome to Slang Word Dictionary");
		System.out.println("We are offering you some services below for you:");
		System.out.println("1.FInd the meaning by slang keyword..");
		
		System.out.println("Enter the number please:");
		Scanner myLine;
		
		myLine = new Scanner(System.in);
		int num = myLine.nextInt();  
		
		FileHandling file = new FileHandling();
		ArrayList<SlangWord> slang = new ArrayList<SlangWord>();
		file.readFile(slang);
		
		switch(num) {
		case 1:{
			System.out.println("Enter the keyword please:");
			myLine = new Scanner(System.in);
			String key = myLine.nextLine();
			sl.SearchKey(key,slang);
			
		}
		}
		
		
	}
	
	
}
