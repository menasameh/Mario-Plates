package listeners;

import gui.View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import control.controller;

public class StartGame implements ActionListener{
//	View v;
	controller c;
	 public StartGame(controller c) {
//		this.v = v;
		this.c = c;
	 }
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		 c.getV().showGame();
		 c.startGame();
	}

}
