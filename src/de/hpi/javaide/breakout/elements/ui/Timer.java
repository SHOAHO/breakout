package de.hpi.javaide.breakout.elements.ui;

import de.hpi.javaide.breakout.basics.Font;
import de.hpi.javaide.breakout.basics.UIObject;
import de.hpi.javaide.breakout.screens.Screen;
import de.hpi.javaide.breakout.screens.ScreenManager;
import de.hpi.javaide.breakout.starter.Game;

public class Timer extends UIObject {

	private int seconds;
	private int time;

	public Timer(Game game) {
		super(game);
		seconds = 60;
		time    = game.millis();
	}

	@Override
	public void display() {
		game.fill(255);
		game.textFont(Font.getFont16());
		game.text("Time left: " + seconds, game.width-150, game.height-80);
	}

	@Override
	public void update(String input) {
		// TODO Auto-generated method stub
		if(game.millis() - time >= 1000){
			if(seconds > 0){
				seconds--;
			} else { 
		    	ScreenManager.setScreen(game, Screen.END);
			}
			time = game.millis();
		}
	}
}
