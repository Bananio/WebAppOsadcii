package ua.osadchii.controller;

import ua.osadchii.model.Person;
import ua.osadchii.model.PersonsOrder;
import ua.osadchii.model.Pizza;
import ua.osadchii.service.PersonService;
import ua.osadchii.service.PersonsOrderService;
import ua.osadchii.service.PizzaService;
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
    private PizzaService pizzaService;
    @Autowired
    private PersonsOrderService personsOrderService;

    @RequestMapping(value = "/")
    public String listPerson(Model model) throws IOException {
        model.addAttribute("orders", personsOrderService.getAllPersonsOrder());
        return "orders";
    }



    @RequestMapping(value = "/newPizza", method = RequestMethod.GET)
    public ModelAndView newPizza(ModelAndView model) {
        Pizza pizza = new Pizza();
        model.addObject("pizza", pizza);
        model.setViewName("PizzaForm");
        return model;
    }

    @RequestMapping(value = "/newPersonsOrder", method = RequestMethod.GET)
    public ModelAndView newPersonsOrder(ModelAndView model) {
        PersonsOrder personsOrder = new PersonsOrder();
        Person person = new Person();
        model.addObject("pizzas", pizzaService.getAllPizzas());
        model.addObject("personsOrder", personsOrder);
        model.addObject("person",person);
        model.setViewName("PersonsOrderForm");
        return model;
    }

    @RequestMapping(value = "/savePizza", method = RequestMethod.POST)
    public ModelAndView savePizza(@ModelAttribute Pizza pizza) {
        if (pizza.getId() == 0) { // if person id is 0 then creating the
            // person other updating the person
            pizzaService.addPizza(pizza);
        } else {
           pizzaService.updatePizza(pizza);
        }
        return new ModelAndView("redirect:/");
    }
    @RequestMapping(value = "/savePersonsOrder", method = RequestMethod.GET)
    public ModelAndView savePersonsOrder(@ModelAttribute Person person, HttpServletRequest request) {

        personService.addPerson(person);
        PersonsOrder personsOrder = new PersonsOrder();
        personsOrder.setPerson(personService.getPerson(person.getId()));
        String selectedStudentIds[] = request.getParameterValues("selected");
        Set<Pizza> pizzas = new HashSet<>();
        if (selectedStudentIds != null && selectedStudentIds.length != 0) {
            System.out.println("You have selected: ");
            for (int i = 0; i < selectedStudentIds.length; i++) {
                System.out.println(selectedStudentIds[i]);
            }
        }

        for (String  pizzaName:selectedStudentIds){
            pizzas.add(pizzaService.getPizza(pizzaName));
        }
        personsOrder.setPizzas(pizzas);
        Double total = 0.0;
        for (String  pizzaName:selectedStudentIds){
           total = total + (pizzaService.getPizza(pizzaName).getPrice());
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