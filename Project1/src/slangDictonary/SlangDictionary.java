package slangDictonary;
import java.io.*; 
import java.util.Scanner;
import file.FileHandling;
import java.util.ArrayList;
import slangDictonary.SlangWord;
import java.io.File;
import java.lang.Math; 

public class SlangDictionary { 
	// For service 1 : Find the meaning when you enter the slang
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
	
	//For service 2: Enter a word then find all the slang 
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
	
	//For service 4: add a new slang
	static void addSlang(String key,String definition,ArrayList<SlangWord> slang) {
		int count = 0 ;
		for(int i = 0 ; i<slang.size();i++) {
			//always checking null 
			if(slang.get(i) == null)
				break;
			// if entered slang already existed
			if(slang.get(i).slangWord.compareTo(key) == 0) {
				System.out.println("This slang has already existed!");
				System.out.println("1)Override it ....2)Duplicate it");
				
				 Scanner myLine = new Scanner(System.in);
				 int num = myLine.nextInt();
				 if(num == 1) { //you want to override
					 editSlang(key,key,definition,slang);//Use edit function to override the slang
					 System.out.println("Overriden!!");
					//you want to duplicate	
				 } else {
					 FileHandling file  = new FileHandling();
					 String filename = "slang.txt";
					 String newLine = slang.get(i).slangWord + "`" + slang.get(i).definition;
					 file.writeOnFile(filename, newLine);//append at the end of file
					 System.out.println("Duplicated!!");
						
				 }
				 
				count ++;
				break;
				
			}
			} //you can add a new one cuz the entered word is totally new
		if(count == 0) {
			FileHandling fileHndl =  new FileHandling();
			String file = "slang.txt";
			String newLine = key + "`" + definition;
			fileHndl.writeOnFile(file, newLine);
			System.out.println("Successfully adding a new slang");
		}
	}
	
	static void deleteSlang(String key,ArrayList<SlangWord> slang) {
		String filename ="slang.txt";
		FileHandling fileHndl = new FileHandling();
		int count = 0 ;
		fileHndl.deleteFile(filename);//delete the file before a slang is chosen to be removed
		fileHndl.createFile(filename);// create a new one 
		for(int i = 0 ; i<slang.size();i++) {
			//always checking null 
			if(slang.get(i) == null)
				break;
			if(slang.get(i).slangWord.compareTo(key) != 0) {
				
				String line = slang.get(i).slangWord + "`" + slang.get(i).definition;//combine 2 strings because the line in txt file is separated in the arrayList
				fileHndl.writeOnFile(filename, line);// make a new file after doing the deletion 
			} else {
				count++;
			}  
		}
		if(count == 0) { // you can't find any match the key you want to remove
			System.out.println("Found no slang to delete");
		} else {
			System.out.println("Deleted the slang");
		}
	}
	
	static void editSlang(String key,String newKey,String newDefinition,ArrayList<SlangWord> slang ) {
		String filename ="slang.txt";
		FileHandling fileHndl = new FileHandling();
		int count = 0 ;
		fileHndl.deleteFile(filename);//delete the file before a slang is chosen to be removed
		fileHndl.createFile(filename);// create a new one
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
	
	static void resetList() {
		String slangFile ="slang.txt";
		String originalFile = "original.txt";
		FileHandling fileHndl = new FileHandling();
		ArrayList<SlangWord> slang = new ArrayList<SlangWord>();
		fileHndl.readFile(slang,originalFile);
		int count = 0 ;
		fileHndl.deleteFile(slangFile);
		fileHndl.createFile(slangFile);
		for(int i = 0 ; i<slang.size();i++) {
			String line = slang.get(i).slangWord + "`" + slang.get(i).definition;
			fileHndl.writeOnFile(slangFile,line );
		}
	}
	
	static SlangWord randSlang(ArrayList<SlangWord> slang) {
		
		int max = 0; 
        int min = 0; 
       
       
        
        // generate random numbers within 1 to 10 
        for(int i = 0 ; i<slang.size();i++) {
           max++;
          
          
        } 
        int range = max - min + 1; 
        int rand = (int)(Math.random() * range) + min; 
        SlangWord line = new SlangWord();
        for(int i = 0 ; i<slang.size();i++) {
        	if(i == rand) {
        		
        		line.slangWord =slang.get(i).slangWord;
        		line.definition = slang.get(i).definition;
        		return line;
        		
        	}
             
         } 
        return line;
	}
	
	//this function do the giving the 4 answers randomly based on the correct answer
	static void arrangeRiddle(String rightAnswer,ArrayList<SlangWord> slang,int type) {
		String[] answers = new String[4];
		int max = 3; 
        int min = 0; 
        int range = max - min + 1; 
        int rand = (int)(Math.random() * range) + min;// chose a random number for correct answer
        String answer;
        for(int i = 0 ;i < answers.length ;i++) {
        	if(i==rand) { // this is the index for the correct answer
        		
        		answers[i]= rightAnswer;
        		System.out.println(i+1 +")" + answers[i]);
        		
        	} else {
        		//type is used to tell apart service 9 and service 10 of riddle
        		if(type==1) {
        			 answer = randSlang(slang).definition;
        		} else {
        			answer = randSlang(slang).slangWord;
        		}
        		answers[i]=answer;
        		System.out.println(i+1 +")" + answers[i]);// for all the wrong answers left
        	}
        }
        System.out.println("----------Guessing Time--------");
        int yourAnswer = rand + 1;
        checkAnswer(yourAnswer);// para 'yourAnswer'  is to help the function check know which one is correct out of 4'
  
	}
	
	static void checkAnswer(int num) {
		System.out.println("Enter the your answer please:");
		Scanner myLine = new Scanner(System.in);
		int answer = myLine.nextInt();
		
		if( (answer) == num) {
			System.out.println("Congratulations!!You are correct");
		} else {
			System.out.println("You are not lucky this time :(( Let's try again");
		}
	}
	static void riddle2(ArrayList<SlangWord> slang) { //for service 10
		SlangWord randWord = randSlang(slang);// help give a random definition for the question
				 System.out.println("What slang should this definition " + randWord.definition +  " be transformed ?");
				 System.out.println();	
				 arrangeRiddle(randWord.slangWord,slang,2);//ranWord.slangWord is the answer for the question
	}
	
	static void riddle1(ArrayList<SlangWord> slang) { //for service 9
		SlangWord randWord = randSlang(slang);// help give a random slang word for the question
	
				 System.out.println("What does this slang " + randWord.slangWord +  " mean ?");
				 System.out.println();
				 arrangeRiddle(randWord.definition,slang,1);		
	}
	
	public static void main(String[] args) {
		
		//------------------------Put the data in txt file into the ArrayList
		FileHandling file = new FileHandling();
		String filename = "slang.txt";
		ArrayList<SlangWord> slang = new ArrayList<SlangWord>();
		file.readFile(slang,filename);
		//------------------------

		
		int click=-1 ;
		while(click != 0) {
			SlangDictionary sl = new SlangDictionary();
			System.out.println("Hello my friend");
			System.out.println("Welcome to Slang Word Dictionary");
			System.out.println("We are offering you some services below for you:");
			System.out.println("1.Find the meaning by slang word..");
			System.out.println("2.Find the slang by definition..");
			System.out.println("3.Show your history..");
			System.out.println("4.Add a new slang..");
			System.out.println("5.Edit a slang..");
			System.out.println("6.Delete a slang..");
			System.out.println("7.Reset the list slang..");
			System.out.println("8.Give a random slang..");
			System.out.println("9.Riddle 1..");
			System.out.println("10.Riddle 2..");
			System.out.println("0.To Escape..");
			System.out.println("Enter the number please:");
			Scanner myLine;
			
			myLine = new Scanner(System.in);
			int num = myLine.nextInt();  
			
						
			
			
			switch(num) {
			case 0:{
				click = 0;
				
				break;
			}
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
				file.writeHistory(key);
				System.out.println("Enter the definition you want to add please:");
				file.writeHistory(key);
				String definition = myLine.nextLine();
				addSlang(key,definition,slang);
				break;
			}
			case 5: {
				System.out.println("Enter the key word you want to change:");
				myLine = new Scanner(System.in);
				String key = myLine.nextLine();
				file.writeHistory(key);
				
				System.out.println("Enter the new key word you:");
				myLine = new Scanner(System.in);
				String newKey = myLine.nextLine();
				file.writeHistory(key);
				
				System.out.println("Enter the definition for your new slang:");
				myLine = new Scanner(System.in);
				String newDefinition = myLine.nextLine();
				file.writeHistory(key);
				
				editSlang(key,newKey,newDefinition,slang);
				break;
			}
			case 6:{
				System.out.println("Enter the key word you want to delete please:");
				myLine = new Scanner(System.in);
				String key = myLine.nextLine();
				file.writeHistory(key);
				deleteSlang(key,slang);
				break;
			}
			
			case 7:{
				System.out.println("Reseting....");
				resetList();
				break;
			}
			case 8:{
				System.out.println("Getting randomly....");
				System.out.println("Random word is:" + randSlang(slang).slangWord +" : " + randSlang(slang).definition);
				
				break;
			}
			case 9:{
				System.out.println("---------RIDDLE TIME:--------------");
				System.out.println(".....");
				riddle1(slang);
				
				break;
			}
			
			case 10:{
				System.out.println("---------RIDDLE TIME:--------------");
				System.out.println(".....");
				riddle2(slang);
				
				break;
			}
			
			}
			 System.out.println("______________________");
			 System.out.println("0.Escape  1.Continue on with the program");
			 myLine = new Scanner(System.in);
			 int key = myLine.nextInt();
			 
			 if(key == 0) {
				 click = 0;
			 } 
			 System.out.println("Program has terminated.Thank you for using!");
		}
	
		
	}
	
	
}
