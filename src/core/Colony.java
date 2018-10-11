package core;

import java.util.ArrayList;
import java.util.HashMap;

import person.*;

public class Colony {
	public Colony() {
		folks.add(new Person(this,"Walter","Smith",1));
		folks.add(new Person(this,"Jeffrey","Davis",1.2));
		folks.add(new Person(this,"Shims","White",.7));
	}
	private boolean deserted;
	private int totaldays;
	private ArrayList<Person> folks = new ArrayList<Person>();
	public HashMap<Person,Object> trades;
	public boolean isDeserted() {
		return deserted;
	}
	public void setDeserted(boolean deserted) {
		this.deserted = deserted;
	}
	public int getTotaldays() {
		return totaldays;
	}
	public void incTotaldays() {
		this.totaldays++;
	}
	public ArrayList<Person> getFolks() {
		return folks;
	}
	public void setFolks(ArrayList<Person> folks) {
		this.folks = folks;
	}
	public void addFolk(Person indiv) {
		folks.add(indiv);
	}
	public void killFolk(Person indiv) {
		folks.remove(indiv);
	}
	public HashMap<Person, Object> getTrades() {
		return trades;
	}
	public void setTrades(HashMap<Person, Object> trades) {
		this.trades = trades;
	}
	public void addTrade(Person person, Object thing) {
		trades.put(person, thing);
	}
}