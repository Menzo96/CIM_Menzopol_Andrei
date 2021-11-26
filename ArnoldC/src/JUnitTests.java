import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;


public class JUnitTests {
	
	
	//Test #1 - Right test #1: a + b
	@Test
	public void rightPlusTest()
	{
		CommonAncestor c1, c2;
		OperationNode op1;
		NodeVisitorImpl nv1 = new NodeVisitorImpl();
		
		c1 = new ConstantNode(10, '0');
		c2 = new ConstantNode(20, '0');
		
		op1 = new OperationNode(c1, c2, '+');
		
		nv1.visit(op1);
		
		assertEquals(30, op1.getValue());
		
		
	}
	
	//Test #2 - Right test #2: a - b
	@Test
	public void rightMinusTest()
	{
		CommonAncestor c1, c2;
		OperationNode op1;
		NodeVisitorImpl nv1 = new NodeVisitorImpl();
		
		c1 = new ConstantNode(26, '0');
		c2 = new ConstantNode(3, '0');
		
		op1 = new OperationNode(c1, c2, '-');
		
		nv1.visit(op1);
		
		assertEquals(23, op1.getValue());
	
	}
	
	//Test #3 - Right test #3: a % b
	@Test
	public void rightModuloTest()
	{
		CommonAncestor c1, c2;
		OperationNode op1;
		NodeVisitorImpl nv1 = new NodeVisitorImpl();
		
		c1 = new ConstantNode(26, '0');
		c2 = new ConstantNode(3, '0');
		
		op1 = new OperationNode(c1, c2, '%');
		
		nv1.visit(op1);
		
		assertEquals(2, op1.getValue());
	
	}
	
	//Test #4 - Right test #4: a * b
	@Test
	public void rightMultiplyTest()
	{
		CommonAncestor c1, c2;
		OperationNode op1;
		NodeVisitorImpl nv1 = new NodeVisitorImpl();
		
		c1 = new ConstantNode(22, '0');
		c2 = new ConstantNode(3, '0');
		
		op1 = new OperationNode(c1, c2, '*');
		
		nv1.visit(op1);
		
		assertEquals(66, op1.getValue());
	}
	
	//Test #5 - Right test #5: a == b
	@Test
	public void rightEqualTest()
	{
		CommonAncestor c1, c2;
		OperationNode op1;
		NodeVisitorImpl nv1 = new NodeVisitorImpl();
		
		c1 = new ConstantNode(3, '0');
		c2 = new ConstantNode(3, '0');
		
		op1 = new OperationNode(c1, c2, '=');
		
		nv1.visit(op1);
		
		assertEquals(1, op1.getValue());
	}
	
	
	//Test #6 - Boundary test #1: division to 1
	@Test
	public void boundaryDivTo1Test()
	{
		CommonAncestor c1, c2;
		OperationNode op1;
		NodeVisitorImpl nv1 = new NodeVisitorImpl();
		
		c1 = new ConstantNode(10, '0');
		c2 = new ConstantNode(1, '0');
		
		op1 = new OperationNode(c1, c2, '/');
		
		nv1.visit(op1);
		
		assertEquals(10, op1.getValue());
	}
	
	
	
	//Test #7 - Boundary test #2: division to itself
	@Test
	public void boundaryDivToSelfTest()
	{
		CommonAncestor c1, c2;
		OperationNode op1;
		NodeVisitorImpl nv1 = new NodeVisitorImpl();
		
		c1 = new ConstantNode(22, '0');
		c2 = new ConstantNode(22, '0');
		
		op1 = new OperationNode(c1, c2, '/');
		
		nv1.visit(op1);
		
		assertEquals(1, op1.getValue());
	}
	
	//Test #8 - Boundary test #3: modulo to itself
	@Test
	public void boundaryModuloToSelfTest()
	{
		CommonAncestor c1, c2;
		OperationNode op1;
		NodeVisitorImpl nv1 = new NodeVisitorImpl();
		
		c1 = new ConstantNode(22, '0');
		c2 = new ConstantNode(22, '0');
		
		op1 = new OperationNode(c1, c2, '%');
		
		nv1.visit(op1);
		
		assertEquals(0, op1.getValue());
	}
	
	
	//Test #9 - Inverse test #1: test sum by difference
	@Test
	public void inverseSumTest()
	{
		CommonAncestor c1, c2;
		OperationNode op1;
		NodeVisitorImpl nv1 = new NodeVisitorImpl();
		
		int p1 = 2, p2 = 9;
		
		c1 = new ConstantNode(p1, '0');
		c2 = new ConstantNode(p2, '0');
		
		op1 = new OperationNode(c1, c2, '+');
		
		nv1.visit(op1);
		
		assertEquals(p1, op1.getValue() - p2);
	}
	
	//Test #10 - Inverse test #2: test multiply by division
	@Test
	public void inverseMultiTest()
	{
		CommonAncestor c1, c2;
		OperationNode op1;
		NodeVisitorImpl nv1 = new NodeVisitorImpl();
		
		int p1 = 2, p2 = 9;
		
		c1 = new ConstantNode(p1, '0');
		c2 = new ConstantNode(p2, '0');
		
		op1 = new OperationNode(c1, c2, '*');
		
		nv1.visit(op1);
		
		assertEquals(p1, op1.getValue() / p2);
	}
	
	
	//Test #11 - CrossCheck test #1: test modulo operator
	@Test
	public void crossCheckModuloTest()
	{
		CommonAncestor c1, c2;
		OperationNode op1;
		NodeVisitorImpl nv1 = new NodeVisitorImpl();
		
		int p1 = 48, p2 = 5;
		
		c1 = new ConstantNode(p1, '0');
		c2 = new ConstantNode(p2, '0');
		
		op1 = new OperationNode(c1, c2, '%');
		
		nv1.visit(op1);
		
		assertEquals(p1 - p1/p2*p2, op1.getValue());
	}
	
	//Test #12 - CrossCheck test #2: test minus operator
	@Test
	public void crossCheckMinusTest()
	{
		CommonAncestor c1, c2;
		OperationNode op1;
		NodeVisitorImpl nv1 = new NodeVisitorImpl();
		
		int p1 = 48, p2 = 5;
		
		c1 = new ConstantNode(p1, '0');
		c2 = new ConstantNode(p2, '0');
		
		op1 = new OperationNode(c1, c2, '-');
		
		nv1.visit(op1);
		
		assertEquals(p1 - p2, op1.getValue());
	}
	
	//Test #13 - CrossCheck test #3: test greater operator
	@Test
	public void crossCheckGreaterTest()
	{
		CommonAncestor c1, c2;
		OperationNode op1;
		NodeVisitorImpl nv1 = new NodeVisitorImpl();
		
		int p1 = 48, p2 = 5;
		
		c1 = new ConstantNode(p1, '0');
		c2 = new ConstantNode(p2, '5');
		
		op1 = new OperationNode(c1, c2, '>');
		
		nv1.visit(op1);
		
		assertEquals((p1 > p2)?1:0, op1.getValue());
	}
	
	//Test #14 - CrossCheck test #4: test and operator
	@Test
	public void crossCheckAndTest()
	{
		CommonAncestor c1, c2;
		OperationNode op1;
		NodeVisitorImpl nv1 = new NodeVisitorImpl();
		
		int p1 = 48, p2 = 5;
		
		c1 = new ConstantNode(p1, '2');
		c2 = new ConstantNode(p2, '4');
		
		op1 = new OperationNode(c1, c2, '&');
		
		nv1.visit(op1);
		
		assertEquals((p1 > 0 && p2 > 0)?1:0, op1.getValue());
	}
	
	//Test #15 - Error Conditions test #1: throw exception on null filename
	@Test (expected = Exception.class)
	public void errorConditionNull1Test() throws Exception
	{
		BuildTree buildTree = new BuildTree(null);
		buildTree.rise();
	}
	
	//Test #16 - Error Conditions test #2: throw exception on null arguments
	@Test (expected = Exception.class )
	public void errorConditionNull2Test() throws Exception
	{		
		BuildTree buildTree = new BuildTree("inputs/09-primes.ac");
		
		PrintNode pn = buildTree.buildPrintNode(null, null);
	}
	
	//Test #17 - Error Conditions test #3: throw arithmetic exception on division by 0
	@Test (expected = ArithmeticException.class)
	public void errorConditionDivBy0Test()
	{
		CommonAncestor c1, c2;
		OperationNode op1;
		NodeVisitorImpl nv1 = new NodeVisitorImpl();
		
		c1 = new ConstantNode(22, '0');
		c2 = new ConstantNode(0, '0');
		
		op1 = new OperationNode(c1, c2, '/');
		
		nv1.visit(op1);
		
	}
	
	//Test #18 - Error Conditions test #4: throw arithmetic exception on modulo by 0
	@Test  (expected = ArithmeticException.class)
	public void errorConditionModBy0Test()
	{
		CommonAncestor c1, c2;
		OperationNode op1;
		NodeVisitorImpl nv1 = new NodeVisitorImpl();
		
		c1 = new ConstantNode(22, '0');
		c2 = new ConstantNode(0, '0');
		
		op1 = new OperationNode(c1, c2, '%');
		
		nv1.visit(op1);
		
	}
	
	//Test #19 - Performance Test #1 - read the same file many times
	@Test (timeout = 2000)
	public void performanceTest1()
	{
		BuildTree buildTree = new BuildTree("inputs/09-primes.ac", true);
	}
	
	//Test #20 - Performance Test #2 - read a very large file
	@Test (timeout = 2000)
	public void performanceTest2() throws Exception
	{
		BuildTree buildTree = new BuildTree("inputs/dummy_file.ac");
	}
	
	//Test #21 - Conformance Test #1 - test function for if true
	@Test
	public void conformanceTestIfTrue() throws Exception
	{
		BuildTree buildTree = new BuildTree("inputs/09-primes.ac");
		
		String ifStr = "BECAUSE I'M GOING TO SAY PLEASE a";
		String[] wordsStr = ifStr.split("\\s+");
		
		ArrayList<String> wordsArrList = new ArrayList<String>(Arrays.asList(wordsStr));
		
		boolean ret = buildTree.isIf(wordsArrList);
		
		assertEquals(true, ret);
	}
	
	//Test #22 - Conformance Test #2 - test function for if false
	@Test
	public void conformanceIfFalseTest() throws Exception
	{
		BuildTree buildTree = new BuildTree("inputs/09-primes.ac");
		
		String ifStr = "BECAUSE I'M NOT GOING TO SAY PLEASE";
		String[] wordsStr = ifStr.split("\\s+");
		
		ArrayList<String> wordsArrList = new ArrayList<String>(Arrays.asList(wordsStr));
		
		boolean ret = buildTree.isIf(wordsArrList);
		
		assertEquals(false, ret);
	}
	
	//Test #23 - Conformance Test #3 - test function for end if true
	@Test
	public void conformanceEndIfTrueTest() throws Exception
	{
		BuildTree buildTree = new BuildTree("inputs/09-primes.ac");
		
		String endIfStr = "YOU HAVE NO RESPECT FOR LOGIC";
		String[] wordsStr = endIfStr.split("\\s+");
		
		ArrayList<String> wordsArrList = new ArrayList<String>(Arrays.asList(wordsStr));
		
		boolean ret = buildTree.isEndIf(wordsArrList);
		
		assertEquals(true, ret);
	}
	
	//Test #24 - Conformance Test #4 - test function for while true
	@Test
	public void conformanceWhileTrueTest() throws Exception
	{
		BuildTree buildTree = new BuildTree("inputs/09-primes.ac");
		
		String whileStr = "STICK AROUND a";
		String[] wordsStr = whileStr.split("\\s+");
		
		ArrayList<String> wordsArrList = new ArrayList<String>(Arrays.asList(wordsStr));
		
		boolean ret = buildTree.isWhile(wordsArrList);
		
		assertEquals(true, ret);
	}
	
	//Test #25 - Conformance Test #5 - test function for or false
	@Test
	public void conformanceOrFalseTest() throws Exception
	{
		BuildTree buildTree = new BuildTree("inputs/09-primes.ac");
		
		String orStr = "CONSIDER THAT A DIVORCE";
		String[] wordsStr = orStr.split("\\s+");
		
		ArrayList<String> wordsArrList = new ArrayList<String>(Arrays.asList(wordsStr));
		
		boolean ret = buildTree.isOr(wordsArrList);
		
		assertEquals(false, ret);
	}
	
	//Test #26 - Ordering Test #1 - test that generated abstract syntax tree is correct (in order)
	@Test
	public void orderingTest1() throws Exception
	{
		String args[] = {"inputs/09-primes.ac"};
		
		String outputTestFile = "test_outputs/09-primes.ast";
		String outputFile = "outputs/09-primes.ast";
		
		ParseTest.main(args);
		
		BufferedReader bufReadOutput = new BufferedReader(new FileReader(outputFile));
		BufferedReader bufReadTestOutput = new BufferedReader(new FileReader(outputTestFile));
		
		String testLine, outputLine;
		testLine = bufReadTestOutput.readLine();
		outputLine = bufReadOutput.readLine();
		
		while((testLine != null) && (outputLine != null))
		{
			if (!testLine.equals(outputLine))
			{
				fail("The abstract syntax tree is not correctly ordered");
				break;
			}
			
			testLine = bufReadTestOutput.readLine();
			outputLine = bufReadOutput.readLine();
		}
			
	}
	
	//Test #27 - Ordering Test #2 - test that generated abstract syntax tree is correct (in order)
	@Test
	public void orderingTest2() throws Exception
	{
		String args[] = {"inputs/10-complete_math.ac"};
		
		String outputTestFile = "test_outputs/10-complete_math.ast";
		String outputFile = "outputs/10-complete_math.ast";
		
		ParseTest.main(args);
		
		BufferedReader bufReadOutput = new BufferedReader(new FileReader(outputFile));
		BufferedReader bufReadTestOutput = new BufferedReader(new FileReader(outputTestFile));
		
		String testLine, outputLine;
		testLine = bufReadTestOutput.readLine();
		outputLine = bufReadOutput.readLine();
		
		while((testLine != null) && (outputLine != null))
		{
			if (!testLine.equals(outputLine))
			{
				fail("The abstract syntax tree is not correctly ordered");
				break;
			}
			
			testLine = bufReadTestOutput.readLine();
			outputLine = bufReadOutput.readLine();
		}
			
	}
	
	//Test #28 - Ordering Test #3 - test that generated abstract syntax tree is correct (in order)
	@Test
	public void orderingTest3() throws Exception
	{
		String args[] = {"inputs/08-simple_math.ac"};
		
		String outputTestFile = "test_outputs/08-simple_math.ast";
		String outputFile = "outputs/08-simple_math.ast";
		
		ParseTest.main(args);
		
		BufferedReader bufReadOutput = new BufferedReader(new FileReader(outputFile));
		BufferedReader bufReadTestOutput = new BufferedReader(new FileReader(outputTestFile));
		
		String testLine, outputLine;
		testLine = bufReadTestOutput.readLine();
		outputLine = bufReadOutput.readLine();
		
		while((testLine != null) && (outputLine != null))
		{
			if (!testLine.equals(outputLine))
			{
				fail("The abstract syntax tree is not correctly ordered");
				break;
			}
			
			testLine = bufReadTestOutput.readLine();
			outputLine = bufReadOutput.readLine();
		}
			
	}
	
	//Test #29 - Range Test #1 - pass a 0 strings ArrayList as argument
	@Test
	public void rangeTest1() throws Exception
	{
		ArrayList<String> words = new ArrayList<String>();
		
		BuildTree buildTree = new BuildTree("inputs/09-primes.ac");
		
		//words has 0 strings
		AssignmentNode an = buildTree.buildAssignmentNode(words);
		
		assertNull(an);
	}
	
	//Test #30 - Range Test #2 - pass a 5 strings ArrayList as argument
	@Test
	public void rangeTest2() throws Exception
	{
		ArrayList<String> words = new ArrayList<String>();
		
		words.add("words1");
		words.add("words2");
		words.add("words3");
		words.add("words4");
		words.add("words5");
		
		BuildTree buildTree = new BuildTree("inputs/09-primes.ac");
		
		//words has 5 strings
		AssignmentNode an = buildTree.buildAssignmentNode(words);
		
		assertNotNull(an);
	}
	
	//Test #31 - Existence Test #1 - null parameter to minus operator
	@Test
	public void existenceMinusNullTest() throws Exception
	{
		BuildTree buildTree = new BuildTree("inputs/09-primes.ac");
		
		boolean ret = buildTree.isMinusOperator(null);
		
		assertFalse(ret);
	}
	
	//Test #32 - Existence Test #2 - null parameter to multiplication operator
	@Test
	public void existenceMultiNullTest() throws Exception
	{
		BuildTree buildTree = new BuildTree("inputs/09-primes.ac");
		
		boolean ret = buildTree.isMultiplicationOperator(null);
		
		assertFalse(ret);
	}
	
	//Test #33 - Existence Test #3 - null parameter to division operator
	@Test
	public void existenceDivNullTest() throws Exception
	{
		BuildTree buildTree = new BuildTree("inputs/09-primes.ac");
		
		boolean ret = buildTree.isDivisionOperator(null);
		
		assertFalse(ret);
	}
	
	//Test #34 - Existence Test #4 - null parameter to modulo operator
	@Test
	public void existenceModuloNullTest() throws Exception
	{
		BuildTree buildTree = new BuildTree("inputs/09-primes.ac");
		
		boolean ret = buildTree.isModuloOperator(null);
		
		assertFalse(ret);
	}
	
	//Test #35 - Existence Test #5 - null parameter to equal operator
	@Test
	public void existenceEqualNullTest() throws Exception
	{
		BuildTree buildTree = new BuildTree("inputs/09-primes.ac");
		
		boolean ret = buildTree.isEqualTo(null);
		
		assertFalse(ret);
	}
	
	//Test #36 - cardinality Test #1 - input files of 0,1 and 3 print instructions
	@Test
	public void cardinalityTest() throws Exception
	{
		String args_0[] = {"inputs/cardinality-0.ac"};
		String args_1[] = {"inputs/cardinality-1.ac"};
		String args_n[] = {"inputs/cardinality-3.ac"};
		
		String outputCardinality0File = "outputs/cardinality-0.ast";
		String outputCardinality1File = "outputs/cardinality-1.ast";
		String outputCardinalitynFile = "outputs/cardinality-3.ast";
		
		ParseTest.main(args_0);
		ParseTest.main(args_1);
		ParseTest.main(args_n);
		
		BufferedReader bufReadC0Output = new BufferedReader(new FileReader(outputCardinality0File));
		BufferedReader bufReadC1Output = new BufferedReader(new FileReader(outputCardinality1File));
		BufferedReader bufReadCnOutput = new BufferedReader(new FileReader(outputCardinalitynFile));
		
		String line0 = bufReadC0Output.readLine();
		String line1 = bufReadC1Output.readLine();
		String linen = bufReadCnOutput.readLine();
		
		int noPrintsFile0 = 0, noPrintsFile1 = 0, noPrintsFilen = 0;
		
		while(line0 != null)
		{
			if(line0.contains("PrintNode"))
				noPrintsFile0++;
			
			line0 = bufReadC0Output.readLine();
		}
		
		if(noPrintsFile0 != 0)
			fail("wrong number of prints instruction");
		
		
		while(line1 != null)
		{
			if(line1.contains("PrintNode"))
				noPrintsFile1++;
			
			line1 = bufReadC1Output.readLine();
		}
		
		if(noPrintsFile1 != 1)
			fail("wrong number of prints instruction");
		
		
		while(linen != null)
		{
			if(linen.contains("PrintNode"))
				noPrintsFilen++;
			
			linen = bufReadCnOutput.readLine();
		}
		
		if(noPrintsFilen != 3)
			fail("wrong number of prints instruction");
			
	}
	
	//Test #37 Time Test #1 - usual flow time under 0.5 seconds
	@Test (timeout = 100)
	public void timeTest1() throws Exception
	{
		String args[] = {"inputs/07-nested_while.ac"};
		
		ParseTest.main(args);
					
	}
	
	//Test #38 Time Test #2 - usual flow time under 0.5 seconds
	@Test (timeout = 100)
	public void timeTest2() throws Exception
	{
		String args[] = {"inputs/08-simple_math.ac"};
		
		ParseTest.main(args);
					
	}
	
	//Test #39 Time Test #3 - usual flow time under 0.5 seconds
	@Test (timeout = 100)
	public void timeTest3() throws Exception
	{
		String args[] = {"inputs/09-primes.ac"};
		
		ParseTest.main(args);
					
	}
	
	//Test #40 Time Test #4 - usual flow time under 0.5 seconds
	@Test (timeout = 100)
	public void timeTest4() throws Exception
	{
		String args[] = {"inputs/10-complete_math.ac"};
		
		ParseTest.main(args);
					
	}
	
	
	
}
