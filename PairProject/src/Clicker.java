import java.awt.Color;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;


public class Clicker implements MouseListener, KeyListener {
	
	Player player;
	Chamber chamber;
	ArrayList<Obstacle> theOPPS;
	ArrayList<Projectile> thePROJ;
	ArrayList<Platform> thePLAT;
	Image background;
	Color backgroundColor;
	
	public Clicker(Player player, Chamber chamber) {
		this.player = player;
		this.chamber = chamber;
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
			
		} else if(RunGame.state == RunGame.gameState.GAMEOVER){
			if(e.getX() >= 397 && e.getX() <= 640) {
				if(e.getY() >= 630 && e.getY() <= 720) {
					player.reset();
					chamber.reset();
					RunGame.counter = 0;
					RunGame.screenCounter = 0;
					RunGame.state = RunGame.gameState.WELCOMESCREEN;

				}
			}
		}
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
