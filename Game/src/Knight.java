
public class Knight extends Piece{

	
	public Knight(String string) {
		super(string);
	}

	public Knight(String string, int i, int j, int color) {
		super(string, i, j, color);
	}
	
	public boolean isLegal(int i, int j, int occupied, int color) {
		if (occupied == 0 || (occupied == 1 && this.col != color)) {
			if ((Math.abs(this.x_pos - i) == 2 && Math.abs(this.y_pos - j) == 1)
				|| (Math.abs(this.x_pos - i) == 1 && Math.abs(this.y_pos - j) == 2)) {
				this.x_pos = i; 
				this.y_pos = j;
				System.out.println("trace1");
				return true;
			}
			else { 
				System.out.println("trace2");
				System.out.println("" + (Math.abs(this.x_pos - i)));
				return false;
			}
		}
		else {
			System.out.println("trace3");
			return false;
		}
	}
	
	public boolean isLegal2(int i, int j, int occupied, int color) {
		if (occupied == 0 || (occupied == 1 && this.col != color)) {
			if ((Math.abs(this.x_pos - i) == 2 && Math.abs(this.y_pos - j) == 1)
				|| (Math.abs(this.x_pos - i) == 1 && Math.abs(this.y_pos - j) == 2)) {
				System.out.println("trace1");
				return true;
			}
			else { 
				System.out.println("trace2");
				System.out.println("" + (Math.abs(this.x_pos - i)));
				return false;
			}
		}
		else {
			System.out.println("trace3");
			return false;
		}
	}

}
