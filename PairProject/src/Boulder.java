import javax.swing.ImageIcon;

public class Boulder extends Projectile {

	Boulder(double x, double y, double yVelocity) {
		super(x,y, 60, 60, new ImageIcon("images//boulder.png").getImage());
		setYVelocity(yVelocity);
		setName("boulder");
	}

	public Projectile[] explode(int numberOfPieces) {
		return new Projectile[0];
	}
}
