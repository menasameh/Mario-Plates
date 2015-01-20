package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import players.player;

public class Splash extends JFrame  {
	
	private static final long serialVersionUID = 1L;

    public Splash() {
        setSize(500,400);
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - getHeight()) / 2);
        setLocation(x, y);
        setUndecorated(true);
        JLabel BG = new JLabel();
        BG.setBounds(0, 0, 500, 400);
        ImageIcon ii = new ImageIcon();
		ii.setImage(new ImageIcon("res/SPLASH.png").getImage()
				.getScaledInstance(500, 400, 0));
        BG.setIcon(ii);
        BG.setVisible(true);
        BG.setOpaque(false);
        add(BG);
        if(System.getProperty("os.name").matches("(?i)windows.*")){        	
        	setBackground(new Color(0, 0, 0, 0));
        }
    }
       
    
    public static void main (String args[]) {
    	Splash m = new Splash();
//    	GUI play =  new GUI();
    }

	public void showSplash() {
		 Thread t = new Thread(new Runnable() {
				@Override
				public void run() {
					setVisible(true);  
				}
			});
	    	t.run();
	        try {
	 		Thread.sleep(2000);
	 	} catch (InterruptedException e) {
	 	}
	        setVisible(false);
	    }
	
}