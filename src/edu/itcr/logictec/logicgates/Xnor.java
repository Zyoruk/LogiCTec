package edu.itcr.logictec.logicgates;

public class Xnor extends LogicGate<Integer> {
	
	public Xnor(){
		super();
	}

	/*
	 * Sets the output of the logic gate as a Xnor gate would.
	 */
	protected void setRoot(){
		if(this.root.getRight() == null || this.root.getLeft() == null){
			return;
		} else{
			if(this.root.getLeft().getData() == this.root.getRight().getData()){
				this.root.setData(1);
			} else{
				this.root.setData(0);
			}
		}
	}
}
