package entities;

public class Template {
	public static String[][] template = new String[3][3];

	public static String[][] getTemplate() {
		return template;
	}

	public static void setTemplate(String[][] template) {
		Template.template = template;
	}

	public static void showBoard(int spot, String letter, boolean firstGame) {
		int place = 0;
		for (int column = 0; column < 3; column++) {
			for (int row = 0; row < 3; row++) {
				place++;
				if (place == spot) {
					template[row][column] = letter;
				} else if ((template[row][column] != "X" && template[row][column] != "O") || firstGame == true) {
					template[row][column] = Integer.toString(place);
				}
				System.out.print(" " + template[row][column] + " |");
			}
			System.out.print("\n");
			if (column < 2) {
				System.out.println("————————————");
			}
		}
	}

	public static boolean verifyWinner() {
		for (int rowNColumn = 0; rowNColumn < 3; rowNColumn++) {
			if (template[rowNColumn][0] == template[rowNColumn][1]
					&& template[rowNColumn][1] == template[rowNColumn][2]) {
				return true;
			}
			if (template[0][rowNColumn] == template[1][rowNColumn]
					&& template[1][rowNColumn] == template[2][rowNColumn]) {
				return true;
			}
			if (template[0][2] == template[1][1] && template[1][1] == template[2][0]) {
				return true;
			}
		}
		return false;

	}
}
