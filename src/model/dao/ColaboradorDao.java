package model.dao;

import model.entities.Colaborador;



import java.util.List;


public interface ColaboradorDao {

    void insert(Colaborador obj);
    void update(Colaborador obj);
    Colaborador findById(Integer id);
    void deleteById(Integer id);
    List<Colaborador> findAll();

}