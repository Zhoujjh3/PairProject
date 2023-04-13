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
	int chamberHeight, chamberWidth;
	
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
	    chamberHeight = chamber.getHeight();
	    chamberWidth = chamber.getWidth();
	    timer.start();
	}
	
	int counter = 0;
	ActionListener run = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			System.out.println("___WIDTH BEFORE____");
			System.out.println(chamberWidth);
			System.out.println(chamber.getWidth());
			System.out.println("____HEIGHT BEFORE____");
			System.out.println(chamberHeight);
			System.out.println(chamber.getHeight());
			samurai.updatePlayer();
			chamber.repaint();
			
			if(chamberWidth != chamber.getWidth()) {
				System.out.println("yikes");
				chamberWidth = chamber.getWidth();
				chamberHeight = (int) (((double) chamber.getWidth() / 1000.0) * 750.0); 
				chamber.setSize(new Dimension(chamberWidth, chamberHeight));
				frame.setSize(new Dimension(chamberWidth, chamberHeight));
				System.out.println("corrected");
			} 
			if (chamberHeight != chamber.getHeight()) {
				System.out.println("yikes");
				chamberHeight = chamber.getHeight();
				chamberWidth = (int) (((double) chamber.getHeight() / 750.0) * 1000.0); 
				chamber.setSize(new Dimension(chamberWidth, chamberHeight));
				frame.setSize(new Dimension(chamberWidth, chamberHeight));
				System.out.println("corrected");
			}
			chamberWidth = chamber.getWidth();
			chamberHeight = chamber.getHeight();
			System.out.println("___WIDTH____");
			System.out.println(chamberWidth);
			System.out.println(chamber.getWidth());
			System.out.println("____HEIGHT____");
			System.out.println(chamberHeight);
			System.out.println(chamber.getHeight());
		}
	};
	Timer timer = new Timer(1000, run);
	

	public static void main(String[] args) {
		new RunGame();
	}

}
