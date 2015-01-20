package control;

import objects.Shape;
import players.player;

public abstract class abstractFactory {
	public abstract player getPlayer(int type);
	public abstract Shape getShape();
}
