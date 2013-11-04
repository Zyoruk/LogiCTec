package edu.itcr.logictec.logicaluserinterface;

import edu.itcr.logictec.logicgates.And;
import edu.itcr.logictec.logicgates.LogicGate;
import edu.itcr.logictec.logicgates.Nand;
import edu.itcr.logictec.logicgates.Nor;
import edu.itcr.logictec.logicgates.Not;
import edu.itcr.logictec.logicgates.Or;
import edu.itcr.logictec.logicgates.Xnor;
import edu.itcr.logictec.logicgates.Xor;

/**
 * Creates the logic gates depending on a string.
 * @author zyoruk
 *
 */
public class LUI {
	
	private String _gateKind;
	@SuppressWarnings("rawtypes")
	private LogicGate[] myLogicGateList;
	@SuppressWarnings("rawtypes")
	private LogicGate[] myTemporalLogicGateList;
	private int i ;
	
	/**
	 * @param args
	 */
	public LUI(String pLG){
		_gateKind = pLG;
		myLogicGateList = new LogicGate[10];
		myTemporalLogicGateList = new LogicGate[10];
		i = 0 ;
	}
	
	public LogicGate<Integer> createLogicGates(){
		
		if (_gateKind == "AND"){
			LogicGate<Integer> AND = new And();
			myLogicGateList [i] = AND;
			i++;
			return AND;
			
		}else if (_gateKind == "NAND"){
			LogicGate<Integer> NAND = new Nand();
			myLogicGateList [i] = NAND;
			i++;
			return NAND;
			
		}else if (_gateKind == "XOR"){
			LogicGate<Integer> XOR = new Xor();
			myLogicGateList [i] = XOR;
			i++;
			return XOR;
			
		}else if (_gateKind == "XNOR"){
			LogicGate<Integer> XNOR = new Xnor();
			myLogicGateList [i] = XNOR;
			i++;
			return XNOR;
			
		}else if (_gateKind == "OR"){
			LogicGate<Integer> OR = new Or();
			myLogicGateList [i] = OR;
			i++;
			return OR;
			
		}else if (_gateKind == "NOR"){
			LogicGate<Integer> NOR = new Nor();
			myLogicGateList [i] = NOR;
			i++;
			return NOR;
			
		}else{
			LogicGate<Integer> NOT = new Not();
			myLogicGateList [i] = NOT;
			i++;
			return NOT;			
		}
	}
	
	public void undo(){
		if (this.myLogicGateList.length!=0){		
			this.myLogicGateList[i] = null;
			if(i != 0){
				i--;
			}
		}
	}
	
	public void redo(){
		this.myTemporalLogicGateList = buildTemporalList();
		if (i < this.myLogicGateList.length){
			this.myLogicGateList[i] = this.myTemporalLogicGateList[i];
			i++;
		}
	}
	
	@SuppressWarnings("rawtypes")
	private LogicGate[] buildTemporalList(){
		for (int i = 0; i<this.myLogicGateList.length;i++){
			this.myTemporalLogicGateList[i] = this.myLogicGateList[i];
		}		
		return this.myTemporalLogicGateList;
	}

}
