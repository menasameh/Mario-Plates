package players;

import java.io.Serializable;
import java.util.ArrayList;

public class scoreObserver implements Serializable{

	private ArrayList<observer> observers = new ArrayList<observer>();

	public void attach(observer o) {
////		System.out.println("dddd");
		observers.add(o);
	}

	public void notifyAllObservers() {
		for (observer o : observers) {
//			System.out.println("d5l");
			o.update();
		}
	}

}
