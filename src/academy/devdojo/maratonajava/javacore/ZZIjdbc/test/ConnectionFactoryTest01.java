package academy.devdojo.maratonajava.javacore.ZZIjdbc.test;

import academy.devdojo.maratonajava.javacore.ZZIjdbc.dominio.Producer;
import academy.devdojo.maratonajava.javacore.ZZIjdbc.repository.ProducerRepository;

public class ConnectionFactoryTest01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Producer producer = Producer.builder().name("Studio Deen").build();
		ProducerRepository.save(producer);
	}

}
