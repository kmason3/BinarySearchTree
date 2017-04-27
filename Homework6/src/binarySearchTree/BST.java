package binarySearchTree;

public class BST {

	private Node root;

	public BST() {
		root = null;
	}
	
	public boolean isEmpty(){
		return root == null;
	}

	public Node getRoot() {
		return root;
	}

	public void setRoot(String word) {

		this.root = new Node(word);

	}
	
	public void insert(String key){
		
		insert(root, key);
		
	}
	
	public void insert(Node p, String data){
		
		if(isEmpty()){
			
			setRoot(data);
			
		}
		
		if(p.getData().compareToIgnoreCase(data) < 0){
			
			if(p.getLeft() != null){
				
				insert(p.getLeft(), data);
				
			}else{
				p.setLeft(data);
			}
			
		}
		
		if(p.getData().compareToIgnoreCase(data) > 0){
			
			if(p.getRight() != null){
				
				insert(p.getRight(), data);
				
			}else{
				p.setRight(data);
			}
			
		}
		
		if(p.getData().equalsIgnoreCase(data)){
			
			p.incFreq();
			
		}
		
	}

}
