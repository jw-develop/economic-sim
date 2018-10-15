package game;

public class Resource {
	String nameofresource;
	double difficulty;
	double volatility = .05;
	int totalinlocation;
	Resource(String name,double difficulty,double volatility) {
		this.nameofresource = name;
		this.volatility = volatility;
		this.difficulty = difficulty;
	}
	public double getDifficulty() {
		return difficulty;
	}
	
	public String getNameofresource() {
		return nameofresource;
	}
	public double getVolatility() {
		return volatility;
	}
	public int getTotalinlocation() {
		return totalinlocation;
	}
	public int CollectResource(int rate) {
		totalinlocation -= rate;
		return rate;
	}
}