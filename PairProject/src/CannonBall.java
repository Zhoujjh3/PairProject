import java.awt.Color;

public class CannonBall extends Projectile {

	CannonBall(int x, int y, int playerXPos, int playerYPos) {
		super(x,y);
		setColor(Color.red);
		
		setXVelocity(Math.atan((playerXPos + 93)/(playerYPos + 67))); //((playerXPos + 93) - x)/100.0);
		setYVelocity(Math.atan((playerXPos + 93)/(playerYPos + 67)));
		//setXVelocity(((playerXPos + 93) - x)/100.0);
		//setYVelocity(((playerYPos + 67) - y)/100.0);
	}

	
	
	
	
	
	
}
