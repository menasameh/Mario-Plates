package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;

import listeners.StartGame;

public class Menu extends JFrame {

	private static final long serialVersionUID = 1L;
	JLayeredPane bg = null;
	JButton newGame;
	JButton LoadGame;
	JButton QuitGame;
	

	public Menu() {
		setup();
	}

	private void setup() {
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds((int) (dimension.getWidth()-300)/2, (int) (dimension.getHeight()-300)/2, 300, 300);
		setBackground(Color.white);
		bg = new JLayeredPane();
		bg.setVisible(true);
		newGame = new JButton("new Game");
		
		newGame.setBounds(75, 50, 150, 30);
		LoadGame = new JButton("load Game");
		LoadGame.setBounds(75, 100, 150, 30);
		QuitGame= new JButton("quit");
		QuitGame.setBounds(75, 150, 150, 30);
		add(newGame);
		add(LoadGame);
		add(QuitGame);
		getContentPane().add(bg, BorderLayout.CENTER);
		
	}
	public void showMenu(){
		setVisible(true);
		requestFocus();
		newGame.setVisible(true);
		LoadGame.setVisible(true);
		QuitGame.setVisible(true);
	}
	
	public void hideMenu(){
		setVisible(false);
	}
	
	public void setListeners(ActionListener New ,ActionListener load , ActionListener quit ){
		newGame.addActionListener(New);
		LoadGame.addActionListener(load);
		QuitGame.addActionListener(quit);
	}
	
//	public static void main(String[] args) {
//		Menu m = new Menu();
//	}
	
}
