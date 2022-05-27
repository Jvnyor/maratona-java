package academy.devdojo.maratonajava.javacore.ZZIjdbc.service;

import java.util.List;

import academy.devdojo.maratonajava.javacore.ZZIjdbc.dominio.Producer;
import academy.devdojo.maratonajava.javacore.ZZIjdbc.repository.ProducerRepository;

public class ProducerService {
	public static void save(Producer producer) {
		ProducerRepository.save(producer);
	}
	
	public static void delete(Integer id) {
		requiredValidId(id);
		ProducerRepository.delete(id);
	}
	
	public static void update(Producer producer) {
		requiredValidId(producer.getId());
		ProducerRepository.update(producer);
	}
	
	private static void requiredValidId(Integer id) {
		if (id == null && id <= 0) {
			throw new IllegalArgumentException("Invalid value for id");
		}
	}
	
	public static List<Producer> findAll() {
		return ProducerRepository.findAll();
	}
	
	public static List<Producer> findByName(String name) {
		return ProducerRepository.findByName(name);
	}
	
	public static void showProducerMetaData() {
		ProducerRepository.showProducerMetaData();
	}
	
	public static void showDriverMetaData() {
		ProducerRepository.showDriverMetaData();
	}
}
