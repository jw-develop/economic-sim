package simulation;

public class RunGlobe {
	
	public static void main(String[] args) {
		
		Globe earth = new Globe();
		
		Disp.display("New world created");
		while (earth.isDone())
			earth.nextDay();
		
		Disp.display("New world terminated");
	}
}