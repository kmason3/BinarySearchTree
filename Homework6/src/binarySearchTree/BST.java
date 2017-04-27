package binarySearchTree;

public class BST {

	private Node root;

	public BST() {
		root = null;
	}

	/**
	 * Checks if tree is empty
	 * 
	 * @return boolean
	 */
	public boolean isEmpty() {
		return this.root == null;
	}

	// Getters and Setters
	public Node getRoot() {
		return root;
	}

	public void setRoot(String word) {

		this.root = new Node(word);

	}

	/**
	 * Insert method adds string to tree
	 * 
	 * @param key
	 */
	public void insert(String key) {
		// If tree is empty make root otherwise recursively call insert
		if (isEmpty()) {

			setRoot(key);

		} else {
			insert(root, key);
		}

	}

	/**
	 * Inserts new node at correct position in tree
	 * 
	 * @param p
	 * @param data
	 */
	public void insert(Node p, String data) {
		// Creates new node with input data
		Node newNode = new Node(data);
		// If the string comes before the parent it's placed to the left if left
		// node is free, if left node is full recursively calls insert with left
		// node as parent
		if (p.getData().compareToIgnoreCase(data) > 0) {

			if (p.getLeft() != null) {

				insert(p.getLeft(), data);

			} else {
				p.setLeft(newNode);
			}

		}
		// If the string comes after the parent it's placed to the right if the
		// right node is free, if right node is full recursively calls insert
		// with right node as parent
		else if (p.getData().compareToIgnoreCase(data) < 0) {

			if (p.getRight() != null) {

				insert(p.getRight(), data);

			} else {
				p.setRight(newNode);
			}

		}
		// If the string matches the parent then the frequency is incrimented
		else if (p.getData().equalsIgnoreCase(data)) {

			p.incFreq();

		}

	}

	/**
	 * Prints tree in order
	 */
	public void inOrder() {
		inOrder(root);
	}

	/**
	 * Prints tree in order
	 * 
	 * @param curr
	 */
	public void inOrder(Node curr) {
		// If current node is not null check if it has a left or right child
		if (curr != null) {
			// If current node has left child recursively call inOrder method
			// starting at left node
			if (curr.getLeft() != null) {

				inOrder(curr.getLeft());

			}
			// If left node is null print current node's data
			System.out.println(curr.getData() + " " + curr.getFreq());
			// If current node has a right child recursively call inOrder method
			// starting at right node
			if (curr.getRight() != null) {

				inOrder(curr.getRight());

			}

		}

	}

	public void find(String find) {

		Node result = search(find);

		if (isEmpty()) {
			System.out.println("Tree is Empty!");
		} else if (result != null) {
			System.out.println(find + " is in tree!");
		} else if (result == null) {
			System.out.println(find + " is not in tree!");
		}

	}

	public Node search(String find) {
		Node current = root;
		if (isEmpty())
			return null;
		while (current != null) {
			if (current.getData().equals(find)) {
				return current;
			} else if (current.getData().compareToIgnoreCase(find) > 0) {
				current = current.getLeft();
			} else {
				current = current.getRight();
			}
		}
		return null;
	}

}
