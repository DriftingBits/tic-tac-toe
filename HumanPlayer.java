import java.util.Random;
import java.util.Scanner;


public class HumanPlayer extends Player {
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
			int move = scan.nextInt();
			
			//Because arrays start at 0 and you are supposed to enter a number from 1 - 9, "move - 1" is used.
			if(!field.isCellOccupied(move - 1)) {
				field.setCell(move - 1, color);
				return;
			}
		}
	}
	
	@Override
	public String getColor() {
		return color;
	}
}
