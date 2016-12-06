import java.awt.geom.Point2D;
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
	@Override
	public String lookAt(){
		return "It looks like a " + name + ". It looks like you can eat it";
	}
	
	@Override
	public void pickUp(Player player, HashMap<Point2D, Room> map){
		player.mixDirections();
	}
}
