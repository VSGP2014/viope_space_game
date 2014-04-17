package viope.space.game;

import java.awt.Color;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		String mainText = Costants.mainText;		
		Scanner input = new Scanner(System.in);
		System.out.print(mainText);
		int choice = Integer.parseInt(input.nextLine());
		switch (choice) {
		case 1:
			// 1. Game <- will split somewhere if needed
			SpaceShip ship;
			Color shipColor=new Color(0, 0, 0);		
			System.out.print("Give the amount of energy used to launch the ship: ");
			int energy=Integer.parseInt(input.nextLine());
			ship=new SpaceShip("Spaceship", 100, 25, 25, shipColor, energy);
			System.out.print("Will work on it later, sorry :P\n");
		default:
			System.out.print("Exit...");
			return;
		}
	}
}
