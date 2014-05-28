package com.spd.testing.domain;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Vlad on 05.03.14.
 */
@Entity
@Table(name = "Subject")
public class Subject {
    @Id
    @Column(name = "ID")
    @GeneratedValue
    private Integer id;

    @Column(name = "name")
    private String name;

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
