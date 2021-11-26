
/**
 * Clasa If care conditioneaza executia instructiunilor din ifBody si elseBody 
 * @author 
 *
 */
public class IfNode implements Node{
	
	/**
	 * Conditia
	 */
	private ConditionNode conditionNode;
	
	/**
	 * Corpul de if
	 */
	private IfBodyNode ifBodyNode;
	
	/**
	 * Corpul de else
	 */
	private ElseBodyNode elseBodyNode;
	
	/**
	 * Daca exista else
	 */
	private boolean useElse;
	
	/**
	 * nivelul fata de radacina
	 */
	private int level;
	
	/**
	 * Constructor
	 */
	public IfNode() {
	} 
	
	/**
	 * Setter conditie
	 * @param conditionNode conditia
	 */
	public void setCondition(ConditionNode conditionNode) {
		this.conditionNode = conditionNode;
	}
	
	/**
	 * Setter ifBody
	 * @param ifBodyNode corpul de if
	 */
	public void setIfBodyNode(IfBodyNode ifBodyNode) {
		this.ifBodyNode = ifBodyNode;
	}
	
	/**
	 * Setter elseBody
	 * @param elseBodyNode corp de else
	 */
	public void setElseBodyNode(ElseBodyNode elseBodyNode) {
		this.elseBodyNode = elseBodyNode;
		useElse = true;
	}
	
	/**
	 * Metoda toString
	 */
	public String toString() {
		return "IfNode";
	}
	
	/**
	 * Metoda din interfata
	 */
	public void addNode(Node n) {
		
	}
	
	/**
	 * Setter pentru nivel
	 * @param l nivelul
	 */
	public void setLevel(int l) {
		level = l;
	}
	
	/**
	 * Getter pentru nivel
	 * @return nivelul
	 */
	public int getLevel() {
		return level;
	}
	
	/**
	 * Metoda care accepta visitor-ul care calculeaza rezultatul arborelui
	 */
	public void accept(NodeVisitor nodeVisitor) {
		conditionNode.accept(nodeVisitor);
		int i = 0;
		// Caut valoarea conditiei pentru a intra in ifBody sau in elseBody
		for (VariableNode v : ParseTest.buildTree.treeVariables) {
			if (v.getVariableName().equals(conditionNode.getVariableName())) {
				i = v.getValue();
			}
		}
		
		// Pentru conditie adevrata, intru in ifBody
		if (i!=0) {
			ifBodyNode.accept(nodeVisitor);
		}
		else {
			// Pentru conditie falsa intru in elseBody
			if (useElse) {
				elseBodyNode.accept(nodeVisitor);
			}
		}
		nodeVisitor.visit(this);
	}
	
	/**
	 * Metoda care accepta visitor-ul pentru afisare
	 */
	public void accept(NodeVisitorPrint nodeVisitorPrint) {
		nodeVisitorPrint.visit(this);
		
		conditionNode.accept(nodeVisitorPrint);
		
		ifBodyNode.accept(nodeVisitorPrint);
		
		// Daca am else, intru pe elseBody
		if (useElse) {
			elseBodyNode.accept(nodeVisitorPrint);
		}
	}
	
	/**
	 * Metoda pentru calculul numarului de taburi
	 */
	public void accept(NodeVisitorTab nodeVisitorTab, int level) {
		this.level = level;
		level++;		
		nodeVisitorTab.visit(this);
		
		// Vizitez conditia si ifBody
		conditionNode.accept(nodeVisitorTab, level);
		ifBodyNode.accept(nodeVisitorTab, level);
		
		// Pentru else, vizitez si elseBody
		if (useElse) {
			elseBodyNode.accept(nodeVisitorTab, level);
		}
	}
}
