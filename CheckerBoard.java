import java.util.*;
public class CheckerBoard{
	String[][] board;
	ArrayList<Piece> allPieces;
	int size;

	public CheckerBoard(){
	}

	public void setSize(int s){
		size = s;
		board = new String[s][s];
		allPieces = new ArrayList<Piece>();
		for (int i = 0; i < 3; i++){
			for (int j = 0; j < s; j++){
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
		for (int i = s - 3; i < s; i++){
			for (int j = 0; j < s; j++){
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
		for(int i = 0; i < board.length; i++){
			for(int j = 0; j < board[0].length; j++){
				board[i][j] = null;
			}
		}
		for(Piece x : allPieces){
			board[x.getRow()][x.getCol()] = x.getSymbol();
		}
	}

	public String toString(){
		int rowcount = size;
		String result = "\n  +---+---+---+---+---+---+---+---+\n";
		for (int i = 0; i < board.length; i++){
			result += rowcount + " ";
			rowcount--;
			for(int j = 0; j < board[0].length; j++){
				if (board[i][j] != null){
					result += "| " + board[i][j] + " ";
				} else {
					result += "|   ";
				}
			}
			result += "|\n  +---+---+---+---+---+---+---+---+\n";
		}
		result += "    1   2   3   4   5   6   7   8  ";
		return result;
	}

	public void moveUpRight(int col, int row){
		row = size - row;
		col--;
		for(Piece x : allPieces){
			if(col == x.getCol() && row == x.getRow()){
				x.moveUp();
				x.moveRight();
				break;
			}
		}
	}

	public void moveUpleft(int col, int row){
		row = size - row;
		col--;
		for(Piece x : allPieces){
			if(col == x.getCol() && row == x.getRow()){
				x.moveUp();
				x.moveLeft();
				break;
			}
		}
	}

	public void moveDownleft(int col, int row){
		row = size - row;
		col--;
		for(Piece x : allPieces){
			if(col == x.getCol() && row == x.getRow()){
				x.moveDown();
				x.moveLeft();
				break;
			}
		}
	}

	public void moveDownRight(int col, int row){
		row = size - row;
		col--;
		for(Piece x : allPieces){
			if(col == x.getCol() && row == x.getRow()){
				x.moveDown();
				x.moveRight();
				break;
			}
		}
	}
	
}
