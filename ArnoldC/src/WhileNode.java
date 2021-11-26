
/**
 * Clasa while care relizeaza bucla de executat, cat
 * timp este verificata conditia
 * @author 
 *
 */
public class WhileNode implements Node{
	/**
	 * Conditia din while
	 */
	private ConditionNode conditionNode;
	
	/**
	 * Corpul de instructiuni
	 */
	private BodyNode bodyNode;
	
	/**
	 * Nivelul pe care se afla nodul
	 */
	private int level;
	
	/**
	 * Constructor
	 * @param conditionNode conditia
	 * @param bodyNode corpul de while
	 */
	public WhileNode(ConditionNode conditionNode, BodyNode bodyNode) {
		this.conditionNode = conditionNode;
		this.bodyNode = bodyNode;
	}
	
	/**
	 * Metoda preluata din interfata
	 */
	public void addNode(Node n) {
		
	}
	
	/**
	 * Metoda toString
	 */
	public String toString() {
		return "WhileNode";
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
	 */
	public int getLevel() {
		return level;
	}
	
	/**
	 * Getter pentru Body
	 * @return corpul de while
	 */
	public BodyNode getBodyNode() {
		return bodyNode;
	}
	
	/**
	 * Getter pentru conditie
	 * @return  conditia
	 */
	public ConditionNode getConditionNode() {
		return conditionNode;
	}
	
	/**
	 * Accept pentru interpretarea arborelui
	 */
	public void accept(NodeVisitor nodeVisitor) {
		conditionNode.accept(nodeVisitor);
		
		if (conditionNode.getResult()) {
			bodyNode.accept(nodeVisitor);
		}
		
		nodeVisitor.visit(this);
	}

	/**
	 * Accept pentru afisarea arborelui
	 */
	public void accept(NodeVisitorPrint nodeVisitorPrint) {
		nodeVisitorPrint.visit(this);
		
		conditionNode.accept(nodeVisitorPrint);
		
		bodyNode.accept(nodeVisitorPrint);
	}
	
	/**
	 * Accept pentru calcularea numarului de taburi
	 */
	public void accept(NodeVisitorTab nodeVisitorPrint, int level) {
		this.level = level;
		
		level++;
		
		nodeVisitorPrint.visit(this);
		
		conditionNode.accept(nodeVisitorPrint, level);
		
		bodyNode.accept(nodeVisitorPrint, level);
	
	}
}
