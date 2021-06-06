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

	public boolean isGameOver(){
		int bcounter = 0;
		int rcounter = 0;
		for(Piece x : allPieces){
			if(bcounter > 0 && rcounter > 0){
				return false;
			}
			if(x.getSymbol().toLowerCase().equals("r")){
				rcounter++;
			} else if(x.getSymbol().toLowerCase().equals("b")){
				bcounter++;
			}
		}
		if(bcounter == 0){
			System.out.println("Player R Wins! GG get better Player B!");
			return true;
		} else {
			System.out.println("Player B Wins! GG get better Player R!");
			return true;
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

	public String[][] getBoard() {
		return board;
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

	public Piece getPiece(int col, int row){
		row = size - row;    
		col--;  
		Piece a = null;
		for(Piece x : allPieces){
			if(col == x.getCol() && row == x.getRow()){
				a = x;
				break;
			}
		}
		return a;
	}
	
	public void promote(){
		for(Piece x: allPieces){
			if((x.getSymbol().toLowerCase().equals("b") && x.getRow() == 0) || (x.getSymbol().toLowerCase().equals("r") && x.getRow() == size - 1)){
				x.upgrade();
			}
		}
	}

	public boolean isEmpty(int col, int row) {
			if (board[row][col] == null) {
				return true; 
			}else {
				return false; 
			}
	}

	public boolean isOutOfRange(int col, int row) {
		if (board.length < row || row < 0) {
			return true; 
		}else if (board[0].length < col || col < 0) {
			return true;
		}else {
			return false; 
		}
	}

	public boolean isMoveAllowed(boolean P, int col, int row){
		row = size - row;    
		col--;  
		Piece a = null;
		if (board[row][col] == null) {
			System.out.println("Can't move. No piece"); 
			return false; 
		}
		for(Piece x : allPieces){
			if(col == x.getCol() && row == x.getRow()){
				a = x;
				break;
			}
		}
		if (P && a.getSymbol().toLowerCase().equals("b")){
			System.out.println("access to piece granted");
			return true;
		} else if (!P && a.getSymbol().toLowerCase().equals("r")){
			return true;
		} else {
			System.out.println("Nuh uh no cheating! Pick your own piece to move.\n");
			return false;
		}
	}

	public boolean isYourOwn(int initialCol, int initialRow, int col, int row) {
		if (board[row][col] == board[initialRow][initialCol]) {
			return true;
		}else {
			return false; 
		}
	}


	public boolean moveUpRight(int col, int row, boolean P){  // 1,3 
		row = size - row;    // 5
		col--;                // 0   just referencing the actual point in 2D array
		Piece a = null;
		for(Piece x : allPieces){
			if(col == x.getCol() && row == x.getRow()){
				a = x;
				break;
			}
		}
		if(a.getUpgraded() || P){
			if (isOutOfRange(col + 1, row - 1)) {
				System.out.println("The value is out of range!" );
				return false; 
				 
			}else if (isYourOwn(col, row, col + 1, row - 1)) {
				System.out.println("You can't move on top of your own piece!");
				return false; 
				 
			}else if (isEmpty(col + 1, row - 1)) {
				a.moveUp();
				a.moveRight();
				return true;
			} else if(!isOutOfRange(col + 2, row - 2) && isEmpty(col + 2, row - 2)){
				a.moveUp();
				a.moveUp();
				a.moveRight();
				a.moveRight();
				for(Piece x : allPieces){
					if(col + 1 == x.getCol() && row - 1 == x.getRow()){
						allPieces.remove(x);
						break;
					}
				}
				return true; 
			} else{
				System.out.println("This is not a valid move.");
				return false; 
			}
		} else {
			System.out.println("This piece cannot move in this direction.");
			return false; 
		}
	}

	

	public boolean moveUpLeft(int col, int row, boolean P){
		row = size - row;
		col--;
		Piece a = null;
		for(Piece x : allPieces){
			if(col == x.getCol() && row == x.getRow()){
				a = x;
				break;
			}
		}
		if(P || a.getUpgraded()){
			if (isOutOfRange(col - 1, row - 1)) {
				System.out.println("The value is out of range!");
				return false;
				 
			}else if (isYourOwn(col, row, col - 1, row - 1)) {
				System.out.println("You can't move on top of your own piece!");
				return false;
				 
			}else if (isEmpty(col - 1, row - 1)) {
				a.moveUp();
				a.moveLeft();
				return true;
			} else if(!isOutOfRange(col - 2, row - 2) && isEmpty(col - 2, row - 2)){
				a.moveUp();
				a.moveUp();
				a.moveLeft();
				a.moveLeft();
				for(Piece x : allPieces){
					if(col - 1 == x.getCol() && row - 1 == x.getRow()){
						allPieces.remove(x);
						break;
					}
				}
				return true; 
			} else{
				System.out.println("This is not a valid move.");
				return false; 
			}
		} else {
			System.out.println("This piece cannot move in this direction.");
			return false; 
		}
	}

	public boolean moveDownLeft(int col, int row, boolean P){
		row = size - row;
		col--;
		Piece a = null;
		for(Piece x : allPieces){
			if(col == x.getCol() && row == x.getRow()){
				a = x;
				break;
			}
		}
		if(!P || a.getUpgraded()){
			if (isOutOfRange(col - 1, row + 1)) {
				System.out.println("The value is out of range!");
				return false; 
				
			}else if (isYourOwn(col, row, col - 1, row + 1)) {
				System.out.println("You can't move on top of your own piece!");
				return false;				
			}else if (isEmpty(col - 1, row + 1)) {
				a.moveDown();
				a.moveLeft();
				return true; 
			} else if(!isOutOfRange(col - 2, row + 2) && isEmpty(col - 2, row + 2)){
				a.moveDown();
				a.moveDown();
				a.moveLeft();
				a.moveLeft();
				for(Piece x : allPieces){
					if(col - 1 == x.getCol() && row + 1 == x.getRow()){
						allPieces.remove(x);
						break;
					}
				}
				return true; 
			} else{
				System.out.println("This is not a valid move.");
				return false; 
			}
		} else {
			System.out.println("This piece cannot move in this direction.");
			return false; 
		}
	}

	public boolean moveDownRight(int col, int row, boolean P){
		row = size - row;
		col--;
		Piece a = null;
		for(Piece x : allPieces){
			if(col == x.getCol() && row == x.getRow()){
				a = x;
				break;
			}
		}
		if(!P || a.getUpgraded()){
			if (isOutOfRange(col + 1, row + 1)) {
				System.out.println("The value is out of range!");
				return false; 
				
			}else if (isYourOwn(col, row, col + 1, row + 1)) {
				System.out.println("You can't move on top of your own piece!");
				return false; 
			}else if (isEmpty(col + 1, row + 1)) {
				a.moveDown();
				a.moveRight();
				return true; 
			} else if(!isOutOfRange(col + 2, row + 2) && isEmpty(col + 2, row + 2)){
				a.moveDown();
				a.moveDown();
				a.moveRight();
				a.moveRight();
				for(Piece x : allPieces){
					if(col + 1 == x.getCol() && row + 1 == x.getRow()){
						allPieces.remove(x);
						break;
					}
				}
				return true; 
			} else{
				System.out.println("This is not a valid move.");
				return false; 
			}
		} else {
			System.out.println("This piece cannot move in this direction.");
			return false; 
		}
	}	
}
