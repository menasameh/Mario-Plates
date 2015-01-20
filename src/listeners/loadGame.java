package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import save_load.serial;
import control.controller;

public class loadGame implements ActionListener {
//	View v;
//	model m;
	controller c;

	public loadGame(controller c) {
//		this.v = v;
//		this.m = m;
		this.c = c;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		c.stopTime();
		try {
			c.getV().addPlayers(c.getSerial().load());
			c.getM().getPool().addShapes(c.getM().getP1().getRight());
			c.getM().getPool().addShapes(c.getM().getP1().getLeft());
			c.getM().getPool().addShapes(c.getM().getP2().getRight());
			c.getM().getPool().addShapes(c.getM().getP2().getLeft());
			c.getV().getV().addShapes(c.getM().getP1().getRight());
			c.getV().getV().addShapes(c.getM().getP1().getLeft());
			c.getV().getV().addShapes(c.getM().getP2().getRight());
			c.getV().getV().addShapes(c.getM().getP2().getLeft());
			// c.setListeners();
			c.getM().getObserver().attach(c.getM().getP1());
			c.getM().getObserver().attach(c.getM().getP2());
			c.getV().showGame();
			c.getSp().start();
			c.startTime();
		} catch (Exception e1) {
			if (!e1.getMessage().equals(serial.noFile)) {
				JOptionPane.showMessageDialog(null,
						"error during operation !!", "error",
						JOptionPane.OK_OPTION);
			}
		}
	
	}
}
