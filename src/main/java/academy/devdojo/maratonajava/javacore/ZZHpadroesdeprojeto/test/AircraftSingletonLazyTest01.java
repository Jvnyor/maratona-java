package academy.devdojo.maratonajava.javacore.ZZHpadroesdeprojeto.test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import academy.devdojo.maratonajava.javacore.ZZHpadroesdeprojeto.dominio.AircraftSingletonLazy;

public class AircraftSingletonLazyTest01 {

	public static void main(String[] args) throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		// TODO Auto-generated method stub
		bookSeat("1A");
		bookSeat("1A");
		System.out.println(AircraftSingletonLazy.getINSTANCE());
		System.out.println(AircraftSingletonLazy.getINSTANCE());
		Constructor<AircraftSingletonLazy> constructor = AircraftSingletonLazy.class.getDeclaredConstructor(String.class);
		constructor.setAccessible(true);
		AircraftSingletonLazy aircraftSingletonLazy = constructor.newInstance("787-900");
		System.out.println(aircraftSingletonLazy);
	}

	private static void bookSeat(String seat) {
		System.out.println(AircraftSingletonLazy.getINSTANCE());
		AircraftSingletonLazy aircraftSingletonLazy = AircraftSingletonLazy.getINSTANCE();
		System.out.println(aircraftSingletonLazy.bookSeat(seat));
	}
}
 