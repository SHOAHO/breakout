package de.hpi.javaide.breakout.basics;

import de.hpi.javaide.breakout.Colorable;

public class Color implements Colorable {

	/**
	 * the components of the color
	 */
	private int r, g, b;

	/**
	 * default constructor to create a black color
	 */
	public Color() {
		r = 0;
		g = 0;
		b = 0;
	}

	/**
	 * Constructor to create a color with the specified values
	 * @param r red portion of the color 0-255
	 * @param g green portion of the color 0-255
	 * @param b blue portion of the color 0-255
	 */
	public Color(int r, int g, int b) {
		this.r = r;
		this.g = g;
		this.b = b;
	}

	@Override
	public int getR() {
		return r;
	}
    /**
     * Set the red component
     * @param r int 0-255
     */
	public void setR(int r) {
		this.r = r;
	}

	@Override
	public int getG() {
		return g;
	}
	/**
     * Set the green component
     * @param g int 0-255
     */
	public void setG(int g) {
		this.g = g;
	}

	@Override
	public int getB() {
		return b;
	}

	/**
     * Set the blue components
     * @param b int 0-255
     */
	public void setB(int b) {
		this.b = b;
	}

	@Override
	public void setColor(int r, int g, int b) {
		setR(r);
		setG(g);
		setB(b);
	}
}