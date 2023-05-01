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
	ArrayList<Projectile> projectiles = new ArrayList<Projectile>();
	
	public RunGame() {
		samurai = new Player();
		Obstacle cannon1 = new Cannon(900, 200);
		obstacles.add(cannon1);
		Obstacle cannon2 = new Cannon(0, 200);
		obstacles.add(cannon2);
		Clicker theClicker = new Clicker(samurai);
		
		
		frame = new JFrame();
		chamber = new Chamber(samurai, background, obstacles, projectiles);
		chamber.setPreferredSize(new Dimension(1000, 750));
		frame.addMouseListener(theClicker);
		frame.addKeyListener(theClicker);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(chamber);
		frame.pack();
	    frame.setVisible(true);
	    frame.requestFocus();
	    timer.start();
	}
	
	public static int counter = 0;
	ActionListener run = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if(counter % 1 == 0) {
				Projectile cannonBall1 = new CannonBall(890, 245, samurai.getXPos(), samurai.getYPos());
				projectiles.add(cannonBall1);	
				Projectile cannonBall2 = new CannonBall(100, 245, samurai.getXPos(), samurai.getYPos());
				projectiles.add(cannonBall2);	
			}
			for(int i = 0; i < projectiles.size(); i++) {
				projectiles.get(i).updateProjectile();
				if(projectiles.get(i).getX() > 1000 || projectiles.get(i).getY() > 750 ||
				projectiles.get(i).getX() < 0 || projectiles.get(i).getY() < 0) {
					projectiles.remove(i);
				}
			}
			samurai.updatePlayer();
			chamber.repaint();
			counter++;
		}
	};
	Timer timer = new Timer(20, run);
	

	public static void main(String[] args) {
		new RunGame();
	}
	
	//end

}
