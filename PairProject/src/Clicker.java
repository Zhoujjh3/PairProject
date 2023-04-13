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
		//hello
		switch (code) {
		case 37:
		case 65:
			//run left
			player.setMove(true);
			player.changeBoolean(code, true);
//			player.setMove(true);
//			player.changeDirection("LEFT");
//			player.state = Player.States.MOVING;
			System.out.println(code);
			break;
		case 39:
		case 68:
			//run right
			player.setMove(true);
			player.changeBoolean(code, true);
//			player.setMove(true);
//			player.changeDirection("RIGHT");
//			player.state = Player.States.MOVING;
			System.out.println(code);
			break;
		case 32:	//jump
			player.changeBoolean(code, true);
//			player.toggleJump();
//			player.state = Player.States.MOVING;
			System.out.println(code);
			break;
		case 38:
		case 87:
			System.out.println(code);

			break;
		case 40:
		case 83:
			System.out.println(code);

			break;
		case 77:
			System.out.println(code);

			break;
		}
	}

	public void keyReleased(KeyEvent e) {
		//player.setMove(false);
		player.changeBoolean(e.getKeyCode(), false);
		System.out.println("released " + e.getKeyCode());
//		if(!player.jump) {
//			player.state = Player.States.IDLE;
//		}
		
		//System.out.println("IDLE");
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

}
