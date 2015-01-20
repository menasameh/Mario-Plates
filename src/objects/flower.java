package objects;

import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class flower extends Shape implements Serializable {

	private static final long serialVersionUID = 1L;
	// private Polygon p ;
	private static LinkedList<ImageIcon> colors = new LinkedList<ImageIcon>();
	static final int width=30,height=40;
	public flower() {	
	}

	public void setColors() {
		colors = new LinkedList<ImageIcon>();
		for (int i = 0; i < 4; i++) {
			ImageIcon ii = new ImageIcon();
			ii.setImage(new ImageIcon("res/flower" + i + ".png").getImage()
					.getScaledInstance(width, height, 0));
			colors.add(ii);
		}
	}

	public flower(int color) {
		setParameters(color);
	}
	

	// public void draw(Graphics g) {
	// p =new Polygon(new int[]{x,x+40,x+30,x+10},new int []{y,y,y+40,y+40},4);
	// g.setColor(color);
	// g.fillPolygon(p);
	// }

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	@Override
	public void reset() {
		Random r = new Random();
		int c = r.nextInt(4);
		setColor(c);
		setVisible(true);
//		setIcon((ImageIcon) colors.get(c));
		setPic(c);
		setLocation(r.nextInt(1000), -1 * getHeight());
		state = new state(state.fall);
	}

	@Override
	public void setPic(int color2) {
		setIcon((ImageIcon) colors.get(color2));
	}

	@Override
	public void tryToAccess() {
		colors.get(1);
	}

	@Override
	public void setSize() {
		setSize(width, height);
	}

}
