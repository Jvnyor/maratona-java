package academy.devdojo.maratonajava.javacore.ZZIjdbc.repository;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.JdbcRowSet;

import academy.devdojo.maratonajava.javacore.ZZIjdbc.conn.ConnectionFactory;
import academy.devdojo.maratonajava.javacore.ZZIjdbc.dominio.Producer;
import academy.devdojo.maratonajava.javacore.ZZIjdbc.listener.CustomRowSetListener;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class ProducerRepositoryRowSet {
	public static List<Producer> findByNameJdbcRowSet(String name) {
		log.info("Finding Producers by name");
		String sql = "SELECT * FROM anime_store.producer WHERE name LIKE ?;";
		List<Producer> producers = new ArrayList<>();
		try (JdbcRowSet jrs = ConnectionFactory.getJdbcRowSet();) {
			jrs.addRowSetListener(new CustomRowSetListener());
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

//	public static void updateJdbcRowSet(Producer producer) {
//		log.info("Finding Producers by name");
//		String sql = "UPDATE `anime_store`.`producer` SET `name` = ?  WHERE (`id` = ?);";
//		try (JdbcRowSet jrs = ConnectionFactory.getJdbcRowSet();) {
//			jrs.setCommand(sql);
//			jrs.setString(1, producer.getName());
//			jrs.setInt(2, producer.getId());
//			jrs.execute();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}

	public static void updateJdbcRowSet(Producer producer) {
		String sql = "SELECT * FROM anime_store.producer WHERE (`id` = ?);";
		try (JdbcRowSet jrs = ConnectionFactory.getJdbcRowSet();) {
			jrs.addRowSetListener(new CustomRowSetListener());
			jrs.setCommand(sql);
			jrs.setInt(1, producer.getId());
			jrs.execute();
			if (!jrs.next()) {
				return;
			}
			jrs.updateString("name", producer.getName());
			jrs.updateRow();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void updateCachedRowSet(Producer producer) {
		String sql = "SELECT * FROM producer WHERE (`id` = ?);";
		try (CachedRowSet crs = ConnectionFactory.getCachedRowSet();
				Connection conn = ConnectionFactory.getConnection()) {
			conn.setAutoCommit(false);
			crs.setCommand(sql);
			crs.setInt(1, producer.getId());
			crs.execute(conn);
			if (!crs.next()) {
				return;
			}
			crs.updateString("name", producer.getName());
			crs.updateRow();
			TimeUnit.SECONDS.sleep(10);
			crs.acceptChanges();
		} catch (SQLException | InterruptedException e) {
			e.printStackTrace();
		}
	}

}
