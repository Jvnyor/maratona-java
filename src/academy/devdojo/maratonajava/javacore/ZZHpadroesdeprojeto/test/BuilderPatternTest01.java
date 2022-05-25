package academy.devdojo.maratonajava.javacore.ZZHpadroesdeprojeto.test;

import academy.devdojo.maratonajava.javacore.ZZHpadroesdeprojeto.dominio.Person;

public class BuilderPatternTest01 {

	public static void main(String[] args) {
		Person person = Person.PersonBuilder
			.builder()
			.firstName("William")
			.lastName("Suane")
			.username("viradonojiraya")
			.email("william.suane@devdojo.academy")
			.build();
		
		System.out.println(person);
		
	}

}
