
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;
import javax.swing.Timer;

public class RunGame {
	
	JFrame frame;
	JPanel chamber;
	Player samurai;
	Image background;
	
	public RunGame() {
		samurai = new Player();
		background = new ImageIcon("images//background0.png").getImage();
		
		frame = new JFrame();
		chamber = new Chamber(samurai, background);
		chamber.setPreferredSize(new Dimension(1000, 750));
		chamber.addMouseListener(new Clicker());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(chamber);
		frame.pack();
	    frame.setVisible(true);
	    
	}
	
	int counter = 0;
	ActionListener run = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
		}
	};
	Timer ShapesTimer = new Timer(5, run);
	

	public static void main(String[] args) {
		new RunGame();
	}

}
