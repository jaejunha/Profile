package ui;

import java.awt.Color;

import javax.swing.JFrame;

import logic.Size;

public class Frame extends JFrame {
	
	private Panel panel;
	
	public Frame(){
		panel = new Panel(this);
		setUndecorated(true); // whether you use upper bar or not
		setBackground(new Color(255, 255, 255, 0));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(panel);
		setSize(Size.screenWidth,Size.screenWidth);
		setLocationRelativeTo(null); // move application to center position
		setVisible(true);
	}
}
