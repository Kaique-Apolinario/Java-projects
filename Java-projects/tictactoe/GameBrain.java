package tictactoe;

public class GameBrain {
	static int backspace = 0;
	static int breakline = 0;
	static int round = 0;


	
	public static void showTable(String[][] table, int choice, String player, char representation){
		int position = 1;
		for (int x=0;x<3;x++) {
			for (int y=0;y<3;y++) {
				 if (round == 0) {
					table[x][y] = Integer.toString(position);
				 } else if (choice == position) {
					table[x][y] = Character.toString(representation);
				}
				position++;	
				System.out.print("  "+ table[x][y]);
				backspace++;
				if (backspace < 3) { 
					System.out.print("  |");
				}

				if (backspace == 3) {
					if (breakline < 2) {
						breakline++;
						System.out.print("\n ————————————————\n");
					}
					backspace = 0;
				};
			}
		}
		breakline = 0;
		round++;
	}

	public static boolean checkDisponibility(String[][] table, int position, String personOrPc) {
		for (int x=0;x<3;x++) {
			for (int y=0;y<3;y++) {
				if (table[x][y].equals(Integer.toString(position))) {
					return true;
				}
			}
		}
		if (personOrPc.equals("Person")) {
			System.out.println("Oops! This spot is invalid. Try again!");
		}
		return false;
	}


	public static boolean checkWinner(String[][] table, String player){
		if (table[0][0].equals(table[1][1]) && table[1][1].equals(table[2][2])) {
			round = 0;
			System.out.println("\n\n"+ player +" IS THE WINNER!!!");
			return true;
		}
		for (int x=0;x<3;x++) {
			if (table[x][0].equals(table[x][1]) && table[x][1].equals(table[x][2])){
				round = 0;
				System.out.println("\n\n"+ player +" IS THE WINNER!!!");
				return true;
			} else if (table[0][x].equals(table[1][x]) && table[1][x].equals(table[2][x])){
				round = 0;
				System.out.println("\n\n"+ player +" IS THE WINNER!!!");
				return true;
			} else if (table[0][2].equals(table[1][1]) && table[1][1].equals(table[2][0])) {
				round = 0;
				System.out.println("\n\n"+ player +" IS THE WINNER!!!");
				return true;
			}
		}
		return false;
	}
	
	public static boolean checkDraw(String[][] table) {
		if (round == 10) {
			round = 0;
			System.out.println("\n\nNo one is the winner.");
			return true;
		} else {
			return false;
		}
	}
	
}

