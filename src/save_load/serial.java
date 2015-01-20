package save_load;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JFileChooser;

import players.player;
import control.controller;
import control.model;

public class serial {
	public static String noFile = "no file choosen";
	model m;
	controller c;
	
	public serial(model m, controller c) {
		this.m=m;
		this.c=c;
	}

	public File getFile(int i){
		JFileChooser fc = new JFileChooser();
		int ans;
		if(i == 0)
			 ans = fc.showOpenDialog(null);
		else
			 ans = fc.showSaveDialog(null);
		if(ans == JFileChooser.APPROVE_OPTION){
			return fc.getSelectedFile();
		}
		return null;
	}
	
	
	public void save() throws IOException {
		File f = getFile(1);
		if(f == null){
			throw new IOException(noFile);
		}
		if (!f.exists()) {
			f.createNewFile();
		}
		FileOutputStream fOut = new FileOutputStream(f);
		ObjectOutputStream out = new ObjectOutputStream(fOut);
		out.writeObject(m.getP1());
		out.writeObject(m.getP2());
		out.writeObject(c.getTime());
		out.close();
		fOut.close();

	}

	public player[] load() throws ClassNotFoundException, IOException {
		File f = getFile(0);
		if(f == null){
			throw new IOException(noFile);
		}
		player p1;
		player p2;
		player[] pl= new player[2];
		FileInputStream fIn = new FileInputStream(f);
		ObjectInputStream in = new ObjectInputStream(fIn);
		p1 = (player) in.readObject();
		m.setP1(p1);
		p2 = (player) in.readObject();
		m.setP2(p2);
		c.setTime((int) in.readObject());
		
		pl[0] = p1;
		pl[1] = p2;
		in.close();
		fIn.close();
		return pl;
	}

}
