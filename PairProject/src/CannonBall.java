import java.awt.Color;

import javax.swing.ImageIcon;

public class CannonBall extends Projectile {

	CannonBall(double x, double y, double xVelocity, double yVelocity) {
		super(x,y, 25, 25, new ImageIcon("images//cannonball.png").getImage());
		setXVelocity(xVelocity);
		setYVelocity(yVelocity);
		setName("cannonball");
	}
	
	public Projectile[] explode(int numberOfPieces) {
		return new Projectile[0];
	}
	
}
