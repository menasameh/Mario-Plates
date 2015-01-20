package control;

import gui.View;

public class TheGame {
static int gameTime = 60;
	
	
	public static void main(String[] args) {
		model m = new model();
		View v = new View(gameTime);
		controller c = new controller(v,m,gameTime);
	}
}
