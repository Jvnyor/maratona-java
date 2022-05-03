package academy.devdojo.maratonajava.javacore.ZZBcomportamento.interfaces;

import academy.devdojo.maratonajava.javacore.ZZBcomportamento.dominio.Car;

@FunctionalInterface
public interface CarPredicate {
	// anonimas, fun��es, conciso
	boolean test(Car car);
	// (parametro) -> <express�o>
	// (Car car) -> car.getColor().equals("green");
}
