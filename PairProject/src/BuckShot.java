import java.awt.Color;

import javax.swing.ImageIcon;

public class BuckShot extends Projectile {

	private int counterStart;
	
	BuckShot(double x, double y, double playerX, double playerY, int counter) {
		super(x, y, 25, 25, new ImageIcon("images//buckshot.png").getImage());
		counterStart = counter;
		setName("buckshot");
		double playerXMiddle = playerX + 93;
		double playerYMiddle = playerY + 67;
		setColor(Color.red);
		double theta = Math.atan(Math.abs(playerYMiddle - y)/Math.abs(playerXMiddle - x));
		double xDirection;
		double yDirection;
		if((playerXMiddle - x) >= 0) {
			xDirection = 1.0;
		} else {
			xDirection = -1.0;
		}
		if((playerYMiddle - y) >= 0) {
			yDirection = 1.0;
		} else {
			yDirection = -1.0;
		}
		setXVelocity(4.0*Math.cos(theta) * (xDirection));
		setYVelocity(4.0*Math.sin(theta) * (yDirection));
	}
	
	public Projectile[] explode(int numberOfPieces) {
		
		Projectile[] cannonBalls = new CannonBall[numberOfPieces];
		
		for (int i = 0; i < cannonBalls.length; i++) {
			double theta = (double) ((i+1) * 2 * Math.PI) / (double) (cannonBalls.length);
			cannonBalls[i] = new CannonBall((int) getX(), (int) getY(), 2 * Math.sin(theta), 2 * Math.cos(theta));
		}
		
		return cannonBalls;
		
	}
	
	public int getCounterStart() {
		return counterStart;
	}
	
}
