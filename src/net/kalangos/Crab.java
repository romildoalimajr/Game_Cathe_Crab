package net.kalangos;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Crab {

	public double x, y, dx, dy;
	public double speed = 4;
	
	public static BufferedImage[] crabSprite;
	
	public int curFrames = 0;
	public int maxFrames = 10;
	public int maxAnimation = 2;
	public int curAnimation = 0;
	

	public Crab(int x, int y) {
		this.x = x;
		this.y = y;
		double radius = Math.atan2((Game.HEIGHT/2 -20) - y, (Game.WIDTH/2 - 20) - x);
		this.dx = Math.cos(radius);
		this.dy = Math.sin(radius);
		crabSprite = new BufferedImage[2];
		crabSprite[0] = Game.spritesheet.getSprite(0, 0);
		crabSprite[1] = Game.spritesheet.getSprite(16, 0);
		// TODO = Calculo até o buraco
	}

	public void update() {
		x += dx * speed;
		y += dy * speed;
		if(new Rectangle((int)x, (int)y, 40, 40).intersects(Game.maskBuraco)) {
			Game.crabs.remove(this);
			return;
		}
		curFrames++;
		if(curFrames == maxFrames) {
			curAnimation++;
			if(curAnimation == maxAnimation) {
				curAnimation = 0;
			}
			curFrames = 0;
		}
	}

	public void render(Graphics g) {
		g.drawImage(crabSprite[curAnimation], (int)x, (int)y, 40, 40, null);
		//g.setColor(Color.RED);
		//g.fillRect((int) x, (int) y, 48, 48);
	}
}
