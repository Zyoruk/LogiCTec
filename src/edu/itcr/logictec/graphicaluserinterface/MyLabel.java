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

@SuppressWarnings("serial")
public class MyLabel extends JLabel implements MouseMotionListener, MouseListener {
	
	private boolean amIClicked;
	private String gatekind;
	private GUI theGUI;
	
	public MyLabel(){
		super();
		addMouseMotionListener(this);
		addMouseListener(this);
	}
	
	public MyLabel(int px , int py , int pheight, MyPanel pPanel_1,GUI ptheGUI){
		super.setBounds(px, py, pheight, pheight);
		amIClicked = false;
		theGUI = ptheGUI;
		addMouseMotionListener(this);
		addMouseListener(this);
	}

	public MyLabel(ImageIcon pimageIcon, MyPanel pPanel_1, String pGateKind, GUI ptheGUI) {
		super(pimageIcon);
		amIClicked = false;
		gatekind = pGateKind;
		theGUI = ptheGUI;
		addMouseMotionListener(this);
		addMouseListener(this);
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
		theGUI.setClickedOne(this);
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
