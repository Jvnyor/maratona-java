package academy.devdojo.maratonajava.javacore.ZZJcrud.service;

import java.util.List;
import java.util.Scanner;

import academy.devdojo.maratonajava.javacore.ZZJcrud.dominio.Producer;
import academy.devdojo.maratonajava.javacore.ZZJcrud.repository.ProducerRepository;

public class ProducerService {

	private static final Scanner SCANNER = new Scanner(System.in);

	public static void menu(int op) {
		switch (op) {
		case 1:
			findByName();
			break;
		case 2:
			delete();
			break;
		default:
			throw new IllegalArgumentException("Not a valid option");
		}
	}

	public static void findByName() {
		System.out.println("Type the name or empty to all");
		String name = SCANNER.nextLine();
		List<Producer> producers = ProducerRepository.findByName(name);
		for (int i = 0; i < producers.size(); i++) {
			System.out.printf("[%d] - ID: %d %s%n", i, producers.get(i).getId(), producers.get(i).getName());
		}
	}

	private static void delete() {
		System.out.println("Type the id of the producer you want to delete");
		int id = Integer.parseInt(SCANNER.nextLine());
		System.out.println("Are you sure? S/N");
		String choice = SCANNER.nextLine();
		if ("s".equalsIgnoreCase(choice)) {
			ProducerRepository.delete(id);
		}
	}
}
