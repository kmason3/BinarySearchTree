package binarySearchTree;

public class Main {
	
	public static void main(String[]args){
		
		BST test = new BST();
		String testA = "a", testB = "b", testB1 = "b", c = "c", d = "d", h = "h";
		
		test.insert(d);
		
		test.insert(testB);
		test.insert(testA);
//		test.insert(c);
		test.insert("f");
		test.insert("g");
		test.insert("e");
		test.insert(h);
		
	
//		test.deleteInstance("b");
//		test.deleteInstance("b");
//		test.delete("d");
//		test.delete("h");
		test.delete("b");
//		test.delete("a");
//		test.delete("f");
//		System.out.println("Root is " + test.getRoot().getData());
//		System.out.println("Root's left child " + test.getRoot().getLeft().getData());
//		System.out.println("Root's right child " + test.getRoot().getRight().getData());
//		System.out.println("b's left child is " + test.search("b").getLeft().getData());
//		System.out.println("a's right child is " + test.search("a").getRight().getData());
//		System.out.println("f's left child is " + test.search("f").getLeft().getData());
//		System.out.println("f's right child is " + test.search("f").getRight().getData());
//		System.out.println("g's left child is " + test.search("g").getLeft().getData());
//		System.out.println("g's right child is " + test.search("g").getRight().getData());
		test.inOrder();

		
		
	}

}
