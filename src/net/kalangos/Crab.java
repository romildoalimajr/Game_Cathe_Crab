package net.kalangos;

import java.awt.Color;
import java.awt.Graphics;

public class Crab {

	public double x, y, dx, dy;
	public double spd = 4;

	public Crab(int x, int y) {
		this.x = x;
		this.y = y;
		// TODO = Calculo até o buraco
	}

	public void update() {
		x++;
		y++;
	}

	public void render(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect((int) x, (int) y, 48, 48);
	}
}
