package academy.devdojo.maratonajava.javacore.ZZHpadroesdeprojeto.test;

import academy.devdojo.maratonajava.javacore.ZZHpadroesdeprojeto.dominio.Aircraft;
import academy.devdojo.maratonajava.javacore.ZZHpadroesdeprojeto.dominio.AircraftSingletonEager;

public class AircraftTest01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		bookSeat("1A");
		bookSeat("1A");
		AircraftTest01.bookSeat("1A");
	}

	private static void bookSeat(String seat) {
		System.out.println(AircraftSingletonEager.getINSTANCE());
		Aircraft aircraft = new Aircraft("787-900");
		System.out.println(aircraft.bookSeat(seat));
	}
}
