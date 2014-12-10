import javax.swing.ImageIcon;

public class Piece extends ImageIcon{
	
	int x_pos; 
	int y_pos;
	int col; 
	
	public Piece(String string) { 
		super(string);
	}
	
	public Piece(String string, int x, int y, int color) { 
		super(string);
		x_pos = x; 
		y_pos = y; 
		col = color;
	}

	public boolean isLegal(int i, int j, int occupied, int color) {
		return true;
	}
	
	public boolean isLegal2(int i, int j, int occupied, int color) {
		return true;
	}

}
