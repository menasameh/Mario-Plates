package listeners;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JOptionPane;
import javax.swing.Timer;

import save_load.serial;
import control.controller;
import control.model;
import gui.*;


public class keyListner implements KeyListener , ActionListener{
	
	private Set<Integer> pressed = new HashSet<Integer>();
	Timer t ;
//	View v ;
//	model m;
	controller c;
	public keyListner(controller c){
//		this.v =v;
//		this.m=m;
		this.c = c;
		t = new Timer(25 , this);
		t.start();
		clear();
	}
	
	public void clear(){
		pressed = new HashSet<Integer>();
	}
	
	
	@Override
	public void keyTyped(KeyEvent k) {
		
	}

	@Override
	public synchronized void keyPressed(KeyEvent e) {
		pressed.add(e.getKeyCode());
		if(e.getKeyCode() == 83){
			if(pressed.contains(17)){
				save();
			}
		}
		else if(e.getKeyCode() == 27){
			back();
		}
		
	}


	private void back() {
		c.getV().getV().setRunning(false);
		c.stopTime();
		int ans = JOptionPane.showConfirmDialog(null, "are you sure you want to back current game will be lost ?","are you sure",JOptionPane.YES_NO_OPTION);
		if(ans == JOptionPane.YES_OPTION){			
			c.endGame(0);
		}
		else{			
			c.getV().getV().setRunning(true);
			c.startTime();
		}
	}

	private void save() {
		c.getV().getV().setRunning(false);
		c.stopTime();
		try {
			c.getSerial().save();
		} catch (Exception e1) {
			if(!e1.getMessage().equals(serial.noFile)){				
				JOptionPane.showMessageDialog(null, "error during operation !!","error",JOptionPane.OK_OPTION);
			}
		}
		c.getV().getV().setRunning(true);
		c.startTime();
	}

	@Override
	public synchronized void keyReleased(KeyEvent e) {
		pressed.remove(e.getKeyCode());
	}

	private void setLocation1(int i) {
		if (c.getM().getP1().getX() + i < 0 || c.getM().getP1().getX() + i > c.getV().getWidth() - c.getM().getP1().getWidth()) {
			return;
		}
		c.getM().getP1().setLocation(c.getM().getP1().getX() + i, c.getM().getP1().getY());
		c.getM().getP1().move(i);
	}

	private void setLocation2(int i) {
		if (c.getM().getP2().getX() + i < 0 || c.getM().getP2().getX() + i > c.getV().getWidth() - c.getM().getP2().getWidth()) {
			return;
		}
		c.getM().getP2().setLocation(c.getM().getP2().getX() + i, c.getM().getP2().getY());
		c.getM().getP2().move(i);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(!c.getV().getV().isRunning()){
			return ;
		}
		for (Integer x : pressed) {
			if (x == KeyEvent.VK_RIGHT) {
				setLocation2(10);
			}
			if (x == KeyEvent.VK_LEFT) {
				setLocation2(-10);
			}
			if (x == 68) {
				setLocation1(10);
			}
			if (x == 65) {
				setLocation1(-10);
			}
		}
	}

}
