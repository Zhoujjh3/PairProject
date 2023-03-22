
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class RunGame {
	
	JFrame frame;
	JPanel chamber;
	
	public RunGame() {
		frame = new JFrame();
		chamber = new Chamber();
		chamber.setPreferredSize(new Dimension(1000, 750));
		chamber.addMouseListener(new Clicker());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(chamber);
		frame.pack();
	    frame.setVisible(true);
	}

	public static void main(String[] args) {
		new RunGame();
	}
	

}
