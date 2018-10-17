package game;
import java.util.ArrayList;
import static game.Env.*;

/**
 * @author jameswhite
 *
 */
public class Cycle {
	private int day;
	private ArrayList<Person> people;
	private ArrayList<Person> justdied = new ArrayList<Person>();
	private ArrayList<Person> longdead = new ArrayList<Person>();
	
	//Method for incrementing day.
	public void nextDay(Colony colony) {
		colony.incTotaldays();
		
		//Fetching and printing variables
		day = colony.getTotaldays();
		people = colony.getFolks();
		
		p("\nDay %d - Member Count: %d - Death Count: %d\n",day,people.size(),longdead.size());
		
		//Circuit through population
		for (Person indiv : people) {
			indiv.act();
			p("%s has %s food after eating.\n",indiv.getSurname(),indiv.getAmtOfGood("food"));
			p("Food bundles are %s\n\n",indiv.getAmtOfEachGood("food"));
			p("",indiv.getFullname());
			if (indiv.isDead()) {
				justdied.add(indiv);
				p("%s has %s!\n\n",indiv.getSurname(),indiv.getDeathtag());
			}
		}
		//Bury bodies
		longdead.addAll(justdied);
		people.removeAll(justdied);
		justdied.clear();
		
		//A check for if colony should continue.
		if (colony.getTotaldays()>=100||people.isEmpty())
			colony.setDeserted(true);
	}
}