package game;

import java.util.ArrayList;

public class Production extends Occupation {
	Resource produced;
	double volatility;
	int rate;
	Production(int years,Colony col, ArrayList<Good> owned,Resource produced) {
		super(years,col,owned);
		this.volatility = produced.getVolatility();
		this.produced = produced;
		this.rate = 1950;
	}

	public void work() {
		int quantity = (int)(Env.gauss(volatility)*produced.CollectResource(rate));
		owned.add(new Good(nameofproduced,quantity));
	}
}