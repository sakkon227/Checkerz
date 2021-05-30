import java.util.*;
public class CheckersClientCode{
	public static void main(String args[]) {
		System.out.println("Welcome to our checkers game! "); 
		Scanner console = new Scanner(System.in);
		System.out.println("press 1 for the default 8 x 8 board"); 
		int modeType = console.nextInt();                             
		if (modeType == 1) {                    // later on, an area to improve on would be to make a bigger/smaller board. 
			String[][] type = new String[8][8]; 

			String[][] topp = constructTop(type);
			PiecesTop a = new PiecesTop(topp);
			
			String[][] bottomm =  constructBottom(type);
			PiecesBottom b = new PiecesBottom(bottomm);
			
			Board board = new Board(a, b); 
			board.printOut(); 

		}

	} 

	public static String[][] constructTop(String[][] type){
		// for the top pieces; 
		String[][] top = new String[8][8];  // kinda messy at the moment, see if you can make it neater. 
		top[0][1] = "R";
		top[0][3] = "R";
		top[0][5] = "R"; 
		top[0][7] = "R"; 
		top[1][0] = "R";
		top[1][2] = "R";
		top[1][4] = "R";
		top[1][6] = "R";
		top[2][1] = "R";
		top[2][3] = "R";
		top[2][5] = "R";
		top[2][7] = "R";

		return top; 
	}

	public static String[][] constructBottom(String[][] type){
		String[][] bottom = new String[8][8];
		bottom[5][0] = "B";
		bottom[5][2] = "B";
		bottom[5][4] = "B";
		bottom[5][6] = "B";
		bottom[6][1] = "B";
		bottom[6][3] = "B";
		bottom[6][5] = "B";
		bottom[6][7] = "B";
		bottom[7][0] = "B";
		bottom[7][2] = "B";
		bottom[7][4] = "B";
		bottom[7][6] = "B"; 

		return bottom;   

	}











}