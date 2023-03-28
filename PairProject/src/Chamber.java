import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.JPanel;


public class Chamber extends JPanel{
	
	Player samurai;
	Image chamber;
	
	public Chamber(Player player, Image background) {
		samurai = player;
		chamber = background;
	}
	
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(chamber, 0, 0, 1000, 750, null);
		
		samurai.drawPlayer(g);
		g2.setColor(Color.black);
		g2.fillRect(0, 694, this.getWidth(), this.getHeight()-694);
	}
}
