import java.awt.Color;
import java.awt.Graphics;

public class hitbox {
	
	Coordinate[] hitbox;
	int xPos, yPos, height, width;
	
	public hitbox(int xPos, int yPos, int height, int width) {
		this.xPos = xPos;
		this.yPos = yPos;
		this.height = height;
		this.width = width;
		
		hitbox = new Coordinate[4];
		hitbox[0] = new Coordinate(xPos, yPos);					//top left
		hitbox[1] = new Coordinate(xPos+width, yPos);			//top right
		hitbox[2] = new Coordinate(xPos+width, yPos+height);	//bottom right
		hitbox[3] = new Coordinate(xPos, yPos+height);			//bottom left
	}
	
	public hitbox(Coordinate a, Coordinate b, Coordinate c, Coordinate d) {
		hitbox = new Coordinate[4];
		hitbox[0] = a;					
		hitbox[1] = b;			
		hitbox[2] = c;	
		hitbox[3] = d;	
		
		this.xPos = hitbox[0].getX();
		this.yPos = hitbox[0].getY();
		this.height = hitbox[2].getY() - hitbox[0].getY();
		this.width = hitbox[1].getX() - hitbox[0].getX();
	}
	
	public boolean checkCollision(hitbox otherObject) {
		if(checkXOverlap(otherObject) && checkYOverlap(otherObject)) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean checkXOverlap(hitbox otherObject) {
		boolean temp = false;
		if(getLeftX() <= otherObject.getLeftX() && getRightX() >= otherObject.getLeftX()) {
			//collide on the left
			temp = true;
		} else if(getLeftX() <= otherObject.getRightX() && getRightX() >= otherObject.getRightX()) {
			//collide on the right
			temp = true;
		} else if(getLeftX() >= otherObject.getLeftX() && getRightX() <= otherObject.getRightX()) {
			//within
			temp = true;
		}
		return temp;
	}
	
	public boolean checkYOverlap(hitbox otherObject) {
		boolean temp = false;
		if(getBottomY() >= otherObject.getTopY() && getBottomY() <= otherObject.getTopY()) {
			//top collision
			temp = true;
		} else if(getTopY() <= otherObject.getBottomY() && getTopY() >= otherObject.getTopY()){ 
			//bottom collision
			temp = true;
		}
		return temp;
	}
	
	public Coordinate getCoord(int index) {
		return hitbox[index];
	}
	
	public int getLeftX() {
		return xPos;
	}
	
	public int getRightX() {
		return xPos + width;
	}
	
	public int getTopY() {
		return yPos;
	}
	
	public int getBottomY() {
		return yPos + height;
	}
	
	public int getHeight() {
		return height;
	}
	
	public int getWidth() {
		return width;
	}
	
	public void drawHitBox(Graphics g) {
		g.setColor(Color.red);
		g.drawRect(xPos, yPos, width, height);
		//g.setColor(Color.blue);
		//g.drawLine(getLeftX(), getBottomY(), getRightX(), getBottomY());
	}
}
