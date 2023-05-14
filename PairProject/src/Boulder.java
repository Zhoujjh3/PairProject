
public class Boulder extends Projectile {

	Boulder(double x, double y, double yVelocity) {
		super(x,y);
		setYVelocity(yVelocity);
	}
	
	public Projectile[] explode(int numberOfPieces) {
		return new Projectile[0];
	}

	public double findFloor() {
		double temp = 1000;
		double max = 1000;
		for (Platform p : RunGame.platforms) {
			if (getHitBox().checkXOverlap(p.getHitBox()) && getHitBox().getBottomY() <= (p.getHitBox().getTopY() + 3)) {
				if (p.getHitBox().getTopY() < max) {
					temp = p.getHitBox().getTopY();
					max = temp;
				}
			}
		}
		return temp;
	}
	
}
