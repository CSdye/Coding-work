package program5;
//Callen Dye
/* Task: perform the game battleship.
 * This program runs the board-game battleship on the console. 
 */
import java.util.Scanner;
import java.util.Random;

public class BattleShip {
	public static void main(String[] args) {
		GameBoard person = new GameBoard();
		GameBoard computer = new GameBoard();
		GameBoard peek = new GameBoard();
		Scanner scan = new Scanner(System.in);

		MyPlacement(person, scan);
		person.showBoard();
		peek.showBoard();
		CompPlacement(computer);
		Plays(person, computer, peek, scan);
		Stats(person, computer);
	}
	
	public static void MyPlacement(GameBoard person, Scanner scan) {
		boolean APlaced = false, BPlaced = false, SPlaced = false;
		person.showBoard();
		while (!APlaced) {
			System.out.print("Which row do you want the aircraft carrier?");
			int row = scan.nextInt();
			System.out.print("Which column do you want the aircraft carrier?");
			int col = scan.nextInt();
			System.out.print("Type [V] for vertical or [H] for horizantal");
			char orient = scan.next().toUpperCase().charAt(0);
			if (orient != 'V' && orient != 'H')
				System.out.println("Invalid orientation");
			else if (person.placeShip('A', row, col, orient))
				APlaced = true;
			else
				System.out.println("Invalid choice");

		} // Aircraft
		person.showBoard();
		while (!BPlaced) {
			System.out.print("Which row do you want the battleship ?");
			int row = scan.nextInt();
			System.out.print("Which column do you want the battleship?");
			int col = scan.nextInt();
			System.out.print("Type [V] for vertical or [H] for horizantal");
			char orient = scan.next().toUpperCase().charAt(0);
			if (orient != 'V' && orient != 'H')
				System.out.println("Invalid orientation");
			else if (person.placeShip('B', row, col, orient))
				BPlaced = true;
			else
				System.out.println("Invalid choice");
		} // BattleShip
		person.showBoard();
		while (!SPlaced) {
			System.out.print("Which row do you want the submarine ?");
			int row = scan.nextInt();
			System.out.print("Which column do you want the submarine?");
			int col = scan.nextInt();
			System.out.print("Type [V] for vertical or [H] for horizantal");
			char orient = scan.next().toUpperCase().charAt(0);
			if (orient != 'V' && orient != 'H')
				System.out.println("Invalid orientation");
			else if (person.placeShip('S', row, col, orient))
				SPlaced = true;
			else
				System.out.println("Invalid choice");
		} // Submarine
	}// MyPlacement
	//Place the computer ships on the board
	public static void CompPlacement(GameBoard computer) {
		boolean CAPlaced = false, CBPlaced = false, CSPlaced = false;
		Random rand = new Random();
		int rorient, row, col;
		char orient;

		while (!CAPlaced) {
			rorient = rand.nextInt(2);
			if (rorient == 0) {
				orient = 'H';
				row = rand.nextInt(10);
				col = rand.nextInt(6);
				if (computer.placeShip('A', row, col, orient))
					CAPlaced = true;
			}
			if (rorient == 1) {
				orient = 'V';
				row = rand.nextInt(6);
				col = rand.nextInt(10);
				if (computer.placeShip('A', row, col, orient))
					CAPlaced = true;
			}
		}
		while (!CBPlaced) {
			rorient = rand.nextInt(2);
			if (rorient == 0) {
				orient = 'H';
				row = rand.nextInt(10);
				col = rand.nextInt(7);
				if (computer.placeShip('B', row, col, orient))
					CBPlaced = true;
			}
			if (rorient == 1) {
				orient = 'V';
				row = rand.nextInt(7);
				col = rand.nextInt(10);
				if (computer.placeShip('B', row, col, orient))
					CBPlaced = true;
			}
		}
		while (!CSPlaced) {
			rorient = rand.nextInt(2);
			if (rorient == 0) {
				orient = 'H';
				row = rand.nextInt(10);
				col = rand.nextInt(6);
				if (computer.placeShip('S', row, col, orient))
					CSPlaced = true;
			}
			if (rorient == 1) {
				orient = 'V';
				row = rand.nextInt(6);
				col = rand.nextInt(10);
				if (computer.placeShip('S', row, col, orient))
					CSPlaced = true;
			}
		}
		System.out.println();
	}

	public static void Plays(GameBoard person, GameBoard computer, GameBoard peek, Scanner scan) {
		Random rand = new Random();
		int row, col;
		boolean test;
		while (!person.allSunk() && !computer.allSunk()) {
			test = true;
			while (test) {
				System.out.println("Enter the row you want to fire at: ");
				row = scan.nextInt();
				System.out.println("Enter the column you want to fire at: ");
				col = scan.nextInt();
				if (computer.validShot(row, col)) {
					computer.play(row, col, peek);
					test = false;
				}
				else
					System.out.println("TRY AGAIN!");
			}//end while
			peek.showBoard();
			test = true;
			while(test) {
				row = rand.nextInt(10);
				col = rand.nextInt(10);
				if(person.validShot(row, col)) {
					person.play(row, col);
					test = false;
				}
				person.showBoard();
				
				
			}//end while
		}//end big while

	}

	public static void Stats(GameBoard person, GameBoard computer)
	{
		if(computer.allSunk())
		{
			System.out.println("You won in " + computer.getPlays() + " shots");
		}
		else
		{
			System.out.println("The computer won in " + person.getPlays() + " shots");

		}
	}
}