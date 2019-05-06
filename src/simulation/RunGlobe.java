package simulation;

public class RunGlobe {
	
	public static void main(String[] args) {
		
		Globe earth = new Globe();
		
		Disp.display("Initialized\n");
		while (earth.isDone())
			earth.nextDay();
		
		Disp.display("Completed\n");
	}
}