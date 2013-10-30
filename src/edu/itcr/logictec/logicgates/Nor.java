package edu.itcr.logictec.logicgates;

public class Nor extends LogicGate<Integer> {
	
	public Nor(){
		super();
	}

	/*
	 * Sets the output of the logic gate as a Not gate would.
	 */
	protected void setRoot(){
		if(this.root.getRight() == null || this.root.getLeft() == null){
			return;
		} else{
			this.root.setData(this.root.getLeft().getData() + 
								   this.root.getRight().getData());
			if (this.root.getData() >= 1){
				this.root.setData(0);
			}
			if(this.root.getData() == 0){
				this.root.setData(1);
			}
		}
	}
}
