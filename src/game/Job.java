package game;

public class Job {
	private String nameofgood;
	private Resource source;
	Job(Resource source) {
		nameofgood = source.getNameofresource();
		this.source = source;
	}

	public Good work(int skilllevel) {
		int quantity = source.CollectResource(1950);
		return new Good(nameofgood,quantity);
	}
}