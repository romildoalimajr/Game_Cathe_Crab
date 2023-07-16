package net.kalangos;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

public class Game extends Canvas implements Runnable {

	public static int WIDTH = 480;
	public static int HEIGHT = 480;

	public static List<Crab> crabs;
	public Spawner spawner;
	public static Spritesheet spritesheet;
	
	public static Rectangle maskBuraco;

	public Game() {
		this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		spritesheet = new Spritesheet("/spritesheet.png");
		crabs = new ArrayList<>();
		spawner = new Spawner();
		
		maskBuraco = new Rectangle(WIDTH/2 - 20, HEIGHT/2 - 20, 40, 40);

	}

	public void update() {
		spawner.update();
		for (int i = 0; i < crabs.size(); i++) {
			crabs.get(i).update();
		}
	}

	public void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		Graphics g = bs.getDrawGraphics();
		g.setColor(new Color(255, 229, 102));
		g.fillRect(0, 0, WIDTH, HEIGHT);
		g.setColor(Color.black);
		g.fillOval(WIDTH / 2 - 20, HEIGHT / 2 - 20, 40, 40);

		for (int i = 0; i < crabs.size(); i++) {
			crabs.get(i).render(g);
		}

		g.dispose();
		bs.show();
	}

	public static void main(String[] args) {
		Game game = new Game();
		JFrame frame = new JFrame();
		frame.setTitle("Catch the Crab - Kalango's");
		frame.add(game);
		frame.setResizable(false);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.setVisible(true);

		new Thread(game).start();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		double fps = 60.0;
		while (true) {
			update();
			render();
			try {
				Thread.sleep((int) (1000 / fps));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
