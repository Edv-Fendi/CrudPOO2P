package model.dao;

import db.DB;
import model.dao.impl.EnderecoDaoJDBC;
import model.dao.impl.PorteDaoJDBC;

public class DaoFactory {

	public static  PorteDao createPorteDao() {
		return new PorteDaoJDBC(DB.getConnection());
	}

	public static  EnderecoDao createEnderecoDao() {
		return new EnderecoDaoJDBC(DB.getConnection());
	}
}
