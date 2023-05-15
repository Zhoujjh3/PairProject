import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;
import javax.swing.Timer;

public class RunGame {
	//for max 

	private JFrame frame;
	private Chamber chamber;
	private Player samurai;
	private Image background = new ImageIcon("images//background0.png").getImage();;
	ArrayList<Obstacle> obstacles = new ArrayList<Obstacle>();
	ArrayList<Projectile> projectiles = new ArrayList<Projectile>();

	public static ArrayList<Platform> platforms = new ArrayList<Platform>();
	public static double lightCounter;
	public static boolean tutorial = true;
	boolean changeLight = true;

	public enum gameState {
		WELCOMESCREEN, TUTORIAL, PLAYGAME, GAMEOVER
	}
	public static gameState state;

	public RunGame() {
		state = gameState.WELCOMESCREEN;

		platforms.add(new Platform(0, 500, 250));
		
		samurai = new Player();
		frame = new JFrame();
		chamber = new Chamber(samurai, background, obstacles, projectiles, platforms);
		chamber.setPreferredSize(new Dimension(1000, 750));
		Clicker theClicker = new Clicker(samurai, chamber);

		lightCounter = 0;
		frame.addMouseListener(theClicker);
		frame.addKeyListener(theClicker);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(chamber);
		frame.pack();
		frame.setVisible(true);
		frame.requestFocus();
		timer.start();

	}

	public static double screenCounter = 0;
	public static int counter = 0;
	ActionListener run = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			if(state == gameState.WELCOMESCREEN) {
				if(screenCounter < 5)
					screenCounter += 0.3;
				chamber.repaint();
				
			} else if(state == gameState.TUTORIAL){
				tutorial = false;
				if(screenCounter < 6.5)
					screenCounter += 0.03;
				chamber.repaint();
				if(screenCounter >= 6.5) {
					state = gameState.PLAYGAME;
				}
				
			} else if(state == gameState.PLAYGAME) {
				frame.setContentPane(chamber);
				if (counter % 70 == 0) {
					double rng = (Math.random() * 650) + 100;
					Platform plat = new Platform(0, rng);
					Platform plat2 = new Platform(0, 850 - rng);
	
					if (Math.random() * 100 % 2 == 0) {
						platforms.add(plat2);
					}
					platforms.add(plat);
					samurai.setScore(samurai.getScore() + 1 + 2*(counter/500));
				}
	
				for (int i = 0; i < platforms.size(); i++) {
					platforms.get(i).updatePlatform(2);
					if (platforms.get(i).relativeY > 750) {
						platforms.remove(i);
					}
				}
	
				if (counter % (1000 - (50 * (counter/500))) == 0) {
					Obstacle cannon1 = new Cannon(900, -100, new ImageIcon("images//rightsidecannon.png").getImage(), counter);
					obstacles.add(cannon1);
					Obstacle cannon2 = new Cannon(0, -100, new ImageIcon("images//leftsidecannon.png").getImage(), counter);
					obstacles.add(cannon2);
				}
				
				if(counter != 0 && counter % (500 - (10 * (counter/100))) == 0) {
					Boulder boulder1 = new Boulder((int) ((Math.random() * 740) + 100), 0, 
					(int) ((double) counter / 1000.0) + 3);
					projectiles.add(boulder1);
				}
	
				for (int i = 0; i < obstacles.size(); i++) {
					boolean removed = false;
					obstacles.get(i).updateObstacle();
					if ((counter - obstacles.get(i).getCounterStart()) % 100 == 0) {
						if (obstacles.get(i).getX() < 500) {
							BuckShot buckShot1 = new BuckShot((int) Math.rint(obstacles.get(i).getX() + 90),
									(int) Math.rint(obstacles.get(i).getY() + 50), samurai.getX(), samurai.getY(), counter);
							projectiles.add(buckShot1);
						} else {
							BuckShot buckShot1 = new BuckShot((int) Math.rint(obstacles.get(i).getX() + 10),
									(int) Math.rint(obstacles.get(i).getY() + 50), samurai.getX(), samurai.getY(), counter);
							projectiles.add(buckShot1);
						}
					}
					if (obstacles.get(i).getX() > 1000 || obstacles.get(i).getY() > 750
							|| (obstacles.get(i).getX() + 100) < 0 || (obstacles.get(i).getY() + 100) < 0 && !removed) {
						obstacles.remove(i);
						removed = true;
						if(i != 0) {
							i--;
						}
					}
					
					if (obstacles.get(i).getHitbox().checkCollision(samurai.getHitBox()) && !removed) {
						samurai.setScore(samurai.getScore() + 30);
						removed = true;
						obstacles.remove(i);
						samurai.setHealth(samurai.getHealth() - 20);
						if(i != 0) {
							i--;
						}
					} 
					
					if (samurai.getSwordHitBox1() != null && counter < 3000 
					&& obstacles.get(i).getHitbox().checkCollision(samurai.getSwordHitBox1())
					&& !removed) {
						samurai.setScore(samurai.getScore() + 30);
						removed = true;
						obstacles.remove(i);
						if(i != 0) {
							i--;
						}
					}
					
					if (samurai.getSwordHitBox2() != null && counter < 3000 
					&& obstacles.get(i).getHitbox().checkCollision(samurai.getSwordHitBox2())
					&& !removed) {
						samurai.setScore(samurai.getScore() + 30);
						removed = true;
						obstacles.remove(i);
						if(i != 0) {
							i--;
						}
					}
					
				}
	
				for (int i = 0; i < projectiles.size(); i++) {
					boolean removed = false;
					projectiles.get(i).updateProjectile();
					if (projectiles.get(i).getName() == "buckshot") {
						if (counter - projectiles.get(i).getCounterStart() == 100) {
							Projectile[] explodedPieces = projectiles.get(i).explode(3 + 1 * (counter/400));
							for (int a = 0; a < explodedPieces.length; a++) {
								projectiles.add(explodedPieces[a]);
							}
	
						}
					}
	
					if ((projectiles.get(i).getX() > 1000 || projectiles.get(i).getY() > 750
							|| (projectiles.get(i).getX() + 10) < 0 || (projectiles.get(i).getY() + 10) < 0) && !removed) {
						projectiles.remove(i);
						removed = true;
						i--;
					} else if (projectiles.get(i).getHitBox().checkCollision(samurai.getHitBox()) && !removed) {
						if(projectiles.get(i).getName().equals("cannonball")) {
							samurai.setHealth(samurai.getHealth() - 5);
						} else if (projectiles.get(i).getName().equals("boulder")) {
							samurai.setHealth(samurai.getHealth() - 20);
						} else if (projectiles.get(i).getName().equals("buckshot")) {
							samurai.setHealth(samurai.getHealth() - 10);
						}
						projectiles.remove(i);
						removed = true;
						i--;
					} else {
						for (int c = 0; c < platforms.size() && !removed; c++) {
							if (projectiles.get(i).getHitBox().checkCollision(platforms.get(c).getHitBox()) 
								&& !projectiles.get(i).getName().equals("boulder")) {
								projectiles.remove(i);
								removed = true;
								i--;
							}
						}
					}
					if (samurai.getSwordHitBox1() != null && !removed) {
						if (projectiles.get(i).getHitBox().checkCollision(samurai.getSwordHitBox1())) {
							changeScore(projectiles.get(i));
							projectiles.remove(i);
							removed = true;
							i--;
						}
					}
					if (samurai.getSwordHitBox2() != null && !removed) {
						if (projectiles.get(i).getHitBox().checkCollision(samurai.getSwordHitBox2())) {
							changeScore(projectiles.get(i));
							projectiles.remove(i);
							removed = true;
							i--;
						}
					}
				}
	
				samurai.updatePlayer();
				chamber.repaint();
				counter++;
	
				if (lightCounter < 253 && !changeLight) {
					lightCounter += 0.3;
				} else {
					changeLight = true;
					lightCounter -= 0.3;
				}
				if (lightCounter <= 10) {
					changeLight = false;
				}
				
			} else if(state == gameState.GAMEOVER){
				if(screenCounter < 10)
					screenCounter += 0.3;
				chamber.repaint();
			}
		}
	};
	Timer timer = new Timer(20, run);

	public void changeScore(Projectile theProjectile) {
		if(theProjectile.getName().equals("cannonball")) {
			samurai.setScore(samurai.getScore() + 5);
		} else if (theProjectile.getName().equals("boulder")) {
			samurai.setScore(samurai.getScore() + 15);
		} else if (theProjectile.getName().equals("buckshot")) {
			samurai.setScore(samurai.getScore() + 10);
		}
		System.out.println(samurai.getScore());
	}
	
	public static void main(String[] args) {
		new RunGame();
	}
}
