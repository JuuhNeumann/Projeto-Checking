package application;

import java.sql.Connection;
import java.sql.SQLException;

import model.dao.BilheteDao;
import model.dao.DaoFactory;
import model.dao.LinhaDao;
import model.dao.PassageiroDao;
import vavatur.banco.BancoQuery;
import vavatur.banco.Fabrica;
import vavatur.visual.RealizarChecking;

public class Principal {
	public static void main(String[] args) throws SQLException  {		

		// Criações
		BilheteDao bilheteDao = DaoFactory.createBilheteDao();
		LinhaDao linhaDao = DaoFactory.createLinhaDao();
		PassageiroDao passageiroDao = DaoFactory.createPassageiroDao();
	

		// Conectando com o banco
		Fabrica fab = new Fabrica();
		Connection con = fab.conectar();
		BancoQuery banco = new BancoQuery(con);
		

		// Chamada da primeira janela
		RealizarChecking rc = new RealizarChecking(banco);
		rc.exibir();

	}
}
