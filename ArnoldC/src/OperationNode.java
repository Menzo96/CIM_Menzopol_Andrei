
/**
 * Clasa care implementeaza toate operatiile
 * @author 
 *
 */
public class OperationNode extends CommonAncestor {

	/**
	 * Nodul copil stanga
	 */
	CommonAncestor c1;
	
	/**
	 * Nodul copil din dreapta
	 */
	CommonAncestor c2;
	
	/**
	 * Nivelul pe care se afla nodul fata de nodul de main
	 */
	int level;
	
	/**
	 * In value retin valoarea calculata in subarbore
	 */
	int value;
	
	/**
	 * Operatia de executat
	 */
	private char operation;
	
	/**
	 * Constructor
	 * @param c1 copil 1
	 * @param c2 copil 2
	 * @param c tip operatie
	 */
	public OperationNode (CommonAncestor c1, CommonAncestor c2, char c) {
		this.c1 = c1;
		this.c2 = c2;
		this.operation = c;
	}
	
	/**
	 * In functie de operatia nodului avem output diferit
	 */
	public String toString() {
		if (operation == '+') {
			return "SumNode";
		}
		if (operation == '-') {
			return "DifferenceNode";
		}
		if (operation == '*') {
			return "MultiplicationNode";
		}
		if (operation == '/') {
			return "DivisionNode";
		}
		if (operation == '%') {
			return "ModuloNode";
		}
		if (operation == '=') {
			return "EqualToNode";
		}
		if (operation == '>') {
			return "GreaterThanNode";
		}
		if (operation == '&') {
			return "AndNode";
		}
		if (operation == 'v') {
			return "OrNode";
		}
		
		return null;
	}
	
	/**
	 * Getter pentru tipul operatiei
	 * @return tip operatie
	 */
	public char getOperationType() {
		return operation;
	}
	
	/**
	 * Getter pentru value
	 */
	public int getValue() {
		return value;
	}
	
	/**
	 * Setter pentru level
	 * @param l nivelul fata de radacina
	 */
	public void setLevel(int l) {
		level = l;
	}
	
	/**
	 * Getter pentru level
	 * @return nivelul
	 */
	public int getLevel() {
		return level;
	}
	
	/**
	 * Metoda care accepta visitor-ul care calculeaza rezultatul arborelui
	 */
	public void accept(NodeVisitor nodeVisitor) {
		c1.accept(nodeVisitor);
		c2.accept(nodeVisitor);
		nodeVisitor.visit(this);
	}
	
	/**
	 * Metoda care accepta visitor-ul care afiseaza arborele
	 */
	public void accept(NodeVisitorPrint nodeVisitorPrint) {
		nodeVisitorPrint.visit(this);
		c1.accept(nodeVisitorPrint);
		c2.accept(nodeVisitorPrint);
	}
	
	/**
	 * Metoda pentru visitor-ul care calculeaza numarul de tab-uri
	 */
	public void accept(NodeVisitorTab nodeVisitorTab, int level) {
		this.level = level;
		level++;
		nodeVisitorTab.visit(this);
		c1.accept(nodeVisitorTab, level);
		c2.accept(nodeVisitorTab, level);
	}
}

	

