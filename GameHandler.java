import java.util.Random;
import java.util.Scanner;

public class GameHandler {
	Player playerOne;
	Player playerTwo;
	PlayField field;
	Scanner scan;
	int size;
	
	public static void main (String[] args) {
		GameHandler game = new GameHandler();
		
		game.prepareGameLoop();
		game.startGameLoop();
	}
	
	//Initializing the instance variables outside the loop seemed like a good idea.
	public void prepareGameLoop() {
		int size = 3;
		
		playerOne = new HumanPlayer("O");
		//playerOne = new ComputerPlayer("O", size);
		
		//playerTwo = new HumanPlayer("X");
		playerTwo = new ComputerPlayer("X", size);
		
		field = new PlayField(size, size);
		scan = new Scanner(System.in);
		
		System.out.printf("To play this game enter a number ranging from 1 - %d. \r\n", size * size);
	}
	
	//This loop will keep on going until the program is shutdown or someone has won.
	public void startGameLoop() {
		while(true) {
			playerOne.prepareTurn();
			playerOne.makeMove(field, scan);
			field.print();
			if(field.checkWinner(playerOne))
				break;
			
			playerTwo.prepareTurn();
			playerTwo.makeMove(field, scan);
			field.print();
			if(field.checkWinner(playerTwo))
				break;
		}
	}
	
	
}
