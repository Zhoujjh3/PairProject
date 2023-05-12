import java.awt.*;

import javax.swing.*;

public class WelcomeScreen extends JPanel{
	
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(new Color(200, 100, 100, 86));
		g2.fillRect(0, 0, this.getWidth(), this.getHeight());
	}
}
