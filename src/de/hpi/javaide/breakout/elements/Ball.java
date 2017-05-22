package de.hpi.javaide.breakout.elements;

import java.awt.Dimension;
import java.awt.Point;

import de.hpi.javaide.breakout.basics.Elliptic;
import de.hpi.javaide.breakout.basics.Vector;
import de.hpi.javaide.breakout.starter.Game;
import processing.core.PApplet;

/**
 * Blueprint for a Ball
 * 
 * @author Ralf Teusner and Tom Staubitz
 *
 */
//TODO neben dem Ergänzen der vom Interface erwarteten Methoden, 
//     sollte der Ball Eigenschaften wie Größe und Richtung mitbringen.
//     Richtung wird in der Regel als Vector definiert. 
//     Vermutlich sollte er die Richtung ändern können und sehr wahrscheinlich wird früher oder später 
//     jemand wissen wollen in welche Richtung er fliegt.
public class Ball extends Elliptic {
	
	private Vector direction;
	private int fullsize;
	
	public Ball(Game game, Point position) {
		super(game, position, new Dimension(10, 10));
		setColor(255,255,255);	
		direction = new Vector(game.random(-7, 7),7);
		fullsize = 20;
	}

	@Override
	public void display() {
		// TODO Auto-generated method stub
		game.ellipseMode(PApplet.CENTER);
		game.noStroke();
		game.fill(getR(), getG(), getB());
		game.ellipse(getX(), getY(), getWidth(), getHeight());
	}

    public int getFullsize() {
    	return fullsize;
    }
    
	public void bounceX() {
		direction.setX(-direction.getX());
	}

	public void bounceY() {
		direction.setY(-direction.getY());
	}	
	
/** set speed by increasing with speedFactor 
 * if speedFactor < 1 speed is decreasing */	
	public void increaseSpeed(float speedFactor){
		direction.mult(speedFactor);
	}

/**move ball to a new position, depending on direction*/	
	public void move() {
		update(new Point(getX() + (int) direction.getX(), 
				         getY() + (int) direction.getY()), this.dimension);
	}	
}
