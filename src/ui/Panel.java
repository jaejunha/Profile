package ui;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JPanel;

import logic.Size;

public class Panel extends JPanel{

	private Frame frame;
	
	public Panel(Frame frame){
		this.frame = frame;
	}
	
	public void paintComponent(Graphics g) {
		Toolkit winTool = this.getToolkit();
		Image buffer = createImage(Size.screenWidth, Size.screenHeight);
		Graphics bufferG = buffer.getGraphics();
		g.drawImage(buffer, 0, 0, this);

		setOpaque(false);
		super.paintComponent(g);
	}
}
