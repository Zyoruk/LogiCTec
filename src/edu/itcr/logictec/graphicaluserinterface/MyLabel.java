package edu.itcr.logictec.graphicaluserinterface;



import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class MyLabel extends JLabel implements MouseMotionListener {
	
	public MyLabel(){
		super();
	}
	
	public MyLabel(int px , int py , int pheight){
		super.setBounds(px, py, pheight, pheight);
		addMouseMotionListener(this);
	}

	public MyLabel(ImageIcon pimageIcon) {
		super(pimageIcon);
		addMouseMotionListener(this);
	}
	
	@Override
	public void mouseDragged(MouseEvent pmme) {

		setLocation(
				   this.getX() + pmme.getX() - this.getWidth() / 2,
		
				   this.getY() + pmme.getY() - this.getHeight() / 2
		);
	}

	@Override
	public void mouseMoved(MouseEvent pmme) {
		// TODO Auto-generated method stub

	}

}
