
/**
 * Clasa pentru nodurile de declarare
 * @author 
 *
 */
public class DeclareNode implements Node {
	/**
	 * Variabila careia i se atribuie valoarea
	 */
	private LvalNode lvalNode;
	
	/**
	 * Constanta atribuita
	 */
	private ConstantNode constantNode;
	
	/**
	 * Nivelul pe care se afla nodul
	 */
	private int level;
	
	/**
	 * Constructor
	 * @param lvalNode nume variabila
	 * @param constantNode constnta
	 */
	public DeclareNode(LvalNode lvalNode, ConstantNode constantNode) {
		this.lvalNode = lvalNode;
		this.constantNode = constantNode;
	}
	
	/**
	 * Getter pentru numele variabilei
	 * @return numele variabilei
	 */
	public String getNameVar() {
		return lvalNode.getName();
	}
	
	/**
	 * Getter pentru valoare variabilei
	 * @return valoarea
	 */
	public int getValueVar() {
		return constantNode.getValue();
	}
	
	/**
	 * Metoda toString
	 */
	public String toString() {
		return "DeclareNode";
	}
	
	/**
	 * Adaug un nod(pentru interfata)
	 */
	public void addNode(Node n) {
	}
	
	/**
	 * Accept pentru interpretarea arborelui
	 */
	public void accept(NodeVisitor nodeVisitor) {
		lvalNode.accept(nodeVisitor);
		constantNode.accept(nodeVisitor);
		nodeVisitor.visit(this);
	}
	
	/**
	 * Setter pentru nivel
	 * @param l nivel
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
	 * Accept pentru afisarea arborelui
	 */
	public void accept(NodeVisitorPrint nodeVisitorPrint) {
		nodeVisitorPrint.visit(this);
		lvalNode.accept(nodeVisitorPrint);
		constantNode.accept(nodeVisitorPrint);
	}
	
	/**
	 * Accept pentru calculul tab-urilor
	 */
	public void accept(NodeVisitorTab nodeVisitorTab, int level) {
		this.level = level;
		level++;
		nodeVisitorTab.visit(this);
		lvalNode.accept(nodeVisitorTab, level);
		constantNode.accept(nodeVisitorTab, level);
	}
}
