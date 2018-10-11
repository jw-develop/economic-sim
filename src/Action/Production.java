package Action;

import envir.Env;
import tradeable.Tradeable;

public class Production extends Occupation {
	public Object work() {
		return new Tradeable((int) (Env.gauss(.05)*1950));
	}
}