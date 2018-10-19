package game;

import java.io.*;
import java.util.*;
import static game.Facts.*;
import static game.Env.*;

public class Reader {

	private String currentline;
	private Scanner input;
	
	public void fillGlobe(Globe globe) throws IOException {
		try {
            //Should even have a file explaining which input method to link to each .txt.
			Scanner miscinput = new Scanner(new FileInputStream("data/Misc.txt"));
			Scanner personinput = new Scanner(new FileInputStream("data/Colonists.txt"));
			Scanner resourceinput = new Scanner(new FileInputStream("data/Resources.txt"));
			
            //An anonymous class could likely make this much more streamlined.
            makeMisc(miscinput);
            makeColonists(personinput);
            makeResources(resourceinput);
            
            miscinput.close();
            personinput.close();
            resourceinput.close();
		}
		catch(Exception re) {
            System.out.println(re.getMessage());
            re.printStackTrace();
		}
		p("%s\n",goodtypes);
		p("%s\n",yieldtypes);
	}
    
    private void makeAll(ArrayList<Scanner> inputstreams) {
        for (Scanner current : inputstreams) {
            input = current;
            //Polymorphic call to anonymous classes, to pull appropriate action.
            boolean part1 = true;
            while(existsLine() && !currentline.equals("<<<Data>>>");
            while(hasLine()) {
                //Object.make***
            }
            input.close();
        }
    }
    
    private void makeMisc(Scanner input) {
        if (hasChar('<') {
            //Or remove <<>>,types, then set remaining string as class to 
            
            if (currentline.equals("<<Production Types>>") {
                //class currentclass = class.fromname(entry);
            }
            else if (currentline.equals("<<Service Types>>") {
                
            }
            else if (currentline.equals("<<Processing Types>>") {
                
            }
            else
                System.out.exit("Fatal read error");
            }
        else if (hasChar('-') {
            //Store word w/0 "-" in currentgood;
            goodtypes.add(currentgood);
        }
        else
            yieldtypes.put(currentline,currentgood);
    }
    
	private void makeColonists(Scanner input) {
        if (hasChar("<")
            

        String[] words = currentline.split(" ");
		String firstword = words[0];
			if (yieldtypes.keySet().contains(firstword))
			
            
firstname surname
skillname yearsofexperience
skillname yearsofexperience2
ownedgoodtype quantity
ownedgoodtype2 quantity2
		    */
	}
	private void makeResources(Scanner input) {
    
    }
	
	private boolean readUntil(String terminator) {
		return hasLine() && terminator.equals(currentline);
	}
	private boolean readUntil(HashSet<String> termination) {
		return hasLine() && termination.contains(currentline);
	}
    private boolean hasChar(char a) {
        return currentline[0].equals(a);
    }
	private boolean existsLine() {
        if (!input.hasNextLine())
			return false;
		currentline = input.nextLine();
		return true;
	}
}
