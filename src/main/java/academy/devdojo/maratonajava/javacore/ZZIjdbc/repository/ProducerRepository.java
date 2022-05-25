package academy.devdojo.maratonajava.javacore.ZZIjdbc.repository;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import academy.devdojo.maratonajava.javacore.ZZIjdbc.conn.ConnectionFactory;
import academy.devdojo.maratonajava.javacore.ZZIjdbc.dominio.Producer;
import lombok.extern.log4j.Log4j2;

@Log4j2 // problema Maven
public class ProducerRepository {
	public static void save(Producer producer) {
		String sql = "INSERT INTO `anime_store`.`producer` (`name`) VALUES ('%s');".formatted(producer.getName());
		try (Connection conn = ConnectionFactory.getConnection();
			 Statement stmt = conn.createStatement();) {
			int rowsAffected = stmt.executeUpdate(sql);
			log.info("rowsAffected {}", rowsAffected);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}