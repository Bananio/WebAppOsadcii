package ua.osadchii.dao;

import ua.osadchii.model.Pizza;

import java.util.List;

public interface PizzaDAO {

    public void addPizza(Pizza pizza);

    public List<Pizza> getAllPizzas();

    public void deletePizza(Integer pizzaId);

    public Pizza updatePizza(Pizza pizza);

    public Pizza getPizza(int pizzaid);

    public Pizza getPizza(String name);
}
