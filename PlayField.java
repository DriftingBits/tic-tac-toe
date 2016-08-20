package nl.bryanwesterveld;

public class PlayField {
	private String[] cells;
	
	public PlayField() {
		cells = new String[9];
		for (int i = 0; i < 9; i++){
			cells[i] = " ";
		}
	}
	
	//All empty cells have a space in them.
	public boolean isCellOccupied(int cellNumber) {
		if(cells[cellNumber] == " ") 
			return false;
		else
			return true;
	}
	
	//The string "color" determines whether this player should appear as a circle or a cross.
	public void setCell(int cellNumber, String color) {
		cells[cellNumber] = color;
	}
	
	public void print() {
		System.out.printf("%s | %s | %s \r\n", cells[0], cells[1], cells[2]);
		System.out.printf("%s | %s | %s \r\n", cells[3], cells[4], cells[5]);
		System.out.printf("%s | %s | %s \r\n", cells[6], cells[7], cells[8]);
	}
	
	public boolean checkWinner() {
		return (checkHor() || checkVer() || checkDia())? true : false;
	}
	
	// 0 1 2
	// 3 4 5
	// 6 7 8
	//The following indexes are i, i+1 and i+2 because a horizontal row consists of 3 numbers.
	public boolean checkHor() {
		for(int i = 0; i < 3; i++){
			if(cells[i] == cells[i+1] && cells[i+1] == cells[i+2] && cells[i] != " ")
				return true;
		}
		return false;
	}
	
	// 0 1 2
	// 3 4 5
	// 6 7 8
	//The following indexes are i, i+3 and i+6 because a vertical row consists of 3 numbers, the +3 means
	//It will start on a new line.
	public boolean checkVer() {
		for(int i = 0; i < 3; i++){
			if(cells[i] == cells[i+3] && cells[i+3] == cells[i+6] && cells[i] != " ")
				return true;
		}
		return false;
	}

	// 0 1 2
	// 3 4 5
	// 6 7 8
	// These special cases are hardcoded because a for loop wouldn't have really helped making it more clear.
	public boolean checkDia() {
		if(cells[0] == cells[4] && cells[4] == cells[8] && cells[0] != " ")
			return true;
		else if (cells[2] == cells[4] && cells[4] == cells[6] && cells[2] != " ")
			return true;
		return false;
	}
}
