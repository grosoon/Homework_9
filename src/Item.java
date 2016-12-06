import java.util.HashMap;
import java.util.Random;
import java.awt.geom.Point2D;

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
	
	public String applyAdjectives(){
		Random rand = new Random();
		return ADJECTIVES[rand.nextInt(ADJECTIVES.length)] + " " + name; 
	}
	
	public String lookAt(){
		return "It appears to be a " + name + ". You can pick it up, but it may not do much";
	}
	
	public void pickUp(Player player, HashMap<Point2D, Room> map){
		player.addToInventory(this);
	}

}
