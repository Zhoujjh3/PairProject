import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Player {

	int runCounter, swingCounter;
	double velocityX, velocityY, accelX, accelY;
	int xPos, yPos;
	Image player;
	
	public Player() {
		//player = new ImageIcon(getClass().getClassLoader().getResource("up arrow.png")).getImage();
		player = new ImageIcon("images\\swordsman3.png").getImage();
		xPos = 500;
		yPos = 500;
	}
	
	public void updatePlayer() {
		
	}
	
	public void drawPlayer(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(player, xPos, yPos, 200, 200, null);
	}
}
