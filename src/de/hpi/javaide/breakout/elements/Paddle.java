package de.hpi.javaide.breakout.elements;

import java.awt.Dimension;
import java.awt.Point;

import de.hpi.javaide.breakout.basics.Rectangular;
import de.hpi.javaide.breakout.basics.Vector;
import de.hpi.javaide.breakout.starter.Game;
import processing.core.PApplet;

/**
 * Create the paddle
 * @param game Game provide access to the Processing features
 */
public class Paddle extends Rectangular {
	
	int START_SPEED = 7;
	private Vector direction = new Vector(0,0);

	
	public Paddle(Game game) {
		super(game, new Point(game.width / 2, game.height - 20), new Dimension(100, 20));
		setColor(150, 150, 150);
	}

	@Override
	public void display() {
		game.rectMode(PApplet.CENTER);
		game.noStroke();
		game.fill(getR(), getG(), getB());
		game.rect(getX(), getY(), getWidth(), getHeight());
	}

	public void move() {
		update(new Point(game.mouseX, getY()), new Dimension(getWidth(), getHeight()));
	}
	
/**paddle is starting to the right. It stops when key is released*/	
	public void stepRight(){
		if (getSpeed() < (float) 0.1 
			 && getSpeed() > (float) -0.1 ){
				moreRight();
			}
	}
	
	/**paddle is starting to the left. It stops when key is released*/	
	public void stepLeft(){
		if (getSpeed() < (float) 0.1 
			 && getSpeed() > (float) -0.1 ){
				moreLeft();
			}
	}

/**speed up paddle, direction left*/	
	public void moreLeft(){
		if (CollisionLogic.checkPaddleCollisionLeftBorder(game, this)){
			return;
		}

		float lf_x = direction.getX();
		
		if (lf_x > 0){				//paddle is moving to the right
			stop();
		}
		else{					//paddle is moving to the left
			if (lf_x > -START_SPEED){			// start paddle
				direction.setX((float) (-START_SPEED) );
			}
			else{					// speed up 
				direction.setX((float) (lf_x * 1.5 ));
			}
		}
	}
	
	/**speed up paddle, direction right*/
	public void moreRight(){
		
		if (CollisionLogic.checkPaddleCollisionRightBorder(game, this)){
			return;
		}
		float lf_x = direction.getX();
		
		if (lf_x < 0){				//paddle is moving to the left
			stop();
		}
		else{					//paddle is moving to the right
			if (lf_x < 5){			// start paddle
				direction.setX((float) (START_SPEED) );
			}
			else{					// speed up 
				direction.setX((float) (lf_x * 1.5 ));
			}
		} 
	}

	/**paddle slides to a new position, depending on direction*/
	public void slide() {
		update(new Point(getX() + (int) direction.getX(), 
				         getY() + (int) direction.getY()), this.dimension);
	}	
	
	/**stop paddle and set it to start position*/
	public void reset(){
		stop();
		update(new Point( game.width / 2, getY() ), new Dimension(getWidth(), getHeight()) );
	}
	
	public void stopAtLeft(){
		stop();
		update(new Point( 0 + getWidth() / 2, getY() ), new Dimension(getWidth(), getHeight()) );
	}
	public void stopAtRight(){
		update(new Point( game.width - getWidth() / 2, getY() ), new Dimension(getWidth(), getHeight()) );
		stop();
	}
	public void stop(){
		direction.setX(0);
	}

	public float getSpeed() {
		return direction.getX();
	}

}
