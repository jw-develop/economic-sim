package person;

import core.Colony;
import envir.Env;

public class Hunter extends Person {
	public Hunter(String first, String sur,double pace) {
		super(first, sur, pace);
	}
	public void work(Colony col) {
		col.augFoodcount((int) (Env.gauss(.05)*1950));
	}
}