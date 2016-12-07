import java.awt.Point;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class TextAdventure {
	
	private static Scanner input;
	private static String playerName;
	private static Map<Point, Room> mansionMap;
	private static final int MANSIONSIZE = 10;
	private static final String[] ROOMNAMES = {"dining room", "bathroom", "bedroom", "guest bedroom"}; 
	
	public static void main (String[] args) {
		/*
		 * This sets up the initial gamestate.
		 */
		int turns = 0;
		Scanner input = new Scanner(System.in);
		mansionMap = makeMap(MANSIONSIZE);
		Player pc = new Player();
		/*
		 * This welcomes the player to their game and prompts them for their name.
		 */
		System.out.println("Please enter your name.");
		playerName = input.nextLine();
		System.out.printf("Hello %s, and welcome to [insert welcome here].\n", playerName);
		System.out.println("Your goal? To escape the mansion with your life.");
		/*
		 * This loops is the main logic of the game. It prints out the number of turns, and
		 * the current room, and prompts them for input. Some rooms will generate special messages.
		 */
		while (pc.isAlive()) {
			System.out.printf("====Turn %d====\n", turns++);
			System.out.printf("You stand in the %s.\n", mansionMap.get(pc.position).name);
			if (pc.position.equals(new Point(13, 13))) {
				System.out.println("This room makes you feel unlucky...");
			} else if (pc.position.equals(new Point(-1, -1))) {
				System.out.println("You feel as if you have cheated.");
			}
			String action = input.nextLine();
			
			System.out.println();
		}
		
		//Cleanup
		lose();
		input.close();
	}
	
	private static void lose() {
		System.out.println("You have lost!");
		System.out.printf("Fare thee well, %s, we will not forget you!\n", playerName);
	}
	
	private static void win() {
		System.out.printf("Congratulations, %s, you have won!\n", playerName);
		input.close();
		System.exit(0);
	}
	
	private static Map<Point, Room> makeMap(int size) {
		Map<Point, Room> someMap = new HashMap<Point, Room>();
		Random rand = new Random();
		for (int x = 0; x < size; x++) {
			for (int y = 0; y < size; y ++) {
				Point coord = new Point(x, y);
				Room someRoom = new Room(ROOMNAMES[rand.nextInt(ROOMNAMES.length)]);
				someMap.put(coord, someRoom);
			}
		}
		return someMap;
	}
	
}
