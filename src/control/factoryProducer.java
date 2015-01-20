package control;

import objects.Shape;
import objects.ShapeFactory;
import players.playerFactory;

public class factoryProducer {
	
	public static abstractFactory getFactory(String type){
		if(type.equalsIgnoreCase("player"))
			return playerFactory.getInstance();
		else if(type.equalsIgnoreCase("shape"))
			return ShapeFactory.getInstance();
		return null;
	}

}
