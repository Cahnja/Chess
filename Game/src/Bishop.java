
public class Bishop extends Piece {
	
	public Bishop(String string) {
		super(string);
	}

	public Bishop(String string, int i, int j) {
		super(string,i,j);
	}
	
	public boolean isLegal(int i, int j) {
		return true;
	}

}
