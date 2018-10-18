package ua.osadchii.service;

import ua.osadchii.dao.PersonDAO;
import ua.osadchii.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonDAO personDAO;

    @Override
    @Transactional
    public void addPerson(Person person) {
        personDAO.addPerson(person);
    }

    @Override
    @Transactional
    public List<Person> getAllPersons() {
        return personDAO.getAllPersons();
    }

    @Override
    @Transactional
    public void deletePerson(Integer personId) {
        personDAO.deletePerson(personId);
    }

    public Person getPerson(int empid) {
        return personDAO.getPerson(empid);
    }

    public Person updatePerson(Person person) {
        // TODO Auto-generated method stub
        return personDAO.updatePerson(person);
    }

    public void setPersonDAO(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

}
