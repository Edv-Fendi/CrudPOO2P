package model.dao.impl;

import db.DB;
import db.DbException;
import db.DbIntegrityException;
import model.dao.ColaboradorDao;
import model.entities.Colaborador;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ColaboradorDaoJDBC implements ColaboradorDao {

    private Connection conn;

    public ColaboradorDaoJDBC(Connection conn) {
        this.conn = conn;
    }

    @Override
    public Colaborador findById(Integer id) {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement(
                    "SELECT * FROM Colaborador WHERE Id_Colaborador = ?");
            st.setInt(1, id);
            rs = st.executeQuery();
            if (rs.next()) {
                Colaborador obj = new Colaborador();
                obj.setId_Colaborador(rs.getInt("Id_Colaborador"));
                obj.setNome(rs.getString("Nome"));
                obj.setTelefone(rs.getString("Telefone"));
                obj.setEmail(rs.getString("Email"));
                obj.setFuncao(rs.getString("Funcao"));
                obj.setSetor(rs.getString("Setor"));
                obj.setAdmin(rs.getBoolean("is_Admin"));
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
    public List<Colaborador> findAll() {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement(
                    "SELECT * FROM Colaborador ORDER BY Id_Colaborador");
            rs = st.executeQuery();

            List<Colaborador> list = new ArrayList<>();

            while (rs.next()) {
                Colaborador obj = new Colaborador();
                obj.setId_Colaborador(rs.getInt("Id_Colaborador"));
                obj.setNome(rs.getString("Nome"));
                obj.setTelefone(rs.getString("Telefone"));
                obj.setEmail(rs.getString("Email"));
                obj.setFuncao(rs.getString("Funcao"));
                obj.setSetor(rs.getString("Setor"));
                obj.setAdmin(rs.getBoolean("is_Admin"));
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
    public void insert(Colaborador obj) {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement(
                    "INSERT INTO Colaborador " +
                            "(Nome, Telefone, Email, Funcao, Setor, is_Admin) " +
                            "VALUES " +
                            "(?, ?, ?, ?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS);

            st.setString(1, obj.getNome()); // Defina o campo Nome
            st.setString(2, obj.getTelefone());
            st.setString(3, obj.getEmail());
            st.setString(4, obj.getFuncao());
            st.setString(5, obj.getSetor());
            st.setBoolean(6, obj.isAdmin());

            int rowsAffected = st.executeUpdate();

            if (rowsAffected > 0) {
                ResultSet rs = st.getGeneratedKeys();
                if (rs.next()) {
                    int id = rs.getInt(1);
                    obj.setId_Colaborador(id);
                }
            } else {
                throw new DbException("Erro inesperado! Nenhuma linha afetada.");
            }
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(st);
        }
    }


    @Override
    public void update(Colaborador obj) {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement(
                    "UPDATE Colaborador " +
                            "SET Nome = ?, " +
                            "Telefone = ?, " +
                            "Email = ?, " +
                            "Funcao = ?, " +
                            "Setor = ?, " +
                            "is_Admin = ? " + // Removed the comma before WHERE
                            "WHERE Id_Colaborador = ?");

            st.setString(1, obj.getNome());
            st.setString(2, obj.getTelefone());
            st.setString(3, obj.getEmail());
            st.setString(4, obj.getFuncao());
            st.setString(5, obj.getSetor());
            st.setBoolean(6, obj.isAdmin());
            st.setInt(7, obj.getId_Colaborador());

            int rowsAffected = st.executeUpdate();
            if (rowsAffected == 0) {
                throw new DbException("No rows updated. Please check if the ID is correct.");
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
    public void deleteById(Integer id) {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement(
                    "DELETE FROM Colaborador WHERE Id_Colaborador = ?");

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
