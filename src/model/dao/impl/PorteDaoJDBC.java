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
import model.dao.PorteDao;
import model.entities.Porte;

public class PorteDaoJDBC implements PorteDao {
    private Connection conn;

    public PorteDaoJDBC (Connection conn) {
        this.conn = conn;
    }

    @Override
    public Porte findById(Integer id) {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement(
                    "SELECT * FROM porte WHERE id_Porte = ?");
            st.setInt(1, id);
            rs = st.executeQuery();
            if (rs.next()) {
                Porte obj = new Porte();
                obj.setId_Porte(rs.getInt("id_Porte"));
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
    public List<Porte> findAll() {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement(
                    "SELECT * FROM porte ORDER BY nome");
            rs = st.executeQuery();

            List<Porte> list = new ArrayList<>();

            while (rs.next()) {
                Porte obj = new Porte();
                obj.setId_Porte(rs.getInt("id_Porte"));
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
    public void insert(Porte obj) {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement(
                    "INSERT INTO porte " +
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
                    obj.setId_Porte(id);
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
    public void update(Porte obj) {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement(
                    "UPDATE porte " +
                            "SET nome = ? " +
                            "WHERE id_Porte = ?");

            st.setString(1, obj.getNome());
            st.setInt(2, obj.getId_Porte());

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
                    "DELETE FROM porte WHERE id_Porte = ?");

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

