import java.awt.Color;

import javax.swing.ImageIcon;

public class CannonBall extends Projectile {

	/*CannonBall(double x, double y, double playerX, double playerY, String playerBased) {
		super(x,y, 25, 25, new ImageIcon("images//cannonball.png").getImage());
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
		setName("cannonball");
	}*/

	CannonBall(double x, double y, double xVelocity, double yVelocity) {
		super(x,y, 25, 25, new ImageIcon("images//cannonball.png").getImage());
		setXVelocity(xVelocity);
		setYVelocity(yVelocity);
	}
	
	public Projectile[] explode(int numberOfPieces) {
		
		return new Projectile[0];
		
	}
	
}
