package de.hpi.javaide.breakout.elements;

import java.awt.Dimension;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Iterator;

import de.hpi.javaide.breakout.Displayable;
import de.hpi.javaide.breakout.starter.Game;

/**
 * Blueprint for the Wall
 * 
 * @author Ralf Teusner and Tom Staubitz
 *
 */
//TODO die Wall wird aus Bricks gebaut.
public class Wall implements Displayable, Iterable<Brick> {
	
	/**
	 * Datastructure to keep the Bricks
	 */
	private ArrayList<Brick> wall;


	public Wall(Game game, int i, int j) {
		// TODO Auto-generated constructor stub
		wall = new ArrayList<>();
		
		buildWall(game, i, j);
	}
	@Override
	public Iterator<Brick> iterator() {
		return wall.iterator();
	}
	/**
	 * Build the wall by putting the single bricks into their position
	 * Hint: You might want to use one or two for-loops
	 * 
	 * @param game
	 * @param columns
	 * @param rows
	 */
	private void buildWall(Game game, int columns, int rows) {
		Brick.setWidthBrick((game.width - Brick.getOffset()) / columns - Brick.getOffset());
		Brick.setHeightBrick((game.height / 3) / rows - Brick.getOffset());
		
		for(int i = 0; i < columns; i++){
			for(int j = 0; j < rows; j++){
				int x = ((i + 1) * Brick.getOffset()) + (i * Brick.getWidthBrick()) +
						(Brick.getWidthBrick()/2);
				int y = ((j + 1) * Brick.getOffset()) + (j * Brick.getHeightBrick()) + 
						(Brick.getHeightBrick()/2);
				wall.add(new Brick(game, new Point(x,y), 
						 new Dimension(Brick.getWidthBrick(),Brick.getHeightBrick())));
		    }
	    }
	}
	@Override
	public void display() {
		// TODO Auto-generated method stub
		for( Brick brick : wall ){
			brick.display();
		}		
	}
}
