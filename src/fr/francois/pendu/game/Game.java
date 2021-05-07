package fr.francois.pendu.game;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class Game {

	String mot;
	
	public Game(String file) {
		Path path = Paths.get(file);
		
		try {
			List<String> listMots = Files.readAllLines(path);
			
			mot = listMots.get(new Random().nextInt(listMots.size()));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void run() {
		int nbEssai = 0;
		char caratere = 0;
		String tmpWord = initTmpWord();
		
		display(tmpWord + "\n");
		while(nbEssai < 7 && !tmpWord.equals(mot)) {
			System.out.println("Choisi une letrre : \n");
			caratere = ScannerSingleton.getInstance().getScanner().nextLine().charAt(0);
			if(mot.contains(Character.toString(caratere))) {
				tmpWord = checkWord(caratere, tmpWord);
			}else {
				System.out.println(DesignPendu.DESIGNPENDU[nbEssai++] + "\n");
			}
			System.out.println(tmpWord + "\n");
		}
		System.out.println(nbEssai < 7 ? "Tu as gangé!" : "Tu as perdu!");
		
	}
	private String checkWord(char caractere, String tmpWord) {
		StringBuilder setMot = new StringBuilder(tmpWord);
		if(tmpWord.contains(Character.toString(caractere))) {
			System.out.println("Tu as déjà proposé cette lettre");
		}else {
			IntStream.range(0, mot.length()).filter(index -> mot.charAt(index) == caractere).forEach(index -> setMot.setCharAt(index, caractere));
		}
		return setMot.toString();
	}
	private String initTmpWord() {
		//String mo = "";
		StringBuilder concatMot = new StringBuilder();
		IntStream.range(0, mot.length()).forEach(charIndex -> concatMot.append("_"));
//		for(int i = 0; i < mot.length(); i++) {
//			
//			mo += "_";
//		}
		return concatMot.toString();
		
	}
	private void display(String lettres) {
		lettres.chars().forEach(charIndex -> System.out.print((char) charIndex + " "));
		System.out.println("");
	}

}
