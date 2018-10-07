package edu.wofford;

import java.util.Scanner;

public class ConsoleMain {

	public static void main(String[] args) {
		TicTacToeModel theGame = new TicTacToeModel();

		Scanner scanner = new Scanner(System.in);

		while(!theGame.IsGameOver()){

				System.out.println("-----------");
				System.out.println("Game Status:\n");
				System.out.println(theGame.toString());
				System.out.print("\nSet next mark \"row col\": ");

				Scanner subScanner = new Scanner(scanner.nextLine());

				theGame.setMarkAt(subScanner.nextInt(), subScanner.nextInt());

		}

		System.out.println("\n" + theGame.toString() + "\n");
		System.out.println(theGame.getResultStr());
	}
}
