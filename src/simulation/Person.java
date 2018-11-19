package simulation;

public class Person {
	private String firstname;
	private String surname;
	private boolean dead;
	private int appetite = 2000;
	private String deathtag;
	
	private Inventory owned = new Inventory();
	
	public Person(String first, String sur) {
		this.firstname = first;
		this.surname = sur;
		owned.acquire(new Good("food",3000));
		this.dead = false;
	}

	public void act() {
		eat(appetite);
		Good yield = new Good("food",1950);
		addGood(yield);
	}
	
	private void eat(int amount) {
		int eaten = owned.consume("food",amount);
		if (eaten>0) {
			deathtag = "starved wanting "+eaten+" food!";
			kill();
		}
	}
	
	public void addGood(Good good) {
		owned.acquire(good);
	}

	public void kill() {this.dead = true;}
	
	public String toString() {
		return this.getFullname();
	}

	public String getSurname() {return surname;}
	
	public Inventory getOwned() {return owned;}
	
	public String getFullname() {return firstname+" "+surname;}
	
	public String getDeathtag() {return deathtag;}

	public boolean isDead() {return dead;}
	
}