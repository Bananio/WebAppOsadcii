package ua.osadchii.service;

import ua.osadchii.model.Pizza;

import java.util.List;

public interface PizzaService {

    public void addPizza(Pizza pizza);

    public List<Pizza> getAllPizzas();

    public void deletePizza(Integer pizzaId);

    public Pizza getPizza(int pizzaid);
    public  Pizza getPizza(String name);

    public Pizza updatePizza(Pizza pizza);
}
