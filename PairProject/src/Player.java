import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.*;
import javax.swing.ImageIcon;

public class Player {

	int runCounter, swingCounter;
	double velocityX, velocityY, accelX, accelY;
	int xPos, yPos;
	Image player;
	
	enum States{
		IDLE, RUNNING, JUMPING, SWINGING;
	}
	States state = States.IDLE;
	
	Image[] playerStatesX;	//has all frames for running
	Image[] playerStatesY;	//has all frames for jumping
	Image[] playerSwing;	//has all frames for swing
	Image[] playerIdle;		//has all frames for idle
	
	public Player() {
		//player = new ImageIcon(getClass().getClassLoader().getResource("up arrow.png")).getImage();
		player = new ImageIcon("images//swordsman3.png").getImage();
		xPos = 500;
		yPos = 500;
	}
	
	public void updatePlayer() {
		switch(state) {
		case IDLE:
			
			break;
		case RUNNING:
			
			break;
		case JUMPING: 
			
			break;
		case SWINGING:
			
			break;
		}
	}
	
	public void drawPlayer(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(player, xPos, yPos, 200, 200, null);
	}
}
