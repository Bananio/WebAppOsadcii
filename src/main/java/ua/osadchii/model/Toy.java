package ua.osadchii.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "toys")
public class Toy implements Serializable {
    @Id
    @Column(name = "toy_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column

    private String name;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Column

    private double price;






    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
