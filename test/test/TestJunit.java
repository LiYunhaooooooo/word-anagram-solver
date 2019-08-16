package test;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;

import org.junit.Assert;
import org.junit.Test;

public class TestJunit {
   @Test
   public void test1() {
	   testHelper("./resorce/test/testConfig1.properties");
   }
   
   public void testHelper(String configString) {
		Properties config = new Properties();
		try{
			config.load(new FileInputStream(configString));
		}
		catch (IOException e) {
		    e.printStackTrace();
		}
		solution.Main.loadConfig(config);
		File ans = new File(config.getProperty("output"));
		File expect = new File(config.getProperty("expected"));
		Map<String , Integer> map = new HashMap<String , Integer>();
		try {
			Scanner sc = new Scanner(ans);
			while(sc.hasNext()) {
				String word = sc.next();
				map.put(word, map.getOrDefault(word , 0) + 1);
			}
			sc = new Scanner(expect);
			while(sc.hasNext()) {
				String word = sc.next();
				if(!map.containsKey(word)) {
					System.out.println("test fail");
					Assert.assertTrue(false);
				}
				else {
					map.put(word, map.get(word) - 1);
					if(map.get(word) == 0)
						map.remove(word);
				}
			}
			if(map.size() == 0) {
				System.out.println("test success");
				Assert.assertTrue(true);
			}
			else {
				System.out.println("test fail");
				Assert.assertTrue(false);	
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}	   
   }
}
