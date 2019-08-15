package solution;



import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Properties;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Assume using default dictionary and accept inputs from command line
		/*
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
		*/

		//read dictionary and input from url	
	    try {
	    	int [] input = new int[Constant.len];
			URL dictionaryURL = new URL("https://raw.githubusercontent.com/LiYunhaooooooo/word-anagram-solver/master/resorce/words.txt");
			URL inputURL = new URL("https://raw.githubusercontent.com/LiYunhaooooooo/word-anagram-solver/master/resorce/input.txt");
	        Scanner sc = new Scanner(inputURL.openStream());
	        while (sc.hasNext()) {
	            for(char c : sc.next().toCharArray()) {
					if('a' <= c && c <= 'z')
						input[c - 'a']++;
					else
						input[c - 'A' + Constant.len / 2]++;
	            }
	        }
	        sc.close();
			Solver solver = new Solver(dictionaryURL , input);
			solver.anagram();
	    } 
	    catch (IOException e) {
	        e.printStackTrace();
	    }
	}

}
