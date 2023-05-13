import java.awt.Color;

public class CannonBall extends Projectile {

	CannonBall(int x, int y, int playerXPos, int playerYPos) {
		super(x,y);
		int playerXMiddle = playerXPos + 93;
		int playerYMiddle = playerYPos + 67;
		setColor(Color.red);
		double theta = Math.atan((double) (Math.abs(playerYMiddle - y))/(double) (Math.abs(playerXMiddle - x)));
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
	}

	CannonBall(int x, int y, double xVelocity, double yVelocity) {
		super(x,y);
		setXVelocity(xVelocity);
		setYVelocity(yVelocity);
	}
	
	public Projectile[] explode(int numberOfPieces) {
		
		return new Projectile[0];
		
	}
	
}
