package edu.itcr.logictec.logicgates;

public class Xor extends LogicGate<Integer> {
	
	public Xor(){
		super();
	}

	/*
	 * Sets the output of the logic gate as a Xor gate would.
	 */
	protected void setRoot(){
		if(this.root.getRight() == null || this.root.getLeft() == null){
			return;
		} else{			
			if(this.root.getLeft().getData() == this.root.getRight().getData()){
				this.root.setData(0);
			} else{
				this.root.setData(1);
			}
		}
	}
}
