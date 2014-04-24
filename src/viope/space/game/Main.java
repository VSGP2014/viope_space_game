package viope.space.game;

import java.awt.Color;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		String mainText = Costants.mainText;		
		Scanner input = new Scanner(System.in);
		boolean exiting = false;
		while(!exiting) {
		System.out.print(mainText);
		int choice = Integer.parseInt(input.nextLine());
		switch (choice) {
			case 0:
				exiting = true;
				break;
			case 1:
				// 1. Game <- will split somewhere if needed
				SolarSystem solarSystem=new SolarSystem();
				SpaceShip ship;
				Color shipColor=new Color(0, 0, 0);		
				System.out.print("Give the amount of energy used to launch the ship: ");
				int energy = Integer.parseInt(input.nextLine());
				ship = new SpaceShip("Spaceship", 100, 25, 25, shipColor, energy, 100);
				System.out.println("Choose the planet you wish to launch from: ");
				for (int i = 0; i < SolarSystem.planets.length ; i++)
					if(SolarSystem.planets[i] != null)
						System.out.println(i+": "+SolarSystem.planets[i]);
				int planetChoice=(Integer.parseInt(input.nextLine()));
				ship.setLaunchPos(SolarSystem.planets[planetChoice].getX(), SolarSystem.planets[planetChoice].getY());
				System.out.println("Choose the direction launch ");
				float dir = Float.parseFloat(input.nextLine()); 
				int a;
				ship.launch(dir);
				while((a=ship.situation())==0)
				 	ship.update();
				System.out.println(Costants.res[a]); //print the result

				break;
			default:
				System.out.println(" - Uops, wrong choice! -");
			}
		// Exit
		input.close();
		}
	}
}
