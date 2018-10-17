package game;

import java.util.HashMap;

public class Person {
	private String firstname;
	private String surname;
	private boolean dead;
	private int appetite = 2000;
	private Skill skill;
	private HashMap<String, Job> jobs;
	private String deathtag;
	
	private Inventory owned = new Inventory();
	
	public Person(Colony col,String first, String sur) {
		jobs = col.getJobs();
		this.firstname = first;
		this.surname = sur;
		//skills = new ArrayList<Skill>(Arrays.asList(skills));
		this.dead = false;
	}

	public void act() {
		eat(appetite);
		Job chosenjob = jobs.get(skill.getTypeofwork());
		Good yield = chosenjob.work(skill.getAbility());
		addGood(yield);
	}
	
	private void eat(int amount) {
		int eaten = owned.consume("food",amount);
		if (eaten>0) {
			deathtag = "starved wanting "+eaten+" food!";
			kill();
		}
	}
	
	public void addSkill(Skill skill) {
		this.skill = skill;
	}
	
	public void addGood(Good good) {
		owned.acquire(good);
	}

	public void exchange() {
		//colony.addTrade(this);
	}
	public void kill() {this.dead = true;}
	
	public String toString(Person guy) {
		return guy.getFullname();
	}

	public String getSurname() {return surname;}
	
	public Inventory getOwned() {return owned;}
	
	public String getFullname() {return firstname+" "+surname;}
	
	public String getDeathtag() {return deathtag;}

	public boolean isDead() {return dead;}
	
}