package ua.osadchii.dao;

import ua.osadchii.model.Toy;

import java.util.List;

public interface ToyDAO {

    public void addToy(Toy toy);

    public List<Toy> getAllToys();

    public void deleteToy(Integer toyId);

    public Toy updateToy(Toy toy);

    public Toy getToy(int toyid);

    public Toy getToy(String name);
}
