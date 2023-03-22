
import java.awt.*;
import java.util.*;
import javax.swing.*;

public class RunGame {
	
	JFrame frame;
	JPanel chamber;
	
	public RunGame() {
		frame = new JFrame();
		chamber = new Chamber();
		chamber.setPreferredSize(new Dimension(1000, 750));
		chamber.addMouseListener(new Clicker());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(chamber);
		frame.pack();
	    frame.setVisible(true);
	}

	public static void main(String[] args) {
		System.out.println("max");
		new RunGame();
	}
	

}
