import java.awt.Point;
import java.util.Random;

public class Enemy {

	public Point position;
	public int noise;

	/*
	 * The enemy MUST start in the corner of the mansion, since the max of their movement
	 * is based on their starting position.
	 */
	public Enemy() {
		Random rand = new Random();
		position = new Point(rand.nextInt(10) + 2, rand.nextInt(10) + 2);
		noise = 1;
	}

	/*
	 * This method updates the enemy's position, and is called once each main loop.
	 * The enemy moves either 0 or 1 tiles each turn in both the x and y directions.
	 * If a certain turn threshold is reached, the enemy begins a strange, erratic
	 * pursuit of the player.
	 */
	public void update(Player pc, int turns) {
		Random rand = new Random();
		int dx = rand.nextInt(3) - 1;
		int dy = rand.nextInt(3) - 1;
		
		if (pc.position.x > position.x && turns >= 20) {
			dx = 1;
		} else if (pc.position.x < position.x && turns >= 20) {
			dx = -1;
		}
		
		if (pc.position.y > position.y && turns >= 20) {
			dy = 1;
		} else if (pc.position.y < position.y && turns >= 20) {
			dy = -1;
		}
		
		position.translate(dx, dy);
		//System.out.printf("enemy location: %d, %d\n", position.x, position.y);
	}
	
	public String makeNoise(Player p){
		if (noise <= 2) {
			if(position.distance(p.position) <= noise){
				return "You hear footsteps nearby...\n";
			} else{
				return "";
			}
		} else {
			String dir = "";
			double dx = p.position.getX() - position.getX();
			double dy = p.position.getY() - position.getY();
			if(dx < 0){
				if(dy < 0){
					dir = "Northeast";
				} else if(dy == 0){
					dir = "North";
				} else {
					dir = "Northwest";
				}
			} else if(dx == 0){
				if(dy < 0){
					dir = "East"; 
				} else {
					dir = "West";
				}
			} else {
				if(dy < 0){
					dir = "Southeast";
				} else if(dy == 0){
					dir = "South";
				} else {
					dir = "Southwest";
				}
			}
			if(position.distance(p.position) <= 2){
				return "You hear footsteps to the" + dir + "...\n";
			} else{
				return "";
			}
			
		}
	}
}
