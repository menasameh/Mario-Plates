package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import control.controller;

public class GameTime implements ActionListener{

	controller c;
	int count;
	public GameTime(controller c, int time) {
		this.c = c;
		count =time-1;
	}
	
	public int getCount() {
		return count;
	}
	
	public void setCount(int count) {
		this.count = count;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(count == 0){
			int i=getWinner();
			c.endGame(i);
		}
		c.getV().setTime(count--);
	}


	private int getWinner() {
		int score1 = c.getM().getP1().getScore();
		int score2 = c.getM().getP2().getScore();
		if(score1 > score2){
			return 1;
		}
		else if(score1 < score2){
			return 2;
		}
		else{
			return 3;
		}
	}

}
