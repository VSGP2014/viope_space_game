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
			SolarSystem solarSystem=new SolarSystem();
			SpaceShip ship;
			Color shipColor=new Color(0, 0, 0);		
			System.out.print("Give the amount of energy used to launch the ship: ");
			int energy = Integer.parseInt(input.nextLine());
			ship = new SpaceShip("Spaceship", 100, 25, 25, shipColor, energy, 100);
			System.out.println("Choose the planet you wish to launch from: ");
			for (int i = 0; i < solarSystem.getPlanets().length; i++)
				if(solarSystem.getPlanets()[i] != null)
					System.out.println(i+": "+solarSystem.getPlanets()[i]);
			int planetChoice=(Integer.parseInt(input.nextLine())-1);
			ship.setLaunchPos(solarSystem.getPlanets()[planetChoice].getX(), solarSystem.getPlanets()[planetChoice].getY());
		default:
			System.out.print("Exit...");
			input.close();
			return;
		}		
	}
}
