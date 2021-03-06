package academy.devdojo.maratonajava.javacore.ZZIjdbc.service;

import java.util.List;

import academy.devdojo.maratonajava.javacore.ZZIjdbc.dominio.Producer;
import academy.devdojo.maratonajava.javacore.ZZIjdbc.repository.ProducerRepository;

public class ProducerService {
	public static void save(Producer producer) {
		ProducerRepository.save(producer);
	}

	public static void saveTransactional(List<Producer> producers) {
		ProducerRepository.saveTransactional(producers);
	}

	public static void delete(Integer id) {
		requiredValidId(id);
		ProducerRepository.delete(id);
	}

	public static void update(Producer producer) {
		requiredValidId(producer.getId());
		ProducerRepository.update(producer);
	}

	public static void updatePreparedStatement(Producer producer) {
		requiredValidId(producer.getId());
		ProducerRepository.updatePreparedStatement(producer);
	}

	public static List<Producer> findAll() {
		return ProducerRepository.findAll();
	}

	public static List<Producer> findByName(String name) {
		return ProducerRepository.findByName(name);
	}

	public static List<Producer> findByNamePreparedStatement(String name) {
		return ProducerRepository.findByNamePreparedStatement(name);
	}

	public static List<Producer> findByNameCallableStatement(String name) {
		return ProducerRepository.findByNameCallableStatement(name);
	}

	public static void showProducerMetaData() {
		ProducerRepository.showProducerMetaData();
	}

	public static void showDriverMetaData() {
		ProducerRepository.showDriverMetaData();
	}

	public static void showTypeScrollWorking() {
		ProducerRepository.showTypeScrollWorking();
	}

	public static List<Producer> findByNameAndUpdateToUpperCase(String name) {
		return ProducerRepository.findByNameAndUpdateToUpperCase(name);
	}

	public static List<Producer> findByNameAndInsertWhenNotFound(String name) {
		return ProducerRepository.findByNameAndInsertWhenNotFound(name);
	}

	public static void findByNameAndDelete(String name) {
		ProducerRepository.findByNameAndDelete(name);
	}

	@SuppressWarnings("null")
	private static void requiredValidId(Integer id) {
		if (id == null && id <= 0) {
			throw new IllegalArgumentException("Invalid value for id");
		}
	}
}
