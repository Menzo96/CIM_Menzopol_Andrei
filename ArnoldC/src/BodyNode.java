import java.util.ArrayList;

/**
 * 
 * @author 
 *	Clasa corpului de while. Retine instructiunile care se executa in while.
 */
public class BodyNode implements Node{
	
	/**
	 * Lista cu nodurile instructiunilor
	 */
	private ArrayList<Node> whileBodyList = new ArrayList<Node>();
	
	/**
	 * Nivelul pe care se afla nodul fata de radacina
	 */
	private int level;
	
	/**
	 * Adaug un nod in lista
	 */
	public void addNode(Node n) {
		this.whileBodyList.add(n);
	}
	
	/**
	 * Metoda toString
	 */
	public String toString() {
		return "BodyNode";
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
		for (Node n : whileBodyList) {
			n.accept(nodeVisitor);
		}
		nodeVisitor.visit(this);
	}
	
	/**
	 * Metoda care accepta visitor-ul care afiseaza arborele
	 */
	public void accept(NodeVisitorPrint nodeVisitorPrint) {
		nodeVisitorPrint.visit(this);
		for (Node n : whileBodyList) {
			n.accept(nodeVisitorPrint);
		}
	}
	
	/**
	 * Metoda pentru visitor-ul care calculeaza numarul de tab-uri
	 */
	public void accept(NodeVisitorTab nodeVisitorTab, int level) {
		this.level = level;
		level++;
		
		nodeVisitorTab.visit(this);
		for (Node n : whileBodyList) {
			n.accept(nodeVisitorTab, level);
		}
	}
}
