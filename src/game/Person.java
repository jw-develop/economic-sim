package game;

import java.util.ArrayList;
import java.util.HashMap;

public class Person {
	private String firstname;
	private String surname;
	private boolean dead;
	private int appetite = 2000;
	private Skill skill;
	private Job job;
	
	private HashMap<String,ArrayList<Good>> owned = new HashMap<String,ArrayList<Good>>();
	
	public Person(Colony col,String first, String sur) {
		job = col.getJob();
		this.firstname = first;
		this.surname = sur;
		//skills = new ArrayList<Skill>(Arrays.asList(skills));
		this.dead = false;
	}

	public void act() {
		boolean ate = consume("food",appetite);
		if (!ate)
			kill();
		Good yield = job.work(skill.getYears());
		this.addGood(yield);
	}
	
	private boolean consume(String goodname,int amount) {
		ArrayList<Good> consumeables = owned.get(goodname);
		if (consumeables == null)
			return false;
		for (Good consuming:consumeables) {
			if (consuming.getQuantity()<=amount) {
				amount -= consuming.getQuantity();
				consumeables.remove(consuming);
			}
			else {
				consuming.lowerQuantity(amount);
				return true;
			}
		}
		return false;
	}
	
	public void addSkill(Skill skill) {
		this.skill = skill;
	}
	public void addGood(Good good) {
		ArrayList<Good> listofgoods = owned.get(good.getNameofGood());
		listofgoods.add(good);
	}
	public ArrayList<Good> getOwnedOfGood(String nameofgood) {return owned.get(nameofgood);}
	
	public void exchange() {
		//colony.addTrade(this);
	}
	public void kill() {
		this.dead = true;
	}

	public String getSurname() {return surname;}
	
	public String getFullname() {return firstname+" "+surname;}
	
	public boolean isDead() {return dead;}
	
}