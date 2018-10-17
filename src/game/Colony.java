package game;

import java.util.ArrayList;
import java.util.HashMap;

public class Colony {
	public Colony() {
		Resource farmland = new Resource("food",1,.05);
		//Resource forest = new Resource("wood",1000,.01);
		this.availablejob = new Job(farmland);
		
		Person walter = new Person(this,"Walter","Smith");
		walter.addSkill(new Skill("farming",5));
		walter.addGood(new Good("food",5000));
		folks.add(walter);
		
		Person shims = new Person(this,"Shims","White");
		shims.addSkill(new Skill("farming",7));
		shims.addGood(new Good("food",3000));
		folks.add(shims);

		Person babs = new Person(this,"Dej","Denver");
		babs.addSkill(new Skill("farming",3));
		babs.addGood(new Good("food",2500));
		folks.add(babs);
	}
	private boolean deserted;
	private int totaldays;
	private ArrayList<Person> folks = new ArrayList<Person>();
	private HashMap<Person,Good> tradegoods= new HashMap<Person,Good>();
	
	//private ArrayList<Resource> worksites = new ArrayList<Resource>();
	//private HashMap<String,Job> jobs = new HashMap<String,Job>();
	private Job availablejob;
	
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
	public void addFolk(Person indiv) {
		folks.add(indiv);
	}
	public void killFolk(Person indiv) {
		folks.remove(indiv);
	}

	public void addTrade(Person trader,Good tradegood) {
		if (!tradegoods.containsKey(trader))
			tradegoods.put(trader, tradegood);
		/*
		else
			tradegoods.put(trader, mergeTradeables(tradegoods.get(trader),tradegood));
			*/
	}
	
	public void resolveTrades() {
		
	}
	public Job getJob() {
		return availablejob;
	}
	//public void setJobs(HashMap<String, Job> jobs) {
		//this.jobs = jobs;
	//}
}