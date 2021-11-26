import java.util.ArrayList;

/**
 * Clasa care contine instructiunile din elseBody
 * @author 
 *
 */
public class ElseBodyNode implements Node{
	
	/**
	 * Lista pentru nodurile de executat
	 */
	private ArrayList<Node> elseBodyList = new ArrayList<Node>();
	
	/**
	 * Nivelul fata de radacina
	 */
	private int level;
	
	/**
	 * Adaug un nod
	 */
	public void addNode(Node n) {
		this.elseBodyList.add(n);
	}
	
	/**
	 * Metoda toString
	 */
	public String toString() {
		return "ElseBodyNode";
	}
	
	/**
	 * Setez nivelul fata de radacina
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
	 * Accept visitor-ul care intepreteaza arborele
	 */
	public void accept(NodeVisitor nodeVisitor) {
		for (Node n : elseBodyList) {
			n.accept(nodeVisitor);
		}
		nodeVisitor.visit(this);
	}
	
	/**
	 * Accept visitor-ul care afiseaza arborele
	 */
	public void accept(NodeVisitorPrint nodeVisitorPrint) {
		nodeVisitorPrint.visit(this);
		for (Node n : elseBodyList) {
			n.accept(nodeVisitorPrint);
		}
	}
	
	/**
	 * Accept visitor-ul care calculeaza numarul de taburi
	 */
	public void accept(NodeVisitorTab nodeVisitorTab, int level) {
		this.level = level;
		level++;
		nodeVisitorTab.visit(this);
		for (Node n : elseBodyList) {
			n.accept(nodeVisitorTab, level);
		}
	}
}
