package ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JPanel;

import logic.Point;
import logic.Random;
import logic.Size;

public class Panel extends JPanel{

	private Frame frame;
	private ArrayList<Point> srcPoints, dscPoints;
	private logic.Color srcColor, dscColor;
	
	public Panel(Frame frame){
		this.frame = frame;
	}
	
	public void paintComponent(Graphics g) {
		Toolkit winTool = this.getToolkit();
		Image buffer = createImage(Size.screenWidth, Size.screenHeight);
		ArrayList<Point> srcPoints, dscPoints;
		int time = frame.getTime();
		int cTime = frame.getCTime();
		srcPoints = frame.getSrcPoints();
		dscPoints = frame.getDscPoints();
		srcColor = frame.getSrcColor();
		dscColor = frame.getDscColor();
		g.drawImage(buffer, 0, 0, this);

		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	//	g2d.drawImage(winTool.getImage(".\\image\\gradation.png"), 0, 0, this);
		int x, y, radius, opacity;
		int red, green, blue;
		for(int i=0;i<Size.numberPoint;i++){
			x = (int)(((500-time)/500.0)*srcPoints.get(i).getX()+((time)/500.0)*dscPoints.get(i).getX());
			y = (int)(((500-time)/500.0)*srcPoints.get(i).getY()+((time)/500.0)*dscPoints.get(i).getY());
			radius = (int)(((500-time)/500.0)*srcPoints.get(i).getRadius()+((time)/500.0)*dscPoints.get(i).getRadius());
			opacity = (int)(((500-time)/500.0)*srcPoints.get(i).getOpacity()*255/100+((time)/500.0)*dscPoints.get(i).getOpacity()*255/100);
			if(time<480){
				red = (int)(((80-cTime)/80.0)*srcColor.getRed()+((cTime)/80.0)*dscColor.getRed());
				green = (int)(((80-cTime)/80.0)*srcColor.getGreen()+((cTime)/80.0)*dscColor.getGreen());
				blue = (int)(((80-cTime)/80.0)*srcColor.getBlue()+((cTime)/80.0)*dscColor.getBlue());
			}else{
				red = (int)(((20-cTime)/20.0)*srcColor.getRed()+((cTime)/20.0)*dscColor.getRed());
				green = (int)(((20-cTime)/20.0)*srcColor.getGreen()+((cTime)/20.0)*dscColor.getGreen());
				blue = (int)(((20-cTime)/20.0)*srcColor.getBlue()+((cTime)/20.0)*dscColor.getBlue());
			}
			g2d.setColor(new Color(red, green, blue, opacity));
			g2d.fillOval(x, y, radius, radius);
		}
		g2d.drawImage(winTool.getImage(".\\image\\D.png"), 0, 0, this);
		
		setOpaque(false);
		super.paintComponent(g);
	}
	
	public void setPoints(ArrayList<Point> srcPoints, ArrayList<Point> dscPoints){
		this.srcPoints = srcPoints;
		this.dscPoints = dscPoints;
	}
}
