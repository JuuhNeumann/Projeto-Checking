package vavatur.banco;

import java.sql.Connection;

public class Fabrica {

	// Método que intermedia a conexão com o banco
	public static Connection conectar() {
		Conexao banco = new Conexao();
		Connection con = banco.conectar();
		return con;
	}

}
