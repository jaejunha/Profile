package logic;

import java.util.ArrayList;

public class Random {
	public ArrayList<Point> makePoints(int pointNumber, int screenWidth, int screenHeight, int minRadius, int maxRadius, int maxOpacity){
		ArrayList<Point> points = new ArrayList<>();
		int x,y,radius,opacity;
		
		int offsetRadius = maxRadius - minRadius;
		
		for(int i=0;i<pointNumber;i++){
			x = (int)(Math.random()*screenWidth)+1;
			y = (int)(Math.random()*screenHeight)+1;
			radius = (int)(Math.random()*offsetRadius)+1+minRadius;
			opacity = (int)(Math.random()*maxOpacity)+1;
			points.add(new Point(x,y,radius,opacity));
		}
		
		return points;
	}
}
