package game;

public class Resource {
	String nameofsite;
	String typeofwork;
	int dailyyield;
	double volatility;
	int totalinlocation;
	Resource(String nameofsite,String worktype,int totalinlocation,int dailyyield,double volatility) {
		this.nameofsite = nameofsite;
		this.typeofwork = worktype;
		this.totalinlocation = totalinlocation;
		this.dailyyield = dailyyield;
		this.volatility = volatility;
	}
	public void replenish() {
		if (totalinlocation <80000)
			totalinlocation *= 1.2;
	}
	public String getNameofsite() {
		return nameofsite;
	}
	public String getWorkType() {
		return typeofwork;
	}
	public double getVolatility() {
		return volatility;
	}
	public int getRemaining() {
		return totalinlocation;
	}
	public int CollectResource(int skilllevel) {
		int collected = (int) (dailyyield*Env.gauss(volatility));
		totalinlocation -= collected;
		return collected;
	}
}