package ui;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JFrame;

import logic.Point;
import logic.Random;
import logic.Size;

public class Frame extends JFrame {
	
	private Panel panel;
	private int time, cTime;
	
	private ArrayList<Point> srcPoints, dscPoints;
	private logic.Color srcColor, dscColor;
	
	public Frame(){
		Random random = new Random();
		srcPoints = random.makePoints(Size.numberPoint, Size.screenWidth, Size.screenHeight, Size.minRadius, Size.maxRadius, Size.maxOpacity);
		dscPoints = random.makePoints(Size.numberPoint, Size.screenWidth, Size.screenHeight, Size.minRadius, Size.maxRadius, Size.maxOpacity);
		srcColor = new logic.Color(255,0,0);
		dscColor =  new logic.Color(255,128,0);
		
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
					cTime++;
					if(time % 80 == 0){
						cTime = 0;
						srcColor = dscColor;
						switch(time){
						case 80:
							dscColor =  new logic.Color(255,255,0);
							break;
						case 160:
							dscColor =  new logic.Color(0,255,0);
							break;
						case 240:
							dscColor =  new logic.Color(0,0,255);
							break;
						case 320:
							dscColor =  new logic.Color(0,0,128);
							break;
						case 400:
							dscColor =  new logic.Color(128,0,128);
							break;
						case 480:
							dscColor =  new logic.Color(0,0,0);
							break;
						}
					}
					if(time % 500 == 0){
						time = 0;
						cTime = 0;
						srcPoints = dscPoints;
						dscColor =  new logic.Color(255,0,0);
						dscPoints = random.makePoints(Size.numberPoint, Size.screenWidth, Size.screenHeight, Size.minRadius, Size.maxRadius, Size.maxOpacity);
					}
					panel.repaint();
				}
			}
		}.start();
	}
	
	public int getTime(){return time;}
	public int getCTime(){return cTime;}
	public ArrayList<Point> getSrcPoints(){return srcPoints;}
	public ArrayList<Point> getDscPoints(){return dscPoints;}
	public logic.Color getSrcColor(){return srcColor;}
	public logic.Color getDscColor(){return dscColor;}
}
