package model.dao;

import db.DB;
import model.dao.impl.PorteDaoJDBC;

public class DaoFactory {

	public static  PorteDao createPorteDao() {
		return new PorteDaoJDBC(DB.getConnection());
	}
}
