import java.awt.Point;
import java.util.Random;

public class Enemy {

	public Point position;
	private Random rand;
	private int maxX;
	private int maxY;

	/*
	 * The enemy MUST start in the corner of the mansion, since the max of their movement
	 * is based on their starting position.
	 */
	public Enemy(int corner) {
		maxX = corner;
		maxY = corner;
		position = new Point(corner, corner);
	}

	/*
	 * This method updates the enemy's position, and is called once each main loop.
	 * The enemy moves either 0, 1, or 2 tiles each turn in both the x and y directions.
	 */
	public void update() {
		rand = new Random();
		int dx = maxX + 1;
		int dy = maxY + 1;
		
		while (dx + position.x > maxX || dx + position.x < 0) {
			dx = Math.min(rand.nextInt(4) - 2, maxX);
		}
		while (dy + position.y > maxY || dy + position.y < 0) {
			dy = Math.min(rand.nextInt(4) - 2, maxY);
		}
		position.translate(dx, dy);
		//System.out.printf("enemy location: %d, %d\n", position.x, position.y);
	}
}
