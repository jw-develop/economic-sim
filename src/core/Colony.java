package core;

import java.util.ArrayList;
import person.*;

public class Colony {
	public Colony() {
		this.foodcount = 5000;
		folks.add(new Hunter("Walter","Smith",1));
		folks.add(new Hunter("Jeffrey","Davis",1.2));
		folks.add(new Hunter("Shims","White",.7));
	}
	private boolean deserted;
	private int totaldays;
	private ArrayList<Person> folks = new ArrayList<Person>();
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
	public void setTotaldays(int totaldays) {
		this.totaldays = totaldays;
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
}