import java.util.Random;
import java.util.Scanner;

//By using an abstract class all kinds of players can be made to work without changing anything in other classes.
public interface Player {
	public void prepareTurn();
	public void makeMove(PlayField field, Scanner scan);
	public String getColor();
}
