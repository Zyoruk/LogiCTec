package edu.itcr.logictec.logicgates;

public class Or extends LogicGate<Integer> {
	
	public Or(){
		super();
	}

	/*
	 * Sets the output of the logic gate as a Or gate would.
	 */
	protected void setRoot(){
		if(this.root.getRight() == null || this.root.getLeft() == null){
			return;
		} else{
			this.root.setData(this.root.getLeft().getData() + 
					   this.root.getRight().getData());
			if (this.root.getData() > 1){
				this.root.setData(1);
			}
		}
	}
}
