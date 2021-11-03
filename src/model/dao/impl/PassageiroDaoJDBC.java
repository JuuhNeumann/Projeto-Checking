package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.dao.PassageiroDao;
import model.entities.Passageiro;

public class PassageiroDaoJDBC implements PassageiroDao {

	private Connection con;

	public PassageiroDaoJDBC(Connection con) {
		this.con = con;
	}
	

	// Método que insere um passageiro no banco
	@Override
	public void insert(Passageiro id) {
		PreparedStatement st = null;
		try {
			st = con.prepareStatement(

					"INSERT INTO passageiro " + "(id, nome, cpf, telefone_contato, email) " + "VALUES "
							+ "(?, ?, ?, ?, ?)");

			st.setInt(1, id.getId());
			st.setString(2, id.getNome());
			st.setString(3, id.getCpf());
			st.setString(4, id.getTelefone());
			st.setString(5, id.getEmail());

			int rowsAffected = st.executeUpdate();

			if (rowsAffected > 0) {
				ResultSet rs = st.getGeneratedKeys();

				if (rs.next()) {
					int codigo = rs.getInt(70);
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
	

	// Método que faz update de um passageiro no banco
	@Override
	public void update(Passageiro id) {
		PreparedStatement st = null;

		try {
			st = con.prepareStatement(

					"UPDATE passageiro " + "SET nome = ?, cpf = ?, telefone_contato = ?, email = ?" + "WHERE codigo = ? ");

			st.setString(1, id.getNome());
			st.setString(2, id.getCpf());
			st.setString(3, id.getTelefone());
			st.setString(4, id.getEmail());
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
	

	// Método que deleta através de um id de um passageiro no banco
	@Override
	public void deleteById(int id) {
		PreparedStatement st = null;

		try {
			st = con.prepareStatement("DELETE FROM passageiro WHERE id = ?");

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
	
	// Método que procura através de um id de um passageiro no banco
	@Override
	public Passageiro findByIdPassageiro(int id) throws SQLException {
		PreparedStatement st = con.prepareStatement("SELECT id FROM passageiro WHERE id = ?");
		st.setInt(1, id);
		st.execute();

		try (ResultSet rs = st.getResultSet()) {
			if (rs.next()) {
				Passageiro p = new Passageiro();
				p.setId(rs.getInt(1));
				return p;
			}
		}
		throw new RuntimeException("Passageiro com id " + id + " não encontrado!");
	}

}
