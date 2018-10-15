package game;

import java.util.ArrayList;

public abstract class Occupation {
	protected int years;
	protected Colony colony;
	Occupation(int years) {
		this.years = years;
	}
	public void work(Colony col,ArrayList<Good> owned) {
		work(owned);
		work(col);
	}
	public void work(ArrayList<Good> owned) {
		work();
	}
	public void work(Colony col) {
		work();
	}
	public void work() {}
}