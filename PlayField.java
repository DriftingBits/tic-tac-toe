import java.util.Random;
import java.util.Scanner;

public class PlayField {
	private String[] cells;
	private int width;
	private int height;
	
	public PlayField(int width, int height) {
		cells = new String[width * height];
		this.width = width;
		this.height = height;
		
		for (int i = 0; i < width * height; i++){
			cells[i] = " ";
		}
	}
	
	//All empty cells have a space in them.
	public boolean isCellOccupied(int cellNumber) {
		if(cells[cellNumber].equals(" ")) 
			return false;
		else
			return true;
	}
	
	//The string "color" determines whether this player should appear as a circle or a cross.
	public void setCell(int cellNumber, String color) throws ArrayIndexOutOfBoundsException {
		cells[cellNumber] = color;
	}

	//Since it is a 1D array if you want to get a value from cells you need to multiple the width with the row, else you"ll get a number in the same row.
	public void print() {
		for(int row = 0; row < height; row++) {
			for(int column = 0; column < width; column++) {
				System.out.printf("| %s ", cells[(row*width)+column]);
			}
			System.out.print("| \r\n");
		}
	}
	
	public boolean checkWinner(Player player) {
		if(checkHor() || checkVer() || checkDia()) {
			System.out.printf("Player: %s has won!", player.getColor());
			return true;
		} else if (checkTie()){
			System.out.printf("There was a tie, please play another game!");
			return true;
		}
		return false;
	}
	
	//Since it is a 1D array if you want to get a value from cells you need to multiple the width with the row, else you"ll get a number in the same row.
	public boolean checkHor() {
		String[] recent = new String[3];
		for(int row = 0; row < height; row++){
			for(int i = 0; i < recent.length; i++)
				recent[i] = " ";
			
			for(int column = 0; column < width; column++) {
				recent[2] = recent[1];
				recent[1] = recent[0];
				recent[0] = cells[(row*width)+column];
				
				if(recent[0].equals(recent[1]) && recent[1].equals(recent[2]) && !recent[0].equals(" "))
					return true;
			}
		}
		return false;
	}
	
	//Since it is a 1D array if you want to get a value from cells you need to multiple the width with the row, else you"ll get a number in the same row.
	public boolean checkVer() {
		String[] recent = new String[3];
		for(int column = 0; column < width; column++){
			for(int i = 0; i < recent.length; i++)
				recent[i] = " ";
			
			for(int row = 0; row < height; row++) {
				recent[2] = recent[1];
				recent[1] = recent[0];
				recent[0] = cells[(row*width)+column];
				
				if(recent[0].equals(recent[1]) && recent[1].equals(recent[2]) && !recent[0].equals(" "))
					return true;
			}
		}
		return false;
	}

	public boolean checkDia() {
		String[] recent = new String[3];
		for(int i = 0; i < recent.length; i++)
				recent[i] = " ";
			
		for(int cell = 0; cell < width*height; cell += (width + 1)) {
			recent[2] = recent[1];
			recent[1] = recent[0];
			recent[0] = cells[cell];
			
			if(recent[0].equals(recent[1]) && recent[1].equals(recent[2]) && !recent[0].equals(" "))
				return true;
		}
		
		for(int i = 0; i < recent.length; i++)
				recent[i] = " ";
		
		for(int cell = 0; cell < width*height; cell += (width - 1)) {
			recent[2] = recent[1];
			recent[1] = recent[0];
			recent[0] = cells[cell];
			
			if(recent[0].equals(recent[1]) && recent[1].equals(recent[2]) && !recent[0].equals(" "))
				return true;
		}
		return false;
	}
	
	public boolean checkTie() {
		for (String cell : cells) {
			if (cell.equals(" "))
				return false;
		}
		return true;
	}
}
