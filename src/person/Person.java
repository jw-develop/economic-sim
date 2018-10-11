package person;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import Action.*;
import core.Colony;
import envir.Env;

public class Person {
	String firstname;
	String surname;
	int appetite = 2000;
	double pace = 1;
	
	int cash;
	int ownedfood;
	ArrayList<Object> owned;
	ArrayList<Occupation> jobs;
	HashSet<Person,Tradeable> colonytrades;
	
	public Person(Colony col,String first, String sur,double pace) {
		this.firstname = first;
		this.surname = sur;
		this.pace = pace;
		this.colonytrades = col.getTrades();
		ownedfood = 1000;
	}

	public void act(Colony colony) {
		
	}
	
	public void work() {}

	public void eat() {
		if (ownedfood>500) {
			colonytrades.remove(this,45);
		}
		else if (col.getFoodcount()<500) {
			trades.put(this, new Perishible(1000));
		}
		if (col.getFoodcount()<200) {
			aggravated++;
			Env.p(surname+" has gone without food!");
		}
		else {
			col.augFoodcount(-this.appetite);
		}
	}
	*/
	public static void barter() {}

	public int getAppetite() {
		return appetite;
	}
	public String getSurname() {
		return surname;
	}
	public String getFullname() {
		return firstname+" "+surname;
	}
}