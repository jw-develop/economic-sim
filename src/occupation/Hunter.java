package occupation;

import envir.Env;
import perishible.*;

public class Hunter implements Occupation {
	public Object work() {
		return new Perishible((int) (Env.gauss(.05)*1950));
	}
}