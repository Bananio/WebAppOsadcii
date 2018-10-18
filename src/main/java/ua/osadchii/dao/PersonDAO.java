package ua.osadchii.dao;

import ua.osadchii.model.Person;

import java.util.List;

public interface PersonDAO {

    public void addPerson(Person person);

    public List<Person> getAllPersons();

    public void deletePerson(Integer personId);

    public Person updatePerson(Person person);

    public Person getPerson(int personid);
}
