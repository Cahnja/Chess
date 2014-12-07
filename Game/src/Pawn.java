
public class Pawn extends Piece{

	public Pawn(String string) {
		super(string);
	}

	public Pawn(String string, int i, int j) {
		super(string,i,j);
	}

	public boolean isLegal(int i, int j) {
		return true;
	}
}
