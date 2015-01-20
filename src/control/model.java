package control;

import objects.careTaker;
import objects.objectPool;
import players.player;
import players.playerFactory;
import players.scoreObserver;
import save_load.serial;

public class model {
	
	player p1,p2;
	scoreObserver observer;
	objectPool pool;
	abstractFactory pf ;
	serial s;
	careTaker ck;
	
	public model() {
		observer = new scoreObserver();
		pool = objectPool.getInstance();
		pf = factoryProducer.getFactory("player");
		p1 = pf.getPlayer(0);
		p1.setObserver(observer);
		p2 = pf.getPlayer(1);
		p2.setObserver(observer);
		ck = new careTaker();
	}


	public player getP1() {
		return p1;
	}

	public void setP1(player p1) {
		this.p1 = p1;
	}

	public player getP2() {
		return p2;
	}

	public void setP2(player p2) {
		this.p2 = p2;
	}

	public scoreObserver getObserver() {
		return observer;
	}

	public careTaker getCk() {
		return ck;
	}


	public void setCk(careTaker ck) {
		this.ck = ck;
	}


	public void setObserver(scoreObserver observer) {
		this.observer = observer;
	}

	public objectPool getPool() {
		return pool;
	}

	public void setPool(objectPool pool) {
		this.pool = pool;
	}


	public void setPf(playerFactory pf) {
		this.pf = pf;
	}
	
	public void updateScore(){
		observer.notifyAllObservers();
	}
	
	public void clearData(){
		pool.clearPool();
		observer = new scoreObserver();
		p1 = pf.getPlayer(0);
		p1.setObserver(observer);
		p2 = pf.getPlayer(1);
		p2.setObserver(observer);
		ck = new careTaker();
	}
	
	
	
	
	
	

}
