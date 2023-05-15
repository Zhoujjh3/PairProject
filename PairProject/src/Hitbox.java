import java.awt.Color;
import java.awt.Graphics;

public class Hitbox {
	
	double x, y, height, width;
	
	public Hitbox(double x, double y, double height, double width) {
		this.x = x;
		this.y = y;
		this.height = height;
		this.width = width;
	}
	
	public boolean checkCollision(Hitbox otherObject) {
		if(checkXOverlap(otherObject) && checkYOverlap(otherObject)) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean checkXOverlap(Hitbox otherObject) {
		boolean temp = false;
		if(getLeftX() <= otherObject.getLeftX() && getRightX() >= otherObject.getLeftX()) {
			//collide on the left
			temp = true;
		} else if(getLeftX() <= otherObject.getRightX() && getRightX() >= otherObject.getRightX()) {
			//collide on the right
			temp = true;
		} else if(getRightX() >= otherObject.getLeftX() && getLeftX() <= otherObject.getLeftX()) {
			//collide on the right
			temp = true;
		} else if(getLeftX() >= otherObject.getLeftX() && getRightX() <= otherObject.getRightX()) {
			//within
			temp = true;
		} 
		return temp;
	}
	
	public boolean checkYOverlap(Hitbox otherObject) {
		boolean temp = false;
		if(getTopY() <= otherObject.getTopY() && getBottomY() >= otherObject.getBottomY()) {
			//collide on the left
			temp = true;
		} else if(getTopY() <= otherObject.getBottomY() && getBottomY() >= otherObject.getBottomY()) {
			//collide on the right
			temp = true;
		} else if(getBottomY() >= otherObject.getTopY() && getTopY() <= otherObject.getTopY()) {
			//collide on the right
			temp = true;
		} else if(getTopY() >= otherObject.getTopY() && getBottomY() <= otherObject.getBottomY()) {
			//within
			temp = true;
		}
		return temp;
	}
	
	public double getLeftX() {
		return x;
	}
	
	public double getRightX() {
		return x + width;
	}
	
	public double getTopY() {
		return y;
	}
	
	public double getBottomY() {
		return y + height;
	}
	
	public double getHeight() {
		return height;
	}

	public double getWidth() {
		return width;
	}
	
	public void drawHitBox(Graphics g) {
		g.setColor(Color.red);
		g.drawRect((int) Math.rint(x), (int) Math.rint(y), 
		(int) Math.rint(width), (int) Math.rint(height));
	}
}
