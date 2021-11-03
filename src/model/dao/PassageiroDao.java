package model.dao;

import java.sql.SQLException;

import model.entities.Passageiro;

public interface PassageiroDao {

	void insert(Passageiro id);
	void update(Passageiro id);
	void deleteById(int id);
	Passageiro findByIdPassageiro(int id) throws SQLException;
}
