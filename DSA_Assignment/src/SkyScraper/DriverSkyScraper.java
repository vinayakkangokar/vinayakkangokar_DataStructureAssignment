package SkyScraper;

import java.util.Scanner;

public class DriverSkyScraper {
	public static void main(String[] args) {

		SkyScraper skyscraper = new SkyScraper();
		Scanner keyboardInput = new Scanner(System.in);

		System.out.println("Enter the total number of floors in the building");
		
		int numberOfFloors = keyboardInput.nextInt();
		int floorSizeEntered = 0;

		for (int i=0; i<numberOfFloors; i++) {
			int entrydays = i+1;
			
			System.out.println("enter the floor size given on day " + entrydays );
			
			do {
				floorSizeEntered = keyboardInput.nextInt();
			} while (floorSizeEntered <= 0);

			skyscraper.addToStack(entrydays, floorSizeEntered);
		}
		
		skyscraper.floorAssembly();
		
		keyboardInput.close();
	}
	
}
