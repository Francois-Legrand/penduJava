package fr.francois.pendu.test;

import fr.francois.pendu.game.Game;
import fr.francois.pendu.game.ScannerSingleton;

public class Main {

	public static void main(String[] args) {

		char response = '\0';
		do {
			new Game(args[0]).run();
			
			System.out.println("Rejouer une partie? y/n");
			
			response = ScannerSingleton.getInstance().getScanner().nextLine().charAt(0);
			
		} while (response == 'y');
		
		ScannerSingleton.getInstance().getScanner().close();
	}

}
