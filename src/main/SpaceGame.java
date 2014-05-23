package main;
import java.awt.EventQueue;
import javax.swing.*;

public class SpaceGame {
	// Run the game!
	public static void main(String[] args){
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        try {
		EventQueue.invokeAndWait(MainMenu.createMenu());
		} catch (Exception e) 
		{System.out.println("Hello derp"); return;}
	}
}
