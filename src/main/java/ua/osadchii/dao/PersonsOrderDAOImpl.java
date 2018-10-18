package ua.osadchii.dao;

import ua.osadchii.model.PersonsOrder;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersonsOrderDAOImpl implements PersonsOrderDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public void addPersonsOrder(PersonsOrder personsOrder) {
        sessionFactory.getCurrentSession().saveOrUpdate(personsOrder);

    }

    @SuppressWarnings("unchecked")
    public List<PersonsOrder> getAllPersonsOrder() {

        return sessionFactory.getCurrentSession().createQuery("from PersonsOrder")
                .list();
    }

    @Override
    public void deletePersonsOrder(Integer personsOrderId) {
        PersonsOrder personsOrder = (PersonsOrder) sessionFactory.getCurrentSession().load(
                PersonsOrder.class, personsOrderId);
        if (null != personsOrder) {
            this.sessionFactory.getCurrentSession().delete(personsOrder);
        }

    }

    public PersonsOrder getPersonsOrder(int personsOrderid) {
        return (PersonsOrder) sessionFactory.getCurrentSession().get(
                PersonsOrder.class, personsOrderid);
    }

    @Override
    public PersonsOrder updatePersonsOrder(PersonsOrder personsOrder) {
        sessionFactory.getCurrentSession().update(personsOrder);
        return personsOrder;
    }

}