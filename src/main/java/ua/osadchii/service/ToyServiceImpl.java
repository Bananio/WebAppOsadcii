package ua.osadchii.service;

import ua.osadchii.dao.ToyDAO;
import ua.osadchii.model.Toy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ToyServiceImpl implements ToyService {

    @Autowired
    private ToyDAO toyDAO;

    @Override
    @Transactional
    public void addToy(Toy toy) {
        toyDAO.addToy(toy);
    }

    @Override
    @Transactional
    public List<Toy> getAllToys() {
        return toyDAO.getAllToys();
    }

    @Override
    @Transactional
    public void deleteToy(Integer toyId) {
        toyDAO.deleteToy(toyId);
    }

    public Toy getToy(int pizid) {
        return toyDAO.getToy(pizid);
    }
    public Toy getToy(String name) {
        return toyDAO.getToy(name);
    }

    public Toy updateToy(Toy toy) {
        // TODO Auto-generated method stub
        return toyDAO.updateToy(toy);
    }

    public void setToyDAO(ToyDAO toyDAO) {
        this.toyDAO = toyDAO;
    }

}
