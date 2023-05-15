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
	
	Image[] tutorialScreens = {
			new ImageIcon("images//screens//tutorial 1.png").getImage(),
			new ImageIcon("images//screens//tutorial 2.png").getImage(),
			new ImageIcon("images//screens//tutorial 3.png").getImage(),
			new ImageIcon("images//screens//tutorial 4.png").getImage(),
			new ImageIcon("images//screens//tutorial 5.png").getImage(),
			new ImageIcon("images//screens//tutorial 6.png").getImage(),
			new ImageIcon("images//screens//tutorial 6.png").getImage(),
			new ImageIcon("images//screens//tutorial 6.png").getImage()
	};
	
	Color[] endColors = {
			new Color(255, 255, 255, 100),
			new Color(240, 240, 240, 90),
			new Color(225, 225, 225, 80),
			new Color(200, 200, 200, 70),
			new Color(180, 180, 180, 60),
			new Color(150, 150, 150, 50),
			new Color(120, 120, 120, 40),
			new Color(90, 90, 90, 30),
			new Color(75, 40, 40, 20),
			new Color(75, 10, 10, 10)
	};
	
	Image gameOver = new ImageIcon("images//screens//Lose Screen.png").getImage();
	
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
			
		} else if(RunGame.state == RunGame.gameState.TUTORIAL){
			g2.drawImage(tutorialScreens[(int)RunGame.screenCounter], 0, 0, 1000, 750, null);
			
		}else if(RunGame.state == RunGame.gameState.PLAYGAME) {
			R = (int) (RunGame.lightCounter);
			G = (int) (RunGame.lightCounter);
			B = (int) RunGame.lightCounter;
			
			backgroundColor = new Color(R, G, B, 95);
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
			
		} else if(RunGame.state == RunGame.gameState.GAMEOVER){
			if(RunGame.screenCounter < 10) {
				g2.setColor(endColors[(int) RunGame.screenCounter]);
				g2.fillRect(0, 0, 1000, 750);
			} else {
				g2.setColor(new Color(75, 10, 10));
				g2.fillRect(0, 0, 1000, 750);
				g2.drawImage(gameOver, 0, 0, 1000, 750, null);
				g2.setColor(new Color(0, 0, 0));
				Font font = new Font("Serif", Font.PLAIN, 60);
				g.setFont(font);
				g2.drawString("" + samurai.getScore(), 490 - (20* (int) Math.log10(samurai.getScore())), 550);
			}
		}
	}
	
	public void reset() {
		theOPPS.removeAll(theOPPS);
		thePROJ.removeAll(thePROJ);
		thePLAT.removeAll(thePLAT);
		R=1;
		G=0;
		B=20;
		backgroundColor = new Color(R,G,B,90);
		thePLAT.add(new Platform(0, 500, 250));
	}
}
