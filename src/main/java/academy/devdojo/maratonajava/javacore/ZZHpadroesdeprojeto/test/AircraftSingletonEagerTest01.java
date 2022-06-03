package academy.devdojo.maratonajava.javacore.ZZHpadroesdeprojeto.test;

import academy.devdojo.maratonajava.javacore.ZZHpadroesdeprojeto.dominio.AircraftSingletonEager;

public class AircraftSingletonEagerTest01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		bookSeat("1A");
		bookSeat("1A");
	}

	private static void bookSeat(String seat) {
		System.out.println(AircraftSingletonEager.getINSTANCE());
		AircraftSingletonEager aircraftSingletonEager = AircraftSingletonEager.getINSTANCE();
		System.out.println(aircraftSingletonEager.bookSeat(seat));
	}
}
 