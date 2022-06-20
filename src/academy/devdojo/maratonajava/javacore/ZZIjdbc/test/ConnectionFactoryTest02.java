package academy.devdojo.maratonajava.javacore.ZZIjdbc.test;

import java.util.List;

import academy.devdojo.maratonajava.javacore.ZZIjdbc.dominio.Producer;
import academy.devdojo.maratonajava.javacore.ZZIjdbc.service.ProducerServiceRowSet;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class ConnectionFactoryTest02 {

	public static void main(String[] args) {
		Producer producerToUpdate = Producer.builder().id(1).name("MAD").build();
		ProducerServiceRowSet.updateCachedRowSet(producerToUpdate);
		log.info("------------------------");
		List<Producer> producers = ProducerServiceRowSet.findByNameJdbcRowSet("");
		log.info("Producers found {}", producers);
	}

}
