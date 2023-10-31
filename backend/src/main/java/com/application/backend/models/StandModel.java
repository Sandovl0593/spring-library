package com.application.backend.models;

import jakarta.persistence.*;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "stand", schema = "sp_library")
public class StandModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "book_id", referencedColumnName = "code", nullable = false)
    private BookModel book_id;

    @ManyToOne
    @JoinColumn(name = "owner", referencedColumnName = "dni", nullable = false)
    private UserModel owner;

    @Column(nullable = false)
    private Integer units;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
