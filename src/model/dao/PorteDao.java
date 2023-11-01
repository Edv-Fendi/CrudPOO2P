package model.dao;

import java.util.List;

import model.entities.Porte;


public interface PorteDao {

    void insert(Porte obj);
    void update(Porte obj);
    Porte findById(Integer id);
    void deleteById(Integer id);
    List<Porte> findAll();


}