package de.hpi.javaide.breakout.starter;

import de.hpi.javaide.breakout.basics.Font;
import de.hpi.javaide.breakout.elements.ui.Highscore;
import de.hpi.javaide.breakout.screens.Screen;
import de.hpi.javaide.breakout.screens.ScreenManager;
import processing.core.PApplet;

@SuppressWarnings("serial")
public class Game extends PApplet implements GameConstants {

	String info = " ";
	char paddleMode = '2';

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
		if (key==CODED){			//special keys like cursor 
			switch (keyCode){
			case RIGHT:
				System.out.println("nach rechts");
				ScreenManager.getCurrentScreen().handleKeyPressed(Screen.CURSOR_RIGHT);
				break;
			case LEFT:
				System.out.println("nach links");
				ScreenManager.getCurrentScreen().handleKeyPressed(Screen.CURSOR_LEFT);
				break;
			case UP:
				System.out.println("schneller");
				ScreenManager.getCurrentScreen().handleKeyPressed(Screen.CURSOR_UP);
				break;
			case DOWN:
				System.out.println("langsamer");
				ScreenManager.getCurrentScreen().handleKeyPressed(Screen.CURSOR_DOWN);
				break;
			default:
				break;	
			}
		}
		switch (key) {
		case RETURN:
		case ENTER:
			ScreenManager.getCurrentScreen().handleKeyPressed(Screen.KEY_ENTER);
			break;
		case DELETE:
		case BACKSPACE:		
			ScreenManager.getCurrentScreen().handleKeyPressed(Screen.KEY_DELETE);
			break;		
		case ' ':
			ScreenManager.getCurrentScreen().handleKeyPressed(Screen.KEY_SPACE);
			break;
		default: 
			System.out.println("key:" + key + "/"); 
			ScreenManager.getCurrentScreen().handleKeyPressed("" + key);				
			break;
		}
	}

	@Override
	public void keyReleased() {
		ScreenManager.getCurrentScreen().handleKeyReleased();				

	}

	public void increaseScore(int i) {
		ScreenManager.getCurrentScreen().increaseScore(i);
	}
	
	public Highscore getHighscore() {
		return Highscore.getInstance(this);
	}
	
	public void setInfo(String if_info){
		info = if_info;
	}
	
/** Infotext is stored in game, because paddleInfo is added. **/	
	public String getInfo(){
		return info + getPaddleInfo();
	}
	
/** Info about paddle mode**/	
	public String getPaddleInfo(){
		
		switch (paddleMode){
		case '1':
			return " >You are playing with paddle in Slide Mode\n";
		case '2':
			return " >You are playing with paddle in Step Mode\n";
		default:
			return " ";
		}
	}

/** what kind of paddle do you like? Self-sliding paddle started by
 * the cursor keys or a paddle that stops when the cursor kewy is released **/	
	public void setPaddleMode(char if_mode) {
		paddleMode = if_mode;
	}

	/** get the selected paddle mode**/
	public char getPaddleMode() {
		return paddleMode;
	}
	
}
