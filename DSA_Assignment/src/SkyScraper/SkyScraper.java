package SkyScraper;

import java.util.*;

public class SkyScraper {
		
		Stack <Integer> floorSizes = new Stack<>();
		Stack <Integer> deliveryDays = new Stack<>();
		
		LinkedList <String> assembleFloors = new LinkedList<>();
		LinkedList <Integer> assembleDays = new LinkedList<>();

		void addToStack(int day, int size) {
			floorSizes.push(size);
			deliveryDays.push(day);
		}

		void printStack() {
			System.out.println(floorSizes);
			System.out.println(deliveryDays);
		}

		void sortStack() {
			
			Stack <Integer> sortedFloors = new Stack<>();
			Stack <Integer> sortedDays = new Stack<>();
			
			while(!floorSizes.isEmpty()) {
				int tempFloor = floorSizes.pop();
				int tempDay = deliveryDays.pop();
				
				while(!sortedFloors.isEmpty() && sortedFloors.peek() > tempFloor) {
					floorSizes.push(sortedFloors.pop());
					deliveryDays.push(sortedDays.pop());
				}
				
				sortedFloors.push(tempFloor);
				sortedDays.push(tempDay);
			}
			
			floorSizes = sortedFloors;
			deliveryDays = sortedDays;
		}

		void addToLinkList(int day, String floors) {
			
			if(!assembleDays.isEmpty() && assembleDays.peekLast() == day) {
				assembleDays.pollLast();
				assembleFloors.pollLast();
			}
			assembleFloors.add(floors);
			assembleDays.add(day);
		}

		void floorAssembly() {
			
			sortStack(); 
			
			String floors="";
			int delday = 0;	
			int floorInDay = 0;
			int floorSize = 0;

			while (!floorSizes.isEmpty()) {
				floorSize = floorSizes.pop();
				delday = deliveryDays.pop();
				
				if (floorInDay == 0 || delday > floorInDay) {
					floors = "";
					floorInDay = delday;
				}
				
				floors += floorSize + " "; 
				
				addToLinkList(floorInDay, floors);
			}
			
			printFloorConstruction();
		}

		void printFloorConstruction() {
			int day = 1;

			System.out.println("\nThe order of construction is as follows : ");

			while (!assembleDays.isEmpty()) {
				System.out.println("\nDay : " + day);
				if (assembleDays.peekFirst() == day) {
					System.out.println(assembleFloors.pollFirst());
					assembleDays.removeFirst();
				}
				day++;
			}
		}
}
