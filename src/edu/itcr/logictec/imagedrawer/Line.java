package edu.itcr.logictec.imagedrawer;

import java.awt.Graphics;


public class Line {
	int x2;
	int y1;
	int x1;
	int y2;
	Graphics g;
	
	public Line(int x1 , int y1 , int x2 , int y2 , Graphics g){
		this.x1 = x1;
		this.x2 = x2;
		this.y1 = y1;
		this.y2 = y2;
		this.g = g;
	}
	
	public void drawLine(){
		g.drawLine(x1, y1, x2, y2);
	}
}
