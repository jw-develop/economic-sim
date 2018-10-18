package game;
import java.util.ArrayList;
import static game.Env.*;

/**
 * @author jameswhite
 *
 */
public class Globe {
	public static int date;
	private int terminationday;
	private ArrayList<Person> justdied = new ArrayList<Person>();
	private ArrayList<Person> longdead = new ArrayList<Person>();
	private boolean printnextday;
	private boolean complete = false;
	Colony colony = new Colony();
	
	public Globe() {
		terminationday = 50;
		printnextday = true;
	}
	//Method for incrementing day.
	public void nextDay() {
		
		colony.incTotaldays();
		ArrayList<Person> people = colony.getFolks();
		ArrayList<Resource> worksites = colony.getWorksites();
		int currentday = colony.getTotaldays();
		
		//Increment of days to print
		int printinc = 20;
		if (currentday % printinc == 0 || currentday == terminationday)
			printnextday = true;
		
		//Activating printnextday
		boolean noteworthy = false;
		if (printnextday)
			noteworthy = true;
		printnextday = false;
		
		//Print statements
		if (noteworthy) {
			p("Day %d - Member Count: %d - Death Count: %d\n",currentday,people.size(),longdead.size());
			for (Resource site : worksites)
				p("%s has %s remaining.\n\n",site.getNameofsite(),site.getRemaining());
			for (Person indiv : people) {
				//Total food after eating.
				p("  %s has %s food after eating.\n",indiv.getSurname(),indiv.getOwned().getAmtOfGood("food"));
				//Individual food bundles.
				p("     Food bundles are %s.\n\n",indiv.getOwned().getAmtOfEachGood("food"));
			}
		}
		
		//Act through resources
		for (Resource site : worksites)
			site.replenish();
		
		//Act through population
		for (Person indiv : people) {
			indiv.act();
			if (indiv.isDead()) {
				justdied.add(indiv);
				p("On Day %s %s %s!\n\n",currentday,indiv.getSurname(),indiv.getDeathtag());
			}
		}
		//Bury bodies
		longdead.addAll(justdied);
		people.removeAll(justdied);
		justdied.clear();
		
		//Termination conditions
		if (people.isEmpty())
			colony.setDeserted("All colonists have perished . . .");
		else if (colony.getTotaldays()>=terminationday) {
			String survivors = "";
			String perished = "";
			for (Person indiv : people)
				survivors += indiv.getFullname()+" - ";
			for (Person indiv : longdead)
				perished += indiv.getFullname()+ " - ";
			colony.setDeserted("Survivors: "+survivors+"\n\nPerished: "+perished);
		}
		
		if (colony.isDeserted()) {
			p(colony.getDesertionstate());
			finishSimulation();
		}
	}
	public boolean isComplete() {
		return complete;
	}
	public void finishSimulation() {
		complete = true;
	}
	
	
}