package viope.space.game;

import java.awt.Color;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		SpaceShip ship;
		Scanner input=new Scanner(System.in);
		
		Color shipColor=new Color(0, 0, 0);		
		System.out.print("Give the amount of energy used to launch the ship: ");
		int energy=Integer.parseInt(input.nextLine());
		ship=new SpaceShip(100, 25, 25, shipColor, energy);
	}
}
