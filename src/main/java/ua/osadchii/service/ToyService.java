package ua.osadchii.service;

import ua.osadchii.model.Toy;

import java.util.List;

public interface ToyService {

    public void addToy(Toy toy);

    public List<Toy> getAllToys();

    public void deleteToy(Integer toyId);

    public Toy getToy(int toyid);
    public  Toy getToy(String name);

    public Toy updateToy(Toy toy);
}
