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
    @JoinTable(name = "ORDER_TOYS", joinColumns = {@JoinColumn(name = "ORDER_ID")},inverseJoinColumns = {@JoinColumn(name = "TOYS_ID")})
    private Set<Toy> toys;

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

    public Set<Toy> getToys() {
        return toys;
    }

    public void setToys(Set<Toy> toys) {
        this.toys = toys;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
