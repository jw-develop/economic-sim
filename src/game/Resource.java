package game;

public class Resource {
	String nameofyield;
	int dailyyield;
	double volatility;
	int totalinlocation;
	Resource(String name,int dailyyield,double volatility) {
		this.nameofyield = name;
		this.volatility = volatility;
		this.dailyyield = dailyyield;
	}
	public String getNameofresource() {
		return nameofyield;
	}
	public double getVolatility() {
		return volatility;
	}
	public int CollectResource(int rate) {
		totalinlocation -= dailyyield*rate;
		return rate;
	}
}