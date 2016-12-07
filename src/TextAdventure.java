import java.awt.Point;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class TextAdventure {
	
	private static Scanner input;
	private static String playerName;
	private static Map<Point, Room> mansionMap;
	private static final int MANSIONSIZE = 4;
	private static final String[] ROOMNAMES = {"dining room", "bathroom", "bedroom", "guest bedroom"}; 
	
	public static void main (String[] args) {
		/*
		 * This sets up the initial gamestate.
		 */
		int turns = 0;
		input = new Scanner(System.in);
		mansionMap = makeMap(MANSIONSIZE);
		Enemy badGuy = new Enemy(MANSIONSIZE);
		Player pc = new Player();
		/*
		 * This welcomes the player to their game and prompts them for their name.
		 */
		System.out.println("Please enter your name.");
		playerName = input.nextLine();
		System.out.printf("Hello %s, and welcome to [insert welcome here].\n", playerName);
		System.out.println("Your goal? To escape the mansion with your life.");
		System.out.println();
		/*
		 * This loops is the main logic of the game. It prints out the number of turns, and
		 * the current room, and prompts them for input. Some rooms will generate special messages.
		 */
		while (pc.isAlive()) {
			//This deals with things related to the room position, and counts the turn.
			Room cur = mansionMap.get(pc.position);
			System.out.printf("====Turn %d====\n", turns++);
			System.out.printf("You stand in the %s.\n", cur.name);
			if (Math.abs(pc.position.x - badGuy.position.x) <= 2 && 
					Math.abs(pc.position.y - badGuy.position.y) <= 2) {
				System.out.println("You hear the shuffling feet of the murderer...");
			}
			if (pc.position.x == badGuy.position.x && pc.position.y == badGuy.position.y) {
				lose();
			}
			System.out.println();
			//Special messages (may delete later)
			if (pc.position.equals(new Point(13, 13))) {
				System.out.println("This room makes you feel unlucky...");
			} else if (pc.position.equals(new Point(-1, -1))) {
				System.out.println("You feel as if you have cheated.");
			}
			//This prints out the items in the room.
			System.out.printf("The %s contains the following items:\n", cur.name);
			for (Item i : cur.items) {
				System.out.printf("%s\n", i.name);
			}
			System.out.println();
			//This deals with player actions.
			System.out.println("What do you want to do?");
			String action = input.nextLine();
			System.out.println();
			//This updates the enemy
			badGuy.update();
		}
		
		//Cleanup
		lose();
		input.close();
	}
	
	private static void lose() {
		System.out.println("...and that's because he's in the room with you!");
		System.out.println();
		System.out.println("W H A T   A   T E R R I B L E   F A T E");
		System.out.println();
		System.out.printf("Fare thee well, %s, we will not forget you!\n", playerName);
		input.close();
		System.exit(0);
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
