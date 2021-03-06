import java.util.Map;
import java.util.Random;
import java.awt.Point;

public class Item {
	// creates a new item that doesn't do anything
	public static final String[] NAMES = {"vase", "pouch", "orb", "ball", "lamp", 
			"paper weight", "plate", "cup", "bottle", "candlestick", "book"};
	public static final String[] ADJECTIVES = {"Red", "Orange", "Blue", "Yellow",
			"White", "Black", "Green", "Large", "Small", "Wide", "Important", "Brown"};
	public String name;
	
	public Item(){
		Random rand = new Random();
		name = NAMES[rand.nextInt(NAMES.length)];
		name = applyAdjectives();
	}
	
	/* applies an adjective to the name from the above list so as to
	 * add variety in items 
	 */
	
	public String applyAdjectives(){
		Random rand = new Random();
		return ADJECTIVES[rand.nextInt(ADJECTIVES.length)] + " " + name; 
	}
	
	
	/* allows the player to look at an item without
	 * disturbing it.
	 */
	public String lookAt(){
		return "It appears to be a " + name + ". You can pick it up, but it may not do much";
	}
	
	/*picks up an item that doesn't do anything upon pickup
	 * 
	 */
	public String pickUp(Player player, Map<Point, Room> map){
		player.addToInventory(this);
		return "You pick up the " + name + " and put it in your pocket";
	}
	
	// uses an item, in this case the item does nothing
	public String Use(Player player, Enemy e){
		return "Nothing Happened";
	}

}
