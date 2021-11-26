
/**
 * Clasa Main
 * Realizeaza operatiile importante
 * @author 
 */
public class ParseTest {
	/**
	 * Nodul main
	 */
	public static MainNode main;
	
	/**
	 * Obiect care construieste arborele
	 */
	
	public static BuildTree buildTree;
	
	/**
	 * Numele fisierului
	 */
	public static String filename;

	
	public static void main(String [] args) {

		filename = args[0];
		
		main = new MainNode();
		
		// Cu datele din fisier construiesc arborele
		try {
			buildTree = new BuildTree(args[0]);
			buildTree.rise();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		int level = 0;
		
		// Calculez numarul de taburi
		main.accept(new NodeVisitorTabImpl(), level);
		
		// Interpretez arborele
		main.accept(new NodeVisitorImpl());
		
		// Afisez arborele
		main.accept(new NodeVisitorPrintImpl());
	}
}
