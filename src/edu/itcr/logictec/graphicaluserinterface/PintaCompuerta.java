package edu.itcr.logictec.graphicaluserinterface;



import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

import edu.itcr.logictec.constants.Constants;

public class PintaCompuerta{
	private int _x;
	private int _y;
	private int _height;
	private String _tipoCompuerta;
	private JPanel panel_1;
	public PintaCompuerta(int px,int py,int ph,String ptc,JPanel pPanel_1){
		this._x = px;
		this._y = py;
		this._height = ph;
		this._tipoCompuerta = ptc;
		this.panel_1 = pPanel_1;
	}
	public void pintar() throws IOException{
		BufferedImage image;
		
		if (_tipoCompuerta == "AND"){
			image = ImageIO.read(new File(Constants.andImage));			
		}else if (_tipoCompuerta == "NAND"){
			image = ImageIO.read(new File(Constants.nandImage));	

			
		}else if (_tipoCompuerta == "XOR"){
			image = ImageIO.read(new File(Constants.xorImage));	

			
		}else if (_tipoCompuerta == "XNOR"){
			image = ImageIO.read(new File(Constants.xnorImage));	

			
		}else if (_tipoCompuerta == "OR"){
			image = ImageIO.read(new File(Constants.orImage));

			
		}else if (_tipoCompuerta == "NOR"){
			image = ImageIO.read(new File(Constants.norImage));	

			
		}else{
			image = ImageIO.read(new File(Constants.notImage));
			
		}
		
		MyLabel picLabel = new MyLabel(new ImageIcon(image));
		panel_1.add(picLabel);
		picLabel.setBounds(_x,_y,_height,_height);
	}
}
