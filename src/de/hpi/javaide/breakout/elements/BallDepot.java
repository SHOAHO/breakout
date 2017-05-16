package de.hpi.javaide.breakout.elements;

import java.awt.Dimension;
import java.awt.Point;
import java.util.ArrayList;

import de.hpi.javaide.breakout.Displayable;
import de.hpi.javaide.breakout.Measureable;
import de.hpi.javaide.breakout.starter.Game;


//TODO hier werden wir sicher eine Collection brauchen um die Bälle unterzubringen.
//     Vermutlich werden wir wissen wollen wann das Depot leer ist.
//     Irgendwie müssen die Bälle an den Start gebracht werden.
public class BallDepot implements Displayable, Measureable {

	private ArrayList<Ball> balls;
	private int x;
	private int y;
	private int distance;
	private int fullsize;

	public BallDepot(Game game) {
		// TODO Auto-generated constructor stub
		balls = new ArrayList<>();
		
		x = game.width-140;
		y = game.height-60;
		distance = 25;
		fullsize = 30;
		for(int i=0; i<Game.LIVES; i++){
			balls.add(new Ball(game, new Point(x + (i * distance), y)));
		}
	}

	@Override
	public int getX() {
		
		// TODO Auto-generated method stub
		return this.x;
	}

	@Override
	public int getY() {
		// TODO Auto-generated method stub
		return this.y;
	}

	@Override
	public int getWidth() {
		// TODO Auto-generated method stub
		return distance * Game.LIVES - distance + 10;
	}

	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		return this.y;
	}

	@Override
	public void display() {
		// TODO Auto-generated method stub
		for( Ball ball : balls ){
			ball.display();
		}
	}

	public boolean isEmpty() {
		// TODO Auto-generated method stub
	    return balls.isEmpty();
	}

	public Ball dispense() {
		// TODO Auto-generated method stub
		if (this.isEmpty()) {
			return null;
		} else {
			Ball currentBall = balls.remove(balls.size() - 1);
			currentBall.update(Game.STARTPOSITION, new Dimension(fullsize, fullsize));
			return currentBall;
		}
	}

}


