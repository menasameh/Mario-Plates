package players;

import objects.Shape;
import control.abstractFactory;


public class playerFactory extends abstractFactory{
	
	static playerFactory pf= null;
	
	private playerFactory(){
		
	}
	
	public static playerFactory getInstance(){
		if(pf == null){
			pf = new playerFactory();
		}
		return pf;
	}
	
	public player getPlayer(int type){
		player p = null;
		p = new player();
		p.setIcon(type);
		return p;
	}

	@Override
	public Shape getShape() {
		// TODO Auto-generated method stub
		return null;
	}

}
