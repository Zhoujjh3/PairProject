import java.awt.Color;

public class BuckShot extends CannonBall {

	private int counterStart;
	
	BuckShot(int x, int y, int playerXPos, int playerYPos, int counter) {
		super(x, y, playerXPos, playerYPos);
		counterStart = counter;
		setName("buckshot");
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
