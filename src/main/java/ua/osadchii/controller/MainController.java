package ua.osadchii.controller;

import ua.osadchii.model.Person;
import ua.osadchii.model.PersonsOrder;
import ua.osadchii.model.Toy;
import ua.osadchii.service.PersonService;
import ua.osadchii.service.PersonsOrderService;
import ua.osadchii.service.ToyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

@Controller
public class MainController {


    public MainController() {
        System.out.println("MainController()");
    }

    @Autowired
    private PersonService personService;
    @Autowired
    private ToyService toyService;
    @Autowired
    private PersonsOrderService personsOrderService;

    @RequestMapping(value = "/")
    public String listPerson(Model model) throws IOException {
        model.addAttribute("orders", personsOrderService.getAllPersonsOrder());
        return "orders";
    }



    @RequestMapping(value = "/newToy", method = RequestMethod.GET)
    public ModelAndView newToy(ModelAndView model) {
        Toy toy = new Toy();
        model.addObject("toy", toy);
        model.setViewName("ToyForm");
        return model;
    }

    @RequestMapping(value = "/newPersonsOrder", method = RequestMethod.GET)
    public ModelAndView newPersonsOrder(ModelAndView model) {
        PersonsOrder personsOrder = new PersonsOrder();
        Person person = new Person();
        model.addObject("toys", toyService.getAllToys());
        model.addObject("personsOrder", personsOrder);
        model.addObject("person",person);
        model.setViewName("PersonsOrderForm");
        return model;
    }

    @RequestMapping(value = "/saveToy", method = RequestMethod.POST)
    public ModelAndView saveToy(@ModelAttribute Toy toy) {
        if (toy.getId() == 0) { // if person id is 0 then creating the
            // person other updating the person
            toyService.addToy(toy);
        } else {
           toyService.updateToy(toy);
        }
        return new ModelAndView("redirect:/");
    }
    @RequestMapping(value = "/savePersonsOrder", method = RequestMethod.GET)
    public ModelAndView savePersonsOrder(@ModelAttribute Person person, HttpServletRequest request) {

        personService.addPerson(person);
        PersonsOrder personsOrder = new PersonsOrder();
        personsOrder.setPerson(personService.getPerson(person.getId()));
        String selectedStudentIds[] = request.getParameterValues("selected");
        Set<Toy> toys = new HashSet<>();
        if (selectedStudentIds != null && selectedStudentIds.length != 0) {
            System.out.println("You have selected: ");
            for (int i = 0; i < selectedStudentIds.length; i++) {
                System.out.println(selectedStudentIds[i]);
            }
        }

        for (String  toyName:selectedStudentIds){
            toys.add(toyService.getToy(toyName));
        }
        personsOrder.setToys(toys);
        Double total = 0.0;
        for (String  toyName:selectedStudentIds){
           total = total + (toyService.getToy(toyName).getPrice());
        }
        personsOrder.setTotal(total);


        if (selectedStudentIds != null && selectedStudentIds.length != 0) {
            System.out.println("You have selected: ");
            for (int i = 0; i < selectedStudentIds.length; i++) {
                System.out.println(selectedStudentIds[i]);
            }
        }
        personsOrderService.addPersonsOrder(personsOrder);
        return new ModelAndView("redirect:/");
    }

    @RequestMapping(value = "/deleteOrder", method = RequestMethod.GET)
    public ModelAndView deleteOrder(HttpServletRequest request) {
        int orderId = Integer.parseInt(request.getParameter("id"));
        personsOrderService.deletePersonsOrder(orderId);
        int personId = Integer.parseInt(request.getParameter("id2"));
        personService.deletePerson(personId);
        return new ModelAndView("redirect:/");
    }
}