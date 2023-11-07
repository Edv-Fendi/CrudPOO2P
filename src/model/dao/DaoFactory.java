package model.dao;

import db.DB;
import model.dao.impl.*;

public class DaoFactory {

	public static  PorteDao createPorteDao() {return new PorteDaoJDBC(DB.getConnection());
	}

	public static  EnderecoDao createEnderecoDao() {return new EnderecoDaoJDBC(DB.getConnection());
	}

	public static ColaboradorDao createColaboradorDao() {return new ColaboradorDaoJDBC(DB.getConnection());
	}

	public static EmpresaDao createEmpresaDao(){return new EmpresaDaoJDBC(DB.getConnection());}

	public static  RamoDao createRamoDao() {return new RamoDaoJDBC(DB.getConnection());
	}
}
