import java.util.ArrayList;

/**
 * Clasa pentru nodul main
 * @author 
 *
 */
public class MainNode extends CommonAncestor {
	/**
	 * Lista cu nodurile continute de main
	 */
	private ArrayList<Node> rootList = new ArrayList<Node>();
	
	/**
	 * Nivelul pe care se afla nodul
	 */
	private int level;
	
	/**
	 * Adaug un nod in lista
	 */
	public void addNode(Node n) {
		this.rootList.add(n);
	}
	
	/**
	 * Metoda toString
	 */
	public String toString() {
		return "MainNode";
	}
	
	/**
	 * Getter pentru lista
	 * @return lista
	 */
	public ArrayList<Node> getList() {
		return rootList;
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
	 * Accept pentru intepretarea arborelui
	 */
	public void accept(NodeVisitor nodeVisitor) {
		for (Node n : rootList) {
			n.accept(nodeVisitor);
		}
		nodeVisitor.visit(this);
	}
	
	/**
	 * Accept pentru afisarea arborelui
	 */
	public void accept(NodeVisitorPrint nodeVisitorPrint) {
		nodeVisitorPrint.visit(this);
		for (Node n : rootList) {
			n.accept(nodeVisitorPrint);
		}
	}
	
	/**
	 * Accept pentru calcularea numarului de taburi
	 */
	public void accept(NodeVisitorTab nodeVisitorTab, int level) {
		nodeVisitorTab.visit(this);
		level++;

		for (Node n : rootList) {
			n.accept(nodeVisitorTab, level);
		}
	}
}
