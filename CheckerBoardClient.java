import java.util.*;
public class CheckerBoardClient{
	public static int stopper = 3; 

	public static boolean isPlayerB = false; 
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
			System.out.println("type \"0 0 0 rules\" at any time to display rules");
			System.out.println("type \"666 666 stop stop\" to terminate at any time."); 
		} 
		while (stopper != 666 ) {
			isPlayerB = !isPlayerB; 
			System.out.println(a);
			System.out.println("What would you like to move? Use this grid like a coordiate plane ");
			System.out.println("and use U / D for up or down, and R / L for right or left. ");  
			if (isPlayerB == true) {
				System.out.println("It's player B's turn");
			}else {
				System.out.println("It's player R's turn"); 
			}
			int b = console.nextInt(); // col
			int c = console.nextInt(); // row 
			String aa = console.next(); 
			String bb = console.next();

			if(bb.equals("rules")){
				rules();
				isPlayerB = !isPlayerB;
				continue;
			}

			if (b == 666 || c == 666 || aa.equals("stop") || bb.equals("stop")) {
				stopper = 666; 
				break; 
			} 

			if ((aa.equals("U") || aa.equals("D")) && (bb.equals("R") || bb.equals("L"))) {
				if (a.isMoveAllowed(isPlayerB, b, c) == true) { 

					if (aa.equals("U") && bb.equals("R")) {
						if (!(a.moveUpRight(b,c, isPlayerB))) {
							isPlayerB = !isPlayerB; 
						} 
						a.promote();
						a.updateBoard();
					}else if (aa.equals("D") && bb.equals("R")) {
						if (!(a.moveDownRight(b,c, isPlayerB))) {
							isPlayerB = !isPlayerB; 
						}
						a.promote();
						a.updateBoard();
					}else if (aa.equals("U") && bb.equals("L")) {
						if (!(a.moveUpLeft(b,c, isPlayerB))) {
							isPlayerB = !isPlayerB; 
						} 
						a.promote();
						a.updateBoard();
					}else if (aa.equals("D") && bb.equals("L")) {
						if (!(a.moveDownLeft(b,c, isPlayerB))) {
							isPlayerB = !isPlayerB;
						}  
						a.promote();
						a.updateBoard();  
					}
				}else {
					isPlayerB = !isPlayerB; 
				}
			}else {
				System.out.println("Move not allowed. Try again"); 
					isPlayerB = !isPlayerB; 
				
			}
			if(a.isGameOver()){
				stopper = 666;
				break;
			}
		}
	}

	public static void rules(){
		System.out.println("\nThe goal is to eliminate all of your opponents pieces.");
		System.out.println("Your piece can only move forward from where it starts until it gets promoted.");
		System.out.println("For example r pieces can only move down while b pieces can only move up.");
		System.out.println("Once a piece is promoted by getting it all the way to the other side of the board it can move in all directions.");
		System.out.println("Speaking of directions pieces can only move in diagonals so when \nmoving a piece you have to choose up or down and left or right.");
		System.out.println("Now to eliminate opponents pieces it has to be your turn and there \nhas to be an opponent piece in one of the diagonals adjacent to your piece.");
		System.out.println("Then make your piece jump over the opponents by moving towards the opponent piece.");
		System.out.println("This will kill the opponent piece unless there is another piece behind it. \nThen your piece will not be able to move there.");
		System.out.println("Now you have all the rules so go play!\n");
	}
}
