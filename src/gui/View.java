package gui;

import listeners.keyListner;
import objects.Shape;
import players.player;

public class View {
	
	Splash s;
	Menu m;
	Game g;
	GameFrame gf;
	
	public Game getV() {
		return g;
	}

	
	
	public Menu getM() {
		return m;
	}
	public View(int time){
		s = new Splash();
		m = new Menu();
		g = new Game(time);
		gf= new GameFrame(time,g);
		
	}

	public void showMenu() {
		m.showMenu();
		if(g.isRunning()){			
			g.hideGame();
		}
	}

	public void showSplash() {
		s.showSplash();
	}
	
	
	public void showGame() {
		m.hideMenu();
		gf.showGame();
	}

	public int getWidth() {
		return g.getWidth();
	}

	public void addKeyListener(keyListner keylistner) {
		g.addKeyListener(keylistner);
	}

	public int getHeight() {
		return g.getHeight();
	}

	public void add(Shape s2) {
		g.add(s2);
	}

	public void updateScore(int score1, int score2) {
		g.updateScore(score1, score2);
	}

	public void endGame(int i) {
		gf.hideGame();
		g.endGame(i);
		m.showMenu();
	}

	public void setTime(int i) {
		g.setTime(i);
	}

	public void addPlayers(player p1, player p2) {
		g.addPlayers(p1, p2);
		g.setLoc(p1, p2);
	}
	
	public void addPlayers(player[] pl) {
		g.addPlayers(pl[0], pl[1]);
	}
	
	
	
	


	
	
}
