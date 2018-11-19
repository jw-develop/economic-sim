package simulation;

import java.util.ArrayList;
import simulation.Person;

public class Colony {
	public Colony() {
		
	}
	private boolean deserted = false;
	private String desertionstate;
	private int totaldays;
	private ArrayList<Person> folks = new ArrayList<Person>();
	
	//private ArrayList<Resource> worksites = new ArrayList<Resource>();
	//private HashMap<String,Job> jobs = new HashMap<String,Job>();
	
	public boolean isDeserted() {
		return deserted;
	}
	public String getDesertionstate() {
		return desertionstate;
	}
	public void setDeserted(String desertionstate) {
		this.desertionstate = desertionstate;
		deserted = true;
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
	public void addFolk(Person indiv) {
		folks.add(indiv);
	}
	public void killFolk(Person indiv) {
		folks.remove(indiv);
	}
}