package main;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

public class Icon extends JPanel implements MouseListener
{
	JPanel icon = new JPanel();
	private Color color;
	public int width;
	public int height;
	//private Graphics Graphics;
	
	public Icon(Color color, int width, int height)
	{
		this.color = color;
		this.width = width;
		this.height = height;
		addMouseListener(this);
		//icon.setBackground(Color.black);
		//icon.setPreferredSize(new Dimension(this.width, this.height));
	}
	
	public void paint(Graphics g)
	{
		g.setColor(Color.green);
		g.setColor(this.color);
		g.fillOval(5, 5, this.width - 10, this.height - 10);
	}

	public void mouseClicked(MouseEvent e) 
	{
		new Editor();
	}

	public void mouseEntered(MouseEvent e) 
	{
		//this.color = Color.white;
		//repaint();
		System.out.println(this.color);
	}

	public void mouseExited(MouseEvent e) 
	{

	}

	public void mousePressed(MouseEvent e) 
	{

	}

	public void mouseReleased(MouseEvent e) 
	{

	}
}
