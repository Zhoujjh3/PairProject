import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;
import javax.swing.Timer;

public class RunGame {
	
	JFrame frame;
	JPanel chamber, welcomeScreen, gameOverScreen;
	Player samurai;
	Image background = new ImageIcon("images//background0.png").getImage();;
	ArrayList<Obstacle> obstacles = new ArrayList<Obstacle>();
	ArrayList<Projectile> projectiles = new ArrayList<Projectile>();
	
	public static ArrayList<Platform> platforms = new ArrayList<Platform>();
	public static double lightCounter;	
	boolean changeLight = false;
	
	public enum gameState{
		WELCOMESCREEN,
		PLAYGAME,
		GAMEOVER
	}
	public static gameState state;
	
	public RunGame() {
		state = gameState.WELCOMESCREEN;
		
		platforms.add(new Platform(0, 500, 250));
		System.out.println(platforms.size());

		samurai = new Player();
		Obstacle cannon1 = new Cannon(900, 200, new ImageIcon("images//cannon.png").getImage());
		obstacles.add(cannon1);
		Obstacle cannon2 = new Cannon(0, 200, new ImageIcon("images//cannon.png").getImage());
		obstacles.add(cannon2);
		Clicker theClicker = new Clicker(samurai);
		
		lightCounter = 0;		
		
		frame = new JFrame();
		welcomeScreen = new WelcomeScreen();
		welcomeScreen.setPreferredSize(new Dimension(1000, 750));
		chamber = new Chamber(samurai, background, obstacles, projectiles, platforms);
		chamber.setPreferredSize(new Dimension(1000, 750));
		
		frame.addMouseListener(theClicker);
		frame.addKeyListener(theClicker);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(chamber);
		frame.pack();
	    frame.setVisible(true);
	    frame.requestFocus();
	    timer.start();
	}
	
	public static int counter = 0;
	ActionListener run = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			//if(state == gameState.PLAYGAME) {
				if(counter % 1000000 == 0) {
					CannonBall cannonBall1 = new CannonBall(910, 245, samurai.getXPos(), samurai.getYPos());
					projectiles.add(cannonBall1);	
					CannonBall cannonBall2 = new CannonBall(90, 245, samurai.getXPos(), samurai.getYPos());
					projectiles.add(cannonBall2);
				} else if (counter % 100 == 0) {
					BuckShot buckShot1 = new BuckShot(910, 245, samurai.getXPos(), samurai.getYPos(), counter);
					projectiles.add(buckShot1);	
					BuckShot buckShot2 = new BuckShot(90, 245, samurai.getXPos(), samurai.getYPos(), counter);
					projectiles.add(buckShot2);
				}
				for(int i = 0; i < projectiles.size(); i++) {
					projectiles.get(i).updateProjectile();
					if(projectiles.get(i).getName() == "buckshot") {
						if(counter - projectiles.get(i).getCounterStart() == 100) {
							Projectile[] explodedPieces;
							explodedPieces = projectiles.get(i).explode(100);
							for(int a = 0; a < explodedPieces.length; a++) {
								projectiles.add(explodedPieces[a]);
							}

						}
					}
					if(projectiles.get(i).getX() > 1000 || projectiles.get(i).getY() > 750 ||
					projectiles.get(i).getX() < 0 || projectiles.get(i).getY() < 0) {
						projectiles.remove(i);
					}
				}
				
				if(counter % 70 == 0) {
					double rng = Math.random()*700;
					Platform plat = new Platform(0, rng);
					Platform plat2 = new Platform(0, 700-rng);
					
					if(Math.random()*100 % 2 == 0) {
						platforms.add(plat2);
					}
					platforms.add(plat);
				}
				
				for(int i = 0; i < platforms.size(); i++) {
					platforms.get(i).updatePlatform(2);
					platforms.get(i).getHitBox().checkCollision(samurai.getHitBox());
					if(platforms.get(i).relativeY > 750) {
						platforms.remove(i);
					}
				}
				
				samurai.updatePlayer();
				chamber.repaint();
				counter++;
				
				if(lightCounter < 253 && !changeLight) {
					lightCounter += 0.1;
				} else {
					changeLight = true;
					lightCounter -= 0.1;
				}
				if(lightCounter <= 10) {
					changeLight = false;
				}
			}
			
		//}
	};
	Timer timer = new Timer(20, run);
	
	public static void main(String[] args) {
		new RunGame();
	}
}


