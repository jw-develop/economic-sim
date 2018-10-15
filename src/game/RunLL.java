package game;

public class RunLL {

	public static void main(String[] args) {
		Colony colony = new Colony();
		Cycle cycle = new Cycle();
		while (!colony.isDeserted())
			cycle.nextDay(colony);
		System.out.println("There is no one left in the colony.");
	}
}