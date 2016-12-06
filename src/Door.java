
public class Door {
	Room destination;
	boolean blocked;
	
	public Door(){
		blocked = false;
		destination = null;
	}
	
	public Door(Room dest){
		destination = dest;
		blocked = false;
	}
	
	public void block(){
		blocked = true;
	}

}
