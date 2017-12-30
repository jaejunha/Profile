package ui;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JFrame;

import logic.Point;
import logic.Random;
import logic.Size;

public class Frame extends JFrame {
	
	private Panel panel;
	private int time;
	
	private ArrayList<Point> srcPoints, dscPoints;
	
	public Frame(){
		Random random = new Random();
		srcPoints = random.makePoints(Size.numberPoint, Size.screenWidth, Size.screenHeight, Size.minRadius, Size.maxRadius, Size.maxOpacity);
		dscPoints = random.makePoints(Size.numberPoint, Size.screenWidth, Size.screenHeight, Size.minRadius, Size.maxRadius, Size.maxOpacity);

		panel = new Panel(this);
		setUndecorated(true); // whether you use upper bar or not
		setBackground(new Color(255, 255, 255, 0));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(panel);
		setSize(Size.screenWidth,Size.screenWidth);
		setLocationRelativeTo(null); // move application to center position
		setVisible(true);
		
		new Thread(){
			public void run(){
				while(true){
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					time++;
					if(time % 500 == 0){
						time = 0;
						srcPoints = dscPoints;
						dscPoints = random.makePoints(Size.numberPoint, Size.screenWidth, Size.screenHeight, Size.minRadius, Size.maxRadius, Size.maxOpacity);
					}
					panel.repaint();
				}
			}
		}.start();
	}
	
	public int getTime(){return time;}
	public ArrayList<Point> getSrcPoints(){return srcPoints;}
	public ArrayList<Point> getDscPoints(){return dscPoints;}
}
