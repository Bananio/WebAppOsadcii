package ua.osadchii.dao;

import ua.osadchii.model.Pizza;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PizzaDAOImpl implements PizzaDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public void addPizza(Pizza pizza) {
        sessionFactory.getCurrentSession().saveOrUpdate(pizza);

    }

    @SuppressWarnings("unchecked")
    public List<Pizza> getAllPizzas() {

        return sessionFactory.getCurrentSession().createQuery("from Pizza")
                .list();
    }

    @Override
    public void deletePizza(Integer pizzaId) {
        Pizza pizza = (Pizza) sessionFactory.getCurrentSession().load(
                Pizza.class, pizzaId);
        if (null != pizza) {
            this.sessionFactory.getCurrentSession().delete(pizza);
        }

    }

    public Pizza getPizza(int persid) {
        return (Pizza) sessionFactory.getCurrentSession().get(
                Pizza.class, persid);
    }
    public Pizza getPizza(String name) {
        Query query = sessionFactory.getCurrentSession().createQuery("from Pizza where name=:name");
        query.setParameter("name",name);
        return (Pizza) query.uniqueResult();
    }

    @Override
    public Pizza updatePizza(Pizza pizza) {
        sessionFactory.getCurrentSession().update(pizza);
        return pizza;
    }

}