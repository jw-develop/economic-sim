package core;
import java.util.ArrayList;

import envir.Env;
import person.*;

/**
 * @author jameswhite
 *
 */
public class Cycle {
	private int day;
	private int food;
	private ArrayList<Person> people;
	//Method for incrementing day.
	public void nextDay(Colony colony) {
		//Incrementing day.
		colony.incTotaldays();
		
		//Fetching and printing vars
		day = colony.getTotaldays();
		people = colony.getFolks();
		food = colony.getFoodcount();
		Env.p("Day %d - Current Food: %d - Member Count: %d\n",day,food,people.size());
		
		//Circuit through population
		for (int i=0;i<people.size();i++) {
			Person indiv = people.get(i);
			String name = indiv.getSurname();
			if (!indiv.live(colony)) {
				Env.p("",indiv.getFullname());
				colony.killFolk(indiv);
				if (people.isEmpty())
					colony.setDeserted(true);;
			}
			//Trades between members
			
			food = colony.getFoodcount();
			Env.p("Remaining food after %s: %d\n",name,food);
		}
		if (colony.getTotaldays()>=1000)
			colony.setDeserted(true);
		Env.p("\n",colony.getTotaldays(),colony.getFoodcount());
	}
}