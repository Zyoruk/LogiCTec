package edu.itcr.logictec.graphicaluserinterface;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class MyPanel extends JPanel {
	
	private MyLabel[] clickedOnes;
	
	public MyPanel(){
		super();
		clickedOnes = new MyLabel[2];
	}
	
	public void setClickedOne(MyLabel label){	
		
		if(clickedOnes[0] == null){
			clickedOnes[0] = label;	
			System.out.println(true);
		}else if (clickedOnes[1] == null && clickedOnes[0] != null){
			clickedOnes[1] = label;			
		}else{
			clickedOnes[0].setIfClicked(false);
			clickedOnes[0] = clickedOnes[1];
			clickedOnes[1] = label;
		}
			
	}
	
	public MyLabel[] getClikedOnes(){
		return this.clickedOnes;
	}
	
	public void connectOIA(Color color){   
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
	
	public void connectOIB(Color color){   
		if (clickedOnes[0] !=null && clickedOnes[1] !=null){        			
			Graphics g = this.getGraphics();
			g.setColor(color);
			g.drawLine(clickedOnes[0].getX() + 100,clickedOnes[0].getY() + 50,
					clickedOnes[1].getX(),clickedOnes[1].getY()+50);
		}    	
	}
	
	public void clearClickedOnes(){
		clickedOnes[0] = null;
		clickedOnes[1] = null;
	}
}
