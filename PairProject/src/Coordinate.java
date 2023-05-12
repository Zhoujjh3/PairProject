
public class Coordinate {
	
	int[] coords;
	
	public Coordinate(int xPos, int yPos) {
		coords = new int[2];
		coords[0] = xPos;
		coords[1] = yPos;
	}
	
	public int[] getCoords() {
		return coords;
	}
	
	public int getX() {
		return coords[0];
	}
	
	public int getY() {
		return coords[1];
	}
}
