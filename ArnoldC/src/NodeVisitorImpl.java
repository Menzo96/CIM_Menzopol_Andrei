import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Clasa care interpreteaza arborele
 * Implementeaza Interfata NodeVisitor
 * @author 
 *
 */
public class NodeVisitorImpl implements NodeVisitor{
	/**
	 * Metoda preluata din interfata
	 */
	public void visit(Node n) {
		
	}
	
	/**
	 * Vizitez un nod while
	 */
	public void visit(WhileNode whileNode) {
		/**
		 *  Daca se verifica conditia trimit vistor-ul in clasa de unde a plecat
		 *  pentru a relua ciclul
		 */
		if (whileNode.getConditionNode().getResult()) {
			whileNode.accept(this);
		}
	}
	
	/**
	 * Operatiile pe noduri
	 */
	public void visit(OperationNode operationNode) {
		operationNode.value = operationNode.c1.getValue() * operationNode.c2.getValue();
		
		// Plus
		if (operationNode.getOperationType() == '+') {
			operationNode.value = operationNode.c1.getValue() + operationNode.c2.getValue();
		}
		// Minus
		if (operationNode.getOperationType() == '-') {
			operationNode.value = operationNode.c1.getValue() - operationNode.c2.getValue();
		}
		// Division
		if (operationNode.getOperationType() == '/') {
			operationNode.value = operationNode.c1.getValue() / operationNode.c2.getValue();
		}
		// Multiplication
		if (operationNode.getOperationType() == '*') {
			operationNode.value = operationNode.c1.getValue() * operationNode.c2.getValue();
		}
		// IsEqualTo
		if (operationNode.getOperationType() == '=') {
			if (operationNode.c1.getValue() == operationNode.c2.getValue()) {
				operationNode.value = 1;
			} else {
				operationNode.value = 0;
			}
		}
		// IsGreaterThan
		if (operationNode.getOperationType() == '>') {
			if (operationNode.c1.getValue() > operationNode.c2.getValue()) {
				operationNode.value = 1;
			} else {
				operationNode.value = 0;
			}
		}
		
		// And
		if (operationNode.getOperationType() == '&') {
			if (operationNode.c1.getValue() > 0 && operationNode.c2.getValue() > 0) {
				operationNode.value = 1;
			} else {
				operationNode.value = 0;
			}
		}
		// Or
		if (operationNode.getOperationType() == 'v') {
			if (operationNode.c1.getValue() == 0 && operationNode.c2.getValue() == 0) {
				operationNode.value = 0;
			} else {
				operationNode.value = 1;
			}
		}
		// Modulo
		if (operationNode.getOperationType() == '%') {
			operationNode.value = operationNode.c1.getValue() % operationNode.c2.getValue();
		}
	}


	/**
	 * Metoda de print a unui nod
	 */
	public void visit(PrintNode printNode) {
		
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
		String fileName = "./outputs/" + newName + "out";

		File log = new File(fileName);
		
		// Dupa ce am creat fisierul scriu date de afisare in el
		try{
		    if(!log.exists()){
		    	log.createNewFile();
		    }
		    FileWriter fileWriter = new FileWriter(log, true);
		    BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
		    if (printNode.stringN) {
				bufferedWriter.write(printNode.stringNode.getString() + "\n");
			}
			if (printNode.constantN) {
				bufferedWriter.write(printNode.constantNode.getValue() + "\n");
			}
			if (printNode.variableN) {
				bufferedWriter.write(printNode.variableNode.getValue() + "\n");
			}
			bufferedWriter.close();
		} catch(IOException e) {
		    
		}		
	}
	
	/**
	 * Atribuirea unei noi valori unei variabile
	 */
	public void visit(AssignmentNode assignmentNode) {
		for (VariableNode v :ParseTest.buildTree.treeVariables) {
			if (v.getVariableName().equals(assignmentNode.getVariableName())) {
				v.setValue(assignmentNode.getValue());
			}
		}
	}
}
