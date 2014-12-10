
public class King extends Piece {
	
	public King(String string) {
		super(string);
	}

	public King(String string, int i, int j, int color) {
		super(string,i,j, color);
	}
	
	public boolean isLegal(int i, int j, int occupied, int color) {
		if (occupied == 0 || (occupied == 1 && this.col != color)) {
			int xdiff = Math.abs(this.x_pos - i);
			int ydiff = Math.abs(this.y_pos - j);
			System.out.print("kingmove");
			if (xdiff + ydiff == 1 || (xdiff == 1 && ydiff == 1) ){
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
			int xdiff = Math.abs(this.x_pos - i);
			int ydiff = Math.abs(this.y_pos - j);
			System.out.print("kingmove");
			if (xdiff + ydiff == 1 || (xdiff == 1 && ydiff == 1) ){
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
