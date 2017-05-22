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
	public void stepRight(){
		update(new Point( getX() + 10, getY() ), new Dimension(getWidth(), getHeight()) );
	}
	public void stepLeft(){
		update(new Point( getX() - 10, getY() ), new Dimension(getWidth(), getHeight()) );
	}
	public void moreLeft(){
		if (CollisionLogic.checkPaddleCollisionLeftBorder(game, this)){
			return;
		}

		float lf_x = direction.getX();
		
		if (lf_x > 0){				//paddle is moving to the right
			stop();
/*			if (lf_x > START_SPEED){			//reduce speed
				direction.setX((float) (lf_x * 0.66666) );
			}
			else{					// stop paddle
				stop();
			}  */
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
	
	public void moreRight(){
		
		if (CollisionLogic.checkPaddleCollisionRightBorder(game, this)){
			return;
		}
		float lf_x = direction.getX();
		
		if (lf_x < 0){				//paddle is moving to the left
			stop();
/*			if (lf_x < -START_SPEED){			//reduce speed
				direction.setX((float) (lf_x * 0.66666) );
			}
			else{					// stop paddle
				stop();
			} */
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

	public void slide() {
		// TODO Auto-generated method stub
		update(new Point(getX() + (int) direction.getX(), 
				         getY() + (int) direction.getY()), this.dimension);
	}	
	
	public void reset(){
		direction.setX(0);
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
		// TODO Auto-generated method stub
		return direction.getX();
	}

}
