package main;
import java.awt.EventQueue;

public class SpaceGame {
	// Run the game!
	public static void main(String[] args){
		try {
		EventQueue.invokeAndWait(MainMenu.createMenu());
		} catch (Exception e) 
		{System.out.println("Hello derp"); return;}
	}
}
