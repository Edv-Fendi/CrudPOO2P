package model.dao.impl;

import db.DB;
import db.DbException;
import db.DbIntegrityException;
import model.dao.EmpresaDao;
import model.entities.Empresa;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmpresaDaoJDBC implements EmpresaDao {

    private Connection conn;

    public EmpresaDaoJDBC(Connection conn) {
        this.conn = conn;
    }

    @Override
    public Empresa findById(Integer id) {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement(
                    "SELECT * FROM Empresa WHERE id_empresa = ?");
            st.setInt(1, id);
            rs = st.executeQuery();
            if (rs.next()) {
                Empresa obj = new Empresa();
                obj.setId_Empresa(rs.getInt("id_empresa"));
                obj.setEmail(rs.getString("email"));
                obj.setRazao_social(rs.getString("razao_socail"));
                obj.setNome_fantasia((rs.getString("nome_fantasia")));
                obj.setCnpj(rs.getString("cnpj"));
                obj.setQtd_funcionarios(rs.getInt("quantidade_funcionario"));
                obj.setTelefone(rs.getString("telefone"));
                obj.setPontuacao(rs.getInt("pontuacao"));
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
    public List<Empresa> findAll() {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement(
                    "SELECT * FROM Empresa ORDER BY id_empresa");
            rs = st.executeQuery();

            List<Empresa> list = new ArrayList<>();

            while (rs.next()) {
                Empresa obj = new Empresa();
                obj.setId_Empresa(rs.getInt("id_empresa"));
                obj.setEmail(rs.getString("email"));
                obj.setRazao_social(rs.getString("razao_socail"));
                obj.setNome_fantasia((rs.getString("nome_fantasia")));
                obj.setCnpj(rs.getString("cnpj"));
                obj.setQtd_funcionarios(rs.getInt("quantidade_funcionario"));
                obj.setTelefone(rs.getString("telefone"));
                obj.setPontuacao(rs.getInt("pontuacao"));


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
    public void insert(Empresa obj) {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement(
                    "INSERT INTO Empresa " +
                            "(email,razao_socail,nome_fantasia,cnpj,quantidade_funcionario,telefone,pontuacao) " +
                            "VALUES " +
                            "(?,?,?,?,?,?,?)",
                    Statement.RETURN_GENERATED_KEYS);

            st.setString(1, obj.getEmail());
            st.setString(2, obj.getRazao_social());
            st.setString(3, obj.getNome_fantasia());
            st.setString(4, obj.getCnpj());
            st.setInt(5, obj.getQtd_funcionarios());
            st.setString(6, obj.getTelefone());
            st.setInt(7, obj.getPontuacao());


            int rowsAffected = st.executeUpdate();

            if (rowsAffected > 0) {
                ResultSet rs = st.getGeneratedKeys();
                if (rs.next()) {
                    int id = rs.getInt(1);
                    obj.setId_Empresa(id);
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
    public void update(Empresa obj) {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement(
                    "UPDATE Empresa " +
                            "SET email = ?, " +
                            "razao_socail = ?, " +
                            "nome_fantasia = ?," +
                            "cnpj = ?," +
                            "quantidade_funcionario = ?," +
                            "telefone = ?," +
                            "pontuacao = ?," +
                            "WHERE id_empresa = ?");

            st.setString(1, obj.getEmail());
            st.setString(2, obj.getRazao_social());
            st.setString(3, obj.getNome_fantasia());
            st.setString(4, obj.getCnpj());
            st.setInt(5, obj.getQtd_funcionarios());
            st.setString(6, obj.getTelefone());
            st.setInt(7, obj.getPontuacao());
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
                    "DELETE FROM Empresa WHERE id_empresa = ?");

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