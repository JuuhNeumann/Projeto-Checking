package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.dao.LinhaDao;
import model.entities.Linha;

public class LinhaDaoJDBC implements LinhaDao {

	private Connection con;

	public LinhaDaoJDBC(Connection con) {
		this.con = con;
	}
	
	// Método que faz inserção de uma linha no banco
	@Override
	public void insert(Linha id) {
		PreparedStatement st = null;
		try {
			st = con.prepareStatement(

					"INSERT INTO linha " + "(id, origem, destino, horam_embarque, hora_partida) " + "VALUES " + "(?, ?, ?, ?, ?)");

			st.setInt(1, id.getId());
			st.setString(2, id.getOrigem());
			st.setString(3, id.getDestino());
			st.setString(4, id.getHoraEmbarque());
			st.setString(5, id.getHoraPartida());

			int rowsAffected = st.executeUpdate();

			if (rowsAffected > 0) {
				ResultSet rs = st.getGeneratedKeys();

				if (rs.next()) {
					int codigo = rs.getInt(3);
					id.setId(codigo);
				}
				rs.close();

			} else {
				throw new SQLException();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	// Método que faz update de uma linha no banco
	@Override
	public void update(Linha id) {
		PreparedStatement st = null;

		try {
			st = con.prepareStatement(

					"UPDATE linha " + "SET origem = ?, destino = ?, hora_embarque = ?, hora_partida = ? " + "WHERE id = ? ");

			st.setString(1, id.getOrigem());
			st.setString(2, id.getDestino());
			st.setString(3, id.getHoraEmbarque());
			st.setString(4, id.getHoraPartida());
			st.setInt(5, id.getId());

			st.getResultSet();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	// Método que deleta através de um id de uma linha no banco
	@Override
	public void deleteById(int id) {
		PreparedStatement st = null;

		try {
			st = con.prepareStatement("DELETE FROM linha WHERE id = ?");

			st.setInt(1, id);

			st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	// Método que procura através de um id de uma linha no banco
	@Override
	public Linha findByIdLinha(int id) throws SQLException {
		PreparedStatement st = con.prepareStatement("SELECT id FROM linha WHERE id = ?");
		st.setInt(1, id);
		st.execute();

		try (ResultSet rs = st.getResultSet()) {
			if (rs.next()) {
				Linha l = new Linha();
				l.setId(rs.getInt(1));
				return l;
			}
		}
		throw new RuntimeException("Linha com id " + id + " não encontrado!");
	}

}
