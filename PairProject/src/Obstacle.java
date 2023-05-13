import java.awt.*;

public abstract class Obstacle {

	private double x, y, xVelocity, yVelocity;
	private Image obstacle;
	private String name;
	private int counterStart;

	Obstacle(int x, int y, Image visual, int counterStart) {
		this.x = x;
		this.y = y;
		obstacle = visual;
		this.counterStart = counterStart;
	}
	
	public double getX() {return x;}
	//
	public double getY() {return y;}
	
	public void setXVelocity(double speed) {
		xVelocity = speed;
	}
	
	public void setYVelocity(double speed) {
		yVelocity = speed;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public int getCounterStart() {
		return counterStart;
	}
	
	public void updateObstacle() {
		x += xVelocity;
		y += yVelocity;
	}
	
	public void drawObstacle(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(obstacle, (int) Math.rint(x), (int) Math.rint(y), 100, 100, null);
	}
	
}
