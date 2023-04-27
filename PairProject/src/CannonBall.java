import java.awt.Color;

public class CannonBall extends Projectile {

	CannonBall(int x, int y, int playerXPos, int playerYPos) {
		super(x,y);
		setColor(Color.red);
		setXVelocity(((playerXPos + 93) - x)/100.0);
		setYVelocity(((playerYPos + 67) - y)/100.0);
	}

	
	
	
	
	
	
}
