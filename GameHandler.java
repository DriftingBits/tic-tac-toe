package nl.bryanwesterveld;

import java.util.Scanner;

public class GameHandler {
	Player playerOne;
	Player playerTwo;
	PlayField field;
	Scanner scan;
	
	public static void main (String[] args) {
		GameHandler game = new GameHandler();
		
		game.prepareGameLoop();
		game.startGameLoop();
	}
	
	//Initializing the instance variables outside the loop seemed like a good idea.
	public void prepareGameLoop() {
		playerOne = new HumanPlayer("O");
		//playerOne = new ComputerPlayer("O");
		
		//playerTwo = new HumanPlayer("X");
		playerTwo = new ComputerPlayer("X");
		
		field = new PlayField();
		scan = new Scanner(System.in);
		
		System.out.println("To play this game enter a number ranging from 1 - 9.");
	}
	
	//This loop will keep on going until the program is shutdown or someone has won.
	public void startGameLoop() {
		while(true) {
			playerOne.prepareTurn();
			playerOne.makeMove(field, scan);
			field.print();
			if(field.checkWinner()) {
				System.out.printf("Player %s has won!", playerOne.getColor());
				break;
			}
			
			playerTwo.prepareTurn();
			playerTwo.makeMove(field, scan);
			field.print();
			if(field.checkWinner()) {
				System.out.printf("Player %s has won!", playerTwo.getColor());
				break;
			}
		}
	}
	
	
}
