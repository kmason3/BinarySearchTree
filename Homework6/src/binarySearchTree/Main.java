package binarySearchTree;

import java.io.*;
import java.io.FileReader;

public class Main {

	public static void main(String[] args) {

		BST test = new BST();
		String filename = "data.txt";

		try {
			BufferedReader reader = new BufferedReader(new FileReader(filename));
			String key[] = reader.readLine().split(" ");

			for (int i = 0; i < key.length; i++) {
				test.insert(key[i]);

			}reader.close();
			
			//Balance Testing
			System.out.println("--Balance Test--");
			System.out.println();
			System.out.println("The Unbalanced Root is " + test.getRoot().getData());
			System.out.println();
			test.inOrder();
			System.out.println();
			test.balance();
			System.out.println("The Balanced Root is " + test.getRoot().getData());
			System.out.println();
			
			//Delete Testing
			System.out.println("--Delete 'am' Test--");
			System.out.println();
			test.delete("am");
			test.inOrder();
			System.out.println();
			
			//Delete Instance Testing
			System.out.println("--Delete Instance of 'testing' Test--");
			System.out.println();
			test.deleteInst("testing");
			test.inOrder();
			System.out.println();
			
			//Find Testing
			System.out.println("--Find 'a' Testing--");
			System.out.println();
			test.find("a");
			System.out.println();
			System.out.println("--Find 'zootopia' Testing--");
			System.out.println();
			test.find("zootopia");
			
		

		} catch (Exception e) {
			System.err.format("Exception occurred trying to read '%s'.",
					filename);
			e.printStackTrace();
		}

	}

}
