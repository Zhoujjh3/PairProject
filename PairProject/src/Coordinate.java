
public class Coordinate {
	
	double[] coords;
	
	public Coordinate(double x, double y) {
		coords = new double[2];
		coords[0] = x;
		coords[1] = y;
	}
	
	public double[] getCoords() {
		return coords;
	}
	
	public double getX() {
		return coords[0];
	}
	
	public double getY() {
		return coords[1];
	}
}
