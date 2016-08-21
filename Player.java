import java.util.Random;
import java.util.Scanner;

//By using an abstract class all kinds of players can be made to work without changing anything in other classes.
public abstract class Player {
	public abstract void prepareTurn();
	public abstract void makeMove(PlayField field, Scanner scan);
	public abstract String getColor();
}
