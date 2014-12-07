/**
 * CIS 120 HW10
 * (c) University of Pennsylvania
 * @version 2.0, Mar 2013
 */

// imports necessary libraries for Java swing
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Game Main class that specifies the frame and widgets of the GUI
 */
public class Game implements Runnable {
	
	boolean pressed;
	int turn;
	Piece image; 
	JButton butt; 
	int xAdjustment;
	int yAdjustment;
	JButton[][] chessBoardSquares;
	JLabel status;
	int image_x; 
	int image_y;
	int image_color;
	King blackking;
	King whiteking; 
	
    static Font font = new Font("Sans-Serif", Font.PLAIN, 50);
    
    final Rook black_rook = new Rook("black_rook.png", 1, 1, 0);
    final Knight black_knight = new Knight("black_knight.png", 2, 1, 0);
    final Bishop black_bishop = new Bishop("black_bishop.png", 3, 1, 0);
    final Queen black_queen = new Queen("black_queen.png",4, 1, 0);   
    final King black_king = new King("black_king.png", 5, 1, 0);
    final Bishop black_bishop_2 = new Bishop("black_bishop.png", 6, 1, 0);
    final Knight black_knight_2 = new Knight("black_knight.png", 7, 1, 0);
    final Rook black_rook_2 = new Rook("black_rook.png", 8, 1, 0);
    final Pawn black_pawn = new Pawn("black_pawn.png",1, 2, 0);
    final Pawn black_pawn_2 = new Pawn("black_pawn.png",2, 2, 0);
    final Pawn black_pawn_3 = new Pawn("black_pawn.png",3, 2, 0);
    final Pawn black_pawn_4 = new Pawn("black_pawn.png",4, 2, 0);
    final Pawn black_pawn_5 = new Pawn("black_pawn.png",5, 2, 0);
    final Pawn black_pawn_6 = new Pawn("black_pawn.png",6, 2, 0);
    final Pawn black_pawn_7 = new Pawn("black_pawn.png",7, 2, 0);
    final Pawn black_pawn_8 = new Pawn("black_pawn.png",8, 2, 0);
    
    final Rook white_rook = new Rook("white_rook.png", 1, 8, 1);
    final Knight white_knight = new Knight("white_knight.png", 2, 8, 1);
    final Bishop white_bishop = new Bishop("white_bishop.png", 3, 8, 1);
    final Queen white_queen = new Queen("white_queen.png", 4, 8, 1);   
    final King white_king = new King("white_king.png", 5, 8, 1);
    final Bishop white_bishop_2 = new Bishop("white_bishop.png", 6, 8, 1);
    final Knight white_knight_2 = new Knight("white_knight.png", 7, 8, 1);
    final Rook white_rook_2 = new Rook("white_rook.png", 8, 8, 1);
    final Pawn white_pawn = new Pawn("white_pawn.png", 1, 7, 1);
    final Pawn white_pawn_2 = new Pawn("white_pawn.png", 2, 7, 1);
    final Pawn white_pawn_3 = new Pawn("white_pawn.png", 3, 7, 1);
    final Pawn white_pawn_4 = new Pawn("white_pawn.png", 4, 7, 1);
    final Pawn white_pawn_5 = new Pawn("white_pawn.png", 5, 7, 1);
    final Pawn white_pawn_6 = new Pawn("white_pawn.png", 6, 7, 1);
    final Pawn white_pawn_7 = new Pawn("white_pawn.png", 7, 7, 1);
    final Pawn white_pawn_8 = new Pawn("white_pawn.png", 8, 7, 1);


	public void run() {
		// NOTE : recall that the 'final' keyword notes inmutability
		// even for local variables.

		// Top-level frame in which game components live
		// Be sure to change "TOP LEVEL FRAME" to the name of your game		
		
		pressed = false;
		turn = 1;
		image = new Piece("black_rook.png");

	    final String COLS = "ABCDEFGH";
		final JFrame frame = new JFrame("TOP LEVEL FRAME");
		frame.setLocation(300, 300);
		
		blackking = black_king;
		whiteking = white_king;
		
		JLayeredPane layeredPane = new JLayeredPane();
	    chessBoardSquares = new JButton[8][8];
		JPanel chessBoard = new JPanel(new GridLayout(9, 9));
		chessBoard.setBorder(new LineBorder(Color.BLACK));
		layeredPane.add(chessBoard);
		
		Insets buttonMargin = new Insets(0,0,0,0);
		for (int ii = 0; ii < chessBoardSquares.length; ii++) {
			for (int jj = 0; jj < chessBoardSquares[ii].length; jj++) {
				JButton b = new JButton();
				b.setBorder(new LineBorder(Color.BLACK));
				b.setMargin(buttonMargin);			
				//ImageIcon icon = new ImageIcon("white_black_rook.png");
				ImageIcon icon = new ImageIcon(new BufferedImage(64, 64, BufferedImage.TYPE_INT_ARGB));
                b.setIcon(icon);
			    if ((jj % 2 == 1 && ii % 2 == 1)
                        //) {
                        || (jj % 2 == 0 && ii % 2 == 0)) {
                    b.setBackground(Color.WHITE);
                    b.setOpaque(true);
                } else {
                    b.setBackground(Color.darkGray);
                    b.setOpaque(true);
                }
				 chessBoardSquares[jj][ii] = b;
			}
		}
		
        chessBoard.add(new JLabel(""));
        for (int ii = 0; ii < 8; ii++) {
            chessBoard.add(
                    new JLabel(COLS.substring(ii, ii + 1),
                    SwingConstants.CENTER));
        }
        
        for (int ii = 0; ii < 8; ii++) {
            for (int jj = 0; jj < 8; jj++) {
                switch (jj) {
                    case 0:
                        chessBoard.add(new JLabel("" + (ii + 1),
                                SwingConstants.CENTER));
                        
                    default:
                        chessBoard.add(chessBoardSquares[jj][ii]);
                }
            }
        }
        
        System.out.println(chessBoard.getComponentCount());
        
        JButton a1 = (JButton) chessBoard.getComponent(10);
        a1.setIcon(black_rook);
        JButton b1 = (JButton) chessBoard.getComponent(11);
        b1.setIcon(black_knight);
        JButton c1 = (JButton) chessBoard.getComponent(12);
        c1.setIcon(black_bishop);
        JButton d1 = (JButton) chessBoard.getComponent(13);
        d1.setIcon(black_queen);
        JButton e1 = (JButton) chessBoard.getComponent(14);
        e1.setIcon(black_king);
        JButton f1 = (JButton) chessBoard.getComponent(15);
        f1.setIcon(black_bishop_2);
        JButton g1 = (JButton) chessBoard.getComponent(16);
        g1.setIcon(black_knight_2);
        JButton h1 = (JButton) chessBoard.getComponent(17);
        h1.setIcon(black_rook_2);
        JButton a2 = (JButton) chessBoard.getComponent(19);
        a2.setIcon(black_pawn);
        JButton b2 = (JButton) chessBoard.getComponent(20);
        b2.setIcon(black_pawn_2);
        JButton c2 = (JButton) chessBoard.getComponent(21);
        c2.setIcon(black_pawn_3);
        JButton d2 = (JButton) chessBoard.getComponent(22);
        d2.setIcon(black_pawn_4);
        JButton e2 = (JButton) chessBoard.getComponent(23);
        e2.setIcon(black_pawn_5);
        JButton f2 = (JButton) chessBoard.getComponent(24);
        f2.setIcon(black_pawn_6);
        JButton g2 = (JButton) chessBoard.getComponent(25);
        g2.setIcon(black_pawn_7);
        JButton h2 = (JButton) chessBoard.getComponent(26);
        h2.setIcon(black_pawn_8);
        
        JButton a8 = (JButton) chessBoard.getComponent(73);
        a8.setIcon(white_rook);
        JButton b8 = (JButton) chessBoard.getComponent(74);
        b8.setIcon(white_knight);
        JButton c8 = (JButton) chessBoard.getComponent(75);
        c8.setIcon(white_bishop);
        JButton d8 = (JButton) chessBoard.getComponent(76);
        d8.setIcon(white_queen);
        JButton e8 = (JButton) chessBoard.getComponent(77);
        e8.setIcon(white_king);
        JButton f8 = (JButton) chessBoard.getComponent(78);
        f8.setIcon(white_bishop_2);
        JButton g8 = (JButton) chessBoard.getComponent(79);
        g8.setIcon(white_knight_2);
        JButton h8 = (JButton) chessBoard.getComponent(80);
        h8.setIcon(white_rook_2);
        JButton a7 = (JButton) chessBoard.getComponent(64);
        a7.setIcon(white_pawn);
        JButton b7 = (JButton) chessBoard.getComponent(65);
        b7.setIcon(white_pawn_2);
        JButton c7 = (JButton) chessBoard.getComponent(66);
        c7.setIcon(white_pawn_3);
        JButton d7 = (JButton) chessBoard.getComponent(67);
        d7.setIcon(white_pawn_4);
        JButton e7 = (JButton) chessBoard.getComponent(68);
        e7.setIcon(white_pawn_5);
        JButton f7 = (JButton) chessBoard.getComponent(69);
        f7.setIcon(white_pawn_6);
        JButton g7 = (JButton) chessBoard.getComponent(70);
        g7.setIcon(white_pawn_7);
        JButton h7 = (JButton) chessBoard.getComponent(71);
        h7.setIcon(white_pawn_8);
        
		layeredPane.addMouseListener(new MouseAdapter() {
       	 public void mouseClicked(MouseEvent e) {
       		System.out.println("please");
		    	if (pressed == true) { 
		    		Component c = chessBoard.getComponentAt(e.getX(), e.getY());
		    		System.out.println(
		    				chessBoard.getComponentAt(e.getX(), e.getY()).equals(
		    				chessBoard.getComponent(10))
		    			);
		    		System.out.println(c.toString());

		    		
		    		}
		    	}
       });	
		
        chessBoard.addMouseListener(new MouseAdapter() {
        	 public void mouseClicked(MouseEvent e) {
        		System.out.println("fuck");
 		    	if (pressed == true) { 
 		    		Component c = chessBoard.getComponentAt(e.getX(), e.getY());
 		    		System.out.println(
 		    				chessBoard.getComponentAt(e.getX(), e.getY()).equals(
 		    				chessBoard.getComponent(10))
 		    			);
 		    		System.out.println(c.toString());
 		    		System.out.println(e.getX());
 		    		System.out.println(e.getY());
 		    		
 		    		}
 		    	}
        });	
        
        for (int i = 0; i < 8; i++) {
        	for (int j = 0; j < 8; j++) {
        		listenUp(i, j);	
        	}
        }
             
		frame.add(chessBoard, BorderLayout.CENTER);
		
		// Status panel
		final JPanel status_panel = new JPanel();
		frame.add(status_panel, BorderLayout.SOUTH);
		status = new JLabel("Running...");
		status_panel.add(status);

		// Main playing area
		final GameCourt court = new GameCourt(status);
		frame.add(chessBoard, BorderLayout.CENTER);

		// Reset button
		final JPanel control_panel = new JPanel();
		frame.add(control_panel, BorderLayout.NORTH);

		// Note here that when we add an action listener to the reset
		// button, we define it as an anonymous inner class that is
		// an instance of ActionListener with its actionPerformed()
		// method overridden. When the button is pressed,
		// actionPerformed() will be called.
		final JButton reset = new JButton("Reset");
		reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				court.reset();
			}
		});
		control_panel.add(reset);

		// Put the frame on the screen
		frame.pack();
		frame.setMinimumSize(frame.getSize());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

		// Start game
		court.reset();
	}

	private void listenUp(int i, int j) {
		chessBoardSquares[i][j].addMouseListener(
				new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
		    	int occupied;
		    	int x_occupied;
		    	int y_occupied;
		    	int color = 2; 
		    	int diff; 
		    	int k; 
		    	ImageIcon blank = new ImageIcon(new BufferedImage(64, 64, BufferedImage.TYPE_INT_ARGB)); 
		    	if (pressed == true) { 
		    		pressed = false;
		    		occupied = 0;
			    	x_occupied = 0; 
			    	y_occupied = 0;

		    		if (chessBoardSquares[i][j].getIcon() instanceof Piece) {
		    			occupied = 1;
		    			color = ((Piece) chessBoardSquares[i][j].getIcon()).col;
		    		}
		    		if (image instanceof Rook || image instanceof Queen) {
		    			if (image.x_pos - i == 1) {
			    			diff = Math.abs(image.y_pos - (j+1)); 
			    			k = Math.min(image.y_pos-1, j);
			    			for (int l = 1; l<diff; l++) {
			    				if (chessBoardSquares[i][k+l].getIcon() instanceof Piece) {
					    			occupied = 2;
					    			System.out.println("rooknotjumping_1");
			    				}
			    			}		
		    			}
		    			if (image.y_pos - j == 1) {
			    			diff = Math.abs(image.x_pos - (i+1)); 
			    			k = Math.min(image.x_pos-1, i);
			    			for (int l = 1; l<diff; l++) {
			    				if (chessBoardSquares[k+l][j].getIcon() instanceof Piece) {
					    			occupied = 2;
					    			System.out.println("rooknotjumping_2");
			    				}
			    			}		
		    			}
		    		}
		    		
		    		if (image instanceof Bishop || image instanceof Queen) {
		    			int y_diff = image.y_pos - (j+1); 
		    			int x_diff = image.x_pos - (i+1); 
		    			if (x_diff > 0 && y_diff > 0) {
			    			for (int l = 1; l<Math.abs(x_diff); l++) {
				    			System.out.println("" + (image.x_pos-l-1));
				    			System.out.println("" + (image.y_pos-l-1));
			    				if (chessBoardSquares[image.x_pos-1-l][image.y_pos-1-l].getIcon() instanceof Piece) {
					    			occupied = 2;
					    			System.out.println("bishopnotjumping_1");
			    				}
			    			}		
		    			}
		    			if (x_diff > 0 && y_diff < 0) {
			    			for (int l = 1; l<Math.abs(x_diff); l++) {
				    			System.out.println("" + (image.x_pos+l-1));
				    			System.out.println("" + (image.y_pos+l-1));
			    				if (chessBoardSquares[image.x_pos-1-l][image.y_pos-1+l].getIcon() instanceof Piece) {
					    			occupied = 2;
					    			System.out.println("bishopnotjumping_2");
			    				}
			    			}
		    			}
		    			if (x_diff < 0 && y_diff > 0) {
			    			for (int l = 1; l<Math.abs(x_diff); l++) {
				    			System.out.println("" + (image.x_pos+l-1));
				    			System.out.println("" + (image.y_pos+l-1));
			    				if (chessBoardSquares[image.x_pos-1+l][image.y_pos-1-l].getIcon() instanceof Piece) {
					    			occupied = 2;
					    			System.out.println("bishopnotjumping_3");
			    				}
			    			}
		    			}
		    			if (x_diff < 0 && y_diff < 0) {
			    			for (int l = 1; l<Math.abs(x_diff); l++) {
				    			System.out.println("" + (image.x_pos+l-1));
				    			System.out.println("" + (image.y_pos+l-1));
			    				if (chessBoardSquares[image.x_pos-1+l][image.y_pos-1+l].getIcon() instanceof Piece) {
					    			occupied = 2;
					    			System.out.println("bishopnotjumping_4");
			    				}
			    			}
		    			}

		    		}
		    		
		    		if (image instanceof King) {
		    			if (image.col == 0) {
		    				if (Math.abs(i+1 - whiteking.x_pos) < 2 &&
		    						Math.abs(j+1-whiteking.y_pos) < 2) {
		    					occupied = 2;
		    					System.out.println("toocloseblack");
		    				}
		    			}
		    			else {
		    				if (Math.abs(i+1 - blackking.x_pos) < 2 &&
		    						Math.abs(j+1-blackking.y_pos) < 2) {
		    					occupied = 2;
		    					System.out.println("tooclosewhite");
		    				}
		    			}
		    		}
	
			    		if (image.isLegal(i+1,j+1,occupied, color)) {
			    			if (image.y_pos == 8 && image instanceof Pawn && image.col == 0) {
			    				image = new Queen("black_queen.png",image.x_pos, 8, 0);
			    			}
			    			if (image.y_pos == 1 && image instanceof Pawn && image.col == 1) {
			    				image = new Queen("white_queen.png",image.x_pos, 1, 0);
			    			}
			    			
				    		if (image instanceof King) {
				    			if (image.col == 0) {
				    				blackking = new King("black_king.png", i+1, j+1, 0);
				    				System.out.println("blackmoved");
				    				System.out.println("" + (i+1));
				    				System.out.println("" + (j+1));
				    			}
				    			else {
				    				whiteking = new King("white_king.png", i+1, j+1, 1);
				    			}
				    		}
				    		
			    			ImageIcon oldIcon = (ImageIcon) chessBoardSquares[i][j].getIcon();
			    			
			    			if (!(inCheck())) {
				    			chessBoardSquares[i][j].setIcon(image);
				    			if (image.col == 0) {
				    				if (inCheckBlack()) {
				    					chessBoardSquares[i][j].setIcon(oldIcon);
				    					System.out.print("woah there");
				    				}
				    				else {
							    		chessBoardSquares[image_x][image_y].setIcon(blank);
							    		if (turn == 0) {turn = 1;}
							    		else {turn = 0;}
				    				}
				    			}
				    			if (image.col == 1) {
				    				if (inCheckWhite()) {
				    					chessBoardSquares[i][j].setIcon(oldIcon);
				    					System.out.print("woah there");
				    				}
				    				else {
							    		chessBoardSquares[image_x][image_y].setIcon(blank);
							    		if (turn == 0) {turn = 1;}
							    		else {turn = 0;}
				    				}
				    			}
			    			}
			    			else {
			    				chessBoardSquares[i][j].setIcon(image);
			    				if (inCheck()) {
			    					chessBoardSquares[i][j].setIcon(oldIcon);
			    					System.out.print("error you are in check");
			    				}
			    				else {
					    			chessBoardSquares[image_x][image_y].setIcon(blank);
					    			if (turn == 0) {turn = 1;}
					    			else {turn = 0;}
			    				}
			    			}
			    			
			    		}
		    		else {
		    			status = new JLabel("invalid");
		    		}
		    	}
		    	else {
		    		if (chessBoardSquares[i][j].getIcon() instanceof Piece) {
		    			image = (Piece) chessBoardSquares[i][j].getIcon();
		    			if (turn == image.col) {
			    			image_x = i; 
			    			image_y = j;
				    		pressed = true;
		    			
				    		if (image instanceof Rook) {
				    			image = (Rook) image;
				    			System.out.println("rookmoved");
				    			}
				    		if (image instanceof Queen) {
				    			image = (Queen) image;
				    		}
				    		if (image instanceof King) {
				    			image = (King) image;
				    		}
				    		if (image instanceof Pawn) {
				    			image = (Pawn) image; 
				    		}
				    		if (image instanceof Knight) {
				    			image = (Knight) image; 
				    		}
				    		if (image instanceof Bishop) {
				    			image = (Bishop) image; 
				    		}
				    		else {
				    			//stub
				    		}
		    			}
		    		}
		    	}
		    }
		   });
	}
	
	public boolean inCheckBlack() {
		Piece column = new Piece("black_king.png");
		for (int i = blackking.y_pos-2; i > 0 ; i--) {
			if (chessBoardSquares[blackking.x_pos-1][i].getIcon() instanceof Piece) {
				column = (Piece) chessBoardSquares[blackking.x_pos-1][i].getIcon();
				if (!((column instanceof Queen && column.col == 1) 
						|| (column instanceof Rook && column.col == 1)))
						 {
					break;
				}
				if ((column instanceof Queen || column instanceof Rook) && column.col == 1) {
					System.out.println("in_check");
					return true;
				}
			}
		}
		for (int i = blackking.y_pos; i < 8; i++) {
			System.out.println("" + blackking.y_pos);
			if (chessBoardSquares[blackking.x_pos-1][i].getIcon() instanceof Piece) {
				column = (Piece) chessBoardSquares[blackking.x_pos-1][i].getIcon();
				System.out.println("trace");
				if (!((column instanceof Queen && column.col == 1) 
						|| (column instanceof Rook && column.col == 1)))
						 {
					break;
				}
				if ((column instanceof Queen || column instanceof Rook) && column.col == 1) {
					System.out.println("in_check");
					return true;
				}
			}
		}
		int k;
		k = Math.min(8-blackking.y_pos-1, blackking.x_pos-1);
		for (int i = 1; i < k ; i++) {
			System.out.println("wegothere");
			System.out.println("k");
			System.out.println("" + k);
			if (chessBoardSquares[blackking.x_pos-1-i][blackking.y_pos-1+i].getIcon() instanceof Piece) {
				column = (Piece) chessBoardSquares[blackking.x_pos-1-i][blackking.y_pos-1+i].getIcon();
				if (!((column instanceof Bishop && column.col == 1) 
						|| (column instanceof Queen && column.col == 1)))
						 {
					break;
				}
				if ((column instanceof Bishop || column instanceof Queen) && column.col == 1) {
					System.out.println("in_check");
					return true;
				}
			}
		}
		k = Math.min(8-blackking.y_pos-1, 8-blackking.x_pos-1);
		for (int i = 1; i < k ; i++) {
			System.out.println("wegothere");
			System.out.println("k");
			System.out.println("" + k);
			if (chessBoardSquares[blackking.x_pos-1+i][blackking.y_pos-1+i].getIcon() instanceof Piece) {
				column = (Piece) chessBoardSquares[blackking.x_pos-1+i][blackking.y_pos-1+i].getIcon();
				if (!((column instanceof Bishop && column.col == 1) 
						|| (column instanceof Queen && column.col == 1)))
						 {
					break;
				}
				if ((column instanceof Bishop || column instanceof Queen) && column.col == 1) {
					System.out.println("in_check");
					return true;
				}
			}
		}
		k = Math.min(blackking.y_pos-1, 8-blackking.x_pos-1);
		for (int i = 1; i < k ; i++) {
			System.out.println("wegothere");
			System.out.println("k");
			System.out.println("" + k);
			if (chessBoardSquares[blackking.x_pos-1+i][blackking.y_pos-1-i].getIcon() instanceof Piece) {
				column = (Piece) chessBoardSquares[blackking.x_pos-1+i][blackking.y_pos-1-i].getIcon();
				if (!((column instanceof Bishop && column.col == 1) 
						|| (column instanceof Queen && column.col == 1)))
						 {
					break;
				}
				if ((column instanceof Bishop || column instanceof Queen) && column.col == 1) {
					System.out.println("in_check");
					return true;
				}
			}
		}
		k = Math.min(blackking.y_pos-1, blackking.x_pos-1);
		for (int i = 1; i < k ; i++) {
			System.out.println("wegothere");
			System.out.println("k");
			System.out.println("" + k);
			if (chessBoardSquares[blackking.x_pos-1-i][blackking.y_pos-1-i].getIcon() instanceof Piece) {
				column = (Piece) chessBoardSquares[blackking.x_pos-1-i][blackking.y_pos-1-i].getIcon();
				if (!((column instanceof Bishop && column.col == 1) 
						|| (column instanceof Queen && column.col == 1)))
						 {
					break;
				}
				if ((column instanceof Bishop || column instanceof Queen) && column.col == 1) {
					System.out.println("in_check");
					return true;
				}
			}
		}
		ImageIcon op1 = new Piece("black_queen");
		ImageIcon op2 = new Piece("black_queen");
		ImageIcon op3 = new Piece("black_queen");
		ImageIcon op4 = new Piece("black_queen");
		ImageIcon op5 = new Piece("black_queen");
		ImageIcon op6 = new Piece("black_queen");
		ImageIcon op7 = new Piece("black_queen");
		ImageIcon op8 = new Piece("black_queen");
		
		try {op1 = (ImageIcon) chessBoardSquares[blackking.x_pos-1+2][blackking.y_pos-1+1].getIcon();} 
		catch (ArrayIndexOutOfBoundsException e) {System.out.println("caught");}
		try {op2 = (ImageIcon) chessBoardSquares[blackking.x_pos-1+1][blackking.y_pos-1+2].getIcon();}
		catch (ArrayIndexOutOfBoundsException e) {System.out.println("caught");}
		try {op3 = (ImageIcon) chessBoardSquares[blackking.x_pos-1-2][blackking.y_pos-1+1].getIcon();}
		catch (ArrayIndexOutOfBoundsException e) {System.out.println("caught");}
		try {op4 = (ImageIcon) chessBoardSquares[blackking.x_pos-1-1][blackking.y_pos-1+2].getIcon();}
		catch (ArrayIndexOutOfBoundsException e) {System.out.println("caught");}
		try {op5 = (ImageIcon) chessBoardSquares[blackking.x_pos-1-1][blackking.y_pos-1-2].getIcon();}
		catch (ArrayIndexOutOfBoundsException e) {System.out.println("caught");}
		try {op6 = (ImageIcon) chessBoardSquares[blackking.x_pos-1-2][blackking.y_pos-1-1].getIcon();}
		catch (ArrayIndexOutOfBoundsException e) {System.out.println("caught");}
		try {op7 = (ImageIcon) chessBoardSquares[blackking.x_pos-1+1][blackking.y_pos-1-2].getIcon();}
		catch (ArrayIndexOutOfBoundsException e) {System.out.println("caught");}
		try {op8 = (ImageIcon) chessBoardSquares[blackking.x_pos-1+2][blackking.y_pos-1-1].getIcon();}
		catch (ArrayIndexOutOfBoundsException e) {System.out.println("caught");}
		
		if ((op1 instanceof Knight && ((Knight) op1).col == 1) ||
			(op2 instanceof Knight && ((Knight) op2).col == 1) ||
			(op3 instanceof Knight && ((Knight) op3).col == 1) ||
			(op4 instanceof Knight && ((Knight) op4).col == 1) ||
			(op5 instanceof Knight && ((Knight) op5).col == 1) ||
			(op6 instanceof Knight && ((Knight) op6).col == 1) ||
			(op7 instanceof Knight && ((Knight) op7).col == 1) ||
			(op8 instanceof Knight && ((Knight) op8).col == 1))
		{
			System.out.println("in_check");
			return true;
		}	
		
		try {op1 = (ImageIcon) chessBoardSquares[blackking.x_pos-1-1][blackking.y_pos-1+1].getIcon();} 
		catch (ArrayIndexOutOfBoundsException e) {System.out.println("caught");}
		try {op2 = (ImageIcon) chessBoardSquares[blackking.x_pos-1+1][blackking.y_pos-1+1].getIcon();}
		catch (ArrayIndexOutOfBoundsException e) {System.out.println("caught");}
		
		if ((op1 instanceof Pawn && ((Pawn) op1).col == 1) ||
		(op2 instanceof Pawn && ((Pawn) op2).col == 1))
		{
			System.out.println("in_check");
			return true;
		}
		
		return false;
	}
	
	public boolean inCheckWhite() {
		Piece column = new Piece("black_king.png");
		for (int i = whiteking.y_pos; i < 8; i++) {
			if (chessBoardSquares[whiteking.x_pos-1][i].getIcon() instanceof Piece) {
				column = (Piece) chessBoardSquares[whiteking.x_pos-1][i].getIcon();
				if (!((column instanceof Queen && column.col == 0) 
						|| (column instanceof Rook && column.col == 0)))
						 {
					break;
				}
				if ((column instanceof Queen || column instanceof Rook) && column.col == 0) {
					System.out.println("in_check");
					return true;
				}
			}
		}
		for (int i = whiteking.y_pos-2; i > 0; i--) {
			if (chessBoardSquares[whiteking.x_pos-1][i].getIcon() instanceof Piece) {
				column = (Piece) chessBoardSquares[whiteking.x_pos-1][i].getIcon();
				if (!((column instanceof Queen && column.col == 0)
						|| (column instanceof Rook && column.col == 0)))
						 {
					break;
				}
				if ((column instanceof Queen || column instanceof Rook) && column.col == 0) {
					System.out.println("in_check");
					return true;
				}
			}
		}
		int k;
		k = Math.min(8-whiteking.y_pos-1, whiteking.x_pos-1);
		for (int i = 1; i < k ; i++) {
			System.out.println("wegothere");
			System.out.println("k");
			System.out.println("" + k);
			if (chessBoardSquares[whiteking.x_pos-1-i][whiteking.y_pos-1+i].getIcon() instanceof Piece) {
				column = (Piece) chessBoardSquares[whiteking.x_pos-1-i][whiteking.y_pos-1+i].getIcon();
				if (!((column instanceof Bishop && column.col == 0) 
						|| (column instanceof Queen && column.col == 0)))
						 {
					break;
				}
				if ((column instanceof Bishop || column instanceof Queen) && column.col == 0) {
					System.out.println("in_check");
					return true;
				}
			}
		}
		k = Math.min(8-whiteking.y_pos-1, 8-whiteking.x_pos-1);
		for (int i = 1; i < k ; i++) {
			System.out.println("wegothere");
			System.out.println("k");
			System.out.println("" + k);
			if (chessBoardSquares[whiteking.x_pos-1+i][whiteking.y_pos-1+i].getIcon() instanceof Piece) {
				column = (Piece) chessBoardSquares[whiteking.x_pos-1+i][whiteking.y_pos-1+i].getIcon();
				if (!((column instanceof Bishop && column.col == 0) 
						|| (column instanceof Queen && column.col == 0)))
						 {
					break;
				}
				if ((column instanceof Bishop || column instanceof Queen) && column.col == 0) {
					System.out.println("in_check");
					return true;
				}
			}
		}
		k = Math.min(whiteking.y_pos-1, 8-whiteking.x_pos-1);
		for (int i = 1; i < k ; i++) {
			System.out.println("wegothere");
			System.out.println("k");
			System.out.println("" + k);
			if (chessBoardSquares[whiteking.x_pos-1+i][whiteking.y_pos-1-i].getIcon() instanceof Piece) {
				column = (Piece) chessBoardSquares[whiteking.x_pos-1+i][whiteking.y_pos-1-i].getIcon();
				if (!((column instanceof Bishop && column.col == 0) 
						|| (column instanceof Queen && column.col == 0)))
						 {
					break;
				}
				if ((column instanceof Bishop || column instanceof Queen) && column.col == 0) {
					System.out.println("in_check");
					return true;
				}
			}
		}
		k = Math.min(whiteking.y_pos-1, whiteking.x_pos-1);
		for (int i = 1; i < k ; i++) {
			System.out.println("wegothere");
			System.out.println("k");
			System.out.println("" + k);
			if (chessBoardSquares[whiteking.x_pos-1-i][whiteking.y_pos-1-i].getIcon() instanceof Piece) {
				column = (Piece) chessBoardSquares[whiteking.x_pos-1-i][whiteking.y_pos-1-i].getIcon();
				if (!((column instanceof Bishop && column.col == 0) 
						|| (column instanceof Queen && column.col == 0)))
						 {
					break;
				}
				if ((column instanceof Bishop || column instanceof Queen) && column.col == 0) {
					System.out.println("in_check");
					return true;
				}
			}
		}
		
		ImageIcon op1 = new Piece("black_queen");
		ImageIcon op2 = new Piece("black_queen");
		ImageIcon op3 = new Piece("black_queen");
		ImageIcon op4 = new Piece("black_queen");
		ImageIcon op5 = new Piece("black_queen");
		ImageIcon op6 = new Piece("black_queen");
		ImageIcon op7 = new Piece("black_queen");
		ImageIcon op8 = new Piece("black_queen");
		
		try {op1 = (ImageIcon) chessBoardSquares[whiteking.x_pos-1+2][whiteking.y_pos-1+1].getIcon();} 
		catch (ArrayIndexOutOfBoundsException e) {System.out.println("caught");}
		try {op2 = (ImageIcon) chessBoardSquares[whiteking.x_pos-1+1][whiteking.y_pos-1+2].getIcon();}
		catch (ArrayIndexOutOfBoundsException e) {System.out.println("caught");}
		try {op3 = (ImageIcon) chessBoardSquares[whiteking.x_pos-1-2][whiteking.y_pos-1+1].getIcon();}
		catch (ArrayIndexOutOfBoundsException e) {System.out.println("caught");}
		try {op4 = (ImageIcon) chessBoardSquares[whiteking.x_pos-1-1][whiteking.y_pos-1+2].getIcon();}
		catch (ArrayIndexOutOfBoundsException e) {System.out.println("caught");}
		try {op5 = (ImageIcon) chessBoardSquares[whiteking.x_pos-1-1][whiteking.y_pos-1-2].getIcon();}
		catch (ArrayIndexOutOfBoundsException e) {System.out.println("caught");}
		try {op6 = (ImageIcon) chessBoardSquares[whiteking.x_pos-1-2][whiteking.y_pos-1-1].getIcon();}
		catch (ArrayIndexOutOfBoundsException e) {System.out.println("caught");}
		try {op7 = (ImageIcon) chessBoardSquares[whiteking.x_pos-1+1][whiteking.y_pos-1-2].getIcon();}
		catch (ArrayIndexOutOfBoundsException e) {System.out.println("caught");}
		try {op8 = (ImageIcon) chessBoardSquares[whiteking.x_pos-1+2][whiteking.y_pos-1-1].getIcon();}
		catch (ArrayIndexOutOfBoundsException e) {System.out.println("caught");}
		
		if ((op1 instanceof Knight && ((Knight) op1).col == 0) ||
			(op2 instanceof Knight && ((Knight) op2).col == 0) ||
			(op3 instanceof Knight && ((Knight) op3).col == 0) ||
			(op4 instanceof Knight && ((Knight) op4).col == 0) ||
			(op5 instanceof Knight && ((Knight) op5).col == 0) ||
			(op6 instanceof Knight && ((Knight) op6).col == 0) ||
			(op7 instanceof Knight && ((Knight) op7).col == 0) ||
			(op8 instanceof Knight && ((Knight) op8).col == 0))
		{
			System.out.println("in_check");
			return true;
		}	
		
		try {op1 = (ImageIcon) chessBoardSquares[whiteking.x_pos-1-1][whiteking.y_pos-1-1].getIcon();} 
		catch (ArrayIndexOutOfBoundsException e) {System.out.println("caught");}
		try {op2 = (ImageIcon) chessBoardSquares[whiteking.x_pos-1+1][whiteking.y_pos-1-1].getIcon();}
		catch (ArrayIndexOutOfBoundsException e) {System.out.println("caught");}
		
		if ((op1 instanceof Pawn && ((Pawn) op1).col == 0) ||
		(op2 instanceof Pawn && ((Pawn) op2).col == 0))
		{
			System.out.println("in_check");
			return true;
		}
		
		return false;
	}
	
	
	public boolean inCheck() {
		Piece column = new Piece("black_king.png");
		for (int i = blackking.y_pos-2; i > 0 ; i--) {
			if (chessBoardSquares[blackking.x_pos-1][i].getIcon() instanceof Piece) {
				column = (Piece) chessBoardSquares[blackking.x_pos-1][i].getIcon();
				if (!((column instanceof Queen && column.col == 1) 
						|| (column instanceof Rook && column.col == 1)))
						 {
					break;
				}
				if ((column instanceof Queen || column instanceof Rook) && column.col == 1) {
					System.out.println("in_check");
					return true;
				}
			}
		}
		for (int i = blackking.y_pos; i < 8; i++) {
			System.out.println("" + blackking.y_pos);
			if (chessBoardSquares[blackking.x_pos-1][i].getIcon() instanceof Piece) {
				column = (Piece) chessBoardSquares[blackking.x_pos-1][i].getIcon();
				System.out.println("trace");
				if (!((column instanceof Queen && column.col == 1) 
						|| (column instanceof Rook && column.col == 1)))
						 {
					break;
				}
				if ((column instanceof Queen || column instanceof Rook) && column.col == 1) {
					System.out.println("in_check");
					return true;
				}
			}
		}
		for (int i = whiteking.y_pos; i < 8; i++) {
			if (chessBoardSquares[whiteking.x_pos-1][i].getIcon() instanceof Piece) {
				column = (Piece) chessBoardSquares[whiteking.x_pos-1][i].getIcon();
				if (!((column instanceof Queen && column.col == 0) 
						|| (column instanceof Rook && column.col == 0)))
						 {
					break;
				}
				if ((column instanceof Queen || column instanceof Rook) && column.col == 0) {
					System.out.println("in_check");
					return true;
				}
			}
		}
		for (int i = whiteking.y_pos-2; i > 0; i--) {
			if (chessBoardSquares[whiteking.x_pos-1][i].getIcon() instanceof Piece) {
				column = (Piece) chessBoardSquares[whiteking.x_pos-1][i].getIcon();
				if (!((column instanceof Queen && column.col == 0)
						|| (column instanceof Rook && column.col == 0)))
						 {
					break;
				}
				if ((column instanceof Queen || column instanceof Rook) && column.col == 0) {
					System.out.println("in_check");
					return true;
				}
			}
		}
		int k;
		k = Math.min(8-blackking.y_pos-1, blackking.x_pos-1);
		for (int i = 1; i < k ; i++) {
			System.out.println("wegothere");
			System.out.println("k");
			System.out.println("" + k);
			if (chessBoardSquares[blackking.x_pos-1-i][blackking.y_pos-1+i].getIcon() instanceof Piece) {
				column = (Piece) chessBoardSquares[blackking.x_pos-1-i][blackking.y_pos-1+i].getIcon();
				if (!((column instanceof Bishop && column.col == 1) 
						|| (column instanceof Queen && column.col == 1)))
						 {
					break;
				}
				if ((column instanceof Bishop || column instanceof Queen) && column.col == 1) {
					System.out.println("in_check");
					return true;
				}
			}
		}
		k = Math.min(8-blackking.y_pos-1, 8-blackking.x_pos-1);
		for (int i = 1; i < k ; i++) {
			System.out.println("wegothere");
			System.out.println("k");
			System.out.println("" + k);
			if (chessBoardSquares[blackking.x_pos-1+i][blackking.y_pos-1+i].getIcon() instanceof Piece) {
				column = (Piece) chessBoardSquares[blackking.x_pos-1+i][blackking.y_pos-1+i].getIcon();
				if (!((column instanceof Bishop && column.col == 1) 
						|| (column instanceof Queen && column.col == 1)))
						 {
					break;
				}
				if ((column instanceof Bishop || column instanceof Queen) && column.col == 1) {
					System.out.println("in_check");
					return true;
				}
			}
		}
		k = Math.min(blackking.y_pos-1, 8-blackking.x_pos-1);
		for (int i = 1; i < k ; i++) {
			System.out.println("wegothere");
			System.out.println("k");
			System.out.println("" + k);
			if (chessBoardSquares[blackking.x_pos-1+i][blackking.y_pos-1-i].getIcon() instanceof Piece) {
				column = (Piece) chessBoardSquares[blackking.x_pos-1+i][blackking.y_pos-1-i].getIcon();
				if (!((column instanceof Bishop && column.col == 1) 
						|| (column instanceof Queen && column.col == 1)))
						 {
					break;
				}
				if ((column instanceof Bishop || column instanceof Queen) && column.col == 1) {
					System.out.println("in_check");
					return true;
				}
			}
		}
		k = Math.min(blackking.y_pos-1, blackking.x_pos-1);
		for (int i = 1; i < k ; i++) {
			System.out.println("wegothere");
			System.out.println("k");
			System.out.println("" + k);
			if (chessBoardSquares[blackking.x_pos-1-i][blackking.y_pos-1-i].getIcon() instanceof Piece) {
				column = (Piece) chessBoardSquares[blackking.x_pos-1-i][blackking.y_pos-1-i].getIcon();
				if (!((column instanceof Bishop && column.col == 1) 
						|| (column instanceof Queen && column.col == 1)))
						 {
					break;
				}
				if ((column instanceof Bishop || column instanceof Queen) && column.col == 1) {
					System.out.println("in_check");
					return true;
				}
			}
		}
		k = Math.min(8-whiteking.y_pos-1, whiteking.x_pos-1);
		for (int i = 1; i < k ; i++) {
			System.out.println("wegothere");
			System.out.println("k");
			System.out.println("" + k);
			if (chessBoardSquares[whiteking.x_pos-1-i][whiteking.y_pos-1+i].getIcon() instanceof Piece) {
				column = (Piece) chessBoardSquares[whiteking.x_pos-1-i][whiteking.y_pos-1+i].getIcon();
				if (!((column instanceof Bishop && column.col == 0) 
						|| (column instanceof Queen && column.col == 0)))
						 {
					break;
				}
				if ((column instanceof Bishop || column instanceof Queen) && column.col == 0) {
					System.out.println("in_check");
					return true;
				}
			}
		}
		k = Math.min(8-whiteking.y_pos-1, 8-whiteking.x_pos-1);
		for (int i = 1; i < k ; i++) {
			System.out.println("wegothere");
			System.out.println("k");
			System.out.println("" + k);
			if (chessBoardSquares[whiteking.x_pos-1+i][whiteking.y_pos-1+i].getIcon() instanceof Piece) {
				column = (Piece) chessBoardSquares[whiteking.x_pos-1+i][whiteking.y_pos-1+i].getIcon();
				if (!((column instanceof Bishop && column.col == 0) 
						|| (column instanceof Queen && column.col == 0)))
						 {
					break;
				}
				if ((column instanceof Bishop || column instanceof Queen) && column.col == 0) {
					System.out.println("in_check");
					return true;
				}
			}
		}
		k = Math.min(whiteking.y_pos-1, 8-whiteking.x_pos-1);
		for (int i = 1; i < k ; i++) {
			System.out.println("wegothere");
			System.out.println("k");
			System.out.println("" + k);
			if (chessBoardSquares[whiteking.x_pos-1+i][whiteking.y_pos-1-i].getIcon() instanceof Piece) {
				column = (Piece) chessBoardSquares[whiteking.x_pos-1+i][whiteking.y_pos-1-i].getIcon();
				if (!((column instanceof Bishop && column.col == 0) 
						|| (column instanceof Queen && column.col == 0)))
						 {
					break;
				}
				if ((column instanceof Bishop || column instanceof Queen) && column.col == 0) {
					System.out.println("in_check");
					return true;
				}
			}
		}
		k = Math.min(whiteking.y_pos-1, whiteking.x_pos-1);
		for (int i = 1; i < k ; i++) {
			System.out.println("wegothere");
			System.out.println("k");
			System.out.println("" + k);
			if (chessBoardSquares[whiteking.x_pos-1-i][whiteking.y_pos-1-i].getIcon() instanceof Piece) {
				column = (Piece) chessBoardSquares[whiteking.x_pos-1-i][whiteking.y_pos-1-i].getIcon();
				if (!((column instanceof Bishop && column.col == 0) 
						|| (column instanceof Queen && column.col == 0)))
						 {
					break;
				}
				if ((column instanceof Bishop || column instanceof Queen) && column.col == 0) {
					System.out.println("in_check");
					return true;
				}
			}
		}
		ImageIcon op1 = new Piece("black_queen");
		ImageIcon op2 = new Piece("black_queen");
		ImageIcon op3 = new Piece("black_queen");
		ImageIcon op4 = new Piece("black_queen");
		ImageIcon op5 = new Piece("black_queen");
		ImageIcon op6 = new Piece("black_queen");
		ImageIcon op7 = new Piece("black_queen");
		ImageIcon op8 = new Piece("black_queen");
		
		try {op1 = (ImageIcon) chessBoardSquares[blackking.x_pos-1+2][blackking.y_pos-1+1].getIcon();} 
		catch (ArrayIndexOutOfBoundsException e) {System.out.println("caught");}
		try {op2 = (ImageIcon) chessBoardSquares[blackking.x_pos-1+1][blackking.y_pos-1+2].getIcon();}
		catch (ArrayIndexOutOfBoundsException e) {System.out.println("caught");}
		try {op3 = (ImageIcon) chessBoardSquares[blackking.x_pos-1-2][blackking.y_pos-1+1].getIcon();}
		catch (ArrayIndexOutOfBoundsException e) {System.out.println("caught");}
		try {op4 = (ImageIcon) chessBoardSquares[blackking.x_pos-1-1][blackking.y_pos-1+2].getIcon();}
		catch (ArrayIndexOutOfBoundsException e) {System.out.println("caught");}
		try {op5 = (ImageIcon) chessBoardSquares[blackking.x_pos-1-1][blackking.y_pos-1-2].getIcon();}
		catch (ArrayIndexOutOfBoundsException e) {System.out.println("caught");}
		try {op6 = (ImageIcon) chessBoardSquares[blackking.x_pos-1-2][blackking.y_pos-1-1].getIcon();}
		catch (ArrayIndexOutOfBoundsException e) {System.out.println("caught");}
		try {op7 = (ImageIcon) chessBoardSquares[blackking.x_pos-1+1][blackking.y_pos-1-2].getIcon();}
		catch (ArrayIndexOutOfBoundsException e) {System.out.println("caught");}
		try {op8 = (ImageIcon) chessBoardSquares[blackking.x_pos-1+2][blackking.y_pos-1-1].getIcon();}
		catch (ArrayIndexOutOfBoundsException e) {System.out.println("caught");}
		
		if ((op1 instanceof Knight && ((Knight) op1).col == 1) ||
			(op2 instanceof Knight && ((Knight) op2).col == 1) ||
			(op3 instanceof Knight && ((Knight) op3).col == 1) ||
			(op4 instanceof Knight && ((Knight) op4).col == 1) ||
			(op5 instanceof Knight && ((Knight) op5).col == 1) ||
			(op6 instanceof Knight && ((Knight) op6).col == 1) ||
			(op7 instanceof Knight && ((Knight) op7).col == 1) ||
			(op8 instanceof Knight && ((Knight) op8).col == 1))
		{
			System.out.println("in_check");
			return true;
		}	
		
		try {op1 = (ImageIcon) chessBoardSquares[whiteking.x_pos-1+2][whiteking.y_pos-1+1].getIcon();} 
		catch (ArrayIndexOutOfBoundsException e) {System.out.println("caught");}
		try {op2 = (ImageIcon) chessBoardSquares[whiteking.x_pos-1+1][whiteking.y_pos-1+2].getIcon();}
		catch (ArrayIndexOutOfBoundsException e) {System.out.println("caught");}
		try {op3 = (ImageIcon) chessBoardSquares[whiteking.x_pos-1-2][whiteking.y_pos-1+1].getIcon();}
		catch (ArrayIndexOutOfBoundsException e) {System.out.println("caught");}
		try {op4 = (ImageIcon) chessBoardSquares[whiteking.x_pos-1-1][whiteking.y_pos-1+2].getIcon();}
		catch (ArrayIndexOutOfBoundsException e) {System.out.println("caught");}
		try {op5 = (ImageIcon) chessBoardSquares[whiteking.x_pos-1-1][whiteking.y_pos-1-2].getIcon();}
		catch (ArrayIndexOutOfBoundsException e) {System.out.println("caught");}
		try {op6 = (ImageIcon) chessBoardSquares[whiteking.x_pos-1-2][whiteking.y_pos-1-1].getIcon();}
		catch (ArrayIndexOutOfBoundsException e) {System.out.println("caught");}
		try {op7 = (ImageIcon) chessBoardSquares[whiteking.x_pos-1+1][whiteking.y_pos-1-2].getIcon();}
		catch (ArrayIndexOutOfBoundsException e) {System.out.println("caught");}
		try {op8 = (ImageIcon) chessBoardSquares[whiteking.x_pos-1+2][whiteking.y_pos-1-1].getIcon();}
		catch (ArrayIndexOutOfBoundsException e) {System.out.println("caught");}
		
		if ((op1 instanceof Knight && ((Knight) op1).col == 0) ||
			(op2 instanceof Knight && ((Knight) op2).col == 0) ||
			(op3 instanceof Knight && ((Knight) op3).col == 0) ||
			(op4 instanceof Knight && ((Knight) op4).col == 0) ||
			(op5 instanceof Knight && ((Knight) op5).col == 0) ||
			(op6 instanceof Knight && ((Knight) op6).col == 0) ||
			(op7 instanceof Knight && ((Knight) op7).col == 0) ||
			(op8 instanceof Knight && ((Knight) op8).col == 0))
		{
			System.out.println("in_check");
			return true;
		}	
		
		try {op1 = (ImageIcon) chessBoardSquares[blackking.x_pos-1-1][blackking.y_pos-1+1].getIcon();} 
		catch (ArrayIndexOutOfBoundsException e) {System.out.println("caught");}
		try {op2 = (ImageIcon) chessBoardSquares[blackking.x_pos-1+1][blackking.y_pos-1+1].getIcon();}
		catch (ArrayIndexOutOfBoundsException e) {System.out.println("caught");}
		
		if ((op1 instanceof Pawn && ((Pawn) op1).col == 1) ||
		(op2 instanceof Pawn && ((Pawn) op2).col == 1))
		{
			System.out.println("in_check");
			return true;
		}
		
		try {op1 = (ImageIcon) chessBoardSquares[whiteking.x_pos-1-1][whiteking.y_pos-1-1].getIcon();} 
		catch (ArrayIndexOutOfBoundsException e) {System.out.println("caught");}
		try {op2 = (ImageIcon) chessBoardSquares[whiteking.x_pos-1+1][whiteking.y_pos-1-1].getIcon();}
		catch (ArrayIndexOutOfBoundsException e) {System.out.println("caught");}
		
		if ((op1 instanceof Pawn && ((Pawn) op1).col == 0) ||
		(op2 instanceof Pawn && ((Pawn) op2).col == 0))
		{
			System.out.println("in_check");
			return true;
		}
		
		System.out.println("not_in_check");
		return false; 
	}

	/*
	 * Main method run to start and run the game Initializes the GUI elements
	 * specified in Game and runs it IMPORTANT: Do NOT delete! You MUST include
	 * this in the final submission of your game.
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Game());
	}
}
