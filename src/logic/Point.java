package logic;

public class Point {
	private int x;
	private int y;
	private int radius;
	private int opacity;
	
	public Point(int x, int y, int radius, int opacity){
		this.x = x;
		this.y = y;
		this.radius = radius;
		this.opacity = opacity;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getRadius() {
		return radius;
	}

	public int getOpacity() {
		return opacity;
	}
}
