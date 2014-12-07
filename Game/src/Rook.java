
public class Rook extends Piece {
	
	public Rook(String string) {
		super(string);
	}

	public Rook(String string, int i, int j, int color) {
		super(string, i, j, color);
	}

	public boolean isLegal(int i, int j, int occupied, int color) {
		System.out.println("" + occupied);
		if ((occupied == 0 && (i - this.x_pos == 0 || j - this.y_pos == 0)) ||
			(occupied == 1 && this.col != color)) {
				this.x_pos = i; 
				this.y_pos = j; 
				return true;
			}
		else {
			return false;
		}
	}
}
