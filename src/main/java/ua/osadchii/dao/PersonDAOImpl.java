package ua.osadchii.dao;

import ua.osadchii.model.Person;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersonDAOImpl implements PersonDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public void addPerson(Person person) {
        sessionFactory.getCurrentSession().saveOrUpdate(person);

    }

    @SuppressWarnings("unchecked")
    public List<Person> getAllPersons() {

        return sessionFactory.getCurrentSession().createQuery("from Person")
                .list();
    }

    @Override
    public void deletePerson(Integer personId) {
        Person person = (Person) sessionFactory.getCurrentSession().load(
                Person.class, personId);
        if (null != person) {
            this.sessionFactory.getCurrentSession().delete(person);
        }

    }

    public Person getPerson(int persid) {
        return (Person) sessionFactory.getCurrentSession().get(
                Person.class, persid);
    }

    @Override
    public Person updatePerson(Person person) {
        sessionFactory.getCurrentSession().update(person);
        return person;
    }

}