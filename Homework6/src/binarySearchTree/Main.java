package binarySearchTree;

public class Main {
	
	public static void main(String[]args){
		
		BST test = new BST();
		String testA = "a", testB = "b", testB1 = "b";
		
		
		test.insert(testA);
		test.insert(testB);
		test.insert(testB1);
		
		
		System.out.println(test.getRoot().getRight().getData());
		System.out.println(test.getRoot().getRight().getFreq());
		
		test.inOrder();
		
	}

}
