package ua.osadchii.service;

import ua.osadchii.dao.PizzaDAO;
import ua.osadchii.model.Pizza;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PizzaServiceImpl implements PizzaService {

    @Autowired
    private PizzaDAO pizzaDAO;

    @Override
    @Transactional
    public void addPizza(Pizza pizza) {
        pizzaDAO.addPizza(pizza);
    }

    @Override
    @Transactional
    public List<Pizza> getAllPizzas() {
        return pizzaDAO.getAllPizzas();
    }

    @Override
    @Transactional
    public void deletePizza(Integer pizzaId) {
        pizzaDAO.deletePizza(pizzaId);
    }

    public Pizza getPizza(int pizid) {
        return pizzaDAO.getPizza(pizid);
    }
    public Pizza getPizza(String name) {
        return pizzaDAO.getPizza(name);
    }

    public Pizza updatePizza(Pizza pizza) {
        // TODO Auto-generated method stub
        return pizzaDAO.updatePizza(pizza);
    }

    public void setPizzaDAO(PizzaDAO pizzaDAO) {
        this.pizzaDAO = pizzaDAO;
    }

}
