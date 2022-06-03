package academy.devdojo.maratonajava.javacore.ZZKjunit.service;

import java.util.Objects;

import academy.devdojo.maratonajava.javacore.ZZKjunit.dominio.Person;

public class PersonService {
	public boolean isAdult(Person person) {
		Objects.requireNonNull(person, "Person can't be null");
		return person.getAge() >= 21;
	}
}
