package com.server.backend.models;

import jakarta.persistence.*;

@Entity
@Table(name = "stand")
public class StandModel {

    @Id
    @Column(nullable = false)
    private String id;

    @ManyToOne
    @JoinColumn(name = "book_id", referencedColumnName = "id", nullable = false)
    private BookModel book_id;

    @ManyToOne
    @JoinColumn(name = "owner", referencedColumnName = "dni", nullable = false)
    private UserModel owner;

    @Column(nullable = false)
    private Integer units;

    public StandModel() {}
    public StandModel(String id, BookModel book_id, UserModel owner, Integer units) {
        this.id = id;
        this.book_id = book_id;
        this.owner = owner;
        this.units = units;
    }

    public BookModel getBook_id() {
        return book_id;
    }

    public void setBook_id(BookModel book_id) {
        this.book_id = book_id;
    }

    public UserModel getOwner() {
        return owner;
    }

    public void setOwner(UserModel owner) {
        this.owner = owner;
    }

    public Integer getUnits() {
        return units;
    }

    public void setUnits(Integer units) {
        this.units = units;
    }
}
