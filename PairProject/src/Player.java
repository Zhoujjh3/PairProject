import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.*;
import javax.swing.ImageIcon;

public class Player {

	double runCounter, swingCounter;
	double velocityX, velocityY, accelX, accelY;
	int xPos, yPos, direction;
	boolean move, jump, swing, midAir;
	boolean[] keyPresses;
	Image player;
	
	public enum States{
		IDLE, MOVING;
	}
	States state = States.MOVING;
	
	Image[] playerRunLeft = 
		{
			new ImageIcon("images//left running frames//swordsman left run1.png").getImage(), 
			new ImageIcon("images//left running frames//swordsman left run2.png").getImage(), 
			new ImageIcon("images//left running frames//swordsman left run3.png").getImage(), 
			new ImageIcon("images//left running frames//swordsman left run4.png").getImage(), 
			new ImageIcon("images//left running frames//swordsman left run5.png").getImage(), 
			new ImageIcon("images//left running frames//swordsman left run6.png").getImage(), 
		};
	Image[] playerRunRight = 
		{
			new ImageIcon("images//right running frames//swordsman right run1.png").getImage(), 
			new ImageIcon("images//right running frames//swordsman right run2.png").getImage(), 
			new ImageIcon("images//right running frames//swordsman right run3.png").getImage(), 
			new ImageIcon("images//right running frames//swordsman right run4.png").getImage(), 
			new ImageIcon("images//right running frames//swordsman right run5.png").getImage(), 
			new ImageIcon("images//right running frames//swordsman right run6.png").getImage(), 	
		};
	Image[] playerSwing;	//has all frames for swing
	Image[] playerIdle = 
		{
			new ImageIcon("images//swordsman right.png").getImage(), 
			new ImageIcon("images//swordsman left.png").getImage()
		};
	Image[] playerJump = 
		{
			new ImageIcon("images//jump 2.png").getImage(),
			new ImageIcon("images//jump 2 left.png").getImage()
		};
			
	public Player() {
		
		//player = new ImageIcon(getClass().getClassLoader().getResource("up arrow.png")).getImage();
		player = playerIdle[0];
		xPos = 500;
		yPos = 500;
		direction = 1;
		
		runCounter = 0;
		velocityX = 0;
		velocityY = 0;
		accelX = 0;
		accelY = 0;
		keyPresses = new boolean[100];
		
		move = false;
		jump = false;
		swing = false;
		midAir = false;
	}
	
	public void updatePlayer() {
		
		if(!move && direction == 1) {
			player = playerIdle[0];
		} else if(!move && direction == 0) {
			player = playerIdle[1];
		}
				
		//horizontal movement
		if(keyPresses[64] || keyPresses[36]) {
			updateRunCounter();
			player = playerRunLeft[(int)runCounter];
			
			changeDirection("LEFT");
			velocityX = -1*Math.abs(velocityX);
			accelX = -2.5;
			move = true;
		} else if(keyPresses[38] || keyPresses[67]) {
			updateRunCounter();
			player = playerRunRight[(int)runCounter];
			
			changeDirection("RIGHT");
			velocityX = Math.abs(velocityX);
			accelX = 2.5;
			move = true;
		} else {
			accelX = 0;
			velocityX = 0;
			runCounter = 0;
			move = false;
		}
		if(Math.abs(velocityX) < 15) {
			velocityX += accelX;
		}
				
		//vertical movement
		if(keyPresses[31]) {
			jump = true;
		}
		
		//changing sprites
		if(midAir) {
			if(direction == 1) {
				player = playerJump[0];
			} else if(direction == 0) {
				player = playerJump[1];
			}
			move = true;
		}
		
		if(jump && !midAir) {
			velocityY = -15;
			accelY = 0.5;
			jump = false;
			midAir = true;
		} else if(yPos > 495) {
			jump = false;
			midAir = false;
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
	
	public void drawPlayer(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(player, xPos, yPos, 150, 150, null);
	}
	
	public void updateRunCounter() {
		if(runCounter < 5)
			runCounter += 0.2;
		else 
			runCounter = 0;
	}
}
