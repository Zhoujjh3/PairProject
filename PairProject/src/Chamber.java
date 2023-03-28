import java.awt.*;
import java.util.*;
import javax.swing.*;


public class Chamber extends JPanel{
	
	Player samurai;
	Image chamber;
	ArrayList<Obstacle> theOPPS;
	
	public Chamber(Player player, Image background, ArrayList<Obstacle> obstacles) {
		samurai = player;
		chamber = background;
		theOPPS = obstacles;
	}
	
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(chamber, 0, 0, 1000, 750, null);
		
		samurai.drawPlayer(g);
		g2.setColor(Color.black);
		g2.fillRect(0, 694, this.getWidth(), this.getHeight()-694);
	}
}
