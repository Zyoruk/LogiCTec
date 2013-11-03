package edu.itcr.logictec.graphicaluserinterface;



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
	private JComponent panel_1;
	private int i = 0;
	private MyLabel[] labelList;
	private MyLabel[] temp;	
	private Component[] components ;


	public DrawGate(int px,int py,int ph,String ptc,JComponent pPanel_1){
		this._x = px;
		this._y = py;
		this._height = ph;
		this._gateKind = ptc;
		this.panel_1 = pPanel_1;	
		components = new Component[10];
		labelList = new MyLabel[10];
		temp = new MyLabel[10];

	}

	/**
	 * Paint the logic gate with its inputs and outputs.
	 * @throws IOException
	 * @author Zyoruk
	 */
	public void paint() throws IOException{
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

		MyLabel picLabel = new MyLabel(new ImageIcon(image));
		labelList[i] = picLabel;
		i++;			

		JTextField input1 = new JTextField();		
		picLabel.add(input1);
		input1.setBounds(0, 0, 20, 20);	

		JTextField input2 = new JTextField();		
		picLabel.add(input2);
		input2.setBounds(0,50, 20, 20);

		JTextField output = new JTextField();		
		picLabel.add(output);
		output.setBounds(80,50, 20, 20);

		panel_1.add(picLabel);
		picLabel.setBounds(_x,_y,_height,_height);


		//Creates a temporal list of components
		for(int i = 0 ; i < panel_1.getComponentCount();i++){
			components[i] = panel_1.getComponent(i);
		}

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

	public String getGateKind(){
		return this._gateKind;
	}

	public void connect(Color color){    	
		for (int i = 0; i < labelList.length ; i++){        			
			if( temp.length == 2 ){
				Graphics g = panel_1.getGraphics();
				g.setColor(color);
				g.drawLine(temp[0].getX(),temp[0].getY(),temp[1].getX(),temp[1].getY());
			}else{
				System.out.print(false);
			}
		}    	
	}

	public MyLabel[] getClikedOnes(){
		return this.temp;
	}

	public void setClickedOnes(){
		for (int i = 0; i < labelList.length ; i++){
			if (labelList[i].getIfClicked() == true){
				temp[i] = (labelList[i]);
			}
		}
	}
}
