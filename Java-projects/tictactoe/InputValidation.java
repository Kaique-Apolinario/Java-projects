package tictactoe;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputValidation {

	
	//"Yes" or "No" validation
	public static String YNValid(String menugame, Scanner type) {
		while (!(menugame.equals("Y") || menugame.equals("N"))){
			System.out.println("Oops! Not a valid choice. Try again!");
			menugame = type.nextLine().toUpperCase().trim();
		}
		return menugame;
	}
	//"1" or "2" validation
	public static String OneTwoValid(String menugame, Scanner type) {
		while (!(menugame.equals("1") || menugame.equals("2"))){
			System.out.println("Oops! Not a valid choice. Try again!");
			System.out.println("\nDo you want to play against:\n[1] A computer\n[2] Somebody else");
			menugame = type.nextLine().toUpperCase().trim();
		}
		return menugame;
	}
	//Integer validation
	public static int IntValid(Scanner type) {
		int position = 0;
		boolean validation;
		do {
		validation = true;
			try {
				position = type.nextInt();
				type.nextLine();
				} catch (InputMismatchException e){
					validation = false;
					System.out.println("Oops! Not a valid position. Try again!");
				}
			} while (validation == false);
		return position;
	}
	//Capitalizing player's names
	public static String NameValid(String playername) {
		String capitalizing = playername.substring(0, 1).toUpperCase();
		String lowercase = playername.substring(1);
		return capitalizing + lowercase;
	}
	
}
