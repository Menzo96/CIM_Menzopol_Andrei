/**
 * Clasa care retine un string
 * @author 
 *
 */
public class StringNode implements Node {
	/**
	 * String-ul retinut
	 */
	private String string;
	
	/**
	 * Nivelul pe care se afla nodul
	 */
	private int level;
	
	/**
	 * Constructor
	 * @param string sirul
	 */
	public StringNode(String string) {
		this.string = string;
	}
	
	/**
	 * Getter string
	 * @return string
	 */
	public String getString() {
		return string;
	}
	
	/**
	 * Metoda toString
	 */
	public String toString() {
		return "StringNode" + " <" + string + ">";
	}
	
	/**
	 * Metoda preluata din interfata
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
	 */
	public int getLevel() {
		return level;
	}
	
	/**
	 * Accept pentru visitor-ul de interpretare
	 */
	public void accept(NodeVisitor nodeVisitor) {
		nodeVisitor.visit(this);
	}
	
	/**
	 * Accept pentru visitor-ul care afiseaza arborele
	 */
	public void accept(NodeVisitorPrint nodeVisitorPrint) {
		nodeVisitorPrint.visit(this);
	}
	
	/**
	 * Accept pentru visitor-ul care calculeaza numarul de taburi
	 */
	public void accept(NodeVisitorTab nodeVisitorPrint, int level) {
		this.level = level;
		nodeVisitorPrint.visit(this);
	}
}
