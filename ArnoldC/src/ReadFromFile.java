import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Clasa pentru citirea din fisier
 * @author 
 *	
 */
public class ReadFromFile {
		/**
		 * Sir de string-uri care retine cate o linie din fisier
		 */
		private String[] set;
		
		/**
		 * Lungimea sirului
		 */
		private int lung;
		
		/**
		 * Numele fiserului
		 */
		private String fileInput;
		
		/**
		 * Constructor
		 * @param fileInput numele fisierului
		 */
		public ReadFromFile(String fileInput) {
			this.fileInput = fileInput;
		}
		
		/**
		 * Metoda care realizeaza citirea
		 */
		public void read() {
			
			BufferedReader br = null;
			int dim = 1;
			
			// Metoda try
			try {
				// Retine linia curenta
				String sCurrentLine;	
				
				// Bufferedreader ia date din fisierul fileInput
				br = new BufferedReader(new FileReader(this.fileInput));		
				String [] auxiliar = new String[1];
				auxiliar[0] = br.readLine();
				
				// Cat timp nu am ajuns la finalul fisierului
				while ((sCurrentLine = br.readLine()) != null) {
					if (!sCurrentLine.equals("")) {
						String [] parts = sCurrentLine.split(" ");
						if (parts.length > 0) {
							char [] chars = parts[0].toCharArray();
							if (chars.length > 0) {
								// Elimin tab-urile
								if (chars[0] == '	') {
									int len = chars.length;
									for (int i = 0; i < chars.length - 1; i++) {
										if (chars[i] == '	') {
											for(int j = 0; j < len - 1; j++) {
												chars[j] = chars[j+1];
											}
											len--;
											i--;
										}
									}
									String s = new String(chars);
									parts[0] = s;
								}
							}
						}
						// Transform in String sirul de caractere
						StringBuffer result = new StringBuffer();
						for (int i = 0; i < parts.length; i++) {
						   result.append( parts[i] );
						   result.append(" ");
						   //result.append( optional separator );
						}
						sCurrentLine = result.toString();
						// Realoc set, pentru inca un string
						set = new String[dim + 1];
						
						// Copiez din auxiliar in set
						for (int i = 0; i < dim; i++) {
							set[i] = auxiliar[i];
						}
						
						// Adaug noul string
						set[dim] = sCurrentLine;
						auxiliar = set;		
						dim++;
					}
				}
			
				// Pentru exceptie
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {	
					// Inchid bufferedReader
					if (br != null) 
						br.close();
				} catch (IOException ex) {
						ex.printStackTrace();
				}
			}
			lung = dim;
		}
	
		/**
		 * Getter pentru lungimea blocului de stringuri
		 * @return lungimea
		 */
		public int getDim() {
			return lung;
		}
		
		/**
		 * Getter pentru blocul de string-uri
		 * @return blocul
		 */
		public String[] getSet() {
			return set;
		}
		
		/**
		 * Metoda care elimina taburile din sirul de stringuri
		 */
		public void eliminTab() {
			ArrayList<String> words = new ArrayList<String>();
			
			// Pun cuvintele intr-un arraylist
			for (int i = 0; i < set.length; i++) {
				String [] parts = set[i].split(" ");
				for (int j = 0; j < parts.length; j++) {
					words.add(parts[j]);
				}
				
				// Sterg elementele goale
				String s = "", s1 = "";
				for (int j = 0; j < words.size(); j++) {
					if (words.get(j).equals("")) {
						words.remove(j);
						j--;
					}
				}
				
				// Reconstruiesc String-ul
				for (int j = 1; j < words.size(); j++) {
					s = s1 + " " + words.get(j);
					s1 = s;
				}
				if (words.size() > 0) {
					s1 = words.get(0) + s;
				}
				
				set[i] = s1;
				words.clear();
			}
		}
}
	