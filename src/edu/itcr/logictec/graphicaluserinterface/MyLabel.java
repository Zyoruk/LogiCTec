package edu.itcr.logictec.graphicaluserinterface;

/**
 * This is a class that extends JLabel. Creates a panel that can be dragged and
 * dropped. Also, it sets a flag true when clicked on it.
 */

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class MyLabel extends JLabel implements MouseMotionListener, MouseListener {
	
	private boolean amIClicked;
	private MyPanel panel_1;
	private String gatekind;
	
	public MyLabel(){
		super();
		addMouseMotionListener(this);
		addMouseListener(this);
	}
	
	public MyLabel(int px , int py , int pheight, MyPanel pPanel_1){
		super.setBounds(px, py, pheight, pheight);
		addMouseMotionListener(this);
		addMouseListener(this);
		amIClicked = false;
		panel_1 = pPanel_1;
	}

	public MyLabel(ImageIcon pimageIcon, MyPanel pPanel_1, String pGateKind) {
		super(pimageIcon);
		addMouseMotionListener(this);
		addMouseListener(this);
		amIClicked = false;
		panel_1 = pPanel_1;
		gatekind = pGateKind;
	}
	
	@Override
	public void mouseDragged(MouseEvent pmme) {

		setLocation(
				   this.getX() + pmme.getX() - this.getWidth() / 2,
		
				   this.getY() + pmme.getY() - this.getHeight() / 2
		);
	}

	public boolean getIfClicked(){
		return amIClicked;
	}
	
	public void setIfClicked(boolean true_false){
		this.amIClicked = true_false;
	}
	
	public String getGatekind(){
		return this.gatekind;
	}
	
	public void setGateKind(String pGK){
		this.gatekind = pGK;
	}
	@Override
	public void mouseMoved(MouseEvent pmme) {
		// TODO Auto-generated method stub
	}
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		amIClicked = true;
		panel_1.setClickedOne(this);
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
}
