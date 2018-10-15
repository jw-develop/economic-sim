package game;
import java.util.ArrayList;
import static game.Env.*;

/**
 * @author jameswhite
 *
 */
public class Cycle {
	private int day;
	private String deaths = "";
	private ArrayList<Person> people;
	private ArrayList<Person> dead = new ArrayList<Person>();
	
	//Method for incrementing day.
	public void nextDay(Colony colony) {
		colony.incTotaldays();
		
		//Fetching and printing variables
		day = colony.getTotaldays();
		people = colony.getFolks();
		p("Day %d - Member Count: %d - Death Count: %d\n",day,people.size(),dead.size());
		
		//Circuit through population
		for (Person indiv : people) {
			indiv.act();
			p("%s has %s food after eating.\n",indiv.getSurname(),indiv.getOwnedfood());
			p("",indiv.getFullname());
			if (indiv.isDead()) {
				dead.add(indiv);
				deaths += " "+indiv.getSurname();
			}
		}
		for (Person indiv : dead) {

			if (indiv.isDead()) {
				p("%s has died!\n", deaths);
				colony.killFolk(indiv);
				deaths = "";
			}
		}
		
		
		//A check for if colony should continue.
		if (colony.getTotaldays()>=100||people.isEmpty())
			colony.setDeserted(true);
	}
}