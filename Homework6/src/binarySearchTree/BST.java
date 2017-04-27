package binarySearchTree;

public class BST {

	private Node root;

	public BST() {
		root = null;
	}

	public boolean isEmpty() {
		return this.root == null;
	}

	public Node getRoot() {
		return root;
	}

	public void setRoot(String word) {

		this.root = new Node(word);

	}

	public void insert(String key) {

		if (isEmpty()) {

			setRoot(key);

		} else {
			insert(root, key);
		}

	}

	public void insert(Node p, String data) {

		Node newNode = new Node(data);

		if (p.getData().compareToIgnoreCase(data) > 0) {

			if (p.getLeft() != null) {

				insert(p.getLeft(), data);

			} else {
				p.setLeft(newNode);
			}

		}

		else if (p.getData().compareToIgnoreCase(data) < 0) {

			if (p.getRight() != null) {

				insert(p.getRight(), data);

			} else {
				p.setRight(newNode);
			}

		}

		else if (p.getData().equalsIgnoreCase(data)) {

			p.incFreq();

		}

	}

	public void inOrder() {
		inOrder(root);
	}

	public void inOrder(Node curr) {

		if (curr != null) {

			if (curr.getLeft() != null) {

				inOrder(curr.getLeft());

			}

			System.out.print(curr.getData() + " ");

			if (curr.getRight() != null) {

				inOrder(curr.getRight());

			}

		}

	}

}
