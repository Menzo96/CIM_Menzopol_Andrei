import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 
 * @author 
 *
 */
public class NodeVisitorPrintImpl implements NodeVisitorPrint{
	
	/**
	 * Scriu in fisier arborele
	 */
	public void visit(Node n) {
		/**
		 * Se prelucreaza numele fisierului de intrare pentru a obtine numele
		 * fisierului de iesire
		 */
		String [] words = ParseTest.filename.split("/");
		char [] letters = words[1].toCharArray();
		
		char [] nou = new char[letters.length - 2];
		for (int i = 0; i < nou.length; i++) {
			nou[i] = letters[i];
		}
		
		String newName = new String(nou);
		String fileName = "./outputs/" + newName + "ast";

		File log = new File(fileName);
		
		// Dupa ce am construit numele fisierului de iesire, afisez arborele in el
		try{
		    if(!log.exists()){
		    	log.createNewFile();
		    }
		    FileWriter fileWriter = new FileWriter(log, true);
		    BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
		    
		    // Scriu mai intai tab-urile
			for (int i = 0; i < n.getLevel(); i++) {
				bufferedWriter.write("	");
			}
			// Afisez informatia din nod
			bufferedWriter.write(n.toString());
			bufferedWriter.write("\n");
			bufferedWriter.close();
		} catch(IOException e) {
		    
		}
	}		
	
}



