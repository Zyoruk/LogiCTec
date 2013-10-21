package edu.itcr.logictec.graphicaluserinterface;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JPanel;

public class DrawLine extends JPanel {

		private int _x;
		private int _y;
		private int _x2;
		private int _y2;
		private Color c;
		private Point _startsDragging;
		private Point _stopsDragging;
		
		public DrawLine(){
			super();
	        addMouseListener(new MouseAdapter() {

	            public void mousePressed(MouseEvent e) { // cuando se presiona el mouse
	            	_startsDragging = new Point(e.getX(), e.getY());
	            	_stopsDragging = _startsDragging;
	                repaint();
	            }

	            public void mouseReleased(MouseEvent e) { // cuando se deja de presionar el mouse
	                _x = _startsDragging.x;
	                _y = _startsDragging.y;
	                _x2 = e.getX();
	                _y2 = e.getY();
	                _startsDragging = null;
	                _stopsDragging = null;
	            }
	        });
	        addMouseMotionListener(new MouseMotionAdapter() {

	            public void mouseDragged(MouseEvent e) { // cuando se esta arrastrando el mouse
	            	_stopsDragging = new Point(e.getX(), e.getY());
	            }
	        });
            System.out.println(_x);
		}
		public void setColor(Color pcolor){
			this.c = pcolor;
		}
		public void paint(Graphics g){
			g.drawLine(_x, _y, _x2, _y2);
		}
}
