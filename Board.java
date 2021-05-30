
public class Board{

	public String[][] top;
	public String[][] bottom; 

	public Board (PiecesTop a, PiecesBottom b) {
		top = a.getPiecesTop();
		bottom = b.getPiecesBottom(); 
	}

	public void printOut() { 
		System.out.println("+---+---+---+---+---+---+---+---+");
		for (int i = 0; i < top.length; i++) {
			for (int j = 0; j < top.length; j++) {
				System.out.print("|");
				if (top[i][j] == null &&  bottom[i][j] == null) {
					System.out.print("   "); 
				} else if (top[i][j] == null && bottom[i][j] != null) {
					System.out.print(" " + bottom[i][j] + " "); 
				}else if (top[i][j] != null &&  bottom[i][j] == null) {
					System.out.print(" " + top[i][j] + " "); 
				}
			}
			System.out.println("|"); 
			System.out.println("+---+---+---+---+---+---+---+---+");
		}

	}






}