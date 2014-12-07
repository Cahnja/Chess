
public class Queen extends Piece {
	
	public Queen(String string) {
		super(string);
	}

	public Queen(String string, int i, int j) {
		super(string,i,j);

	}
	
	public boolean isLegal(int i, int j) {
		return true;
	}

}
