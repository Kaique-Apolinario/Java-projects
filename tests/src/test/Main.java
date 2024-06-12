package test;

import java.util.Scanner;

import entities.Template;

public class Main {

	public static void main(String[] args) {
		System.out.println("Hello! Welcome to the Tic-Tac-Toe!\n");
		String playAgain = null;
		Scanner type = new Scanner(System.in);

		// Show template
		while (playAgain != "N") {
			Template.showBoard(0, "", true);
			boolean firstGame = false;
			boolean winner = false;
			int spot;
			String letter = "X";
			while (winner != true) {
				System.out.println("\nPlease, choose where are you going to put " + letter + " at");
				spot = type.nextInt();
				Template.showBoard(spot, letter, firstGame);
				winner = Template.verifyWinner();
				if (letter == "X") {
					letter = "O";
				} else if (letter == "O") {
					letter = "X";
				}
			}
			if (winner = true) {
				System.out.println("Congratulations! " + letter + " won!");
			}
			System.out.println("Do you want to play again?");
			playAgain = type.next();
		}
		type.close();
	}
}
