package de.hpi.javaide.breakout.elements.ui;

import java.io.File;

import de.hpi.javaide.breakout.basics.Font;
import de.hpi.javaide.breakout.basics.UIObject;
import de.hpi.javaide.breakout.starter.Game;
import processing.data.Table;
import processing.data.TableRow;

public class Highscore extends UIObject {

	private static Highscore instance;

	private String userName;
	private Table scoreTable;
	private Score score;

	public Highscore(Game game) {
		super(game);
		init();
	}

	public static Highscore getInstance(Game game) {
		if (instance == null) {
			instance = new Highscore(game);
		} else {
			instance.init();
		}
		return instance;
	}

	public void init() {
		if (userName == null) {
			userName = " ";
		}
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserName() {
		return userName;
	}

	public void setInstanceScore(Score instance) {
		this.score = instance;
	}

	public void updateHighscore() {
		TableRow oldRow = scoreTable.findRow(userName, "name");
		if(oldRow != null){
			if(oldRow.getInt("score") < score.getScore()){
				oldRow.setInt("score", score.getScore());
			}
		} else {
			TableRow newRow = scoreTable.addRow();
			newRow.setInt("id", scoreTable.getRowCount() - 1);
			newRow.setString("name", userName);
			newRow.setInt("score", score.getScore());			
		}

		game.saveTable(scoreTable, "data/Highscore.csv");
		scoreTable.sortReverse("score");
	}

	public void loadHighscore() {

		String filename = "Highscore.csv";
		scoreTable = new Table();

		File f = new File(game.dataPath(filename));
		if (f.exists()) {
			scoreTable = game.loadTable("data/Highscore.csv", "header, csv");
		} else {
			scoreTable.addColumn("id");
			scoreTable.addColumn("name");
			scoreTable.addColumn("score");
			game.saveTable(scoreTable, "data/Highscore.csv");
		}
	}

	@Override
	public void display() {
		// TODO Auto-generated method stub
		game.fill(255);
		game.textFont(Font.getFont24());	
		
		String info = "Highscore\n";
		game.text(info, game.width/4, 30);		
		
		int counter = scoreTable.lastRowIndex();
		if(counter > 14){
			counter = 14;
		}
		for (int i = 0; i < counter+1; i++) {
			TableRow row = scoreTable.getRow(i);
			String name = row.getString("name");
			int score = row.getInt("score");
			
			game.text(i+1, game.width/4, 30 + ((i+1) * 30));
			game.text(name, (game.width/4)+50, 30 + ((i+1) * 30));
			game.text(score, (game.width/4)+400, 30 + ((i+1) * 30));
		}
	}

	@Override
	public void update(String input) {
		// TODO Auto-generated method stub

	}

}
