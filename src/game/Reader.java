package game;

import java.io.*;
import java.util.*;
import static game.Facts.*;
import static game.Env.*;

public class Reader {

	private String currentline;
	private Scanner input;
	
	public static String[] keywordarray = new String[] { 
			"Resource",
			"Person",
			"Job"
			};
	
	public static Set<String> keywords = new HashSet<>(Arrays.asList(keywordarray));
	
	public void fillGlobe(Globe globe) throws IOException {
		try {
			Scanner miscinput = new Scanner(new FileInputStream("data/Misc.txt"));
			Scanner personinput = new Scanner(new FileInputStream("data/Colonists.txt"));
			Scanner resourceinput = new Scanner(new FileInputStream("data/Resources.txt"));
			
			input = miscinput;
			while(readUntil("death")) {
				p("early %s\n",currentline);
				goodtypes.add(currentline);
			}
			while(readRest()) {
				p("later %s\n",currentline);
				while (readUntil(goodtypes)) {
					String key = currentline;
					p("later %s\n",currentline);
					while((currentline = input.nextLine()) != null || !goodtypes.contains(goodtypes)) {
						p("later %s\n",currentline);
						yieldtypes.put(currentline, key);
					}
				}
			}

			input.close();
			
			/*
			String[] words = currentline.split(" ");
			String guideword = words[0];
			if (guideword == "")
			
			if (words[])
			if (keywords.contains(words[0])) {
				guideword = words[0];
				if (guideword=="Resource") {
					
				}
		    for (String word : words) {
		        
		    }
		    */
		}
		catch(Exception re) {
            System.out.println(re.getMessage());
            re.printStackTrace();
		}
		p("%s\n",goodtypes);
		p("%s\n",yieldtypes);
	}
	private void makeColonists(Scanner input) {
		
	}
	private void makeResources(Scanner input) {}
	
	private boolean readUntil(String terminator) {
		if (!input.hasNextLine() || terminator.equals(currentline))
			return false;
		currentline = input.nextLine();
		return true;
	}
	private boolean readUntil(HashSet<String> termination) {
		if (!input.hasNextLine())
			return false;
		currentline = input.nextLine();
		return !termination.contains(currentline);
	}
	private boolean readRest() {
		if (!input.hasNextLine())
			return false;
		currentline = input.nextLine();
		return true;
	}
	private void incrementline() {
		
	}
		
		
	/*
	 * 	//Worksites
		//Resource abstract type
		//Food v. other?
		worksites.add(new Resource("Farmland","farming",50000,1900,.01));
		worksites.add(new Resource("Forest","hunting",50000,2100,.05));
		
		for (Resource site : worksites)
			jobs.put(site.getWorkType(),new Job(site));
		
		//People
		Person walter = new Person(this,"Charles","Smith");
		walter.addSkill(new Skill("farming",5));
		walter.addGood(new Good("food",5000));
		folks.add(walter);
		
		Person shims = new Person(this,"Shims","White");
		shims.addSkill(new Skill("farming",7));
		shims.addGood(new Good("food",3000));
		folks.add(shims);

		Person babs = new Person(this,"Dej","Denver");
		babs.addSkill(new Skill("hunting",3));
		babs.addGood(new Good("food",2500));
		folks.add(babs);
	 */
}
                
                
                
                
 