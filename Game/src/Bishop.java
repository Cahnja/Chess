
public class Bishop extends Piece {
	
	public Bishop(String string) {
		super(string);
	}

	public Bishop(String string, int i, int j, int color) {
		super(string,i,j, color);
	}
	
	public boolean isLegal(int i, int j, int occupied, int color) {
		if (occupied == 0 || (occupied == 1 && this.col != color)) {
			if ( (this.y_pos-j != 0) && ((Math.abs(this.x_pos - i))/(Math.abs(this.y_pos-j)) == 1)) {
				this.x_pos = i;
				this.y_pos = j;
				return true;
			}
			else {
				return false;
			}
		}
		else {
			return false;
		}
	}
	
	public boolean isLegal2(int i, int j, int occupied, int color) {
		if (occupied == 0 || (occupied == 1 && this.col != color)) {
			if ( (this.y_pos-j != 0) && ((Math.abs(this.x_pos - i))/(Math.abs(this.y_pos-j)) == 1)) {
				return true;
			}
			else {
				return false;
			}
		}
		else {
			return false;
		}
	}

}
