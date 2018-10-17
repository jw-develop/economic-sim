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
	private String deathtag;
	
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
		ArrayList<Good> depleted = new ArrayList<Good>();
		ArrayList<Good> consumeables = owned.get(goodname);
		if (consumeables == null)
			return false;
		for (Good consuming : consumeables) {
			if (consuming.getQuantity()<=amount) {
				amount -= consuming.getQuantity();
				depleted.add(consuming);
			}
			else {
				consuming.lowerQuantity(amount);
				break;
			}
		}
		consumeables.removeAll(depleted);
		if (consumeables.isEmpty()) {
			deathtag = "starved wanting "+amount+" food!";
			return false;
		}
		return true;
	}
	
	public void addSkill(Skill skill) {
		this.skill = skill;
	}
	public void addGood(Good good) {
		if (owned.get(good.getNameofGood())==null)
			owned.put(good.getNameofGood(),new ArrayList<Good>());
		ArrayList<Good> listofgoods = owned.get(good.getNameofGood());
		listofgoods.add(good);
	}
	public void exchange() {
		//colony.addTrade(this);
	}
	public void kill() {
		this.dead = true;
	}
	public int getAmtOfGood(String nameofgood) {
		ArrayList<Good> listofgoods = owned.get(nameofgood);
		int quantity = 0;
		for (Good thang : listofgoods)
			quantity+=thang.getQuantity();
		return quantity;
	}
	
	public ArrayList<Integer> getAmtOfEachGood(String nameofgood) {
		ArrayList<Good> listofgoods = owned.get(nameofgood);
		ArrayList<Integer> quantities = new ArrayList<Integer>();
		for (Good thang : listofgoods)
			quantities.add(thang.getQuantity());
		return quantities;
	}

	public HashMap<String, ArrayList<Good>> getOwned() {
		return owned;
	}

	public String getSurname() {return surname;}
	
	public String getFullname() {return firstname+" "+surname;}
	
	public String getDeathtag() {return deathtag;}

	public boolean isDead() {return dead;}
	
}