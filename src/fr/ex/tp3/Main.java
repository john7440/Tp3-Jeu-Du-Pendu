package fr.ex.tp3;
import java.util.Set;
import java.util.HashSet;
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
		System.out.println("\nMot mystère : ");
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
		
		// The List of words that can be used in our game
		String[] wordsList = {"cookie", "chocolat", "patisserie", "anticonstitutionnelement", "sandwich", "marteau", "capitalisme", "alphabet", "confiture"};
		
		String randomizedWord = randomizer(wordsList);
		char[] hidedWord = hidingWordFromUser(randomizedWord);
		
		// Scanner
		Scanner scan = new Scanner(System.in);
		
		// Number of fail authorized (10 by default)
		int tryLeft = 10;
		
		// We initialize a set a of character to store previous guesses
		Set<Character> inputList = new HashSet<>();
		
		while (!winCondition(hidedWord) && tryLeft > 0) {
			displayHidenWord(hidedWord);
			System.out.println("Entrez une lettre: (déja utilisé " + inputList + "): ");
			String usrInput = scan.next().trim().toLowerCase();
			
			// Check Input validity (must be length 1 and a letter)
			if (usrInput.length() !=1  || !Character.isLetter(usrInput.charAt(0))) {
				System.out.println("Entrée invalide! Veuillez entrer une seule lettre.");
				continue;
			}
			
			// If the input is good, then we "convert" it into a char
			char usrChoice = usrInput.charAt(0);
			
			// We check if the char was already tried before and display an error
			// message if that was the case
			if (inputList.contains(usrChoice)) {
				System.out.println("Lettre " + usrChoice + " déjà proposé!");
				displayHidenWord(hidedWord);
				
			} else {
				// Else we add the new char to the list
				inputList.add(usrChoice);
				
				if (updatingHiddenWord(randomizedWord, hidedWord, usrChoice)) {
					System.out.println("Bien joué !");
	            } else {
	            	tryLeft--;
	                System.out.println("Raté! {" + usrChoice + "} ne se trouve pas dans le mot!\nIl vous reste " + tryLeft + " essais !");
	                System.out.println("Lettres déjà proposées : " + inputList);
	            }
					
				}
			
		}
		
		// Check if the Win or Loose condition is true,
		// if it is then it display a message accordingly
		if (winCondition(hidedWord)) {
			System.out.println("Félicitations vous avez gagné en "+ tryLeft+" essais! Le mot était bien : " + randomizedWord);
		} else {
			System.out.println("Vous avez perdu! Le mot était : " + randomizedWord);
			
		}
		scan.close();
			
		}

	}


