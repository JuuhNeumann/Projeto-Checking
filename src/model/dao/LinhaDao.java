package model.dao;

import java.sql.SQLException;
import java.text.ParseException;

import model.entities.Linha;

public interface LinhaDao {

	void insert(Linha id) throws ParseException;
	void update(Linha id);
	void deleteById(int id);
	Linha findByIdLinha(int id) throws SQLException;
}
