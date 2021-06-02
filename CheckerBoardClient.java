
import java.util.*;
public class CheckerBoardClient{
	public static int stopper = 3; 
	public static void main(String[] args){
		System.out.println("Welcome to our checkers game! "); 
		Scanner console = new Scanner(System.in);
		System.out.println("press 1 for the default 8 x 8 board."); 
		int modeType = console.nextInt();           
		CheckerBoard a = new CheckerBoard();                  
		if (modeType == 1) {                    // later on, an area to improve on would be to make a bigger/smaller board. 
			a.setSize(8);
			a.updateBoard();
			System.out.println(a);
			System.out.println("type \"000\" to terminate at any time."); 
		} 
		// while (! (stopper == 0 )) {
		// System.out.println("What would you like to move? Use this grid like a coordiate plane. "); 
		// int b = console.nextInt(); 
		// int c = console.nextInt(); 
		// checkForTerminating(b); 
		// checkForTerminating(c); 
		// need to add in options, type in R for right, L for left, U for up, etc. 

		// our next area of improvement is to add in a way to differentiate r's turn and b's turn. 
		// also, we need a bunch of if statements to check if the movement is allowed. I've gotten started in the CheckerBoard class. 
		a.moveUpLeft(1,3);
		a.updateBoard();
		System.out.println(a);
		a.moveUpRight(3,3);
		a.updateBoard();
		System.out.println(a);
		a.moveDownRight(1,3);
		a.updateBoard();
		System.out.println(a);
		//}

	}

	public static void checkForTerminating(int b) {
		if (b == 000) {
			stopper = 0;
		} 
	}
}
