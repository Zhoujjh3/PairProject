import java.awt.*;
import java.util.*;
import javax.swing.*;


public class Chamber extends JPanel{
	
	Player samurai;
	Image chamber;
	ArrayList<Obstacle> theOPPS;
	ArrayList<Projectile> thePROJ;
	ArrayList<Platform> thePLAT;
	Color backgroundColor;
	int R, G, B;
	
	public Chamber(Player player, Image background, ArrayList<Obstacle> obstacles, 
			ArrayList<Projectile> projectiles, ArrayList<Platform> platforms) {
		samurai = player;
		chamber = background;
		theOPPS = obstacles;
		thePROJ = projectiles;
		thePLAT = platforms;
		R=1;
		G=0;
		B=20;
		backgroundColor = new Color(R,G,B,90);
	}
	
	public void paintComponent(Graphics g) {
		R = (int) (RunGame.lightCounter);
		G = (int) (RunGame.lightCounter);
		B = (int) RunGame.lightCounter;
		
		//System.out.println(B);
		backgroundColor = new Color(R, G, B, 90);
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(backgroundColor);
		g2.fillRect(0, 0, this.getWidth(), this.getHeight());
		
		//g2.drawImage(chamber, 0, 0, 1000, 750, null);
		for(int i = 0; i < theOPPS.size(); i++) {
			theOPPS.get(i).drawObstacle(g2);
		}
		for(int i = 0; i < thePROJ.size(); i++) {
			thePROJ.get(i).drawProjectile(g2);
		}
		for(int i = 0; i < thePLAT.size(); i++) {
			thePLAT.get(i).drawPlatform(g2);
		}
		samurai.drawPlayer(g);		
		
		g2.drawLine(0, 500, 1000, 500);
	}
}
