package academy.devdojo.maratonajava.javacore.ZZIjdbc.test;

import java.util.List;

import academy.devdojo.maratonajava.javacore.ZZIjdbc.dominio.Producer;
import academy.devdojo.maratonajava.javacore.ZZIjdbc.service.ProducerService;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class ConnectionFactoryTest01 {
	public static void main(String[] args) {
		Producer producer = Producer.builder().name("Studio Deen").build();
		Producer producerToUpdate = Producer.builder().id(1).name("MADHOUSE").build();
//		ProducerService.save(producer);
//		ProducerService.delete(4);
//		ProducerService.update(producerToUpdate);
//		List<Producer> producers = ProducerService.findAll();
//		List<Producer> producers = ProducerService.findByName("Mad");
//		log.info("Producers found '{}'", producers);
//		ProducerService.showProducerMetaData();
		ProducerService.showDriverMetaData();
//		log.info("info");
//		log.debug("debug");
//		log.warn("warn");
//		log.error("error");
//		log.trace("trace");
	}
}
