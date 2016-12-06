import java.awt.Point;
import java.util.HashMap;
import java.util.Random;

public class Edible extends Item{
	// creates an item that can be consumed
	public static final String[] ENAMES = {"",""};
	
	public Edible(){
		Random rand = new Random();
		name = ENAMES[rand.nextInt(ENAMES.length)];
		name = applyAdjectives();
	}
	
	// looks at an edible object
	@Override
	public String lookAt(){
		return "It looks like a " + name + ". It looks like you can eat it";
	}
	
	//eats an edible object, and calls mixDirections on player
	@Override
	public String pickUp(Player player, HashMap<Point, Room> map){
		player.mixDirections();
		return "You eat the " + name + " and start to feel a bit disoriented";
	}
}
