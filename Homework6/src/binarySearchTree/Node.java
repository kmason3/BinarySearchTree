package binarySearchTree;

public class Node {
	
	private Node left, right;
	private String data;
	private int freq;
	
	public Node(String word){
		
		this.setData(word);
		this.setFreq(1);
		this.setLeft(null);
		this.setRight(null);
		
	}

	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right =  right;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public int getFreq() {
		return freq;
	}

	public void setFreq(int freq) {
		this.freq = freq;
	}
	
	public void incFreq(){
		this.freq++;
	}
	

}
