package solution;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;





//build a TrieTree
public class TrieTree {
	private Node root;
	public TrieTree() {
		root = new Node(false , 0);
	}
	
	//add one word to trieTree
	private void buildHelper(String word) {
		if(word.length() == 0)
			return;
		
		Node cur = this.root;
		for(char c : word.toCharArray()) {
			int index = 0;
			if('a' <= c && c <= 'z')
				index = c - 'a';
			else
				index = c - 'A' + Constant.len / 2;
			Node next = new Node(false , index);
			cur = cur.addChild(next);
		}
		cur.setEnd(true);
	}
	
	//build TrieTree
	public void build(String dictionary) {
		File file = new File(dictionary);
	    try {
	        Scanner sc = new Scanner(file);
	        while (sc.hasNextLine()) {
	            String word = sc.nextLine();
	            this.buildHelper(word);
	        }
	        sc.close();
	    } 
	    catch (FileNotFoundException e) {
	        e.printStackTrace();
	    }
	}
	
	public Node getRoot() {
		return root;
	}
}
