package com.server.backend.models;

import jakarta.persistence.*;

@Entity
@Table(name = "stand")
public class StandModel {

    @Column(nullable = false)
    private String book_id;

    @Column(nullable = false)
    private String owner;

    @Column(nullable = false)
    private Integer units;

    public StandModel(String book_id, String owner, Integer units) {
        this.book_id = book_id;
        this.owner = owner;
        this.units = units;
    }

    public String getBook_id() {
        return book_id;
    }

    public void setBook_id(String book_id) {
        this.book_id = book_id;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Integer getUnits() {
        return units;
    }

    public void setUnits(Integer units) {
        this.units = units;
    }
}
