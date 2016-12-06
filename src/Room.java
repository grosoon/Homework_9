import java.util.Random;

public class Room {
	public String name;
	public Item[] items;
	
	
	public Room(String name){
		this.name = name;
		generateItems();
	}
	
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
