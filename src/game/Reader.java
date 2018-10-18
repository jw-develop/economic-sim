package game;

import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Reader {
	
	public static void fillGlobe(Globe globe) throws IOException {
		try {
			File file2 = new File(".");
			for(String fileNames : file2.list()) System.out.println(fileNames);
			Scanner file = new Scanner(new FileInputStream("Outline.txt"));
			while(file.hasNext()) {
				StringTokenizer line = new StringTokenizer(file.nextLine());
				System.out.println(line.nextToken());
			}
			file.close();
		} 
		catch(Exception re) {
            System.out.println(re.getMessage());
            re.printStackTrace();
		}
	}
}
                
                
                
                
 