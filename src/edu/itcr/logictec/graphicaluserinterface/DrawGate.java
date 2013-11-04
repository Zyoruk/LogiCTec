package edu.itcr.logictec.graphicaluserinterface;

/**
 * Class on charge of drawing the respective gate with its image.
 * It creates a MyLabel.
 */

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JTextField;
import edu.itcr.logictec.constants.Constants;
import edu.itcr.logictec.logicgates.And;
import edu.itcr.logictec.logicgates.LogicGate;
import edu.itcr.logictec.logicgates.Nand;
import edu.itcr.logictec.logicgates.Nor;
import edu.itcr.logictec.logicgates.Not;
import edu.itcr.logictec.logicgates.Or;
import edu.itcr.logictec.logicgates.Xnor;
import edu.itcr.logictec.logicgates.Xor;

public class DrawGate{
	private int _x;
	private int _y;
	private int _height;
	private String _gateKind;
	private MyPanel panel_1;
	private int i = 0;
	private MyLabel[] clickedOnes;
	private Component[] components ;
	private MyLabel[] labelList;
	private JTextField input1;
	private JTextField input2;
	private JTextField output;

	public DrawGate(){
		components = new Component[10];
		clickedOnes = new MyLabel[2];
	}
	
	public DrawGate(int px,int py,int ph,String ptc,MyPanel pPanel_1, MyLabel[] pLabelList){
		this._x = px;
		this._y = py;
		this._height = ph;
		this._gateKind = ptc;
		this.panel_1 = pPanel_1;	
		components = new Component[10];
		this.labelList = pLabelList;
		clickedOnes = new MyLabel[2];
		input1 = new JTextField();
		input2 = new JTextField();
		output = new JTextField();
	}

	/**
	 * Paint the logic gate with its inputs and outputs.
	 * @throws IOException
	 * @author Zyoruk
	 */
	public MyLabel paint() throws IOException{
		BufferedImage image;

		if (_gateKind == "AND"){
			image = ImageIO.read(new File(Constants.andImage));

		}else if (_gateKind == "NAND"){
			image = ImageIO.read(new File(Constants.nandImage));

		}else if (_gateKind == "XOR"){
			image = ImageIO.read(new File(Constants.xorImage));	

		}else if (_gateKind == "XNOR"){
			image = ImageIO.read(new File(Constants.xnorImage));

		}else if (_gateKind == "OR"){
			image = ImageIO.read(new File(Constants.orImage));

		}else if (_gateKind == "NOR"){
			image = ImageIO.read(new File(Constants.norImage));	

		}else{
			image = ImageIO.read(new File(Constants.notImage));
		}

		MyLabel picLabel = new MyLabel(new ImageIcon(image), panel_1, _gateKind);
		labelList[i] = picLabel;
		i++;			
		
		/*
		 * We create 3 textfields for every new gate.
		 * The "Not" gate has only one input, then we dont add to it a textfield
		 */
		if(_gateKind != "NOT"){
			picLabel.add(input1);
			input1.setBounds(0, 0, 20, 20);
			input1.setText("0");
		}
		
		picLabel.add(input2);
		input2.setBounds(0,50, 20, 20);
		input2.setText("0");
		
		picLabel.add(output);
		output.setBounds(80,50, 20, 20);

		panel_1.add(picLabel);
		picLabel.setBounds(_x,_y,_height,_height);
		
		//Creates a temporal list of components
		for(int i = 0 ; i < panel_1.getComponentCount();i++){
			if(i != 9){
				components[i] = panel_1.getComponent(i);
			}else{
				break;
			}
		}
		
		return picLabel;
		
	}
	
	/**
	 * Undo the last change made.
	 * @author Zyoruk
	 */
	public void unDo(){
		if (panel_1.getComponentCount()!=0){		
			panel_1.remove(panel_1.getComponentCount() - 1);
			panel_1.repaint();
			if(i != 0){
				i--;
			}
		}
	}

	/**
	 * Redo the last change.
	 * @author Zyoruk
	 */
	public void reDo(){
		if (i < components.length){
			if (components[i] !=null){
			panel_1.add(components[i]);
			panel_1.repaint();
			i++;
			}
		}
	}

	/**
	 * return the kind of gate that has been created
	 * @return _gateKind which is a String.
	 */
	public String getGateKind(){
		return this._gateKind;
	}

	/**
	 * Gets  the list of MyLabels created
	 * @return lalbelList 
	 */
	public MyLabel[] getListOfLabels(){
		return this.labelList;
	}

	/**
	 * Gets the value of the input 1 as an Integer.
	 * @return temp 
	 */
	public int getInA(){
		int temp = Integer.parseInt(this.input1.getText());
		return temp;
	}
	
	/**
	 * Gets the value of the input 2 as an Integer.
	 * @return temp
	 */
	public int getInB(){
		int temp = Integer.parseInt(this.input2.getText());
		return temp;
	}
	
	/**
	 * Sets the value of the Input1
	 * @param pInput1
	 */
	public void setInA(String pInput1){
		this.input1.setText(pInput1);
	}
	
	/**
	 * Sets the value of the Input2
	 * @param pInput2
	 */
	public void setInB(String pInput2){
		this.input2.setText(pInput2);
	}
	
	/**
	 * sets the  value ofr the output of the gate
	 * @param pOut
	 */
	public void setOut(String pOut){
		this.output.setText(pOut);
	}
}
