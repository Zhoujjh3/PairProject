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
	Image playerTorso;
	Image playerLegs;
	
	public enum States{
		IDLE, MOVING;
	}
	States state = States.MOVING;
	
	Image[] playerRunLeftTorso = 
		{
			new ImageIcon("images//left running frames//l-torso1.png").getImage(), 
			new ImageIcon("images//left running frames//l-torso2.png").getImage(), 
			new ImageIcon("images//left running frames//l-torso3.png").getImage(), 
			new ImageIcon("images//left running frames//l-torso4.png").getImage(), 
			new ImageIcon("images//left running frames//l-torso5.png").getImage(), 
			new ImageIcon("images//left running frames//l-torso6.png").getImage()			
		};
	Image[] playerRunLeftLegs = 
		{
			new ImageIcon("images//left running frames//l-legs1.png").getImage(), 
			new ImageIcon("images//left running frames//l-legs2.png").getImage(), 
			new ImageIcon("images//left running frames//l-legs3.png").getImage(), 
			new ImageIcon("images//left running frames//l-legs4.png").getImage(), 
			new ImageIcon("images//left running frames//l-legs5.png").getImage(), 
			new ImageIcon("images//left running frames//l-legs6.png").getImage()			
		};
	Image[] playerRunRightTorso = 
		{
			new ImageIcon("images//right running frames//r-torso1.png").getImage(), 
			new ImageIcon("images//right running frames//r-torso2.png").getImage(), 
			new ImageIcon("images//right running frames//r-torso3.png").getImage(), 
			new ImageIcon("images//right running frames//r-torso4.png").getImage(), 
			new ImageIcon("images//right running frames//r-torso5.png").getImage(), 
			new ImageIcon("images//right running frames//r-torso6.png").getImage(), 
		};
	Image[] playerRunRightLegs = 
		{
			new ImageIcon("images//right running frames//r-legs1.png").getImage(), 
			new ImageIcon("images//right running frames//r-legs2.png").getImage(), 
			new ImageIcon("images//right running frames//r-legs3.png").getImage(), 
			new ImageIcon("images//right running frames//r-legs4.png").getImage(), 
			new ImageIcon("images//right running frames//r-legs5.png").getImage(), 
			new ImageIcon("images//right running frames//r-legs6.png").getImage(), 
		};
	Image[] playerSwingLeft = 
		{
			new ImageIcon("images//swing//leftswing1.png").getImage(),
			new ImageIcon("images//swing//leftswing2.png").getImage(),
			new ImageIcon("images//swing//leftswing3.png").getImage(),
			new ImageIcon("images//swing//leftswing4.png").getImage(),
		};	
	Image[] playerSwingRight = 
		{
			new ImageIcon("images//swing//rightswing1.png").getImage(),
			new ImageIcon("images//swing//rightswing2.png").getImage(),
			new ImageIcon("images//swing//rightswing3.png").getImage(),
			new ImageIcon("images//swing//rightswing4.png").getImage(),
		};	
	Image[] playerIdleLegs = 
		{
			new ImageIcon("images//legs right.png").getImage(), 
			new ImageIcon("images//legs left.png").getImage()
		};
	Image[] playerIdleTorso = 
		{
			new ImageIcon("images//torso right.png").getImage(), 
			new ImageIcon("images//torso left.png").getImage()
		};
	Image[] playerJump = 
		{
			new ImageIcon("images//jump//jump legs right.png").getImage(),
			new ImageIcon("images//jump//jump legs left.png").getImage()
		};
			
	public Player() {
		
		//player = new ImageIcon(getClass().getClassLoader().getResource("up arrow.png")).getImage();
		playerTorso = playerIdleTorso[0];
		playerLegs = playerIdleLegs[0];
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
			playerTorso = playerIdleTorso[0];
			playerLegs = playerIdleLegs[0];
		} else if(!move && direction == 0) {
			playerTorso = playerIdleTorso[1];
			playerLegs = playerIdleLegs[1];
		}
				
		//horizontal movement
		if(keyPresses[64] || keyPresses[36]) {
			updateRunCounter();
			playerTorso = playerRunLeftTorso[(int)runCounter];
			playerLegs = playerRunLeftLegs[(int)runCounter];
			
			changeDirection("LEFT");
			velocityX = -1*Math.abs(velocityX);
			accelX = -2.5;
			move = true;
		} else if(keyPresses[38] || keyPresses[67]) {
			updateRunCounter();
			playerTorso = playerRunRightTorso[(int)runCounter];
			playerLegs = playerRunRightLegs[(int)runCounter];
			
			
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
		
		//changing jumping sprites
		if(midAir) {
			if(direction == 1) {
				playerTorso = playerIdleTorso[0];
				playerLegs = playerJump[0];
			} else if(direction == 0) {
				playerTorso = playerIdleTorso[1];
				playerLegs = playerJump[1];
			}
			move = true;
		}
		
		if(swing) {
			
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
		g2.drawImage(playerTorso, xPos, yPos, 186, 134, null);
		g2.drawImage(playerLegs, xPos, yPos, 186, 134, null);
		
	}
	
	public void updateRunCounter() {
		if(runCounter < 5)
			runCounter += 0.2;
		else 
			runCounter = 0;
	}
	
	public void updateSwingCounter() {
		if(swingCounter < 4) {
			swingCounter += 0.5;
		} else {
			swingCounter = 0;
			swing = false;
		}
	}
}
