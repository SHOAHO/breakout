package de.hpi.javaide.breakout.screens;

import de.hpi.javaide.breakout.basics.Font;
import de.hpi.javaide.breakout.basics.UIObject;
import de.hpi.javaide.breakout.elements.ui.Info;
import de.hpi.javaide.breakout.starter.Game;

/**
 * The Screen can be in three states, either the StartScreen, the GameScreen, or the EndScreen.
 * The game logic takes care, which of those is the currently active screen.
 * 
 * @author Ralf Teusner and Tom Staubitz
 *
 */
public class StartScreen implements Screen {

	/**
	 * This variable is needed for the Singleton pattern
	 */
	private static Screen instance;
	/**
	 * A reference to get access to the Processing features
	 */
	private Game game;
	private UIObject infoBox;
	private boolean start = false;
	
	private StartScreen(Game game){
		this.game = game;
		init();
	}

	/**
	 * StartScreen implements a "Lazy Instantiation" of the Singleton Design Patterns (Gang of Four) 
	 * This approach is not "Thread safe", but is sufficient for our current needs.
	 * 
	 * Please, be aware that Singletons need to be handled with care.
	 * There are various ways to implement them, all have there pros and cons.
	 * In his book, Effective Java, Joshua Bloch recommends to create Singletons using an enum, 
	 * which is a language concept that we have not discussed here so far.
	 * For those of you who want to go further we suggest to follow this recommendation at some point of time. 
	 *
	 * @return the StartScreen
	 */
	public static Screen getInstance(Game game){
		if(instance == null){
	    	instance = new StartScreen(game);
	    } else {
	    	instance.init();
	    }
	    return instance;
	}
	
	/*
	 * The user should be able to start the game here (by switching to the GameScreen.)
	 * 
	 * (non-Javadoc)
	 * @see de.hpi.javaide.breakout.screens.Screen#handleKeyPressed(java.lang.String)
	 */
	@Override
	public void init() {
//		game.noLoop();
		game.background(0);	
		String info = "Press Enter to start!\n";
		info += "Press Enter to launch the balls!\n";
		info += "Control speed with cursor up/down!\n";
		info += "Move paddle using your mouse\n";
		info += "or cursor keys!\n";
		info += "1 - Slide Mode / 2 - Step Mode\n";
		info += "Spacebar resets paddle!\n";
		game.setPaddleMode('1');
		game.setInfo(info);
		infoBox = new Info(game, info);
		infoBox.update(game.getInfo());
		infoBox.display();
	}
	
	@Override
	public void update() {
		// TODO Auto-generated method stub

	}

	@Override
	public void display() {
		if(start == false){
			System.out.println("input name");
			game.fill(255);
			game.textFont(Font.getFont24());
			game.text("Please enter your name:" + (game.getHighscore().getUserName()), game.width/(float)4, game.height/(float)2);	
		} else {
			System.out.println("Hit enter to start");
			infoBox.display();		
		}
	}

	@Override
	public void handleKeyPressed(String key) {
		switch (key) {
		case Screen.KEY_ENTER: 
			if(start == false){
				System.out.println("input name end");
				start = true;
			} else {
				start = false;
				System.out.println("starting..");
				ScreenManager.setScreen(game, Screen.GAME);
			}
			break;
		case Screen.KEY_DELETE:
		case Screen.KEY_BACKSPACE:	
			game.getHighscore().setUserName(game.getHighscore().getUserName().substring(0, game.getHighscore().getUserName().length()-1));
			break;
		case "1":
			if(start == true){
				game.setPaddleMode('1');
				infoBox.update(game.getInfo());
				infoBox.display();
			} else {
				game.getHighscore().setUserName(game.getHighscore().getUserName() + key);	
			}
			break;
		case "2":
			if(start == true){			
				game.setPaddleMode('2');
				infoBox.update(game.getInfo());
				infoBox.display();
		} else {
			game.getHighscore().setUserName(game.getHighscore().getUserName() + key);	
		}			
			break;
			
		default: 
			game.getHighscore().setUserName(game.getHighscore().getUserName() + key);
			break;
		}
	}

	@Override
	public void handleMouseDragged() {
		// Im StartScreen ist keine Interaktion mit der Maus notwendig.
	}
	
	@Override
	public void increaseScore(int i) {
		// Im StartScreen gibt es keinen Counter.
	}
}
