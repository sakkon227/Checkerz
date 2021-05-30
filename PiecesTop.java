// does not have to extend Board, because it's not like we're sharing methods between them.
// I'm just giving the information from PiecesTop for board to access. No need to extend. 

public class PiecesTop{
	public String[][] top; 

	public PiecesTop(String[][] arr) {

		top = arr;
	}

	public String[][] getPiecesTop() {
		return top; 
	}



}