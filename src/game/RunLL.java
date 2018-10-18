package game;

import java.io.IOException;

public class RunLL {

	public static void main(String[] args) throws IOException {
		Reader.fillGlobe(new Globe());
		/*
		Globe globe = new Globe();
		Reader reader = new Reader();
		Reader.fillGlobe(globe);
		while (!globe.isComplete())
			globe.nextDay();
			*/
	}
}