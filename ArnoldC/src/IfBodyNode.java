import java.util.ArrayList;

/**
 * Clasa care contine instructiunile din corpul if-ului
 * @author 
 *
 */
public class IfBodyNode implements Node{
	/**
	 * Lista pentru nodurile de executat
	 */
	private ArrayList<Node> ifBodyList = new ArrayList<Node>();
	
	/**
	 * Nivelul fata de radacina
	 */
	private int level;
	
	/**
	 * Adaug un nod
	 */
	public void addNode(Node n) {
		this.ifBodyList.add(n);
	}
	
	/**
	 * Metoda toString
	 */
	public String toString() {
		return "IfBodyNode";
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
		for (Node n : ifBodyList) {
			n.accept(nodeVisitor);
		}
		nodeVisitor.visit(this);
	}
	
	/**
	 * Accept visitor-ul care afiseaza arborele
	 */
	public void accept(NodeVisitorPrint nodeVisitorPrint) {
		nodeVisitorPrint.visit(this);
		for (Node n : ifBodyList) {
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
		for (Node n : ifBodyList) {
			n.accept(nodeVisitorTab, level);
		}
	}

}
