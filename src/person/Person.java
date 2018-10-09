package person;

import java.util.ArrayList;
import core.Colony;
import envir.Env;
import perishible.*;

public class Person {
	public static HashMap<Object,Integer> trades;
	
	String firstname;
	String surname;
	int appetite = 2000;
	int aggravated = 0;
	boolean veryaggrav = false;
	double pace = 1;
	
	int cash;
	int ownedfood;
	ArrayList<Object> owned;
	
	public Person(String first, String sur,double pace) {
		this.firstname = first;
		this.surname = sur;
		this.pace = pace;
		ownedfood = 1000;
	}

	public boolean live(Colony col) {
		this.eat(col);
		this.work(col);
		return this.stay(col);
	}
	
	public void work(Colony col) {}
	public boolean stay(Colony col){
		if (aggravated>2 & !veryaggrav) {
			Env.p(this.getSurname()+" is very aggravated . . .");
			veryaggrav = true;
		}
		return aggravated<4;
	}
	public void eat(Colony col) {
		if (>500) {
			trades.remove(Perishible);
		}
		else if (col.getFoodcount()<500) {
			trades.add(new Perishible(1000));
		}
		if (col.getFoodcount()<200) {
			aggravated++;
			Env.p(surname+" has gone without food!");
		}
		else {
			col.augFoodcount(-this.appetite);
		}
	}
	public static void barter(Colony col) {
		
	}

	public int getAppetite() {
		return appetite;
	}
	public void setAppetite(int appetite) {
		this.appetite = appetite;
	}
	public String getSurname() {
		return surname;
	}
	public String getFullname() {
		return firstname+" "+surname;
	}
}