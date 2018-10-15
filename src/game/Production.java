package game;

import java.util.ArrayList;

public class Production extends Occupation {
	String nameofproduced;
	double volatility;
	double difficulty;
	int rate;
	Production(int years,Resource produced) {
		super(years);
		this.nameofproduced = produced.getNameofresource();
		this.volatility = produced.getVolatility();
		this.difficulty = produced.getDifficulty();
		this.rate = 1950;
	}

	public void work(ArrayList<Good> owned) {
		int quantity = (int)(Env.gauss(volatility)*difficulty*rate);
		owned.add(new Good(nameofproduced,quantity));
	}
}