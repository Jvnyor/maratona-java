package academy.devdojo.maratonajava.javacore.ZZIjdbc.service;

import java.util.List;

import academy.devdojo.maratonajava.javacore.ZZIjdbc.dominio.Producer;
import academy.devdojo.maratonajava.javacore.ZZIjdbc.repository.ProducerRepositoryRowSet;

public class ProducerServiceRowSet {
	public static List<Producer> findByNameJdbcRowSet(String name) {
		return ProducerRepositoryRowSet.findByNameJdbcRowSet(name);
	}
}
