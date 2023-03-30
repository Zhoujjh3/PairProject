import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Clicker implements MouseListener, KeyListener {

	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		int code = e.getKeyCode();

		switch (code) {
		case 37:
		case 65:
			System.out.println(code);
			break;
		case 39:
		case 68:
			System.out.println(code);

			break;
		case 32:
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

	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("e");

	}

	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
