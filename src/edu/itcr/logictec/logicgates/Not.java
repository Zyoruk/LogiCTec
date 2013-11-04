package edu.itcr.logictec.logicgates;

import edu.itcr.logictec.trees.binary.BinaryNode;

public class Not extends LogicGate<Integer> {
	
	public Not(){
		super();
	}
	
	//*****************************************************************//
	/*
	 * As a NOT only has one input, the method to set up the inputs are 
	 * rewritten setting both inputs equally.
	 */	
	
	public void setInA(int pdata){
		if (this.root == null){
			BinaryNode<Integer> node = new BinaryNode<Integer>();
			this.root = node;
		}
		this.root.setLeft(pdata);
		this.root.setRight(pdata);
		setRoot();
	}
	
	public void setInB(int pdata){
		if (this.root == null){
			BinaryNode<Integer> node = new BinaryNode<Integer>();
			this.root = node;
		}
		this.root.setRight(pdata);
		this.root.setLeft(pdata);
		setRoot();
	}
	
	//*****************************************************************//

	/*
	 * Sets the output of the logic gate as a Not gate would.
	 */
	protected void setRoot(){
		if(this.root.getLeft().getData() == 0){
			this.root.setData(1);
		}else{
			this.root.setData(0);
		}
	}
}
