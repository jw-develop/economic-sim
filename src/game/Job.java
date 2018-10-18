package game;

import static game.Facts.*;

public class Job {
	private String nameofgood;
	private Resource source;

	Job(Resource source) {
		String worktype = source.getWorkType();
		this.source = source;
		nameofgood = yieldtypes.get(worktype);
	}

	public Good work(int skilllevel) {
		//Insert fancy skilllevel ==> yield equation.
		int quantity = source.CollectResource(skilllevel);
		return new Good(nameofgood,quantity);
	}
}