package ppp.domain;

import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.util.*;

/**
 * Created by Vlad on 05.03.14.
 */
@Entity
@Proxy(lazy=false)
@Table(name = "Item")
public class Item {
    @Id
    @Column(name = "ID")
    @GeneratedValue
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "quantity")
    private Integer quantity;

    @OneToMany(mappedBy = "item")
    private List<Sales> sales;

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public List<Sales> getSales() {
        return sales;
    }

    public void setSales(List<Sales> sales) {
        this.sales = sales;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
