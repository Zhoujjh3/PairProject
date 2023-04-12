package buggybug;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.*;
import javax.swing.ImageIcon;

public class Player {

	int runCounter, swingCounter;
	double velocityX, velocityY, accelX, accelY;
	int xPos, yPos;
	boolean direction;
	boolean move, jump, swing;
	Image player;
	
	public enum States{
		IDLE, MOVING;
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
		
		velocityX = 0;
		velocityY = -10;
		accelX = 0;
		accelY = 0;
		
		move = false;
		jump = false;
		swing = false;
	}
	
	public void updatePlayer() {
		switch(state) {
		case IDLE:
			System.out.println("fjdskljfl");
			velocityY = -10;
			velocityX = 0;
			
			move = false;
			jump = false;
			swing = false;
			break;
		case MOVING:
			if(move) {
				if(direction) {
					velocityX = 8;
					//accelX = 0.5;
				} else if(!direction) {
					velocityX = -8;
					//accelX = -0.5;
				}
			}
			
			if(jump || yPos <= 500) {
				accelY = 0.5;
				velocityY += accelY;
				yPos += velocityY;
			}
//			if(velocityX < 6 && velocityX > -6) {
//				velocityX += accelX;
//			}
			
			xPos += velocityX;
			//System.out.println("RUNNING");
			break;
//		case SWINGING:
//			
//			break;
		}
	}
	
	public void changeDirection(String dir) {
		if(dir.equals("LEFT")) {
			direction = false;
		} else if(dir.equals("RIGHT")){
			direction = true;
		}
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
	
	public void toggleJump() {
		if(!jump) {
			jump = true;
		} else if(yPos >= 500) {
			yPos = 500;
			jump = false;
		}
	}
	
	public void setMove(boolean move) {
		this.move = move;
	}
	
	public void drawPlayer(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(player, xPos, yPos, 200, 200, null);
	}
}
