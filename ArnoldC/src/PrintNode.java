
/**
 * Clasa care afiseaza informatia unui nod
 * Poate primi un mesaj, constanta sau variabila
 * @author 
 *
 */
public class PrintNode implements Node {
	
	public StringNode stringNode;
	public VariableNode variableNode;
	public ConstantNode constantNode;
	boolean constantN = false;
	boolean variableN = false;
	boolean stringN = false;
	private int level;
	
	/**
	 * Constructor pentru nod string
	 * @param stringNode sirul
	 */
	public PrintNode(StringNode stringNode) {
		this.stringNode = stringNode;
		this.stringN = true;
	}
	
	/**
	 * Constructor pentru nod constant
	 * @param constantNode constnta
	 */
	public PrintNode(ConstantNode constantNode) {
		this.constantNode = constantNode;
		this.constantN = true;
	}
	
	/**
	 * Contructor pentru nod variabila
	 * @param variableNode variabila
	 */
	public PrintNode(VariableNode variableNode) {
		this.variableNode = variableNode;
		this.variableN = true;
	}
	
	/**
	 * Metoda toString
	 */
	public String toString() {
		return "PrintNode";
	}
	
	/**
	 * Metoda din interfata
	 */
	public void addNode(Node n) {
	}
	
	/**
	 * Setter nivel
	 * @param l nivelul
	 */
	public void setLevel(int l) {
		level = l;
	}
	
	/**
	 * Getter nivel
	 */
	public int getLevel() {
		return level;
	}
	
	/**
	 * Accept pentru interpretarea arborelui
	 */
	public void accept(NodeVisitor nodeVisitor) {
		
		if (constantN) {
			constantNode.accept(nodeVisitor);
		}
		
		if (stringN) {
			stringNode.accept(nodeVisitor);
		}
		
		if (variableN) {
			variableNode.accept(nodeVisitor);
		}
		nodeVisitor.visit(this);
	}
	
	/**
	 * Accept pentru afisarea arborelui
	 */
	public void accept(NodeVisitorPrint nodeVisitorPrint) {
		nodeVisitorPrint.visit(this);
		if (constantN) {
			constantNode.accept(nodeVisitorPrint);
		}
		
		if (stringN) {
			stringNode.accept(nodeVisitorPrint);
		}
		
		if (variableN) {
			variableNode.accept(nodeVisitorPrint);
		}
	}
	
	/**
	 * Accept pentru calcularea numarului de taburi
	 */
	public void accept(NodeVisitorTab nodeVisitorTab, int level) {
		this.level = level;
		level++;
		nodeVisitorTab.visit(this);
		if (constantN) {
			constantNode.accept(nodeVisitorTab, level);
		}
		
		if (stringN) {
			stringNode.accept(nodeVisitorTab, level);
		}
		
		if (variableN) {
			variableNode.accept(nodeVisitorTab, level);
		}
	}
}
