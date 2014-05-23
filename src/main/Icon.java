package main;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.InputEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Icon extends JPanel implements MouseListener
{
	JPanel icon = new JPanel();
	private Image image;
	private Color color;
	private int width;
	private int height;
	int id;
	boolean active;
	Editor edit;
	
	//private Graphics Graphics;
	
	public Icon(Color color, Image image, int width, int height, int id)
	{
		this.color = color;
		this.image = image;
		this.width = width;
		this.height = height;
		this.id = id;
		this.active = false;
		addMouseListener(this);
	}
	
	public void paint(Graphics g)
	{
		/*g.setColor(Color.green);
		g.setColor(this.color);
		g.fillOval(5, 5, this.width - 10, this.height - 10);*/
		
		g.drawImage(this.image, 0, 0, null);
		g.setColor(this.color);
		g.fillRect(0, 10, 10, 10);
	}

	public void mouseClicked(MouseEvent e) 
	{
		//Single-click left
		if(e.getClickCount() == 1 && !e.isConsumed() && e.getModifiers() != MouseEvent.BUTTON3_MASK)
		{
			Creator.start = SolarSystem.body[this.id];
			Creator.startBody.setText("Start: " + Creator.start.getName());
		}
		
		//Single-click right
		if(e.getModifiers() == MouseEvent.BUTTON3_MASK)
		{
			Creator.end = SolarSystem.body[this.id];
			Creator.endBody.setText("End: " + Creator.end.getName());
		}
		
		//Shift-left click
		if(e.getClickCount() == 1 && e.isShiftDown())
		{
			edit = new Editor(this);
			this.active = true;
			System.out.println(this.id + " is active!");
		}
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
