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
	
	Image[] WelcomeScreens = {
			new ImageIcon("images//screens//WS-1.png").getImage(),
			new ImageIcon("images//screens//WS-2.png").getImage(),
			new ImageIcon("images//screens//WS-3.png").getImage(),
			new ImageIcon("images//screens//WS-4.png").getImage(),
			new ImageIcon("images//screens//WS-5.png").getImage(),
			new ImageIcon("images//screens//WS-6.png").getImage()
	};
	
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
		Graphics2D g2 = (Graphics2D) g;
		
		if(RunGame.state == RunGame.gameState.WELCOMESCREEN) {
			g2.drawImage(WelcomeScreens[(int)RunGame.screenCounter], 0, 0, 1000, 750, null);
			
		} else if(RunGame.state == RunGame.gameState.PLAYGAME) {
			R = (int) (RunGame.lightCounter);
			G = (int) (RunGame.lightCounter);
			B = (int) RunGame.lightCounter;
			
			backgroundColor = new Color(R, G, B, 90);
			g2.setColor(backgroundColor);
			g2.fillRect(0, 0, this.getWidth(), this.getHeight());
			
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
			
		} else {
			
		}
			
	}
}
