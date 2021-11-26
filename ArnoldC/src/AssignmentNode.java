
/**
 * 
 * @author  
 * Clasa care face atribuirea de valori unor variabile
 *
 */
public class AssignmentNode implements Node {
	/**
	 * Numele variabilei care primeste valoarea
	 */
	private LvalNode lvalNode;
	
	/**
	 * Variabila care "ofera" valoarea
	 * Poate fi const, variabila sau subarbore de operatii
	 */
	private CommonAncestor commAnc;
	
	/**
	 * Nivelul fata de radacina pe care se gaseste nodul
	 */
	private int level;
	
	/**
	 * Constructor
	 * @param lN leftNode
	 * @param cA nodul de unde se atribuie valoarea
	 */
	public AssignmentNode(LvalNode lN, CommonAncestor cA) {
		this.lvalNode = lN;
		this.commAnc = cA;
	}
	
	/**
	 * Getter pentru valoarea calculata
	 * @return valoarea
	 */
	public int getValue() {
		return commAnc.getValue();
	}
	
	/**
	 * Trebuie sa existe, din interfata
	 */
	public void addNode(Node n) {
		
	}
	
	/**
	 * Getter pentru numele variabilei
	 * @return variableName
	 */
	public String getVariableName() {
		return lvalNode.getName();
	}
	
	/**
	 * Metoda toString
	 */
	public String toString() {
		return "AssignmentNode";
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
		lvalNode.accept(nodeVisitor);
		
		commAnc.accept(nodeVisitor);
		
		nodeVisitor.visit(this);
	}
	
	/**
	 * Metoda care accepta visitor-ul care afiseaza arborele
	 */
	public void accept(NodeVisitorPrint nodeVisitorPrint) {
		nodeVisitorPrint.visit(this);

		lvalNode.accept(nodeVisitorPrint);
		
		commAnc.accept(nodeVisitorPrint);
		
	}
	
	/**
	 * Metoda pentru visitor-ul care calculeaza numarul de tab-uri
	 */
	public void accept(NodeVisitorTab nodeVisitorTab, int level) {
		this.level = level;
		level++;
		
		nodeVisitorTab.visit(this);
		
		lvalNode.accept(nodeVisitorTab, level);
		
		commAnc.accept(nodeVisitorTab, level);
		
	}
}
