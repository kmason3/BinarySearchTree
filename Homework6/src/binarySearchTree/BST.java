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
		/*
		 * If the string comes before the parent it's placed to the left if left
		 * node is free, if left node is full recursively calls insert with left
		 * node as parent
		 */
		if (p.getData().compareToIgnoreCase(data) > 0) {

			if (p.getLeft() != null) {

				insert(p.getLeft(), data);

			} else {
				p.setLeft(newNode);
				newNode.setParent(p);
			}

		}
		/*
		 * If the string comes after the parent it's placed to the right if the
		 * right node is free, if right node is full recursively calls insert
		 * with right node as parent
		 */
		else if (p.getData().compareToIgnoreCase(data) < 0) {

			if (p.getRight() != null) {

				insert(p.getRight(), data);

			} else {
				p.setRight(newNode);
				newNode.setParent(p);
			}

		}
		// If the string matches the parent then the frequency is incremented
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

	/**
	 * Determines if string is in BST and prints human readable response
	 * 
	 * @param String
	 *            find
	 */
	public void find(String find) {
		// Implements search method to create a node variable
		Node result = search(find);
		/*
		 * If the BST is empty prints Tree is Empty!, if the string is in the
		 * BST prints the string and is in tree!, if the node is null then the
		 * string is not in BST so it prints the string and is not in tree!
		 */
		if (isEmpty()) {
			System.out.println("Tree is Empty!");
		} else if (result != null) {
			System.out.println(find + " is in tree!");
		} else if (result == null) {
			System.out.println(find + " is not in tree!");
		}

	}

	/**
	 * If the the string is in the BST it returns the node that contains it
	 * 
	 * @param String
	 *            find
	 * @return Node
	 */
	public Node search(String find) {
		/*
		 * Loops through BST to find a node with string 'find'. If node exists
		 * returns Node, if node does not exist returns null.
		 */
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

	/**
	 * Deletes node containing the parameter toDelete
	 * 
	 * @param String
	 *            toDelete
	 * @return Node
	 */
	public Node delete(String toDelete) {
		// Creates Node variable using search method
		Node temp = search(toDelete);
		// If BST is empty returns null
		if (isEmpty())
			return null;
		/*
		 * If the node to be deleted has no children and it's the left child of
		 * the parent sets parent's left child to null and deletes node. If it's
		 * the right child sets parents right child to null and deletes node. If
		 * the node to be deleted has only one child points the parent to the
		 * next node in tree and deletes node. If the node to be deleted has two
		 * children method finds the minimum node to the right of it and
		 * replaces it's data with that data then deletes the minimum node.
		 */
		if (temp.noChildren()) {

			if (temp.getParent().getData().compareToIgnoreCase(toDelete) > 0) {

				temp.getParent().setLeft(null);
				temp = null;
			} else {
				temp.getParent().setRight(null);
				temp = null;
			}

		} else if (temp.hasLeft() && !temp.hasRight()) {

			if (temp.getData().compareToIgnoreCase(temp.getParent().getData()) < 0) {
				temp.getParent().setLeft(temp.getLeft());
				temp = null;
			} else {

				temp.getParent().setRight(temp.getLeft());
				temp = null;

			}
		} else if (!temp.hasLeft() && temp.hasRight()) {

			if (temp.getData().compareToIgnoreCase(temp.getParent().getData()) < 0) {

				temp.getParent().setLeft(temp.getRight());
				temp = null;

			} else {

				temp.getParent().setRight(temp.getRight());
				temp = null;

			}
		} else {

			Node min;
			if (temp.getRight().getRight() == null) {
				min = minimum(temp);
				temp.setData(min.getData());
				temp.setFreq(min.getFreq());
				min.getParent().setLeft(null);
				min = null;
			} else {
				min = minimum(temp.getRight());

				temp.setData(min.getData());
				temp.setFreq(min.getFreq());
				min.getParent().setLeft(null);
				min = null;
			}
		}
		return (temp);
	}

	/**
	 * Delete's instance of a string
	 * 
	 * @param String
	 *            toDelete
	 */
	public void deleteInst(String toDelete) {
		/*
		 * Creates temporary node from string input and if there are multiple
		 * occurences in the text only deletes one from the tree. If there is
		 * only one occurance then calls delete method and removes node.
		 */
		Node temp = search(toDelete);
		if (temp.getFreq() > 1) {
			temp.decFreq();
		} else {
			delete(temp.getData());
		}
	}

	/**
	 * Find's minimum node
	 * 
	 * @param Node
	 *            root
	 * @return Node minimum
	 */

	public Node minimum(Node root) {
		if (root.getLeft() == null)
			return root;
		else {
			return minimum(root.getLeft());
		}
	}

}
