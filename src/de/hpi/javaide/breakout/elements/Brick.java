package de.hpi.javaide.breakout.elements;

import java.awt.Dimension;
import java.awt.Point;

import de.hpi.javaide.breakout.basics.Rectangular;
import de.hpi.javaide.breakout.starter.Game;
import processing.core.PApplet;


//TODO wichtige Attribute: Größe, Position, Abstand der Bricks untereinander
//     Irgendwie muss ich herausbekommen ob der Stein noch existiert oder nicht.
public class Brick extends Rectangular {

	private final static int OFFSET = 10;
	
	private static int WIDTH  = 100;
	private static int HEIGHT = 20;
	
	private int status = 3;
	
	public Brick(Game game, Point position, Dimension dimension) {
		super(game, position, dimension);
		// TODO Auto-generated constructor stub
		setColor(128,255,0);
	}

	@Override
	public void display() {
		// TODO Auto-generated method stub
		game.rectMode(PApplet.CENTER);
		game.noStroke();
		game.fill(getR(), getG(), getB());
		if(!this.isDead()){
			game.rect(getX(), getY(), getWidth(), getHeight());
		}
	}
	
	public boolean isDead() {
		// TODO Auto-generated method stub
		return status <= 0;
	}

	public void nextStatus() {
		// TODO Auto-generated method stub
		if(status > 0){
			status--;
		};
	}
	
	public static int getOffset() {
		return OFFSET;
	}	
	
	public static int getWidthBrick() {
		return WIDTH;
	}	
	
	public static int getHeightBrick() {
		return HEIGHT;
	}
	
	public static void setWidthBrick(int width) {
		WIDTH = width;
	}	
	
	public static void setHeightBrick(int height) {
		HEIGHT = height;
	}	
}
