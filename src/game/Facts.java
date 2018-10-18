package game;

import java.util.HashMap;

public class Facts {
	
	public static HashMap<String,String> yieldtype = new HashMap<String,String>();
	
	static {
	yieldtype.put("farming","food");
	yieldtype.put("hunting","food");
	yieldtype.put("fishing","food");
	yieldtype.put("woodcutting","wood");
	yieldtype.put("mining","rock");
	}
}
