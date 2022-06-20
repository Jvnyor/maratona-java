package academy.devdojo.maratonajava.javacore.ZZIjdbc.test;

import java.util.List;

import academy.devdojo.maratonajava.javacore.ZZIjdbc.dominio.Producer;
import academy.devdojo.maratonajava.javacore.ZZIjdbc.service.ProducerService;

public class ConnectionFactoryTest03 {

	public static void main(String[] args) {
		Producer producer = Producer.builder().name("Toei Animation").build();
		Producer producer2 = Producer.builder().name("White Fox").build();
		Producer producer3 = Producer.builder().name("Studio Ghibli").build();
		ProducerService.saveTransactional(List.of(producer, producer2, producer3));
	}

}
