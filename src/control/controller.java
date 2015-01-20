package control;

import gui.View;

import javax.swing.Timer;

import listeners.GameTime;
import listeners.StartGame;
import listeners.actionListener;
import listeners.keyListner;
import listeners.loadGame;
import listeners.quit;
import save_load.serial;

public class controller {
	
	View v;
	public View getV() {
		return v;
	}

	public model getM() {
		return m;
	}

	public void setV(View v) {
		this.v = v;
	}

	public void setM(model m) {
		this.m = m;
	}

	model m;
	int gameTime;
	Timer t;
	Timer time;
	keyListner keylistner;
	actionListener actionlistner; 
	StartGame startGame; 
	GameTime GT;
	serial s;
	SoundPlayer sp;
	
	
	public SoundPlayer getSp() {
		return sp;
	}

	public controller(View v , model m, int timeLength)  {
		this.v=v;
		this.m=m;
		sp = new SoundPlayer();
		gameTime = timeLength;
		setListeners();
		GT = new GameTime(this, gameTime);
		time = new Timer(1000,GT );
		t = new Timer(10, actionlistner);
		v.showSplash();
		v.showMenu();
		v.getM().setListeners(new StartGame(this),new loadGame(this),new quit());
//		v.getV().setListeners(new saveGame(v,m,this), new back(v,this)/*, new loadGame(v,m,this)*/);
		s = new serial(m,this);
	}

	public serial getSerial() {
		return s;
	}
	
	public void setSerial(serial s) {
		this.s = s;
	}

	
	public int getTime(){
		return GT.getCount();
	}
	
	public void setTime(int time){
		 GT.setCount(time-1);
		 v.setTime(time);
	}
	
	public void endGame(int i) {
		sp.stop();
		resetGame();
		v.endGame(i);
	}
	
	public void setListeners(){
		keylistner = new keyListner(this);
		v.addKeyListener(keylistner);
		actionlistner = new actionListener(this);
	}
	
	private void resetGame() {
		stopTime();
		sp = new SoundPlayer();
		GT = new GameTime(this, gameTime);
		time = new Timer(1000, GT);
		v.setTime(gameTime);
		m.clearData();
		s = new serial(m,this); 
	}
	
	public void stopTime(){
		t.stop();
		time.stop();
	}

	public void startTime(){
		keylistner.clear();
		time.start();
		t.start();
	}
	
	public void startGame() {
		if(sp != null){	
			sp.start();
		}
		startTime();
//		v.setTime(gameTime);
		v.addPlayers(m.getP1(), m.getP2());
	}
}