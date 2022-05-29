package academy.devdojo.maratonajava.javacore.ZZIjdbc.repository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.JdbcRowSet;

import academy.devdojo.maratonajava.javacore.ZZIjdbc.conn.ConnectionFactory;
import academy.devdojo.maratonajava.javacore.ZZIjdbc.dominio.Producer;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class ProducerRepositoryRowSet {
	public static List<Producer> findByNameJdbcRowSet(String name) {
		log.info("Finding Producers by name");
		String sql = "SELECT * FROM anime_store.producer WHERE name LIKE ?;";
		List<Producer> producers = new ArrayList<>();
		try (JdbcRowSet jrs = ConnectionFactory.getJdbcRowSet();) {
			jrs.setCommand(sql);
			jrs.setString(1, String.format("%%%s%%", name));
			jrs.execute();
			while (jrs.next()) {
				Producer producer = Producer.builder().id(jrs.getInt("id")).name(jrs.getString("name")).build();
				producers.add(producer);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return producers;
	}
}
