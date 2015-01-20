package objects;

import java.io.Serializable;

public class state implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	private String state;
	public static final String notUsed = "da mesh mosta5dam :D";
	public static final String inPool = "5ra";
	public static final String with_Player = "da m3 player :D";
	public static final String fall = "da byo23 :D";
	
	
	public state(String s) {
		state = s;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return state;
	}
	
}
