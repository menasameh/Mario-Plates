package objects;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.Random;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import control.abstractFactory;

public abstract class Shape extends JLabel implements Serializable {

	private static final long serialVersionUID = 1L;
	protected int color;
	public state state;
	
	// public LinkedList<ImageIcon> colors;

	// static{
	// colors = new LinkedList<ImageIcon>();
	// }

	public state getState() {
		return state;
	}

	public void setState(state state) {
		this.state = state;
	}

	public memento saveStateToMemento() {
		return new memento(state.getState());
	}

	public void setStateFromMemento(memento memento) {
		state.setState(memento.getState());
	}

	public Shape() {
		// TODO Auto-generated constructor stub
	}

	public void setParameters(int color) {
		setColor(color);
		// setIcon((ImageIcon) colors.get(color));
		setPic(color);
		setSize();
		Random r = new Random();
		setLocation(r.nextInt(1000), -1 * getHeight());
		state = new state(state.notUsed);
		
		setVisible(true);
	}

	public abstract void setSize();
	
	public abstract void setPic(int color2);

	public Shape(int color) {
		// setHorizontalTextPosition(JLabel.CENTER);
		// setVerticalTextPosition(JLabel.BOTTOM);
		this.color = color;
	}

	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}

	public abstract void setColors();

	// public abstract void draw(Graphics g);
	public abstract void reset();

	public abstract void tryToAccess();

}
