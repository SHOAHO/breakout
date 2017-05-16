package de.hpi.javaide.breakout.basics;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.geom.Ellipse2D;

import de.hpi.javaide.breakout.starter.Game;

/**
 * Extends the CollisionObject to provide the basis for the round collidable Elements, such as the Ball
 * @author Ralf Teusner and Tom Staubitz
 *
 */
public abstract class Elliptic extends CollisionObject {

	public Elliptic(Game game, Point position, Dimension dimension) {
		super(game, position, dimension);
		geometry = new Ellipse2D.Float(getX(), getY(), getWidth(), getHeight());
	}

	/**
	 * Constructor to create the basis for a round object
	 * 
	 * @param game Game reference to the game that provides access to the Processing features
	 * @param position Position x,y position of the Object
	 * @param dimension
	 */
	public Elliptic(Game game) {
		this(game, new Point(0, 0), new Dimension(10, 10));
	}
	
	/**
	 * Default constructor to create a round object with a size 10,10 at the top left corner of the screen.
	 * @param game Game
	 */
	@Override
	public void update(Point position, Dimension dimension) {
		super.update(position, dimension);
		((Ellipse2D) this.getGeometry()).setFrame(getX(), getY(), getWidth(), getHeight());
	}
}
