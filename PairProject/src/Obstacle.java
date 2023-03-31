import java.awt.*;

public abstract class Obstacle {

	int xPos, yPos;
	Image obstacle;
	
	public int getXPos() {return xPos;}
	
	public int getYPos() {return yPos;}
	
	public void drawObstacle(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(obstacle, xPos, yPos, 200, 200, null);
	}
	
}
