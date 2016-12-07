import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class Player {
	public int highestX;
	public int highestY;
	public Point position;
	public List<Item> inventory;
	public int items;
	private boolean alive;
	public static final int MAXITEMS = 10;
	
	public Player(){
		highestX = 0;
		highestY = 0;
		position = new Point(0,0);
		inventory = new ArrayList<Item>();
		items = 0;
		alive = true;
	}
	
	public boolean isAlive() {
		return alive;
	}
	
	public void addToInventory(Item i){
		if(items < MAXITEMS){
			inventory.add(i);
		} else {
			System.out.println("You're carrying too much right now to pick THAT up!");
		}
	}
	
	
	public void remove(Item i){
		
	}

}
