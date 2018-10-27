package simulator;

public class Skill {
	private int years;
	private String typeofwork;
	
	public Skill(String typeofwork,int years) {
		this.years = years;
		this.typeofwork = typeofwork;
	}

	public int getAbility() {
		return years;
	}

	public String getTypeofwork() {
		return typeofwork;
	}
}