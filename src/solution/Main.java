package solution;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

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
		String dictionary = config.getProperty("dictionary ");
		String out = config.getProperty("output");
		int [] input = new int[Constant.len];
		for(char c : args[0].toCharArray()) {
			if('a' <= c && c <= 'z')
				input[c - 'a']++;
			else
				input[c - 'A' + Constant.len / 2]++;
		}
		Solver solver = new Solver(dictionary , input, out);
		solver.anagram();
	}

}
