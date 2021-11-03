package model.dao;

import java.sql.SQLException;

import model.entities.Bilhete;

public interface BilheteDao {

	void insert(Bilhete codigo);
	void update(Bilhete codigo);
	void deleteByCodigo(String codigo);
	Bilhete findByCodigoBilhete(String codigo) throws SQLException;
	
}
