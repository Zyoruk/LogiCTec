package edu.itcr.logictec.graphicaluserinterface;



import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class MyLabel extends JLabel implements MouseMotionListener, MouseListener {
	
	private boolean amIClicked;
	
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
		addMouseListener(this);
		amIClicked = false;
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
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		amIClicked = true;
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	public boolean getIfClicked(){
		return amIClicked;
	}
}
