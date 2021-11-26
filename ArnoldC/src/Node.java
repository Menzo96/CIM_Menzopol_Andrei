
/**
 * Interfata implementata de toate nodurile din arbore
 * @author 
 *
 */
public interface Node {
	/**
	 * Accept pentru visitorul care interpreteaza arborele
	 * @param nodeVisitor visitor interpretare
	 */
	public void accept (NodeVisitor nodeVisitor);
	
	/**
	 * Accept pentru visitorul care afiseaza arborele
	 * @param nodeVisitorPrint visitor afisare
	 */
	public void accept (NodeVisitorPrint nodeVisitorPrint);
	
	/** 
	 * Accept pentru visitor-ul care calculeaza numarul de tab-uri
	 * @param nodeVisitorTab visitor calcultab-uri
	 * @param level nivelul
	 */
	public void accept (NodeVisitorTab nodeVisitorTab, int level);
	
	/**
	 * Metoda pentru adaugarea unui nou copil
	 * @param node nodul de adaugat
	 */
	public void addNode (Node node);
	
	/**
	 * Getter nivel
	 * @return nivelul
	 */
	public int getLevel();
}
