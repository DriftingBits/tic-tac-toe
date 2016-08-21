import java.util.Random;
import java.util.Scanner;

public class ComputerPlayer extends Player {
	String color;
	Random rand;
	
	public ComputerPlayer(String color) {
		this.color = color;
		rand = new Random();
	}
		
	@Override
	public void prepareTurn() {
		System.out.printf("Player %s's turn.\r\n", color);
		//Maybe use some algorithm to check for the best move		
	}

	@Override
	public void makeMove(PlayField field, Scanner scan) {
		while(true) {
			int move = rand.nextInt(9) + 1;
			
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
