package fr.ex.tp3;
import java.util.Random;

public class Main {

	public static void main(String[] args) {
		
		String[] wordsList = {"cookie", "chocolat", "patisserie", "anticonstitutionnelement", "sandwich", "marteau", "capitalisme", "alphabet", "confiture"};
		
		// Randomization
		Random random = new Random();
		int rdmIndex = random.nextInt(wordsList.length);
		String randomizedWord = wordsList[rdmIndex];
		
		System.out.println(randomizedWord);
		
		// Modifications
		String hidedWord = randomizedWord.replaceAll(".", "_ ");
		
		System.out.println("Mot Mystère: " + hidedWord);

	}

}
