package vavatur.banco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import model.entities.Bilhete;
import model.entities.Linha;
import model.entities.Passageiro;

public class BancoQuery {

	private Connection con = null;
	private PreparedStatement st = null;
	private ResultSet rs = null;

	public BancoQuery(Connection con) {
		this.con = con;
	}

	// Método para buscar bilhete no banco
	public Bilhete buscaBilhete(String codigo) {

		try {
			st = con.prepareStatement("SELECT * FROM bilhete WHERE codigo = ?");
			st.setString(1, codigo);
			st.execute();
			rs = st.getResultSet();

			if (rs.next()) {
				String codiguin = rs.getString("codigo");
				int assentin = rs.getInt("assento");
				int id_p = rs.getInt("id_passageiro");
				int id_l = rs.getInt("id_linha");
				Passageiro passageirinho = buscaPassageiro(id_p);
				Linha linhazinha = buscaLinha(id_l);
				Bilhete bilhetin = new Bilhete(codiguin, assentin, passageirinho, linhazinha);
				return bilhetin;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Bilhete não encontrado!");
		}
		return null;
	}

	// Método para buscar passageiro no banco
	public Passageiro buscaPassageiro(int id_p) {
		try {
			st = con.prepareStatement("SELECT * FROM passageiro WHERE id = ?");
			st.setInt(1, id_p);
			st.execute();
			rs = st.getResultSet();

			if (rs.next()) {
				String nomezin = rs.getString("nome");
				String cpfzin = rs.getString("cpf");
				String telefonezin = rs.getString("telefone_contato");
				String emailzin = rs.getString("email");
				Passageiro passageirin = new Passageiro(id_p, nomezin, cpfzin, telefonezin, emailzin);
				return passageirin;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Passageiro não encontrado!");
		}
		return null;
	}

	// Método para buscar linha no banco
	public Linha buscaLinha(int id_l) {
		try {
			st = con.prepareStatement("SELECT * FROM linha WHERE id = ?");
			st.setInt(1, id_l);
			st.execute();
			rs = st.getResultSet();

			if (rs.next()) {
				String origemzinha = rs.getString("origem");
				String destininho = rs.getString("destino");
				String hr_embarquezinho = rs.getString("hora_embarque");
				String hr_partidinha = rs.getString("hora_partida");
				Linha linhazinha = new Linha(id_l, origemzinha, destininho, hr_embarquezinho, hr_partidinha);
				return linhazinha;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Linha não encontrada!");
		}
		return null;
	}

	// Método para atualizar dados do passageiro no banco
	public void attDados(Bilhete b) {
		try {
			st = con.prepareStatement("UPDATE passageiro SET nome = ? WHERE id = ?");
			st.setString(1, b.getPassageiro().getNome());
			st.setInt(2, b.getPassageiro().getId());
			st.executeUpdate();

			st = con.prepareStatement("UPDATE passageiro SET email = ? WHERE id = ?");
			st.setString(1, b.getPassageiro().getEmail());
			st.setInt(2, b.getPassageiro().getId());
			st.executeUpdate();

			st = con.prepareStatement("UPDATE passageiro SET cpf = ? WHERE id = ?");
			st.setString(1, b.getPassageiro().getCpf());
			st.setInt(2, b.getPassageiro().getId());
			st.executeUpdate();

			st = con.prepareStatement("UPDATE passageiro SET telefone_contato = ? WHERE id = ?");
			st.setString(1, b.getPassageiro().getTelefone());
			st.setInt(2, b.getPassageiro().getId());
			st.executeUpdate();

			st = con.prepareStatement("UPDATE passageiro SET email = ? WHERE id = ?");
			st.setString(1, b.getPassageiro().getEmail());
			st.setInt(2, b.getPassageiro().getId());
			st.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Update não foi realizado!");
		}
	}

	// Método para verificar se o assento já está ocupado por um passageiro no banco
	public boolean verificaAssento(Bilhete bi) {
		try {
			st = con.prepareStatement("SELECT assento FROM bilhete where id_passageiro = ?");
			st.setInt(1, bi.getPassageiro().getId());
			st.execute();
			rs = st.getResultSet();

			if (rs.next()) {

				return true;

			} else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Nenhum assento encontrado!");
		}
		return false;
	}

	// Método para buscar o nome do passageiro no banco
	public Passageiro buscaNomePassageiro(int id_p) {
		try {
			st = con.prepareStatement("SELECT nome FROM passageiro WHERE id = ?");
			st.setInt(1, id_p);
			st.execute();
			rs = st.getResultSet();

			while (rs.next()) {
				String nome = rs.getString("nome");
				Passageiro p = new Passageiro(nome);
				return p;

			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Nome não encontrado!");
		}
		return null;

	}
	
	// Método que pega o id do passageiro
	public Integer getIdPassageiro(String nome) {
		try {
			st = con.prepareStatement("SELECT id FROM passageiro JOIN bilhete ON passageiro.id =  bilhete.id_passageiro WHERE bilhete.codigo = '"+nome+"'");
			st.execute();
			rs = st.getResultSet();
			
			while (rs.next()) {
				Integer nomePassageiro = rs.getInt(1);
				return nomePassageiro;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Id do passageiro não encontrado!");
		}
		return null;
	}
	
	// Método que pega o id da linha
	public Integer getIdLinha(String nome) {
		try {
			st = con.prepareStatement("SELECT id FROM linha JOIN bilhete ON linha.id =  bilhete.id_linha WHERE bilhete.codigo = '"+nome+"'");
			st.execute();
			rs = st.getResultSet();
			
			while (rs.next()) {
				Integer nomePassageiro = rs.getInt(1);
				return nomePassageiro;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Id da linha não encontrado!");
		}
		return null;
	}
	
	// Método que pega uma lista de assentos ocupados do banco
	public List<Integer> AssentosOcupados(Bilhete bi) {
		List<Integer> assentoMarcado = new ArrayList<>();
		try {
			
			Integer i = this.getIdLinha(bi.getCodigo());
			st = con.prepareStatement("SELECT assento FROM bilhete WHERE assento <=30 AND ? = id_linha");
			st.setInt(1, i);
			st.execute();
			rs = st.getResultSet();

			while (rs.next()) {
				assentoMarcado.add(rs.getInt("assento"));
			}
			return assentoMarcado;
		
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,"ERROR :" + e.getSQLState(), "DATABASE ERROR: ", JOptionPane.ERROR_MESSAGE);
		}
		return assentoMarcado;
	}
	
	// Método que marca o assento
	public void marcarAssento(Integer i, String j) {
		@SuppressWarnings("unused")
		Integer idP = getIdPassageiro(j);
		@SuppressWarnings("unused")
		Integer idL = getIdLinha(j);
		LocalDateTime localTime = LocalDateTime.now();
		try {
			st = con.prepareStatement("UPDATE bilhete SET assento = '"+i+"', assento_marcado_em = '"+localTime+"' WHERE bilhete.codigo = '"+j+"'");
			st.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Não foi possível marcar este assento!");
		}
	}

	// Método que apaga um assento
	public void apagarAssento(Bilhete bi) {
		try {
			st = con.prepareStatement("UPDATE bilhete SET assento = null WHERE codigo = ?");
			st.setString(1, bi.getCodigo());
			st.executeUpdate();
			
		}
		catch(SQLException e) {
			e.printStackTrace();
			System.out.println("Não foi possível apagar este assento!");
		}
	}

}
