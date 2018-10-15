package game;

import java.util.ArrayList;
import java.util.Arrays;

public class Person {
	private Colony colony;
	private String firstname;
	private String surname;
	private boolean dead;
	private int appetite = 2000;
	private ArrayList<Occupation> jobs;
	
	int cash;
	int ownedfood;
	ArrayList<Good> owned;
	
	public Person(Colony col,String first, String sur,Occupation ...occupations) {
		this.colony = col;
		this.firstname = first;
		this.surname = sur;
		jobs = new ArrayList<Occupation>(Arrays.asList(occupations));
		owned = new ArrayList<Good>();
		this.ownedfood = 10000;
		this.dead = false;
	}

	public void act() {
		eat();
		for (Occupation job : jobs)
			job.work();
		exchange();
	}

	private void eat() {
		if (ownedfood>2000)
			ownedfood-=appetite;
		else {
			Env.p(surname+" has gone without food!\n");
			kill();
		}
		/*
		if (ownedfood>5000) {
			int toexchange = ownedfood - 2000;
			ownedfood-=2000;
			colony.addTrade(this,new Good("food",toexchange));
		}
		*/
	}
	
	public void exchange() {
		//colony.addTrade(this);
	}
	public int getAppetite() {
		return appetite;
	}
	public String getSurname() {
		return surname;
	}
	public String getFullname() {
		return firstname+" "+surname;
	}
	
	public int getOwnedfood() {
		return ownedfood;
	}

	public boolean isDead() {
		return dead;
	}
	public void kill() {
		this.dead = true;
	}
}