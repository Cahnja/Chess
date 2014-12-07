
public class Rook extends Piece {
	
	public Rook(String string) {
		super(string);
	}

	public Rook(String string, int i, int j, int color) {
		super(string, i, j, color);
	}

	public boolean isLegal(int i, int j, int occupied, int color) {
		return true;
	}
}
