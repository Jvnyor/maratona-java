package academy.devdojo.maratonajava.javacore.ZZEstreams.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class StreamTest04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<List<String>> devdojo = new ArrayList<>();
		List<String> graphicDesigners = List.of("Wildnei Suane", "Catarina Santos", "Sandy Carolina");
		List<String> developers = List.of("William", "David", "Harisson");
		List<String> students = List.of("�dipo", "Gustavo Lima", "Gustavo Mendes", "Guilherme");
		devdojo.add(graphicDesigners);
		devdojo.add(developers);
		devdojo.add(students);
//		devdojo.forEach(people -> {
//			people.forEach(System.out::println);
//		});
		devdojo.stream()
			.flatMap(Collection::stream)
			.forEach(System.out::println);;
	}

}
