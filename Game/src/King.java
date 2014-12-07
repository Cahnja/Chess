
public class King extends Piece {
	
	public King(String string) {
		super(string);
	}

	public King(String string, int i, int j) {
		super(string,i,j);
	}
	
	public boolean isLegal(int i, int j) {
		return true;
	}

}
