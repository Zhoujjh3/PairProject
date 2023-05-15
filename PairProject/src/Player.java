import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.*;
import javax.swing.ImageIcon;

public class Player {

	private double runCounter, swingCounter;
	private double XVelocity, YVelocity, accelX, accelY;
	private double x, y, direction, floor;
	private boolean move, jump, swing, midAir, landed;
	private boolean[] keyPresses;
	private Hitbox hitbox, swordHitbox1, swordHitbox2;
	private Image playerTorso;
	private Image playerLegs;
	private int health;
	
	public enum States {
		IDLE, MOVING;
	}

	States state = States.MOVING;

	Image[] playerRunLeftTorso = { new ImageIcon("images//left running frames//l-torso1.png").getImage(),
			new ImageIcon("images//left running frames//l-torso2.png").getImage(),
			new ImageIcon("images//left running frames//l-torso3.png").getImage(),
			new ImageIcon("images//left running frames//l-torso4.png").getImage(),
			new ImageIcon("images//left running frames//l-torso5.png").getImage(),
			new ImageIcon("images//left running frames//l-torso6.png").getImage() };
	Image[] playerRunLeftLegs = { new ImageIcon("images//left running frames//l-legs1.png").getImage(),
			new ImageIcon("images//left running frames//l-legs2.png").getImage(),
			new ImageIcon("images//left running frames//l-legs3.png").getImage(),
			new ImageIcon("images//left running frames//l-legs4.png").getImage(),
			new ImageIcon("images//left running frames//l-legs5.png").getImage(),
			new ImageIcon("images//left running frames//l-legs6.png").getImage() };
	Image[] playerRunRightTorso = { new ImageIcon("images//right running frames//r-torso1.png").getImage(),
			new ImageIcon("images//right running frames//r-torso2.png").getImage(),
			new ImageIcon("images//right running frames//r-torso3.png").getImage(),
			new ImageIcon("images//right running frames//r-torso4.png").getImage(),
			new ImageIcon("images//right running frames//r-torso5.png").getImage(),
			new ImageIcon("images//right running frames//r-torso6.png").getImage(), };
	Image[] playerRunRightLegs = { new ImageIcon("images//right running frames//r-legs1.png").getImage(),
			new ImageIcon("images//right running frames//r-legs2.png").getImage(),
			new ImageIcon("images//right running frames//r-legs3.png").getImage(),
			new ImageIcon("images//right running frames//r-legs4.png").getImage(),
			new ImageIcon("images//right running frames//r-legs5.png").getImage(),
			new ImageIcon("images//right running frames//r-legs6.png").getImage(), };
	Image[] playerSwingLeft = { new ImageIcon("images//swing//leftswing1.png").getImage(),
			new ImageIcon("images//swing//leftswing2.png").getImage(),
			new ImageIcon("images//swing//leftswing3.png").getImage(),
			new ImageIcon("images//swing//leftswing4.png").getImage(), };
	Image[] playerSwingRight = { new ImageIcon("images//swing//rightswing1.png").getImage(),
			new ImageIcon("images//swing//rightswing2.png").getImage(),
			new ImageIcon("images//swing//rightswing3.png").getImage(),
			new ImageIcon("images//swing//rightswing4.png").getImage(), };
	Image[] playerIdleLegs = { new ImageIcon("images//legs right.png").getImage(),
			new ImageIcon("images//legs left.png").getImage() };
	Image[] playerIdleTorso = { new ImageIcon("images//torso right.png").getImage(),
			new ImageIcon("images//torso left.png").getImage() };
	Image[] playerJump = { new ImageIcon("images//jump//jump legs right.png").getImage(),
			new ImageIcon("images//jump//jump legs left.png").getImage() };

	public Player() {
		// player = new ImageIcon(getClass().getClassLoader().getResource("up
		// arrow.png")).getImage();
		playerTorso = playerIdleTorso[0];
		playerLegs = playerIdleLegs[0];
		x = 500;
		y = 100;
		direction = 1;
		floor = 0;
		hitbox = new Hitbox(x + 40, y + 20, 114, 74);

		runCounter = 0;
		XVelocity = 0;
		YVelocity = 0;
		accelX = 0;
		accelY = 0;
		keyPresses = new boolean[100];

		move = false;
		jump = false;
		swing = false;
		midAir = false;
		landed = true;
		health = 100;
	}

	public void updatePlayer() {

		if (!move && direction == 1) {
			playerTorso = playerIdleTorso[0];
			playerLegs = playerIdleLegs[0];
		} else if (!move && direction == 0) {
			playerTorso = playerIdleTorso[1];
			playerLegs = playerIdleLegs[1];
		}

		// horizontal movement
		if (keyPresses[64] || keyPresses[36]) {
			updateRunCounter();
			playerTorso = playerRunLeftTorso[(int) runCounter];
			playerLegs = playerRunLeftLegs[(int) runCounter];

			changeDirection("LEFT");
			XVelocity = -1 * Math.abs(XVelocity);
			accelX = -2.5;
			move = true;
		} else if (keyPresses[38] || keyPresses[67]) {
			updateRunCounter();
			playerTorso = playerRunRightTorso[(int) runCounter];
			playerLegs = playerRunRightLegs[(int) runCounter];

			changeDirection("RIGHT");
			XVelocity = Math.abs(XVelocity);
			accelX = 2.5;
			move = true;
		} else {
			accelX = 0;
			XVelocity = 0;
			runCounter = 0;
			move = false;
		}
		if (Math.abs(XVelocity) < 15) {
			XVelocity += accelX;
		}

		// vertical movement
		if (keyPresses[31] || keyPresses[86]) {
			jump = true;
		}

		// changing jumping sprites
		if (midAir) {
			if (direction == 1) {
				playerTorso = playerIdleTorso[0];
				playerLegs = playerJump[0];
			} else if (direction == 0) {
				playerTorso = playerIdleTorso[1];
				playerLegs = playerJump[1];
			}
			move = true;
		}

		if (swing) {
			if (direction == 0) {
				swordHitbox1 = new Hitbox(x + 75, y, 20, 74);
				swordHitbox2 = new Hitbox(x, y, 125, 75);
			} else if (direction == 1) {
				swordHitbox1 = new Hitbox(x + 40, y, 20, 74);
				swordHitbox2 = new Hitbox(x + 114, y, 125, 70);
			}
			updateSwingCounter();
			if (direction == 1) {
				playerTorso = playerSwingRight[(int) swingCounter];
			} else if (direction == 0) {
				playerTorso = playerSwingLeft[(int) swingCounter];
			}
		}

		floor = (int) findFloor();

		YVelocity += accelY;
		x += XVelocity;
		y += YVelocity;

		if (jump && !midAir) {
			YVelocity = -15;
			accelY = 0.5;
			jump = false;
			midAir = true;
			landed = false;
		} else if (y + 134 <= floor) {
			// midAir = true;
			accelY = 0.5;
		} else if (y + 134 >= floor && !landed) {
			jump = false;
			midAir = false;
			YVelocity = 0;
			accelY = 0;
			landed = true;
			y = floor - 131;
		} else if (landed) {
			YVelocity = 0;
			accelY = 0;
			y = floor - 131;
		}
		
		if(y > 750 || health <= 0) {
			RunGame.state = RunGame.gameState.GAMEOVER; 
		}

		if (direction == 0) {
			hitbox = new Hitbox(x + 75, y + 20, 114, 74);
		} else if (direction == 1) {
			hitbox = new Hitbox(x + 40, y + 20, 114, 74);
		}
	}

	public void changeDirection(String dir) {
		if (dir.equals("LEFT")) {
			direction = 0;
		} else if (dir.equals("RIGHT")) {
			direction = 1;
		} else {
			direction = 2;
		}
	}

	public void drawPlayer(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(playerTorso, (int) Math.rint(x), (int) Math.rint(y), 186, 134, null);
		g2.drawImage(playerLegs, (int) Math.rint(x), (int) Math.rint(y), 186, 134, null);
		hitbox.drawHitBox(g2);
		if (swordHitbox1 != null) {
			swordHitbox1.drawHitBox(g2);
		}
		if (swordHitbox2 != null) {
			swordHitbox2.drawHitBox(g2);
		}
		if (direction == 0) {
			g2.setColor(Color.RED);
			g2.fillRect((int) Math.rint(x+55), (int) Math.rint(y+140), 104, 16);
			g2.setColor(Color.GREEN);
			g2.fillRect((int) Math.rint(x+58), (int) Math.rint(y+143), (int) (98*((double) health / 100.0)), 10);
		} else if (direction == 1) {
			g2.setColor(Color.RED);
			g2.fillRect((int) Math.rint(x+20), (int) Math.rint(y+140), 104, 16);
			g2.setColor(Color.GREEN);
			g2.fillRect((int) Math.rint(x+23), (int) Math.rint(y+143), (int) (98*((double) health / 100.0)), 10);

		}
		
	}

	public void updateRunCounter() {
		if (runCounter < 5)
			runCounter += 0.2;
		else
			runCounter = 0;
	}

	public void updateSwingCounter() {
		if (swingCounter < 3) {
			swingCounter += 0.5;
		} else {
			swingCounter = 0;
			swing = false;
			swordHitbox1 = null;
			swordHitbox2 = null;
		}
	}

	public double findFloor() {
		double temp = 1000;
		double max = 1000;
		for (Platform p : RunGame.platforms) {
			if (hitbox.checkXOverlap(p.getHitBox()) && hitbox.getBottomY() <= (p.getHitBox().getTopY() + 3)) {
				if (p.getHitBox().getTopY() < max) {
					temp = p.getHitBox().getTopY();
					max = temp;
				}
			}
		}
		return temp;
	}

	public void reset() {
		playerTorso = playerIdleTorso[0];
		playerLegs = playerIdleLegs[0];
		x = 500;
		y = 100;
		direction = 1;
		floor = 0;
		hitbox = new Hitbox(x + 40, y + 20, 114, 74);

		runCounter = 0;
		XVelocity = 0;
		YVelocity = 0;
		accelX = 0;
		accelY = 0;
		keyPresses = new boolean[100];

		move = false;
		jump = false;
		swing = false;
		midAir = false;
		landed = true;
	}

	
	public Hitbox getHitBox() {
		return hitbox;
	}

	public Hitbox getSwordHitBox1() {
		return swordHitbox1;
	}

	public Hitbox getSwordHitBox2() {
		return swordHitbox2;
	}

	public void changeBoolean(int keyValue, boolean newValue) {
		keyPresses[keyValue - 1] = newValue;
	}

	public void changeSwing(boolean swing) {
		this.swing = swing;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public void setHealth(int health) {
		this.health = health;
	}
	
	public int getHealth() {
		return health;
	}
	
	public void setYVelocity(double YVelocity) {
		this.YVelocity = YVelocity;
	}

	public void setXVelocity(double XVelocity) {
		this.XVelocity = XVelocity;
	}

	public void changeState(States state) {
		this.state = state;
	}

}