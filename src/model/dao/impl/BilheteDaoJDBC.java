package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.dao.BilheteDao;
import model.entities.Bilhete;

public class BilheteDaoJDBC implements BilheteDao {

	private Connection con;

	public BilheteDaoJDBC(Connection con) {
		this.con = con;
	}

	// M�todo que faz inser��o de um bilhete no banco
	@Override
	public void insert(Bilhete codigo) {
		PreparedStatement st = null;
		try {
			st = con.prepareStatement(

					"INSERT INTO bilhete " + "(codigo, assento, id_passageiro, id_linha, assento_marcado_em) " + "VALUES "
							+ "(?, ?, ?, ?)");

			st.setString(1, codigo.getCodigo());
			st.setInt(2, codigo.getAssento());
			st.setInt(3, codigo.getPassageiro().getId());
			st.setInt(4, codigo.getLinha().getId());
			st.setString(5, codigo.getHoraMarcacaoAssento());

			int rowsAffected = st.executeUpdate();

			if (rowsAffected > 0) {
				ResultSet rs = st.getGeneratedKeys();

				if (rs.next()) {
					String id = rs.getString("BAFEEX");
					codigo.setCodigo(id);
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


	// M�todo que faz o update de um bilhete no banco
	@Override
	public void update(Bilhete codigo) {
		PreparedStatement st = null;

		try {
			st = con.prepareStatement(

					"UPDATE bilhete " + "SET assento = ?, id_passageiro = ?, id_linha = ? " + "WHERE codigo = ? ");

			st.setInt(1, codigo.getAssento());
			st.setInt(2, codigo.getPassageiro().getId());
			st.setInt(3, codigo.getLinha().getId());
			st.setString(4, codigo.getCodigo());

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

	// M�todo que deleta atrav�s do codigo de um bilhete no banco
	@Override
	public void deleteByCodigo(String codigo) {
		PreparedStatement st = null;

		try {
			st = con.prepareStatement("DELETE FROM bilhete WHERE codigo = ?");

			st.setString(1, codigo);

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

	// M�todo que procura atrav�s do c�digo de um bilhete no banco
	@Override
	public Bilhete findByCodigoBilhete(String codigo) throws SQLException {
		PreparedStatement st = con.prepareStatement("SELECT codigo FROM bilhete WHERE codigo = ?");
		st.setString(1, codigo);
		st.execute();

		try (ResultSet rs = st.getResultSet()) {
			if (rs.next()) {
				Bilhete b = new Bilhete();
				b.setCodigo(rs.getString(1));
				return b;
			}
		}
		throw new RuntimeException("Bilhete com c�digo " + codigo + " n�o encontrado!");
	}

}
