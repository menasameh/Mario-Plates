package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import org.omg.CORBA.Bounds;
import org.omg.CORBA.ContextList;

import objects.Shape;
import players.player;

public class Game extends JPanel {

	private static final long serialVersionUID = 1L;
	// Shape p, x, x1, x2, x3;
	// player p1, p2;
//	serial s;
	JLabel p1Score;
	JLabel p2Score;
	JLabel barBG;
	JLabel counter;
	JLayeredPane bar;
//	JButton saveGame;
//	JButton backToMenu;
//	JButton loadGame;
//	Timer t;
	
////	scoreObserver so;
	private int floor = 70;
	private boolean running;

	public Game(int time) {
		setLayout(null);
		initialize(time);
		// // p = sf.getSape();
		// // x = sf.getSape();
		// // System.out.println("Size2");
		// p.setLocation(20, 20);
		// x.setLocation(40, 40);
		// keyListner kl = new keyListner(this);
		// addKeyListener(kl);

		// getInputMap().put(KeyStroke.getKeyStroke(
		// KeyEvent.VK_ENTER, 0),
		// "check");
		// getActionMap().put("check", new AbstractAction() {
		// public void actionPerformed(ActionEvent e) {
		// System.out.println("dddddd");
		// }
		// });
		// p.setSize(80, 20);
		// x.setVisible(true);
		// p.setVisible(true);
		// p.setIcon(new ImageIcon("img/shape1-color1.png"));
		// add(p);
		// add(x);
		// x.setText("dsg");
	}

	private void initialize(int time) {
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		bar = new JLayeredPane();
		bar.setBounds(0, 0,(int) dimension.getWidth(), 150);
//		bar.setOpaque(true);
		bar.setLayout(null);
		
		barBG = new JLabel();		
		ImageIcon ii = new ImageIcon();
		ii.setImage(new ImageIcon("res/barBG.png").getImage()
				.getScaledInstance((int)dimension.getWidth(), 150, 0));
		barBG.setIcon(ii);
		barBG.setBounds(0, 0,(int) dimension.getWidth(), 150);
		bar.add(barBG,1);
//		p1Score.setOpaque(true);
		
		counter = new JLabel(time+"");
		counter.setFont(new Font("arial", 0,20));
		counter.setBounds((int) dimension.getWidth()/2-50, 0, 50, 100);
		
		
		p1Score = new JLabel("Score1 : 0");
		p1Score.setFont(new Font("arial", 0,20));
		p1Score.setHorizontalTextPosition(JLabel.RIGHT);
		p1Score.setVerticalTextPosition(JLabel.CENTER);
//		p1Score.setBackground(Color.RED);
		ii = new ImageIcon();
		ii.setImage(new ImageIcon("res/redhead.png").getImage()
				.getScaledInstance(100, 100, 0));
		p1Score.setIcon(ii);
		p1Score.setBounds(0, 0, 250, 100);
//		p1Score.setOpaque(true);
				
		ii = new ImageIcon();
		ii.setImage(new ImageIcon("res/greenhead.png").getImage()
				.getScaledInstance(100, 100, 0));
		p2Score = new JLabel("Score2 : 0");
		p2Score.setHorizontalTextPosition(JLabel.LEFT);
		p2Score.setVerticalTextPosition(JLabel.CENTER);
		p2Score.setIcon(ii);
		p2Score.setBounds((int) dimension.getWidth()-200, 0, 250, 100);
		p2Score.setFont(new Font("arial", 0,20));
//		p2Score.setBackground(Color.GREEN);
//		p2Score.setOpaque(true);
//		JButton back;
//		JButton loadGame;
//		ii = new ImageIcon();
//		ii.setImage(new ImageIcon(player.class
//				.getResource("/img/back.png")).getImage()
//				.getScaledInstance(200, 120, 0));
//		backToMenu = new JButton("back");
//		backToMenu.setIcon(ii);
//		backToMenu.setOpaque(false);
//		backToMenu.setBorderPainted(false);
//		backToMenu.setContentAreaFilled(false);
//		backToMenu.setBackground(new Color(0,0,0,0));
//		backToMenu.setBounds(400, 25, 200, 120);
//		
//			
//		
//		ii = new ImageIcon();
//		ii.setImage(new ImageIcon(player.class
//				.getResource("/img/save.png")).getImage()
//				.getScaledInstance(100, 100, 0));
//		saveGame = new JButton("save game");
//		saveGame.setIcon(ii);
//		saveGame.setOpaque(false);
//		saveGame.setBorderPainted(false);
//		saveGame.setContentAreaFilled(false);
//		saveGame.setBounds(100, 50, 100, 100);
//		loadGame = new JButton("load game");
//		loadGame.setBounds(400, 50, 100, 30);
		
		
		
		
		add(bar);
		bar.add(p1Score,0);
		bar.add(p2Score,0);
		bar.add(counter,0);
//		bar.add(saveGame,0);
//		bar.add(backToMenu,0);
//		bar.add(loadGame,0);
		
		
//		actionListener al = new actionListener(this);
		
//		so = new scoreObserver();
		// playerFactory pf = playerFactory.getInstance();
		// p1 = pf.getPlayer(0);
		// p1.setObserver(so);
		// p2 = pf.getPlayer(1);
		// p2.setObserver(so);
		// p1 = new player(so);
		// p1.setLocation(0, 0);
		// // p1.setMargin(new Insets(10, 10, 10, 10));
		//
		// add(p1);
		// p2 = new player(so);
		// System.out.println(getHeight());

		// add(p1);
		// add(p2);
		setFocusable(true);
//		s = new serial(this);
		//
	}
	
	public void setListeners(ActionListener save ,ActionListener back/* , ActionListener load*/ ){
//		saveGame.addActionListener(save);
//		backToMenu.addActionListener(back);
//		loadGame.addActionListener(load);
	}
	
	
	public void addPlayers(player p1, player p2) {
		
		add(p1);
		add(p2);
//		setLoc(p1, p2);
	}

	public void setLoc(player p1, player p2) {
		// System.out.println( p1.getHeight());
		p1.setLocation(getParent().getWidth()  / 4, getParent().getHeight()
				- p1.getHeight() - floor);
		p2.setLocation(getParent().getWidth()*3/ 4,
				getParent().getHeight() - p2.getHeight() - floor);
	}

	// public player getP1() {
	// return p1;
	// }
	//
	// public void setP1(player p1) {
	// this.p1 = p1;
	// }
	//
	// public player getP2() {
	// return p2;
	// }
	//
	// public void setP2(player p2) {
	// this.p2 = p2;
	// }

	@Override
	public void paint(Graphics paramGraphics) {
		super.paint(paramGraphics);
//		System.out.println("d");
		if(running){
			requestFocus();	
		}		
	}

	public void updateScore(int score1 ,int score2) {
		p1Score.setText("Score 1 : "+score1);
		p2Score.setText("Score 2 : "+score2);
	}

	public void setTime(int i) {
		counter.setText(i+"");
	}

	public void endGame(int i) {
		if(i == 0){
			hideGame();
			return;
		}
		if(i != 3){	
			JOptionPane.showMessageDialog(null, "Player "+i+" Wins");
		}
		else{
			JOptionPane.showMessageDialog(null, "it's a draw");
		}
		hideGame();
	}

	public void hideGame() {
		removeAll();
		setVisible(false);
		running = false;
	}

	public void showGame() {
		running = true;
		add(bar,0);
		setVisible(true);
//		saveGame.setVisible(true);
//		loadGame.setVisible(true);
//		backToMenu.setVisible(true);
		bar.setVisible(true);
		barBG.setVisible(true);
		counter.setVisible(true);
		p1Score.setVisible(true);
		p2Score.setVisible(true);
	}

	public boolean isRunning() {
		return running;
	}
	
	public void addShapes(ArrayList<Shape> arr){
		for(Shape s : arr){
			add(s);
		}
	}

	public void setRunning(boolean b) {
		running = b;
	}

}
