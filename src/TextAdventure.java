import java.awt.Point;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class TextAdventure {
	
	private static Scanner input;
	private static String playerName;
	private static Map<Point, Room> mansionMap;
	private static boolean attack = false;
	private static final String[] ROOMNAMES = {"dining room", "bathroom", "bedroom", 
			"living room", "guest bedroom", "treasure vault", "ballroom", "great hall"}; 
	
	public static void main (String[] args) {
		/*
		 * This sets up the initial gamestate.
		 */
		
		Random rand = new Random();
		int turns = 0;
		input = new Scanner(System.in);
		mansionMap = new HashMap<Point, Room>();
		Enemy badGuy = new Enemy();
		Player pc = new Player();
		/*
		 * This welcomes the player to their game and prompts them for their name.
		 */
		System.out.println("Please enter your name.");
		playerName = input.nextLine();
		System.out.printf("Hello %s, and welcome to THE MANSION.\n", playerName);
		System.out.println("Your goal? To escape the mansion with your life.");
		System.out.println("In order to to do this");
		System.out.println();
		/*
		 * This loops is the main logic of the game. It prints out the number of turns, and
		 * the current room, and prompts them for input. Some rooms will generate special messages.
		 */
		while (pc.isAlive()) {
			boolean known= false;
			// checks to see if this room has been visited already and if not creates the room
			Room cur;
			if(mansionMap.containsKey(pc.position)){
				cur = mansionMap.get(pc.position);
				known = true;
			} else {
				cur = new Room(ROOMNAMES[rand.nextInt(ROOMNAMES.length)]);
				mansionMap.put(pc.position, cur);
			}
			
			// informs the player of the turn number and lets them know their current room and if they can hear

			System.out.printf("========Turn %d========\n", turns++);
			System.out.printf("You stand in the %s.\n", cur.name);
			if (!attack && pc.position.x == badGuy.position.x && pc.position.y == badGuy.position.y) {
				lose();
			}
			
			System.out.println(badGuy.makeNoise(pc));
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
				System.out.printf("- %s\n", i.name);
			}
			System.out.println();
			if(known){
				System.out.println("You feel like you've been here before");
			}
			
			
			//Prompts the user for an action
			System.out.println("What do you want to do?");
			String action = input.nextLine();
			
			interpretAction(action);
			
			
			if(action.toLowerCase().equals("attack")){
				attack = true;
				
				
				
			} else if(action.toLowerCase().equals("wait")){
				
				
				
				
				
			} else if(action.length() < 7){
				System.out.println("The command " + action + " is not recognized");
			} else {
				
				
				
				
				if(action.substring(0,7).toLowerCase().equals("pick up")){
					boolean done = false;
					for(Item i : cur.items){
						if(i.name.toLowerCase().equals(action.substring(8).toLowerCase())){
							System.out.println(i.pickUp(pc, (HashMap<Point, Room>) mansionMap));
							cur.remove(i);
							done = true;
						}
					}

					if(!done){
						System.out.println("There was no item named " + action.substring(8));
					}
					
					
					
					
				} else if(action.substring(0,7).toLowerCase().equals("look at")){
					if(action.length() == 17 && action.substring(8).toLowerCase().equals("inventory")){
						lookAtInventory(pc, input, badGuy);
					} else {
						boolean done = false;
						for(Item i: cur.items){
							if(i.name.toLowerCase().equals(action.substring(8).toLowerCase())){
								System.out.println(i.lookAt());
								done = true;
							}
						}
						if(!done){
							System.out.println("There was no item named " + action.substring(8));
						}
					}
				} else if(action.substring(0, 2).toLowerCase().equals("go")){
					//the fifth option is to go in a direction
					if(action.substring(3).toLowerCase().equals("north")){
						pc.move(0);
					} else if(action.substring(3).toLowerCase().equals("north")){
						pc.move(0);
					} else if(action.substring(3).toLowerCase().equals("east")){
						pc.move(1);
					} else if(action.substring(3).toLowerCase().equals("south")){
						pc.move(2);
					} else if(action.substring(3).toLowerCase().equals("west")){
						pc.move(3);
					} else {
						System.out.println("You cannot move " + action.substring(2));
					}
				} else {
					System.out.println(action + " not recognized as an option, please try again");
				}
			} 
			
			
			
			
			
			
			
			
			boolean gotKey = false;
			for(Item i : pc.inventory){
				if(i.name.toLowerCase().equals("important key")){
					gotKey = true;
				}
			}
		
			if(pc.position.equals(new Point(0,0)) && gotKey){
				win();
			}
			
			System.out.println();
			//This updates the enemy
			badGuy.update();
		}
		
		//Cleanup
		lose();
		input.close();
	}
	
	private static void interpretAction(String action) {
		if(action.toLowerCase().equals("attack")){
			
		}
		
	}

	private static void lookAtInventory(Player p, Scanner input, Enemy e) {
		boolean done = false;
		while(!done){
			System.out.println(e.makeNoise(p));
			System.out.println("You have the following items in your inventory.");
			for(Item i : p.inventory){
				System.out.println(" - " + i.name);
			}
			System.out.println("You can drop an item, use an item, or exit your inventory.");
			System.out.println("What do you want to do");
			String action = input.nextLine();
			
			if(action.equals("exit")){
				done = true;
			} else if(action.length() > 4){
				if(action.substring(0, 3).toLowerCase().equals("use")){
					boolean temp = false;
					for(Item i : p.inventory){
						if(i.name.toLowerCase().equals(action.substring(4).toLowerCase())){
							System.out.println(i.Use(p, e));
							temp = true;
							break;
						}
					}
					if(!temp){
						System.out.println("There was no item named " + action.substring(8));
					}
				} else if(action.substring(0,4).toLowerCase().equals("drop")){
					boolean temp = false;
					for(Item i : p.inventory){
						if(i.name.toLowerCase().equals(action.substring(5).toLowerCase())){
							System.out.println(p.remove(i));
							temp = true;
							break;
						}
					}
					if(!temp){
						System.out.println("There was no item named " + action.substring(5));
					}
				}
			} 
			
			
			boolean gotKey = false;
			for(Item i : p.inventory){
				if(i.name.toLowerCase().equals("important key")){
					gotKey = true;
				}
			}
		
			if(p.position.equals(new Point(0,0)) && gotKey){
				win();
			}
			
			System.out.println();
			//This updates the enemy
			e.update();
		}
		
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
	
}

