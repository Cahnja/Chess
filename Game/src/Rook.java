
public class Rook extends Piece {
	
	public Rook(String string) {
		super(string);
	}

	public Rook(String string, int i, int j) {
		super(string, i, j);
	}

	public boolean isLegal(int i, int j) {
		return true;
	}
}
