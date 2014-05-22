package main;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class MainMenu implements ActionListener{
	//private static SpaceGUI spaceGUI;
	private JFrame frame = new JFrame("SpaceGame");
	JFrame scoreFrame= new JFrame("Scores");
	JFrame aboutFrame= new JFrame("About");

	public MainMenu(){
		//JFrame frame = new JFrame("SpaceGame");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setPreferredSize(new Dimension(800,800));
		
		//START BUTTON
		BufferedImage startIcon = null;
		try{
			startIcon = ImageIO.read(getClass().getResource("start_button.png"));
		}
		catch (IOException ex) {
        	System.out.println("Herp derp no image");
        }
		JButton start= new JButton(new ImageIcon(startIcon));
		Font font= new Font("Arial", 0, 32);
		start.setFont(font);
		start.setSize(150, 50);
		start.setLocation((frame.getPreferredSize().width/2)-(start.getSize().width/2), 300);
		start.setBorder(BorderFactory.createEmptyBorder());
		start.setContentAreaFilled(false);
		BufferedImage startRoll = null;
		try{
			startRoll = ImageIO.read(getClass().getResource("start_button_highlighted.png"));
		}
		catch (IOException ex){
			System.out.println("Herp derp no image");
		}
		Icon startRollIcon = new ImageIcon(startRoll);
	    start.setRolloverIcon(startRollIcon);
	    BufferedImage startPress = null;
	    try{
	    	startPress = ImageIO.read(getClass().getResource("start_button_inverted.png"));
	    }
	    catch (IOException ex){
			System.out.println("Herp derp no image");
		}
	    Icon pressStartIcon = new ImageIcon(startPress);
	    start.setPressedIcon(pressStartIcon);
		start.setActionCommand("Start");
		start.addActionListener(this);
	    frame.getContentPane().add(start);
		
		//SCORES BUTTON
	    BufferedImage scoresIcon = null;
		try{
			scoresIcon = ImageIO.read(getClass().getResource("scores_button.png"));
		}
		catch (IOException ex) {
        	System.out.println("Herp derp no image");
        }
		JButton scores= new JButton(new ImageIcon(scoresIcon));
		scores.setSize(150,50);
		scores.setFont(font);		
		scores.setLocation((frame.getPreferredSize().width/2)-(scores.getSize().width/2), (start.getLocation().y+start.getSize().height));
		scores.setBorder(BorderFactory.createEmptyBorder());
		scores.setContentAreaFilled(false);
		scores.setActionCommand("Scores");
		scores.addActionListener(this);
		BufferedImage scoresRoll = null;
		try{
			scoresRoll = ImageIO.read(getClass().getResource("scores_button_highlighted.png"));
		}
		catch (IOException ex){
			System.out.println("Herp derp no image");
		}
		Icon scoresRollIcon = new ImageIcon(scoresRoll);
		scores.setRolloverIcon(scoresRollIcon);
	    BufferedImage scoresPress = null;
	    try{
	    	scoresPress = ImageIO.read(getClass().getResource("scores_button_inverted.png"));
	    }
	    catch (IOException ex){
			System.out.println("Herp derp no image");
		}
	    Icon pressScoresIcon = new ImageIcon(scoresPress);
	    scores.setPressedIcon(pressScoresIcon);
	    frame.getContentPane().add(scores);
		
		//ABOUT BUTTON
	    BufferedImage aboutIcon = null;
		try{
			aboutIcon = ImageIO.read(getClass().getResource("about_button.png"));
		}
		catch (IOException ex) {
        	System.out.println("Herp derp no image");
        }
		JButton about = new JButton(new ImageIcon(aboutIcon));
		about.setFont(font);
		about.setSize(150,50);
		about.setLocation((frame.getPreferredSize().width/2)-(about.getSize().width/2), (start.getLocation().y+start.getSize().height+start.getSize().height));
		about.setBorder(BorderFactory.createEmptyBorder());
		about.setContentAreaFilled(false);
		about.setActionCommand("About");
		about.addActionListener(this);
		BufferedImage aboutRoll = null;
		try{
			aboutRoll = ImageIO.read(getClass().getResource("about_button_highlighted.png"));
		}
		catch (IOException ex){
			System.out.println("Herp derp no image");
		}
		Icon aboutRollIcon = new ImageIcon(aboutRoll);
		about.setRolloverIcon(aboutRollIcon);
	    BufferedImage aboutPress = null;
	    try{
	    	aboutPress = ImageIO.read(getClass().getResource("about_button_inverted.png"));
	    }
	    catch (IOException ex){
			System.out.println("Herp derp no image");
		}
	    Icon pressAboutIcon = new ImageIcon(aboutPress);
	    about.setPressedIcon(pressAboutIcon);
	    frame.getContentPane().add(about);
		
		//QUIT BUTTON
	    BufferedImage quitIcon = null;
		try{
			quitIcon = ImageIO.read(getClass().getResource("exit_button.png"));
		}
		catch (IOException ex) {
        	System.out.println("Herp derp no image");
        }
		JButton quit = new JButton(new ImageIcon(quitIcon));
		quit.setFont(font);
		quit.setSize(150,50);
		quit.setLocation((frame.getPreferredSize().width/2)-(quit.getSize().width/2), (start.getLocation().y+start.getSize().height+start.getSize().height+start.getSize().height));
		quit.setBorder(BorderFactory.createEmptyBorder());
		quit.setContentAreaFilled(false);
		quit.setActionCommand("Quit");
		quit.addActionListener(this);
		BufferedImage quitRoll = null;
		try{
			quitRoll = ImageIO.read(getClass().getResource("exit_button_highlighted.png"));
		}
		catch (IOException ex){
			System.out.println("Herp derp no image");
		}
		Icon quitRollIcon = new ImageIcon(quitRoll);
		quit.setRolloverIcon(quitRollIcon);
	    BufferedImage quitPress = null;
	    try{
	    	quitPress = ImageIO.read(getClass().getResource("exit_button_inverted.png"));
	    }
	    catch (IOException ex){
			System.out.println("Herp derp no image");
		}
	    Icon pressQuitIcon = new ImageIcon(quitPress);
	    quit.setPressedIcon(pressQuitIcon);
	    frame.getContentPane().add(quit); 
		
		BufferedImage backGround=null;
	       try {                
	           backGround = ImageIO.read(getClass().getResource("background.jpg"));
	        } catch (IOException ex) {
	        	System.out.println("Herp derp no background");
	        }
	    
	    
	    JLabel picLabel = new JLabel(new ImageIcon(backGround));
	    picLabel.setLocation(0,0);
	    picLabel.setSize(frame.getPreferredSize());


	    frame.getContentPane().add(picLabel);		
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		frame.pack();
		frame.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		String command=arg0.getActionCommand();
		switch (command)
		{
			case "Quit" :				
				System.exit(0);
				break;
			case "Start" :		
				frame.dispose();
				new Creator().addKeyListener(new KeyAdapter() {
					
					public void keyTyped(KeyEvent e) 
					{
						System.out.println("Anything");
					}
					
					public void keyReleased(KeyEvent e) 
					{

					}
					
					public void keyPressed(KeyEvent e) 
					{
						if (e.getKeyCode() == KeyEvent.VK_A)
						{
							System.out.println("Lollissimo");
						}
					}
				});
				//frame.dispose();
				//SpaceGame.StartGame();				
				break;
			case "Scores" :
				initializeScores();
				break;
			case "About" :
				initializeAbout();
				break;
			case "ScoresBack" :
				scoreFrame.dispose();
				break;
			case "AboutBack" :
				aboutFrame.dispose();
				break;
		}
	}
	public static Runnable createMenu(){
		return new Runnable(){
					public void run(){
						new MainMenu();
					}
		};
	}
	public void initializeScores()
	{		
		scoreFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		scoreFrame.setPreferredSize(new Dimension(800,800));		
		JLabel player = new JLabel("Player1: 103");
		player.setLocation(100, 50);
		player.setSize(400, 50);
		Font font=new Font("Arial",0,22);
		player.setFont(font);
		JButton back=new JButton("Back");
		back.setSize(150,50);
		back.setLocation(250,700);
		back.addActionListener(this);
		back.setActionCommand("ScoresBack");
		scoreFrame.getContentPane().add(player);
		scoreFrame.getContentPane().add(back);
		scoreFrame.getContentPane().setLayout(null);
		scoreFrame.setResizable(false);
		scoreFrame.pack();
		scoreFrame.setVisible(true);
	}
	public void initializeAbout()
	{
		aboutFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		aboutFrame.setPreferredSize(new Dimension(800,800));
		JButton back=new JButton("Back");
		back.setSize(150,50);
		back.setLocation(250,700);
		back.addActionListener(this);
		back.setActionCommand("AboutBack");
		JLabel info=new JLabel("Balh blah blah...");
		info.setLocation(150,100);
		info.setSize(250,100);
		aboutFrame.getContentPane().add(info);
		aboutFrame.getContentPane().add(back);
		aboutFrame.getContentPane().setLayout(null);
		aboutFrame.setResizable(false);
		aboutFrame.pack();
		aboutFrame.setVisible(true);
	}
}
