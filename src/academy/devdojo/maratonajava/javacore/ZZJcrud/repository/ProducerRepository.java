package academy.devdojo.maratonajava.javacore.ZZJcrud.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import academy.devdojo.maratonajava.javacore.ZZJcrud.conn.ConnectionFactory;
import academy.devdojo.maratonajava.javacore.ZZJcrud.dominio.Producer;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class ProducerRepository {

	public static List<Producer> findByName(String name) {
		log.info("Finding Producers by name '{}'", name);
		List<Producer> producers = new ArrayList<>();
		try (Connection conn = ConnectionFactory.getConnection();
				PreparedStatement ps = createPreparedStatementFindByName(conn, name);
				ResultSet rs = ps.executeQuery();) {
			while (rs.next()) {
				Producer producer = Producer.builder().id(rs.getInt("id")).name(rs.getString("name")).build();
				producers.add(producer);
			}
		} catch (SQLException e) {
			log.error("Error while trying to update producer", e);
		}
		return producers;
	}

	private static PreparedStatement createPreparedStatementFindByName(Connection conn, String name)
			throws SQLException {
		String sql = "SELECT id, name FROM anime_store.producer WHERE name LIKE ?;";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, String.format("%%%s%%", name));
		return ps;
	}

	public static void delete(int id) {
		try (Connection conn = ConnectionFactory.getConnection();
				PreparedStatement ps = createPreparedStatementDelete(conn, id)) {
			ps.execute();
			log.info("Deleted producer '{}' from the database", id);
		} catch (SQLException e) {
			log.error("Error while trying to delete producer '{}'", id, e);
		}
	}

	private static PreparedStatement createPreparedStatementDelete(Connection conn, Integer id) throws SQLException {
		String sql = "DELETE FROM `anime_store`.`producer` WHERE (`id` = ?);";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, id);
		return ps;
	}
}
