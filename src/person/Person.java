package person;

import java.util.ArrayList;
import java.util.HashMap;
import core.Colony;
import envir.Env;
import occupation.*;
import perishible.*;

public abstract class Person {
	public static HashMap<String,Object> trades;
	
	Colony col;
	String firstname;
	String surname;
	int appetite = 2000;
	int aggravated = 0;
	boolean veryaggrav = false;
	double pace = 1;
	
	int cash;
	int ownedfood;
	ArrayList<Object> owned;
	ArrayList<Occupation> jobs;
	
	public Person(Colony col, String first, String sur,double pace) {
		this.col = col;
		this.firstname = first;
		this.surname = sur;
		this.pace = pace;
		ownedfood = 1000;
	}
	
	public abstract void act();

	public boolean live() {
		this.eat();
		this.work();
		return this.stay();
	}
	
	public void work() {}
	public boolean stay(){
		if (aggravated>2 & !veryaggrav) {
			Env.p(this.getSurname()+" is very aggravated . . .");
			veryaggrav = true;
		}
		return aggravated<4;
	}
	public void eat() {
		if (ownedfood>500) {
			trades.remove(trades.get(surname));
		}
		else if (col.getFoodcount()<500) {
			trades.put(surname, new Perishible(1000));
		}
		if (col.getFoodcount()<200) {
			aggravated++;
			Env.p(surname+" has gone without food!");
		}
		else {
			col.augFoodcount(-this.appetite);
		}
	}
	public static void barter() {
		
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