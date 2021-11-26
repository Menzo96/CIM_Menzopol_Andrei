
/**
 * Clasa care contine numele variabilei careia i se atribuie o valoare
 * @author 
 *
 */
public class LvalNode implements Node {
	/**
	 * Numele variabilei
	 */
	private String variableName;
	
	/**
	 * nivelul pe care se afla variabila
	 */
	private int level;
	
	/**
	 * Constructor
	 * @param name nume variabila
	 */
	public LvalNode(String name) {
		this.variableName = name;
	}
	
	/**
	 * Metoda toString
	 */
	public String toString() {
		return "LvalNode" + " <" + variableName + ">";
	}
	
	/**
	 * Getter pentru nume
	 * @return nume variabila
	 */
	public String getName() {
		return variableName;
	}
	
	/** 
	 * Metoda a interfatei
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
	 * @return nivelul
	 */
	public int getLevel() {
		return level;
	}
	
	/**  
	 * Accept pentru visitor-ul care interpreteaza arborele
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
