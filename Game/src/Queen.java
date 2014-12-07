
public class Queen extends Piece {
	
	public Queen(String string) {
		super(string);
	}

	public Queen(String string, int i, int j, int color) {
		super(string,i,j, color);

	}
	
	public boolean isLegal(int i, int j, int color) {
		return true;
	}

}
