package slangDictonary;
import java.io.*; 
import java.util.Scanner;
import file.FileHandling;

public class SlangDictionary {
	public static void main(String[] args) {
		
		
		System.out.println("Hello my friend");
		System.out.println("Welcome to Slang Word Dictionary");
		System.out.println("We are offering you some services below for you:");
		System.out.println("1.FInd the meaning by slang keyword..");
		
		System.out.println("Enter the number please:");
		Scanner myObj = new Scanner(System.in);
		int num = myObj.nextInt();  
		
		FileHandling file = new FileHandling();
		file.readFile();
		
		switch(num) {
		case 1:{
			
		}
		}
		
		
	}
}
