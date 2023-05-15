import java.awt.*;

public abstract class Projectile {

	
	private double x, y, height, width, xVelocity, yVelocity;
	private Color theColor;
	private String name;
	private int counterStart;
	private Hitbox hitbox;
	private Image image;
	
	Projectile(double x, double y, double height, double width, Image visual) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		image = visual;
		hitbox = new Hitbox(x, y, height, width);
	}
	
	public void drawProjectile(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(theColor);
		g2.drawImage(image, (int) Math.rint(x), (int) Math.rint(y), 
		(int) Math.rint(height), (int) Math.rint(width), null);
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
		hitbox = new Hitbox(x, y, height, width);
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
