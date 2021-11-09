package com.wildcodeschool.wildandwizard.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class School {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Long capacity;
    private String country;

    //One School can have many Wizards
    //CascadeType.ALL: combines REMOVE, REFRESH and many other operations,
    // CascadeType.REMOVE: Deletes the entity when a relationship is deleted, When I delete the School, the enrolled Wizards will be deleted as well
    // CascadeType.REFRESH: Updates the entity when a relationship is changed or deleted
    //mappedBy: it refers to the attribute "school" of the class Wizard
    @OneToMany(mappedBy = "school", cascade = CascadeType.ALL)
    private List<Wizard> wizards;

    public School() {
    }

    public School(Long id, String name, Long capacity, String country) {
        this.id = id;
        this.name = name;
        this.capacity = capacity;
        this.country = country;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCapacity() {
        return capacity;
    }

    public void setCapacity(Long capacity) {
        this.capacity = capacity;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<Wizard> getWizards() {
        return wizards;
    }

    public void setWizards(List<Wizard> wizards) {
        this.wizards = wizards;
    }
}