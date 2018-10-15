package game;

import java.util.ArrayList;

public abstract class Occupation {
	protected int years;
	protected Colony colony;
	protected ArrayList<Good> owned;
	//Production
	Occupation(Colony col, ArrayList<Good> owned,Resource produced) {
		this.owned = owned;
	}
	//Other
	Occupation(int years,Colony col, ArrayList<Good> owned) {
		
	}
	public abstract void work();
	public void setWorker(int years,Colony col) {
	}
}