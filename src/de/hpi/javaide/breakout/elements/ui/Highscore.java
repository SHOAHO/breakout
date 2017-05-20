package de.hpi.javaide.breakout.elements.ui;

import de.hpi.javaide.breakout.basics.UIObject;
import de.hpi.javaide.breakout.starter.Game;

public class Highscore extends UIObject{

	private static Highscore instance;
	
	private String userName;
	
	public Highscore(Game game) {
		super(game);
		init();
	}	
	
	public static Highscore getInstance(Game game){
		if(instance == null){
	    	instance = new Highscore(game);
	    } else {
	    	instance.init();
	    }
	    return instance;
	}

	public void init() {
		if(userName == null){ 
			userName = " ";	
		}
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}	
	
	public String getUserName() {
		return userName;
	}	
	
	@Override
	public void display() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(String input) {
		// TODO Auto-generated method stub
		
	}

}
