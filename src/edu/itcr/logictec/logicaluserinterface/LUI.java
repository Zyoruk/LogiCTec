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
	private LogicGate[] myTemporalLogicGateList;
	
	/**
	 * @param args
	 */
	public LUI(String pLG){
		_gateKind = pLG;
		myTemporalLogicGateList = new LogicGate[10];
	}
	
	public LogicGate<Integer> createLogicGates(LogicGate<Integer>[] pArray, int J){
		
		if (_gateKind == "AND"){
			LogicGate<Integer> AND = new And();
			pArray[J] = AND;
			return AND;
			
		}else if (_gateKind == "NAND"){
			LogicGate<Integer> NAND = new Nand();
			pArray[J] = NAND;
			return NAND;
			
		}else if (_gateKind == "XOR"){
			LogicGate<Integer> XOR = new Xor();
			pArray[J]  = XOR;
			return XOR;
			
		}else if (_gateKind == "XNOR"){
			LogicGate<Integer> XNOR = new Xnor();
			pArray[J]  = XNOR;
			return XNOR;
			
		}else if (_gateKind == "OR"){
			LogicGate<Integer> OR = new Or();
			pArray[J]  = OR;
			return OR;
			
		}else if (_gateKind == "NOR"){
			LogicGate<Integer> NOR = new Nor();
			pArray[J]  = NOR;
			return NOR;
			
		}else{
			LogicGate<Integer> NOT = new Not();
			pArray[J] = NOT;
			return NOT;			
		}
	}
	
	public int undo(LogicGate<Integer>[] pArray, int J){
		if (pArray[0] != null){		
			pArray[J] = null;
			J--;
		}
		return J;
	}
	
	public int redo(LogicGate<Integer>[] pArray, int J){
		this.myTemporalLogicGateList = buildTemporalList(pArray);
		if (J < pArray.length){
			pArray[J] = this.myTemporalLogicGateList[J];
			J++;
		}
		return J;
	}
	
	@SuppressWarnings("rawtypes")
	private LogicGate[] buildTemporalList(LogicGate[] pArray){
		for (int i = 0; i<pArray.length;i++){
			this.myTemporalLogicGateList[i] = pArray[i];
		}		
		return this.myTemporalLogicGateList;
	}

}
