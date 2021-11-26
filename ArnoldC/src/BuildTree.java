import java.util.ArrayList;
import java.util.Stack;

/**
 * @author 
 * Clasa care construieste arborele
 */
public class BuildTree {
	
	/** 
	 * Setul de instructiuni pe care il citesc din fisier
	 */
	String [] set;
	
	/**
	 * Pozitia curenta in setul de instructiuni
	 */
	static int pos;
	
	/**
	 * Nivelul curent pe care trebuie sa adaug nodurile
	 */
	int level;
	
	/**
	 * Nodul curent la care lipesc un nod nou creat
	 */
	
	Node curent;
	/**
	 * Lista cu variabilele din arbore 
	 */
	ArrayList<VariableNode> treeVariables;
	
	/** Stiva cu nodurile curente din arbore
	 * 
	 */
	Stack<Node> curents;
	
	/**
	 * Constructor
	 * @param filename numele fisierului
	 */
	public BuildTree(String filename) throws Exception {
		
		if(filename == null)
			throw new Exception("input file null");
		
		ReadFromFile read = new ReadFromFile(filename);
		
		// Citire din fisier
		read.read();
		read.eliminTab();
		
		set = new String[read.getDim()];
		set = read.getSet();
		pos = 1;	
		
		// Nodul de la care pornesc este main
		curent = ParseTest.main;								
		treeVariables = new ArrayList<VariableNode>();
		curents = new Stack<Node>();
		
		// Adaug in stiva nodul main
		curents.push(ParseTest.main);
		level = 0;
	}
	
	/**
	 * Constructor
	 * @param filename numele fisierului
	 */
	public BuildTree(String filename, boolean enable) {
		
		int times = 0;
		
		if (enable)
		{
			times = 10000;
		}
		
		for(int i = 0; i < times; i++)
		{
			ReadFromFile read = new ReadFromFile(filename);
			
			// Citire din fisier
			read.read();
			read.eliminTab();
			
			set = new String[read.getDim()];
			set = read.getSet();
			pos = 1;	
			
			// Nodul de la care pornesc este main
			curent = ParseTest.main;								
			treeVariables = new ArrayList<VariableNode>();
			curents = new Stack<Node>();
			
			// Adaug in stiva nodul main
			curents.push(ParseTest.main);
			level = 0;
		}
	}

	
	/**
	 * Caut o variabila in lista de variabile
	 * @param s numele dupa care o caut
	 * @return variabila
	 */
	public VariableNode searchVariable(String s) {
		for (VariableNode v : treeVariables) {
			if (v.getVariableName().equals(s)) {
				return v;
			}
		}
		return null;
	}
	
	/**
	 * Metoda care transforma un vector de string in arrayList
	 * @param str vectorul de string
	 * @return lista
	 */
	private ArrayList<String> toArrayList(String [] str) {    // Metoda care transforma un vector de string in arrayList			
		ArrayList<String> array = new ArrayList<String>();
		for (int i = 0; i < str.length; i++) {
			array.add(str[i]);
		}
		return array;
	}
	
	/**
	 * Metoda care elimina spatiile in arrayList
	 * @param array lista de transformat
	 * @return noua lista
	 */
	private ArrayList<String> eraseSpaces(ArrayList<String> array) {			// Metoda care elimina spatiile dintr un arrayList
		for (int i = array.size() - 1; i >= 0; i--) {
			if (array.get(i).equals("")) {
				array.remove(i);
			}
		}
		return array;
	}
	
	/**
	 * Verific daca o linie din fisier este un "if" valid
	 * @param array lista de cuvinte
	 * @return true/false
	 */
	public boolean isIf(ArrayList<String> array) {
		if(array == null)
			return false;
		
		if (array.size() == 7 && (array.get(0) +  array.get(1) + array.get(2) +
				array.get(3) +  array.get(4) + array.get(5)).equals("BECAUSEI'MGOINGTOSAYPLEASE")) {       
			return true;
		}
		return false;
	}
	
	/**
	 * Verifica daca o linie din fisier este "endIf" valid
	 * @param array lista de cuvinte
	 * @return true/false
	 */
	public boolean isEndIf(ArrayList<String> array) {
		if(array == null)
			return false;
		
		if (array.size() == 6 && (array.get(0) +  array.get(1) + array.get(2) +
				array.get(3) +  array.get(4) + array.get(5)).equals("YOUHAVENORESPECTFORLOGIC")) {       
			return true;
		}
		return false;
	}
	
	/**
	 * Verific daca o linie din fisier este "while" valid
	 * @param array lista de cuvinte
	 * @return true/false
	 */
	public boolean isWhile(ArrayList<String> array) {
		if(array == null)
			return false;
		
		if (array.size() == 3 && (array.get(0) +  array.get(1)).equals("STICKAROUND")) {      
			return true;
		}
		return false;
	}
	
	/**
	 * Verific daca o linie din fisier este "declare" valid
	 * @param array lista de cuvinte
	 * @return true/false
	 */
	public boolean isDeclare(ArrayList<String> array) {
		if(array == null)
			return false;
		
		if (array.size() == 4 && (array.get(0) +  array.get(1) + array.get(2)).equals("HEYCHRISTMASTREE")) {       
			return true;
		}
		return false;
	}
	
	/**
	 * Verific daca o linie din fisier este "print" valid
	 * @param array lista de cuvinte
	 * @return true/false
	 */
	public boolean isPrint(ArrayList<String> array) {
		if(array == null)
			return false;
		
		if ((array.get(0) +  array.get(1) + array.get(2) + array.get(3)).equals("TALKTOTHEHAND")) {       
			return true;
		}
		return false;
	}
	
	/**
	 * Verific daca o linie din fisier este "assignment" valid
	 * @param array lista de cuvinte
	 * @return true/false
	 */
	public boolean isAssignVariable(ArrayList<String> array) {
		if(array == null)
			return false;
		
		if ((array.get(0) +  array.get(1) + array.get(2) + array.get(3)).equals("GETTOTHECHOPPER")) {       			
			return true;
		}
		return false;
	}
	
	/**
	 * Verific daca o linie din fisier este "sum" valid
	 * @param array lista de cuvinte
	 * @return true/false
	 */
	public boolean isPlusOperator(ArrayList<String> array) {
		if(array == null)
			return false;
		
		if (array.size() == 3 && (array.get(0) +  array.get(1)).equals("GETUP")) {       			
			return true;
		}
		return false;
	}
	
	/**
	 * Verific daca o linie din fisier este "difference" valid
	 * @param array lista de cuvinte
	 * @return true/false
	 */
	public boolean isMinusOperator(ArrayList<String> array) {
		if(array == null)
			return false;
		
		if (array.size() == 3 && (array.get(0) +  array.get(1)).equals("GETDOWN")) {       			
			return true;
		}
		return false;
	}
	
	/**
	 * Verific daca o linie din fisier este "multiplication" valid
	 * @param array lista de cuvinte
	 * @return true/false
	 */
	public boolean isMultiplicationOperator(ArrayList<String> array) {
		if(array == null)
			return false;
		
		if (array.size() == 3 && (array.get(0) +  array.get(1)).equals("YOU'REFIRED")) {       			
			return true;
		}
		return false;
	}
	
	/**
	 * Verific daca o linie din fisier este "division" valid
	 * @param array lista de cuvinte
	 * @return true/false
	 */
	public boolean isDivisionOperator(ArrayList<String> array) {
		if(array == null)
			return false;
		
		if (array.size() == 5 && (array.get(0) + array.get(1)+ array.get(2) + array.get(3)).equals("HEHADTOSPLIT")) {       			
			return true;
		}
		return false;
	}
	
	/**
	 * Verific daca o linie din fisier este "modulo" valid
	 * @param array lista de cuvinte
	 * @return true/false
	 */
	public boolean isModuloOperator(ArrayList<String> array) {
		if(array == null)
			return false;
		
		if (array.size() == 5 && (array.get(0) + array.get(1) + array.get(2) + array.get(3)).equals("ILETHIMGO")) {
			return true;
		}
		return false;
	}
	
	/**
	 * Verific daca o linie din fisier este "toEqual" valid
	 * @param array lista de cuvinte
	 * @return true/false
	 */
	public boolean isEqualTo(ArrayList<String> array) {
		if(array == null)
			return false;
		
		if (array.size() == 9 && (array.get(0) + array.get(1) + array.get(2) + array.get(3)+ array.get(4) + array.get(5) + array.get(6)).equals("YOUARENOTYOUYOUAREME")) {       			// este == valid
			return true;
		}
		if (array.size() == 8 && (array.get(0) + array.get(1) + array.get(2) + array.get(3)+ array.get(4) + array.get(5) + array.get(6)).equals("YOUARENOTYOUYOUAREME")) {       			// este == valid
			return true;
		}
		return false;
	}
	
	/**
	 * Verific daca o linie din fisier este "greaterThan" valid
	 * @param array lista de cuvinte
	 * @return true/false
	 */
	public boolean isGreaterThan(ArrayList<String> array) {
		if(array == null)
			return false;
		
		if (array.size() == 6 && (array.get(0) + array.get(1) + array.get(2) + array.get(3)+ array.get(4)).equals("LETOFFSOMESTEAMBENNET")) {      
			return true;
		}
		return false;
	}
	
	/**
	 * Verific daca o linie din fisier este "or" valid
	 * @param array lista de cuvinte
	 * @return true/false
	 */
	public boolean isOr(ArrayList<String> array) {
		if(array == null)
			return false;
		
		if (array.size() == 5 && (array.get(0) + array.get(1) + array.get(2) + array.get(3)).equals("CONSIDERTHATADIVORCE")) {       			
			return true;
		}
		return false;
	}
	
	/**
	 * Verific daca o linie din fisier este "and" valid
	 * @param array lista de cuvinte
	 * @return true/false
	 */
	public boolean isAnd(ArrayList<String> array) {
		if(array == null)
			return false;
		
		if (array.size() == 3 && (array.get(0) + array.get(1)).equals("KNOCKKNOCK")) {       			
			return true;
		}
		return false;
	}
	
	/**
	 * Construiesc un DeclareNod in functie de informatia copiilor
	 * @param words lista de de cuvinte
	 * @return obiect DeclareNode
	 */
	private DeclareNode buildDeclareNode(ArrayList<String> words) {
		// Cresc pozitia lui pos pentru a citit randul urmator
		pos = pos + 1;							
		
		// Parsez linia urmatoare pentru a lua valoarea variabilei
		String [] parts2 = set[pos].split(" ");
		ArrayList<String> setInitialValue = new ArrayList<String>();
		setInitialValue = toArrayList(parts2);
		setInitialValue = eraseSpaces(setInitialValue);	
		
		// Daca b = 'b', atunci constanta este booleana
		char b = '0';
		int value = 0;
		
		// Dimensiuniea sirului este 6, deci avem constanta bool
		if (setInitialValue.size() == 6) {			
			b = 'b';
			// Pentru "PROBLEMO", constanta devine 1 
			if (setInitialValue.get(5).equals("PROBLEMO")) {
				value = 1;
			}
		} else {
			// Pentru dimensiune 5, avem o constanta intreaga
			value = Integer.valueOf(setInitialValue.get(4)); // altfel, noua valoare
		}
		
		// Creez un obiect Lval(numele variabilei)
		LvalNode lval = new LvalNode(words.get(3));
		
		// Creez un obiect ConstanteNode
		ConstantNode constantN = new ConstantNode(value, b);
		
		// Adaug noua variabila in lista
		treeVariables.add(new VariableNode(lval.getName(), constantN.getValue()));

		// Creez obiectul DeclareNode
		DeclareNode declareNode = new DeclareNode(lval, constantN);
		return declareNode;
	}
	
	/**
	 * Creez un obiect de tip PrintNode, care va afisa variabila data ca parametru
	 * @param words lista de cuvinte
	 * @param linie linia din fisier
	 * @return obiect PrintNode
	 * @throws Exception 
	 */
	public PrintNode buildPrintNode(ArrayList<String> words, String linie) throws Exception { 			// construiesc print node
		
		if((words == null) || (linie == null))
			throw new Exception("null input arguments");
		
		PrintNode printNode = null;
		char [] letters = linie.toCharArray();
		
		// Verific daca mesajul de printat este un sir
		if (letters[letters.length - 1] == '\"') {
			String [] parts = linie.split("\"");
			StringNode string = new StringNode(parts[1]);
			printNode = new PrintNode(string);
	
		}
		
		// Verific daca mesajul este un intrg
		else if (words.get(words.size() - 1).matches("\\d+")) {
				int value = Integer.valueOf(words.get(words.size() - 1));
				ConstantNode constantN = new ConstantNode(value, '0');
				printNode = new PrintNode(constantN);
				
		} else {
				// Altfel, printez continutul unei variabile
				printNode = new PrintNode(searchVariable(words.get(words.size() - 1)));
		}

		return printNode;
	}
	
	/**
	 * Construiesc un nod de tipul AssignmentNode
	 * @param words lista de cuvinte
	 * @return obiect AssignmentNode
	 * @throws Exception 
	 */
	public AssignmentNode buildAssignmentNode(ArrayList<String> words) {
		
		if(words.size() < 5)
			return null;
		
		// Construiesc Lval
		LvalNode lval = new LvalNode(words.get(4));		

		// Trec la urmatorul rand
		pos = pos + 1;	
		String [] parts;
		
		// Liste de cuvinte in cazul in care Assignment nod contine un subarbore de operatii
		ArrayList<String> words1 = new ArrayList<String>();
		ArrayList<String> words2 = new ArrayList<String>();
		
		// instructions numara cate operatii sunt in zona de assignment
		int instructions = 0;
		int posCopy = pos;
		AssignmentNode assignmentNode = null;
		
		// Numar instructiunile pana ajung la "ENOUGH TALK"
		while (!set[posCopy].equals("ENOUGH TALK")) {
			instructions++;
			posCopy = posCopy + 1;
		}
		
		// AssignmentNode are in dreapta un nod frunza(atribuire simpla)
		if (instructions == 1) {
			
			parts = set[pos].split(" ");
			words = toArrayList(parts);
			words = eraseSpaces(words);
			
			// Verific daca atribui o variabila booleana
			String [] atSignParts = set[pos].split("@");
			if (atSignParts.length == 2) {			
				
				// Pentru "NO PROBLEMO", constuiesc o constanta = 1
				if (atSignParts[1].equals("NO PROBLEMO")) {
					
					// Creez obiectul ConstantNode
					ConstantNode constantNode = new ConstantNode(1, 'b');
					assignmentNode = new AssignmentNode(lval, constantNode);
				} 
				// Pentru "I LIED", construiesc o constanta = 0
				if (atSignParts[1].equals("I LIED")) {
					
					// Construiesc obiectul ConstantNode si AssignmentNode
					ConstantNode constantNode = new ConstantNode(0, 'b');
					assignmentNode = new AssignmentNode(lval, constantNode);
				}
			} else {
				// Pentru un numar intreg fac casta de la String la Integer
				if (words.get(4).matches("\\d+")) {
					
					// Construiesc ConstanteNode care contine valoarea intreaga si apoi ConstanteNode
					ConstantNode constantNode = new ConstantNode(Integer.valueOf(words.get(4)), '0');
					assignmentNode = new AssignmentNode(lval, constantNode);
				} else {
					
					// In caz contrar, se atribuie o variabila
					RvalNode rvalNode = new RvalNode(words.get(4));
					assignmentNode = new AssignmentNode(lval, rvalNode);
				}
			}
		} else {
			
			//   Variabile CommonAncestor care ma ajuta sa retin variabilele 
			// din subarborele de operatii al lui AssignmentNode(daca exista)
			CommonAncestor commonAncestor1 = null;
			CommonAncestor commonAncestor2 = null;
			
			// Aceasta variabila uneste intr-o operatie 2 noduri copil
			CommonAncestor commonAncestorMid = null;
			
			// Construiesc de jos in sus copiii
			// Primul copil nod
			parts = set[pos].split(" ");
			words1 = toArrayList(parts);
			words1 = eraseSpaces(words1);
			String [] atSignParts = set[pos].split("@");
			
			// Verific daca se atribuie o constanta booleana
			if (atSignParts.length == 2) {			
				 
				// Pentru "NO PROBLEMO" am 1
				if (atSignParts[1].equals("NO PROBLEMO")) {
					commonAncestor1 = new ConstantNode(1, 'b');
				} 
				
				// Pentru "I LIED" am 0
				if (atSignParts[1].equals("I LIED")) {

					 commonAncestor1 = new ConstantNode(0, 'b');
				}
			} else {
				// Verific daca am valoare intreaga
				if (words1.get(words1.size() - 1).matches("\\d+")) {
					commonAncestor1 = new ConstantNode(Integer.valueOf(words1.get(4)), '0');
				} else {
					// Verific daca am o variabila
					commonAncestor1 = new RvalNode(words1.get(4));		
				}
			}

			pos++;
			// Trec la pozitia urmatoare
			parts = set[pos].split(" ");
			words2 = toArrayList(parts);
			words2 = eraseSpaces(words2);
			atSignParts = set[pos].split("@");
			
			pos++;
			
			// Pentru cel de-al doilea copil
			if (atSignParts.length == 2) {			
				
				// Analog ca la copilul verific cazurile de bool, constanta, variabila
				if (atSignParts[1].equals("NO PROBLEMO")) {
					commonAncestor2 = new ConstantNode(1, 'b');
				} 
				if (atSignParts[1].equals("I LIED")) {

					 commonAncestor2 = new ConstantNode(0, 'b');
				}
			} else {

				if (words2.get(words2.size() - 1).matches("\\d+")) {
				
					commonAncestor2 = new ConstantNode(Integer.valueOf(words2.get(words2.size() - 1)), '0');
				} else {
					commonAncestor2 = new RvalNode(words2.get(words2.size() - 1));		
				}
			}
			
			// Mai departe, in functie de operatia dorita, creez un nod 
			
			// Pentru nod de Sum
			if (isPlusOperator(words2)) {
				commonAncestorMid = new OperationNode(commonAncestor1, commonAncestor2, '+');
			}
			
			// Pentru un nod Difference
			if (isMinusOperator(words2)) {
				commonAncestorMid = new OperationNode(commonAncestor1, commonAncestor2, '-');
			}
			
			// Pentru nod Multiplication
			if (isMultiplicationOperator(words2)) {
				commonAncestorMid = new OperationNode(commonAncestor1, commonAncestor2, '*');
			}
			
			// Pentru nod Division
			if (isDivisionOperator(words2)) {
				commonAncestorMid = new OperationNode(commonAncestor1, commonAncestor2, '/');
			}
			
			// Pentru nod Modulo
			if (isModuloOperator(words2)) {
				commonAncestorMid = new OperationNode(commonAncestor1, commonAncestor2, '%');
			}
			
			// Pentru nod EqualTo
			if (isEqualTo(words2)) {
				commonAncestorMid = new OperationNode(commonAncestor1, commonAncestor2, '=');
			}
			
			// Pentru nod IsGreaterThan
			if (isGreaterThan(words2)) {
				commonAncestorMid = new OperationNode(commonAncestor1, commonAncestor2, '>');
			}
			
			// Pentru nod Or
			if (isOr(words2)) {
				commonAncestorMid = new OperationNode(commonAncestor1, commonAncestor2, 'v');
			}
			
			// Pentru nod And
			if (isAnd(words2)) {
				commonAncestorMid = new OperationNode(commonAncestor1, commonAncestor2, '&');
			}
			
			// Pornind de la acest nod creat, parcurg toate operatiile din assignment
			// si adaug nodurile create
			while (!set[pos].equals("ENOUGH TALK")) {
					
					// Prelucrez linia curenta
					parts = set[pos].split(" ");
					words2 = toArrayList(parts);
					words2 = eraseSpaces(words2);
					atSignParts = set[pos].split("@");
					
					// Verific ce fel de informatie contine: bool, int, variable
					// Verific daca am bool
					if (atSignParts.length == 2) {			
						if (atSignParts[1].equals("NO PROBLEMO")) {
							commonAncestor2 = new ConstantNode(1, 'b');
						} 
						if (atSignParts[1].equals("I LIED")) {
		
							 commonAncestor2 = new ConstantNode(0, 'b');
						}
					} else {
						// Verific daca am int
						if (words2.get(words2.size() - 1).matches("\\d+")) {
							commonAncestor2 = new ConstantNode(Integer.valueOf(words2.get(words2.size() - 1)), '0');
						} else {
							
							// Verific daca am variabila
							commonAncestor2 = new RvalNode(words2.get(words2.size() - 1));		
						}
					}
					
					/*Intotdeauna nodul construit o sa fie in stanga 
					 *Construiesc un obiect in fucntie de ce operatie am 
					 */
					commonAncestor1 = commonAncestorMid;
					// Pentru nod de Sum
					if (isPlusOperator(words2)) {
						commonAncestorMid = new OperationNode(commonAncestor1, commonAncestor2, '+');
					}
					
					// Pentru un nod Difference
					if (isMinusOperator(words2)) {
						commonAncestorMid = new OperationNode(commonAncestor1, commonAncestor2, '-');
					}
					
					// Pentru nod Multiplication
					if (isMultiplicationOperator(words2)) {
						commonAncestorMid = new OperationNode(commonAncestor1, commonAncestor2, '*');
					}
					
					// Pentru nod Division
					if (isDivisionOperator(words2)) {
						commonAncestorMid = new OperationNode(commonAncestor1, commonAncestor2, '/');
					}
					
					// Pentru nod Modulo
					if (isModuloOperator(words2)) {
						commonAncestorMid = new OperationNode(commonAncestor1, commonAncestor2, '%');
					}
					
					// Pentru nod EqualTo
					if (isEqualTo(words2)) {
						commonAncestorMid = new OperationNode(commonAncestor1, commonAncestor2, '=');
					}
					
					// Pentru nod IsGreaterThan
					if (isGreaterThan(words2)) {
						commonAncestorMid = new OperationNode(commonAncestor1, commonAncestor2, '>');
					}
					
					// Pentru nod Or
					if (isOr(words2)) {
						commonAncestorMid = new OperationNode(commonAncestor1, commonAncestor2, 'v');
					}
					
					// Pentru nod And
					if (isAnd(words2)) {
						commonAncestorMid = new OperationNode(commonAncestor1, commonAncestor2, '&');
					}
					
					// Trec la linia urmatoare
					pos++;
			}
			
			// Creez obiectul de tip AssignmentNode
			assignmentNode = new AssignmentNode(lval, commonAncestorMid);
		}
		
		return assignmentNode;
	}
	
	/**
	 * Aceasta metoda este foarte speciala
	 * Retine nodul curent unde ma aflu si adauga un nod nou creat, in 
	 * functie de instanta sa, pentru: main, ifBody, elseBody, while
	 * @param n
	 */
	private void integrate(Node n) {
		
		// Extrag nodul din varf
		curent = curents.peek();
		
		// Adaug la curent, noul nod
		curent.addNode(n);
	}

	/**
	 * Metoda care parcurge setul de instructiuni din fisier si creeaza noduri
	 * in functie de continutul fiecareia
	 * @throws Exception 
	 */
	public void rise() throws Exception {
		// Stiva pentru nodurile de tip If imbricate
		Stack<IfNode> ifStack = new Stack<IfNode>();
		
		// Stiva pentru nodurile de tip else imbricate
		Stack<ElseBodyNode> elseStackNode = new Stack<ElseBodyNode>();
 		
		// Stiva care contine valori de 0 si 1 cand avem else si cand nu avem
		Stack<Integer> elseStack = new Stack<Integer>();
		
		// Stiva pentru nodurile de tip while imbricate
		Stack<WhileNode> whileNodeStack = new Stack<WhileNode>();
		
		// Sirul de cuvinte al liniei curente
		ArrayList<String> words = new ArrayList<String>();
		String [] parts;
		
		int i = pos;
		
		// Parcurg lista de cuvinte
		for ( pos = i; pos < set.length; pos++) {                 
			parts = set[pos].split(" ");						
	
			// Transform in arrayList
			words = toArrayList(parts);
			words = eraseSpaces(words);							
			if (isDeclare(words)) {								  
				
				// Construiesc obiectul de tip DeclareNode
				DeclareNode declareNode = buildDeclareNode(words);
				
				// Il adaug in arbore
				integrate(declareNode);                      
			}
			
			// Verific daca linia citita eeste o afisare
			if (words.size() > 0 && words.get(0).equals("TALK") && isPrint(words)) {
				PrintNode printNode = buildPrintNode(words, set[pos]);
				integrate(printNode);
			}
			
			// Verific daca linia citita este de atribuire
			if (words.size() > 0 && words.get(0).equals("GET") && words.get(1).equals("TO") && isAssignVariable(words)) {
				AssignmentNode assignmentNode = buildAssignmentNode(words);
				integrate(assignmentNode);
			}
			
			// Verific daca linia este un if
			if (isIf(words)) {
				
				ConditionNode conditionNode = new ConditionNode(searchVariable(words.get(words.size() - 1)));
				IfBodyNode ifBodyNode = new IfBodyNode();   
				IfNode ifNode = new IfNode();
				
				// Pana acum nu am else
				elseStack.push(0);	
				
				// Setez conditia si ifBody
				ifNode.setCondition(conditionNode);
				ifNode.setIfBodyNode(ifBodyNode);
				ifStack.push(ifNode);
				
				// Adaug in lista de noduri nodul de if, pentru a lipi la el noile noduri
				curents.push(ifBodyNode);
			}
			
			// Verific daca am ajuns la else
			if (set[pos].equals("BULLSHIT")) {
				// Scot 0 din stiva si pun 1(am gasit else pentru if
				elseStack.pop();
				elseStack.push(1);
				
				// Creez un obiect de tip ElseBodyNode
				ElseBodyNode elseBodyNode = new ElseBodyNode();
				
				// Il daug in stiva de else
				elseStackNode.push(elseBodyNode);
				
				// Scot vechiul IfBodyNode si adaug ElseBodyNode
				curents.pop();
				curents.push(elseBodyNode);
			}
			
			// Daca am ajuns la finalul if-ului
			if (isEndIf(words)) {
				
				// Daca nu am else pana acum, adaug in arbore IfNode
				if (elseStack.pop() == 0) {
					curents.pop();
					integrate(ifStack.pop());
					
				} else {
					// Am si else pentru if
					curents.pop();
					IfNode ifNode = ifStack.pop();
					ElseBodyNode el = elseStackNode.pop();
					
					// Leg ElseBodyNode de IfNode
					ifNode.setElseBodyNode(el);
					
					// Adaug IfNode in arbore
					integrate(ifNode);
				}
			}
			// Daca am bucla de while
			if (isWhile(words)) {
				ConditionNode conditionNode = new ConditionNode(searchVariable(words.get(words.size() - 1)));
				BodyNode bodyNode = new BodyNode();

				// Adaug bodyNode in lista de noduri curente
				curents.push(bodyNode);
				WhileNode whileNode = new WhileNode(conditionNode, bodyNode);
				
				// Il pun pe stiva de while-uri imbricate
				whileNodeStack.push(whileNode);
			}
			
			// Verific cand am ajuns la finalul while
			if (set[pos].equals("CHILL")) {
				// Elimin varful din stiva de noduri curente
				curents.pop();
				integrate(whileNodeStack.pop());
			}
		}		
	}	
}
