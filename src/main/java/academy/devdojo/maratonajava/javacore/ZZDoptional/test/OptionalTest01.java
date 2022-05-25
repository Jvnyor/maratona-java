package academy.devdojo.maratonajava.javacore.ZZDoptional.test;

import java.util.List;
import java.util.Optional;

public class OptionalTest01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Optional<String> o1 = Optional.of("fewioqhfioweh hfq ");
		Optional<String> o2 = Optional.ofNullable(null);
		Optional<String> o3 = Optional.empty();
		System.out.println(o1);
		System.out.println(o2);
		System.out.println(o3);
		Optional<String> nameOptional = findName("William");
		String empty = nameOptional.orElse("EMPTY");
		System.out.println(empty);
		nameOptional.ifPresent(s -> System.out.println(s.toUpperCase()));

	}

	private static Optional<String> findName(String name) {
		List<String> list = List.of("William", "Devdojo");
		int i = list.indexOf(name);
		if (i != 1) {
			return Optional.of(list.get(i));
		}
		return Optional.empty();
	}

}
