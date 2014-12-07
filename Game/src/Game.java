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
	ImageIcon image; 
	JButton butt; 
	int xAdjustment;
	int yAdjustment;
	JButton[][] chessBoardSquares;
	
    static Font font = new Font("Sans-Serif", Font.PLAIN, 50);
    
    final Rook black_rook = new Rook("black_rook.png");
    final Knight black_knight = new Knight("black_knight.png");
    final Bishop black_bishop = new Bishop("black_bishop.png");
    final Pawn black_pawn = new Pawn("black_pawn.png");
    final King black_king = new King("black_king.png");
    final Queen black_queen = new Queen("black_queen.png");   
    final Rook white_rook = new Rook("white_rook.png");
    final Knight white_knight = new Knight("white_knight.png");
    final Bishop white_bishop = new Bishop("white_bishop.png");
    final Pawn white_pawn = new Pawn("white_pawn.png");
    final King white_king = new King("white_king.png");
    final Queen white_queen = new Queen("white_queen.png");   


	public void run() {
		// NOTE : recall that the 'final' keyword notes inmutability
		// even for local variables.

		// Top-level frame in which game components live
		// Be sure to change "TOP LEVEL FRAME" to the name of your game		
		
		pressed = false;
		image = new ImageIcon("black_white_rook.png");
		
	    final String COLS = "ABCDEFGH";
		
		final JFrame frame = new JFrame("TOP LEVEL FRAME");
		frame.setLocation(300, 300);
		
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
        f1.setIcon(black_bishop);
        JButton g1 = (JButton) chessBoard.getComponent(16);
        g1.setIcon(black_knight);
        JButton h1 = (JButton) chessBoard.getComponent(17);
        h1.setIcon(black_rook);
        JButton a2 = (JButton) chessBoard.getComponent(19);
        a2.setIcon(black_pawn);
        JButton b2 = (JButton) chessBoard.getComponent(20);
        b2.setIcon(black_pawn);
        JButton c2 = (JButton) chessBoard.getComponent(21);
        c2.setIcon(black_pawn);
        JButton d2 = (JButton) chessBoard.getComponent(22);
        d2.setIcon(black_pawn);
        JButton e2 = (JButton) chessBoard.getComponent(23);
        e2.setIcon(black_pawn);
        JButton f2 = (JButton) chessBoard.getComponent(24);
        f2.setIcon(black_pawn);
        JButton g2 = (JButton) chessBoard.getComponent(25);
        g2.setIcon(black_pawn);
        JButton h2 = (JButton) chessBoard.getComponent(26);
        h2.setIcon(black_pawn);
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
        f8.setIcon(white_bishop);
        JButton g8 = (JButton) chessBoard.getComponent(79);
        g8.setIcon(white_knight);
        JButton h8 = (JButton) chessBoard.getComponent(80);
        h8.setIcon(white_rook);
        JButton a7 = (JButton) chessBoard.getComponent(64);
        a7.setIcon(white_pawn);
        JButton b7 = (JButton) chessBoard.getComponent(65);
        b7.setIcon(white_pawn);
        JButton c7 = (JButton) chessBoard.getComponent(66);
        c7.setIcon(white_pawn);
        JButton d7 = (JButton) chessBoard.getComponent(67);
        d7.setIcon(white_pawn);
        JButton e7 = (JButton) chessBoard.getComponent(68);
        e7.setIcon(white_pawn);
        JButton f7 = (JButton) chessBoard.getComponent(69);
        f7.setIcon(white_pawn);
        JButton g7 = (JButton) chessBoard.getComponent(70);
        g7.setIcon(white_pawn);
        JButton h7 = (JButton) chessBoard.getComponent(71);
        h7.setIcon(white_pawn);
        
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
		final JLabel status = new JLabel("Running...");
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
		    	if (pressed == true) { 
		    		pressed = false;
		    		chessBoardSquares[i][j].setIcon(image);
		    		}
		    	else {
		    		pressed = true;
		    		image = (ImageIcon) chessBoardSquares[i][j].getIcon();
		    	}
		    }
		   });
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
