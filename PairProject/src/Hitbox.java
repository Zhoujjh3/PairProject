import java.awt.Color;
import java.awt.Graphics;

public class Hitbox {
	
	Coordinate[] hitbox;
	double x, y, height, width;
	
	public Hitbox(double x, double y, double height, double width) {
		this.x = x;
		this.y = y;
		this.height = height;
		this.width = width;
		
		hitbox = new Coordinate[4];
		hitbox[0] = new Coordinate(x, y);					//top left
		hitbox[1] = new Coordinate(x+width, y);			//top right
		hitbox[2] = new Coordinate(x+width, y+height);	//bottom right
		hitbox[3] = new Coordinate(x, y+height);			//bottom left
	}
	
	public Hitbox(Coordinate a, Coordinate b, Coordinate c, Coordinate d) {
		hitbox = new Coordinate[4];
		hitbox[0] = a;					
		hitbox[1] = b;			
		hitbox[2] = c;	
		hitbox[3] = d;	
		
		this.x = hitbox[0].getX();
		this.y = hitbox[0].getY();
		this.height = hitbox[2].getY() - hitbox[0].getY();
		this.width = hitbox[1].getX() - hitbox[0].getX();
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
	
	public Coordinate getCoord(int index) {
		return hitbox[index];
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
		//g.setColor(Color.blue);
		//g.drawLine(getLeftX(), getBottomY(), getRightX(), getBottomY());
	}
}
