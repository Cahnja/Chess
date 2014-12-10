
public class Pawn extends Piece{

	public Pawn(String string) {
		super(string);
	}

	public Pawn(String string, int i, int j, int color) {
		super(string,i,j, color);
	}

	public boolean isLegal(int i, int j, int occupied, int color) {
		if (this.col == 0) {
			if (occupied == 0) {
				System.out.println("tracing_time_black");
				if ((i - this.x_pos) == 0 && (j - this.y_pos) == 1) {
					this.x_pos = i; 
					this.y_pos = j;
					return true;
				}
				if (this.y_pos == 2 && i - this.x_pos == 0 && j - this.y_pos == 2) {
					this.x_pos = i; 
					this.y_pos = j;
					return true;
				}
				else {
					return false;
				}
			}
			else {
				if (this.col == color) {
					return false;
				}
				else {
					if (Math.abs(i - this.x_pos) == 1 && (j - this.y_pos) == 1) {
						this.x_pos = i; 
						this.y_pos = j;							
			    		System.out.println("trace");
						return true; 
					}
					else { 
						return false;
					}
				}
			}
		}
		
		else {
			if (occupied == 0) {
				System.out.println(this.y_pos);
				System.out.println(this.y_pos);
				if ((i - this.x_pos) == 0 && (this.y_pos - j) == 1) {
					this.x_pos = i; 
					this.y_pos = j;
					return true;
				}
				if (this.y_pos == 7 && this.x_pos - i == 0 && this.y_pos - j == 2) {
					this.x_pos = i; 
					this.y_pos = j;
					return true;
				}
				else {
					return false;
				}
			}
			else {
				if (this.col == color) {
					return false;
				}
				else {
					if (Math.abs(i - this.x_pos) == 1 && (this.y_pos - j) == 1) {
						this.x_pos = i; 
						this.y_pos = j;
						return true; 
					}

					else { 
						return false;
					}
				}
			}
		}
	}
			
}
