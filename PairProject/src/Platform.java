import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Platform {
	double X, relativeY;	//y coordinates 
	double absoluteY;		//the height
	Image floatingPlatform = new ImageIcon("images//floating platform.png").getImage(); 
	
	public Platform(double absoluteY, double X) {
		this.X = X;
		this.absoluteY = absoluteY;
		relativeY = 0;
	}
	
	public void updatePlatform(double fallRate) {
		relativeY += fallRate;
	}
	
	public void drawPlatform(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(floatingPlatform, (int) X, (int) relativeY, 200, 65, null);	
	}
	
	public double getXLeft() {
		return X;
	} 
	
	public double getXRight() {
		return X + 200;
	}
	
	public double getRelativeY() {
		return relativeY;
	}

}
