package binarySearchTree;

public class Main {
	
	public static void main(String[]args){
		
		BST test = new BST();
		String testA = "a", testB = "b", testB1 = "b", c = "c", d = "d";
		
		test.insert(c);
		test.insert(testA);
		test.insert(testB);
		test.insert(testB1);
		test.insert(c);
		test.insert(d);
		
		
		
		test.find("f");
		test.inOrder();
		
		System.out.println(test.search("f"));
		
	}

}
