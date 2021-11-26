
/**
 * Clasa care extinde interfata Node si este parintele tuturor
 * claselor care creeaza noduri pentru operatiile aritmetice
 * @author 
 *
 */
public class CommonAncestor implements Node{
	
	/**
	 * accept pentru interpretarea arborelui
	 */
	public void accept(NodeVisitor nodeVisitor) { }
	
	/**
	 * accept pentru afisare arborelui
	 */
	public void accept(NodeVisitorPrint nodeVisitorPrint) { }
	
	/**
	 * accept pentru calculul taburilor pentru fiecare nod
	 */
	public void accept(NodeVisitorTab nodeVisitorTab, int level) { }
	
	/**
	 * Adaug un nod la nodul curent
	 */
	public void addNode(Node n) { }
	
	/**
	 * Returneaza valoarea continuta in nod
	 * @return 0
	 */
	public int getValue() {
		return 0;
	}
	
	/**
	 * Getter level
	 */
	public int getLevel() {
		return 0;
	}
}
