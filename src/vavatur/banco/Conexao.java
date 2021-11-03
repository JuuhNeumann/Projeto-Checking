package vavatur.banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	
	private String url = "jdbc:postgresql://134.209.243.185:5432/vavatur";
	private String usuario = "vavatur";
	private String senha = "gGgLqu";
	private Connection conexao = null;
	
	// Método que faz a conexão com o banco de dados
	public Connection conectar() {
		try {
            conexao = DriverManager.getConnection(url, usuario, senha);

            System.out.println("CONEXÃO FEITA COM SUCESSO!!");

        } catch (SQLException e) {
            System.out.println("FALHA AO SE CONECTAR COM O BANCO DE DADOS");
            System.out.println(e);
        }
		return conexao;	
	}

}
