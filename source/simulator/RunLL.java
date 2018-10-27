package simulator;

import java.io.IOException;

public class RunLL {

	public static void main(String[] args) throws IOException {
		Reader reader = new ReadTypes("data");
		reader.fillGlobe(new Globe());
		/*
		Globe globe = new Globe();
		
		Reader.fillGlobe(globe);
		while (!globe.isComplete())
			globe.nextDay();
			*/
	}
}