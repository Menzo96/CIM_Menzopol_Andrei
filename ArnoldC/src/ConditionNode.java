
/**
 * Clasa conditie folosita de if si de while
 * @author 
 *
 */
public class ConditionNode implements Node{
	
	/**
	 * Variabila folosita ca si verificare (0 sau 1)
	 */
	private VariableNode variable;
	
	/**
	 * Nivelul fata de radacina
	 */
	private int level;
	
	/**
	 * Constructor
	 * @param variable variabila-conditie
	 */
	public ConditionNode(VariableNode variable) {
		this.variable = variable;
	}
	
	/**
	 * Getter pentru valoare conditiei
	 * @return 0/1
	 */
	public boolean getResult() {
		if (variable.getValue() == 0) {
			return false;
		}
		return true;
	}
	
	/**
	 * Setez noua valoare a conditiei
	 * @param res valoarea
	 */
	public void setResult(int res) {
		variable.setValue(res);
	}
	
	/**
	 * Metoda toString pentru afisare
	 */
	public String toString() {
		return "ConditionNode <" + variable.getVariableName() + ">" ;
	}
	
	/**
	 * Getter pentru numele variabilei
	 * @return nume variabila
	 */
	public String getVariableName() {
		return variable.getVariableName();
	}
	
	/**
	 * Metoda adaugare nod, trebuie sa fie (pentru interfata)
	 */
	public void addNode(Node n) {
	}
	
	/**
	 * Setez nivelul nodului
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
	public void accept(NodeVisitorTab nodeVisitorPrint, int level) {
		this.level = level;
		nodeVisitorPrint.visit(this);
	}
}
