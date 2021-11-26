
/**
 * Interfata pentru visitor-ul care interpreteaza arborele
 * Fiecare metoda viziteaza in mod diferit fiecare nod
 * @author 
 *
 */
public interface NodeVisitor {
	
	public void visit(Node n);
		
	public void visit(WhileNode whileNode);

	public void visit(OperationNode operationNode);
	
	public void visit(PrintNode printNode);
	
	public void visit(AssignmentNode assignmentNode);
	
}
