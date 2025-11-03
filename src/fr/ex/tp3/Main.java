package fr.ex.tp3;
import java.util.Random;
import java.util.Scanner;

public class Main {
	
	public static String userInput() {
		
		Scanner scan = new Scanner(System.in);
		String usrChoice  = scan.next();
		scan.close();
		return usrChoice;
	}
	
	public static String randomizer(String[] wordList) {
		
		// Randomization
		Random random = new Random();
		int rdmIndex = random.nextInt(wordList.length);
		return wordList[rdmIndex];
		
	}
	
	public static String hidingWordFromUser(String word) {
		
		// Modifications
		String hidedWord = word.replaceAll(".", "_ ");
		return hidedWord;
	}

	public static void main(String[] args) {
		
		String[] wordsList = {"cookie", "chocolat", "patisserie", "anticonstitutionnelement", "sandwich", "marteau", "capitalisme", "alphabet", "confiture"};
		
		
		String randomizedWord = randomizer(wordsList);
		
		
		
		
		System.out.println("Mot Mystère: " + hidingWordFromUser(randomizedWord));
		
		System.out.println("Veuilez entrer une lettre: ");
		String userChoice = userInput();
		
			
		}

	}


