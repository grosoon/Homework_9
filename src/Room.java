import java.util.Random;

public class Room {
	public String name;
	public Item[] items;
	
	//creates a new room and generates the items
	public Room(String name){
		this.name = name;
		generateItems();
	}
	
	
	/*This function randomly fills the room
	 * with 0-3 items with the number and 
	 * type being randomly selected.
	 */
	private void generateItems(){
		int count = 0;
		Random rand = new Random();
		items = new Item[rand.nextInt(4)];
		while(count < items.length){
			switch(rand.nextInt(3)){
			case 1:
				items[count++] = new Edible();
				break;
			case 2:
				items[count++] = new Trigger();
				break;
			default:
				items[count++] = new Item();
			}
			
		}
	}
	
	
}
