package model.dao;

import model.dao.impl.BilheteDaoJDBC;
import model.dao.impl.LinhaDaoJDBC;
import model.dao.impl.PassageiroDaoJDBC;
import vavatur.banco.Fabrica;

public class DaoFactory {

	public static BilheteDao createBilheteDao() {
		return new BilheteDaoJDBC(Fabrica.conectar());
	}
	
	public static LinhaDao createLinhaDao() {
		return new LinhaDaoJDBC(Fabrica.conectar());
	}
	
	public static PassageiroDao createPassageiroDao() {
		return new PassageiroDaoJDBC(Fabrica.conectar());
	}
}
