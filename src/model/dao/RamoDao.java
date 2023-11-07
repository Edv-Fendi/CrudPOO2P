package model.dao;

import java.util.List;

import model.entities.Ramo;

public interface RamoDao {
    void insert(Ramo obj);
    void update(Ramo obj);
    Ramo findById(Integer id);
    void deleteById(Integer id);
    List<Ramo> findAll();
}