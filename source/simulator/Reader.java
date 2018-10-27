package simulator;

import java.io.*;
import java.util.*;
import static game.Facts.*;
    //goodtypes
    //yieldtypes
import static game.Env.*;
import static game.Colony.*;
        //If this works . . . Probably singleton instead.
    //colonists
    //resources
    //jobs

//Change "game" to "sim".

public abstract class Reader {
    
	protected String currentline;
	protected String[] words;
	protected Scanner input;
	protected String sourcefolder;
	
	public Reader(String source) {
		sourcefolder = source;
	}
	
	public abstract void read();
	
	protected Scanner makeStream(String filename) {
		try {
			Scanner stream = new Scanner(new FileInputStream(sourcefolder+"/"+filename));
			//Jumps to after occurrence of <<<Data>>>
			input = stream;
	        while (moveLine() && !currentline.equals("<<<Data>>>"));
			return stream;
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		}
    }

    protected boolean hasChar(Character ... chars) {
    	char currentchar = currentline.charAt(0);
    	List<Character> charlist = Arrays.asList(chars);
    	return charlist.contains(currentchar);
    }
	protected boolean moveLine() {
        if (!input.hasNextLine())
			return false;
		currentline = input.nextLine();
		words = currentline.split(" ",2);
		if (currentline.equals(""))
        	moveLine();
		return true;
	}
	protected String removeChar(String a) {
		return currentline.replace(a, "");
	}
	
	public void fillGlobe(Globe globe) throws IOException {
		try {
            //Should even have a file explaining which input method to link to each .txt.
			Scanner miscinput = new Scanner(new FileInputStream("data/Misc.txt"));
			Scanner personinput = new Scanner(new FileInputStream("data/Colonists.txt"));
			Scanner resourceinput = new Scanner(new FileInputStream("data/Resources.txt"));
			
            //An anonymous class could likely make this much more streamlined.
            make(miscinput);
            
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
	p("%s\n",yieldtypes);
	}
    
    private void make(Scanner inputstream) {
        input = inputstream;
        while(moveLine() && !currentline.equals("<<<Data>>>"))
        	p("%s\n",currentline);
        makeMisc();
        input.close();
    }
    
    private void makeMisc() {
    	String currentgood = "food";
    	while (moveLine()) {
    		if (hasChar('<','*'));
	        else if (hasChar('-')) {
	            currentgood = currentline.replace("-","");
	            goodtypes.add(currentgood);
	        }
	        else
	            yieldtypes.put(currentline,currentgood);
    		p("%s\n",currentline);
    	}
    }
    
    /*
	private void makeColonists() {
        if (hasChar('-')
            currentstring = *between the --*;
        String[] words = currentline.split(" ");
		String firstword = words[0];
	    if (yieldtypes.keySet().contains(firstword))
            currentint1 = 
        if (
			
            
	-firstname surname-
	skillname yearsofexperience
	skillname yearsofexperience2
	ownedgoodtype quantity
	ownedgoodtype2 quantity2
		    
	}
	private void makeResources() {
    

	
	-resourcename-
	appropriateworktype
	typicalyield (Eventually a function for skill/yield)
	startingquantity volatility
	regenmin regenavg regenmax
	
	for (Resource site : worksites)
        jobs.put(site.getWorkType(),new Job(site));
    }
    */
}
