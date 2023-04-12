package NewSystem;
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
	Image background = new ImageIcon("images//background0.png").getImage();;
	ArrayList<Obstacle> obstacles = new ArrayList<Obstacle>();
	
	public RunGame() {
		samurai = new Player();
		Clicker theClicker = new Clicker(samurai);
		
		frame = new JFrame();
		chamber = new Chamber(samurai, background, obstacles);
		chamber.setPreferredSize(new Dimension(1000, 750));
		chamber.addMouseListener(theClicker);
		chamber.addKeyListener(theClicker);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(chamber);
		frame.pack();
	    frame.setVisible(true);
	    chamber.requestFocus();
	    timer.start();
	}
	
	int counter = 0;
	ActionListener run = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			samurai.updatePlayer();
			chamber.repaint();
		}
	};
	Timer timer = new Timer(5, run);
	

	public static void main(String[] args) {
		new RunGame();
	}

}
