import java.awt.*;

public abstract class Obstacle {

	int xPos, yPos;
	Image obstacle;
	
	Obstacle(int x, int y, Image visual) {
		xPos = x;
		yPos = y;
		obstacle = visual;
	}
	
	public int getXPos() {return xPos;}
	//
	public int getYPos() {return yPos;}
	
	public void drawObstacle(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(obstacle, xPos, yPos, 100, 100, null);
	}
	
}
