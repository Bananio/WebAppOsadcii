package ua.osadchii.dao;

import ua.osadchii.model.Toy;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ToyDAOImpl implements ToyDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public void addToy(Toy toy) {
        sessionFactory.getCurrentSession().saveOrUpdate(toy);

    }

    @SuppressWarnings("unchecked")
    public List<Toy> getAllToys() {

        return sessionFactory.getCurrentSession().createQuery("from Toy")
                .list();
    }

    @Override
    public void deleteToy(Integer toyId) {
        Toy toy = (Toy) sessionFactory.getCurrentSession().load(
                Toy.class, toyId);
        if (null != toy) {
            this.sessionFactory.getCurrentSession().delete(toy);
        }

    }

    public Toy getToy(int persid) {
        return (Toy) sessionFactory.getCurrentSession().get(
                Toy.class, persid);
    }
    public Toy getToy(String name) {
        Query query = sessionFactory.getCurrentSession().createQuery("from Toy where name=:name");
        query.setParameter("name",name);
        return (Toy) query.uniqueResult();
    }

    @Override
    public Toy updateToy(Toy toy) {
        sessionFactory.getCurrentSession().update(toy);
        return toy;
    }

}