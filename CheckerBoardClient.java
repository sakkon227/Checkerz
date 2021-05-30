import java.util.*;
public class CheckerBoardClient{
	public static void main(String[] args){
		System.out.println("Welcome to our checkers game! "); 
		Scanner console = new Scanner(System.in);
		System.out.println("press 1 for the default 8 x 8 board"); 
		int modeType = console.nextInt();                             
		if (modeType == 1) {                    // later on, an area to improve on would be to make a bigger/smaller board. 
			CheckerBoard a = new CheckerBoard(8);
			a.updateBoard();
			System.out.println(a);
		}
	}
}