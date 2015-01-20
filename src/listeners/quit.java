package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import gui.View;

public class quit implements ActionListener{
//	View v;
	 public quit() {
//		this.v = v;
	 }
	@Override
	public void actionPerformed(ActionEvent e) {
		int ans = JOptionPane.showConfirmDialog(null, "are you sure you want to exit MARIO PLATES™ ?","are you sure",JOptionPane.YES_NO_OPTION);
		if(ans == JOptionPane.YES_OPTION){			
			System.exit(0);
		}
	}
}
