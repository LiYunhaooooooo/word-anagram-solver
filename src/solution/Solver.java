package solution;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;

public class Solver {
	static final int caseN = 26;
	TrieTree tree;
	int [] input;

	public Solver(URL dictionary , int [] input) {
		this.tree = new TrieTree();
		this.tree.build(dictionary);
		this.input = input;
	}
	
	public void anagram() {
		int count = 0;   		//assume that number of input character won't exceed range of integer 
		for(int i = 0; i < input.length ; i++) {
			count += input[i];
		}
		Node cur = tree.getRoot();
		searchTree(cur , count , new StringBuilder());
	}
	
	private void searchTree(Node cur , int count , StringBuilder str) {
		if(count == 0) {
			if(cur.isEnd()) {
				System.out.println(str.toString());
			}
			else
				return;
		}
		for(int i = 0; i < input.length ; i++) {
			if(input[i] > 0 && cur.getChildren()[i] != null) {
				if(i >= 0 && i < 26)
					str.append((char)(i + 'a'));
				else
					str.append((char)(i  - Constant.len / 2 + 'A'));
				input[i]--;
				searchTree(cur.getChildren()[i] , count - 1, str);
				input[i]++;
				str.deleteCharAt(str.length() - 1);
			}
		}
	}
	
}
