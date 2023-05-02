import java.awt.Color;

public class CannonBall extends Projectile {

	CannonBall(int x, int y, int playerXPos, int playerYPos) {
		super(x,y);
		int playerXMiddle = playerXPos + 93;
		int playerYMiddle = playerYPos + 67;
		setColor(Color.red);
		double theta = Math.atan((double) (Math.abs(playerXMiddle - x))/(double) (Math.abs(playerYMiddle - y)));
		double direction;
		if((playerXMiddle - x) >= 0) {
			direction = 1.0;
		} else {
			direction = -1.0;
		}
		setXVelocity(4.0*Math.sin(theta) * (direction));
		setYVelocity(4.0*Math.cos(theta));
		//setXVelocity(((playerXPos + 93) - x)/100.0);
		//setYVelocity(((playerYPos + 67) - y)/100.0);
	}

	
	
	
	
	
	
}
