package de.hpi.javaide.breakout.starter;

//TODO => Fehlermeldungen beseitigen
// 1. Lokale core.jar verlinken
// 2. Fehlende Methoden ergänzen. Tipp: eclipse macht hier das meiste für euch. Ihr braucht nahezu keinen Code zu schreiben.
// Der Vorteil hier: eclipse erstellt euch auch gleich einen Großteil eurer TODOs (Window->Show View->Tasks)

import processing.core.PApplet;

public class Main 
{

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		PApplet.main(new String[]{"--present", "de.hpi.javaide.breakout.starter.Game"});
	}

}
