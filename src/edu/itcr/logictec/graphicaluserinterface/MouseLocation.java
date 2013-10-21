package edu.itcr.logictec.graphicaluserinterface;

import java.awt.MouseInfo;
import java.awt.Point;

public class MouseLocation {
	private int x;
	private int y;
	private Point cursor;
	
	public MouseLocation(){
		cursor = MouseInfo.getPointerInfo().getLocation();
	}
	
	public String getMouseLocation(){
		x = cursor.x;
		y = cursor.y;
		StringBuilder result = new StringBuilder();
		result.append('x');
		result.append(String.format("%s ", x));
		result.append('y');
		result.append(String.format("%s", y));
		return result.toString();
	}
	
	public int getX(){
		return cursor.x;
	}
	
	public int getY(){
		return cursor.y;
	}
}
