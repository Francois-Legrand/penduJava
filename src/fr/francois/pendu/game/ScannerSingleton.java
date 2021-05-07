package fr.francois.pendu.game;

import java.util.Scanner;

public class ScannerSingleton {
	private static ScannerSingleton myScanner;
	private Scanner scanner = new Scanner(System.in);
	
	private ScannerSingleton() {
		
	}
	
	public static synchronized ScannerSingleton getInstance() {
		if (myScanner == null) {
			myScanner = new ScannerSingleton();
		}
		return myScanner;
	}
	
	public Scanner getScanner() {
		
		return scanner;
		
	}
}
