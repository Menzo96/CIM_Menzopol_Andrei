
/**
 * Clasa care contine valoarea unui nod de tip constanta
 * @author 
 *
 */
public class ConstantNode extends CommonAncestor {
	
	/**
	 * Valoarea constantei
	 */
	private int value;
	
	/**
	 * Indicator pentru variabila de tip bool
	 */
	private boolean isBoolean = false;
	
	/**
	 * Nivelul fata de radacina
	 */
	private int level;
	
	/**
	 * Constructor
	 * @param value valoarea constantei
	 * @param b este de tip bool?
	 */
	public ConstantNode(int value, char b) {
		this.value = value;
		if (b == 'b') {
			this.isBoolean = true;
		}
	}
	
	/**
	 * Getter pentru valoare
	 */
	public int getValue() {
		return value;
	}
	
	/**
	 * Este constanta booleana?
	 * @return true/false
	 */
	public boolean isBoolean() {
		return isBoolean;
	}
	
	/**
	 * Metoda toString
	 */
	public String toString() {
		return "ConstantNode" + " <" + value + ">";
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
		nodeVisitor.visit(this);
	}
	
	/**
	 * Metoda care accepta visitor-ul care afiseaza arborele
	 */
	public void accept(NodeVisitorPrint nodeVisitorPrint) {
		nodeVisitorPrint.visit(this);
	}
	
	/**
	 * Metoda pentru visitor-ul care calculeaza numarul de tab-uri
	 */
	public void accept(NodeVisitorTab nodeVisitorTab, int level) {
		this.level = level;
		nodeVisitorTab.visit(this);
	}
}
