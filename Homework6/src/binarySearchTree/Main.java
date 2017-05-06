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

			}

			test.inOrder();
			System.out.println("--Delete 'am' Test:");
			test.delete("am");
			test.inOrder();
			System.out.println("--Delete Instance of 'testing' Test:");
			test.deleteInst("testing");
			reader.close();
			test.inOrder();
		} catch (Exception e) {
			System.err.format("Exception occurred trying to read '%s'.",
					filename);
			e.printStackTrace();
		}

	}

}
