package de.hpi.javaide.breakout.basics;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Shape;

import de.hpi.javaide.breakout.Collidable;
import de.hpi.javaide.breakout.Colorable;
import de.hpi.javaide.breakout.Displayable;
import de.hpi.javaide.breakout.starter.Game;

/**
 * Base class to build collidable objects from.
 * Provides the required basis for Elliptics and Rectangulars
 * 
 * @author Ralf Teusner and Tom Staubitz
 *
 */
public abstract class CollisionObject implements Collidable, Displayable, Colorable {

	/**
	 * the geometrical Shape that defines the form of the object.
	 */
	protected Shape geometry;
	/**
	 * a reference to the game class to provide access to the processing methods
	 */
	protected Game game;
	/** 
	 * width and height of the object
	 */
	protected Dimension dimension;
	/** 
	 * the x,y position of an object
	 */
	protected Point position;
	/**
	 * the color of the object
	 */
	private Color color;
	/**
	 * Constructor. Initializes the reference to the Game, the size and the position of the object
	 * @param game Game, access to the Processing features 
	 * @param position Position, the x,y coordinates 
	 * @param dimension Dimension, the width and height of the object
	 */
	public CollisionObject(Game game, Point position, Dimension dimension) {
		this.game = game;
		this.position = position;
		this.dimension = dimension;
		this.color = new Color(255, 255, 255);
	}

	@Override
	public int getWidth() {
		return dimension.width;
	}

	@Override
	public int getHeight() {
		return dimension.height;
	}

	@Override
	public int getX() {
		return position.x;
	}

	@Override
	public int getY() {
		return position.y;
	}

	@Override
	public int getR() {
		return color.getR();
	}

	@Override
	public int getG() {
		return color.getG();
	}

	@Override
	public int getB() {
		return color.getB();
	}

	@Override
	public void setColor(int r, int g, int b) {
		this.color = new Color(r, g, b);
	}

	@Override
	public Shape getGeometry() {
		return this.geometry;
	}

	@Override
	public void update(Point position, Dimension dimension) {
		this.position = position;
		this.dimension = dimension;
	}
}
