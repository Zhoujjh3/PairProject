import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public abstract class Projectile {

	
	private double x, y, xVelocity, yVelocity;
	private Color theColor;
	private String name;
	private int counterStart;
	
	Projectile(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void drawProjectile(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(theColor);
		g2.fillOval((int) Math.rint(x), (int) Math.rint(y), 10, 10);
	}
	
	public void setColor(Color theColor) {
		this.theColor = theColor;
	}
	
	public void setXVelocity(double speed) {
		xVelocity = speed;
	}
	
	public void setYVelocity(double speed) {
		yVelocity = speed;
	}
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
	
	public void updateProjectile() {
		x += xVelocity;
		y += yVelocity;
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
	
	public abstract Projectile[] explode(int numberOfPieces);
}
