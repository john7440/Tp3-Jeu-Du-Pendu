package fr.ex.tp3;
import java.util.Random;
import java.util.Scanner;

public class Main {
	
	
	public static String randomizer(String[] wordList) {
		
		// Randomization
		Random random = new Random();
		int rdmIndex = random.nextInt(wordList.length);
		return wordList[rdmIndex];
		
	}
	
	public static char [] hidingWordFromUser(String word) {
		
		char[] hiddenWord = new char[word.length()];
        for (int i = 0; i < word.length(); i++) {
            hiddenWord[i] = '_';
        }
        return hiddenWord;
	}
	
	public static void displayHidenWord(char[] hidden) {
		
		// Affichage
		System.out.println("Mot mystère : ");
		for (char c: hidden) {
			System.out.print(c + " ");
		}
		System.out.println();
	}
	
	public static boolean updatingHiddenWord(String word, char[]hidden, char userInput) {
		
		// verification
		boolean found = false;
		for (int i =0; i < word.length(); i++) {
			if (word.charAt(i) == userInput) {
				hidden[i] = userInput;
				found = true;
			}
		}
		return found;
	}
	
	public static boolean winCondition(char[] hidden) {
		for (char c : hidden) {
			if (c == '_') return false;
		}
		return true;
	}

	public static void main(String[] args) {
		
		// Our data
		String[] wordsList = {"cookie", "chocolat", "patisserie", "anticonstitutionnelement", "sandwich", "marteau", "capitalisme", "alphabet", "confiture"};
		
		String randomizedWord = randomizer(wordsList);
		char[] hidedWord = hidingWordFromUser(randomizedWord);
		
		// Scanner
		Scanner scan = new Scanner(System.in);
		
		//nombre d'essais
		int tryLeft = 10;
		
		while (!winCondition(hidedWord) && tryLeft > 0) {
			displayHidenWord(hidedWord);
			System.out.println("Entrez une lettre: ");
			char usrChoice = scan.next().toLowerCase().charAt(0);
			
			if (updatingHiddenWord(randomizedWord, hidedWord, usrChoice)) {
				System.out.println("Bien joué !");
            } else {
            	tryLeft--;
                System.out.println("Raté ! il vous reste " + tryLeft + " essais !");
            }
					
		}
		
		if (winCondition(hidedWord)) {
			System.out.println("Bravo ! Le mot était : " + randomizedWord);
		} else {
			System.out.println("Vous avez perdu! Le mot était : " + randomizedWord);
			
		}
		scan.close();
			
		}

	}


