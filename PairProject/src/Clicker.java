import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class Clicker implements MouseListener, KeyListener {
	
	Player player;
	
	public Clicker(Player player) {
		this.player = player;
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
		if(RunGame.state == RunGame.gameState.WELCOMESCREEN) {
			if(e.getX() >= 420 && e.getX() <= 575) {
				if(e.getY() >= 595 && e.getY() <= 660) {
					RunGame.state = RunGame.gameState.PLAYGAME;
				}
			}
		} else if(RunGame.state == RunGame.gameState.PLAYGAME) {
			player.changeSwing(true);
		} else {
			
		}
		
		System.out.println(RunGame.state);
		System.out.println("x: " + e.getX() + ", y: " + e.getY());
	}
	
	public void mousePressed(MouseEvent e) {
	}
	public void mouseReleased(MouseEvent e) {
	}
	public void mouseEntered(MouseEvent e) {
	}
	public void mouseExited(MouseEvent e) {
	}
}
