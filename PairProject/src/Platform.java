import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Platform {
	double X, relativeY;	//y coordinates 
	double absoluteY;		//the height
	Image floatingPlatform = new ImageIcon("images//floating platform.png").getImage(); 
	Hitbox platformHitBox;
	
	public Platform(double absoluteY, double X) {
		this.X = X;
		this.absoluteY = absoluteY;
		relativeY = 0;
		platformHitBox = new Hitbox((int) X, (int) relativeY, 45, 150);
	}
	
	public Platform(double absoluteY, double X, double relativeY) {
		this.X = X;
		this.absoluteY = absoluteY;
		this.relativeY = relativeY;
		platformHitBox = new Hitbox((int) X, (int) relativeY, 45, 150);
	}
	
	public void updatePlatform(double fallRate) {
		relativeY += fallRate;
		platformHitBox = new Hitbox((int) X, (int) relativeY, 45, 150);
	}
	
	public void drawPlatform(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(floatingPlatform, (int) X, (int) relativeY, 150, 45, null);	
		
		platformHitBox.drawHitBox(g2);
//		g2.drawLine((int) getXLeft(), 0, (int) getXLeft(), 1000);
//		g2.drawLine((int) getXRight(), 0, (int) getXRight(), 1000);
	}
	
	public double getXLeft() {
		return platformHitBox.getLeftX();
	} 
	
	public double getXRight() {
		return platformHitBox.getRightX();
	}
	
	public double getRelativeY() {
		return relativeY;
	}
	
	public Hitbox getHitBox() {
		return platformHitBox;
	}

}
