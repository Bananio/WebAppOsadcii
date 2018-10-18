package ua.osadchii.service;

import ua.osadchii.dao.PersonsOrderDAO;
import ua.osadchii.model.PersonsOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PersonsOrderServiceImpl implements PersonsOrderService {

    @Autowired
    private PersonsOrderDAO personsOrderDAO;

    @Override
    @Transactional
    public void addPersonsOrder(PersonsOrder personsOrder) {
        personsOrderDAO.addPersonsOrder(personsOrder);
    }

    @Override
    @Transactional
    public List<PersonsOrder> getAllPersonsOrder() {
        return personsOrderDAO.getAllPersonsOrder();
    }

    @Override
    @Transactional
    public void deletePersonsOrder(Integer personsOrderId) {
        personsOrderDAO.deletePersonsOrder(personsOrderId);
    }

    public PersonsOrder getPersonsOrder(int personsOrderid) {
        return personsOrderDAO.getPersonsOrder(personsOrderid);
    }

    public PersonsOrder updatePersonsOrder(PersonsOrder personsOrder) {
        // TODO Auto-generated method stub
        return personsOrderDAO.updatePersonsOrder(personsOrder);
    }

    public void setPersonsOrderDAO(PersonsOrderDAO personsOrderDAO) {
        this.personsOrderDAO = personsOrderDAO;
    }

}
