import java.awt.Point;
import java.util.HashMap;
import java.util.Map;

public class Mansion {

	private Map<Point, Room> mansionMap;
	
	public Mansion () {
		mansionMap = new HashMap<Point, Room>();
		makeMap();
	}
	
	private void makeMap() {
		for (int x = 0; x < 5; x++) {
			for (int y = 0; y < 5; y ++) {
				Point coord = new Point(x, y);
				Room someRoom = new Room("Test");
				mansionMap.put(coord, someRoom);
			}
		}
	}
}
