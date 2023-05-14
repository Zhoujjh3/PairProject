import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public abstract class Projectile {

	
	private double x, y, xVelocity, yVelocity;
	private Color theColor;
	private String name;
	private int counterStart;
	private Hitbox hitbox;
	
	Projectile(double x, double y) {
		this.x = x;
		this.y = y;
		hitbox = new Hitbox(x, y, 10, 10);
	}
	
	public void drawProjectile(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(theColor);
		g2.fillOval((int) Math.rint(x), (int) Math.rint(y), 10, 10);
		hitbox.drawHitBox(g2);
	}
	
	public void setColor(Color theColor) {
		this.theColor = theColor;
	}
	
	public Hitbox getHitBox() {
		return hitbox;
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
		hitbox = new Hitbox(x, y, 10, 10);
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
