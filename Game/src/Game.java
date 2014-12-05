/**
 * CIS 120 HW10
 * (c) University of Pennsylvania
 * @version 2.0, Mar 2013
 */

// imports necessary libraries for Java swing
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.LineBorder;

/**
 * Game Main class that specifies the frame and widgets of the GUI
 */
public class Game implements Runnable {
	public void run() {
		// NOTE : recall that the 'final' keyword notes inmutability
		// even for local variables.

		// Top-level frame in which game components live
		// Be sure to change "TOP LEVEL FRAME" to the name of your game		
		
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
				ImageIcon icon = new ImageIcon();
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
				 chessBoard.add(chessBoardSquares[jj][ii]);
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
