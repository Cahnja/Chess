
public class Knight extends Piece{

	
	public Knight(String string) {
		super(string);
	}

	public Knight(String string, int i, int j) {
		super(string, i, j);
	}
	
	public boolean isLegal(int i, int j) {
		return true;
	}

}
