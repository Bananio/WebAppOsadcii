package ua.osadchii.dao;

import ua.osadchii.model.PersonsOrder;

import java.util.List;

public interface PersonsOrderDAO {

    public void addPersonsOrder(PersonsOrder personsOrder);

    public List<PersonsOrder> getAllPersonsOrder();

    public void deletePersonsOrder(Integer personOrderId);

    public PersonsOrder updatePersonsOrder(PersonsOrder personsOrder);

    public PersonsOrder getPersonsOrder(int personsOrderid);
}
