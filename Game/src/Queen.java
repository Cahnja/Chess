
public class Queen extends Piece {
	
	public Queen(String string) {
		super(string);
	}

	public Queen(String string, int i, int j, int color) {
		super(string,i,j, color);

	}
	
	public boolean isLegal(int i, int j, int occupied, int color) {
		if (occupied == 0 || (occupied == 1 && this.col != color)) {
			if ( (this.y_pos-j != 0) && ((Math.abs(this.x_pos - i))/(Math.abs(this.y_pos-j)) == 1)) {
				this.x_pos = i;
				this.y_pos = j;
				return true;
			}
		}
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
