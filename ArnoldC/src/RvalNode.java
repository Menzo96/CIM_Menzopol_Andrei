
/**
 * Clasa Rval contine numele unei variabile folosite in operatii
 * @author 
 *
 */
public class RvalNode extends CommonAncestor {
	/**
	 * Numele variabilei
	 */
	private String variableName;
	
	/**
	 * Nivelul pe care se afla variabila
	 */
	private int level;
	
	/** Constructor
	 * @param name nume variabila
	 */
	public RvalNode(String name) {
		this.variableName = name;
	}
	
	/**
	 * Metoda toString
	 */
	public String toString() {
		return "RvalNode" + " <" + variableName + ">";
	}
	
	/**
	 * Getter pentru nume
	 * @return numele variabilei
	 */
	public String getName() {
		return variableName;
	}
	
	/**
	 * Getter pentru valoare, o caut in lista de variabile din arbore
	 */
	public int getValue() {
		for (VariableNode v :ParseTest.buildTree.treeVariables) {
			if (v.getVariableName().equals(variableName)) {
				return v.getValue();
			}
		}
		return 0;
	}
	
	/**
	 * Setter nivel
	 * @param l nivelul
	 */
	public void setLevel(int l) {
		level = l;
	}
	
	/**
	 * Getter nivel
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
	 * Accept pentru visitor-ul care printeaza arborele
	 */
	public void accept(NodeVisitorPrint nodeVisitorPrint) {
		nodeVisitorPrint.visit(this);
	}
	
	/**
	 * Accept pentru visitor-ul care calculeaza numarul de tab-uri
	 */
	public void accept(NodeVisitorTab nodeVisitorPrint, int level) {
		this.level = level;
		nodeVisitorPrint.visit(this);
	}
}
