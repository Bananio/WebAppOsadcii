package ua.osadchii.service;

import ua.osadchii.model.PersonsOrder;

import java.util.List;

public interface PersonsOrderService {

    public void addPersonsOrder(PersonsOrder personsOrder);

    public List<PersonsOrder> getAllPersonsOrder();

    public void deletePersonsOrder(Integer personsOrderId);

    public PersonsOrder getPersonsOrder(int personsOrderid);

    public PersonsOrder updatePersonsOrder(PersonsOrder personsOrder);
}
