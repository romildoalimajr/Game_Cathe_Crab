package net.kalangos;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Smoke {

	public int x;
	public int y;

	public static BufferedImage[] smokeSprite;

	public int curFrames = 0;
	public int maxFrames = 10;
	public int maxAnimation = 2;
	public int curAnimation = 0;

	public Smoke(int x, int y) {
		this.x = x;
		this.y = y;
		
		smokeSprite = new BufferedImage[2];
		
		smokeSprite[0] = Game.spritesheet.getSprite(32, 0);
		smokeSprite[1] = Game.spritesheet.getSprite(48, 0);
	}
	
	public void update() {
		curFrames++;
		if(curFrames == maxFrames) {
			curAnimation++;
			if(curAnimation == maxAnimation) {
				curAnimation = 0;
				Game.smokes.remove(this);
			}
			curFrames = 0;
		}
	}
	
	public void render(Graphics g) {
		g.drawImage(smokeSprite[curAnimation], (int)x, (int)y, 40, 40, null);
	}
}
