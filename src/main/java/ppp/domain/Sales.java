package ppp.domain;

import javax.persistence.*;

/**
 * Created by Vlad on 28.05.14.
 */
@Entity
@Table(name = "sales")
public class Sales {
    @Id
    @Column(name = "ID")
    @GeneratedValue
    private Integer id;

    @Column(name = "period")
    private String period;

    @Column(name = "quantity")
    private Double quantity;

    @ManyToOne
    @JoinColumn(name="item_id")
    private Item item;




    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

}
