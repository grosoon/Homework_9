import java.awt.Point;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TextAdventure {
	
	private static Scanner input;
	private static String playerName;
	private static Map<Point, Room> mansionMap;
	
	public static void main (String[] args) {
		input = new Scanner(System.in);
		mansionMap = makeMap();
		//Welcome
		System.out.println("Please enter your name.");
		playerName = input.nextLine();
		System.out.printf("Hello %s, and welcome to [insert welcome here].\n", playerName);
		System.out.println("Your goal? To [insert goal here].");
		
		//Set up initial gamestate.
		
		//More entrance text.
		
		//While loop describing game logic
		

		
		//Cleanup
		lose();
	}
	
	private static void lose() {
		System.out.println("You have lost!");
		System.out.printf("Fare thee well, %s, we will not forget you!\n", playerName);
		input.close();
	}
	
	private static void win() {
		System.out.printf("Congratulations, %s, you have won!\n", playerName);
		input.close();
		System.exit(0);
	}
	
	private static Map<Point, Room> makeMap() {
		Map<Point, Room> someMap = new HashMap<Point, Room>();
		for (int x = 0; x < 5; x++) {
			for (int y = 0; y < 5; y ++) {
				Point coord = new Point(x, y);
				Room someRoom = new Room("Test");
				someMap.put(coord, someRoom);
			}
		}
		return someMap;
	}
	
}
