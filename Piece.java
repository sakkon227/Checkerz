public class Piece{
	String symbol;
	int row;
	int col;
	boolean isUpgraded;

	public Piece(int x, int y, String s){
		col = y;
		row = x;
		isUpgraded = false;
		symbol = s;
	}

	public int getRow(){
		return row;
	}

	public int getCol(){
		return col;
	}

	public String getSymbol(){
		return symbol;
	}

}