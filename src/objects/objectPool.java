package objects;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

import control.abstractFactory;
import control.factoryProducer;

public class objectPool implements Container, Serializable {

	private ArrayList<Shape> locked, unlocked;
	private static objectPool pool = null;
//	private careTaker ck ;

	public static objectPool getInstance() {
		if (pool == null) {
			pool = new objectPool();
		}
		return pool;
	}

	private objectPool() {
		locked = new ArrayList<Shape>();
		unlocked = new ArrayList<Shape>();
//		ck = new careTaker();
	}

	public Shape getFromPool() {
		Shape s;
		abstractFactory factory = factoryProducer.getFactory("shape");
		if (unlocked.size() > 0) {
			s = unlocked.get(0);
			unlocked.remove(s);
			try {
				s.tryToAccess();
			} catch (Exception e) {
				s.setColors();
			}
			s.reset();
			locked.add(s);
//			s.setState(new state(state.fall));
			// System.out.println("acac");
//			s.setStateFromMemento(ck.get(0));
			return s;
		}
		s = factory.getShape();
		locked.add(s);
		return s;

	}

	public void insertIntoPool(Shape s) {
		s.setState(new state(state.inPool));
		unlocked.add(s);
		locked.remove(s);
	}

	public void addShapes(ArrayList<Shape> arr) {
		for (Shape s : arr) {
			s.setState(new state(state.with_Player));
			locked.add(s);
		}
	}

	@Override
	public Iterator getIterator() {
		return locked.iterator();
	}

	public void clearPool() {
		locked = new ArrayList<Shape>();
		unlocked = new ArrayList<Shape>();
	}

	public ArrayList<Shape> getLocked() {
		return locked;
	}

	public void setLocked(ArrayList<Shape> locked) {
		this.locked = locked;
	}
}