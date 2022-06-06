package academy.devdojo.maratonajava.javacore.ZZKjunit.dominio;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DeveloperTest {

	@Test
	public void instanceOf_ExecutesChildClassMethod_WhenObjectsIsOfChildType() {
		Employee employeeDeveloper = new Developer("1", "Java");
		if (employeeDeveloper instanceof Developer) {
			Developer developer = (Developer) employeeDeveloper;
			Assertions.assertEquals("Java", developer.getMainLanguage());
		}
		
		if (employeeDeveloper instanceof Developer developer) {
			Assertions.assertEquals("Java", developer.getMainLanguage());
		}
	}
}
