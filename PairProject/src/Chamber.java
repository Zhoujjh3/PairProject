import java.awt.*;
import java.util.*;
import javax.swing.*;


public class Chamber extends JPanel{
	
	Player samurai;
	Image chamber;
	ArrayList<Obstacle> theOPPS;
	ArrayList<Projectile> thePROJ;
	
	public Chamber(Player player, Image background, ArrayList<Obstacle> obstacles, ArrayList<Projectile> projectiles) {
		samurai = player;
		chamber = background;
		theOPPS = obstacles;
		thePROJ = projectiles;
	}
	
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		//g2.setColor(new Color(1,0,20,90));
		//g2.fillRect(0, 0, this.getWidth(), this.getHeight());
		
		g2.drawImage(chamber, 0, 0, 1000, 750, null);
		for(int i = 0; i < theOPPS.size(); i++) {
			theOPPS.get(i).drawObstacle(g2);
		}
		for(int i = 0; i < thePROJ.size(); i++) {
			thePROJ.get(i).drawProjectile(g2);
		}
		samurai.drawPlayer(g);
		//g2.setColor(Color.black);
		g2.fillRect(0, 694, this.getWidth(), this.getHeight()-694);
		
	}
	
	//Works?
}
