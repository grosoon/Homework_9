import java.awt.Point;
import java.util.Map;
import java.util.Random;

public class Trigger extends Item{
	public static final String[] NAMES = {"vase", "pouch", "orb", "ball", "lamp", 
			"paper weight", "plate", "cup", "bottle", "candlestick", "book", "key"};
	public static final String[] TRANSPORTS = {"fall down a slide", "trip through a secret passage" 
			, "pass out and wake up after feeling yourself dropped to the floor",
			"go blind and run through the house in panic, eventually regaining your vision upon "
			+ "stopping"};
	
	public Trigger(){
		Random rand = new Random();
		name = NAMES[rand.nextInt(NAMES.length)];
		name = applyAdjectives();
	}
	
	/*
	 * Picks up an item that transports the player
	 */
	public String pickUp(Player player, Map<Point, Room> map){
		player.addToInventory(this);
		Random rand = new Random();
		int maxX = player.highestX;
		int maxY = player.highestY;
		player.position.setLocation(rand.nextInt(maxX), rand.nextInt(maxY));
		player.position.x =  rand.nextInt(maxX);
		player.position.y = rand.nextInt(maxY);
		String known = "an unfamiliar room.";
		if(map.containsKey(player.position)){
			known = "a familiar room.";
		}
		
		
		return "You pick up the " + name + " and suddenly\n" + 
		TRANSPORTS[rand.nextInt(TRANSPORTS.length)] + 
		".\nYou find yourself in " + known;
	}
	
	//creates an item that triggers the locking or unlocking of a door

}
