package simulator;

import java.util.Random;

public class Env {
	private static Random rand = new Random();
	public static int rand(int x) {
		return rand.nextInt(x);
	}
	public static double rand() {
		return rand.nextDouble();
	}
	public static double gauss(double x) {
		return (1/x)/(rand.nextGaussian()+(1/x));
	}
	//Printing method
	public static void p(String s,Object...args) {
		System.out.printf(s,args);
	}
}