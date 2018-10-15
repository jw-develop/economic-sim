package game;

public class Resource {
	String nameofresource;
	int dailyyield = 1950;
	double volatility = .05;
	int totalinlocation;
	Resource(String name,int dailyyield,double volatility) {
		this.nameofresource = name;
		this.volatility = volatility;
		this.dailyyield = dailyyield;
	}
	public String getNameofresource() {
		return nameofresource;
	}
	public double getVolatility() {
		return volatility;
	}
	public int CollectResource(int rate) {
		totalinlocation -= dailyyield*rate;
		return rate;
	}
}