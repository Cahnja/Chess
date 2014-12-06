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

/**
 * Game Main class that specifies the frame and widgets of the GUI
 */
public class Game implements Runnable {
	
	boolean pressed;
	
    static Font font = new Font("Sans-Serif", Font.PLAIN, 50);

	public void run() {
		// NOTE : recall that the 'final' keyword notes inmutability
		// even for local variables.

		// Top-level frame in which game components live
		// Be sure to change "TOP LEVEL FRAME" to the name of your game		
		
		pressed = false;
		
	    final String COLS = "ABCDEFGH";
	    
	    final ImageIcon white_white_rook = new ImageIcon("white_white_rook.png");
	    final ImageIcon white_black_rook = new ImageIcon("white_black_rook.png");
	    final ImageIcon white_black_knight = new ImageIcon("white_black_knight.png");
	    final ImageIcon white_white_knight = new ImageIcon("white_white_knight.png");
	    final ImageIcon white_black_bishop = new ImageIcon("white_black_bishop.png");
	    final ImageIcon white_white_bishop = new ImageIcon("white_white_bishop.png");
	    final ImageIcon white_black_pawn = new ImageIcon("white_black_pawn.png");
	    final ImageIcon white_white_pawn = new ImageIcon("white_white_pawn.png");
	    final ImageIcon white_black_king = new ImageIcon("white_black_king.png");
	    final ImageIcon white_white_queen = new ImageIcon("white_white_queen.png");
	    final ImageIcon black_white_rook = new ImageIcon("black_white_rook.png");
	    final ImageIcon black_black_rook = new ImageIcon("black_black_rook.png");
	    final ImageIcon black_black_knight = new ImageIcon("black_black_knight.png");
	    final ImageIcon black_white_knight = new ImageIcon("black_white_knight.png");
	    final ImageIcon black_black_bishop = new ImageIcon("black_black_bishop.png");
	    final ImageIcon black_white_bishop = new ImageIcon("black_white_bishop.png");
	    final ImageIcon black_black_pawn = new ImageIcon("black_black_pawn.png");
	    final ImageIcon black_white_pawn = new ImageIcon("black_white_pawn.png");
	    final ImageIcon black_white_king = new ImageIcon("black_white_king.png");
	    final ImageIcon black_black_queen = new ImageIcon("black_black_queen.png");   
		
		final JFrame frame = new JFrame("TOP LEVEL FRAME");
		frame.setLocation(300, 300);
		
	    final JButton[][] chessBoardSquares = new JButton[8][8];
		JPanel chessBoard = new JPanel(new GridLayout(9, 9));
		chessBoard.setBorder(new LineBorder(Color.BLACK));
		
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
                    System.out.println("hello");
                } else {
                    b.setBackground(Color.BLACK);
                    b.setOpaque(true);
                    System.out.println("goodbye");
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
        
        JButton a1 = (JButton) chessBoard.getComponent(10);
        a1.setIcon(black_white_rook);
        JButton b1 = (JButton) chessBoard.getComponent(11);
        b1.setIcon(black_black_knight);
        JButton c1 = (JButton) chessBoard.getComponent(12);
        c1.setIcon(black_white_bishop);
        JButton d1 = (JButton) chessBoard.getComponent(13);
        d1.setIcon(black_black_queen);
        JButton e1 = (JButton) chessBoard.getComponent(14);
        e1.setIcon(black_white_king);
        JButton f1 = (JButton) chessBoard.getComponent(15);
        f1.setIcon(black_black_bishop);
        JButton g1 = (JButton) chessBoard.getComponent(16);
        g1.setIcon(black_white_knight);
        JButton h1 = (JButton) chessBoard.getComponent(17);
        h1.setIcon(black_black_rook);
        JButton a2 = (JButton) chessBoard.getComponent(19);
        a2.setIcon(black_black_pawn);
        JButton b2 = (JButton) chessBoard.getComponent(20);
        b2.setIcon(black_white_pawn);
        JButton c2 = (JButton) chessBoard.getComponent(21);
        c2.setIcon(black_black_pawn);
        JButton d2 = (JButton) chessBoard.getComponent(22);
        d2.setIcon(black_white_pawn);
        JButton e2 = (JButton) chessBoard.getComponent(23);
        e2.setIcon(black_black_pawn);
        JButton f2 = (JButton) chessBoard.getComponent(24);
        f2.setIcon(black_white_pawn);
        JButton g2 = (JButton) chessBoard.getComponent(25);
        g2.setIcon(black_black_pawn);
        JButton h2 = (JButton) chessBoard.getComponent(26);
        h2.setIcon(black_white_pawn);
      
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

	/*
	 * Main method run to start and run the game Initializes the GUI elements
	 * specified in Game and runs it IMPORTANT: Do NOT delete! You MUST include
	 * this in the final submission of your game.
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Game());
	}
}
