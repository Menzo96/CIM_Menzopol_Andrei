
/**
 * Clasa care retine informatii despre un nod variabila 
 * @author 
 *
 */
public class VariableNode implements Node {
	/**
	 * Numele variabilei
	 */
	private String variableName;
	
	/**
	 * Valoarea variabilei
	 */
	private int value;
	
	/**
	 * Nivelul pe care se afla nodul
	 */
	private int level;
	
	/**
	 * Constructor
	 * @param variableName numele
	 * @param value valoarea
	 */
	public VariableNode(String variableName, int value) {
		this.variableName = variableName;
		this.value = value;
	}
	
	/**
	 * Setter valoare
	 * @param v tip operatie
	 */
	public void setValue(int v) {
		this.value = v;
	}
	
	/**
	 * Getter pentru numele variabilei
	 * @return numele variabilei
	 */
	public String getVariableName() {
		return variableName;
	}
	
	/**
	 * Getter pentru valoare
	 * @return valoarea calcului subarborelui
	 */
	public int getValue() {
		return value;
	}
	
	/**
	 * Metoda toString
	 */
	public String toString() {
		return "VariableNode" + " <" + variableName + ">";
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
	 * Accept pentru interpretare
	 */
	public void accept(NodeVisitor nodeVisitor) {
	}
	
	/**
	 * Accept pentru afisare
	 */
	public void accept(NodeVisitorPrint nodeVisitorPrint) {
		nodeVisitorPrint.visit(this);
	}
	
	/**
	 * Accept pentru calcularea numarului da taburi
	 */
	public void accept(NodeVisitorTab nodeVisitorPrint, int level) {
		this.level = level;
		nodeVisitorPrint.visit(this);
	}
}
