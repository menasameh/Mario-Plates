package listeners;

import gui.View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.Random;

import objects.Shape;
import objects.state;
import players.player;
import control.controller;
import control.model;

public class actionListener implements ActionListener {

	// objectPool op;
	int count;
//	View v;
//	model m;
	controller c;

	public actionListener(controller c) {
//		this.v = v;
		this.c = c;
		// op = objectPool.getInstance();
	}

	@Override
	public void actionPerformed(ActionEvent paramActionEvent) {
		// System.out.println(v.getComponentCount());
		// m.getP1().getScore();
		// System.out.println(m.getP1().getScore());
		// System.out.println(m.getP2().getScore());
		// Component [] c = v.getComponents();
		// for(int i=0;i<c.length;i++){
		// for(int j=0;j<c.length;j++){
		// if(i!=j && c[i] == c[j]){
		// System.out.println("a7a");
		// }
		// }
		// }
		// v.invalidate();
		// v.updateUI();
		// v.repaint();
		// v.requestFocus();
		Iterator shapes = c.getM().getPool().getIterator();
		for (; shapes.hasNext();) {
			Shape p = (Shape) shapes.next();

			if (p.getState().getState().equals(state.fall)) {
				if (p.getY() + 1 > c.getV().getHeight()) {
					shapes.remove();
				} else if (touch(p)) {

					p.state.setState(state.with_Player);
				} else
					p.setLocation(p.getX(), p.getY() + 1);
			}
		}
		if (count == 40) {
			count = 0;
			Shape s = c.getM().getPool().getFromPool();
			if (s.getState().getState().equals(state.notUsed)) {
				c.getV().add(s);
				s.setState(new state(state.fall));
				c.getM().getCk().add(s.saveStateToMemento());
			} else {
				s.setStateFromMemento(c.getM().getCk().get(0));
			}
		}
		count++;
		c.getM().updateScore();
		c.getV().updateScore(c.getM().getP1().getScore(), c.getM().getP2().getScore());
	}

	private boolean touch(Shape s) {
		if (!s.getState().getState().equals(state.fall))
			return false;
		player p1, p2;
		p1 = c.getM().getP1();
		p2 = c.getM().getP2();
		int success = 0;
		if (p1 != null
				&& (p1.containRight(s) || p1.containLeft(s))) {
			success += 1;

		}
		if (p2 != null
				&& (p2.containRight(s) || p2.containLeft(
						s))) {
			success += 2;
		}
		if (success == 3) {
			int luck = new Random().nextInt(2);
			if (luck == 0)
				p1.addShape(s);
			else
				p2.addShape(s);
		} else if (success == 1)
			p1.addShape(s);
		else if (success == 2)
			p2.addShape(s);

		if (success > 0)
			return true;
		return false;
	}
}
