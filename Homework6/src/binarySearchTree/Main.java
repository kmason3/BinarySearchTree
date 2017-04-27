package binarySearchTree;

public class Main {
	
	public static void main(String[]args){
		
		BST test = new BST();
		String testA = "a", testB = "b";
		
		
		test.insert(testA);
		test.insert(testB);
		
		System.out.println(test.getRoot().getRight().getData());
		
		
	}

}
