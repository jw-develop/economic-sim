package game;

import java.util.ArrayList;
import java.util.HashMap;

public class Colony {
	public Colony() {
		Resource farmland = new Resource("food",1,.05);
		//Resource forest = new Resource("wood",1000,.01);
		
		//folks.add(new Person(this,"Walter","Smith",1,new Production(5,farmland)));
		Person jeff = new Person(this,"Walter","Smith");
		jeff.addJob(new Production(5,farmland));
		
		
		//folks.add(new Person(this,"Jeffrey","Davis",1.2));
		//folks.add(new Person(this,"Shims","White",.7));
	}
	private boolean deserted;
	private int totaldays;
	private ArrayList<Person> folks = new ArrayList<Person>();
	private HashMap<Person,Good> tradegoods= new HashMap<Person,Good>();
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
	public Good mergeTradeables(Good good1,Good good2) {
		//If same type//
		return new Good(good1.getNameofGood(),good1.getQuantity()+good2.getQuantity());
	}
}