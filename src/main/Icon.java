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
	private int width;
	private int height;
	int id;
	boolean active;
	Editor edit;
	
	//private Graphics Graphics;
	
	public Icon(Color color, int width, int height, int id)
	{
		this.color = color;
		this.width = width;
		this.height = height;
		this.id = id;
		this.active = false;
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
		edit = new Editor(this);
		this.active = true;
		System.out.println(this.id + " is active!");
	}

	public void mouseEntered(MouseEvent e) 
	{
		//repaint();
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
	
	public int getWidth()
	{
		return this.width;
	}
	
	public int getHeight()
	{
		return this.height;
	}
	
	public Color getColor()
	{
		return this.color;
	}
	
	public void setColor(Color c)
	{
		this.color = c;
	}
	
	public int getId()
	{
		return this.id;
	}
}
