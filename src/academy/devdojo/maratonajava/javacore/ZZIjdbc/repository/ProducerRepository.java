package academy.devdojo.maratonajava.javacore.ZZIjdbc.repository;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import academy.devdojo.maratonajava.javacore.ZZIjdbc.conn.ConnectionFactory;
import academy.devdojo.maratonajava.javacore.ZZIjdbc.dominio.Producer;

//@Log4j2
public class ProducerRepository {
	public static void save(Producer producer) {
		String sql = "INSERT INTO `anime_store`.`producer` (`name`) VALUES ('%s');".formatted(producer.getName());
		try (Connection conn = ConnectionFactory.getConnection(); Statement stmt = conn.createStatement();) {
			int rowsAffected = stmt.executeUpdate(sql);
			log.info("Inserted producer '{}' in the database, rows affected '{}'", producer.getName(), rowsAffected);
		} catch (SQLException e) {
			log.error("Error while trying to insert producer '{}'", producer.getName(), e);
		}
	}

	public static void saveTransactional(List<Producer> producers) {
		try (Connection conn = ConnectionFactory.getConnection()) {
			conn.setAutoCommit(false);
			preparedStatementSaveTransactional(conn, producers);
			conn.commit();
			conn.setAutoCommit(true);
		} catch (SQLException e) {
			log.error("Error while trying to save producer '{}'", producers, e);
		}
	}

	private static void preparedStatementSaveTransactional(Connection conn, List<Producer> producers)
			throws SQLException {
		String sql = "INSERT INTO `anime_store`.`producer` (`name`) VALUES ( ? );";
		boolean shouldRollback = false;
		for (Producer p : producers) {
			log.info("Saving producer '{}'", p.getName());
			try (PreparedStatement ps = conn.prepareStatement(sql)) {
				ps.setString(1, p.getName());
				if (p.getName().equals("White Fox")) throw new SQLException("Can't save White Fox");
				ps.execute();
			} catch (SQLException e) {
				e.printStackTrace();
				shouldRollback = true;
			}
		}
		if (shouldRollback) {
			log.warn("Transaction is goind be rollback");
			conn.rollback();
		}
	}

	public static void delete(int id) {
		String sql = "DELETE FROM `anime_store`.`producer` WHERE (`id` = '%d');".formatted(id);
		try (Connection conn = ConnectionFactory.getConnection(); Statement stmt = conn.createStatement();) {
			int rowsAffected = stmt.executeUpdate(sql);
			log.info("Deleted producer '{}' from the database, rows affected '{}'", id, rowsAffected);
		} catch (SQLException e) {
			log.error("Error while trying to delete producer '{}'", id, e);
		}
	}

	public static void update(Producer producer) {
		String sql = "UPDATE `anime_store`.`producer` SET `name` = '%s ' WHERE (`id` = '%d');"
				.formatted(producer.getName(), producer.getId());
		try (Connection conn = ConnectionFactory.getConnection(); Statement stmt = conn.createStatement();) {
			int rowsAffected = stmt.executeUpdate(sql);
			log.info("Updated producer '{}', rows affected '{}'", producer.getId(), rowsAffected);
		} catch (SQLException e) {
			log.error("Error while trying to update producer '{}'", producer.getId(), e);
		}
	}

	public static void updatePreparedStatement(Producer producer) {
		try (Connection conn = ConnectionFactory.getConnection();
				PreparedStatement ps = preparedStatementUpdate(conn, producer);) {
			int rowsAffected = ps.executeUpdate();
			log.info("Updated producer '{}', rows affected '{}'", producer.getId(), rowsAffected);
		} catch (SQLException e) {
			log.error("Error while trying to update producer '{}'", producer.getId(), e);
		}
	}

	private static PreparedStatement preparedStatementUpdate(Connection conn, Producer producer) throws SQLException {
		String sql = "UPDATE `anime_store`.`producer` SET `name` = ?  WHERE (`id` = ?);";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, producer.getName());
		ps.setInt(2, producer.getId());
		return ps;
	}

	public static List<Producer> findAll() {
		log.info("Finding all Producers");
		return findByName("");
//		String sql = "SELECT id, name FROM anime_store.producer;";
//		List<Producer> producers = new ArrayList<>();
//		try (Connection conn = ConnectionFactory.getConnection();
//				Statement stmt = conn.createStatement();
//				ResultSet rs = stmt.executeQuery(sql);) {
//			while (rs.next()) {
//				Producer producer = Producer.builder().id(rs.getInt("id")).name(rs.getString("name")).build();
//				producers.add(producer);
//			}
//		} catch (SQLException e) {
//			log.error("Error while trying to update producer", e);
//		}
//		return producers;
	}

	public static List<Producer> findByName(String name) {
		log.info("Finding Producers by name");
		String sql = "SELECT id, name FROM anime_store.producer WHERE name LIKE '%%%s%%';".formatted(name);
		List<Producer> producers = new ArrayList<>();
		try (Connection conn = ConnectionFactory.getConnection();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);) {
			while (rs.next()) {
				Producer producer = Producer.builder().id(rs.getInt("id")).name(rs.getString("name")).build();
				producers.add(producer);
			}
		} catch (SQLException e) {
			log.error("Error while trying to update producer", e);
		}
		return producers;
	}

	public static List<Producer> findByNamePreparedStatement(String name) {
		log.info("Finding Producers by name");
		List<Producer> producers = new ArrayList<>();
		try (Connection conn = ConnectionFactory.getConnection();
				PreparedStatement ps = preparedStatementFindByName(conn, name);
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

	public static List<Producer> findByNameCallableStatement(String name) {
		log.info("Finding Producers by name");
		List<Producer> producers = new ArrayList<>();
		try (Connection conn = ConnectionFactory.getConnection();
				CallableStatement cs = callableStatementFindByName(conn, name);
				ResultSet rs = cs.executeQuery();) {
			while (rs.next()) {
				Producer producer = Producer.builder().id(rs.getInt("id")).name(rs.getString("name")).build();
				producers.add(producer);
			}
		} catch (SQLException e) {
			log.error("Error while trying to update producer", e);
		}
		return producers;
	}

	private static CallableStatement callableStatementFindByName(Connection conn, String name) throws SQLException {
		String sql = "CALL `anime_store`.`sp_get_producer_by_name`(?);";
		CallableStatement cs = conn.prepareCall(sql);
		cs.setString(1, String.format("%%%s%%", name));
		return cs;
	}

	private static PreparedStatement preparedStatementFindByName(Connection conn, String name) throws SQLException {
		String sql = "SELECT id, name FROM anime_store.producer WHERE name LIKE ?;";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, String.format("%%%s%%", name));
		return ps;
	}

	public static void showProducerMetaData() {
		log.info("Showing Producer MetaData");
		String sql = "SELECT * FROM anime_store.producer";
		try (Connection conn = ConnectionFactory.getConnection();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);) {
			ResultSetMetaData rsMetaData = rs.getMetaData();
			int columnCount = rsMetaData.getColumnCount();
			log.info("Columns count '{}'", columnCount);
			for (int i = 1; i <= columnCount; i++) {
				log.info("Table name '{}'", rsMetaData.getTableName(i));
				log.info("Column name '{}'", rsMetaData.getColumnName(i));
				log.info("Column size '{}'", rsMetaData.getColumnDisplaySize(i));
				log.info("Column size '{}'", rsMetaData.getColumnTypeName(i));
			}
		} catch (SQLException e) {
			log.error("Error while trying to update producer", e);
		}
	}

	public static void showDriverMetaData() {
		log.info("Showing Driver MetaData");
		try (Connection conn = ConnectionFactory.getConnection();) {
			DatabaseMetaData dbMetaData = conn.getMetaData();
			if (dbMetaData.supportsResultSetType(ResultSet.TYPE_FORWARD_ONLY)) {
				log.info("Supports TYPE_FORWARD_ONLY");
				if (dbMetaData.supportsResultSetConcurrency(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE)) {
					log.info("And supports CONCUR_UPDATABLE");
				}
			}
			if (dbMetaData.supportsResultSetType(ResultSet.TYPE_SCROLL_INSENSITIVE)) {
				log.info("Supports TYPE_SCROLL_INSENSITIVE");
				if (dbMetaData.supportsResultSetConcurrency(ResultSet.TYPE_SCROLL_INSENSITIVE,
						ResultSet.CONCUR_UPDATABLE)) {
					log.info("And supports CONCUR_UPDATABLE");
				}
			}
			if (dbMetaData.supportsResultSetType(ResultSet.TYPE_SCROLL_SENSITIVE)) {
				log.info("Supports TYPE_SCROLL_SENSITIVE");
				if (dbMetaData.supportsResultSetConcurrency(ResultSet.TYPE_SCROLL_SENSITIVE,
						ResultSet.CONCUR_UPDATABLE)) {
					log.info("And supports CONCUR_UPDATABLE");
				}
			}
		} catch (SQLException e) {
			log.error("Error while trying to update producer", e);
		}
	}

	public static void showTypeScrollWorking() {
		String sql = "SELECT * FROM anime_store.producer";
		try (Connection conn = ConnectionFactory.getConnection();
				Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
				ResultSet rs = stmt.executeQuery(sql);) {
			log.info("Last row? '{}'", rs.last());
			log.info("Row number '{}'", rs.getRow());
			log.info(Producer.builder().id(rs.getInt("id")).name(rs.getString("name")).build());
			log.info("First row? '{}'", rs.first());
			log.info("Row number '{}'", rs.getRow());
			log.info(Producer.builder().id(rs.getInt("id")).name(rs.getString("name")).build());
			log.info("Row absolute? '{}'", rs.absolute(2));
			log.info("Row number '{}'", rs.getRow());
			log.info(Producer.builder().id(rs.getInt("id")).name(rs.getString("name")).build());
			log.info("Row relative? '{}'", rs.relative(-1));
			log.info("Row number '{}'", rs.getRow());
			log.info(Producer.builder().id(rs.getInt("id")).name(rs.getString("name")).build());
			log.info("Is last? '{}'", rs.isLast());
			log.info("Row number '{}'", rs.getRow());
			log.info("Is first? '{}'", rs.isFirst());
			log.info("Row number '{}'", rs.getRow());
			log.info("Last row? '{}'", rs.last());
			log.info("-------------------");
			rs.next();
			log.info("After last row? '{}'", rs.isAfterLast());
			while (rs.previous()) {
				log.info(Producer.builder().id(rs.getInt("id")).name(rs.getString("name")).build());
			}
		} catch (SQLException e) {
			log.error("Error while trying to update producer", e);
		}
	}

	public static List<Producer> findByNameAndUpdateToUpperCase(String name) {
		log.info("Finding Producers by name and update to upper case");
		String sql = "SELECT id, name FROM anime_store.producer WHERE name LIKE '%%%s%%';".formatted(name);
		List<Producer> producers = new ArrayList<>();
		try (Connection conn = ConnectionFactory.getConnection();
				Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
				ResultSet rs = stmt.executeQuery(sql);) {
			while (rs.next()) {
				rs.updateString("name", rs.getString("name").toUpperCase());
//				rs.cancelRowUpdates();
				rs.updateRow();
				Producer producer = Producer.builder().id(rs.getInt("id")).name(rs.getString("name")).build();
				producers.add(producer);
			}
		} catch (SQLException e) {
			log.error("Error while trying to update producer", e);
		}
		return producers;
	}

	public static List<Producer> findByNameAndInsertWhenNotFound(String name) {
		log.info("Finding Producers by name or insert when not found");
		String sql = "SELECT id, name FROM anime_store.producer WHERE name LIKE '%%%s%%';".formatted(name);
		List<Producer> producers = new ArrayList<>();
		try (Connection conn = ConnectionFactory.getConnection();
				Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
				ResultSet rs = stmt.executeQuery(sql);) {

			if (rs.next()) {
				return producers;
			}

			insertNewProducer(name, rs);

			producers.add(getProducer(rs));

		} catch (SQLException e) {
			log.error("Error while trying to update producer", e);
		}
		return producers;
	}

	public static void findByNameAndDelete(String name) {
		log.info("Finding Producers by name and delete");
		String sql = "SELECT id, name FROM anime_store.producer WHERE name LIKE '%%%s%%';".formatted(name);
		try (Connection conn = ConnectionFactory.getConnection();
				Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
				ResultSet rs = stmt.executeQuery(sql);) {
			while (rs.next()) {
				log.info("Deleting '{}'", rs.getString("name"));
				rs.deleteRow();
			}
		} catch (SQLException e) {
			log.error("Error while trying to update producer", e);
		}
	}

	private static void insertNewProducer(String name, ResultSet rs) throws SQLException {
		rs.moveToInsertRow();
		rs.updateString("name", name);
		rs.insertRow();
	}

	private static Producer getProducer(ResultSet rs) throws SQLException {
		rs.beforeFirst();
		rs.next();
		return Producer.builder().id(rs.getInt("id")).name(rs.getString("name")).build();
	}

}