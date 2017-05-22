package de.hpi.javaide.breakout.elements;

import java.awt.Dimension;
import java.awt.Point;
import java.util.ArrayList;

import de.hpi.javaide.breakout.Displayable;
import de.hpi.javaide.breakout.Measureable;
import de.hpi.javaide.breakout.starter.Game;


//TODO hier werden wir sicher eine Collection brauchen um die B�lle unterzubringen.
//     Vermutlich werden wir wissen wollen wann das Depot leer ist.
//     Irgendwie m�ssen die B�lle an den Start gebracht werden.
public class BallDepot implements Displayable, Measureable {

	private ArrayList<Ball> balls;
	private int x;
	private int y;
	private int distance;

	public BallDepot(Game game) {
		balls = new ArrayList<>();
		
		x = game.width-140;
		y = game.height-60;
		distance = 25;
		for(int i=0; i<Game.LIVES; i++){
			balls.add(new Ball(game, new Point(x + (i * distance), y)));
		}
	}

	@Override
	public int getX() {
		return this.x;
	}

	@Override
	public int getY() {
		// TODO Auto-generated method stub
		return this.y;
	}

	@Override
	public int getWidth() {
		return distance * Game.LIVES - distance + 10;
	}

	@Override
	public int getHeight() {
		return this.y;
	}

	@Override
	public void display() {
		for( Ball ball : balls ){
			ball.display();
		}
	}

/** are there remaining balls?*/	
	public boolean isEmpty() {
	    return balls.isEmpty();
	}

/**throw a new ball onto the screen*/	
	public Ball dispense() {
		if (this.isEmpty()) {
			return null;
		} else {
			Ball currentBall = balls.remove(balls.size() - 1);
			currentBall.update(Game.STARTPOSITION, 
					           new Dimension(currentBall.getFullsize(), currentBall.getFullsize()));
			return currentBall;
		}
	}

}


