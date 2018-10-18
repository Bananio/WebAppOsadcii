package ua.osadchii.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class PersonsOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int orderId;

    private Double total;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE} , fetch = FetchType.EAGER)
    @JoinTable(name = "ORDER_PIZZAS", joinColumns = {@JoinColumn(name = "ORDER_ID")},inverseJoinColumns = {@JoinColumn(name = "PIZZAS_ID")})
    private Set<Pizza> pizzas;

    @OneToOne
    private Person person;

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Set<Pizza> getPizzas() {
        return pizzas;
    }

    public void setPizzas(Set<Pizza> pizzas) {
        this.pizzas = pizzas;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
