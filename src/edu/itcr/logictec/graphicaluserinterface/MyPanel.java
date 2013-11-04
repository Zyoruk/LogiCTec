package edu.itcr.logictec.graphicaluserinterface;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class MyPanel extends JPanel {


	public MyPanel(){
		super();
	}

	public void connectOIA(MyLabel[] clickedOnes,Color color){   
		if (clickedOnes[1].getGatekind() == "NOT"){
			Graphics g = this.getGraphics();
			g.setColor(color);
			g.drawLine(clickedOnes[0].getX() + 100,clickedOnes[0].getY() + 50,
					clickedOnes[1].getX(),clickedOnes[1].getY()+50);
		}else{
			if (clickedOnes[0] !=null && clickedOnes[1] !=null){        			
				Graphics g = this.getGraphics();
				g.setColor(color);
				g.drawLine(clickedOnes[0].getX() + 100,clickedOnes[0].getY() + 50,
						   clickedOnes[1].getX(),clickedOnes[1].getY());
			}  
		}
	}

	public void connectOIB(MyLabel [] clickedOnes , Color color){   
		if (clickedOnes[0] !=null && clickedOnes[1] !=null){        			
			Graphics g = this.getGraphics();
			g.setColor(color);
			g.drawLine(clickedOnes[0].getX() + 100,clickedOnes[0].getY() + 50,
					clickedOnes[1].getX(),clickedOnes[1].getY()+50);
		}    	
	}
}
