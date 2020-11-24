package slangDictonary;
import java.io.*; 
import java.util.Scanner;
import file.FileHandling;
import java.util.ArrayList;
import slangDictonary.SlangWord;

public class SlangDictionary {
	
	static void SearchKey(String key,ArrayList<SlangWord> slang) {
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
	
	static void findAllSlangs(String key,ArrayList<SlangWord> slang) {
		int count = 0;
		for(int i = 0 ; i < slang.size(); i++) {
			for(int j = 0;j<slang.get(i).keyWord.size(); j++ ) {
				if(slang.get(i).keyWord.get(j).compareToIgnoreCase(key) == 0) {
					System.out.println(slang.get(i).slangWord);
					count++;
				}
			}
		}
		if(count == 0)
		System.out.println("Sorry!Can't find any match");
	}
	
	public static void main(String[] args) {
		
		//SlangDictionary sl = new SlangDictionary();
		System.out.println("Hello my friend");
		System.out.println("Welcome to Slang Word Dictionary");
		System.out.println("We are offering you some services below for you:");
		System.out.println("1.Find the meaning by slang word..");
		System.out.println("2.Find the slang by definition..");
		
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
		}
		
	}
	
	
}
