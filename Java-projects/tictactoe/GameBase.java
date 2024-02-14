package tictactoe;
import java.util.Scanner;
import java.util.Random;

public class GameBase {
	public static void main(String[] args) throws InterruptedException {
		// TicTacToe's space creation
		Scanner type = new Scanner(System.in);
		Random random = new Random();
		int position = 0;
		String[][] table = new String[3][3];


		//Menu - Start or Exit
		System.out.print("Welcome to \"Jogo da Velha\". Are you ready? Y for 'yes' or N to exit.\n");
		String menugame = type.nextLine().toUpperCase().trim();
		menugame = InputValidation.YNValid(menugame, type);
		

		// Choose between to play against the computer or a friend
		do {
			if (menugame.equals("Y")) {
				System.out.println("\nDo you want to play against:\n[1] A computer\n[2] Somebody else");
				menugame = InputValidation.OneTwoValid(type.nextLine().toUpperCase().trim(), type);
				
				
				//Start the game against computer
				if (menugame.equals("1")){
					GameBrain.showTable(table, 0, "", "O".charAt(0));
					System.out.print("\n\nYou're 'X' and the computer 'O'.");
					while (true) {
						System.out.println("\nPlease, choose the position you want to put 'X'.\n"); //Player choice
						do {
							position = InputValidation.IntValid(type);
							} while (GameBrain.checkDisponibility(table, position, "Person") == false); //Check if the chosen space is free
						
						
						//Check if there's a winner before the computer's time
						GameBrain.showTable(table, position, "player", "X".charAt(0));
						if (GameBrain.checkWinner(table, "PLAYER")) { 
							break;
						} else {
							if (GameBrain.checkDraw(table)) { //Check if there's a draw
								break;
							}
						}
						System.out.print("\n\nNow's computer turn. It is thinking.....\n\n");
						Thread.sleep(3000);
						do {
							position = random.nextInt(9);
						} while (GameBrain.checkDisponibility(table, position, "Pc") == false); //Check if the chosen space is free
						GameBrain.showTable(table, position, "PC", "O".charAt(0));
						if (GameBrain.checkWinner(table, "PC")) { //Check if there's a winner before the player's time
							break;
						} else {
							if (GameBrain.checkDraw(table)) {//Check if there's a draw
								break;
							}
						}
					}
					
					
				//Start game against a friend
				} else if (menugame.equals("2")){
					String[][] players = new String[2][2];
					for (int i=0; i<2; i++) {
						System.out.print("\nPlayer " + (i+1) + ", how do you want to be called? "); //Players data
						players[0][i] = InputValidation.NameValid(type.next());
						do {
							System.out.print("\nWhich character you want to be represented by? ");
							players[1][i] = Character.toString(type.next().charAt(0)).toUpperCase();
						if (i == 1 && players[1][0].equals(players[1][1])) {
							System.out.println("Oops! This character is already used, try another one.");
							}
						} while (players[1][0].equals(players[1][1]));
					}
					GameBrain.showTable(table, 0, "", "_".charAt(0));
					TwoPlayersLoop:
					do {
						for (int i=0; i<2; i++) {
							System.out.println("\n\n" + players[0][i] + ", please, choose the position you want to put "+ players[1][i] +" at.\n");
							do {
								position = InputValidation.IntValid(type);
							} while (GameBrain.checkDisponibility(table, position, "Person") == false); //Check if the chosen space is free
							GameBrain.showTable(table, position, "player", players[1][i].charAt(0));
							if (GameBrain.checkWinner(table, players[0][i])) { //Check if there's a winner
								break TwoPlayersLoop;
							} else if (GameBrain.checkDraw(table)) { //Check if there's a draw
								break TwoPlayersLoop;
								}
							}
					} while (true);
				}
			} else {
				break;
			}
			
			//Play again or exit
			System.out.print("\nDo you want to play once again? Type 'Y' for YES or 'N' for NO.\n");
			menugame = InputValidation.YNValid(type.nextLine().toUpperCase().trim(), type);
		} while (!(menugame == "Y"));


		type.close();
		System.out.println("\nBye, bye!");
	}
}