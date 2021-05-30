import java.util.*;
public class CheckerBoard{
	String[][] board;
	ArrayList<Piece> allPieces;

	public CheckerBoard(int size){
		board = new String[size][size];
		allPieces = new ArrayList<Piece>();
		for (int i = 0; i < 3; i++){
			for (int j = 0; j < size; j++){
				if(i % 2 == 0){
					if(j % 2 == 1){
						Piece a = new Piece(i, j, "r");
						allPieces.add(a);
					}
				} else {
					if(j % 2 == 0){
						Piece a = new Piece(i, j, "r");
						allPieces.add(a);
					}
				}

			}
		}
		for (int i = size - 3; i < size; i++){
			for (int j = 0; j < size; j++){
				if(i % 2 == 0){
					if(j % 2 == 1){
						Piece a = new Piece(i, j, "b");
						allPieces.add(a);
					}
				} else {
					if(j % 2 == 0){
						Piece a = new Piece(i, j, "b");
						allPieces.add(a);
					}
				}
			}
		}
	}

	public void updateBoard(){
		for(Piece x : allPieces){
			board[x.getRow()][x.getCol()] = x.getSymbol();
		}
	}

	public String toString(){
		String result = "\n+---+---+---+---+---+---+---+---+\n|";
		for (int i = 0; i < board.length; i++){
			for(int j = 0; j < board[0].length; j++){
				if (board[i][j] != null){
					result += " " + board[i][j] + " |";
				} else {
					result += "   |";
				}
			}
			result += "\n+---+---+---+---+---+---+---+---+";
			result +="\n|";
		}
		return result;
	}
	
}