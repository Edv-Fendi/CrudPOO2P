package model.dao.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.DB;
import db.DbException;
import db.DbIntegrityException;
import model.dao.RamoDao;
import model.entities.Ramo;

public class RamoDaoJDBC implements RamoDao {
    private Connection conn;

    public RamoDaoJDBC (Connection conn) {
        this.conn = conn;
    }

    @Override
    public Ramo findById(Integer id) {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement(
                    "SELECT * FROM porte WHERE id_Ramo = ?");
            st.setInt(1, id);
            rs = st.executeQuery();
            if (rs.next()) {
                Ramo obj = new Ramo();
                obj.setId_Ramo(rs.getInt("id_Ramo"));
                obj.setNome(rs.getString("nome"));
                return obj;
            }
            return null;
        }
        catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
        finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }
    }

    @Override
    public List<Ramo> findAll() {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement(
                    "SELECT * FROM ramo ");
            rs = st.executeQuery();

            List<Ramo> list = new ArrayList<>();

            while (rs.next()) {
                Ramo obj = new Ramo();
                obj.setId_Ramo(rs.getInt("id_Ramo"));
                obj.setNome(rs.getString("nome"));
                list.add(obj);
            }
            return list;
        }
        catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
        finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }
    }

    @Override
    public void insert(Ramo obj) {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement(
                    "INSERT INTO ramo " +
                            "(nome) " +
                            "VALUES " +
                            "(?)",
                    Statement.RETURN_GENERATED_KEYS);

            st.setString(1, obj.getNome());

            int rowsAffected = st.executeUpdate();

            if (rowsAffected > 0) {
                ResultSet rs = st.getGeneratedKeys();
                if (rs.next()) {
                    int id = rs.getInt(1);
                    obj.setId_Ramo(id);
                }
            }
            else {
                throw new DbException("Unexpected error! No rows affected!");
            }
        }
        catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
        finally {
            DB.closeStatement(st);
        }
    }

    @Override
    public void update(Ramo obj) {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement(
                    "UPDATE ramo " +
                            "SET nome = ? " +
                            "WHERE `id_Ramo` = ?");

            st.setString(1, obj.getNome());
            st.setInt(2, obj.getId_Ramo());

            st.executeUpdate();
        }
        catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
        finally {
            DB.closeStatement(st);
        }
    }

    @Override
    public void deleteById(Integer id) {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement(
                    "DELETE FROM porte WHERE id_Ramo = ?");

            st.setInt(1, id);

            st.executeUpdate();
        }
        catch (SQLException e) {
            throw new DbIntegrityException(e.getMessage());
        }
        finally {
            DB.closeStatement(st);
        }
    }
}

