import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.*;
import javax.swing.ImageIcon;

public class Player {

	int runCounter, swingCounter;
	double velocityX, velocityY, accelX, accelY;
	int xPos, yPos, direction;
	boolean move, jump, swing;
	boolean[] keyPresses;
	Image player;
	
	public enum States{
		IDLE, MOVING;
	}
	States state = States.MOVING;
	
	Image[] playerStatesX;	//has all frames for running
	Image[] playerStatesY;	//has all frames for jumping
	Image[] playerSwing;	//has all frames for swing
	Image[] playerIdle;		//has all frames for idle
	
	public Player() {
		//player = new ImageIcon(getClass().getClassLoader().getResource("up arrow.png")).getImage();
		player = new ImageIcon("images//swordsman3.png").getImage();
		xPos = 500;
		yPos = 500;
		direction = 3;
		
		velocityX = 0;
		velocityY = 0;
		accelX = 0;
		accelY = 0;
		keyPresses = new boolean[100];
		
		move = false;
		jump = false;
		swing = false;
	}
	
	public void updatePlayer() {
				
		//horizontal movement
		if(keyPresses[64] || keyPresses[36]) {
			changeDirection("LEFT");
			velocityX = -1*Math.abs(velocityX);
			accelX = -2.5;
		} else if(keyPresses[38] || keyPresses[67]) {
			changeDirection("RIGHT");
			velocityX = Math.abs(velocityX);
			accelX = 2.5;
		} else {
			accelX = 0;
			velocityX = 0;
		}
		if(Math.abs(velocityX) < 15) {
			velocityX += accelX;
		}
				
		//vertical movement
		if(keyPresses[31]) {
			jump = true;
		}
		
		if(jump) {
			velocityY = -10;
			accelY = 0.5;
			jump = false;
		} else if(yPos > 495) {
			velocityY = 0;
			accelY = 0;
			yPos = 500;
		}
		velocityY += accelY;

		xPos += velocityX;
		yPos += velocityY;

	}
	
	public void changeDirection(String dir) {
		if(dir.equals("LEFT")) {
			direction = 0;
		} else if(dir.equals("RIGHT")){
			direction = 1;
		} else {
			direction = 2;
		}
	}
	
	public void changeBoolean(int keyValue, boolean newValue) {
		keyPresses[keyValue - 1] = newValue;
	}
	
	public int getXPos() {
		return xPos;
	}
	
	public int getYPos() {
		return yPos;
	}
	
	public void setVelocityY(double velocityY) {
		this.velocityY = velocityY;
	}
	
	public void setVelocityX(double velocityX) {
		this.velocityX = velocityX;
	}
	
	public void changeState(States state) {
		this.state = state;
	}
	
	public void setMove(boolean move) {
		this.move = move;
	}
	
	public void drawPlayer(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(player, xPos, yPos, 200, 200, null);
	}
	
	//end
}
