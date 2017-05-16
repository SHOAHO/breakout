package de.hpi.javaide.breakout.elements;

import java.awt.Dimension;
import java.awt.Point;

import de.hpi.javaide.breakout.basics.Rectangular;
import de.hpi.javaide.breakout.starter.Game;
import processing.core.PApplet;

/**
 * Create the paddle
 * @param game Game provide access to the Processing features
 */
public class Paddle extends Rectangular {
	public Paddle(Game game) {
		super(game, new Point(game.width / 2, game.height - 20), new Dimension(100, 20));
		setColor(150, 150, 150);
	}

	@Override
	public void display() {
		game.rectMode(PApplet.CENTER);
		game.noStroke();
		game.fill(getR(), getG(), getB());
		game.rect(getX(), getY(), getWidth(), getHeight());
	}

	public void move() {
		update(new Point(game.mouseX, getY()), new Dimension(getWidth(), getHeight()));
	}
}
