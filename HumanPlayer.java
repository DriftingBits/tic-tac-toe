import java.util.Random;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.lang.ArrayIndexOutOfBoundsException;


public class HumanPlayer implements Player {
	private String color;
	
	//The string "color" determines whether this player should appear as a circle or a cross.
	public HumanPlayer(String color) {
		this.color = color;
	}
	
	@Override
	public void prepareTurn() {
		System.out.printf("Player %s's turn.\r\n", color);
	}
	
	@Override
	public void makeMove(PlayField field, Scanner scan) {
		while(true) {
			System.out.printf("Player %s, please enter a valid number: ", color);
			try {
				int move = scan.nextInt();
				if(!field.isCellOccupied(move - 1)) {
					field.setCell(move - 1, color);
					return;
				}
			} catch (InputMismatchException e) {
				scan.next();
			} catch (ArrayIndexOutOfBoundsException e) {
				continue;
			}
		}
	}
	
	@Override
	public String getColor() {
		return color;
	}
}
