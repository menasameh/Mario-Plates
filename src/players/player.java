package players;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.ImageIcon;

import objects.Shape;
import objects.objectPool;

public class player extends observer implements Serializable {

	private static final long serialVersionUID = 1L;
	int score;
	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	final static int height = 150, width = 150;
	ArrayList<Shape> right, left;
	int rightHeight;
	int leftHeight;

	private static LinkedList<ImageIcon> colors = new LinkedList<ImageIcon>();

	static {
		for (int i = 0; i < 2; i++) {
			ImageIcon ii = new ImageIcon();
			ii.setImage(new ImageIcon("res/player0-color" + i + ".png").getImage()
					.getScaledInstance(width, height, 0));
			colors.add(ii);
		}
	}

	public void setIcon(int type) {
		setIcon(colors.get(type));
	}

	public player(scoreObserver observer) {
		this.observer = observer;
		this.observer.attach(this);
//		System.out.println("dsafdasf");
		score = 0;
		right = new ArrayList<Shape>();
		left = new ArrayList<Shape>();
		rightHeight = 0;
		leftHeight = 0;
		// t = new Timer(20, this);
		// t.start();
		// TODO get a color
		setIcon((ImageIcon) colors.get(0));
		setSize(width, height);
	}

	public void setObserver(scoreObserver observer) {
		this.observer = observer;
		 this.observer.attach(this);
	}

	public void move(int dx) {
		for (Shape s : right) {
			s.setLocation(s.getX() + dx, s.getY());
		}
		for (Shape s : left) {
			s.setLocation(s.getX() + dx, s.getY());
		}
	}

	public player() {
//		 this.observer.attach(this);
		score = 0;
		right = new ArrayList<Shape>();
		left = new ArrayList<Shape>();
		rightHeight = 0;
		leftHeight = 0;
		// t = new Timer(20, this);
		// t.start();
		// TODO get a color
		setIcon((ImageIcon) colors.get(0));
		setSize(width, height);
	}

	public void addToRigth(Shape s) {
		updateShape(s);
		right.add(s);
		rightHeight += s.getHeight();
	}

	public void addToLeft(Shape s) {
		updateShape(s);
		left.add(s);
		leftHeight += s.getHeight();
	}

	private void updateShape(Shape s) {
		if (containLeft(s))
			s.setLocation(getX(), getY() - leftHeight - s.getHeight());
		else if (containRight(s))
			s.setLocation(getX() + 30 + 85,
					getY() - rightHeight - s.getHeight());
	}

	@Override
	public void update() {
//		System.out.println(right.size() +"  "+left.size());
		if (right.size() > 2) {
			int last = right.size() - 1;
			if (right.get(last).getColor() == right.get(last - 1).getColor()
					&& right.get(last).getColor() == right.get(last - 2)
							.getColor()) {
				int lostHeight =0;
				objectPool pool = objectPool.getInstance();
//				System.out.println();
				for(int i=0;i<3;i++){
					Shape ss = right.get(last - i);
					lostHeight += ss.getHeight();
					ss.setVisible(false);
					pool.insertIntoPool(ss);
					right.remove(ss);
				}
				rightHeight -= lostHeight;
				score++;
			}
		}
		if (left.size() > 2) {
			int last = left.size() - 1;
			if (left.get(last).getColor() == left.get(last - 1).getColor()
					&& left.get(last).getColor() == left.get(last - 2)
							.getColor()) {
				int lostHeight =0;
				objectPool pool = objectPool.getInstance();
				for(int i=0;i<3;i++){
					Shape ss = left.get(last - i);
					lostHeight += ss.getHeight();
					ss.setVisible(false);
					pool.insertIntoPool(ss);
					left.remove(ss);
				}
				score++;
				leftHeight -= lostHeight;
			}
		}
	}

	public void addShape(Shape s) {
		if (containLeft(s))
			addToLeft(s);
		else
			addToRigth(s);
	}

	public boolean containLeft(Shape s) {
		int x,y;
		x = s.getX();
		y = s.getY()+s.getHeight();
		int myx = getX();
		int myy = getY();
//		y += 30;	
		if ((Math.abs(x - myx) <= s.getWidth()/2) || (Math.abs(x - myx - 30) <= s.getWidth()/2)) {
			if (myy - y - leftHeight == 0) {
				return true;
			}
		}
		return false;
	}

	public boolean containRight(Shape s) {
		int myx = getX();
		int myy = getY();
		int x,y;
		x = s.getX();
		y = s.getY()+s.getHeight();
//		y += 30;
		if ((Math.abs(x - myx - 30 - 85) <= s.getWidth()/2 || Math.abs(x - myx - 30 - 85
				- 30) <= s.getWidth()/2)) {
			if (myy - y - rightHeight == 0) {
				return true;
			}
		}
		return false;
	}

	public ArrayList<Shape> getRight() {
		return right;
	}

	public void setRight(ArrayList<Shape> right) {
		this.right = right;
	}

	public ArrayList<Shape> getLeft() {
		return left;
	}

	public void setLeft(ArrayList<Shape> left) {
		this.left = left;
	}
}
