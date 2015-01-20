package objects;

import java.util.ArrayList;
import java.util.Random;

import players.player;
import save_load.classLoader;
import control.abstractFactory;

public class ShapeFactory extends abstractFactory {

	static ShapeFactory sf = null;
	private ArrayList<Class<?>> shapes;

	private ShapeFactory() {
		try {
			shapes = classLoader.getShapes();
//			System.out.println(shapes.get(0).getName() +" " + shapes.get(1).getName());
//			
			for(int i=0;i<shapes.size();i++){	
				Shape s1 = (Shape) shapes.get(i).newInstance();
				s1.setColors();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static ShapeFactory getInstance() {
		if (sf == null) {
			sf = new ShapeFactory();
		}
		return sf;
	}

	public Shape getShape() {
		Shape newShape = null;
		Random r = new Random();
		int type = r.nextInt(shapes.size());
		int color = r.nextInt(4);
		try {
			if (type == 0) {
				newShape = (Shape) shapes.get(0).newInstance();
			} else if (type == 1) {
				newShape = (Shape) shapes.get(1).newInstance();
			}
			
			else if(type == 2){
				newShape = (Shape) shapes.get(2).newInstance();
			}
			newShape.setParameters(color);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return newShape;
	}

	@Override
	public player getPlayer(int type) {
		// TODO Auto-generated method stub
		return null;
	}

}
