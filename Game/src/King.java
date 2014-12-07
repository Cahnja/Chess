
public class King extends Piece {
	
	public King(String string) {
		super(string);
	}

	public King(String string, int i, int j, int color) {
		super(string,i,j, color);
	}
	
	public boolean isLegal(int i, int j, int color) {
		return true;
	}

}
