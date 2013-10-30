package edu.itcr.logictec.logicgates;

public class Nand extends LogicGate<Integer> {
	
	public Nand(){
		super();
	}

	/*
	 * Sets the output of the logic gate as a Nand gate would.
	 */
	protected void setRoot(){
		if(this.root.getRight() == null || this.root.getLeft() == null){
			return;
		} else{
			this.root.setData(this.root.getLeft().getData() * 
								   this.root.getRight().getData());
			if(this.root.getData() == 0){
				this.root.setData(1);
			} else{
				this.root.setData(0);
			}
		}
	}
}
