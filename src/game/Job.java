package game;

import java.util.HashMap;

public class Job {
	private String nameofgood;
	private Resource source;
	private HashMap<String,String> yieldtype = new HashMap<String,String>();
	Job(Resource source) {
		String worktype = source.getWorkType();
		this.source = source;
		yieldtype.put("farming","food");
		yieldtype.put("hunting","food");
		yieldtype.put("fishing","food");
		yieldtype.put("woodcutting","wood");
		yieldtype.put("mining","rock");
		nameofgood = yieldtype.get(worktype);
	}

	public Good work(int skilllevel) {
		//Insert fancy skilllevel ==> yield equation.
		int quantity = source.CollectResource(skilllevel);
		return new Good(nameofgood,quantity);
	}
}