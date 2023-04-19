import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class Clicker implements MouseListener, KeyListener {
	
	Player player;
	
	public Clicker(Player player) {
		this.player = player;
		System.out.println("ugh");
	}
	public void keyTyped(KeyEvent e) {
	}
	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();
		player.changeBoolean(code, true);
	}

	public void keyReleased(KeyEvent e) {
		int code = e.getKeyCode();
		player.changeBoolean(code, false);
	}

	public void mouseClicked(MouseEvent e) {
		//System.out.println("e");

	}
	
	public void mousePressed(MouseEvent e) {
	}
	public void mouseReleased(MouseEvent e) {
	}
	public void mouseEntered(MouseEvent e) {
	}
	public void mouseExited(MouseEvent e) {
	}

	//end
}
