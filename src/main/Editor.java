package main;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class Editor extends JFrame
{
	JFrame frame;
	public Editor()
	{
		frame = new JFrame();
		frame.setSize(200, 200);
		frame.setLocation(600, 200);
		frame.setResizable(false);
		frame.setUndecorated(false);
		frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		frame.setVisible(true);
	}
}
