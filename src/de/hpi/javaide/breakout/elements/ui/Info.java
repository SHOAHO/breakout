package de.hpi.javaide.breakout.elements.ui;

import de.hpi.javaide.breakout.basics.Font;
import de.hpi.javaide.breakout.basics.UIObject;
import de.hpi.javaide.breakout.starter.Game;

//TODO nach dem die fehlenden Methoden ergänzt wurden, muss hier noch ein Konstruktorparameter 
//     an das zugehörige Attribut übergeben werden.

public class Info extends UIObject {

	private String content;
	
	public Info(Game game, String content) {
		super(game);
		this.content = content;
	}

	@Override
	public void display() {
	    game.textFont(Font.getFont24());
	    game.text(content, Game.SCREEN_X/10, Game.SCREEN_Y/4);
	}

	@Override
	public void update(String input) {
		// just like setContent
		content = input;
	}
	
/**UIObject has no getter for content*/	
	public String getContent(){
		return content;
	}
}
