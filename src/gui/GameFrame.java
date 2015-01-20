package gui;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.border.Border;

import objects.star;


public class GameFrame extends JFrame{


	private static final long serialVersionUID = 1L;
	JLayeredPane bg = null;
	Game view ; 
	JLabel p1Score;
	JLabel p2Score;
	JPanel bar;
	JLabel jl;
	
	public Game getView() {
		return  view;
	}

	public GameFrame (int time,Game view ){
		setup(time ,view);
	}
	private void setup(int time ,Game view  ) {
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		setSize(dimension.getSize());
		setLocation(0,0);
		setExtendedState(JFrame.MAXIMIZED_BOTH); 
		setUndecorated(true);
//		setVisible(true);
		setResizable(false);
		bg =new JLayeredPane();
		getContentPane().add(bg,BorderLayout.CENTER);
		jl = new JLabel(new ImageIcon("res/bg.jpg"));
		jl.setBounds(0,0,1366,768);
		jl.setOpaque(true);
		
//		bar = new JPanel();
//		bar.setBounds(0, 0,(int) dimension.getWidth(), (int) (dimension.getHeight()*0.125));
//		bar.setVisible(true);
//		bar.setOpaque(true);
//		
//		
//		p1Score = new JLabel("score1 : 0");
//		p1Score.setFont(new Font("arial", 0,20));
//		p1Score.setBackground(Color.RED);
//		p1Score.setBounds(0, 0, 100, 20);
//		p1Score.setVisible(true);
//		p1Score.setOpaque(true);
//		
//		p2Score = new JLabel("score2 : 0");
//		p2Score.setBounds((int) (dimension.getWidth()-100), 0, 100, 20);
//		p2Score.setFont(new Font("arial", 0,20));
//		p2Score.setBackground(Color.GREEN);
//		p2Score.setVisible(true);
//		p2Score.setOpaque(true);
				
		this.view = view;
		view.setSize(dimension.getSize());
		view.setOpaque(false);
		bg.add(jl,1);
		bg.add(view,0);
//		view.setVisible(true);		
//		bg.add(bar,0);
//		bar.add(p1Score);
//		bar.add(p2Score);
//		bg.add(p2Score,0);
//		bg.add(p1Score,0);
//		view.setLoc();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public void showGame() {
		setVisible(true);
		bg.setVisible(true);
		jl.setVisible(true);
		requestFocus();
		view.showGame();
	}

	public void hideGame() {
		view.hideGame();
		setVisible(false);
		bg.setVisible(false);
		jl.setVisible(false);
	}
	
//	public static void main(String[] args) {
//		GUI play = new GUI();
//		
//	}
}

//	@Override
//	public void paint(Graphics paramGraphics) {
//		// TODO Auto-generated method stub
//		super.paint(paramGraphics);
//		
//		if( && view != null){
//			view.requestFocus();
//			System.out.println("df");
//		}
//	}
//		setBounds(100, 100, 1000, 600);
//		bg.setOpaque(true);
//		bg.setBackground(Color.red);
//		new ImageIcon("")
//		jl.setBackground(Color.red);
//		jl.setSize(dimension.getSize());
//		jl.setLocation(0, 0);
//		System.out.println("yesS");
//		jl.setOpaque(true);
//		view.setBounds(getBounds());
//		System.out.println(view.getSize().height);
//		view.setLocation(0, 0);
//		JLabel jl = new JLabel(new ImageIcon(getClass().getResource("res/shape1-color0.png")));
//		jl.setBounds(50,50,200,200);
//		jl.setVisible(true);
//		jl.setOpaque(true);
//		jl.updateUI();
//		jl.setBackground(Color.red);
//		view.add(jl);
//		getContentPane().add(view,BorderLayout.CENTER);
//		System.out.println("frame: " + getHeight());
//		view.repaint();
//	Dimension dimension;
