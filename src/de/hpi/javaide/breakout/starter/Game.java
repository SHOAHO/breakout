package de.hpi.javaide.breakout.starter;

import de.hpi.javaide.breakout.basics.Font;
import de.hpi.javaide.breakout.screens.Screen;
import de.hpi.javaide.breakout.screens.ScreenManager;
import processing.core.PApplet;

@SuppressWarnings("serial")
public class Game extends PApplet implements GameConstants {

	

	// Setup the game
	@Override
	public void setup() {
		size(SCREEN_X, SCREEN_Y);
		background(0);
		frameRate(30);
		Font.init(this);
		ScreenManager.setScreen(this, Screen.START);
	}

	// Update and draw everything in the game
	@Override
	public void draw() {
		background(0);
		ScreenManager.getCurrentScreen().update();
		ScreenManager.getCurrentScreen().display();
	}

	// Interact with the mouse
	@Override
	public void mouseMoved() {

	}

	@Override
	public void mouseDragged() {
		ScreenManager.getCurrentScreen().handleMouseDragged();
	}

	// Interact with the keyboard
	@Override
	public void keyPressed() {
		switch (key) {
		case RETURN:
		case ENTER:
			ScreenManager.getCurrentScreen().handleKeyPressed(Screen.KEY_ENTER);
			break;
		case 'h':
			System.out.println("nach rechts");
			ScreenManager.getCurrentScreen().handleKeyPressed("h");
			break;
		case 'g': 
			System.out.println("nach links");
			ScreenManager.getCurrentScreen().handleKeyPressed("g");
			break;
		case DELETE:
		case BACKSPACE:		
			ScreenManager.getCurrentScreen().handleKeyPressed(Screen.KEY_DELETE);
			break;			
		default: 
			System.out.println("key:" + key + "/"); 
			ScreenManager.getCurrentScreen().handleKeyPressed("" + key);				
			break;
		}
	}

	@Override
	public void keyReleased() {

	}

	public void increaseScore(int i) {
		ScreenManager.getCurrentScreen().increaseScore(i);
	}
}
