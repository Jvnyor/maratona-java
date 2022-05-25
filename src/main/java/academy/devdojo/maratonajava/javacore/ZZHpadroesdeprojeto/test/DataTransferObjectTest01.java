package academy.devdojo.maratonajava.javacore.ZZHpadroesdeprojeto.test;

import academy.devdojo.maratonajava.javacore.ZZHpadroesdeprojeto.dominio.Aircraft;
import academy.devdojo.maratonajava.javacore.ZZHpadroesdeprojeto.dominio.Country;
import academy.devdojo.maratonajava.javacore.ZZHpadroesdeprojeto.dominio.Currency;
import academy.devdojo.maratonajava.javacore.ZZHpadroesdeprojeto.dominio.CurrencyFactory;
import academy.devdojo.maratonajava.javacore.ZZHpadroesdeprojeto.dominio.Person;
import academy.devdojo.maratonajava.javacore.ZZHpadroesdeprojeto.dominio.ReportDto;

public class DataTransferObjectTest01 {

	public static void main(String[] args) {
		Aircraft aircraft = new Aircraft("777");
		Country country = Country.BRAZIL;
		Currency currency = CurrencyFactory.newCurrency(country);
		
		Person person = Person.PersonBuilder.builder()
				.firstName("William")
				.lastName("Suane")
				.build();
		
		ReportDto reportDto = ReportDto.ReportDtoBuilder.builder()
				.aircraftName(aircraft.getName())
				.country(country)
				.currency(currency)
				.personName(person.getFirstName().concat(" ").concat(person.getLastName()))
				.build();
		
		System.out.println(reportDto);
	}

}
