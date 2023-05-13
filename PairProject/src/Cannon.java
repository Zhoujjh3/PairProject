import java.awt.*;

public class Cannon extends Obstacle {

	
	Cannon(int x, int y, Image visual, int counterStart) {
		super(x, y, visual, counterStart);
		//setXVelocity(4.0);
		setYVelocity(1.0);
	}
	
}
