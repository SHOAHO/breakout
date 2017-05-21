package de.hpi.javaide.breakout.elements;

import java.awt.geom.Rectangle2D;
import java.util.Iterator;

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
		if(checkCollisionLeftAndRightBorder(game,ball)){
			ball.bounceX();	
		} else if(checkCollisionTopBorder(game,ball)){
			ball.bounceY();
		} else if(checkCollisionPaddle(game,ball,paddle)){
			ball.bounceY();
		} else {
			for ( Iterator<Brick> iterator = wall.iterator(); iterator.hasNext(); ){
				Brick brick = iterator.next();
				if (checkCollisionBrick(game,ball,brick)){
					if(!brick.isDead()){
						ball.bounceY();
						brick.nextStatus();	
						game.increaseScore(1);
					}
				}			
			}			
		}		
	}
	
	public static boolean checkCollisionLeftAndRightBorder(Game game, Ball ball){
		return 0 > (ball.getX() - ball.getWidth()/2) ||
				   Game.SCREEN_X < (ball.getX() + ball.getWidth()/2);
	}
	
	public static boolean checkPaddleCollisionLeftBorder(Game game, Paddle paddle){
		return 0 > (paddle.getX() - paddle.getWidth()/2);
	}
	public static boolean checkPaddleCollisionRightBorder(Game game, Paddle paddle){
		return Game.SCREEN_X < (paddle.getX() + paddle.getWidth()/2) ;
	}
	
	public static boolean checkCollisionTopBorder(Game game, Ball ball){
		return 0 > (ball.getY() - ball.getHeight()/2);
	}
	
	public static boolean checkCollisionPaddle(Game game, Ball ball, Paddle paddle){
		return ball.getGeometry().intersects((Rectangle2D) paddle.getGeometry());
	}	
	
	public static boolean checkCollisionBrick(Game game, Ball ball, Brick brick){
		return ball.getGeometry().intersects((Rectangle2D) brick.getGeometry());
	}	
}
