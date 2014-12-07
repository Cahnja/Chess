import javax.swing.ImageIcon;

public class Piece extends ImageIcon{
	
	int x_pos; 
	int y_pos;
	
	public boolean isLegal(int i, int j) {
		return true;
	}
	
	public Piece(String string) { 
		super(string);
	}
	
	public Piece(String string, int x, int y) { 
		super(string);
		x_pos = x; 
		y_pos = y; 
	}
}
