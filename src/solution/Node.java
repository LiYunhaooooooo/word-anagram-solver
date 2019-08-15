package solution;

//TrieTree Node
class Node {
	private boolean end;  //the last character of a word in dictionary
	private Node [] children; //children in next level
	private int index; // the index in its parents'children list
	public Node(boolean end , int index) {
		this.end = end;
		children = new Node[Constant.len];
		this.index = index;
	}
	
	//add a new child node if it doesn't exist
	public Node addChild(Node child) {
		if(this.children[child.getIndex()] == null) {
			this.children[child.getIndex()] = child;
		}
		return this.children[child.getIndex()];
	}
	public Node[] getChildren(){
		return this.children;
	}
	
	public int getIndex() {
		return this.index;
	}
	public boolean isEnd() {
		return end;
	}

	public void setEnd(boolean end) {
		this.end = end;
	}
}

