package model.dao.impl;

import db.DB;
import db.DbException;
import db.DbIntegrityException;
import model.dao.EnderecoDao;
import model.entities.Endereco;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EnderecoDaoJDBC implements EnderecoDao {

    private Connection conn;

    public EnderecoDaoJDBC(Connection conn) {
        this.conn = conn;
    }

    @Override
    public Endereco findById(Integer id) {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement(
                    "SELECT * FROM endereco WHERE Id_Endereco = ?");
            st.setInt(1, id);
            rs = st.executeQuery();
            if (rs.next()) {
                Endereco obj = new Endereco();
                obj.setId_Endereco(rs.getInt("Id_Endereco"));
                obj.setCidade(rs.getString("Cidade"));
                obj.setNumero(rs.getString("Numero"));
                obj.setEstado((rs.getString("Estado")));
                obj.setBairro(rs.getString("Bairro"));
                obj.setCep(rs.getString("CEP"));
                obj.setComplemento(rs.getString("complemento"));
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
    public List<Endereco> findAll() {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement(
                    "SELECT * FROM endereco ORDER BY Id_Endereco");
            rs = st.executeQuery();

            List<Endereco> list = new ArrayList<>();

            while (rs.next()) {
                Endereco obj = new Endereco();
                obj.setId_Endereco(rs.getInt("Id_Endereco"));
                obj.setCidade(rs.getString("Cidade"));
                obj.setNumero(rs.getString("Numero"));
                obj.setEstado((rs.getString("Estado")));
                obj.setBairro(rs.getString("Bairro"));
                obj.setCep(rs.getString("CEP"));
                obj.setComplemento(rs.getString("complemento"));

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
    public void insert(Endereco obj) {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement(
                    "INSERT INTO endereco " +
                            "(Cidade,Numero,Estado,Bairro,CEP,Complemento) " +
                            "VALUES " +
                            "(?,?,?,?,?,?)",
                    Statement.RETURN_GENERATED_KEYS);

            st.setString(1, obj.getCidade());
            st.setString(2, obj.getNumero());
            st.setString(3, obj.getEstado());
            st.setString(4, obj.getBairro());
            st.setString(5, obj.getCep());
            st.setString(6, obj.getComplemento());

            int rowsAffected = st.executeUpdate();

            if (rowsAffected > 0) {
                ResultSet rs = st.getGeneratedKeys();
                if (rs.next()) {
                    int id = rs.getInt(1);
                    obj.setId_Endereco(id);
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
    public void update(Endereco obj) {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement(
                    "UPDATE endereco " +
                            "SET Cidade = ?, " +
                            "Numero = ?, " +
                            "Estado = ?," +
                            "Bairro = ?," +
                            "CEP = ?," +
                            "Complemento = ?," +
                            "WHERE Id_Endereco = ?");

            st.setString(1, obj.getCidade());
            st.setString(2, obj.getNumero());
            st.setString(3, obj.getEstado());
            st.setString(4, obj.getBairro());
            st.setString(5, obj.getCep());
            st.setString(6, obj.getComplemento());
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
                    "DELETE FROM endereco WHERE Id_Endereco = ?");

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
