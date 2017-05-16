package de.hpi.javaide.breakout.elements;

import java.awt.geom.Rectangle2D;
import java.util.Iterator;

import de.hpi.javaide.breakout.screens.Screen;
import de.hpi.javaide.breakout.screens.ScreenManager;
import de.hpi.javaide.breakout.starter.Game;

//TODO den Fehler unten haben wir absichtlich eingebaut, um zu zeigen, dass hier noch was getan werden muss.
//     Hier sollen alle Kollisionen geprüft werden. Trifft der Ball das Paddle.
//     Für jeden Stein in der Mauer: wurde er getroffen?
//     Erreicht der Ball den Spielfeld Rand.
//     Tipp: Schleifen könnten sich als hilfreich erweisen.
public class CollisionLogic {
	/**
	 * The constructor of this class is private to make sure that it is only used as a static class.
	 * - it cannot be instantiated,
	 * - it cannot hold a state,
	 * - it contains only static methods
	 */
	private CollisionLogic() {}
	
	/**
	 * This method provides a way to determine if the ball collides with any of the collidable elements on the screen.
	 * Paddle, Bricks, ...
	 * 
	 * @param game
	 * @param ball
	 * @param paddle
	 * @param wall
	 */
	public static void checkCollision(Game game, Ball ball, Paddle paddle, Wall wall) {
		// TODO
		if (ball.getX() > Game.SCREEN_X - 15 || ball.getX() < 30/2) {
			ball.bounceX();
		}

		if (ball.getY() > Game.SCREEN_Y - 15 || ball.getY() < 30/2) {
			if (ball.getY() > Game.SCREEN_Y -15){
				
			} else {
				ball.bounceY();
			}
		}
		
		if (ball.getGeometry().intersects((Rectangle2D) paddle.getGeometry())){
			ball.bounceY();
		}

		for ( Iterator<Brick> iterator = wall.iterator(); iterator.hasNext(); ){
			Brick brick = iterator.next();
			if (ball.getGeometry().intersects((Rectangle2D) brick.getGeometry())){
				if(!brick.isDead()){
					ball.bounceY();
					brick.nextStatus();	
					game.increaseScore(1);
				}
			}			
		}
				
	}

}
