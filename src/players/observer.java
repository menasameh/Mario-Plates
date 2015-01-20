package players;

import java.io.Serializable;

import javax.swing.JLabel;

public abstract class observer extends JLabel implements Serializable{
	
	private static final long serialVersionUID = 1L;

	public scoreObserver observer;
	public abstract void update();
	
//	public abstract void setObserver(observer o);

}
