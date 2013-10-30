package edu.itcr.logictec.logicaluserinterface;

import edu.itcr.logictec.logicgates.And;
import edu.itcr.logictec.logicgates.LogicGate;
import edu.itcr.logictec.logicgates.Nand;
import edu.itcr.logictec.logicgates.Nor;
import edu.itcr.logictec.logicgates.Not;
import edu.itcr.logictec.logicgates.Or;
import edu.itcr.logictec.logicgates.Xnor;
import edu.itcr.logictec.logicgates.Xor;

public class LUI {
	
	private String _gateKind;

	/**
	 * @param args
	 */
	public LUI(){
		
	}
	
	public LogicGate<Integer> createLogicGates(){
		
		if (_gateKind == "AND"){
			LogicGate<Integer> AND = new And();
			return AND;
			
		}else if (_gateKind == "NAND"){
			LogicGate<Integer> NAND = new Nand();
			return NAND;
			
		}else if (_gateKind == "XOR"){
			LogicGate<Integer> XOR = new Xor();
			return XOR;
			
		}else if (_gateKind == "XNOR"){
			LogicGate<Integer> XNOR = new Xnor();
			return XNOR;
			
		}else if (_gateKind == "OR"){
			LogicGate<Integer> OR = new Or();
			return OR;
			
		}else if (_gateKind == "NOR"){
			LogicGate<Integer> NOR = new Nor();
			return NOR;
			
		}else{
			LogicGate<Integer> NOT = new Not();
			return NOT;
			
		}
	}

}
