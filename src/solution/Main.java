package solution;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Assume using default dictionary and accept inputs from command line
		Properties config = new Properties();
		try{
			config.load(new FileInputStream("config.properties"));
		}
	    catch (IOException e) {
	        e.printStackTrace();
	    }
		String dictionary = config.getProperty("dictionary");
		String out = config.getProperty("output");
		File inputFile = new File(config.getProperty("input"));
		int [] input = new int[Constant.len];
	    try {
	        Scanner sc = new Scanner(inputFile);
	        while (sc.hasNext()) {
	            for(char c : sc.next().toCharArray()) {
					if('a' <= c && c <= 'z')
						input[c - 'a']++;
					else
						input[c - 'A' + Constant.len / 2]++;
	            }
	        }
	        sc.close();
	    } 
	    catch (FileNotFoundException e) {
	        e.printStackTrace();
	    }
		Solver solver = new Solver(dictionary , input, out);
		solver.anagram();
		
	}

}
