package simulator;

import java.util.ArrayList;
import java.util.HashMap;

public class Colony {
	public Colony() {
		//Worksites
		//Resource abstract type
			//Food v. other?
		
		ReadTypes typeinput = new ReadTypes("data");
    	typeinput.read();
		
    	/*
		worksites.add(new Resource("Farmland","farming",50000,1900,.01));
		worksites.add(new Resource("Forest","hunting",50000,2100,.05));
		
		for (Resource site : worksites)
			jobs.put(site.getWorkType(),new Job(site));
		
		//People
		Person walter = new Person(this,"Charles","Smith");
		walter.addSkill(new Skill("farming",5));
		walter.addGood(new Good("food",5000));
		folks.add(walter);
		
		Person shims = new Person(this,"Shims","White");
		shims.addSkill(new Skill("farming",7));
		shims.addGood(new Good("food",3000));
		folks.add(shims);

		Person babs = new Person(this,"Dej","Denver");
		babs.addSkill(new Skill("hunting",3));
		babs.addGood(new Good("food",2500));
		folks.add(babs);
		*/
	}
	private boolean deserted = false;
	private String desertionstate;
	private int totaldays;
	private ArrayList<Person> folks = new ArrayList<Person>();
	
	private ArrayList<Resource> worksites = new ArrayList<Resource>();
	private HashMap<String,Job> jobs = new HashMap<String,Job>();
	
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

	public HashMap<String,Job> getJobs() {
		return jobs;
	}
	public ArrayList<Resource> getWorksites() {
		return worksites;
	}
	//public void setJobs(HashMap<String, Job> jobs) {
		//this.jobs = jobs;
	//}
}